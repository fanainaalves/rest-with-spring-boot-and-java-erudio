package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {

	private final AtomicLong counter = new AtomicLong();
	
	//soma
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo)
		throws Exception{
			if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
				throw new UnsupportedMathOperationException("Por favor insira um valor numérico!");
			}
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}
	
	//subtração
	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double subtraction(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo)
					throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor insira um valor numérico!");
		}
		return convertToDouble(numberOne) - convertToDouble(numberTwo);
	}
	
	// multiplicação
	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplication(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo)
					throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor insira um valor numérico!");
		}
		return convertToDouble(numberOne) * convertToDouble(numberTwo);
	}
	
	//divisão
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double division(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo)
					throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor insira um valor numérico!");
		}
		return convertToDouble(numberOne) / convertToDouble(numberTwo);
	}
	
	//media
	@RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mean(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo)
					throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor insira um valor numérico!");
		}
		return convertToDouble(numberOne) + convertToDouble(numberTwo) / 2;
	}
	
	//raiz quadrada
	@RequestMapping(value = "/squareRoot/{number}", method = RequestMethod.GET)
	public Double squareRoot(@PathVariable(value = "number") String number) throws Exception{
		if(!isNumeric(number)) {
			throw new UnsupportedMathOperationException("Por favor insira um valor numérico!");
		}
		return Math.sqrt(convertToDouble(number));
	}
	
	private Double convertToDouble(String strNumber) {
		if(strNumber == null) return 0D;
		String number = strNumber.replaceAll(",", ".");
		if(isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
