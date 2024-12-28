package ub.edu.resources.dao.MOCK.entities;

import ub.edu.model.Persona;
import ub.edu.resources.dao.entities.DAOPersona;

import java.util.*;

public class DAOPersonaMOCK implements DAOPersona {

    private Map<String, Persona> xarxaPersones = new HashMap<>();

    public DAOPersonaMOCK() {
        addPersona("ajaleo@gmail.com", "ajaleoPassw7");
        addPersona("dtomacal@yahoo.cat", "Qwertyft5");
        addPersona("heisenberg@gmail.com", "the1whoknocks");
        addPersona("rick@gmail.com", "wabalabadapdap22");
        addPersona("nietolopez10@gmail.com", "pekFD91m2a");
        addPersona("nancyarg10@yahoo.com", "contra10LOadc");
        addPersona("CapitaCC@gmail.com", "Alistar10");
        addPersona("nauin2@gmail.com", "kaynJGL20");
        addPersona("juancarlos999@gmail.com", "staIamsA12");
        addPersona("judit121@gmail.com", "Ordinador1");
    }

    private void addPersona(String nom, String pwd){
        xarxaPersones.put(nom, new Persona(nom, pwd));
    }

    @Override
    public List<Persona> getAll() {
        return new ArrayList<>(xarxaPersones.values());
    }

    @Override
    public Optional<Persona> getById(String[] id) {
        return Optional.ofNullable(xarxaPersones.get(Objects.requireNonNull(id[0], "Name cannot be null")));
    }

    @Override
    public boolean add(final Persona persona) {
        if (xarxaPersones.containsKey(persona.getName())) {
            return false;
        }
        xarxaPersones.put(persona.getName(), persona);
        return true;
    }

    @Override
    public boolean update(final Persona persona, String[] params) {
        persona.setName(Objects.requireNonNull(
                params[0], "Name cannot be null"));
        persona.setPwd(Objects.requireNonNull(
                params[1], "Password cannot be null"));
        return xarxaPersones.replace(persona.getName(), persona) != null;
    }

    @Override
    public boolean delete(final Persona persona) {
        return xarxaPersones.remove(persona.getName()) != null;
    }
}
