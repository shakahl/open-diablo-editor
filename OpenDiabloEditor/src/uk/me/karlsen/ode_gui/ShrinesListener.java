package uk.me.karlsen.ode_gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uk.me.karlsen.ode.BaseMonsterStore;
import uk.me.karlsen.ode.CharacterStore;
import uk.me.karlsen.ode.ShrinesStore;

public class ShrinesListener implements ActionListener {

	ShrinesStore shrinesStore;
	
	public ShrinesListener(ShrinesStore shrinesStore) {
		this.shrinesStore = shrinesStore;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String actionCommand = e.getActionCommand();
		// TODO Auto-generated method stub
		
	}

}
