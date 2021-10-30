package factory;

import domain.Symptom;

import java.util.Iterator;
import java.util.Set;

public class GetSymptomByName implements GetSymptom{
    Set<Symptom> symptoms;

    public GetSymptomByName(Set<Symptom> symptoms) {
        this.symptoms = symptoms;
    }

    @Override
    public Symptom getSymptom(String symptomName) {
        Iterator<Symptom> i = symptoms.iterator();
        Symptom s = null;
        while (i.hasNext()) {
            s = i.next();
            if (s != null && s.getName().equals(symptomName)) return s;
        }
        return null;
    }
}
