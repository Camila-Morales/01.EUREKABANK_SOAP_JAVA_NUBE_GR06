package ec.edu.monster.servicio;

import java.util.List;
import ec.edu.monster.ws.WSEureka;
import ec.edu.monster.ws.WSEureka_Service;
import ec.edu.monster.ws.Movimiento;

public class EurekaService {

    public int regDeposito(String cuenta, double importe) {
        WSEureka_Service service = new WSEureka_Service();
        WSEureka port = service.getWSEurekaPort();
        return port.regDeposito(cuenta, importe);
    }

    public List<Movimiento> traerMovimientos(String cuenta) {
        WSEureka_Service service = new WSEureka_Service();
        WSEureka port = service.getWSEurekaPort();
        return port.traerMovimientos(cuenta);
    }

    public int regRetiro(String cuenta, double importe) {
        WSEureka_Service service = new WSEureka_Service();
        WSEureka port = service.getWSEurekaPort();
        return port.regRetiro(cuenta, importe);
    }

    public int regTransferencia(String cuentaOrigen, String cuentaDestino, double importe) {
        WSEureka_Service service = new WSEureka_Service();
        WSEureka port = service.getWSEurekaPort();
        return port.regTransferencia(cuentaOrigen, cuentaDestino, importe);
    }
}
