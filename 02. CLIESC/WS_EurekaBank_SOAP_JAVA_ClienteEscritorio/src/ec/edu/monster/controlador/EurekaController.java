package ec.edu.monster.controlador;

import ec.edu.monster.servicio.EurekaService;
import java.util.List;
import ec.edu.monster.ws.Movimiento;

public class EurekaController {
    
    public List<Movimiento> traerMovimientos(String cuenta) {
        EurekaService service = new EurekaService();
        return service.traerMovimientos(cuenta);
    }

    public int regDepósito(String cuenta, double importe) {
        EurekaService service = new EurekaService();
        return service.regDeposito(cuenta, importe);
    }

    public int regRetiro(String cuenta, double importe) {
        EurekaService service = new EurekaService();
        return service.regRetiro(cuenta, importe);
    }

    public int regTransferencia(String cuentaOrigen, String cuentaDestino, double importe) {
        EurekaService service = new EurekaService();
        return service.regTransferencia(cuentaOrigen, cuentaDestino, importe);
    }
}
