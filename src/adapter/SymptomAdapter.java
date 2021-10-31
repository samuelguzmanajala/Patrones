package adapter;

import domain.Symptom;
import factory.SymptomFactory;


import java.util.*;


public class SymptomAdapter implements InvertedIterator{
    ArrayList<Object> reverselist= new ArrayList<>();
    ListIterator reverseIterator;


    public SymptomAdapter(Set<Symptom> list) {
        this.reverselist.addAll(list);
        this.reverseIterator = reverselist.listIterator(0);
    }

    @Override
    public Object previous() {
        return reverseIterator.previous();
    }

    @Override
    public boolean hasPrevious() {
        return reverseIterator.hasPrevious();
    }

    @Override
    public void goLast() {
        this.reverseIterator = reverselist.listIterator(reverselist.size());
    }

}
