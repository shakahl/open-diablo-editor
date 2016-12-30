package uk.me.karlsen.ode.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uk.me.karlsen.ode.stores.ShrinesStore;
import uk.me.karlsen.ode.types.Quest;
import uk.me.karlsen.ode.types.Shrine;

public class ShrinesPanel extends JPanel {

	private ShrinesStore shrineStore;
	
	public ShrinesPanel(ShrinesStore shrineStore)
	{
		super();
		
		this.shrineStore = shrineStore;
		
		GridLayout layout = new GridLayout(0,2);
		this.setLayout(layout);
		
		String[] shrineNames = shrineStore.getShrineNames();
		String[] comboBoxStrings = new String[shrineNames.length + 1]; 
		comboBoxStrings[0] = "None selected";
		System.arraycopy(shrineNames, 0, comboBoxStrings, 1, shrineNames.length);
		JComboBox<String> comboBox = new JComboBox<String>(comboBoxStrings);
		comboBox.setSelectedIndex(0);
	
		JLabel cbLabel = new JLabel("Shrine selected:");
		this.add(cbLabel);
		this.add(comboBox);
		
		JLabel shrineIndexLabel = new JLabel("Shrine index:");
		JTextField shrineIndexField = new JTextField();
		this.add(shrineIndexLabel);
		this.add(shrineIndexField);
		
		JLabel shrineNameLabel = new JLabel("Shrine name:");
		JTextField shrineNameField = new JTextField();
		this.add(shrineNameLabel);
		this.add(shrineNameField);
		
		JLabel shrinePointerLabel = new JLabel("Shrine pointer:");
		JTextField shrinePointerField = new JTextField();
		this.add(shrinePointerLabel);
		this.add(shrinePointerField);
		
		JLabel minShrineLevelLabel = new JLabel("Min shrine level:");
		JTextField minShrineLevelField = new JTextField();
		this.add(minShrineLevelLabel);
		this.add(minShrineLevelField);
		
		JLabel maxShrineLevelLabel = new JLabel("Max shrine level:");
		JTextField maxShrineLevelField = new JTextField();
		this.add(maxShrineLevelLabel);
		this.add(maxShrineLevelField);
		
		JLabel gameTypesInWhichPresentLabel = new JLabel("Game types in which present:");
		JTextField gameTypesInWhichPresentField = new JTextField();
		this.add(gameTypesInWhichPresentLabel);
		this.add(gameTypesInWhichPresentField);
		
		ActionListener shrinesListener = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String shrineName = (String) comboBox.getSelectedItem();
				if(shrineName.equals("None selected")){
					shrineIndexField.setText("");
					shrineNameField.setText("");
					shrinePointerField.setText("");
					minShrineLevelField.setText("");
					maxShrineLevelField.setText("");
					gameTypesInWhichPresentField.setText("");
				} else {
					Shrine shrine = shrineStore.getShrineByName(shrineName);
					shrineIndexField.setText(String.valueOf(shrine.getShrineIndex()));
					shrineNameField.setText(String.valueOf(shrine.getShrineName()));
					shrinePointerField.setText(String.valueOf(shrine.getShrinePointer()));
					minShrineLevelField.setText(String.valueOf(shrine.getMinShrineLevel()));
					maxShrineLevelField.setText(String.valueOf(shrine.getMaxShrineLevel()));
					gameTypesInWhichPresentField.setText(String.valueOf(shrine.getGameTypesInWhichPresent()));					
				}
			}
			
		};
		comboBox.addActionListener(shrinesListener);
		
		JButton saveButton = new JButton("Store changes");
		this.add(saveButton);
		
		ActionListener saveClick = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String shrineName = (String) comboBox.getSelectedItem();
				if(shrineName.equals("None selected")){
					//Do nothing
				} else {
					Shrine shrine = shrineStore.getShrineByName(shrineName);
					shrine.setShrineIndex(Integer.parseInt(shrineIndexField.getText()));
					shrine.setShrineName(shrineNameField.getText());
					shrine.setShrinePointer(Long.parseLong(shrinePointerField.getText()));
					shrine.setMinShrineLevel(Integer.parseInt(minShrineLevelField.getText()));
					shrine.setMaxShrineLevel(Integer.parseInt(maxShrineLevelField.getText()));
					shrine.setGameTypesInWhichPresent(Integer.parseInt(gameTypesInWhichPresentField.getText()));
				}
			}
		};
		saveButton.addActionListener(saveClick);
	}
	
	
}
