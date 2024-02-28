package br.com.erudio.integrationtests.controller.withxml;

import br.com.erudio.configs.TestConfigs;
import br.com.erudio.integrationtests.testcontainers.AbstractIntegrationTest;
import br.com.erudio.integrationtests.vo.AccountCredentialsVO;
import br.com.erudio.integrationtests.vo.TokenVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuthControllerXmlTest extends AbstractIntegrationTest {

    private static TokenVO tokenVO;

    @Test
    @Order(1)
    public void testSignin() throws JsonMappingException, JsonProcessingException {

        AccountCredentialsVO user = new AccountCredentialsVO("leandro", "admin123");

        var tokenVO = given().basePath("/auth/signin")
                .port(TestConfigs.API_PORT)
                .contentType(TestConfigs.CONTENT_TYPE_XML)
                .body(user).when().post()
                .then().statusCode(200)
                .extract().body().as(TokenVO.class);

        assertNotNull(tokenVO.getAccessToken());
        assertNotNull(tokenVO.getRefreshToken());

    }

    @Test
    @Order(2)
    public void testRefresh() throws JsonMappingException, JsonProcessingException {

        AccountCredentialsVO user = new AccountCredentialsVO("leandro", "admin123");

        var newTokenVO = given().basePath("/auth/refresh")
                .port(TestConfigs.API_PORT)
                .contentType(TestConfigs.CONTENT_TYPE_XML)
                .pathParams("username", tokenVO.getUsername())
                .header(TestConfigs.HEADER_PARAM_AUTHORIZATION, "Bearer " + tokenVO.getRefreshToken())
                .when().put("{username}")
                .then().statusCode(200)
                .extract().body().as(TokenVO.class);

        assertNotNull(newTokenVO.getAccessToken());
        assertNotNull(newTokenVO.getRefreshToken());

    }

}
