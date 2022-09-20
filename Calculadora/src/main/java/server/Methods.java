package server;

import java.util.List;

public class Methods {

    DaoHistory daoHistory = new DaoHistory();

    public double addition(double num1, double num2){
        double result = num1+num2;
        daoHistory.saveOperation(num1, num2, result , "Suma");
        return result;
    }

    public double sustraction(double num1, double num2){
        double result = num1-num2;
        daoHistory.saveOperation(num1, num2, result , "Resta");
        return result;
    }

    public double multiplication(double num1, double num2){
        double result = num1*num2;
        daoHistory.saveOperation(num1, num2, result , "Multplicación");
        return result;
    }

    public double division(double num1, double num2){
        double result = num1/num2;
        daoHistory.saveOperation(num1, num2, result , "División");
        return result;
    }

    public double exponet(double base, double exponent){
        double result =Math.pow(base, exponent);
        daoHistory.saveOperation(base, exponent, result , "Elevado");
        return result;

    }

    public double  root(double num1){
        double result =Math.sqrt(num1);
        daoHistory.saveOperation(num1,0D, result , "Raíz cuadrada");
        return result;
    }

    public String history(double num1 ){
        String text="";
        List<String> list = daoHistory.listOperations();
        for (String s:list) {
            text += s + "\n";
        }
        return text;
    }
}
