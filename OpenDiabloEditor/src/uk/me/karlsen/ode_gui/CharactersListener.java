package uk.me.karlsen.ode_gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uk.me.karlsen.ode.BaseMonsterStore;
import uk.me.karlsen.ode.CharacterStore;

public class CharactersListener implements ActionListener {

	CharacterStore characterStore;
	
	public CharactersListener(CharacterStore characterStore) {
		this.characterStore = characterStore;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String actionCommand = e.getActionCommand();
		// TODO Auto-generated method stub
		
	}

}
