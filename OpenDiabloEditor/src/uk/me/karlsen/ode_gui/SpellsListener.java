package uk.me.karlsen.ode_gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uk.me.karlsen.ode.BaseMonsterStore;
import uk.me.karlsen.ode.CharacterStore;
import uk.me.karlsen.ode.QuestStore;
import uk.me.karlsen.ode.SpellsStore;

public class SpellsListener implements ActionListener {

	SpellsStore store;
	
	public SpellsListener(SpellsStore store) {
		this.store = store;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String actionCommand = e.getActionCommand();
		// TODO Auto-generated method stub
		
	}

}
