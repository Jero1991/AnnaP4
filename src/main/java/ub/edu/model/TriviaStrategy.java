package ub.edu.model;

import ub.edu.model.cataleg.GrupInteres;
import ub.edu.model.quizz.Pregunta;

public class TriviaStrategy implements MembershipStrategy{
    private Pregunta pregunta;
    private String correctAnswer;

    public TriviaStrategy(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean becomeMember(Persona follower, GrupInteres grup) {
        if (pregunta.getRespostaCorrecta().equals(correctAnswer)){
            follower.addGrupInteresMembership(grup);
            follower.addPunts(200);
            return true;
        } else {
            return false;
        }
    }
}
