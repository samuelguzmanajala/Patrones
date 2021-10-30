package observer;

import domain.Symptom;
import factory.GetSymptom;
import factory.GetSymptomByName;
import factory.SymptomFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Set;

public class Covid19Patient extends Observable {
    private String name;
    private int age;
    private Map<Symptom, Integer> symptoms = new HashMap<Symptom, Integer>();

    public Covid19Patient(String name, int years) {
        this.name = name;
        this.age = years;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight(Symptom s) {
        return symptoms.get(s);
    }

    public Set<Symptom> getSymptoms() {
        return symptoms.keySet();
    }

    public Symptom getSymptomByName(String symptomName) {
        GetSymptom symptoms = new GetSymptomByName(getSymptoms());
        return symptoms.getSymptom(symptomName);
    }

    public Symptom addSymptomByName(String symptom, Integer w) {

        Symptom s = getSymptomByName(symptom);
        if (s == null) {
            s = createSymptom(symptom);
            symptoms.put(s, w);
        }
        setChanged();
        notifyObservers();
        return s;

    }

    public Symptom removeSymptomByName(String symptomName) {
        Symptom s = getSymptomByName(symptomName);
        System.out.println("Simptom to remove: " + s);
        if (s != null) symptoms.remove(s);
        setChanged();
        notifyObservers();
        return s;
    }

    public double covidImpact() {
        double afection = 0;
        double increment = 0;
        double impact = 0;

        //calculate afection
        for (Symptom c : symptoms.keySet()) {
            System.out.println("Sintomas" + c);
            afection = afection + c.getSeverityIndex() * symptoms.get(c);
        }
        afection = afection / symptoms.size();

        //calculate increment
        if (getAge() > 65) increment = afection * 0.5;

        //calculate impact
        impact = afection + increment;
        return impact;
    }

    private Symptom createSymptom(String symptomName) {
        return SymptomFactory.createSymptom(symptomName);
    }

}

