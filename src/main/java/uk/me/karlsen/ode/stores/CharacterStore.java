package uk.me.karlsen.ode.stores;

import java.util.ArrayList;
import java.util.List;

import uk.me.karlsen.ode.ReaderWriter;
import uk.me.karlsen.ode.TomeOfKnowledge;
import uk.me.karlsen.ode.types.Character;
import uk.me.karlsen.ode.utils.BinEditHelper;

public class CharacterStore {

	private Character char0;
	private Character char1;
	private Character char2;
	private List<Character> characters;
	
	private ReaderWriter rw;

	public CharacterStore(ReaderWriter rw) {
		this.rw = rw;
		characters = new ArrayList<Character>();
		this.readInCharacters();
	}

	//TODO -- make this code more concise
	public void readInCharacters() {
		
		byte[] startingStats;
		byte[] maxStats;
		byte[] blockingBonuses;
		byte[] bonusesAndFramesets;
		
		long pos = TomeOfKnowledge.MIN_STATS_OFFSET;
		rw.seek(pos);
		startingStats = new byte[TomeOfKnowledge.MIN_STATS_LENGTH_IN_BYTES];
		for(int j = 0; j < TomeOfKnowledge.MIN_STATS_LENGTH_IN_BYTES; j++){
			startingStats[j] = rw.readByte();
			pos++;
			rw.seek(pos);
		}

		BinEditHelper beh = new BinEditHelper(rw);
		long initWarriorStrength = beh.convertFourBytesToNumber(startingStats, 0);
		long initRogueStrength = beh.convertFourBytesToNumber(startingStats, 4);
		long initSorcStrength = beh.convertFourBytesToNumber(startingStats, 8);
		long initWarriorMagic = beh.convertFourBytesToNumber(startingStats, 12);
		long initRogueMagic = beh.convertFourBytesToNumber(startingStats, 16);
		long initSorcMagic = beh.convertFourBytesToNumber(startingStats, 20);
		long initWarriorDexterity = beh.convertFourBytesToNumber(startingStats, 24);
		long initRogueDexterity = beh.convertFourBytesToNumber(startingStats, 28);
		long initSorcDexterity = beh.convertFourBytesToNumber(startingStats, 32);
		long initWarriorVitality = beh.convertFourBytesToNumber(startingStats, 36);
		long initRogueVitality = beh.convertFourBytesToNumber(startingStats, 40);
		long initSorcVitality = beh.convertFourBytesToNumber(startingStats, 44);

		pos = TomeOfKnowledge.MAX_STATS_OFFSET;
		rw.seek(pos);
		maxStats = new byte[TomeOfKnowledge.MAX_STATS_LENGTH_IN_BYTES];
		for(int j = 0; j < TomeOfKnowledge.MAX_STATS_LENGTH_IN_BYTES; j++){
			maxStats[j] = rw.readByte();
			pos++;
			rw.seek(pos);
		}

		long maxWarriorStrength = beh.convertFourBytesToNumber(maxStats, 0);
		long maxWarriorMagic = beh.convertFourBytesToNumber(maxStats, 4);
		long maxWarriorDexterity = beh.convertFourBytesToNumber(maxStats, 8);
		long maxWarriorVitality = beh.convertFourBytesToNumber(maxStats, 12);
		long maxRogueStrength = beh.convertFourBytesToNumber(maxStats, 16);
		long maxRogueMagic = beh.convertFourBytesToNumber(maxStats, 20);
		long maxRogueDexterity = beh.convertFourBytesToNumber(maxStats, 24);
		long maxRogueVitality = beh.convertFourBytesToNumber(maxStats, 28);
		long maxSorcStrength = beh.convertFourBytesToNumber(maxStats, 32);
		long maxSorcMagic = beh.convertFourBytesToNumber(maxStats, 36);
		long maxSorcDexterity = beh.convertFourBytesToNumber(maxStats, 40);
		long maxSorcVitality = beh.convertFourBytesToNumber(maxStats, 44);

		pos = TomeOfKnowledge.BLOCKING_BONUSES_OFFSET;
		rw.seek(pos);
		blockingBonuses = new byte[TomeOfKnowledge.BLOCKING_BONUSES_LENGTH_IN_BYTES];
		for(int j = 0; j < TomeOfKnowledge.BLOCKING_BONUSES_LENGTH_IN_BYTES; j++){
			blockingBonuses[j] = rw.readByte();
			pos++;
			rw.seek(pos);
		}

		long warriorBlockingBonus = beh.convertFourBytesToNumber(blockingBonuses, 0);
		long rogueBlockingBonus = beh.convertFourBytesToNumber(blockingBonuses, 4);
		long sorcBlockingBonus = beh.convertFourBytesToNumber(blockingBonuses, 8);

		pos = TomeOfKnowledge.BONUSES_AND_FRAMESETS_OFFSET;
		rw.seek(pos);
		bonusesAndFramesets = new byte[TomeOfKnowledge.BONUSES_AND_FRAMESETS_LENGTH_IN_BYTES];
		for(int j = 0; j < TomeOfKnowledge.BONUSES_AND_FRAMESETS_LENGTH_IN_BYTES; j++){
			bonusesAndFramesets[j] = rw.readByte();
			pos++;
			rw.seek(pos);
		}

		/*
		0 	Idle frameset in the dungeon
		1 	Attacking frameset
		2 	Walking frameset in dungeon
		3 	Blocking speed
		4 	Death frameset
		5 	Frameset for magic casting
		6 	Hit recovery speed
		7 	Idle frameset in town
		8 	Walking frameset in town
		9 	Single handed weapon attacking speed
		10 	Spell casting speed
		*/

		int warriorDungeonIdleFrameset = beh.convertUnsignedByteToInt(bonusesAndFramesets[0]);
		int warriorAttackingFrameset = beh.convertUnsignedByteToInt(bonusesAndFramesets[1]);
		int warriorDungeonWalkFrameset = beh.convertUnsignedByteToInt(bonusesAndFramesets[2]);
		int warriorBlockSpeed = beh.convertUnsignedByteToInt(bonusesAndFramesets[3]);
		int warriorDeathFrameset = beh.convertUnsignedByteToInt(bonusesAndFramesets[4]);
		int warriorCastingFrameset = beh.convertUnsignedByteToInt(bonusesAndFramesets[5]);
		int warriorHitRecoverySpeed = beh.convertUnsignedByteToInt(bonusesAndFramesets[6]);
		int warriorTownIdleFrameset = beh.convertUnsignedByteToInt(bonusesAndFramesets[7]);
		int warriorTownWalkFrameset = beh.convertUnsignedByteToInt(bonusesAndFramesets[8]);
		int warrior1hAttackSpeed = beh.convertUnsignedByteToInt(bonusesAndFramesets[9]);
		int warriorCastingSpeed = beh.convertUnsignedByteToInt(bonusesAndFramesets[10]);
		
		int rogueDungeonIdleFrameset = beh.convertUnsignedByteToInt(bonusesAndFramesets[11]);
		int rogueAttackingFrameset = beh.convertUnsignedByteToInt(bonusesAndFramesets[12]);
		int rogueDungeonWalkFrameset = beh.convertUnsignedByteToInt(bonusesAndFramesets[13]);
		int rogueBlockSpeed = beh.convertUnsignedByteToInt(bonusesAndFramesets[14]);
		int rogueDeathFrameset = beh.convertUnsignedByteToInt(bonusesAndFramesets[15]);
		int rogueCastingFrameset = beh.convertUnsignedByteToInt(bonusesAndFramesets[16]);
		int rogueHitRecoverySpeed = beh.convertUnsignedByteToInt(bonusesAndFramesets[17]);
		int rogueTownIdleFrameset = beh.convertUnsignedByteToInt(bonusesAndFramesets[18]);
		int rogueTownWalkFrameset = beh.convertUnsignedByteToInt(bonusesAndFramesets[19]);
		int rogue1hAttackSpeed = beh.convertUnsignedByteToInt(bonusesAndFramesets[20]);
		int rogueCastingSpeed = beh.convertUnsignedByteToInt(bonusesAndFramesets[21]);
		
		int sorcDungeonIdleFrameset = beh.convertUnsignedByteToInt(bonusesAndFramesets[22]);
		int sorcAttackingFrameset = beh.convertUnsignedByteToInt(bonusesAndFramesets[23]);
		int sorcDungeonWalkFrameset = beh.convertUnsignedByteToInt(bonusesAndFramesets[24]);
		int sorcBlockSpeed = beh.convertUnsignedByteToInt(bonusesAndFramesets[25]);
		int sorcDeathFrameset = beh.convertUnsignedByteToInt(bonusesAndFramesets[26]);
		int sorcCastingFrameset = beh.convertUnsignedByteToInt(bonusesAndFramesets[27]);
		int sorcHitRecoverySpeed = beh.convertUnsignedByteToInt(bonusesAndFramesets[28]);
		int sorcTownIdleFrameset = beh.convertUnsignedByteToInt(bonusesAndFramesets[29]);
		int sorcTownWalkFrameset = beh.convertUnsignedByteToInt(bonusesAndFramesets[30]);
		int sorc1hAttackSpeed = beh.convertUnsignedByteToInt(bonusesAndFramesets[31]);
		int sorcCastingSpeed = beh.convertUnsignedByteToInt(bonusesAndFramesets[32]);

		//Creating characters
		char0 = new Character();
		char0.setClassName("Warrior");
		char0.setInitStrength(initWarriorStrength);
		char0.setInitMagic(initWarriorMagic);
		char0.setInitDexterity(initWarriorDexterity);
		char0.setInitVitality(initWarriorVitality);
		char0.setMaxStrength(maxWarriorStrength);
		char0.setMaxMagic(maxWarriorMagic);
		char0.setMaxDexterity(maxWarriorDexterity);
		char0.setMaxVitality(maxWarriorVitality);
		char0.setBlockingBonus(warriorBlockingBonus);
		char0.setDungeonIdleFrameset(warriorDungeonIdleFrameset);
		char0.setAttackingFrameset(warriorAttackingFrameset);
		char0.setDungeonWalkFrameset(warriorDungeonWalkFrameset);
		char0.setBlockSpeed(warriorBlockSpeed);
		char0.setDeathFrameset(warriorDeathFrameset);
		char0.setCastingFrameset(warriorCastingFrameset);
		char0.setHitRecoverySpeed(warriorHitRecoverySpeed);
		char0.setTownIdleFrameset(warriorTownIdleFrameset);
		char0.setTownWalkFrameset(warriorTownWalkFrameset);
		char0.setOneHandedAttackSpeed(warrior1hAttackSpeed);
		char0.setCastingSpeed(warriorCastingSpeed);

		char1 = new Character();
		char1.setClassName("Rogue");
		char1.setInitStrength(initRogueStrength);
		char1.setInitMagic(initRogueMagic);
		char1.setInitDexterity(initRogueDexterity);
		char1.setInitVitality(initRogueVitality);
		char1.setMaxStrength(maxRogueStrength);
		char1.setMaxMagic(maxRogueMagic);
		char1.setMaxDexterity(maxRogueDexterity);
		char1.setMaxVitality(maxRogueVitality);
		char1.setBlockingBonus(rogueBlockingBonus);
		char1.setDungeonIdleFrameset(rogueDungeonIdleFrameset);
		char1.setAttackingFrameset(rogueAttackingFrameset);
		char1.setDungeonWalkFrameset(rogueDungeonWalkFrameset);
		char1.setBlockSpeed(rogueBlockSpeed);
		char1.setDeathFrameset(rogueDeathFrameset);
		char1.setCastingFrameset(rogueCastingFrameset);
		char1.setHitRecoverySpeed(rogueHitRecoverySpeed);
		char1.setTownIdleFrameset(rogueTownIdleFrameset);
		char1.setTownWalkFrameset(rogueTownWalkFrameset);
		char1.setOneHandedAttackSpeed(rogue1hAttackSpeed);
		char1.setCastingSpeed(rogueCastingSpeed);

		char2 = new Character();
		char2.setClassName("Sorceror");
		char2.setInitStrength(initSorcStrength);
		char2.setInitMagic(initSorcMagic);
		char2.setInitDexterity(initSorcDexterity);
		char2.setInitVitality(initSorcVitality);
		char2.setMaxStrength(maxSorcStrength);
		char2.setMaxMagic(maxSorcMagic);
		char2.setMaxDexterity(maxSorcDexterity);
		char2.setMaxVitality(maxSorcVitality);
		char2.setBlockingBonus(sorcBlockingBonus);
		char2.setDungeonIdleFrameset(sorcDungeonIdleFrameset);
		char2.setAttackingFrameset(sorcAttackingFrameset);
		char2.setDungeonWalkFrameset(sorcDungeonWalkFrameset);
		char2.setBlockSpeed(sorcBlockSpeed);
		char2.setDeathFrameset(sorcDeathFrameset);
		char2.setCastingFrameset(sorcCastingFrameset);
		char2.setHitRecoverySpeed(sorcHitRecoverySpeed);
		char2.setTownIdleFrameset(sorcTownIdleFrameset);
		char2.setTownWalkFrameset(sorcTownWalkFrameset);
		char2.setOneHandedAttackSpeed(sorc1hAttackSpeed);
		char2.setCastingSpeed(sorcCastingSpeed);

		characters.add(char0);
		characters.add(char1);
		characters.add(char2);
	}

	//TODO -- make this code more concise
	public byte[] getInitStatBytes(){
		BinEditHelper beh = new BinEditHelper(rw);
		byte[] returnedStartingStats = new byte[TomeOfKnowledge.MIN_STATS_LENGTH_IN_BYTES];
		long warriorInitStrength = char0.getInitStrength();
		beh.setLongAsFourBytes(warriorInitStrength, returnedStartingStats, 0);
		long rogueInitStrength = char1.getInitStrength();
		beh.setLongAsFourBytes(rogueInitStrength, returnedStartingStats, 4);
		long sorcInitStrength = char2.getInitStrength();
		beh.setLongAsFourBytes(sorcInitStrength, returnedStartingStats, 8);
		long warriorInitMagic = char0.getInitMagic();
		beh.setLongAsFourBytes(warriorInitMagic, returnedStartingStats, 12);
		long rogueInitMagic = char1.getInitMagic();
		beh.setLongAsFourBytes(rogueInitMagic, returnedStartingStats, 16);
		long sorcInitMagic = char2.getInitMagic();
		beh.setLongAsFourBytes(sorcInitMagic, returnedStartingStats, 20);
		long warriorInitDex = char0.getInitDexterity();
		beh.setLongAsFourBytes(warriorInitDex, returnedStartingStats, 24);
		long rogueInitDex = char1.getInitDexterity();
		beh.setLongAsFourBytes(rogueInitDex, returnedStartingStats, 28);
		long sorcInitDex = char2.getInitDexterity();
		beh.setLongAsFourBytes(sorcInitDex, returnedStartingStats, 32);
		long warriorInitVit = char0.getInitVitality();
		beh.setLongAsFourBytes(warriorInitVit, returnedStartingStats, 36);
		long rogueInitVit = char1.getInitVitality();
		beh.setLongAsFourBytes(rogueInitVit, returnedStartingStats, 40);
		long sorcInitVit = char2.getInitVitality();
		beh.setLongAsFourBytes(sorcInitVit, returnedStartingStats, 44);
		return returnedStartingStats;
	}

	//TODO -- make this code more concise
	public byte[] getMaxStatBytes(){
		BinEditHelper beh = new BinEditHelper(rw);
		byte[] maxStats = new byte[TomeOfKnowledge.MAX_STATS_LENGTH_IN_BYTES];
		long warriorMaxStrength = char0.getMaxStrength();
		beh.setLongAsFourBytes(warriorMaxStrength, maxStats, 0);
		long warriorMaxMagic = char0.getMaxMagic();
		beh.setLongAsFourBytes(warriorMaxMagic, maxStats, 4);
		long warriorMaxDex = char0.getMaxDexterity();
		beh.setLongAsFourBytes(warriorMaxDex, maxStats, 8);
		long warriorMaxVit = char0.getMaxVitality();
		beh.setLongAsFourBytes(warriorMaxVit, maxStats, 12);
		long rogueMaxStrength = char1.getMaxStrength();
		beh.setLongAsFourBytes(rogueMaxStrength, maxStats, 16);
		long rogueMaxMagic = char1.getMaxMagic();
		beh.setLongAsFourBytes(rogueMaxMagic, maxStats, 20);
		long rogueMaxDex = char1.getMaxDexterity();
		beh.setLongAsFourBytes(rogueMaxDex, maxStats, 24);
		long rogueMaxVit = char1.getMaxVitality();
		beh.setLongAsFourBytes(rogueMaxVit, maxStats, 28);
		long sorcMaxStrength = char2.getMaxStrength();
		beh.setLongAsFourBytes(sorcMaxStrength, maxStats, 32);
		long sorcMaxMagic = char2.getMaxMagic();
		beh.setLongAsFourBytes(sorcMaxMagic, maxStats, 36);
		long sorcMaxDex = char2.getMaxDexterity();
		beh.setLongAsFourBytes(sorcMaxDex, maxStats, 40);
		long sorcMaxVit = char2.getMaxVitality();
		beh.setLongAsFourBytes(sorcMaxVit, maxStats, 44);
		return maxStats;
	}

	//TODO -- make this code more concise
	public byte[] getBlockingBonusBytes(){
		BinEditHelper beh = new BinEditHelper(rw);
		byte[] blockingBonuses = new byte[TomeOfKnowledge.BLOCKING_BONUSES_LENGTH_IN_BYTES];
		long warriorBlockingBonus = char0.getBlockingBonus();
		beh.setLongAsFourBytes(warriorBlockingBonus, blockingBonuses, 0);
		long rogueBlockingBonus = char1.getBlockingBonus();
		beh.setLongAsFourBytes(rogueBlockingBonus, blockingBonuses, 4);
		long sorcBlockingBonus = char2.getBlockingBonus();
		beh.setLongAsFourBytes(sorcBlockingBonus, blockingBonuses, 8);
		return blockingBonuses;
	}

	//TODO -- make this code more concise
	public byte[] getBonusesAndFramesetBytes(){
		byte[] bonusesAndFramesets = new byte[TomeOfKnowledge.BONUSES_AND_FRAMESETS_LENGTH_IN_BYTES];
		bonusesAndFramesets[0] = (byte) char0.getDungeonIdleFrameset();
		bonusesAndFramesets[1] = (byte) char0.getAttackingFrameset();
		bonusesAndFramesets[2] = (byte) char0.getDungeonWalkFrameset();
		bonusesAndFramesets[3] = (byte) char0.getBlockSpeed();
		bonusesAndFramesets[4] = (byte) char0.getDeathFrameset();
		bonusesAndFramesets[5] = (byte) char0.getCastingFrameset();
		bonusesAndFramesets[6] = (byte) char0.getHitRecoverySpeed();
		bonusesAndFramesets[7] = (byte) char0.getTownIdleFrameset();
		bonusesAndFramesets[8] = (byte) char0.getTownWalkFrameset();
		bonusesAndFramesets[9] = (byte) char0.getOneHandedAttackSpeed();
		bonusesAndFramesets[10] = (byte) char0.getCastingSpeed();
		bonusesAndFramesets[11] = (byte) char1.getDungeonIdleFrameset();
		bonusesAndFramesets[12] = (byte) char1.getAttackingFrameset();
		bonusesAndFramesets[13] = (byte) char1.getDungeonWalkFrameset();
		bonusesAndFramesets[14] = (byte) char1.getBlockSpeed();
		bonusesAndFramesets[15] = (byte) char1.getDeathFrameset();
		bonusesAndFramesets[16] = (byte) char1.getCastingFrameset();
		bonusesAndFramesets[17] = (byte) char1.getHitRecoverySpeed();
		bonusesAndFramesets[18] = (byte) char1.getTownIdleFrameset();
		bonusesAndFramesets[19] = (byte) char1.getTownWalkFrameset();
		bonusesAndFramesets[20] = (byte) char1.getOneHandedAttackSpeed();
		bonusesAndFramesets[21] = (byte) char1.getCastingSpeed();
		bonusesAndFramesets[22] = (byte) char2.getDungeonIdleFrameset();
		bonusesAndFramesets[23] = (byte) char2.getAttackingFrameset();
		bonusesAndFramesets[24] = (byte) char2.getDungeonWalkFrameset();
		bonusesAndFramesets[25] = (byte) char2.getBlockSpeed();
		bonusesAndFramesets[26] = (byte) char2.getDeathFrameset();
		bonusesAndFramesets[27] = (byte) char2.getCastingFrameset();
		bonusesAndFramesets[28] = (byte) char2.getHitRecoverySpeed();
		bonusesAndFramesets[29] = (byte) char2.getTownIdleFrameset();
		bonusesAndFramesets[30] = (byte) char2.getTownWalkFrameset();
		bonusesAndFramesets[31] = (byte) char2.getOneHandedAttackSpeed();
		bonusesAndFramesets[32] = (byte) char2.getCastingSpeed();
		return bonusesAndFramesets;
	}

	public void printCharacters() {
		for(Character c : characters){
			c.printCharacter();
		}
	}

	public void writeCharactersToEXE() {

		byte[] retrievedInitStatBytes = this.getInitStatBytes();
		rw.writeBytes(retrievedInitStatBytes, TomeOfKnowledge.MIN_STATS_OFFSET);

		byte[] retrievedMaxStatBytes = this.getMaxStatBytes();
		rw.writeBytes(retrievedMaxStatBytes, TomeOfKnowledge.MAX_STATS_OFFSET);

		byte[] retrievedBlockingBonusBytes = this.getBlockingBonusBytes();
		rw.writeBytes(retrievedBlockingBonusBytes, TomeOfKnowledge.BLOCKING_BONUSES_OFFSET);

		byte[] retrievedBonusesAndFramesetBytes = this.getBonusesAndFramesetBytes();
		rw.writeBytes(retrievedBonusesAndFramesetBytes, TomeOfKnowledge.BONUSES_AND_FRAMESETS_OFFSET);
	}

	public Character getCharacter(int i) {
		return characters.get(i);
	}

	public void setAllMaxStatsTo255() {
		for(Character c : characters){
			c.setMaxDexterity(255);
			c.setMaxMagic(255);
			c.setMaxStrength(255);
			c.setMaxVitality(255);
		}
	}

	//TODO -- The 3 methods below are "tacked on". Integrate them better.
	//FIXME -- broken due to change in the approach of reading/writing files
	public void setCharZeroStartingSkillBySpellID(int i) {
		long l = i;
		byte[] spellID = new byte[4];
		spellID[0] = (byte)(l >>>  0);
		spellID[1] = (byte)(l >>>  8);
		spellID[2] = (byte)(l >>> 16);
		spellID[3] = (byte)(l >>> 24);
		String[] spellNames = TomeOfKnowledge.createSpellNamesArray();
		String spellName = spellNames[i];
		byte[][] skillBytes = TomeOfKnowledge.createSkillBytesArray();
		byte[] bytesToUse = skillBytes[i];
//		rw.writeBytes(bytesToUse, TomeOfKnowledge.CHARACTER_ZERO_SKILL_LOC_1);
//		rw.writeBytes(bytesToUse, TomeOfKnowledge.CHARACTER_ZERO_SKILL_LOC_2);
//		rw.writeBytes(spellID, TomeOfKnowledge.CHARACTER_ZERO_SPELL_LOC_1);
	}

	//FIXME -- broken due to change in the approach of reading/writing files
	public void setCharOneStartingSkillBySpellID(int i) {
		long l = i;
		byte[] spellID = new byte[4];
		spellID[0] = (byte)(l >>>  0);
		spellID[1] = (byte)(l >>>  8);
		spellID[2] = (byte)(l >>> 16);
		spellID[3] = (byte)(l >>> 24);
		String[] spellNames = TomeOfKnowledge.createSpellNamesArray();
		String spellName = spellNames[i];
		byte[][] skillBytes = TomeOfKnowledge.createSkillBytesArray();
		byte[] bytesToUse = skillBytes[i];
//		rw.writeBytes(bytesToUse, TomeOfKnowledge.CHARACTER_ONE_SKILL_LOC_1);
//		rw.writeBytes(bytesToUse, TomeOfKnowledge.CHARACTER_ONE_SKILL_LOC_2);
//		rw.writeBytes(spellID, TomeOfKnowledge.CHARACTER_ONE_SPELL_LOC_1);

	}

	//FIXME -- broken due to change in the approach of reading/writing files
	public void setCharTwoStartingSkillBySpellID(int i) {
		long l = i;
		byte[] spellID = new byte[4];
		spellID[0] = (byte)(l >>>  0);
		spellID[1] = (byte)(l >>>  8);
		spellID[2] = (byte)(l >>> 16);
		spellID[3] = (byte)(l >>> 24);
		String[] spellNames = TomeOfKnowledge.createSpellNamesArray();
		String spellName = spellNames[i];
		byte[][] skillBytes = TomeOfKnowledge.createSkillBytesArray();
		byte[] bytesToUse = skillBytes[i];
//		rw.writeBytes(bytesToUse, TomeOfKnowledge.CHARACTER_TWO_SKILL_LOC_1);
//		rw.writeBytes(bytesToUse, TomeOfKnowledge.CHARACTER_TWO_SKILL_LOC_2);
//		rw.writeBytes(spellID, TomeOfKnowledge.CHARACTER_TWO_SPELL_LOC_1);
	}

	public String[] getCharacterNames() {
		String[] charNames = new String[3];
		charNames[0] = characters.get(0).getClassName();
		charNames[1] = characters.get(1).getClassName();
		charNames[2] = characters.get(2).getClassName();
		return charNames;
	}

	public Character getCharacterByName(String charName) {
		Character characterSelected = null;
		for(Character c : characters){
			if(c.getClassName().equals(charName)){
				characterSelected = c;
			}
		}
		return characterSelected;
	}

}
