package factory;

import domain.Covid19Patient;
import domain.Medicament;

public class Main {

    public static void main(String[] args) {
        Covid19Patient p1 = new Covid19Patient("aitor", 35);
        Medicament m= new Medicament("ibuprofeno");
        PatientSymptomGUI p= new PatientSymptomGUI(p1);
        MedicalGUI mgui=new MedicalGUI(m);
    }
}