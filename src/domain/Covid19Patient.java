package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;

public class Covid19Patient {
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
        Iterator<Symptom> i = getSymptoms().iterator();
        Symptom s = null;
        while (i.hasNext()) {
            s = i.next();
            if (s != null && s.getName().equals(symptomName)) return s;
        }
        return null;
    }

    public Symptom addSymptomByName(String symptom, Integer w) {
        Symptom s = getSymptomByName(symptom);
        if (s == null) {
            s = createSymptom(symptom);
            symptoms.put(s, w);
        }
        return s;
    }

    public Symptom removeSymptomByName(String symptomName) {
        Symptom s = getSymptomByName(symptomName);
        System.out.println("Simptom to remove: " + s);
        if (s != null) symptoms.remove(s);
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
        List<String> impact5 = Arrays.asList("fiebre", "tos seca", "astenia", "expectoracion");
        List<Double> index5 = Arrays.asList(87.9, 67.7, 38.1, 33.4);
        List<String> impact3 = Arrays.asList("disnea", "dolor de garganta", "cefalea", "milagia",
                "escalofrios");
        List<Double> index3 = Arrays.asList(18.6, 13.9, 13.6, 14.8, 11.4);
        List<String> impact1 = Arrays.asList("nauseas", "v�mitos", "congesti�n nasal", "diarrea",
                "hemoptisis", "congestion conjuntival");
        List<Double> index1 = Arrays.asList(5.0, 4.8, 3.7, 0.9, 0.8);
        int impact = 0;
        double index = 0;
        if (impact5.contains(symptomName)) {
            impact = 5;
            index = index5.get(impact5.indexOf(symptomName));
        } else if (impact3.contains(symptomName)) {
            impact = 3;
            index = index3.get(impact3.indexOf(symptomName));
        } else if (impact1.contains(symptomName)) {
            impact = 1;
            index = index1.get(impact1.indexOf(symptomName));
        }

        if (impact != 0) return new Symptom(symptomName, (int) index, impact);
        else return null;
    }
}

