package ub.edu.model;

import java.util.*;

public class ShowTVTimePersones {

    private CarteraPersones cartera;

    public ShowTVTimePersones(){
        cartera = new CarteraPersones();
    }
    public void setCarteraPersones (List<Persona> llistaC) {
        cartera = new CarteraPersones(llistaC);
    }
    public Persona findPersonaCartera(String string) throws Exception {
        try {
            return cartera.find(string);
        } catch (Exception e) {
            throw new Exception("No s'ha trobat la persona");
        }
    }

    public void addPersona(Persona persona) {
        cartera.add(persona);
    }

    public CarteraPersones getCarteraPersones() {
        return cartera;
    }

}
