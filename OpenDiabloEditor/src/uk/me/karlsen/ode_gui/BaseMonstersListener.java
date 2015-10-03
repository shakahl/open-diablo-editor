package uk.me.karlsen.ode_gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import uk.me.karlsen.ode.BaseMonsterStore;

public class BaseMonstersListener implements ActionListener {

	BaseMonsterStore baseMonsterStore;
	
	public BaseMonstersListener(BaseMonsterStore baseMonsterStore) {
		this.baseMonsterStore = baseMonsterStore;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String actionCommand = e.getActionCommand();
		
		if(actionCommand.equals("itemComboBox")){
			JComboBox<String> itemComboBox = (JComboBox<String>) e.getSource();
		}
		
	}

}
