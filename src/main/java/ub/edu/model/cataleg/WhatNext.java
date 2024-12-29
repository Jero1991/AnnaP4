package ub.edu.model.cataleg;

import java.util.*;

import ub.edu.view.EscenaMain;

import java.time.LocalDateTime;

public class WhatNext extends Observable implements Observer {

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

    public void update(Observable o, Object arg) {
        if (o instanceof WatchedHistory) {
            WatchedHistory wh = (WatchedHistory) o;
            if (arg instanceof String) {
                if (arg.equals("watchedHistory")) {
                    System.out.println("WhatNext ha rebut un canvi de WatchedHistory");
                    populateWhatNext(wh);
                }
            }
        }
    }

    //all the elements of one will be delivered to the other
    private void populateWhatNext(WatchedHistory wh) {
        Map<ContingutDigital, String> watched = wh.getWatchedHistory();
        //we add all the mapped elements to the whatnext
        for (Map.Entry<ContingutDigital, String> entry : watched.entrySet()) {
            ContingutDigital c = entry.getKey();
            //if (!c.isFinished()) {
                whatNext.put(c, entry.getValue());
            //}
        }
        setChanged();
        notifyObservers("whatNext");
    }
}
