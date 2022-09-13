package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class RCP_ArraysOrder {

    //HERRERA HERNANDEZ JOEL ALEJANDRO 4A

    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);


        Scanner read = new Scanner(System.in);
        Object [] data = new Object[5] ;

        for(int i=0; i<data.length; i++){
            System.out.println("Ingresa el numero "+(i+1));
            data[i]= read.nextInt( );
        }


        String response = (String) client.execute("Methods.order", data);
        System.out.println("Result -> " + response);

    }
}
