package uk.me.karlsen.ode;

import java.util.Arrays;

public class ItemModifier {

	ReaderWriter rw = null;

	private long namePointer;
	private String name;
	private byte[] itemEffects;
	private long minimumEffectValue;
	private long maximumEffectValue;
	private long qualityLevel;
	private String occurencePossibilities; //Bow, Jewelry, Weapons, Staves, Armor, Shields -- 001100 etc...
	private int byteTwentyThree;
	private String excludedComboIndicator; //Values "00000001" and "00000010" cannot form a combination. 00000000 is fine.
	private long cursedIndicator; // A value of "00000000" signifies the prefix/suffix as cursed. "01000000" signifies it as not.
	private long minGold;
	private long maxGold;
	private long valueMultiplier;
	private byte[] itemBytes;

	public ItemModifier(byte[] readIn, ReaderWriter rw){
		this.rw = rw;
		namePointer = rw.convertFourBytesToOffset(readIn[0], readIn[1], readIn[2], readIn[3]);
		BinEditHelper nf = new BinEditHelper();
		name = nf.getNameUsingPointer(namePointer);
		itemEffects = Arrays.copyOfRange(readIn, 4, 4+TomeOfKnowledge.NUMBER_OF_ITEM_EFFECTS);
		// ### [ NOTE ] ###
		//
		// Each item effect has a dedicated minimum and maximum value. It would
		// make sence to create a dedicated class (perhaps called ItemEffect)
		// which contained the following three fields:
		//
		//    itemEffect
		//    minimumEffectValue
		//    maximumEffectValue
		//
		// The reason for creating a dedicated class for this, is that it is used
		// by other parts of the game; e.g. UniqueItem contains the following:
		//
		//    private long effectOne;
		//    private long minValueOne;
		//    private long maxValueOne;
		//    private long effectTwo;
		//    private long minValueTwo;
		//    private long maxValueTwo;
		//    private long effectThree;
		//    private long minValueThree;
		//    private long maxValueThree;
		//    private long effectFour;
		//    private long minValueFour;
		//    private long maxValueFour;
		//    private long effectFive;
		//    private long minValueFive;
		//    private long maxValueFive;
		//    private long effectSix;
		//    private long minValueSix;
		//    private long maxValueSix;
		//
		// TODO: Update the relevant code to reflect this.
		//
		// ### [/ NOTE ] ###
		minimumEffectValue = rw.convertFourBytesToNumber(readIn[8], readIn[9], readIn[10], readIn[11]);
		maximumEffectValue = rw.convertFourBytesToNumber(readIn[12], readIn[13], readIn[14], readIn[15]);
		qualityLevel = rw.convertFourBytesToNumber(readIn[16], readIn[17], readIn[18], readIn[19]);
		occurencePossibilities = String.format("%02X", readIn[22]) + String.format("%02X", readIn[21]) + String.format("%02X", readIn[20]);
		byteTwentyThree = rw.convertUnsignedByteToInt(readIn[23]);
		excludedComboIndicator = String.format("%02X", readIn[31]) + ";" + String.format("%02X", readIn[30]) +
				";" + String.format("%02X", readIn[29]) + ";" + String.format("%02X", readIn[28]) +
				";" + String.format("%02X", readIn[27]) + ";" + String.format("%02X", readIn[26]) +
				";" + String.format("%02X", readIn[25]) + ";" + String.format("%02X", readIn[24]);
		cursedIndicator = rw.convertFourBytesToNumber(readIn[32], readIn[33], readIn[34], readIn[35]);
		minGold = rw.convertFourBytesToNumber(readIn[36], readIn[37], readIn[38], readIn[39]);
		maxGold = rw.convertFourBytesToNumber(readIn[40], readIn[41], readIn[42], readIn[43]);
		valueMultiplier = rw.convertFourBytesToNumber(readIn[44], readIn[45], readIn[46], readIn[47]);
		itemBytes = readIn;
	}

	public byte[] getModifierAsBytes(){
		byte[] modifierAsBytes = new byte[48];
		long namePointerRev = namePointer + TomeOfKnowledge.DIABLO_POINTERS_OFFSET;
		modifierAsBytes[0] = (byte)(namePointerRev >>> 0);
		modifierAsBytes[1] = (byte)(namePointerRev >>> 8);
		modifierAsBytes[2] = (byte)(namePointerRev >>> 16);
		modifierAsBytes[3] = (byte)(namePointerRev >>> 24);
		modifierAsBytes[4] = itemEffects[0];
		modifierAsBytes[5] = itemEffects[1];
		modifierAsBytes[6] = itemEffects[2];
		modifierAsBytes[7] = itemEffects[3];
		modifierAsBytes[8] = (byte)(minimumEffectValue >>> 0);
		modifierAsBytes[9] = (byte)(minimumEffectValue >>> 8);
		modifierAsBytes[10] = (byte)(minimumEffectValue >>> 16);
		modifierAsBytes[11] = (byte)(minimumEffectValue >>> 24);
		modifierAsBytes[12] = (byte)(maximumEffectValue >>> 0);
		modifierAsBytes[13] = (byte)(maximumEffectValue >>> 8);
		modifierAsBytes[14] = (byte)(maximumEffectValue >>> 16);
		modifierAsBytes[15] = (byte)(maximumEffectValue >>> 24);
		modifierAsBytes[16] = (byte)(qualityLevel >>> 0);
		modifierAsBytes[17] = (byte)(qualityLevel >>> 8);
		modifierAsBytes[18] = (byte)(qualityLevel >>> 16);
		modifierAsBytes[19] = (byte)(qualityLevel >>> 24);
		String occurencePossibilitiesOne = occurencePossibilities.substring(0, 2);
		String occurencePossibilitiesTwo = occurencePossibilities.substring(2, 4);
		String occurencePossibilitiesThree = occurencePossibilities.substring(4, 6);
		modifierAsBytes[20] = Byte.parseByte(occurencePossibilitiesThree, 16);
		modifierAsBytes[21] = Byte.parseByte(occurencePossibilitiesTwo, 16);
		modifierAsBytes[22] = Byte.parseByte(occurencePossibilitiesOne, 16);
		modifierAsBytes[23] = (byte) byteTwentyThree;
		String[] split = excludedComboIndicator.split(";");
		modifierAsBytes[24] = Byte.parseByte(split[7], 16);
		modifierAsBytes[25] = Byte.parseByte(split[6], 16);
		modifierAsBytes[26] = Byte.parseByte(split[5], 16);
		modifierAsBytes[27] = Byte.parseByte(split[4], 16);
		modifierAsBytes[28] = Byte.parseByte(split[3], 16);
		modifierAsBytes[29] = Byte.parseByte(split[2], 16);
		modifierAsBytes[30] = Byte.parseByte(split[1], 16);
		modifierAsBytes[31] = Byte.parseByte(split[0], 16);
		modifierAsBytes[32] = (byte)(cursedIndicator >>> 0);
		modifierAsBytes[33] = (byte)(cursedIndicator >>> 8);
		modifierAsBytes[34] = (byte)(cursedIndicator >>> 16);
		modifierAsBytes[35] = (byte)(cursedIndicator >>> 24);
		modifierAsBytes[36] = (byte)(minGold >>> 0);
		modifierAsBytes[37] = (byte)(minGold >>> 8);
		modifierAsBytes[38] = (byte)(minGold >>> 16);
		modifierAsBytes[39] = (byte)(minGold >>> 24);
		modifierAsBytes[40] = (byte)(maxGold >>> 0);
		modifierAsBytes[41] = (byte)(maxGold >>> 8);
		modifierAsBytes[42] = (byte)(maxGold >>> 16);
		modifierAsBytes[43] = (byte)(maxGold >>> 24);
		modifierAsBytes[44] = (byte)(valueMultiplier >>> 0);
		modifierAsBytes[45] = (byte)(valueMultiplier >>> 8);
		modifierAsBytes[46] = (byte)(valueMultiplier >>> 16);
		modifierAsBytes[47] = (byte)(valueMultiplier >>> 24);

		//System.out.println("ORIG: " + Arrays.toString(itemBytes));
		//System.out.println("BACK: " + Arrays.toString(modifierAsBytes));
		//System.out.println();

		return modifierAsBytes;
	}

	public void printModifier(){
		System.out.println("Modifier name: " + name);
		System.out.println("Modifier name pointer: " + namePointer);
		String[] itemEffectStrings = createNewItemEffectsString();
		System.out.println("Item Effects: " + itemEffectStrings[itemEffects[0]] + "; " + itemEffectStrings[itemEffects[1]] + "; " + itemEffectStrings[itemEffects[2]] + "; " + itemEffectStrings[itemEffects[3]]);
		System.out.println("Minimum effect value: " + minimumEffectValue);
		System.out.println("Maximum effect value: " + maximumEffectValue);
		System.out.println("Quality level: " + qualityLevel);
		System.out.println("Occurrence probability (bit encoded): " + occurencePossibilities);
		System.out.println("Zero: " + byteTwentyThree);
		System.out.println("Excluded combinations indicator: " + excludedComboIndicator);
		System.out.println("Cursed indicator: " + cursedIndicator);
		System.out.println("Min gold: " + minGold);
		System.out.println("Max gold: " + maxGold);
		System.out.println("Value multiplier: " + valueMultiplier);
		System.out.println();
	}

	private String[] createNewItemEffectsString() {
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
			"hit recovery (1=balance, 3=harmony)", //3B
			"fast block", //3C
			"+ damage done", //3D
			"random speed arrows", //3E
			"x-y damage done (unusual item damage)", //3F
			"altered durability", //40
			"no strength requirements", //41
			"spell charges", //42
			"attack speed (1=readiness, 4=haste)", //43
			"one handed", //44
			"+200% damage versus demons", //45
			"all resistances equal 0%", //46
			"unknown or n/a", //47
			"constantly lose life", //48
			"0-12.5% steal life", //49
			"infravision", //4A
			"positive armor class", //4B
			"armor class added to life", //4C
			"10% of mana added to armor class", //4D
			"+30-clvl% resist fire", //4E
			"negative armor class" //4F
		};
		return itemEffects;
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

	public byte[] getItemEffects() {
		return itemEffects;
	}

	public void setItemEffects(byte[] itemEffects) {
		this.itemEffects = itemEffects;
	}

	public long getMinimumEffectValue() {
		return minimumEffectValue;
	}

	public void setMinimumEffectValue(long minimumEffectValue) {
		this.minimumEffectValue = minimumEffectValue;
	}

	public long getMaximumEffectValue() {
		return maximumEffectValue;
	}

	public void setMaximumEffectValue(long maximumEffectValue) {
		this.maximumEffectValue = maximumEffectValue;
	}

	public long getQualityLevel() {
		return qualityLevel;
	}

	public void setQualityLevel(long qualityLevel) {
		this.qualityLevel = qualityLevel;
	}

	public String getOccurencePossibilities() {
		return occurencePossibilities;
	}

	public void setOccurencePossibilities(String occurencePossibilities) {
		this.occurencePossibilities = occurencePossibilities;
	}

	public int getByteTwentyThree() {
		return byteTwentyThree;
	}

	public void setByteTwentyThree(int byteTwentyThree) {
		this.byteTwentyThree = byteTwentyThree;
	}

	public String getExcludedComboIndicator() {
		return excludedComboIndicator;
	}

	public void setExcludedComboIndicator(String excludedComboIndicator) {
		this.excludedComboIndicator = excludedComboIndicator;
	}

	public long getCursedIndicator() {
		return cursedIndicator;
	}

	public void setCursedIndicator(long cursedIndicator) {
		this.cursedIndicator = cursedIndicator;
	}

	public long getMinGold() {
		return minGold;
	}

	public void setMinGold(long minGold) {
		this.minGold = minGold;
	}

	public long getMaxGold() {
		return maxGold;
	}

	public void setMaxGold(long maxGold) {
		this.maxGold = maxGold;
	}

	public long getValueMultiplier() {
		return valueMultiplier;
	}

	public void setValueMultiplier(long valueMultiplier) {
		this.valueMultiplier = valueMultiplier;
	}

	public byte[] getItemBytes() {
		return itemBytes;
	}

	public void setItemBytes(byte[] itemBytes) {
		this.itemBytes = itemBytes;
	}
}
