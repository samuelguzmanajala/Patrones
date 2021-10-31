package adapter;

import domain.Covid19Patient;
import domain.Symptom;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        String[] symptomNames= {"disnea", "dolor de garganta", "nauseas", "milagia", "escalofrios"};
        Covid19Patient p=
                new Covid19Patient("Aitor",35);
        p.addSymptomByName(symptomNames[0], 3);
        p.addSymptomByName(symptomNames[1],2);
        p.addSymptomByName(symptomNames[2], 2);
        p.addSymptomByName(symptomNames[3],1);
        p.addSymptomByName(symptomNames[4],1);

        Comparator<Object> comparatorName=new SortByName();
        Comparator<Object> comparatorSeverityIndex=new SortBySeverityIndex();

        InvertedIterator adapterIterator= new SymptomAdapter(p.getSymptoms());

        Iterator<Object> sortedIteratorByName= Sorting.sortedIterator
                (adapterIterator,comparatorName);
        Iterator<Object> sortedIteratorBySeverityIndex= Sorting.sortedIterator
                (adapterIterator,comparatorSeverityIndex);

        System.out.println("Lista ordenada por nombre: ");
        while (sortedIteratorByName.hasNext()){
            System.out.println(sortedIteratorByName.next().toString());
        }
        System.out.println();
        System.out.println("Lista ordenada por Indice de severidad: ");
        while (sortedIteratorBySeverityIndex.hasNext()){
            Object o=sortedIteratorBySeverityIndex.next();
            System.out.println(((Symptom) o).getName()+ " : " + ((Symptom) o).getSeverityIndex());
        }



    }
}
