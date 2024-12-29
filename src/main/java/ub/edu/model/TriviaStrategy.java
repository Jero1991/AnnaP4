package ub.edu.model;

import ub.edu.model.cataleg.GrupInteres;
import ub.edu.model.quizz.Pregunta;

public class TriviaStrategy implements MembershipStrategy{
    private Pregunta pregunta;
    private String givenAnswer;

    public void setGivenAnswer(String givenAnswer) {
        this.givenAnswer = givenAnswer;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    @Override
    public boolean becomeMember(Persona follower, GrupInteres grup) {
        if (pregunta.getRespostaCorrecta().equals(givenAnswer)){
            follower.addGrupInteresMembership(grup);
            follower.addPunts(200);
            return true;
        } else {
            return false;
        }
    }
}
