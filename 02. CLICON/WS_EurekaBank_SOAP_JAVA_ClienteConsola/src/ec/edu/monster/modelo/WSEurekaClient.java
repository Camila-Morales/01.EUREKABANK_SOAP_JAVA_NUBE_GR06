/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.modelo;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.util.List;

public class WSEurekaClient {
    private final  ws_eurekabank_soap_java_clienteconsola.WSEureka port;

    public WSEurekaClient() throws Exception {
        URL url = new URL("http://localhost:8080/WS_Eureka/WSEureka?WSDL");
        QName qname = new QName("http://ws.monster.edu.ec/", "WSEureka");
        Service service = Service.create(url, qname);
        port = service.getPort(ws_eurekabank_soap_java_clienteconsola.WSEureka.class);
    }

    public boolean login(String usuario, String contrasena) {
        return port.login(usuario, contrasena);
    }

    public List<ws_eurekabank_soap_java_clienteconsola.Movimiento> traerMovimientos(String cuenta) {
        return port.traerMovimientos(cuenta);
    }

    public int regDeposito(String cuenta, double importe) {
        return port.regDeposito(cuenta, importe);
    }
    public int regRetiro(String cuenta, double importe) {
        return port.regRetiro(cuenta, importe);
    }

    public int regTransferencia(String cuentaOrigen, String cuentaDestino, double importe) {
        return port.regTransferencia(cuentaOrigen, cuentaDestino, importe);
    }
}