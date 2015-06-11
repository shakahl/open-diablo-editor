package uk.me.karlsen.ode;

public class ShrinesAsBytes {

	byte[] shrinePointerBytes = new byte[TomeOfKnowledge.NUMBER_OF_SHRINES*4];
	byte[] minShrineLevelBytes = new byte[TomeOfKnowledge.NUMBER_OF_SHRINES];
	byte[] maxShrineLevelBytes = new byte[TomeOfKnowledge.NUMBER_OF_SHRINES];
	byte[] gameTypesInWhichPresentBytes = new byte[TomeOfKnowledge.NUMBER_OF_SHRINES];
	
	public ShrinesAsBytes(byte[] shrinePointerBytes,
			byte[] minShrineLevelBytes, byte[] maxShrineLevelBytes,
			byte[] gameTypesInWhichPresentBytes) {
		this.shrinePointerBytes = shrinePointerBytes;
		this.minShrineLevelBytes = minShrineLevelBytes;
		this.maxShrineLevelBytes = maxShrineLevelBytes;
		this.gameTypesInWhichPresentBytes = gameTypesInWhichPresentBytes;
	}

	public byte[] getShrinePointerBytes() {
		return shrinePointerBytes;
	}

	public byte[] getMinShrineLevelBytes() {
		return minShrineLevelBytes;
	}

	public byte[] getMaxShrineLevelBytes() {
		return maxShrineLevelBytes;
	}

	public byte[] getGameTypeBytes() {
		return gameTypesInWhichPresentBytes;
	}

}
