package observer;

import java.awt.Color;
import java.awt.Frame;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;


public class SemaphorGUI extends JFrame implements Observer{
	/** stores the associated ConcreteSubject */
	public SemaphorGUI (Observable patient) {
		setSize(100, 100);
		setLocation(350,10);
		Color c=Color.green;
		getContentPane().setBackground(c);
		repaint();
		setVisible(true);
		patient.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		Covid19Patient p=(Covid19Patient)o;
		Color c;
		double current=p.covidImpact();
		if (current<5) c=Color.green;
		else if (current<=10) c=Color.yellow;
		else c=Color.red;
		getContentPane().setBackground(c);
		repaint();
	}
}

