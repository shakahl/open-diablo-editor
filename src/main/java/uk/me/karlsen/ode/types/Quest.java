package uk.me.karlsen.ode.types;

import uk.me.karlsen.ode.ReaderWriter;
import uk.me.karlsen.ode.utils.BinEditHelper;

public class Quest {

	String[] specialLevels = {
			"NA",
			"King Leoric's Tomb",
			"The Chamber of Bone",
			"Maze",
			"Dark Passage",
			"Unholy Altar"
	};

	String[] dungeonTypes = {
		"Tristram",  // 0
		"Cathedral", // 1
		"Catacombs", // 2
		"Caves",     // 3
		"Hell"       // 4
		             // -1 (0xFF) = "None"
	};

	//String[] textEntries = { ... }; -- Regrettably removed due to copyright concerns. Need to read-in every time ODE is run.

	private int dungeonLevelSingle;
	private int dungeonLevelMulti;
	private int dungeonType;
	private int questNumber;
	private int byteFourValue;
	private int specialLevel; //SP only
	private int zeroOne;
	private int zeroTwo;
	private long mpTriggerFlag;
	private long textEntryIDX;
	int slotNumber;
	
	private ReaderWriter rw;

	public Quest(int indexValue, byte[] questBytes, ReaderWriter rw){
		this.rw = rw;
		this.slotNumber = indexValue;
		BinEditHelper beh = new BinEditHelper(rw);
		dungeonLevelSingle = beh.convertUnsignedByteToInt(questBytes[0]);
		dungeonLevelMulti = beh.convertUnsignedByteToInt(questBytes[1]);
		dungeonType = beh.convertUnsignedByteToInt(questBytes[2]);
		questNumber = beh.convertUnsignedByteToInt(questBytes[3]);
		byteFourValue = beh.convertUnsignedByteToInt(questBytes[4]);
		specialLevel = beh.convertUnsignedByteToInt(questBytes[5]); //SP only
		zeroOne = beh.convertUnsignedByteToInt(questBytes[6]);
		zeroTwo = beh.convertUnsignedByteToInt(questBytes[7]);
		mpTriggerFlag = beh.convertFourBytesToNumber(questBytes, 8);
		textEntryIDX = beh.convertFourBytesToNumber(questBytes, 12);
	}

	public void printQuest(){
		System.out.println("Slot number: " + slotNumber + " (hex: " + Integer.toHexString(slotNumber) + ")");
		System.out.println("Dungeon level single: " + dungeonLevelSingle);
		System.out.println("Dungeon level multi: " + dungeonLevelMulti);
		if(dungeonType >= 0 && dungeonType <= 4){
			System.out.println("Dungeon type: " + dungeonTypes[dungeonType]);
		}
		System.out.println("Quest number: " + questNumber);
		System.out.println("Unknown: " + byteFourValue);
		System.out.println("Special level: " + specialLevels[specialLevel]);
		System.out.println("Zero: " + zeroOne);
		System.out.println("Zero: " + zeroTwo);
		System.out.println("Multi player trigger flag: " + mpTriggerFlag);
		//System.out.println("Text entry IDX: `" + textEntries[(int) textEntryIDX] + "`"); -- Regrettably removed due to copyright concerns. Need to read-in every time ODE is run.
		System.out.println();
	}

	public byte[] getQuestAsBytes() {
		byte[] questAsBytes = new byte[16];
		BinEditHelper beh = new BinEditHelper(rw);
		questAsBytes[0] = (byte) dungeonLevelSingle;
		questAsBytes[1] = (byte) dungeonLevelMulti;
		questAsBytes[2] = (byte) dungeonType;
		questAsBytes[3] = (byte) questNumber;
		questAsBytes[4] = (byte) byteFourValue;
		questAsBytes[5] = (byte) specialLevel;
		questAsBytes[6] = (byte) zeroOne;
		questAsBytes[7] = (byte) zeroTwo;
		beh.setLongAsFourBytes(mpTriggerFlag, questAsBytes, 8);
		beh.setLongAsFourBytes(textEntryIDX, questAsBytes, 12);

		return questAsBytes;
	}

	public int getDungeonLevelSingle() {
		return dungeonLevelSingle;
	}

	public void setDungeonLevelSingle(int dungeonLevelSingle) {
		this.dungeonLevelSingle = dungeonLevelSingle;
	}

	public int getDungeonLevelMulti() {
		return dungeonLevelMulti;
	}

	public void setDungeonLevelMulti(int dungeonLevelMulti) {
		this.dungeonLevelMulti = dungeonLevelMulti;
	}

	public int getDungeonType() {
		return dungeonType;
	}

	public void setDungeonType(int dungeonType) {
		this.dungeonType = dungeonType;
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

	public long getTextEntryIDX() {
		return textEntryIDX;
	}

	public void setTextEntryIDX(long textEntryIDX) {
		this.textEntryIDX = textEntryIDX;
	}
}
