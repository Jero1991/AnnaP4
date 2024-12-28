package ub.edu.model.quizz;

import java.util.ArrayList;
import java.util.HashMap;

public class Pregunta {

    private Integer id;
    private String text;

    private ArrayList<Resposta> respostes;

    // Constructor
    public Pregunta(String text,  ArrayList<Resposta> respostes) {
        this.text = text;
        this.respostes = respostes;
    }

    public Pregunta(Integer id, String text) {
        this.id = id;
        this.text = text;
        respostes = new ArrayList<>();
    }

    public Pregunta(Integer id, String text, ArrayList<Resposta> respostes) {
        this.id = id;
        this.text = text;
        this.respostes = respostes;
    }

    public Pregunta(String text) {
        this.text = text;
    }
    // Getters i Setters

    public Integer getId() {
        return id;
    }

    public String getQuestion() {
        return text;
    }

    public void setQuestion(String text) {
        this.text = text;
    }

    public void addResposta(Resposta r) {
        respostes.add(r);
    }

    public ArrayList<Resposta> getRespostes() {
        return respostes;
    }

    public void setRespostes(ArrayList<Resposta> respostes) {
        this.respostes = respostes;
    }

    public boolean comprovaResultat(String resposta) {
        for (Resposta r : respostes) {
            if (r.getText().equals(resposta)) {
                return r.isCorrecta();
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Pregunta{" +
                ", text='" + text + '\'' +
                ", respostes=" + respostes +
                '}';
    }

    public HashMap<String, String> toHash() {
        HashMap<String, String> questionAndAnswers = new HashMap<>();
        questionAndAnswers.put("question", text);
        for (int i = 0; i < respostes.size(); i++) {
            questionAndAnswers.put("answer" + i, respostes.get(i).getText());
        }
        return questionAndAnswers;
    }

    public String getRespostaCorrecta() {
        for (Resposta r : respostes) {
            if (r.isCorrecta()) {
                return r.getText();
            }
        }
        return null;
    }

}
