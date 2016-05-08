package uk.me.karlsen.ode;

import java.text.SimpleDateFormat;
import java.util.Date;

import uk.me.karlsen.ode.stores.BaseItemStore;
import uk.me.karlsen.ode.stores.BaseMonsterStore;
import uk.me.karlsen.ode.stores.CharacterStore;
import uk.me.karlsen.ode.stores.ItemModifiersStore;
import uk.me.karlsen.ode.stores.QuestStore;
import uk.me.karlsen.ode.stores.ShrinesStore;
import uk.me.karlsen.ode.stores.SpellsStore;
import uk.me.karlsen.ode.stores.UniqueItemStore;
import uk.me.karlsen.ode.stores.UniqueMonsterStore;

public class OpenDiabloEditor {

	private ReaderWriter reader;

	QuestStore questStore;
	SpellsStore spellStore;
	ShrinesStore shrineStore;
	ItemModifiersStore modifierStore;
	UniqueItemStore uniqueItemStore;
	CharacterStore characterStore;
	BaseItemStore baseItemStore;
	BaseMonsterStore baseMonsterStore;
	UniqueMonsterStore uniqueMonsterStore;

	public static void main(String[] args){
		OpenDiabloEditor dm = new OpenDiabloEditor();
		dm.run();
	}

	public void run(){

		//####################################
		//#      HERE WE READ IN DATA        #
		//####################################

		reader = new ReaderWriter("input/Diablo.exe");

		questStore = new QuestStore(reader);
		spellStore = new SpellsStore(reader);
		shrineStore = new ShrinesStore(reader);
		modifierStore = new ItemModifiersStore(reader);
		uniqueItemStore = new UniqueItemStore(reader);
		characterStore = new CharacterStore(reader);
		baseItemStore = new BaseItemStore(reader);
		baseMonsterStore = new BaseMonsterStore(reader);
		uniqueMonsterStore = new UniqueMonsterStore(reader);


		//####################################
		//# HERE WE SHOW YOU STUFF TO CHANGE #
		//####################################


		//Uncomment the ones you want to see when running the program...

		//questStore.printQuests();
		//spellStore.printSpells();
		//shrineStore.printShrines();
		//modifierStore.printModifiers();
		//uniqueItemStore.printItems();
		//characterStore.printCharacters();
		//baseItemStore.printItems();
		//baseMonsterStore.printMonsters();
		//uniqueMonsterStore.printUniques();


		//######################################################
		//# DO YOUR MODDING STUFF BELOW HERE -- EXAMPLES BELOW #
		//######################################################

		//v1
		//shrineStore.disableBadShrines();

		//v2
		//characterStore.setAllMaxStatsTo255();

		//v3
		//characterStore.setCharZeroStartingSkillBySpellID(2); //healing
		//characterStore.setCharOneStartingSkillBySpellID(9); //infravision (inner sight)
		//characterStore.setCharTwoStartingSkillBySpellID(5); //identify

		//v4 -- TODO
		//fix or disable yellow zombies
		//change name of infravision
		//make healing skill mana drain

		//####################################
		//# NOW WE WRITE TO DIABLO.EXE COPY  #
		//####################################

		writeAllData();
	}

	private void writeAllData() {
		
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String newPath = "output/Diablo_MODE_" + dateFormat.format(date) + ".exe";
		ReaderWriter writer = new ReaderWriter("input/Diablo.exe", newPath);
		
		shrineStore.writeShrinesToEXE(writer);
		questStore.writeQuestsToEXE(writer);
		spellStore.writeSpellsToEXE(writer);
		modifierStore.writeModifiersToEXE(writer);
		uniqueItemStore.writeItemsToEXE(writer);
		characterStore.writeCharactersToEXE(writer);
		baseItemStore.writeItemsToEXE(writer);
		baseMonsterStore.writeMonstersToEXE(writer);
		uniqueMonsterStore.writeMonstersToEXE(writer);
	}
}
