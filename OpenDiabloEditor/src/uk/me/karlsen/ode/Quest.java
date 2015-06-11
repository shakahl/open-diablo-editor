package uk.me.karlsen.ode;

public class Quest {

	String[] specialLevels = {
			"NA",
			"King Leoric's Tomb",
			"The Chamber of Bone",
			"Maze",
			"Dark Passage",
			"Unholy Altar"
	};
	
	private int dungeonLevel;
	private int byteOneValue;
	private int byteTwoValue;
	private int questNumber;
	private int byteFourValue;
	private int specialLevel; //SP only
	private int zeroOne;
	private int zeroTwo;
	private long mpTriggerFlag;
	private int byteElevenValue;
	private int byteTwelveValue;
	private int byteThirteenValue;
	private int byteFourteenValue;
	private byte[] questBytes;
	int slotNumber;
	
	public Quest(int indexValue, byte[] questBytes, ReaderWriter rw){
		this.slotNumber = indexValue;
		dungeonLevel = rw.convertUnsignedByteToInt(questBytes[0]);
		byteOneValue = rw.convertUnsignedByteToInt(questBytes[1]);
		byteTwoValue = rw.convertUnsignedByteToInt(questBytes[2]);
		questNumber = rw.convertUnsignedByteToInt(questBytes[3]);
		byteFourValue = rw.convertUnsignedByteToInt(questBytes[4]);
		specialLevel = rw.convertUnsignedByteToInt(questBytes[5]); //SP only
		zeroOne = rw.convertUnsignedByteToInt(questBytes[6]);
		zeroTwo = rw.convertUnsignedByteToInt(questBytes[7]);
		mpTriggerFlag = rw.convertFourBytesToNumber(questBytes[8], questBytes[9], questBytes[10], questBytes[11]);
		byteElevenValue = rw.convertUnsignedByteToInt(questBytes[12]);
		byteTwelveValue = rw.convertUnsignedByteToInt(questBytes[13]);
		byteThirteenValue = rw.convertUnsignedByteToInt(questBytes[14]);
		byteFourteenValue = rw.convertUnsignedByteToInt(questBytes[15]);
		this.questBytes = questBytes;
	}
	
	public void printQuest(){
		System.out.println("Slot number: " + slotNumber + " (hex: " + Integer.toHexString(slotNumber) + ")");
		System.out.println("Dungeon level: " + dungeonLevel);
		System.out.println("Unknown: " + byteOneValue);
		System.out.println("Unknown: " + byteTwoValue);
		System.out.println("Quest number: " + questNumber);
		System.out.println("Unknown: " + byteFourValue);
		System.out.println("Special level: " + specialLevels[specialLevel]);
		System.out.println("Zero: " + zeroOne);
		System.out.println("Zero: " + zeroTwo);
		System.out.println("Multi player trigger flag: " + mpTriggerFlag);
		System.out.println("Unknown: " + byteFourteenValue + ", " + byteThirteenValue + ", " + byteTwelveValue + ", " + byteElevenValue);
		System.out.println();
	}

	public byte[] getQuestAsBytes() {
		byte[] questAsBytes = new byte[16];
		questAsBytes[0] = (byte) dungeonLevel;
		questAsBytes[1] = (byte) byteOneValue;
		questAsBytes[2] = (byte) byteTwoValue;
		questAsBytes[3] = (byte) questNumber;
		questAsBytes[4] = (byte) byteFourValue;
		questAsBytes[5] = (byte) specialLevel;
		questAsBytes[6] = (byte) zeroOne;
		questAsBytes[7] = (byte) zeroTwo;
		questAsBytes[8] = (byte) (mpTriggerFlag >>>  0);;
		questAsBytes[9] = (byte) (mpTriggerFlag >>>  8);;
		questAsBytes[10] = (byte) (mpTriggerFlag >>>  16);;
		questAsBytes[11] = (byte) (mpTriggerFlag >>>  24);;
		questAsBytes[12] = (byte) byteElevenValue;
		questAsBytes[13] = (byte) byteTwelveValue;
		questAsBytes[14] = (byte) byteThirteenValue;
		questAsBytes[15] = (byte) byteFourteenValue;
		
		//System.out.println("ORIG: " + Arrays.toString(questBytes));
		//System.out.println("BACK: " + Arrays.toString(questAsBytes));
		//System.out.println();
		
		return questAsBytes;
	}

	public int getDungeonLevel() {
		return dungeonLevel;
	}

	public void setDungeonLevel(int dungeonLevel) {
		this.dungeonLevel = dungeonLevel;
	}

	public int getByteOneValue() {
		return byteOneValue;
	}

	public void setByteOneValue(int byteOneValue) {
		this.byteOneValue = byteOneValue;
	}

	public int getByteTwoValue() {
		return byteTwoValue;
	}

	public void setByteTwoValue(int byteTwoValue) {
		this.byteTwoValue = byteTwoValue;
	}

	public int getQuestNumber() {
		return questNumber;
	}

	public void setQuestNumber(int questNumber) {
		this.questNumber = questNumber;
	}

	public int getByteFourValue() {
		return byteFourValue;
	}

	public void setByteFourValue(int byteFourValue) {
		this.byteFourValue = byteFourValue;
	}

	public int getSpecialLevel() {
		return specialLevel;
	}

	public void setSpecialLevel(int specialLevel) {
		this.specialLevel = specialLevel;
	}

	public int getZeroOne() {
		return zeroOne;
	}

	public void setZeroOne(int zeroOne) {
		this.zeroOne = zeroOne;
	}

	public int getZeroTwo() {
		return zeroTwo;
	}

	public void setZeroTwo(int zeroTwo) {
		this.zeroTwo = zeroTwo;
	}

	public long getMpTriggerFlag() {
		return mpTriggerFlag;
	}

	public void setMpTriggerFlag(long mpTriggerFlag) {
		this.mpTriggerFlag = mpTriggerFlag;
	}

	public int getByteElevenValue() {
		return byteElevenValue;
	}

	public void setByteElevenValue(int byteElevenValue) {
		this.byteElevenValue = byteElevenValue;
	}

	public int getByteTwelveValue() {
		return byteTwelveValue;
	}

	public void setByteTwelveValue(int byteTwelveValue) {
		this.byteTwelveValue = byteTwelveValue;
	}

	public int getByteThirteenValue() {
		return byteThirteenValue;
	}

	public void setByteThirteenValue(int byteThirteenValue) {
		this.byteThirteenValue = byteThirteenValue;
	}

	public int getByteFourteenValue() {
		return byteFourteenValue;
	}

	public void setByteFourteenValue(int byteFourteenValue) {
		this.byteFourteenValue = byteFourteenValue;
	}

	public byte[] getQuestBytes() {
		return questBytes;
	}

	public void setQuestBytes(byte[] questBytes) {
		this.questBytes = questBytes;
	}
}
