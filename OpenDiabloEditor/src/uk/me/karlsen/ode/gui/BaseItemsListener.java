package uk.me.karlsen.ode.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import uk.me.karlsen.ode.stores.BaseItemStore;
import uk.me.karlsen.ode.types.BaseItem;

public class BaseItemsListener implements ActionListener {

	BaseItemStore baseItemStore;
	
	public BaseItemsListener(BaseItemStore baseItemStore) {
		this.baseItemStore = baseItemStore;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		JComboBox comboBox = (JComboBox) e.getSource();
        String itemName = (String) comboBox.getSelectedItem();
        JPanel baseItemsPanel = (JPanel) comboBox.getParent();
        if(itemName.equals("None selected")){
        	//do nothing
        } else {
        	String[] itemNameSplit = itemName.split(":");
        	int itemIndex = Integer.parseInt(itemNameSplit[0].substring(5, itemNameSplit[0].length()));
        	BaseItem bi = baseItemStore.getItem(itemIndex);        	
        }
	}

}
