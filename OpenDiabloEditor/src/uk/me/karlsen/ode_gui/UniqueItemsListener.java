package uk.me.karlsen.ode_gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uk.me.karlsen.ode.BaseMonsterStore;
import uk.me.karlsen.ode.CharacterStore;
import uk.me.karlsen.ode.QuestStore;
import uk.me.karlsen.ode.UniqueItemStore;

public class UniqueItemsListener implements ActionListener {

	UniqueItemStore store;
	
	public UniqueItemsListener(UniqueItemStore store) {
		this.store = store;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String actionCommand = e.getActionCommand();
		// TODO Auto-generated method stub
		
	}

}
