package observer;

import java.util.Observable;

public class Main {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
		Observable patient=new Covid19Patient("aitor", 35);
        Observable patient2=new Covid19Patient("Javier", 25);

        new PatientObserverGUI (patient);
        new PatientThermometerGUI (patient);
        new SemaphorGUI(patient);
        new PatientSymptomGUI ((Covid19Patient) patient);
    }

}
