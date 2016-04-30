package uk.me.karlsen.ode;

import javax.swing.SwingUtilities;

import uk.me.karlsen.ode.gui.GUI;
import uk.me.karlsen.ode.stores.BaseItemStore;
import uk.me.karlsen.ode.stores.BaseMonsterStore;
import uk.me.karlsen.ode.stores.CharacterStore;
import uk.me.karlsen.ode.stores.ItemModifiersStore;
import uk.me.karlsen.ode.stores.QuestStore;
import uk.me.karlsen.ode.stores.ShrinesStore;
import uk.me.karlsen.ode.stores.SpellsStore;
import uk.me.karlsen.ode.stores.UniqueItemStore;
import uk.me.karlsen.ode.stores.UniqueMonsterStore;

public class ODEWithGUI {

public static void main(String[] args){
		
		ReaderWriter rw = new ReaderWriter(false);

		QuestStore questStore = new QuestStore(rw);
		SpellsStore spellStore = new SpellsStore(rw);
		ShrinesStore shrineStore = new ShrinesStore(rw);
		ItemModifiersStore modifierStore = new ItemModifiersStore(rw);
		UniqueItemStore uniqueItemStore = new UniqueItemStore(rw);
		CharacterStore characterStore = new CharacterStore(rw);
		BaseItemStore baseItemStore = new BaseItemStore(rw);
		BaseMonsterStore baseMonsterStore = new BaseMonsterStore(rw);
		UniqueMonsterStore uniqueMonsterStore = new UniqueMonsterStore(rw);
		
		Runnable runnable = new Runnable() {
			public void run(){
				GUI gui = new GUI();
				gui.setQuestStore(questStore);
				gui.setSpellStore(spellStore);
				gui.setShrineStore(shrineStore);
				gui.setItemModifiersStore(modifierStore);
				gui.setUniqueItemStore(uniqueItemStore);
				gui.setCharacterStore(characterStore);
				gui.setBaseItemStore(baseItemStore);
				gui.setBaseMonsterStore(baseMonsterStore);
				gui.setUniqueMonsterStore(uniqueMonsterStore);;
				gui.displayGUI();
			}
		};
		SwingUtilities.invokeLater(runnable);
	}
}
