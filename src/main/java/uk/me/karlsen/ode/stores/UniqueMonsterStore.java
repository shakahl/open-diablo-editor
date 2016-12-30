package uk.me.karlsen.ode.stores;

import java.util.ArrayList;
import java.util.List;

import uk.me.karlsen.ode.ReaderWriter;
import uk.me.karlsen.ode.TomeOfKnowledge;
import uk.me.karlsen.ode.types.UniqueMonster;

public class UniqueMonsterStore {

	List<UniqueMonster> uniqueMonsters;

	public UniqueMonsterStore(ReaderWriter rw) {
		uniqueMonsters = new ArrayList<UniqueMonster>();
		this.readInUniques(rw);
	}

	public void readInUniques(ReaderWriter rw) {
		long pos = TomeOfKnowledge.UNIQUE_MONSTERS_OFFSET;
		rw.seek(pos);
		for(int i = 0; i < TomeOfKnowledge.NUMBER_OF_UNIQUE_MONSTERS; i++){
			byte[] monsterBytes = new byte[TomeOfKnowledge.UNIQUE_MONSTER_LENGTH_IN_BYTES];
			monsterBytes = rw.readBytes(TomeOfKnowledge.UNIQUE_MONSTER_LENGTH_IN_BYTES);
			UniqueMonster um = new UniqueMonster(monsterBytes, rw);
			uniqueMonsters.add(um);
			pos = pos + TomeOfKnowledge.UNIQUE_MONSTER_LENGTH_IN_BYTES;
			rw.seek(pos);
		}
	}

	public void printUniques() {
		for(UniqueMonster um : uniqueMonsters){
			um.printUniqueMonster();
		}

	}

	public byte[] getUniqueAsBytes(int i) {
		return uniqueMonsters.get(i).getUniqueAsBytes();
	}

	public void writeMonstersToEXE(ReaderWriter writer) {
		long pos = TomeOfKnowledge.UNIQUE_MONSTERS_OFFSET;
		for(int i = 0; i < TomeOfKnowledge.NUMBER_OF_UNIQUE_MONSTERS; i++){
			byte[] uniqueAsBytes = this.getUniqueAsBytes(i);
			writer.writeBytes(uniqueAsBytes, pos);
			pos = pos + TomeOfKnowledge.UNIQUE_MONSTER_LENGTH_IN_BYTES;
		}

	}

	public String[] getMonsterNames() {
		String[] monsterNames = new String[uniqueMonsters.size()];
		for(int i = 0; i < uniqueMonsters.size(); i++){
			monsterNames[i] = uniqueMonsters.get(i).getName();
		}
		return monsterNames;
	}

	public UniqueMonster getMonsterByName(String monsterName) {
		UniqueMonster monsterToReturn = null;
		for(UniqueMonster m : uniqueMonsters)
		{
			if(m.getName().equals(monsterName))
			{
				monsterToReturn = m;
				break;
			}
		}
		return monsterToReturn;
	}

}
