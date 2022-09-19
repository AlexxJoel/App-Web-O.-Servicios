package server;

public class Methods {

    public double addition(double num1, double num2){
        return num1+num2;
    }

    public double sustraction(double num1, double num2){
        return num1-num2;
    }

    public double multiplication(double num1, double num2){
        return num1*num2;
    }

    public double division(double num1, double num2){
        return num1/num2;//No dividir entre scero
    }

    public double exponet(double base, double exponent){
        return Math.pow(base, exponent);
    }

    public double  root(double num1){
        return Math.sqrt(num1); //NO raiz economica
    }

    public String history(){
                return "";
    }
}
