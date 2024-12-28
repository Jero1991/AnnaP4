package ub.edu.view;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import ub.edu.controller.MessagesCAT;


import java.io.IOException;

public class EscenaRegister extends Escena {

    public Button registre_btn;
    public Button cancellar_btn;
    public TextField registre_correu;
    public PasswordField registre_pwd;
    public PasswordField registre_pwd_repeat;
    public TextField registre_nom;
    public TextField registre_cognoms;
    public TextField registre_dni;


    public void start() {

    }

    @FXML
    public void onRegistreButtonClick() throws Exception {
        String correu = registre_correu.getText();
        String nom = registre_nom.getText();
        String cognoms = registre_cognoms.getText();
        String dni = registre_dni.getText();
        String pwd = registre_pwd.getText();
        String pwd_repeat = registre_pwd_repeat.getText();

        if (correu==null || correu.equals("") || pwd==null || pwd.equals("") || !pwd.equals(pwd_repeat)) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error en el registre");
            alert.setContentText("El correu y la contraseña son obligatories. Les contrasenyes deben coincidir");
            alert.showAndWait();
            return;
        }

        //PAS2- Crear una nueva Persona
        String resultat = controller.registrePersona(correu, nom, cognoms, dni, pwd);


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        if (resultat.equals(MessagesCAT.PersonaExistsException.toString()) ||
                resultat.equals(MessagesCAT.FormatIncorrecteException.toString()) ||
                resultat.equals(MessagesCAT.NotSecurePasswordException.toString())){
            //Problema en el registre:
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error en el registre");
            alert.setContentText(resultat.toString());
        } else {
            //Registre amb èxit:
            alert.setTitle("Registre exitòs");
            alert.setHeaderText("Registre exitòs");
            alert.setOnCloseRequest(new EventHandler<DialogEvent>() {
                @Override
                public void handle(DialogEvent dialogEvent) {
                    //System.out.println(alert.getResult());
                    String resu_ButtonData = String.valueOf(alert.getResult().getButtonData());
                    if(resu_ButtonData.equals("OK_DONE")){
                        //boton aceptar
                        event_goLogin(correu);

                    }else{
                        //boton cancelar
                        //no hacer nada, nos quedamos donde ya estamos
                    }
                }
            });
        }
        alert.showAndWait();
    }

    private void event_goLogin (String correu){
        try {
            Escena login = EscenaFactory.INSTANCE.creaEscena("login-view", "showTVTime Login View");
            EscenaLogin escenaLogin = ((EscenaLogin) login);
            login.setController(controller);
            this.controller.getSessionMemory().setCorreuPersona(correu);
            escenaLogin.start();
            stage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTornarLoginButtonClick(){
        event_goLogin(null);
    }

}