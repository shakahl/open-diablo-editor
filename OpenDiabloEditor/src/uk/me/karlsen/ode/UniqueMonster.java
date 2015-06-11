package uk.me.karlsen.ode;

public class UniqueMonster {

	private long monsterType;
	private long namePointer;
	private String name;
	private long trnPointer;
	private String trnName;
	private int dungeonLevel;
	private int hitPoints;
	private int attackTypePart1;
	private int attackTypePart2;
	private int minAttackDmg;
	private int maxAttackDmg;
	private String resistances;
	private int packTrigger;
	private long packSpecials;
	private long specialSoundWav;
	//byte[] uniqueBytes;
	
	public UniqueMonster(byte[] monsterBytes, ReaderWriter rw) {
		//uniqueBytes = monsterBytes;
		BinEditHelper nf = new BinEditHelper();
		monsterType = rw.convertFourBytesToNumber(monsterBytes[0], monsterBytes[1], monsterBytes[2], monsterBytes[3]);
		namePointer = rw.convertFourBytesToOffset(monsterBytes[4], monsterBytes[5], monsterBytes[6], monsterBytes[7]);
		name = nf.getNameUsingPointer(namePointer);
		trnPointer = rw.convertFourBytesToOffset(monsterBytes[8], monsterBytes[9], monsterBytes[10], monsterBytes[11]);
		trnName = nf.getNameUsingPointer(trnPointer);
		dungeonLevel = rw.convertTwoBytesToInt(monsterBytes[12], monsterBytes[13]);
		hitPoints = rw.convertTwoBytesToInt(monsterBytes[14], monsterBytes[15]);
		attackTypePart1 = rw.convertUnsignedByteToInt(monsterBytes[16]);
		attackTypePart2 = rw.convertUnsignedByteToInt(monsterBytes[17]);
		minAttackDmg = rw.convertUnsignedByteToInt(monsterBytes[18]);
		maxAttackDmg = rw.convertUnsignedByteToInt(monsterBytes[19]);
		resistances = String.format("%16s", Integer.toBinaryString(rw.convertUnsignedByteToInt(monsterBytes[20]))).replace(' ', '0') + ";" +
				String.format("%16s", Integer.toBinaryString(rw.convertUnsignedByteToInt(monsterBytes[21]))).replace(' ', '0');
		packTrigger = rw.convertTwoBytesToInt(monsterBytes[22], monsterBytes[23]);
		packSpecials = rw.convertFourBytesToNumber(monsterBytes[24], monsterBytes[25], monsterBytes[26], monsterBytes[27]);
		specialSoundWav = rw.convertFourBytesToNumber(monsterBytes[28], monsterBytes[29], monsterBytes[30], monsterBytes[31]);
	}

	public void printItem() {
		System.out.println("Name: " + name);
		System.out.println("Monster type: " + monsterType);
		System.out.println("Name pointer: " + namePointer);
		System.out.println("TRN pointer: " + trnPointer);
		System.out.println("TRN file: " + trnName);
		System.out.println("Dungeon level: " + dungeonLevel);
		System.out.println("HPs: " + hitPoints);
		System.out.println("Attack type part 1: " + attackTypePart1);
		System.out.println("Attack type part 2: " + attackTypePart2);
		System.out.println("Min attack dmg: " + minAttackDmg);
		System.out.println("Max attack dmg: " + maxAttackDmg);
		System.out.println("Resistances: " + resistances);
		System.out.println("Pack trigger: " + packTrigger);
		System.out.println("Pack specials: " + packSpecials);
		System.out.println("Special WAV sound: " + specialSoundWav);
		System.out.println();
	}

	public byte[] getUniqueAsBytes() {
		byte[] uniqueAsBytes = new byte[32];
		uniqueAsBytes[0] = (byte) (monsterType >>> 0);
		uniqueAsBytes[1] = (byte) (monsterType >>> 8);
		uniqueAsBytes[2] = (byte) (monsterType >>> 16);
		uniqueAsBytes[3] = (byte) (monsterType >>> 24);
		long namePointerRev = namePointer + TomeOfKnowledge.DIABLO_POINTERS_OFFSET;
		uniqueAsBytes[4] = (byte) (namePointerRev >>> 0);
		uniqueAsBytes[5] = (byte) (namePointerRev >>> 8);
		uniqueAsBytes[6] = (byte) (namePointerRev >>> 16);
		uniqueAsBytes[7] = (byte) (namePointerRev >>> 24);
		long trnPointerRev = trnPointer + TomeOfKnowledge.DIABLO_POINTERS_OFFSET;
		uniqueAsBytes[8] = (byte) (trnPointerRev >>> 0);
		uniqueAsBytes[9] = (byte) (trnPointerRev >>> 8);
		uniqueAsBytes[10] = (byte) (trnPointerRev >>> 16);
		uniqueAsBytes[11] = (byte) (trnPointerRev >>> 24);
		uniqueAsBytes[12] = (byte) (dungeonLevel >>> 0);
		uniqueAsBytes[13] = (byte) (dungeonLevel >>> 8);
		uniqueAsBytes[14] = (byte) (hitPoints >>> 0);
		uniqueAsBytes[15] = (byte) (hitPoints >>> 8);
		uniqueAsBytes[16] = (byte) attackTypePart1;
		uniqueAsBytes[17] = (byte) attackTypePart2;
		uniqueAsBytes[18] = (byte) minAttackDmg;
		uniqueAsBytes[19] = (byte) maxAttackDmg;
		String[] resistancesSplit = resistances.split(";");
		uniqueAsBytes[20] = (byte) Byte.parseByte(resistancesSplit[0], 2);
		uniqueAsBytes[21] = (byte) Byte.parseByte(resistancesSplit[1], 2);
		uniqueAsBytes[22] = (byte) (packTrigger >>> 0);
		uniqueAsBytes[23] = (byte) (packTrigger >>> 8);
		uniqueAsBytes[24] = (byte) (packSpecials >>> 0);
		uniqueAsBytes[25] = (byte) (packSpecials >>> 8);
		uniqueAsBytes[26] = (byte) (packSpecials >>> 16);
		uniqueAsBytes[27] = (byte) (packSpecials >>> 24);
		uniqueAsBytes[28] = (byte) (specialSoundWav >>> 0);
		uniqueAsBytes[29] = (byte) (specialSoundWav >>> 8);
		uniqueAsBytes[30] = (byte) (specialSoundWav >>> 16);
		uniqueAsBytes[31] = (byte) (specialSoundWav >>> 24);
		
		//System.out.println("ORIG: " + Arrays.toString(uniqueBytes));
		//System.out.println("BACK: " + Arrays.toString(uniqueAsBytes));
		//System.out.println();
		
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

	public int getAttackTypePart1() {
		return attackTypePart1;
	}

	public void setAttackTypePart1(int attackTypePart1) {
		this.attackTypePart1 = attackTypePart1;
	}

	public int getAttackTypePart2() {
		return attackTypePart2;
	}

	public void setAttackTypePart2(int attackTypePart2) {
		this.attackTypePart2 = attackTypePart2;
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
