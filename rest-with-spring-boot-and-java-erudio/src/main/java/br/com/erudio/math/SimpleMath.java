package br.com.erudio.math;

public class SimpleMath {

	//soma
	//@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(Double numberOne,Double numberTwo) {
		return numberOne + numberTwo;
	}

	//subtração
	public Double subtraction(Double numberOne,Double numberTwo){
		return numberOne - numberTwo;
	}

	// multiplicação
	public Double multiplication(Double numberOne,Double numberTwo){
		return numberOne * numberTwo;
	}

	//divisão

	public Double division(Double numberOne, Double numberTwo){
		return numberOne / numberTwo;
	}

	//media
	public Double mean(Double numberOne, Double numberTwo){
		return (numberOne + numberTwo) / 2;
	}

	//media
	public Double squareRoot(Double number){
		return Math.sqrt(number);
	}

}
