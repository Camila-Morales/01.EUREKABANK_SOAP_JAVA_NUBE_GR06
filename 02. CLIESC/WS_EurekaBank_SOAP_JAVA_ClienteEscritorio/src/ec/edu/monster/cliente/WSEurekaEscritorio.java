package ec.edu.monster.cliente;

import ec.edu.monster.vistas.LoginView;

public class WSEurekaEscritorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear y mostrar la ventana de LoginVista
        java.awt.EventQueue.invokeLater(() -> {
            LoginView loginview = new LoginView();
            loginview.setVisible(true);
        });
    }
}
