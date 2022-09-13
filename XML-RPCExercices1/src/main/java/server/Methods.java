package server;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Methods {

    //HERRERA HERNANDEZ JOEL ALEJANDRO 4A

    public double imc(double weight,double height){
        double imc = 0D;
        imc = weight/(height*height);
        return imc;
    }


    public String product(double num1,double num2,double num3){

        double product, adition , average;
        adition = (num1 + num2 + num3);
        product = num1*num2*num3;
        average = (adition/3);

        return "Hola, producto es: "+ product + " , la suma es:  " + adition + " y el promedio es: " + average;
    }


    public String addition(double num1, double num2){
        double min,max,addition = 0;
        min = Math.min(num1, num2);
        max = Math.max(num1, num2);

        for (double i = min+1; i < max; i++) {
            addition+=i;
        }
        return "Hola, La suma es entre : " +min+ " y " +max+ " es :" + addition;
    }




    public String order(int a,int b,int c,int d, int e) {

        int [] number ={a,b,c,d,e};

        Arrays.sort(number);

       String nums="";
        for (int i = 0; i < number.length ; i++) {
            nums += "\n" + number[i];
        }

        return nums;
    }







}
