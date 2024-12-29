package ub.edu.view;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import ub.edu.model.Persona;
import ub.edu.model.cataleg.WatchedHistory;
import ub.edu.model.cataleg.WhatNext;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class EscenaMain extends Escena implements Observer {
    private static final double ESPAI_ENTRE_BOTONS = 30;

    public Button obra_audiovisual_btn;
    public Button button_izq_resetFiltres_main;
    //public Button button_der_resetFiltres_main;
    public AnchorPane contingut_audiovisual_pane;
    public TableView tableTop10Valorades;
    public TableColumn nomColumn;
    public TableColumn valueColumn;
    public TableView tableWatchedList;
    public TableColumn nomColumnWatchedList;
    public Text textPrincipal;
    public ImageView image_main;
    public Button button_punts_main;
    public Button button_imdb_main;
    @FXML
    public ComboBox comboBox_main_tipus;
    public ComboBox comboBox_main_tematica;
    public Button GlobalPersonalButton;


    public void start() throws Exception {
        String correu = controller.getSessionMemory().getCorreuPersona();
        assignarTextPrincipal_Correu(correu);
        asignarimagen();
        popularComboBoxTipus(); //success
        popularComboBoxTematiques(); //success
        popularObresAudiovisualsPerNom();
        // TODO: Repensar donde se llamará este método
        //popularTopDeuValorades();
        popularWatchedList();
    }
    public void assignarTextPrincipal_Correu(String correuPersona) throws Exception {
        textPrincipal.setText("ShowTVTime: "+correuPersona);
    }

    public void asignarimagen() throws FileNotFoundException {
        FileInputStream input = new FileInputStream("./src/main/view-resources/ub/edu/static-resources/logo8.png");
        Image image = new Image(input);
        image_main.setImage(image);
    }

    public void onCheckBoxPelis(ActionEvent actionEvent) {
        controller.getSessionMemory().setTipusObra("Pelicula");
        System.out.println("CheckBox Pelis");
    }

    public void onGlobalPersonalButton() {
        //TODO Pràctica 4 OPCIONAL: canviar la visualitzacio de la WatchedHistory i la WatchNext als
        //TODO: veure els Top10 dels valors de tots els usuaris de l'aplicacio
        if(GlobalPersonalButton.getText().equals("Llista Personal")){
            GlobalPersonalButton.setText("Top10 Global");
            //TODO Pràctica 4 OPCIONAL: afegir el codi que calgui
            System.out.println("Seleccionada l'opció Top10Global");
        }else{
            GlobalPersonalButton.setText("Llista Personal");
            //TODO Pràctica 4 OPCIONAL: afegir el codi que calgui
            System.out.println("Seleccionada l'opció Llista Personal");
        }
    }

    public void onBtnLogOut() {
        //TODO OPT Pràctica 4
        // Limpiar la sesión del usuario
        controller.getSessionMemory().clearSession();

        // Redirigir a la pantalla de inicio de sesión
        try {
            stage.close();
            Escena escena = EscenaFactory.INSTANCE.creaEscena("login-view", "Iniciar Sesión");
            EscenaLogin escenaLogin = ((EscenaLogin) escena);
            escenaLogin.setController(controller);
            escenaLogin.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Actualitzant la vista principal");
        if (o instanceof WatchedHistory){
            System.out.println("Actualitzant la WatchedHistory");
            if (arg instanceof String){
                String s = (String) arg;
                if (s.equals("watchedHistory")){
                    popularWatchedList();
                }
            }
        }
        else if(o instanceof WhatNext) {
            System.out.println("Actualitzant la WhatNext");
            if (arg instanceof String) {
                String s = (String) arg;
                if (s.equals("whatNext")) {
                    popularWhatNext();
                }
            }
        }
    }

    private void popularWhatNext() {
        nomColumn.setCellValueFactory(new PropertyValueFactory<DataWatched, String>("nom"));

        List<HashMap<Object, Object>> listaObres = controller.getWatchNext(this.controller.getSessionMemory().getCorreuPersona());

        // Borrar todos los elementos existentes en la TableView
        tableTop10Valorades.getItems().clear();

        // Agregar los elementos de la lista de nombres a la TableView
        for (HashMap<Object, Object> listaObre : listaObres) {
            // Obtener el nombre (u otro valor) de la obra de la lista de HashMaps
            String nom = (String) listaObre.get("nom");

            // Agregar la cadena directamente a la TableView
            tableTop10Valorades.getItems().add(new DataWatched(nom));
        }
    }


    public static class DataWatched {
        //Cal deixar aquests atributs com finals per poder popular la taula quan el mètode  la cridi
        private final SimpleStringProperty nom;
        DataWatched(String nom_param){
            this.nom = new SimpleStringProperty(nom_param);
        }
        //métodos getters
        public String getNom() {
            return nom.get();
        }
    }

    private void popularWatchedList() {
        nomColumnWatchedList.setCellValueFactory(new PropertyValueFactory<DataWatched, String>("nom"));

        List<HashMap<Object, Object>> listaObres = controller.getWatchedHistory(this.controller.getSessionMemory().getCorreuPersona());

        // Borrar todos los elementos existentes en la TableView
        tableWatchedList.getItems().clear();

        // Agregar los elementos de la lista de nombres a la TableView
        for (HashMap<Object, Object> listaObre : listaObres) {
            // Obtener el nombre (u otro valor) de la obra de la lista de HashMaps
            String nom = (String) listaObre.get("nom");

            // Agregar la cadena directamente a la TableView
            tableWatchedList.getItems().add(new DataWatched(nom));
        }
    }

    private void popularObresAudiovisualsPerNom(){
        List<HashMap<Object,Object>> listaObres = controller.visualitzarContingutsDigitalsPerNom();
        System.out.println(listaObres.toString());
        if(listaObres == null || listaObres.size()==0){
            return;
        }
        List<Node> obresPaneChildren = contingut_audiovisual_pane.getChildren();

        double width = obra_audiovisual_btn.getWidth();
        double height = obra_audiovisual_btn.getHeight();
        double layoutX = obra_audiovisual_btn.getLayoutX();
        double layoutY = obra_audiovisual_btn.getLayoutY();
        //Instanciem un botó per cada obra audiovisual

        String text;
        Button new_btn;
        String nom;
        for (HashMap<Object,Object> obra:listaObres) {
            nom = (String) obra.get("nom");
            text = nom;
            new_btn = createObraAudiovisualButton(nom, text, width, height, layoutX, layoutY);
            obresPaneChildren.add(new_btn);
            layoutY += ESPAI_ENTRE_BOTONS;
        }
        //Actualitzem la mida del pane que conté els botons perque es pugui fer scroll cap abaix si hi ha més botons dels que caben al pane
        contingut_audiovisual_pane.setPrefHeight(layoutY);
        //Esborrem obra_audiovisual_btn, que l'utilitzavem únicament com a referència per la mida dels botons
        obresPaneChildren.remove(obra_audiovisual_btn);
    }

    /*
     * Crea un botó de dimensions width x height, colocat a la posició (layoutX, layoutY)
     * */
    private Button createObraAudiovisualButton(String nom_obra_audiovisual, String text, double width, double height, double layoutX, double layoutY){
        Button new_btn = new Button();
        new_btn.setPrefWidth(width);
        new_btn.setPrefHeight(height);
        new_btn.setText(text);
        new_btn.setLayoutX(layoutX);
        new_btn.setLayoutY(layoutY);
        new_btn.setAlignment(Pos.BASELINE_LEFT);
        //asignamos el evento del click que ejecutará mostrar la ventana con detalles de la ruta
        new_btn.setOnMouseClicked(event ->
        {
            if (event.getButton() == MouseButton.PRIMARY)
            {
                try {
                    mostrarFinestraObraAudiovisual(nom_obra_audiovisual);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        return new_btn;
    }

    private void mostrarFinestraObraAudiovisual(String nom) throws Exception {
        if (this.controller.esPelicula(nom)){
            Escena escena = EscenaFactory.INSTANCE.creaEscena("pelliculaDetalls-view", "Detalls pellicula "+String.valueOf(nom));
            EscenaPelliculaDetalls escenaPelliculaDetalls = ((EscenaPelliculaDetalls)escena);
            escenaPelliculaDetalls.setController(controller);
            this.controller.getSessionMemory().setNomPelicula(nom);
            escenaPelliculaDetalls.start();
        } else {
            Escena escena = EscenaFactory.INSTANCE.creaEscena("serieDetalls-view", "Detalls serie "+String.valueOf(nom));
            EscenaSerieDetalls escenaSerieDetalls = ((EscenaSerieDetalls)escena);
            escenaSerieDetalls.setController(controller);
            this.controller.getSessionMemory().setNomSerie(nom);
            escenaSerieDetalls.start();
        }

    }

    public void popularComboBoxTipus() throws Exception {

        comboBox_main_tipus.getItems().add(0,"Selecciona el tipus");
        comboBox_main_tipus.getItems().add(1,"Pelicula");
        comboBox_main_tipus.getItems().add(2,"Serie");


        //añadir el listener del combobox
        comboBox_main_tipus.valueProperty().addListener(new ChangeListener<String>() {
            //OPCIÓN-1 -> asignar listener para que se ejecute cuando detecte el cambio
            @Override public void changed(ObservableValue classObject, String oldValue, String newValue) {
                System.out.println("TODO: Filtrar Per Tipus: "+newValue);
                //TODO: extensión de popular la lista de Peliculas

                List<HashMap<Object,Object>> listaObres;
                switch (newValue) {
                    case "Pelicula":
                        listaObres = controller.visualitzarPelisPerNom();
                        break;
                    case "Serie":
                        listaObres = controller.visualitzarSeriesPerNom();
                        break;
                    default:
                        listaObres = controller.visualitzarContingutsDigitalsPerNom();
                }
                System.out.println(listaObres.toString());
                if(listaObres == null || listaObres.size()==0){
                    return;
                }
                List<Node> obresPaneChildren = contingut_audiovisual_pane.getChildren();

                double width = obra_audiovisual_btn.getWidth();
                double height = obra_audiovisual_btn.getHeight();
                double layoutX = obra_audiovisual_btn.getLayoutX();
                double layoutY = obra_audiovisual_btn.getLayoutY();
                //Instanciem un botó per cada obra audiovisual

                String text;
                Button new_btn;
                String nom;
                for (HashMap<Object,Object> obra:listaObres) {
                    nom = (String) obra.get("nom");
                    text = nom;
                    new_btn = createObraAudiovisualButton(nom, text, width, height, layoutX, layoutY);
                    obresPaneChildren.add(new_btn);
                    layoutY += ESPAI_ENTRE_BOTONS;
                }
                //Actualitzem la mida del pane que conté els botons perque es pugui fer scroll cap abaix si hi ha més botons dels que caben al pane
                contingut_audiovisual_pane.setPrefHeight(layoutY);
                //Esborrem excursio_btn, que l'utilitzavem únicament com a referència per la mida dels botons
                obresPaneChildren.remove(obra_audiovisual_btn);

            }
        });

    }

    public void popularComboBoxTematiques() throws Exception {
        List<HashMap<Object,Object>> tematiques = controller.getAllTematiques();
        System.out.println("Tematiques: "+tematiques);
        String s = comboBox_main_tematica.getPromptText();
        comboBox_main_tematica.getItems().add(s);

        String nom=null;
        for (HashMap<Object,Object> tematica: tematiques) {
            if(tematica.get("nom")!=null){nom=(String) tematica.get("nom");}
            comboBox_main_tematica.getItems().add(nom);
        }

        //añadir el listener del combobox
        comboBox_main_tematica.valueProperty().addListener(new ChangeListener<String>() {
            //OPCIÓN-1 -> asignar listener para que se ejecute cuando detecte el cambio
            @Override public void changed(ObservableValue classObject, String oldValue, String newValue) {
                System.out.println("TODO: Filtrar rutas por Localitat: "+newValue);
                //TODO: extensión de popular la lista de Rutas
            }
        });
    }
    public void onButtonIzqResetFiltresClick(){
        this.popularObresAudiovisualsPerNom();

        //reset filtro ComboBox1 Comarcas
        //Object stringNameOfComboBoxComarcas = comboBox_main_comarca.getValue();
        //System.out.println("stringNameOfComboBoxComarcas:"+stringNameOfComboBoxComarcas);
        //actualizar el combobox por ese stringValue
        Object str_default_ComboBox_comarcas = comboBox_main_tipus.getPromptText();
        //System.out.println("str_default_ComboBox_comarcas:"+str_default_ComboBox_comarcas);
        comboBox_main_tipus.setValue(str_default_ComboBox_comarcas);

        //reset filtro ComboBox2 Localitat
        //Object stringNameOfComboBoxLocalitat = comboBox_main_localitat.getValue();
        //System.out.println("stringNameOfComboBoxLocalitat:"+stringNameOfComboBoxLocalitat);
        //actualizar el combobox por ese stringValue
        Object str_default_ComboBox_localitat = comboBox_main_tematica.getPromptText();
        //System.out.println("str_default_ComboBox_localitat:"+str_default_ComboBox_localitat);
        comboBox_main_tematica.setValue(str_default_ComboBox_localitat);
    }

    public void onButtonPuntsClick(){
        System.out.println("Presionado Punts");
        //TODO OPT Pràctica 4: Si heu fet valorar, prement aquest botó s'activa i desactiva
        //TODO l'opcio de fer Top10 de les valoracions fetes per usuaris enlloc de la llista de WatchNext
    }
    public void onButtonImdbClick(){
        System.out.println("Presionado boton imdb");
        //TODO OPT Pràctica 4: Si heu fet valorar, prement aquest botó s'activa i desactiva
        //TODO l'opcio de fer Top10 de les valoracions imBD enlloc de la llista de WatchNext
    }


    public void onButtonGestionarGrupsClick() throws Exception {
        Escena escena = EscenaFactory.INSTANCE.creaEscena("perfil-view", "Perfil");
        EscenaPerfil escenaPerfil = ((EscenaPerfil)escena);
        escenaPerfil.setController(controller);
        escenaPerfil.start();
        Persona persona = controller.findClientCartera(controller.getSessionMemory().getCorreuPersona());
        persona.addObserver(escenaPerfil);
    }

    public static class DataTop {
        //Cal deixar aquests atributs com finals per poder popular la taula quan el mètode  la cridi
        private final SimpleStringProperty nom;
        private final SimpleStringProperty value;
        DataTop(String nom_param, Integer value_param){
            this.nom = new SimpleStringProperty(nom_param);
            this.value = new SimpleStringProperty(value_param.toString());
        }
        //métodos getters
        public String getNom() {
            return nom.get();
        }
        public String getValue() {
            return value.get();
        }
    }
}