package ub.edu.model.quizz;

public class Resposta {

    private String text;
    private boolean esCorrecta;

    private Integer pregunta_id;

    // Constructor
    public Resposta( String text, boolean esCorrecta) {

        this.text = text;
        this.esCorrecta = esCorrecta;
    }

    public Resposta( String text, boolean esCorrecta, Integer pregunta_id) {
        this.text = text;
        this.esCorrecta = esCorrecta;
        this.pregunta_id = pregunta_id;
    }

    // Getters i Setters
    public Integer getPreguntaId() {
        return pregunta_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrecta() {
        return esCorrecta;
    }

    public void setEsCorrecta(boolean esCorrecta) {
        this.esCorrecta = esCorrecta;
    }

    @Override
    public String toString() {
        return "Resposta{" +
                ", text='" + text + '\'' +
                ", esCorrecta=" + esCorrecta +
                '}';
    }
}
