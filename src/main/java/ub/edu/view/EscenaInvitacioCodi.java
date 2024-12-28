package ub.edu.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class EscenaInvitacioCodi extends Escena {

    @FXML
    private TextField invitationCodeField; // TextField for entering the code

    @FXML
    private Button accederButton; // The "Accedir" button

    @FXML
    private Label feedbackLabel; // Label to display feedback

    private String correuPersona;
    private String nomGrup;
    // Sample valid invitation code for this example

    @FXML
    public void start() {
        this.correuPersona = controller.getSessionMemory().getCorreuPersona();
        this.nomGrup = controller.getSessionMemory().getNomGrup();
        // Initially disable the "Accedir" button
        accederButton.setDisable(true);

        // Add listener to the invitation code TextField to check for validity

    }

    // Method to check the invitation code
    @FXML
    private void checkInvitationCode() {
        String code = invitationCodeField.getText();
        String resultat = controller.comprovarAcces("CODI", controller.getSessionMemory().getCorreuPersona(), controller.getSessionMemory().getNomGrup(), code);
        if (resultat!=null) {
            if (resultat.equals("MEMBER")) {
                feedbackLabel.setText("Codi d'invitació vàlid. Accedint...");
                accederButton.setDisable(false);
            } else {
                feedbackLabel.setText("Codi d'invitació invàlid. Si us plau, comproveu el codi i torneu a intentar-ho.");
                accederButton.setDisable(true);
            }
        }
    }

    // Action for the "Accedir" button
    @FXML
    public void accedir() {
        // TODO Pràctica 4: Codi d'afegir com a membre de grup
        controller.addMember2Grup(correuPersona, nomGrup, 150);
    }
}