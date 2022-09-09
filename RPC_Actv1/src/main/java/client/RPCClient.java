package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;

public class RPCClient {

    public static void main(String[] args) throws MalformedURLException, XmlRpcException {

        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl(); //tipo de congiguración para que utilize mi servidor
        config.setServerURL(new URL("http://localhost:1200")); //conf server

        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config); //Agregamos al cliente al servidor

        Object[] data = {3.6,10D}; //create object (d is to double num

        Double response = (Double) client.execute("Methods.addition", data);  //wrapper

        System.out.println("Result : " +response);


    }
}
