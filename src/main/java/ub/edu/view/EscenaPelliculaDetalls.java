package ub.edu.view;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;


public class EscenaPelliculaDetalls extends Escena {
    public Text nomPellicula_text;
    public Text data_text_caracteristiques;
    public Text data_text_nom;
    public Text data_text_dataAnyPrimeraEmissio;
    public Text data_text_durada;
    public Text data_text_descripcio;
    public Text data_text_idioma;

    public ImageView data_image_image;


    public Button valorar_btn;
    public Button watched_btn;

    private String correu_persona;
    private String nom_contingut_audiovisual;

    public void start() throws Exception {
        this.correu_persona=this.controller.getSessionMemory().getCorreuPersona();
        this.nom_contingut_audiovisual =this.controller.getSessionMemory().getNomPelicula();
        initData();
    }

    public void initData() throws Exception {
        HashMap<Object,Object> pelliculaHashMap = controller.getDetallsPelicula(this.nom_contingut_audiovisual);
        String nom, idioma, imatge="", descripcio="";
        Integer anyPrimeraEmissio, durada;

        if(pelliculaHashMap.get("imatge")!=null){
            imatge = (String) pelliculaHashMap.get("imatge");
            Image image = new Image(imatge);
            data_image_image.setImage(image);
        }

        if(pelliculaHashMap.get("nom")!=null){
            nom = (String) pelliculaHashMap.get("nom");
            nomPellicula_text.setText(nom);
            data_text_nom.setText("Nom: " + nom);
        }
        if(pelliculaHashMap.get("descripcio")!=null){
            descripcio = (String) pelliculaHashMap.get("descripcio");
            data_text_descripcio.setText("Descripcio: " + descripcio);
        }
        if(pelliculaHashMap.get("dataAnyPrimeraEmissio")!=null){
            String anyPrimeraEmissio_str = (String) pelliculaHashMap.get("dataAnyPrimeraEmissio");
            anyPrimeraEmissio = Integer.parseInt(anyPrimeraEmissio_str);
            data_text_dataAnyPrimeraEmissio.setText("Any Primera Emissio: " + anyPrimeraEmissio);
        }
        if(pelliculaHashMap.get("idioma")!=null){
            idioma = (String) pelliculaHashMap.get("idioma");
            data_text_idioma.setText("Idioma: " + idioma);
        }
        if(pelliculaHashMap.get("durada")!=null){
            durada = (Integer)  pelliculaHashMap.get("durada");
            data_text_durada.setText("Durada: " + durada);
        }
    }

    public void onBtnValorarClick() throws IOException {
        controller.getSessionMemory().setTipusObra("Pelicula");
        //Nova finestra
        Escena escena = EscenaFactory.INSTANCE.creaEscena("valorarObra-view", "Valorar Contingut Audiovisual: "+String.valueOf(this.nom_contingut_audiovisual));
        EscenaValorarObra escenaValorarObra = ((EscenaValorarObra)escena);
        escenaValorarObra.setController(controller);
        escenaValorarObra.start();
    }

    public void onBtnWatchedHistoryAddClick() throws Exception {
        boolean result = controller.addToWatchedHistory(controller.getSessionMemory().getNomPelicula(), controller.getSessionMemory().getCorreuPersona());
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
/*
    public void updateList() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Èxit");
        alert.setHeaderText("Èxit");
        alert.setContentText("Pelicula afegida a la WatchedHistory");
        alert.showAndWait();
    } */
}
