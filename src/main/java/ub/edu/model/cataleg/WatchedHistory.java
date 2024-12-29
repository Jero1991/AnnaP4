package ub.edu.model.cataleg;


import java.util.Observable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class WatchedHistory extends Observable {

    Map<ContingutDigital, String> watchedHistory;

    public WatchedHistory() {
        watchedHistory = new HashMap<>();
    }

    public void afegirWatchedContent(ContingutDigital c, String date) {
        if (watchedHistory.containsKey(c)) {
            System.out.println("Aquest contingut ja està a la WatchedHistory");
        } else {
            watchedHistory.put(c, date);
            System.out.println(c.getNom() + " afegit a la WatchedHistory");
            setChanged();
            notifyObservers("watchedHistory");
        }
    }

    public ArrayList<ContingutDigital> getContingutDigital() {
        return new ArrayList<>(watchedHistory.keySet());
    }

    public Map<ContingutDigital, String> getWatchedHistory() {
        return watchedHistory;
    }
}
