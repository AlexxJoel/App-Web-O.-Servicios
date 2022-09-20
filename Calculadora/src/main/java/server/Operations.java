package server;

import java.util.List;

public class Operations {

    DAO daoHistory = new DAO();

    public double addition(double firstNumber, double secondNUmber){
        double res = firstNumber+secondNUmber;
        daoHistory.saveOperation(firstNumber, secondNUmber, res , "Suma");
        return res;
    }

    public double sustraction(double firstNumber, double secondNUmber){
        double res = firstNumber-secondNUmber;
        daoHistory.saveOperation(firstNumber, secondNUmber, res , "Resta");
        return res;
    }

    public double multiplication(double firstNumber, double secondNUmber){
        double result = firstNumber*secondNUmber;
        daoHistory.saveOperation(firstNumber, secondNUmber, result , "Multplicación");
        return result;
    }

    public double division(double firstNumber, double secondNUmber){
        double result = firstNumber/secondNUmber;
        daoHistory.saveOperation(firstNumber, secondNUmber, result , "División");
        return result;
    }

    public double exponet(double firstNumber, double secondNUmber){
        double result =Math.pow(firstNumber, secondNUmber);
        daoHistory.saveOperation(firstNumber, secondNUmber, result , "Elevado");
        return result;

    }

    public double  root(double firstNumber){
        double result =Math.sqrt(firstNumber);
        daoHistory.saveOperation(firstNumber,0.0, result , "Raíz cuadrada");
        return result;
    }

    public String history(double num1 ){
        String text="";
        List<String> list = daoHistory.listOperations();
        for (String operations:list) {
            text += operations + "\n";
        }
        return text;
    }
}
