package ub.edu.model;

import java.util.Observable;
import java.util.Observer;

public interface SubjectObserver {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(Observable observable, String message);
}
