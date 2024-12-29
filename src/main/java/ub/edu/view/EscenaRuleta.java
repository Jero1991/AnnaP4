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

    private boolean isMember;

    private final String[] options = {"Membre", "Seguidor", "Res"};

    public void start() throws Exception{
        //TODO
        //accedirButton.setDisable(false);
        this.correuPersona = controller.getSessionMemory().getCorreuPersona();
        this.nomGrup = controller.getSessionMemory().getNomGrup();
        //spinButton.setDisable(false);
        //accedirButton.setDisable(true);
        isMember = false;
    }
    // Aixo s'encarrega de l'animació de la ruleta
    @FXML
    private void handleSpin() {
        spinRoulette();
    }

    private void spinRoulette() {
        System.out.println("Tirada la ruleta");

        //HashMap<String, String> tirada  = controller.sollicitarAcces("RULETA", correuPersona, nomGrup);
       // if (tirada!=null) {
            //tirada.get("tirada"));
            String resultat = controller.comprovarAcces("RULETA", correuPersona, nomGrup, "");

            if (resultat!= null) {
                if (resultat.equals("MEMBER")) {
                    spinningLabel.setText("ets membre del grup!");
                    accedirButton.setDisable(false);
                    isMember = true;
                } else {
                    spinningLabel.setText("No ets membre del grup");
                    spinButton.setDisable(true);
                    isMember = false;
                }
            }
        /*} else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Usuari o grup incorrecte o tirada=null");
            alert.showAndWait();
        }*/

    }

    public void onAccedirButton() {
        if(isMember) {
            // TODO Pràctica 4: Codi d'afegir com a membre de grup
            controller.addMember2Grup(correuPersona, nomGrup, 100);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Èxit");
            alert.setHeaderText("Èxit");
            alert.setContentText("Usuari afegit com a membre del grup");
            alert.showAndWait();
        }
    }
}