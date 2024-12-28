package ub.edu.model;

import java.util.ArrayList;
import java.util.List;

public class CarteraPersones {

    private List<Persona> persones;

    public CarteraPersones() {
        persones = new ArrayList<>();
    }

    public CarteraPersones(List<Persona> persones) {
        this.persones = persones;
    }

    public Persona find(String username)  {
        for (Persona persona: persones) {
            if (persona.getName().equals(username))
                return persona;
        }
        return null;
    }

    public void add(Persona persona) {
        persones.add(persona);
    }

    public void clear() {
        persones.clear();
    }

    public void delete(String email) {
        for (Persona persona: persones) {
            if (persona.getName().equals(email)) {
                persones.remove(persona);
                return;
            }
        }
    }


    public int getNumPersones() {
        return persones.size();
    }

    public Persona getPersona(int i) {
        return persones.get(i);
    }

}
