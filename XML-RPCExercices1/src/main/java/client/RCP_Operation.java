package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class RCP_Operation {


    //HERRERA HERNANDEZ JOEL ALEJANDRO 4A

    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);


        // EJERCICO 2
        Scanner read = new Scanner(System.in);
        double num1, num2, num3, suma;
        System.out.println("¿Cuál es el valor 1?");
        num1 = read.nextDouble();
        System.out.println("¿Cuál es el valor 2?");
        num2 = read.nextDouble();
        System.out.println("¿Cuál es el valor 3?");
        num3 = read.nextDouble();

        Object[] data = {num1, num2, num3};
        String response = (String) client.execute("Methods.product", data);


        System.out.println("Result -> " + response);

    }
}
