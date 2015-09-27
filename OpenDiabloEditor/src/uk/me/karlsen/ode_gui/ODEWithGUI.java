package uk.me.karlsen.ode_gui;

import javax.swing.SwingUtilities;

import uk.me.karlsen.ode.BaseItemStore;
import uk.me.karlsen.ode.BaseMonsterStore;
import uk.me.karlsen.ode.CharacterStore;
import uk.me.karlsen.ode.ItemModifiersStore;
import uk.me.karlsen.ode.QuestStore;
import uk.me.karlsen.ode.ReaderWriter;
import uk.me.karlsen.ode.ShrinesStore;
import uk.me.karlsen.ode.SpellsStore;
import uk.me.karlsen.ode.UniqueItemStore;
import uk.me.karlsen.ode.UniqueMonsterStore;

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
