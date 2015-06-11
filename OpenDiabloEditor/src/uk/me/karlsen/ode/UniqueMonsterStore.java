package uk.me.karlsen.ode;

import java.util.ArrayList;
import java.util.List;

public class UniqueMonsterStore {

	ReaderWriter rw;
	List<UniqueMonster> uniqueMonsters;

	public UniqueMonsterStore(ReaderWriter rw) {
		this.rw = rw;
		uniqueMonsters = new ArrayList<UniqueMonster>();
		this.readInUniques();
	}

	public void readInUniques() {
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
			um.printItem();
		}

	}

	public byte[] getUniqueAsBytes(int i) {
		return uniqueMonsters.get(i).getUniqueAsBytes();
	}

	public void writeMonstersToEXE() {
		long pos = TomeOfKnowledge.UNIQUE_MONSTERS_OFFSET;
		for(int i = 0; i < TomeOfKnowledge.NUMBER_OF_UNIQUE_MONSTERS; i++){
			byte[] uniqueAsBytes = this.getUniqueAsBytes(i);
			rw.writeBytes(uniqueAsBytes, pos);
			pos = pos + TomeOfKnowledge.UNIQUE_MONSTER_LENGTH_IN_BYTES;
		}

	}

}
