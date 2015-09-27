package uk.me.karlsen.ode_gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uk.me.karlsen.ode.BaseMonsterStore;

public class BaseMonstersListener implements ActionListener {

	BaseMonsterStore baseMonsterStore;
	
	public BaseMonstersListener(BaseMonsterStore baseMonsterStore) {
		this.baseMonsterStore = baseMonsterStore;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String actionCommand = e.getActionCommand();
		// TODO Auto-generated method stub
		
	}

}
