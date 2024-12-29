package ub.edu.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.HashMap;
import java.util.List;

public class EscenaPerfil extends Escena {

    public TableView tableAllgroups;
    public TableColumn nomAllGroupsColumna;

    public TableView tableFollowingGroups;
    public TableColumn nomFollowingGroupsColumna;
    public TableView tableMemberGroups;
    public TableColumn nomMemberGroupsColumna;


    private String correuPersona;
    public Button groupsToFollow;
    public Button followToMember;
    public Button memberToFollow;
    public Button followToGroups;


    public void start() throws Exception{

        this.correuPersona = controller.getSessionMemory().getCorreuPersona();
        initData();
    }


    private void initData(){

        popularTaulaAllGroups();
        popularTaulaFollowingGroups();
        popularTaulaMemberGroups();
    }

    private void popularTaulaMemberGroups() {
        // TODO Pràctica 4: Cal que el mètode visualitzarMemberGroupsPerPersona estigui implementat
        List<HashMap<Object,Object>> listaObres = controller.visualitzarMemberGrupsPerPersona(correuPersona);
        if (listaObres!=null) {
            nomMemberGroupsColumna.setCellValueFactory(new PropertyValueFactory<DataList, String>("nom"));
            tableMemberGroups.getItems().clear();
            for (HashMap<Object, Object> obra : listaObres) {
                String nom = (String) obra.get("nom");
                tableMemberGroups.getItems().add(new
                        DataList(nom)
                );
            }
        }

    }

    private void popularTaulaFollowingGroups() {
        // TODO Pràctica 4: Cal que el mètode visualitzarFollowingGroupsPerPersona estigui implementat
        List<HashMap<Object,Object>> listaObres = controller.visualitzarFollowingGrupsPerPersona(correuPersona);

        if (listaObres!=null) {
            nomFollowingGroupsColumna.setCellValueFactory(new PropertyValueFactory<DataList, String>("nom"));
            tableFollowingGroups.getItems().clear();
            for (HashMap<Object, Object> obra : listaObres) {
                String nom = (String) obra.get("nom");
                tableFollowingGroups.getItems().add(new
                        DataList(nom)
                );
            }
        }

    }


    public static class DataList {
        //Cal deixar aquests atributs com finals per poder popular la taula quan el mètode  la cridi
        private final SimpleStringProperty nom;
        DataList(String nom_param){
            this.nom = new SimpleStringProperty(nom_param);
        }
        //métodos getters
        public String getNom() {
            return nom.get();
        }
    }

    private void popularTaulaAllGroups() {
        List<HashMap<Object,Object>> listaObres = controller.visualitzarGrupsPerNom();
        nomAllGroupsColumna.setCellValueFactory(new PropertyValueFactory<DataList, String>("nom"));
        tableAllgroups.getItems().clear();
        for (HashMap<Object,Object> obra : listaObres) {
            String nom = (String) obra.get("nom");
            tableAllgroups.getItems().add(new
                    DataList(nom)
            );
        }
    }


    public void onBtnGroupToFollow() {
        // TODO Pràctica 4: Cal afegir el grup a grups seguits
        if (tableAllgroups.getSelectionModel().getSelectedItem() != null){
            DataList selected = (DataList) tableAllgroups.getSelectionModel().getSelectedItem();
            String nomGrup = selected.getNom();
            // TODO Pràctica 4: Cal implementar el mètode per
            controller.getSessionMemory().setNomGrup(nomGrup);
            controller.addFollower2Grup(controller.getSessionMemory().getCorreuPersona(), nomGrup);

            try {
                Escena escena = EscenaFactory.INSTANCE.creaEscena("MenuAccessos-view", "Selecciona una opció");
                EscenaMenuAccessos escenaM = ((EscenaMenuAccessos)escena);
                escenaM.setController(controller);
                escenaM.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            // TODO Pràctica 4: cal també controlar les situacions possibles d'error i
            // TODO mostrar-les per la finestra d'alertes
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Selecciona un grup");
            alert.showAndWait();
        }
    }

    public void OnBtnFollowToGroup() {
        // TODO OPT Pràctica 4: Botó de deixar de seguir al grup
    }

    public void OnBtnMemberToFollow() {
        //TODO OPT Pràctica 4: Botó de deixar de ser membre del grup
    }


    public void onBtnFollowToMember() throws Exception {
        if (tableFollowingGroups.getSelectionModel().getSelectedItem() != null){
            DataList selected = (DataList) tableFollowingGroups.getSelectionModel().getSelectedItem();
            String nomGrup = selected.getNom();
            controller.getSessionMemory().setNomGrup(nomGrup);
            Escena escena = EscenaFactory.INSTANCE.creaEscena("MenuAccessos-view", "Selecciona una opció");
            EscenaMenuAccessos escenaM = ((EscenaMenuAccessos)escena);
            escenaM.setController(controller);
            escenaM.start();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Selecciona un grup");
            alert.showAndWait();
        }
    }








}
