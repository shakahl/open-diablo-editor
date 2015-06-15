package uk.me.karlsen.ode;

public class UniqueMonster {

	private String[] monsterAIs = {
		"Zombie",
		"Overlord",
		"Skeleton",
		"Skeleton Archer",
		"Scavenger",
		"Horned Demon",
		"Goat Man",
		"Goat Man Archer",
		"Fallen One",
		"Magma Demon",
		"Skeleton King",
		"Winged Fiend",
		"Gargoyle",
		"The Butcher",
		"Succubus",
		"Hidden",
		"Lightning Demon",
		"Fireman",
		"Gharbad the Weak",
		"Spitting Terror",
		"Fast Spitting Terror",
		"Golem",
		"Zhar the Mad",
		"Snotspill",
		"Viper",
		"Mage",
		"Balrog",
		"The Dark Lord",
		"Arch Bishop Lazarus",
		"Unique Succubus",
		"Lachdanan",
		"Warlord of Blood"
	};

	private long monsterType;
	private long namePointer;
	private String name;
	private long trnPointer;
	private String trnName;
	private int dungeonLevel;
	private int hitPoints;
	private int monsterAI;
	private int intelligenceFactor;
	private int minAttackDmg;
	private int maxAttackDmg;
	private String resistances;
	private int packTrigger;
	private long packSpecials;
	private long specialSoundWav;

	public UniqueMonster(byte[] monsterBytes, ReaderWriter rw) {
		BinEditHelper beh = new BinEditHelper();
		monsterType = beh.convertFourBytesToNumber(monsterBytes, 0);
		namePointer = beh.convertFourBytesToOffset(monsterBytes, 4);
		name = beh.getNameUsingPointer(namePointer);
		trnPointer = beh.convertFourBytesToOffset(monsterBytes, 8);
		trnName = beh.getNameUsingPointer(trnPointer);
		dungeonLevel = beh.convertTwoBytesToInt(monsterBytes[12], monsterBytes[13]);
		hitPoints = beh.convertTwoBytesToInt(monsterBytes[14], monsterBytes[15]);
		monsterAI = beh.convertUnsignedByteToInt(monsterBytes[16]);
		intelligenceFactor = beh.convertUnsignedByteToInt(monsterBytes[17]);
		minAttackDmg = beh.convertUnsignedByteToInt(monsterBytes[18]);
		maxAttackDmg = beh.convertUnsignedByteToInt(monsterBytes[19]);
		resistances = beh.convertByteToBinaryString(monsterBytes[20]) + ";" + beh.convertByteToBinaryString(monsterBytes[21]);
		packTrigger = beh.convertTwoBytesToInt(monsterBytes[22], monsterBytes[23]);
		packSpecials = beh.convertFourBytesToNumber(monsterBytes, 24);
		specialSoundWav = beh.convertFourBytesToNumber(monsterBytes, 28);
	}

	public void printItem() {
		System.out.println(
			"Name: " + name + "\n" +
			"Monster type: " + monsterType + "\n" +
			"Name pointer: " + namePointer + "\n" +
			"TRN pointer: " + trnPointer + "\n" +
			"TRN file: " + trnName + "\n" +
			"Dungeon level: " + dungeonLevel + "\n" +
			"HPs: " + hitPoints + "\n" +
			"Monster AI: " + monsterAIs[monsterAI] + "\n" +
			"Intelligence factor: " + intelligenceFactor + "\n" +
			"Min attack dmg: " + minAttackDmg + "\n" +
			"Max attack dmg: " + maxAttackDmg + "\n" +
			"Resistances: " + resistances + "\n" +
			"Pack trigger: " + packTrigger + "\n" +
			"Pack specials: " + packSpecials + "\n" +
			"Special WAV sound: " + specialSoundWav + "\n"
		);
	}

	public byte[] getUniqueAsBytes() {
		byte[] uniqueAsBytes = new byte[32];
		BinEditHelper beh = new BinEditHelper();
		beh.setLongAsFourBytes(monsterType, uniqueAsBytes, 0);
		beh.setPointerAsFourBytes(namePointer, uniqueAsBytes, 4);
		beh.setPointerAsFourBytes(trnPointer, uniqueAsBytes, 8);
		beh.setIntAsTwoBytes(dungeonLevel, uniqueAsBytes, 12);
		beh.setIntAsTwoBytes(hitPoints, uniqueAsBytes, 14);
		uniqueAsBytes[16] = (byte) monsterAI;
		uniqueAsBytes[17] = (byte) intelligenceFactor;
		uniqueAsBytes[18] = (byte) minAttackDmg;
		uniqueAsBytes[19] = (byte) maxAttackDmg;
		String[] resistancesSplit = resistances.split(";");
		uniqueAsBytes[20] = (byte) Byte.parseByte(resistancesSplit[0], 2);
		uniqueAsBytes[21] = (byte) Byte.parseByte(resistancesSplit[1], 2);
		beh.setIntAsTwoBytes(packTrigger, uniqueAsBytes, 22);
		beh.setLongAsFourBytes(packSpecials, uniqueAsBytes, 24);
		beh.setLongAsFourBytes(specialSoundWav, uniqueAsBytes, 28);
		return uniqueAsBytes;
	}

	public long getMonsterType() {
		return monsterType;
	}

	public void setMonsterType(long monsterType) {
		this.monsterType = monsterType;
	}

	public long getNamePointer() {
		return namePointer;
	}

	public void setNamePointer(long namePointer) {
		this.namePointer = namePointer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getTrnPointer() {
		return trnPointer;
	}

	public void setTrnPointer(long trnPointer) {
		this.trnPointer = trnPointer;
	}

	public String getTrnName() {
		return trnName;
	}

	public void setTrnName(String trnName) {
		this.trnName = trnName;
	}

	public int getDungeonLevel() {
		return dungeonLevel;
	}

	public void setDungeonLevel(int dungeonLevel) {
		this.dungeonLevel = dungeonLevel;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public int getMonsterAI() {
		return monsterAI;
	}

	public void setMonsterAI(int monsterAI) {
		this.monsterAI = monsterAI;
	}

	public int getIntelligenceFactor() {
		return intelligenceFactor;
	}

	public void setIntelligenceFactor(int intelligenceFactor) {
		this.intelligenceFactor = intelligenceFactor;
	}

	public int getMinAttackDmg() {
		return minAttackDmg;
	}

	public void setMinAttackDmg(int minAttackDmg) {
		this.minAttackDmg = minAttackDmg;
	}

	public int getMaxAttackDmg() {
		return maxAttackDmg;
	}

	public void setMaxAttackDmg(int maxAttackDmg) {
		this.maxAttackDmg = maxAttackDmg;
	}

	public String getResistances() {
		return resistances;
	}

	public void setResistances(String resistances) {
		this.resistances = resistances;
	}

	public int getPackTrigger() {
		return packTrigger;
	}

	public void setPackTrigger(int packTrigger) {
		this.packTrigger = packTrigger;
	}

	public long getPackSpecials() {
		return packSpecials;
	}

	public void setPackSpecials(long packSpecials) {
		this.packSpecials = packSpecials;
	}

	public long getSpecialSoundWav() {
		return specialSoundWav;
	}

	public void setSpecialSoundWav(long specialSoundWav) {
		this.specialSoundWav = specialSoundWav;
	}

}
