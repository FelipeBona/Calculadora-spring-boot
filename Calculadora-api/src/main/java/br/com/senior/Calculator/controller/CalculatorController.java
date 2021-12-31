package br.com.senior.Calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.senior.Calculator.service.CalculatorService;

@RestController
@RequestMapping("/Calculator")
public class CalculatorController {
  
	@Autowired
	private CalculatorService calculatorService;
    
	@GetMapping("/add")
	public Float add(@RequestParam(required = false) Float num1, @RequestParam(required = false) Float num2,
			@RequestParam(required = false) String numbers) {

		if (num1 == null || num2 == null) {
         
			return calculatorService.addLista(numbers);

		} else {
			return calculatorService.add(num1, num2);
		}

	}     
	

	@GetMapping("/sub")
	public float sub(@RequestParam(required = false) Float num1, @RequestParam(required = false) Float num2,
			@RequestParam(required = false) String numbers) {

		if (num1 == null || num2 == null) {

			return calculatorService.subLista(numbers);

		} else {
			return calculatorService.sub(num1, num2);
		}

	}

	@GetMapping("/div")
	public ResponseEntity<Float> div(@RequestParam(required = false) Float num1,
			@RequestParam(required = false) Float num2, @RequestParam(required = false) String numbers) {

		if (num1 == null || num2 == null || num1 == 0 || num2 == 0 || numbers.contains("0")) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		} else {

			return new ResponseEntity<>(calculatorService.divLista(numbers), HttpStatus.OK);
		}
		
	}

	@GetMapping("/mult")
	public float mult(@RequestParam(required = false) Float num1, @RequestParam(required = false) Float num2,
			@RequestParam(required = false) String numbers) {

		if (num1 == null || num2 == null) {

			return calculatorService.multLista(numbers);
         
		} else {
			return calculatorService.mult(num1, num2);
		}
	}

}
