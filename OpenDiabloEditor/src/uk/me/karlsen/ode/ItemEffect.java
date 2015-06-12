package uk.me.karlsen.ode;

public class ItemEffect {

	private long effectNumber;
	private long effect;
	private long minValue;
	private long maxValue;
	
	public ItemEffect(byte[] readIn, int offset) {
		BinEditHelper beh = new BinEditHelper();
		effectNumber = offset / 12;
		effect = beh.convertFourBytesToNumber(readIn, offset);
		minValue = beh.convertFourBytesToNumber(readIn, offset+4);
		maxValue = beh.convertFourBytesToNumber(readIn, offset+8);
	}

	public long getEffect() {
		return effect;
	}

	public void setEffect(long effect) {
		this.effect = effect;
	}

	public long getMinValue() {
		return minValue;
	}

	public void setMinValue(long minValue) {
		this.minValue = minValue;
	}

	public long getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(long maxValue) {
		this.maxValue = maxValue;
	}

	public long getEffectNumber() {
		return effectNumber;
	}

	public void setEffectNumber(long effectNumber) {
		this.effectNumber = effectNumber;
	}

}
