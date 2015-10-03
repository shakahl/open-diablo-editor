package uk.me.karlsen.ode_gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uk.me.karlsen.ode.UniqueMonsterStore;

public class UniqueMonstersListener implements ActionListener {

	UniqueMonsterStore store;
	
	public UniqueMonstersListener(UniqueMonsterStore store) {
		this.store = store;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String actionCommand = e.getActionCommand();
		// TODO Auto-generated method stub
		
	}

}
