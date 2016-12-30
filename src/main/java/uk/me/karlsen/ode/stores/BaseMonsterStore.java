package uk.me.karlsen.ode.stores;

import java.util.ArrayList;
import java.util.List;

import uk.me.karlsen.ode.ReaderWriter;
import uk.me.karlsen.ode.TomeOfKnowledge;
import uk.me.karlsen.ode.types.BaseMonster;
import uk.me.karlsen.ode.types.MonsterAsBytes;

public class BaseMonsterStore {

	private ReaderWriter rw;
	private List<BaseMonster> baseMonsters;

	public BaseMonsterStore(ReaderWriter rw) {
		this.rw = rw;
		baseMonsters = new ArrayList<BaseMonster>();
		this.readInMonsters();
	}

	public void readInMonsters() {
		long pos = TomeOfKnowledge.MONSTER_ACTIVATION_BYTES_OFFSET;
		rw.seek(pos);
		byte[] activationBytes = rw.readBytes(TomeOfKnowledge.NUMBER_OF_BASE_MONSTERS);
		pos = TomeOfKnowledge.BASE_MONSTERS_OFFSET;
		rw.seek(pos);
		for(int i = 0; i < TomeOfKnowledge.NUMBER_OF_BASE_MONSTERS; i++){
			byte[] monsterBytes = new byte[TomeOfKnowledge.BASE_MONSTER_LENGTH_IN_BYTES];
			monsterBytes = rw.readBytes(TomeOfKnowledge.BASE_MONSTER_LENGTH_IN_BYTES);
			BaseMonster bm = new BaseMonster(i, monsterBytes, activationBytes[i], rw);
			baseMonsters.add(bm);
			pos = pos + TomeOfKnowledge.BASE_MONSTER_LENGTH_IN_BYTES;
			rw.seek(pos);
		}
	}

	public MonsterAsBytes getMonsterAsBytes(int index){
		return baseMonsters.get(index).getMonsterAsBytes();
	}

	public void printMonsters() {
		for(BaseMonster bm : baseMonsters){
			bm.printMonster();
		}

	}

	public void writeMonstersToEXE() {
		long pos = TomeOfKnowledge.BASE_MONSTERS_OFFSET;
		long posTwo = TomeOfKnowledge.MONSTER_ACTIVATION_BYTES_OFFSET;
		for(BaseMonster bm : baseMonsters){
			MonsterAsBytes mab = bm.getMonsterAsBytes();
			byte[] mainBytes = mab.getMainBytes();
			byte monsterActivationByte = mab.getEnabledByte();
			rw.writeBytes(mainBytes, pos);
			rw.writeByte(monsterActivationByte, posTwo);
			pos = pos + TomeOfKnowledge.BASE_MONSTER_LENGTH_IN_BYTES;
			posTwo = posTwo + 1; //activation bytes are next to each other
		}
	}

	public String[] getMonsterNames() {
		String[] monsterNames = new String[baseMonsters.size()];
		int monsterNamesIndex = 0;
		for(BaseMonster bm : baseMonsters){
			monsterNames[monsterNamesIndex] = bm.getName();
			monsterNamesIndex++;
		}
		return monsterNames;
	}

	public BaseMonster getMonsterByName(String monsterName) {
		BaseMonster baseMonsterToReturn = null;
		for(BaseMonster m : baseMonsters){
			if(m.getName().equals(monsterName)){
				baseMonsterToReturn = m;
				break;
			}
		}
		return baseMonsterToReturn;
	}

}
