package ub.edu.model.cataleg;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WhatNext {

    Map<ContingutDigital, String> whatNext;

    public WhatNext() {
        whatNext = new HashMap<>();
    }

    public void afegirWhatNextContent(int year, int month, int day, ContingutDigital c) {
        LocalDateTime date = LocalDateTime.of(year, month, day, 0, 0);
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
