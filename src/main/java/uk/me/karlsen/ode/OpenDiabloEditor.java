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

		//#################################################
		//#      HERE WE READ IN DATA AND SET UP WRITER   #
		//#################################################

		reader = new ReaderWriter("Diablo.exe", true);

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String newPath = "Diablo_MODE_" + dateFormat.format(date) + ".exe";
		ReaderWriter writer = new ReaderWriter("Diablo.exe", newPath);

		questStore = new QuestStore(writer);
		spellStore = new SpellsStore(writer);
		shrineStore = new ShrinesStore(writer);
		modifierStore = new ItemModifiersStore(writer);
		uniqueItemStore = new UniqueItemStore(writer);
		characterStore = new CharacterStore(writer);
		baseItemStore = new BaseItemStore(writer);
		baseMonsterStore = new BaseMonsterStore(writer);
		uniqueMonsterStore = new UniqueMonsterStore(writer);


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
		
		shrineStore.writeShrinesToEXE();
		questStore.writeQuestsToEXE();
		spellStore.writeSpellsToEXE();
		modifierStore.writeModifiersToEXE();
		uniqueItemStore.writeItemsToEXE();
		characterStore.writeCharactersToEXE();
		baseItemStore.writeItemsToEXE();
		baseMonsterStore.writeMonstersToEXE();
		uniqueMonsterStore.writeMonstersToEXE();
	}
}
