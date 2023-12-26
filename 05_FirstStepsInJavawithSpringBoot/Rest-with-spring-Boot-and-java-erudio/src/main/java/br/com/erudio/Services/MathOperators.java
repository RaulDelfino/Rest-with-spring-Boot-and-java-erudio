package br.com.erudio.Services;


public class MathOperators{
    
    

    public Double mathSum(Double a, Double b){
        return a + b;
    }
    public Double mathSub(Double a, Double b){
        return a - b;
    }
    public Double mathMult(Double a, Double b){
        return a * b;
    }
    public Double mathDiv(Double a, Double b){
        return a / b;
    } 
    public Double mathAverage(Double a, Double b){
        return (a + b) / 2;
    }
    public Double mathSquare(Double a){
        return Math.sqrt(a);
    }

}