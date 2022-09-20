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


    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);

        List<Object> data = new ArrayList<>();
        data.add(0);
        data.add(0);

        String option = "", firstNumber = "", secondNumber= "", text="";
        Double response ;

        do {
            System.out.println("1.Suma");
            System.out.println("2.Resta");
            System.out.println("3.Multiplicación");
            System.out.println("4.Division");
            System.out.println("5.Exponente");
            System.out.println("6.Raiz");
            System.out.println("7.Consultar historial");
            System.out.println("8.Salir");
            System.out.print("Seleccione opción -> ");
            option= in.next();


            if (isNumber(option)) {
                switch (Integer.parseInt(option)){
                    case 1:
                        do {
                            System.out.println("Ingresa número");
                            firstNumber = in.next();

                            if (!isDouble(firstNumber))
                                System.out.println("Numero invalido");
                        }while (!isDouble(firstNumber));

                        do {
                            System.out.println("Ingresa el segundo número");
                            secondNumber = in.next();
                            if (!isDouble(secondNumber))
                                System.out.println("Numero invalido");
                        }while (!isDouble(secondNumber));


                        data.set(0,Double.parseDouble(firstNumber));
                        data.set(1,Double.parseDouble(secondNumber));

                        response = (Double) client.execute("Operations.addition", data);

                        System.out.println("El resultado de la suma : " +response);
                        break;
                    case 2:
                        do {
                            System.out.println("Ingrese el primer numero");
                            firstNumber = in.next();

                            if (!isDouble(firstNumber))
                                System.out.println("Numero invalido");
                        }while (!isDouble(firstNumber));

                        do {
                            System.out.println("Ingrese el segundo numero");
                            secondNumber = in.next();
                            if (!isDouble(secondNumber))
                                System.out.println("Numero invalid");
                        }while (!isDouble(secondNumber));


                        data.set(0,Double.parseDouble(firstNumber));
                        data.set(1,Double.parseDouble(secondNumber));

                        response = (Double) client.execute("Operations.sustraction", data);
                        System.out.println("El resultado de la resta : " +response);

                        break;
                    case 3:
                        do {
                            System.out.println("Ingrese el primer numero");
                            firstNumber = in.next();

                            if (!isDouble(firstNumber))
                                System.out.println("Numero invalido");
                        }while (!isDouble(firstNumber));

                        do {
                            System.out.println("Ingrese el segundo numero");
                            secondNumber = in.next();
                            if (!isDouble(secondNumber))
                                System.out.println("Numero invalido");
                        }while (!isDouble(secondNumber));


                        data.set(0,Double.parseDouble(firstNumber));
                        data.set(1,Double.parseDouble(secondNumber));

                        response = (Double) client.execute("Operations.multiplication", data);
                        System.out.println("El resultado de la multiplicación : " +response);

                        break;
                    case 4:
                        do {
                            System.out.println("Ingrese el primer numero");
                            firstNumber = in.next();

                            if (!isDouble(firstNumber))
                                System.out.println("Numero invalido");
                        }while (!isDouble(firstNumber));

                        do {
                            System.out.println("Ingrese el segundo numero");
                            secondNumber = in.next();
                            if (!isDouble(secondNumber) || secondNumber.equals("0"))
                                System.out.println("Número invalido");
                        }while (!isDouble(secondNumber) || secondNumber.equals("0"));


                        data.set(0,Double.parseDouble(firstNumber));
                        data.set(1,Double.parseDouble(secondNumber));

                        response = (Double) client.execute("Operations.division", data);
                        System.out.println("El resultado de la división : " +response);

                        break;
                    case 5:

                        do {
                            System.out.println("Ingrese el primer numero");
                            firstNumber = in.next();

                            if (!isDouble(firstNumber))
                                System.out.println("Numero invalido");
                        }while (!isDouble(firstNumber));

                        do {
                            System.out.println("Ingrese el segundo numero");
                            secondNumber = in.next();
                            if (!isDouble(secondNumber))
                                System.out.println("Numero invalido");
                        }while (!isDouble(secondNumber));


                        data.set(0,Double.parseDouble(firstNumber));
                        data.set(1,Double.parseDouble(secondNumber));

                        response = (Double) client.execute("Operations.exponet", data);
                        System.out.println("El resultado de elevar : " +response);

                        break;
                    case 6:

                        do {
                            System.out.println("Ingrese un número");
                            firstNumber = in.next();

                            if (!isDouble(firstNumber) || firstNumber.contains("-"))
                                System.out.println("Número invalido");
                        }while (!isDouble(firstNumber) || firstNumber.contains("-"));

                        data.set(0,Double.parseDouble(firstNumber));
                        data.remove(1);

                        response = (Double) client.execute("Operations.root", data);
                        System.out.println("El resultado de la raíz : " +response);

                        break;
                    case 7:
                        String h = (String) client.execute("Operations.history" , data);
                        System.out.println(h);
                        break;

                    case 8:
                        System.out.println(" Adios ");
                        break;

                    default:
                        System.out.println("No existe esa opción");
                }

            }else {
                System.out.println("La opción es incorrecta Intente nuevemente");
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

}
