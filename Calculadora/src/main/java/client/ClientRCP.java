package client;

import java.util.Scanner;

public class ClientRCP {


    static Scanner in = new Scanner(System.in); //No pierde su valor durante toda la ejecucion


    public static void main(String[] args) {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);

        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);


        String option = "", firstNumber = "", secondNumber= "";

        do {
            System.out.println("1.Suma");
            System.out.println("2.Resta");
            System.out.println("3.Multiplicación");
            System.out.println("4.Division");
            System.out.println("5.Exponente");
            System.out.println("6.Raiz");
            System.out.println("7.Consultar historial");
            System.out.println("8.Salir");
            option= in.next();
            if (isNumber(option)) {
                switch (Integer.parseInt(option)){
                    case 1:
                        do {
                            System.out.println("Ingrese el primer numero");
                            firstNumber = in.next();

                            if (!isDouble(firstNumber))
                                System.out.println("Ingrese el numero valido");
                        }while (!isDouble(firstNumber));

                        do {
                            System.out.println("Ingrese el segundo numero");
                            secondNumber = in.next();
                            if (!isDouble(secondNumber))
                                System.out.println("Ingrese el numero valido");
                        }while (!isDouble(secondNumber));
                        //Ejecución del método en el servidor........

                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("No existe esa opción");
                }

            }else {
                System.out.println("La opcion es incorrecta Intente nuevemente");
            }


        }while (! option.equals("8") );

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
