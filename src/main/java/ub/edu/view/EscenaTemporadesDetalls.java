package ub.edu.view;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;

import java.util.HashMap;
import java.util.List;


public class EscenaTemporadesDetalls extends Escena{
    private static final double ESPAI_ENTRE_BOTONS = 30;
    public AnchorPane temporada_pane;
    public Button temporada_btn;
    private String correu_persona;
    private String id_serie;

    public void start() throws Exception {
        this.correu_persona=this.controller.getSessionMemory().getCorreuPersona();
        this.id_serie =this.controller.getSessionMemory().getNomSerie();
        popularTemporades(id_serie);
    }

    public void popularTemporades(String nomSerie) throws Exception {
        List<HashMap<Object,Object>> hashMapList = controller.getAllTemporadesDeSerie(nomSerie);
        if(hashMapList.size()==0){
            temporada_btn.setText("Empty Temporades");
            temporada_btn.setDisable(true);
            return;
        }
        List<Node> temporadesPaneChildren = temporada_pane.getChildren();

        double width = temporada_btn.getWidth();
        double height = temporada_btn.getHeight();
        double layoutX = temporada_btn.getLayoutX();
        double layoutY = temporada_btn.getLayoutY();

        String s;
        Button new_btn;
        for (int i = 0; i < hashMapList.size(); i++) {
            Integer hasMapValue = (Integer) hashMapList.get(i).get("numTemporada");
            new_btn = createTemporadaButton(hasMapValue, "Temporada " + hasMapValue.toString(), width, height, layoutX, layoutY);
            temporadesPaneChildren.add(new_btn);
            layoutY += ESPAI_ENTRE_BOTONS;
        }
        //Actualitzem la mida del pane que conté els botons per que es pugui fer scroll cap a baix si hi ha més botons dels que caben al pane
        temporada_pane.setPrefHeight(layoutY);
        //Esborrem excursio_btn, que l'utilitzavem únicament com a referència per la mida dels botons
        temporadesPaneChildren.remove(temporada_btn);
    }

    private Button createTemporadaButton(Integer numTemporada, String text, double width, double height, double layoutX, double layoutY){
        Button new_btn = new Button();
        new_btn.setPrefWidth(width);
        new_btn.setPrefHeight(height);
        new_btn.setText(text);
        new_btn.setLayoutX(layoutX);
        new_btn.setLayoutY(layoutY);
        new_btn.setAlignment(Pos.BASELINE_LEFT);
        new_btn.setOnMouseClicked(event ->
        {
            if (event.getButton() == MouseButton.PRIMARY)
            {
                try {
                    mostrarEpisodisSelector(numTemporada);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        return new_btn;
    }

    private void mostrarEpisodisSelector(Integer num_temporada) throws Exception {
        Escena register = EscenaFactory.INSTANCE.creaEscena("episodisSelector-view", "Episodis associats a la Temporada: "+String.valueOf(num_temporada));
        EscenaEpisodisSelector escenaEpisodis = ((EscenaEpisodisSelector) register);
        register.setController(controller);
        this.controller.getSessionMemory().setNumTemporada(num_temporada);
        escenaEpisodis.start();
    }

    public void onBtnWatchedHistoryAddClick() throws Exception {
        //TODO
        boolean result = controller.addTemporadaToWatchedHistory(controller.getSessionMemory().getNomSerie(), controller.getSessionMemory().getNumTemporada(), controller.getSessionMemory().getCorreuPersona());
        if (result){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Èxit");
            alert.setHeaderText("Èxit");
            alert.setContentText("Pelicula afegida a la llista de vistos");
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Error al afegir la pelicula a la llista de vistos");
            alert.showAndWait();
        }

    }
}


