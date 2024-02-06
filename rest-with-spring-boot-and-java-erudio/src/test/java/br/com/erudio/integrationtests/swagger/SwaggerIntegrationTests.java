package br.com.erudio.integrationtests.swagger;

import static io.restassured.RestAssured.given;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.erudio.configs.TestConfig;
import br.com.erudio.integrationtests.testcontainers.AbstractIntegrationTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SwaggerIntegrationTests extends AbstractIntegrationTest{

	@Test
	public void shouldDisplaySwaggerUiPage() {
		var content = given().basePath("/swagger-ui/index.html").port(TestConfig.SERVER_PORT).when().get().then().statusCode(200).extract().body().asString();
		
		Assertions.assertTrue(content.contains("Swagger UI"));
		
		
	}

}
