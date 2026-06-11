package br.com.erudio.controllers;

import br.com.erudio.exception.UnsupportedMathOperation;
import br.com.erudio.utils.MathUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

import static br.com.erudio.utils.MathConverterUtils.convertNumber;
import static br.com.erudio.utils.MathConverterUtils.isNumeric;

@RestController
@RequestMapping("/math")
public class MathController {

    private MathUtils mathUtils = new MathUtils();

    @RequestMapping("/addition/{numberOne}/{numberTwo}")
    public double addition(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        if (isNumeric(numberOne) | isNumeric(numberTwo)) throw new UnsupportedMathOperation("Please set a numeric value");
        return mathUtils.sum(convertNumber(numberOne), convertNumber(numberTwo));
    }

    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        if (isNumeric(numberOne) | isNumeric(numberTwo)) throw new UnsupportedMathOperation("Please set a numeric value");
        return mathUtils.subtraction(convertNumber(numberOne), convertNumber(numberTwo));
    }

    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        if (isNumeric(numberOne) | isNumeric(numberTwo)) throw new UnsupportedMathOperation("Please set a numeric value");
        return mathUtils.division(convertNumber(numberOne), convertNumber(numberTwo));
    }

    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        if (isNumeric(numberOne) | isNumeric(numberTwo)) throw new UnsupportedMathOperation("Please set a numeric value");
        return mathUtils.multiplication(convertNumber(numberOne), convertNumber(numberTwo));
    }

    @RequestMapping("/squareroot/{number}")
    public double squareRoot(@PathVariable("number") String strNumber) {
        if (isNumeric(strNumber)) throw new UnsupportedMathOperation("Please set a numeric value");
        return mathUtils.squareRoot(convertNumber(strNumber));
    }
}
