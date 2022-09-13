package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class RCP_IMC {

    //HERRERA HERNANDEZ JOEL ALEJANDRO 4A

    public static void main(String[] args) throws MalformedURLException, XmlRpcException {

        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        Scanner read = new Scanner(System.in);
        double weight = 0,height = 0; String name;
        System.out.println("----Ingresa tu nombre------------");
        name = read.next();
        System.out.println("----Ingresa el peso-----------");
        weight = read.nextDouble();
        System.out.println("----Ingresa la altura-----------");
        height = read.nextDouble();

        Object[] data = {weight, height};
        Double response = (Double) client.execute("Methods.imc", data);

        System.out.println("Hola "+name + " tu IMC es: "+response);
    }

}

