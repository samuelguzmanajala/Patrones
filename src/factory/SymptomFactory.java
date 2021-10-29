package factory;

import domain.Symptom;

import java.util.HashMap;

public class SymptomFactory {
    private static HashMap<String, Symptom> registeredSymptoms=
            new HashMap<>();
    static {

    }
    public static void registerSymptom(String symptomID, Symptom symptom){
        registeredSymptoms.put(symptomID,symptom);
    }
    public static Symptom createSymptom(String pizzaID){
        return registeredSymptoms.get(pizzaID);
    }
}
