import org.*;
import org.example.SOAPClient.Service;
import org.example.SOAPClient.ServiceService;

import javax.jws.WebService;

public class client {

    public static void main(String[] args) {

        ServiceService serviceService = new ServiceService();

        Service service = serviceService.getServicePort();

        String response = service.responseMessage("Hola");
        System.out.println(response);

    }
}
