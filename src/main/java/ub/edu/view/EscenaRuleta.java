package ub.edu.view;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.HashMap;

public class EscenaRuleta extends Escena {

    private String correuPersona;
    private String nomGrup;
    @FXML
    private Label resultLabel;

    @FXML
    private Label spinningLabel;

    @FXML
    private Button spinButton;

    @FXML
    private Button accedirButton;

    private final String[] options = {"Membre", "Seguidor", "Res"};

    public void start() throws Exception{
        //TODO
        accedirButton.setDisable(true);
        this.correuPersona = controller.getSessionMemory().getCorreuPersona();
        this.nomGrup = controller.getSessionMemory().getNomGrup();
    }
    // Aixo s'encarrega de l'animació de la ruleta
    @FXML
    private void handleSpin() {
        spinRoulette();
    }

    private void spinRoulette() {

        HashMap<String, String> tirada  = controller.sollicitarAcces("RULETA", correuPersona, nomGrup);
        if (tirada!=null) {
            spinningLabel.setText(tirada.get("tirada"));
            String resultat = controller.comprovarAcces("RULETA", correuPersona, nomGrup, tirada.get("tirada"));

            if (resultat!= null) {
                if (resultat.equals("MEMBER")) {
                    accedirButton.setDisable(false);
                } else {
                    spinButton.setDisable(true);
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Usuari o grup incorrecte o tirada=null");
            alert.showAndWait();
        }

    }

    public void onAccedirButton() {
        // TODO Pràctica 4: Codi d'afegir com a membre de grup
        controller.addMember2Grup(correuPersona, nomGrup, 100);
    }
}