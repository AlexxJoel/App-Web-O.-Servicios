package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientRCP {


    static Scanner in = new Scanner(System.in); //Does not lose its value throughout the execution

    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        List<Object> data = new ArrayList<>();
        in.useDelimiter("\n");

        //---------------------------------Variables---------------
        int opc = 0;
        String name, firtSurname, secondSurname, sex, placeBorn, dateBorn, curp="A", text = "";

        //------------------------------------------------------

        System.out.println("----------------Bienvenido-------------------------------");
        do {
            System.out.println("¿Qué acción deseéas realizar?");
            System.out.println("1. Creación de CURP, 2. Buscar un CURP 3.Salir");
            System.out.print("Seleccione un numero  -> ");
            opc = in.nextInt();

            if (opc == 1) {
                System.out.println("---------------------------------------------Creación-------------------------------");
                System.out.println("Ingrese su nombre");

                name = in.next().toUpperCase();
                data.add(name); // ADD THE ARGUMENTS TO SENT FUNCTION
                String[] firstName = name.split(" "); //divide to space
                System.out.println(firstName[0]);
                System.out.println(firstName[0].charAt(0)); //First name´s letter

                System.out.println("Ingrese su primer apellido");
                firtSurname = in.next();
                data.add(firtSurname);// ADD THE ARGUMENTS TO SENT FUNCTION

                System.out.println("Ingrese su segundo apellido ");
                secondSurname = in.next();
                data.add(secondSurname);// ADD THE ARGUMENTS TO SENT FUNCTION

                System.out.println("Ingrese su sexo  Mujer/Hombre ");
                sex = in.next().toUpperCase();
                sex = String.valueOf(sex.charAt(0));
                data.add(sex);// ADD THE ARGUMENTS TO SENT FUNCTION

                System.out.println(sex);

                System.out.println("Ingrese su estado de nacimiento");
                placeBorn = in.next();
                data.add(placeBorn.toUpperCase());// ADD THE ARGUMENTS TO SENT FUNCTION
                String letter = consonat(placeBorn);
                System.out.println(letter);

                System.out.println("---------Respetando el guión medio----------------");
                System.out.println("Ingrese fecha de nacimento en esta estructura YYYY-MM-DD");
                dateBorn = in.next();
                data.add(dateBorn);
                System.out.println(dateCurp(dateBorn));


                data.add(curp);

                for (Object da: data) {
                    System.out.println(da);
                }


                Boolean response = (Boolean) client.execute("Methods.savePerson", data); //SENT TO BUILD UP THE REGISTRE
                text = response?"¡Registro exitoso!":"!!UPSS ocurrió algun problema ";
                System.out.println(text);

            } else if (opc == 2) {
                data.add(0);
                System.out.println("Ingrese CURP a buscar ");
                curp = in.next();

                text = (String) client.execute("Methods.searchPerson", data); //SENT TO SEE A SPECIFIC CURP/INFO PERSON
                System.out.println("Resultado ----> " + text);

            } else if (opc == 3) { System.err.println("!!Adiós");
            }else  System.err.println("!!UPSS Opción no valida");

        }while (opc!=3);

    }

    //to find the consonant letter of states
    public static  String consonat(String state){
        state = state.toUpperCase();
        char[] statesL = state.toCharArray();
        String combination="";
        for (char letter: statesL ) {
            if (combination.length() < 2){
                if (!(letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U' )   ){
                    combination += letter;
                }
            }

        }

        return combination.trim();
    }

    public static String dateCurp(String date){
        if(date.contains("-")){
            String[] part = date.split("-");
            return part[0].substring(2,4) + part[1] + part[2];
        }else{
            return "";
        }
    }


    
/*


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
        */

}



