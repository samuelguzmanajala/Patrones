package adapter;

import domain.Covid19Patient;
import domain.Symptom;

import java.util.Comparator;

public class SortByName implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Symptom p1= (Symptom) o1;
        Symptom p2= (Symptom) o2;
        return p1.getName().compareTo(p2.getName());
    }
}
