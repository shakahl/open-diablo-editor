package uk.me.karlsen.ode.types;

import uk.me.karlsen.ode.ReaderWriter;
import uk.me.karlsen.ode.utils.BinEditHelper;

public class ItemEffect {

	private long effectNumber;
	private long effect;
	private long minValue;
	private long maxValue;
	private String[] effectNames;
	
	public ItemEffect(ReaderWriter rw, byte[] readIn, int offset) {
		effectNames = this.createNewItemEffectsArray();
		BinEditHelper beh = new BinEditHelper(rw);
		effectNumber = offset / 12;
		effect = beh.convertFourBytesToNumber(readIn, offset);
		minValue = beh.convertFourBytesToNumber(readIn, offset+4);
		maxValue = beh.convertFourBytesToNumber(readIn, offset+8);
	}
	
	//TODO -- fix duplicate code
	private String[] createNewItemEffectsArray() {
		String[] itemEffects = {
			"+% ToHit", //00
			"-% ToHit", //01
			"+% damage done", //02
			"-% damage done", //03
			"+% ToHit, +% damage done", //04
			"-% ToHit, -% damage done", //05
			"+% armor class", //06
			"-% armor class", //07
			"+% resist fire", //08
			"+% resist lightning", //09
			"+% resist magic", //0A
			"+% resist all", //0B
			"", //0C
			"", //0D
			"+/- spell levels", //0E
			"+ charges", //0F
			"+ fire damage", //10
			"+ lightning damage", //11
			"", //12
			"+ strength", //13
			"- strength", //14
			"+ magic", //15
			"- magic", //16
			"+ dexterity", //17
			"- dexterity", //18
			"+ vitality", //19
			"- vitality", //1A
			"+ all attributes", //1B
			"+ all attributes", //1C
			"+ damage taken", //1D
			"- damage taken", //1E
			"+ life", //1F
			"- life", //20
			"+ mana", //21
			"- mana", //22
			"+% durability (high durability)", //23
			"-% durability (decreased durability)", //24
			"indestructable", //25
			"+% light", //26
			"-% light", //27
			"unknown or n/a", //28
			"multiple arrows", //29
			"+ fire arrows damage", //2A
			"+ lightning arrows damage", //2B
			"unique picture", //2C
			"attacker take 1-3 damage", //2D
			"-all mana", //2E
			"player can't heal", //2F
			"unknown or n/a", //30
			"unknown or n/a", //31
			"unknown or n/a", //32
			"unknown or n/a", //33
			"absorb half trap damage", //34
			"knocks target back", //35
			"monster can't heal", //36
			"% steal mana", //37
			"% steal life", //38
			"damage/penetrate armor", //39
			"attack speed (1=readiness, 4=haste)", //3A
			"hit recovery (1=balance, 3=harmony", //3B
			"fast block", //3C
			"+ damage done", //3D
			"random speed arrows", //3E
			"x-y damage done (unusual item damage)", //3F
			"altered durability", //40
			"no strength requirements", //41
			"spell-", //42
			"attack speed (1=readiness, 4=haste)", //43
			"one handed", //44
			"+200% damage versus demons", //45
			"all resistances equal 0%", //46
			"unknown or n/a", //47
			"constantly lose life", //48
			"0-12.5% steal life", //49
			"infravision", //4A
			"specified armor class", //4B
			"armor class added to life", //4C
			"10% of mana added to armor class", //4D
			"+30-clvl% resist fire", //4E
			"armor class" //4F
		};
		return itemEffects;
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
	
	public String getEffectName()
	{
		return effectNames[(int) effectNumber];
	}
}
