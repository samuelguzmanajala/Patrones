package factory;

import domain.Symptom;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SymptomFactory {
    public static Symptom createSymptom(String symptomName) {
        List<String> impact5 = Arrays.asList("fiebre", "tos seca", "astenia", "expectoracion");
        List<Double> index5 = Arrays.asList(87.9, 67.7, 38.1, 33.4);
        List<String> impact3 = Arrays.asList("disnea", "dolor de garganta", "cefalea", "milagia",
                "escalofrios");
        List<Double> index3 = Arrays.asList(18.6, 13.9, 13.6, 14.8, 11.4);
        List<String> impact1 = Arrays.asList("nauseas", "vomitos", "congestion nasal", "diarrea",
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
