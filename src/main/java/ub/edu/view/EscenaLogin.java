package ub.edu.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import ub.edu.controller.MessagesCAT;
import ub.edu.model.Persona;

import java.io.IOException;
import java.util.Optional;

public class EscenaLogin extends Escena {

    public Button login_btn;
    public TextField login_correu;
    public PasswordField login_pwd;
    public Button register_btn;
    public Button cancel_btn;
    private String correu;

    public void start(){
        if(correu!=null && !correu.equals("")){
            //caso que hemos registrado correctamemnte una nueva persona
            //poner su email pero la pwd a null para escribirla nosotros
            this.login_correu.setText(correu);
            this.login_pwd.setText(null);
        }else{
            //caso que volvemos del registro sin crear una nueva persona
            //por bondad dejamos los campos default para el login en lugar de hacer reset
            //no hacer nada
        }

    }

    @FXML
    protected void onLoginButtonClick() {
        String correu = login_correu.getText();
        String pwd = login_pwd.getText();

        String resultat = controller.loguejarPersona(correu, pwd);

        if (resultat.equals(MessagesCAT.PersonaNotFoundException.toString()) ||
                resultat.equals(MessagesCAT.WrongPasswordException.toString())) {
            //Problema en el login:
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error en el login");
            alert.setContentText(resultat);
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            //Login amb èxit:
            alert.setTitle("Login exitòs");
            alert.setHeaderText("Login exitòs");
            alert.setContentText("Vols llogar-te a la pagina?");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.isEmpty() || result.get() == ButtonType.CANCEL){
                //alert desaparece o boton cancelar
                //no hacer nada, nos quedamos donde ya estamos
            } else if(result.get() == ButtonType.OK){
                // REVIEW: Este else podrían hacerlo los alumnos para que se familiaricen con el código.
                // Propongo que se deje la definción de la función event_goMain pero dejar que la usen ellos.

                //oke button is pressed
                try {
                    event_goMain(correu);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    private void event_goMain (String correuPersona) throws Exception {
        try {
            Escena main = EscenaFactory.INSTANCE.creaEscena("main-view", "showTVTime Main View");
            EscenaMain escenaMain = ((EscenaMain) main);
            main.setController(controller);
            this.controller.getSessionMemory().setCorreuPersona(correuPersona);

            Persona client = controller.findClientCartera(correuPersona);
            client.getWatchedHistory().addObserver(escenaMain);
            client.getWatchedHistory().addObserver(client.getWhatNext());
            client.getWhatNext().addObserver(escenaMain);

            escenaMain.start();
            stage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onRegisterWindow(){
        try {
            Escena register = EscenaFactory.INSTANCE.creaEscena("register-view", "showTVTime Register View");
            EscenaRegister escenaRegister = ((EscenaRegister) register);
            register.setController(controller);
            escenaRegister.start();
            stage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onCancelButtonClick(){
        System.exit(0);
    }

}