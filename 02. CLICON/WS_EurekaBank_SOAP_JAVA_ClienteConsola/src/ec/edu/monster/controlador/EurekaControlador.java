/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.controlador;

import ec.edu.monster.modelo.WSEurekaClient;
import ec.edu.monster.vista.ConsolaVista;
import ws_eurekabank_soap_java_clienteconsola.Movimiento;

import java.util.List;

public class EurekaControlador {
    private final WSEurekaClient modelo;
    private final ConsolaVista vista;

    public EurekaControlador() throws Exception {
        this.modelo = new WSEurekaClient();
        this.vista = new ConsolaVista();
    }

    public void iniciar() {
        vista.mostrarMensaje("Bienvenido al sistema de consulta bancaria");

        // Login
        boolean autenticado = false;
        while (!autenticado) {
            String usuario = vista.solicitarTexto("Ingrese el usuario:");
            String contrasena = vista.solicitarTexto("Ingrese la contraseña:");
            autenticado = modelo.login(usuario, contrasena);

            if (!autenticado) {
                vista.mostrarMensaje("Credenciales incorrectas. Intente nuevamente.");
            }
        }
        vista.mostrarMensaje("Inicio de sesión exitoso.");

        // Menú
        boolean salir = false;
        while (!salir) {
            vista.mostrarMenu();
            int opcion = vista.solicitarOpcion();

            switch (opcion) {
                case 1:
                    consultarMovimientos();
                    break;
                case 2:
                    registrarDeposito();
                    break;
                case 3:
                    registrarRetiro();
                    break;
                case 4:
                    registrarTransferencia();
                    break;
                case 5:
                    salir = true;
                    vista.mostrarMensaje("Saliendo del sistema. ¡Hasta pronto!");
                    break;
            }
        }
    }

    private void consultarMovimientos() {
        String cuenta = vista.solicitarTexto("Ingrese el número de cuenta (Ejemplo: 00100001):");
        List<Movimiento> movimientos = modelo.traerMovimientos(cuenta);

        if (movimientos.isEmpty()) {
            vista.mostrarMensaje("No se encontraron movimientos para la cuenta.");
        } else {
            vista.mostrarMensaje("Movimientos de la cuenta:");
            for (Movimiento mov : movimientos) {
                vista.mostrarMensaje(String.format("Fecha: %s | Tipo: %s | Acción: %s | Importe: %.2f",
                        mov.getFecha(), mov.getTipo(), mov.getAccion(), mov.getImporte()));
            }
        }
    }

    private void registrarDeposito() {
        String cuenta = vista.solicitarTexto("Ingrese el número de cuenta (Ejemplo: 00100001):");
        double importe = vista.solicitarDecimal("Ingrese el importe a depositar:");

        int estado = modelo.regDeposito(cuenta, importe);
        if (estado == 1) {
            vista.mostrarMensaje("Depósito registrado exitosamente.");
        } else {
            vista.mostrarMensaje("Error al registrar el depósito. Intente nuevamente.");
        }
    }
    
    private void registrarRetiro() {
        String cuenta = vista.solicitarTexto("Ingrese el número de cuenta:");
        double importe = vista.solicitarDecimal("Ingrese el importe a retirar:");
        int estado = modelo.regRetiro(cuenta, importe);

        if (estado == 1) {
            vista.mostrarMensaje("Retiro registrado exitosamente.");
        } else {
            vista.mostrarMensaje("Error al registrar el retiro. Verifique la cuenta o el saldo.");
        }
    }

    private void registrarTransferencia() {
        String cuentaOrigen = vista.solicitarTexto("Ingrese la cuenta de origen:");
        String cuentaDestino = vista.solicitarTexto("Ingrese la cuenta de destino:");
        double importe = vista.solicitarDecimal("Ingrese el importe a transferir:");
        int estado = modelo.regTransferencia(cuentaOrigen, cuentaDestino, importe);

        if (estado == 1) {
            vista.mostrarMensaje("Transferencia registrada exitosamente.");
        } else {
            vista.mostrarMensaje("Error al registrar la transferencia. Verifique los datos.");
        }
    }
}

