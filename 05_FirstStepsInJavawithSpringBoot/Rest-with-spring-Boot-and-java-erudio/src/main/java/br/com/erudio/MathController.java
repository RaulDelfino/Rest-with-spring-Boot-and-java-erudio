package br.com.erudio;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.Services.MathOperators;
import br.com.erudio.Services.ValidateNumber;

@RestController
public class MathController {

    MathOperators math = new MathOperators();
    ValidateNumber validateNumber = new ValidateNumber();

    @GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(
        @PathVariable(value ="numberOne") String numberOne,
        @PathVariable(value ="numberTwo") String numberTwo) throws Exception
        {
            if(!validateNumber.isNumeric(numberOne) || !validateNumber.isNumeric(numberTwo)){
                throw new UnsupportedOperationException("Please set a numeric value");
            }
            return math.mathSum(validateNumber.convert(numberOne), validateNumber.convert(numberTwo));
        }

    @GetMapping("/sub/{numberOne}/{numberTwo}")
    public Double subtract(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo) throws Exception
        {
            if(!validateNumber.isNumeric(numberOne) || !validateNumber.isNumeric(numberTwo)){
                throw new UnsupportedOperationException("Please set a numeric value");
            }
            return validateNumber.convert(numberOne) - validateNumber.convert(numberTwo);
        }
    
    @GetMapping("/mult/{numberOne}/{numberTwo}")
    public Double mult(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo) throws Exception
        {
            if(!validateNumber.isNumeric(numberOne) || !validateNumber.isNumeric(numberTwo)){
                throw new UnsupportedOperationException("Please set a numeric value");
            }
            return validateNumber.convert(numberOne) * validateNumber.convert(numberTwo);
        }    
    
    @GetMapping("/div/{numberOne}/{numberTwo}")
    public Double division(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo) throws Exception
        {
            if(!validateNumber.isNumeric(numberOne) || !validateNumber.isNumeric(numberTwo)){
                throw new UnsupportedOperationException("Please set a numeric value");
            }
            return validateNumber.convert(numberOne) / validateNumber.convert(numberTwo);
        }
    
    @GetMapping("average/{numberOne}/{numberTwo}")
    public Double average(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo) throws Exception
        {
            if(!validateNumber.isNumeric(numberOne) || !validateNumber.isNumeric(numberTwo)){
                throw new UnsupportedOperationException("Please set a numeric value");
            }
            return (validateNumber.convert(numberOne) + validateNumber.convert(numberTwo)) / 2;
        }
    
    @GetMapping("square/{numberOne}")
    public Double square(
        @PathVariable(value = "numberOne") String numberOne) throws Exception
        {
            if(!validateNumber.isNumeric(numberOne)){
                throw new UnsupportedOperationException("Please set a numeric value");
            }
            return Math.sqrt(validateNumber.convert(numberOne));
        }
    


}
