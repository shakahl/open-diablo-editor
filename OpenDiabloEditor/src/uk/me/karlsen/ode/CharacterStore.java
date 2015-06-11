package uk.me.karlsen.ode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CharacterStore {

	ReaderWriter rw;
	Character char0;
	Character char1;
	Character char2;
	List<Character> characters;
	byte[] startingStats;
	byte[] maxStats;
	byte[] blockingBonuses;
	byte[] bonusesAndFramesets;

	public CharacterStore(ReaderWriter rw) {
		this.rw = rw;
		characters = new ArrayList<Character>();
		this.readInCharacters();
	}

	public void readInCharacters() {
		long pos = TomeOfKnowledge.MIN_STATS_OFFSET;
		rw.seek(pos);
		startingStats = new byte[48];
		for(int j = 0; j < 48; j++){
			startingStats[j] = rw.readByte();
			pos++;
			rw.seek(pos);
		}

		long initWarriorStrength = rw.convertFourBytesToNumber(startingStats[0], startingStats[1], startingStats[2], startingStats[3]);
		long initRogueStrength = rw.convertFourBytesToNumber(startingStats[4], startingStats[5], startingStats[6], startingStats[7]);
		long initSorcStrength = rw.convertFourBytesToNumber(startingStats[8], startingStats[9], startingStats[10], startingStats[11]);
		long initWarriorMagic = rw.convertFourBytesToNumber(startingStats[12], startingStats[13], startingStats[14], startingStats[15]);
		long initRogueMagic = rw.convertFourBytesToNumber(startingStats[16], startingStats[17], startingStats[18], startingStats[19]);
		long initSorcMagic = rw.convertFourBytesToNumber(startingStats[20], startingStats[21], startingStats[22], startingStats[23]);
		long initWarriorDexterity = rw.convertFourBytesToNumber(startingStats[24], startingStats[25], startingStats[26], startingStats[27]);
		long initRogueDexterity = rw.convertFourBytesToNumber(startingStats[28], startingStats[29], startingStats[30], startingStats[31]);
		long initSorcDexterity = rw.convertFourBytesToNumber(startingStats[32], startingStats[33], startingStats[34], startingStats[35]);
		long initWarriorVitality = rw.convertFourBytesToNumber(startingStats[36], startingStats[37], startingStats[38], startingStats[39]);
		long initRogueVitality = rw.convertFourBytesToNumber(startingStats[40], startingStats[41], startingStats[42], startingStats[43]);
		long initSorcVitality = rw.convertFourBytesToNumber(startingStats[44], startingStats[45], startingStats[46], startingStats[47]);

		pos = TomeOfKnowledge.MAX_STATS_OFFSET;
		rw.seek(pos);
		maxStats = new byte[48];
		for(int j = 0; j < 48; j++){
			maxStats[j] = rw.readByte();
			pos++;
			rw.seek(pos);
		}

		long maxWarriorStrength = rw.convertFourBytesToNumber(maxStats[0], maxStats[1], maxStats[2], maxStats[3]);
		long maxWarriorMagic = rw.convertFourBytesToNumber(maxStats[4], maxStats[5], maxStats[6], maxStats[7]);
		long maxWarriorDexterity = rw.convertFourBytesToNumber(maxStats[8], maxStats[9], maxStats[10], maxStats[11]);
		long maxWarriorVitality = rw.convertFourBytesToNumber(maxStats[12], maxStats[13], maxStats[14], maxStats[15]);
		long maxRogueStrength = rw.convertFourBytesToNumber(maxStats[16], maxStats[17], maxStats[18], maxStats[19]);
		long maxRogueMagic = rw.convertFourBytesToNumber(maxStats[20], maxStats[21], maxStats[22], maxStats[23]);
		long maxRogueDexterity = rw.convertFourBytesToNumber(maxStats[24], maxStats[25], maxStats[26], maxStats[27]);
		long maxRogueVitality = rw.convertFourBytesToNumber(maxStats[28], maxStats[29], maxStats[30], maxStats[31]);
		long maxSorcStrength = rw.convertFourBytesToNumber(maxStats[32], maxStats[33], maxStats[34], maxStats[35]);
		long maxSorcMagic = rw.convertFourBytesToNumber(maxStats[36], maxStats[37], maxStats[38], maxStats[39]);
		long maxSorcDexterity = rw.convertFourBytesToNumber(maxStats[40], maxStats[41], maxStats[42], maxStats[43]);
		long maxSorcVitality = rw.convertFourBytesToNumber(maxStats[44], maxStats[45], maxStats[46], maxStats[47]);

		pos = TomeOfKnowledge.BLOCKING_BONUSES_OFFSET;
		rw.seek(pos);
		blockingBonuses = new byte[12];
		for(int j = 0; j < 12; j++){
			blockingBonuses[j] = rw.readByte();
			pos++;
			rw.seek(pos);
		}

		long warriorBlockingBonus = rw.convertFourBytesToNumber(blockingBonuses[0], blockingBonuses[1], blockingBonuses[2], blockingBonuses[3]);
		long rogueBlockingBonus = rw.convertFourBytesToNumber(blockingBonuses[4], blockingBonuses[5], blockingBonuses[6], blockingBonuses[7]);
		long sorcBlockingBonus = rw.convertFourBytesToNumber(blockingBonuses[8], blockingBonuses[9], blockingBonuses[10], blockingBonuses[11]);

		pos = TomeOfKnowledge.BONUSES_AND_FRAMESETS_OFFSET;
		rw.seek(pos);
		bonusesAndFramesets = new byte[33];
		for(int j = 0; j < 33; j++){
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

		int warriorDungeonIdleFrameset = rw.convertUnsignedByteToInt(bonusesAndFramesets[0]);
		int warriorAttackingFrameset = rw.convertUnsignedByteToInt(bonusesAndFramesets[1]);
		int warriorDungeonWalkFrameset = rw.convertUnsignedByteToInt(bonusesAndFramesets[2]);
		int warriorBlockSpeed = rw.convertUnsignedByteToInt(bonusesAndFramesets[3]);
		int warriorDeathFrameset = rw.convertUnsignedByteToInt(bonusesAndFramesets[4]);
		int warriorCastingFrameset = rw.convertUnsignedByteToInt(bonusesAndFramesets[5]);
		int warriorHitRecoverySpeed = rw.convertUnsignedByteToInt(bonusesAndFramesets[6]);
		int warriorTownIdleFrameset = rw.convertUnsignedByteToInt(bonusesAndFramesets[7]);
		int warriorTownWalkFrameset = rw.convertUnsignedByteToInt(bonusesAndFramesets[8]);
		int warrior1hAttackSpeed = rw.convertUnsignedByteToInt(bonusesAndFramesets[9]);
		int warriorCastingSpeed = rw.convertUnsignedByteToInt(bonusesAndFramesets[10]);

		int rogueDungeonIdleFrameset = rw.convertUnsignedByteToInt(bonusesAndFramesets[11]);
		int rogueAttackingFrameset = rw.convertUnsignedByteToInt(bonusesAndFramesets[12]);
		int rogueDungeonWalkFrameset = rw.convertUnsignedByteToInt(bonusesAndFramesets[13]);
		int rogueBlockSpeed = rw.convertUnsignedByteToInt(bonusesAndFramesets[14]);
		int rogueDeathFrameset = rw.convertUnsignedByteToInt(bonusesAndFramesets[15]);
		int rogueCastingFrameset = rw.convertUnsignedByteToInt(bonusesAndFramesets[16]);
		int rogueHitRecoverySpeed = rw.convertUnsignedByteToInt(bonusesAndFramesets[17]);
		int rogueTownIdleFrameset = rw.convertUnsignedByteToInt(bonusesAndFramesets[18]);
		int rogueTownWalkFrameset = rw.convertUnsignedByteToInt(bonusesAndFramesets[19]);
		int rogue1hAttackSpeed = rw.convertUnsignedByteToInt(bonusesAndFramesets[20]);
		int rogueCastingSpeed = rw.convertUnsignedByteToInt(bonusesAndFramesets[21]);

		int sorcDungeonIdleFrameset = rw.convertUnsignedByteToInt(bonusesAndFramesets[22]);
		int sorcAttackingFrameset = rw.convertUnsignedByteToInt(bonusesAndFramesets[23]);
		int sorcDungeonWalkFrameset = rw.convertUnsignedByteToInt(bonusesAndFramesets[24]);
		int sorcBlockSpeed = rw.convertUnsignedByteToInt(bonusesAndFramesets[25]);
		int sorcDeathFrameset = rw.convertUnsignedByteToInt(bonusesAndFramesets[26]);
		int sorcCastingFrameset = rw.convertUnsignedByteToInt(bonusesAndFramesets[27]);
		int sorcHitRecoverySpeed = rw.convertUnsignedByteToInt(bonusesAndFramesets[28]);
		int sorcTownIdleFrameset = rw.convertUnsignedByteToInt(bonusesAndFramesets[29]);
		int sorcTownWalkFrameset = rw.convertUnsignedByteToInt(bonusesAndFramesets[30]);
		int sorc1hAttackSpeed = rw.convertUnsignedByteToInt(bonusesAndFramesets[31]);
		int sorcCastingSpeed = rw.convertUnsignedByteToInt(bonusesAndFramesets[32]);

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

	private byte[] getInitStatBytes(){
		byte[] startingStats = new byte[48];
		long warriorInitStrength = char0.getInitStrength();
		startingStats[0] = (byte)(warriorInitStrength >>>  0);
		startingStats[1] = (byte)(warriorInitStrength >>>  8);
		startingStats[2] = (byte)(warriorInitStrength >>> 16);
		startingStats[3] = (byte)(warriorInitStrength >>> 24);
		long rogueInitStrength = char1.getInitStrength();
		startingStats[4] = (byte)(rogueInitStrength >>>  0);
		startingStats[5] = (byte)(rogueInitStrength >>>  8);
		startingStats[6] = (byte)(rogueInitStrength >>> 16);
		startingStats[7] = (byte)(rogueInitStrength >>> 24);
		long sorcInitStrength = char2.getInitStrength();
		startingStats[8] = (byte)(sorcInitStrength >>>  0);
		startingStats[9] = (byte)(sorcInitStrength >>>  8);
		startingStats[10] = (byte)(sorcInitStrength >>> 16);
		startingStats[11] = (byte)(sorcInitStrength >>> 24);
		long warriorInitMagic = char0.getInitMagic();
		startingStats[12] = (byte)(warriorInitMagic >>>  0);
		startingStats[13] = (byte)(warriorInitMagic >>>  8);
		startingStats[14] = (byte)(warriorInitMagic >>> 16);
		startingStats[15] = (byte)(warriorInitMagic >>> 24);
		long rogueInitMagic = char1.getInitMagic();
		startingStats[16] = (byte)(rogueInitMagic >>>  0);
		startingStats[17] = (byte)(rogueInitMagic >>>  8);
		startingStats[18] = (byte)(rogueInitMagic >>> 16);
		startingStats[19] = (byte)(rogueInitMagic >>> 24);
		long sorcInitMagic = char2.getInitMagic();
		startingStats[20] = (byte)(sorcInitMagic >>>  0);
		startingStats[21] = (byte)(sorcInitMagic >>>  8);
		startingStats[22] = (byte)(sorcInitMagic >>> 16);
		startingStats[23] = (byte)(sorcInitMagic >>> 24);
		long warriorInitDex = char0.getInitDexterity();
		startingStats[24] = (byte)(warriorInitDex >>>  0);
		startingStats[25] = (byte)(warriorInitDex >>>  8);
		startingStats[26] = (byte)(warriorInitDex >>> 16);
		startingStats[27] = (byte)(warriorInitDex >>> 24);
		long rogueInitDex = char1.getInitDexterity();
		startingStats[28] = (byte)(rogueInitDex >>>  0);
		startingStats[29] = (byte)(rogueInitDex >>>  8);
		startingStats[30] = (byte)(rogueInitDex >>> 16);
		startingStats[31] = (byte)(rogueInitDex >>> 24);
		long sorcInitDex = char2.getInitDexterity();
		startingStats[32] = (byte)(sorcInitDex >>>  0);
		startingStats[33] = (byte)(sorcInitDex >>> 8);
		startingStats[34] = (byte)(sorcInitDex >>> 16);
		startingStats[35] = (byte)(sorcInitDex >>> 24);
		long warriorInitVit = char0.getInitVitality();
		startingStats[36] = (byte)(warriorInitVit >>>  0);
		startingStats[37] = (byte)(warriorInitVit >>>  8);
		startingStats[38] = (byte)(warriorInitVit >>> 16);
		startingStats[39] = (byte)(warriorInitVit >>> 24);
		long rogueInitVit = char1.getInitVitality();
		startingStats[40] = (byte)(rogueInitVit >>>  0);
		startingStats[41] = (byte)(rogueInitVit >>>  8);
		startingStats[42] = (byte)(rogueInitVit >>> 16);
		startingStats[43] = (byte)(rogueInitVit >>> 24);
		long sorcInitVit = char2.getInitVitality();
		startingStats[44] = (byte)(sorcInitVit >>>  0);
		startingStats[45] = (byte)(sorcInitVit >>>  8);
		startingStats[46] = (byte)(sorcInitVit >>> 16);
		startingStats[47] = (byte)(sorcInitVit >>> 24);
		return startingStats;
	}

	private byte[] getMaxStatBytes(){
		byte[] maxStats = new byte[48];
		long warriorMaxStrength = char0.getMaxStrength();
		maxStats[0] = (byte)(warriorMaxStrength >>>  0);
		maxStats[1] = (byte)(warriorMaxStrength >>>  8);
		maxStats[2] = (byte)(warriorMaxStrength >>> 16);
		maxStats[3] = (byte)(warriorMaxStrength >>> 24);
		long warriorMaxMagic = char0.getMaxMagic();
		maxStats[4] = (byte)(warriorMaxMagic >>>  0);
		maxStats[5] = (byte)(warriorMaxMagic >>>  8);
		maxStats[6] = (byte)(warriorMaxMagic >>> 16);
		maxStats[7] = (byte)(warriorMaxMagic >>> 24);
		long warriorMaxDex = char0.getMaxDexterity();
		maxStats[8] = (byte)(warriorMaxDex >>>  0);
		maxStats[9] = (byte)(warriorMaxDex >>>  8);
		maxStats[10] = (byte)(warriorMaxDex >>> 16);
		maxStats[11] = (byte)(warriorMaxDex >>> 24);
		long warriorMaxVit = char0.getMaxVitality();
		maxStats[12] = (byte)(warriorMaxVit >>>  0);
		maxStats[13] = (byte)(warriorMaxVit >>>  8);
		maxStats[14] = (byte)(warriorMaxVit >>> 16);
		maxStats[15] = (byte)(warriorMaxVit >>> 24);
		long rogueMaxStrength = char1.getMaxStrength();
		maxStats[16] = (byte)(rogueMaxStrength >>>  0);
		maxStats[17] = (byte)(rogueMaxStrength >>>  8);
		maxStats[18] = (byte)(rogueMaxStrength >>> 16);
		maxStats[19] = (byte)(rogueMaxStrength >>> 24);
		long rogueMaxMagic = char1.getMaxMagic();
		maxStats[20] = (byte)(rogueMaxMagic >>>  0);
		maxStats[21] = (byte)(rogueMaxMagic >>>  8);
		maxStats[22] = (byte)(rogueMaxMagic >>> 16);
		maxStats[23] = (byte)(rogueMaxMagic >>> 24);
		long rogueMaxDex = char1.getMaxDexterity();
		maxStats[24] = (byte)(rogueMaxDex >>>  0);
		maxStats[25] = (byte)(rogueMaxDex >>>  8);
		maxStats[26] = (byte)(rogueMaxDex >>> 16);
		maxStats[27] = (byte)(rogueMaxDex >>> 24);
		long rogueMaxVit = char1.getMaxVitality();
		maxStats[28] = (byte)(rogueMaxVit >>>  0);
		maxStats[29] = (byte)(rogueMaxVit >>>  8);
		maxStats[30] = (byte)(rogueMaxVit >>> 16);
		maxStats[31] = (byte)(rogueMaxVit >>> 24);
		long sorcMaxStrength = char2.getMaxStrength();
		maxStats[32] = (byte)(sorcMaxStrength >>>  0);
		maxStats[33] = (byte)(sorcMaxStrength >>>  8);
		maxStats[34] = (byte)(sorcMaxStrength >>> 16);
		maxStats[35] = (byte)(sorcMaxStrength >>> 24);
		long sorcMaxMagic = char2.getMaxMagic();
		maxStats[36] = (byte)(sorcMaxMagic >>>  0);
		maxStats[37] = (byte)(sorcMaxMagic >>>  8);
		maxStats[38] = (byte)(sorcMaxMagic >>> 16);
		maxStats[39] = (byte)(sorcMaxMagic >>> 24);
		long sorcMaxDex = char2.getMaxDexterity();
		maxStats[40] = (byte)(sorcMaxDex >>>  0);
		maxStats[41] = (byte)(sorcMaxDex >>> 8);
		maxStats[42] = (byte)(sorcMaxDex >>> 16);
		maxStats[43] = (byte)(sorcMaxDex >>> 24);
		long sorcMaxVit = char2.getMaxVitality();
		maxStats[44] = (byte)(sorcMaxVit >>>  0);
		maxStats[45] = (byte)(sorcMaxVit >>>  8);
		maxStats[46] = (byte)(sorcMaxVit >>> 16);
		maxStats[47] = (byte)(sorcMaxVit >>> 24);
		return maxStats;
	}

	private byte[] getBlockingBonusBytes(){
		byte[] blockingBonuses = new byte[12];
		long warriorBlockingBonus = char0.getBlockingBonus();
		blockingBonuses[0] = (byte)(warriorBlockingBonus >>>  0);
		blockingBonuses[1] = (byte)(warriorBlockingBonus >>>  8);
		blockingBonuses[2] = (byte)(warriorBlockingBonus >>> 16);
		blockingBonuses[3] = (byte)(warriorBlockingBonus >>> 24);
		long rogueBlockingBonus = char1.getBlockingBonus();
		blockingBonuses[4] = (byte)(rogueBlockingBonus >>>  0);
		blockingBonuses[5] = (byte)(rogueBlockingBonus >>>  8);
		blockingBonuses[6] = (byte)(rogueBlockingBonus >>> 16);
		blockingBonuses[7] = (byte)(rogueBlockingBonus >>> 24);
		long sorcBlockingBonus = char2.getBlockingBonus();
		blockingBonuses[8] = (byte)(sorcBlockingBonus >>>  0);
		blockingBonuses[9] = (byte)(sorcBlockingBonus >>>  8);
		blockingBonuses[10] = (byte)(sorcBlockingBonus >>> 16);
		blockingBonuses[11] = (byte)(sorcBlockingBonus >>> 24);
		return blockingBonuses;
	}

	private byte[] getBonusesAndFramesetBytes(){
		byte[] bonusesAndFramesets = new byte[33];
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

	public void getCharactersAsBytes(){
		byte[] retrievedInitStatBytes = this.getInitStatBytes();
		byte[] retrievedMaxStatBytes = this.getMaxStatBytes();
		byte[] retrievedBlockingBonusBytes = this.getBlockingBonusBytes();
		byte[] retrievedBonusesAndFramesetBytes = this.getBonusesAndFramesetBytes();

		/*
		System.out.println("ORIG: " + Arrays.toString(startingStats));
		System.out.println("RETR: " + Arrays.toString(retrievedInitStatBytes));
		System.out.println();
		System.out.println("ORIG: " + Arrays.toString(maxStats));
		System.out.println("RETR: " + Arrays.toString(retrievedMaxStatBytes));
		System.out.println();
		System.out.println("ORIG: " + Arrays.toString(blockingBonuses));
		System.out.println("RETR: " + Arrays.toString(retrievedBlockingBonusBytes));
		System.out.println();
		System.out.println("ORIG: " + Arrays.toString(bonusesAndFramesets));
		System.out.println("RETR: " + Arrays.toString(retrievedBonusesAndFramesetBytes));
		System.out.println();
		*/
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

	public List<Character> getCharacters() {
		return characters;
	}

	void setAllMaxStatsTo255() {
		for(Character c : characters){
			c.setMaxDexterity(255);
			c.setMaxMagic(255);
			c.setMaxStrength(255);
			c.setMaxVitality(255);
		}
	}

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
		rw.writeBytes(bytesToUse, TomeOfKnowledge.CHARACTER_ZERO_SKILL_LOC_1);
		rw.writeBytes(bytesToUse, TomeOfKnowledge.CHARACTER_ZERO_SKILL_LOC_2);
		rw.writeBytes(spellID, TomeOfKnowledge.CHARACTER_ZERO_SPELL_LOC_1);
	}

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
		rw.writeBytes(bytesToUse, TomeOfKnowledge.CHARACTER_ONE_SKILL_LOC_1);
		rw.writeBytes(bytesToUse, TomeOfKnowledge.CHARACTER_ONE_SKILL_LOC_2);
		rw.writeBytes(spellID, TomeOfKnowledge.CHARACTER_ONE_SPELL_LOC_1);

	}

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
		rw.writeBytes(bytesToUse, TomeOfKnowledge.CHARACTER_TWO_SKILL_LOC_1);
		rw.writeBytes(bytesToUse, TomeOfKnowledge.CHARACTER_TWO_SKILL_LOC_2);
		rw.writeBytes(spellID, TomeOfKnowledge.CHARACTER_TWO_SPELL_LOC_1);
	}

}
