package adapter;

import domain.Covid19Patient;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Covid19PatientAdapter implements InvertedIterator{
    NavigableSet<Object> reverselist= new TreeSet<>();
    Iterator<Object> reverse=reverselist.descendingIterator();
    Covid19Patient p;

    public Covid19PatientAdapter(Covid19Patient p){
        this.p = p;
        this.reverselist.addAll(p.getSymptoms());
    }

    @Override
    public Object previous() {
        return reverse.next();
    }

    @Override
    public boolean hasPrevious() {
        return reverse.hasNext();
    }

    @Override
    public void goLast() {
        this.reverselist.addAll(p.getSymptoms());
    }
}
