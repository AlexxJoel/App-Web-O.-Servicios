package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class ClientRCP {


    static Scanner in = new Scanner(System.in); //Does not lose its value throughout the execution

    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        Object[]  data = new Object[2];
        Object[] root = new Object[1]; //Initialize array just only number
        root[0] = 3D;

        String option = "", firstNumber = "", secondNumber= "", text="";
        Double response = 0D ;

        do {//main menu
            System.out.println("1.Suma, 2.Resta, 3.Multiplicación");  //Option
            System.out.println("4.Division, 5.Exponente, 6.Raiz");
            System.out.println("7.Consultar historial");
            System.out.println("8.Salir");
            do { //Check the variable option if it's a number
                System.out.print("Ingresa opción: ");
                option= in.next();
                if (isNumber(option) ){  //Check how many number we'll need
                    if (Integer.parseInt(option)<8 && Integer.parseInt(option)>0){

                        if ( !(Integer.parseInt(option) == 7) ) { //in the case 7 don't need any number

                            firstNumber = firsNumber();
                            root[0] = Double.parseDouble(firstNumber); //add to array to sent a server


                            if (!(Integer.parseInt(option) == 6)) { //in the case 6 just need a number
                                secondNumber = secondNumber(option);
                                data[0] = root[0];
                                data[1] = Double.parseDouble(secondNumber); //add to array to sent a server

                            }
                        }

                    }
                }else {
                    System.out.println("-----\n Dato incorrecto \n----------");
                }
            }while (!isNumber(option));

            if (isNumber(option)) {
                switch (Integer.parseInt(option)){
                    case 1:
                        response = (Double) client.execute("Methods.addition", data);
                        text = "suma";
                        break;
                    case 2:
                        response = (Double) client.execute("Methods.sustraction", data);
                        text = "resta";
                        break;
                    case 3:
                        response = (Double) client.execute("Methods.multiplication", data);
                        text = "multiplicación";
                        break;
                    case 4:
                        if (secondNumber.equals("0")){
                            System.out.println("No se puede dividir entre 0");
                            secondNumber = secondNumber(option);
                            data[1]= Double.parseDouble(secondNumber) ; //add to array to sent a server

                        }
                        response = (Double) client.execute("Methods.division", data);
                        text = "división";
                        break;
                    case 5:
                        response = (Double) client.execute("Methods.exponet", data);
                        text = "exponente";
                        break;
                    case 6:
                        if (firstNumber.contains("-")){
                            System.out.println("No se puede numeros negativos en raices");
                            firstNumber = firsNumber();
                            root[0]= Double.parseDouble(firstNumber) ; //add to array to sent a server

                        }
                        response = (Double) client.execute("Methods.root", root);
                        text = "raiz";
                        break;
                    case 7:
                        String h = (String) client.execute("Methods.history" , root);
                        System.out.println(h);
                        break;

                    case 8:
                        System.out.println("------------\n Adios \n---------------");
                        break;

                    default:
                        System.out.println("No existe esa opción");
                }

                if(Integer.parseInt(option)<7 && Integer.parseInt(option)>0)
                    System.out.println("-------- \n El resultado de la " + text + " es : " +response +"\n---------");
            }else {
                System.out.println("La opcion es incorrecta Intente nuevemente");
            }
        }while (!option.equals("8") );

    }

    public static boolean isNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }


    //validar que sea double
    public static boolean isDouble(String number) {
        try {
            Double.parseDouble(number);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public  static String secondNumber(String option){
        String secondNumber="";
            do {
                System.out.println("Ingrese el segundo número");
                secondNumber = in.next();
                if (!isDouble(secondNumber))
                    System.out.println("-----\n Número invalido \n----------");
            }while (!isDouble(secondNumber));

        return secondNumber;
    }

    public  static  String firsNumber(){
        String firstNumber;
        do {
            System.out.println("Ingrese un número");
            firstNumber = in.next();
            if (!isDouble(firstNumber))
                System.out.println("-----\n Número invalido \n----------");

        }while (!isDouble(firstNumber));

        return firstNumber;
    }
}
