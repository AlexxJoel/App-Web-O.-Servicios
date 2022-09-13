package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class RCP_AdditionBetwen {

    //HERRERA HERNANDEZ JOEL ALEJANDRO 4A

    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);


        Scanner read = new Scanner(System.in);
        double num1, num2;
        System.out.println("Hola, Ingresa un número");
        num1 = read.nextDouble();
        System.out.println("Ingresa otro número");
        num2 = read.nextDouble();

        Object[] data = {num1,num2};
        String response = (String) client.execute("Methods.addition", data);
        System.out.println("Result -> " + response);
    }
}
