package factory;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.Medicament;
import domain.Symptom;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class  MedicalGUI extends JFrame {	

	private JPanel contentPane;
	private JButton btnRemoveSymptom;
	private JLabel errorLabel;
	private JTextField symptonNameField;
	private JLabel reportLabel;
	private Medicament m;
	private JLabel medicamentLabel;

	
	/**
	 * Create the frame.
	 */
	public MedicalGUI(Medicament med) {
		setTitle("Medical treatments");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectSymptom = new JLabel("Symptoms that can be treated by: ");
		lblSelectSymptom.setBounds(32, 17, 229, 16);
		contentPane.add(lblSelectSymptom);
		
		JLabel lblSymptomWeight = new JLabel("Symptom name ");
		lblSymptomWeight.setBounds(32, 68, 125, 16);
		contentPane.add(lblSymptomWeight);
		
		
		JButton btnNewButton = new JButton("to add to ...");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String symptomName=symptonNameField.getText();
					addSymptom(m, symptomName);
			}
		});
		btnNewButton.setBounds(32, 202, 173, 29);
		contentPane.add(btnNewButton);
		
		btnRemoveSymptom = new JButton("to remove from ...");
		btnRemoveSymptom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				errorLabel.setText(" ");

				String symptomName=symptonNameField.getText();
				removeSymptom(symptomName);

				
			} 
		});
		btnRemoveSymptom.setBounds(217, 202, 185, 29);
		contentPane.add(btnRemoveSymptom);
		
		errorLabel = new JLabel("");
		errorLabel.setBounds(117, 146, 238, 16);
		contentPane.add(errorLabel);
		
		symptonNameField = new JTextField();
		symptonNameField.setBounds(195, 63, 130, 26);
		contentPane.add(symptonNameField);
		symptonNameField.setColumns(10);
		
		 reportLabel = new JLabel("");
		reportLabel.setBounds(42, 263, 360, 114);
		contentPane.add(reportLabel);
		
		medicamentLabel = new JLabel("");
		medicamentLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		medicamentLabel.setBounds(257, 17, 187, 16);
		contentPane.add(medicamentLabel);
		medicamentLabel.setText(med.getName());
		m=med;
		this.setVisible(true);
		
	}
	
	public void addSymptom(Medicament m, String symptonName) {
		Symptom s;
		
		  if (m.getSymptomByName(symptonName)==null) {
				s=m.addSymptomByName(symptonName);
				if (s!=null) {
					errorLabel.setText("Symptom added: "+symptonName);
					reportLabel.setText(createReport());
				} else errorLabel.setText("ERROR, Symptom "+symptonName+ " does not exist ");
		  } 
		  else errorLabel.setText("ERROR, Symptom "+symptonName+" already assigned ");
		  
	}
	
	public void removeSymptom(String symptomName) {
		if (m.getSymptomByName(symptomName)!=null) {
			m.removeSymptomByName(symptomName);
			errorLabel.setText("Symptom removed :"+symptomName);
			reportLabel.setText(createReport());

		
	     } else errorLabel.setText("ERROR, Symptom does not exist");
	}
	
	public String createReport() {
		Iterator<Symptom> i=m.getSymptoms();
	    Symptom p2;
	    String s="<html>Symptoms: <br>";
	    while (i.hasNext()) {
	    	 p2=i.next();
	    	 if (p2!=null) s=s+p2.toString()+"<br>";	
	    }
	    s=s+"</html>";
        return s;	}
	

}

