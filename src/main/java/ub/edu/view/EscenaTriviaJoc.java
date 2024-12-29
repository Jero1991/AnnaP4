package ub.edu.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import ub.edu.model.MembershipStrategy;
import ub.edu.model.TriviaStrategy;
import ub.edu.model.quizz.Pregunta;

import java.util.HashMap;
import java.util.Random;

public class EscenaTriviaJoc extends Escena {

    @FXML
    private Label questionLabel;

    @FXML
    private RadioButton option1;

    @FXML
    private RadioButton option2;

    @FXML
    private RadioButton option3;

    @FXML
    private Label feedbackLabel;

    @FXML
    private Button accedirButton; // New "Accedir" button


    private String correuPersona;

    private String nomGrup;
    private String correctAnswer;
    private final ToggleGroup answerGroup = new ToggleGroup();

    @FXML
    public void start() {

        this.correuPersona = controller.getSessionMemory().getCorreuPersona();
        this.nomGrup = controller.getSessionMemory().getNomGrup();

        // Assign the ToggleGroup to the RadioButtons
        option1.setToggleGroup(answerGroup);
        option2.setToggleGroup(answerGroup);
        option3.setToggleGroup(answerGroup);

        // Initialize the "Accedir" button as disabled
        accedirButton.setDisable(true);

        // Load the first question
        loadRandomQuestion();
    }

    private void loadRandomQuestion() {
        Random random = new Random();
        Pregunta p =  controller.findGrupInteres(nomGrup).getPregunta();
        HashMap<String, String> pregunta  = p.toHash();

        MembershipStrategy ms = controller.findGrupInteres(nomGrup).getMembershipStrategy();
        TriviaStrategy grupTrivia = (TriviaStrategy) ms;
        grupTrivia.setPregunta(p);

        if (pregunta!=null) {
            // Load question and options
            questionLabel.setText(pregunta.get("question"));
            option1.setText(pregunta.get("answer0"));
            option2.setText(pregunta.get("answer1"));
            option3.setText(pregunta.get("answer2"));

            // Clear feedback
            feedbackLabel.setText("");

            // Clear any previous selection
            answerGroup.selectToggle(null);

            // Disable the "Accedir" button for a new question
            accedirButton.setDisable(true);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Nom de la persona o del grup incorrecte o pregunta = null");
            alert.showAndWait();
        }
    }

    @FXML
    private void submitAnswer() {
        // Check the selected answer
        RadioButton selectedOption = (RadioButton) answerGroup.getSelectedToggle();

        if (selectedOption == null) {
            feedbackLabel.setText("Selecciona la resposta més correcta");
            return;
        }
        String selectedAnswer = selectedOption.getText();
        String resultat = controller.comprovarAcces("QUIZZ", controller.getSessionMemory().getCorreuPersona(),controller.getSessionMemory().getNomGrup(), selectedAnswer);
        if (resultat!=null) {
            if (resultat.equals("MEMBER")) {
                accedirButton.setDisable(false); // Enable "Accedir" button
            } else {
                feedbackLabel.setText("Resposta incorrecta");
            }
        }
    }

    @FXML
    public void accedir() {
        // TODO Pràctica 4: Codi d'afegir com a membre de grup
        controller.addMember2Grup(correuPersona, nomGrup, 200);
    }
}