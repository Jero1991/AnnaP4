package ub.edu.model.cataleg;

import java.util.Observable;
import ub.edu.view.EscenaMain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WhatNext extends Observable {

    Map<ContingutDigital, String> whatNext;

    public WhatNext() {
        whatNext = new HashMap<>();
    }

    public void afegirWhatNextContent(ContingutDigital c) {
        LocalDateTime date = LocalDateTime.now();
        //afegir a la whatnext només si no sha acabat de veure el contingut
        if (!c.isFinished()) {
            whatNext.put(c, date.toString());
        }

    }

    public Map<ContingutDigital, String> getWhatNext() {
        return whatNext;
    }

    public ArrayList<ContingutDigital> getContingutDigital() {
        return new ArrayList<>(whatNext.keySet());
    }

}
