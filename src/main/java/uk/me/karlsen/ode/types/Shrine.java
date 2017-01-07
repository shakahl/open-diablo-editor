package uk.me.karlsen.ode.types;

import java.util.logging.Logger;

import uk.me.karlsen.ode.TomeOfKnowledge;

public class Shrine {
	
	private final static Logger LOGGER = Logger.getLogger(Shrine.class.getName());

	private String shrineName;
	private long shrinePointer;
	private int minShrineLevel;
	private int maxShrineLevel;
	private int gameTypesInWhichPresent;
	private int shrineIndex;
	boolean modifiedFromDefault;

	public Shrine(int shrineIndex, String shrineName, long shrinePointer, int minShrineLevel, int maxShrineLevel, int gameTypesInWhichPresent){
		this.shrineIndex = shrineIndex;
		this.shrineName = shrineName;
		this.shrinePointer = shrinePointer;
		this.minShrineLevel = minShrineLevel;
		this.maxShrineLevel = maxShrineLevel;
		this.gameTypesInWhichPresent = gameTypesInWhichPresent;
		this.modifiedFromDefault = false;
	}

	public void printShrine() {
		LOGGER.info("Shrine index: " + shrineIndex);
		LOGGER.info("Shrine name: " + shrineName);
		LOGGER.info("Shrine name pointer: " + shrinePointer);
		LOGGER.info("Min shrine level: " + minShrineLevel);
		LOGGER.info("Max shrine level: " + maxShrineLevel);
		LOGGER.info("SP+MP(0)/SP(1)/MP(2): " + gameTypesInWhichPresent);
		LOGGER.info("");
	}

	public byte[] getShrinePointerBytes() {
		byte[] shrinePointerBytes = new byte[4];
		long shrinePointerRev = shrinePointer + TomeOfKnowledge.DIABLO_POINTERS_OFFSET;
		shrinePointerBytes[0] = 0;
		shrinePointerBytes[1] = (byte)(shrinePointerRev >>> 0);
		shrinePointerBytes[2] = (byte)(shrinePointerRev >>> 8);
		shrinePointerBytes[3] = (byte)(shrinePointerRev >>> 16);
		return shrinePointerBytes;
	}

	public byte getMinShrineLevelByte() {
		return (byte) minShrineLevel;
	}

	public byte getMaxShrineLevelByte() {
		return (byte) maxShrineLevel;
	}

	public byte getGameTypeByte() {
		return (byte) gameTypesInWhichPresent;
	}

	public void setMinShrineLevel(int i) {
		minShrineLevel = i;
		modifiedFromDefault = true;
	}

	public void setMaxShrineLevel(int i) {
		maxShrineLevel = i;
		modifiedFromDefault = true;
	}

	public String getShrineName() {
		return shrineName;
	}

	public void setShrineName(String shrineName) {
		this.shrineName = shrineName;
	}

	public long getShrinePointer() {
		return shrinePointer;
	}

	public void setShrinePointer(long shrinePointer) {
		this.shrinePointer = shrinePointer;
	}

	public int getMinShrineLevel() {
		return minShrineLevel;
	}

	public int getMaxShrineLevel() {
		return maxShrineLevel;
	}

	public int getGameTypesInWhichPresent() {
		return gameTypesInWhichPresent;
	}

	public void setGameTypesInWhichPresent(int gameTypesInWhichPresent) {
		this.gameTypesInWhichPresent = gameTypesInWhichPresent;
	}

	public int getShrineIndex() {
		return shrineIndex;
	}

	public void setShrineIndex(int shrineIndex) {
		this.shrineIndex = shrineIndex;
	}

}
