package uk.me.karlsen.ode;

public class UniqueItem {

	private long namePointer;
	private String name;
	private int itemType;
	private int qualityLevel;
	private int numberOfEffects;
	private long goldValue;
	private long effectOne;
	private long minValueOne;
	private long maxValueOne;
	private long effectTwo;
	private long minValueTwo;
	private long maxValueTwo;
	private long effectThree;
	private long minValueThree;
	private long maxValueThree;
	private long effectFour;
	private long minValueFour;
	private long maxValueFour;
	private long effectFive;
	private long minValueFive;
	private long maxValueFive;
	private long effectSix;
	private long minValueSix;
	private long maxValueSix;
	//private byte[] itemBytes;

	public UniqueItem(byte[] readIn, ReaderWriter rw){
		//this.itemBytes = readIn;
		namePointer = rw.convertFourBytesToOffset(readIn[0], readIn[1], readIn[2], readIn[3]);
		name = this.getNameUsingPointer(namePointer);
		itemType = rw.convertUnsignedByteToInt(readIn[4]);
		qualityLevel = rw.convertUnsignedByteToInt(readIn[5]);
		numberOfEffects = rw.convertTwoBytesToInt(readIn[6], readIn[7]);
		goldValue = rw.convertFourBytesToNumber(readIn[8], readIn[9], readIn[10], readIn[11]);
		effectOne = rw.convertFourBytesToNumber(readIn[12], readIn[13], readIn[14], readIn[15]);
		minValueOne = rw.convertFourBytesToNumber(readIn[16], readIn[17], readIn[18], readIn[19]);
		maxValueOne = rw.convertFourBytesToNumber(readIn[20], readIn[21], readIn[22], readIn[23]);
		effectTwo = rw.convertFourBytesToNumber(readIn[24], readIn[25], readIn[26], readIn[27]);
		minValueTwo = rw.convertFourBytesToNumber(readIn[28], readIn[29], readIn[30], readIn[31]);
		maxValueTwo = rw.convertFourBytesToNumber(readIn[32], readIn[33], readIn[34], readIn[35]);
		effectThree = rw.convertFourBytesToNumber(readIn[36], readIn[37], readIn[38], readIn[39]);
		minValueThree = rw.convertFourBytesToNumber(readIn[40], readIn[41], readIn[42], readIn[43]);
		maxValueThree = rw.convertFourBytesToNumber(readIn[44], readIn[45], readIn[46], readIn[47]);
		effectFour = rw.convertFourBytesToNumber(readIn[48], readIn[49], readIn[50], readIn[51]);
		minValueFour = rw.convertFourBytesToNumber(readIn[52], readIn[53], readIn[54], readIn[55]);
		maxValueFour = rw.convertFourBytesToNumber(readIn[56], readIn[57], readIn[58], readIn[59]);
		effectFive = rw.convertFourBytesToNumber(readIn[60], readIn[61], readIn[62], readIn[63]);
		minValueFive = rw.convertFourBytesToNumber(readIn[64], readIn[65], readIn[66], readIn[67]);
		maxValueFive = rw.convertFourBytesToNumber(readIn[68], readIn[69], readIn[70], readIn[71]);
		effectSix = rw.convertFourBytesToNumber(readIn[72], readIn[73], readIn[74], readIn[75]);
		minValueSix = rw.convertFourBytesToNumber(readIn[76], readIn[77], readIn[78], readIn[79]);
		maxValueSix = rw.convertFourBytesToNumber(readIn[80], readIn[81], readIn[82], readIn[83]);
	}

	public void printItem() {
		System.out.println("Name: " + name);
		System.out.println("Name pointer: " + namePointer);
		String[] itemTypesArray = this.createNewItemTypeArray();
		System.out.println("Item type: " + itemTypesArray[itemType]);
		System.out.println("Quality level: " + qualityLevel);
		System.out.println("Number of effects: " + numberOfEffects);
		System.out.println("Gold value: " + goldValue);
		String[] effectsArray = this.createNewItemEffectsArray();
		System.out.println("Effect one: " + effectsArray[(int) effectOne] +"; " + minValueOne + "; " + maxValueOne);
		System.out.println("Effect two: " + effectsArray[(int) effectTwo] +"; " + minValueTwo + "; " + maxValueTwo);
		System.out.println("Effect three: " + effectsArray[(int) effectThree] +"; " + minValueThree +"; " + maxValueThree);
		System.out.println("Effect four: " + effectsArray[(int) effectFour] +"; " + minValueFour +"; " + effectFour);
		System.out.println("Effect five: " + effectsArray[(int) effectFive] +"; " + minValueFive +"; " + effectFive);
		System.out.println("Effect six: " + effectsArray[(int) effectSix] +"; " + minValueSix +"; " + effectSix);
		System.out.println();
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

	public static String[] createNewItemTypeArray(){
		String[] uniqueItemTypesArray = {
			"nullString", //0
			"Short Bow", //1 (01)
			"Long Bow", //2 (02)
			"Hunter Bow", //3 (03)
			"Composite Bow", //4 (04)
			"Long War Bow", //05
			"Long Battle Bow", //06
			"Dagger", //06
			"Falchion", //08
			"Claymore", //09
			"Broad Sword", //0A
			"Sabre", //0B
			"Scimitar", //0C
			"Long Sword", //0D
			"Bastard Sword", //0E
			"Two Handed Sword", //0F
			"Great Sword", //10
			"Cleaver", //11
			"Large Axe", //12
			"Broad Axe", //13
			"Small Axe", //14
			"Battle Axe", //15
			"Great Axe", //16
			"Mace", //17
			"Morning Star", //18
			"Club , Spiked Club", //19
			"Maul", //1A
			"War Hammer", //1B
			"Flail", //1C
			"Long Staff", //1D
			"Short Staff", //1E
			"Composite Staff", //1F
			"Quarter Staff", //20
			"War Staff", //21
			"Skull Cap", //22
			"Helm", //23
			"Great Helm", //24
			"Crown", //25
			"CRASH!!!", //26
			"Rags", //27
			"Studded Leather Armor", //28
			"Cloak", //29
			"Robe", //2A
			"Chain Mail", //2B
			"Leather Armor", //2C
			"Breast Plate", //2D
			"Cape", //2E
			"Plate Mail", //2F
			"Full Plate Mail", //30
			"Buckler", //31
			"Small Shield", //32
			"Large Shield", //33
			"Kite Shield", //34
			"Tower Shield , Gothic Shield", //35
			"Ring", //36
			"some phucked up scroll", //37
			"Amulet", //38
			"Undead Crown", //39
			"Empyrean Band", //3A
			"Optic Amulet", //3B
			"Ring of Truth", //3C
			"Harlequin Crest", //3D
			"Map of the Stars", //3E
			"Golden Elixir", //3F
			"Arkaine's Valor", //40
			"Veil of Steel", //41
			"Griswold's Edge", //42
			"Lightforge", //43
			"Staff of Lazarus" //44
		};
		return uniqueItemTypesArray;
	}

	//TODO -- refactor duplicate code (is in Spell and ShrinesStore and ItemModifier)
	private String getNameUsingPointer(long pointer){
		ReaderWriter rwTemp = new ReaderWriter(true);
		rwTemp.seek(pointer);
		byte[] bytes = rwTemp.readBytes(20);
		int endByte = -1;
		for(int i = 0; i < bytes.length; i++){
			if(bytes[i] == 0){
				endByte = i;
				break;
			}
		}
		String name;
		if(endByte == -1){
			name = "";
		} else {
			name = new String(bytes, 0, endByte);
		}
		return name;
	}

	public byte[] getItemAsBytes() {
		byte[] itemAsBytes = new byte[84];
		long namePointerRev = namePointer + TomeOfKnowledge.DIABLO_POINTERS_OFFSET;
		itemAsBytes[0] = (byte) (namePointerRev >>> 0);
		itemAsBytes[1] = (byte) (namePointerRev >>> 8);
		itemAsBytes[2] = (byte) (namePointerRev >>> 16);
		itemAsBytes[3] = (byte) (namePointerRev >>> 24);
		itemAsBytes[4] = (byte) itemType;
		itemAsBytes[5] = (byte) qualityLevel;
		itemAsBytes[6] = (byte) (numberOfEffects >>> 0);
		itemAsBytes[7] = (byte) (numberOfEffects >>> 8);
		itemAsBytes[8] = (byte) (goldValue >>> 0);
		itemAsBytes[9] = (byte) (goldValue >>> 8);
		itemAsBytes[10] = (byte) (goldValue >>> 16);
		itemAsBytes[11] = (byte) (goldValue >>> 24);
		itemAsBytes[12] = (byte) (effectOne >>> 0);
		itemAsBytes[13] = (byte) (effectOne >>> 8);
		itemAsBytes[14] = (byte) (effectOne >>> 16);
		itemAsBytes[15] = (byte) (effectOne >>> 24);
		itemAsBytes[16] = (byte) (minValueOne >>> 0);
		itemAsBytes[17] = (byte) (minValueOne >>> 8);
		itemAsBytes[18] = (byte) (minValueOne >>> 16);
		itemAsBytes[19] = (byte) (minValueOne >>> 24);
		itemAsBytes[20] = (byte) (maxValueOne >>> 0);
		itemAsBytes[21] = (byte) (maxValueOne >>> 8);
		itemAsBytes[22] = (byte) (maxValueOne >>> 16);
		itemAsBytes[23] = (byte) (maxValueOne >>> 24);
		itemAsBytes[24] = (byte) (effectTwo >>> 0);
		itemAsBytes[25] = (byte) (effectTwo >>> 8);
		itemAsBytes[26] = (byte) (effectTwo >>> 16);
		itemAsBytes[27] = (byte) (effectTwo >>> 24);
		itemAsBytes[28] = (byte) (minValueTwo >>> 0);
		itemAsBytes[29] = (byte) (minValueTwo >>> 8);
		itemAsBytes[30] = (byte) (minValueTwo >>> 16);
		itemAsBytes[31] = (byte) (minValueTwo >>> 24);
		itemAsBytes[32] = (byte) (maxValueTwo >>> 0);
		itemAsBytes[33] = (byte) (maxValueTwo >>> 8);
		itemAsBytes[34] = (byte) (maxValueTwo >>> 16);
		itemAsBytes[35] = (byte) (maxValueTwo >>> 24);
		itemAsBytes[36] = (byte) (effectThree >>> 0);
		itemAsBytes[37] = (byte) (effectThree >>> 8);
		itemAsBytes[38] = (byte) (effectThree >>> 16);
		itemAsBytes[39] = (byte) (effectThree >>> 24);
		itemAsBytes[40] = (byte) (minValueThree >>> 0);
		itemAsBytes[41] = (byte) (minValueThree >>> 8);
		itemAsBytes[42] = (byte) (minValueThree >>> 16);
		itemAsBytes[43] = (byte) (minValueThree >>> 24);
		itemAsBytes[44] = (byte) (maxValueThree >>> 0);
		itemAsBytes[45] = (byte) (maxValueThree >>> 8);
		itemAsBytes[46] = (byte) (maxValueThree >>> 16);
		itemAsBytes[47] = (byte) (maxValueThree >>> 24);
		itemAsBytes[48] = (byte) (effectFour >>> 0);
		itemAsBytes[49] = (byte) (effectFour >>> 8);
		itemAsBytes[50] = (byte) (effectFour >>> 16);
		itemAsBytes[51] = (byte) (effectFour >>> 24);
		itemAsBytes[52] = (byte) (minValueFour >>> 0);
		itemAsBytes[53] = (byte) (minValueFour >>> 8);
		itemAsBytes[54] = (byte) (minValueFour >>> 16);
		itemAsBytes[55] = (byte) (minValueFour >>> 24);
		itemAsBytes[56] = (byte) (maxValueFour >>> 0);
		itemAsBytes[57] = (byte) (maxValueFour >>> 8);
		itemAsBytes[58] = (byte) (maxValueFour >>> 16);
		itemAsBytes[59] = (byte) (maxValueFour >>> 24);
		itemAsBytes[60] = (byte) (effectFive >>> 0);
		itemAsBytes[61] = (byte) (effectFive >>> 8);
		itemAsBytes[62] = (byte) (effectFive >>> 16);
		itemAsBytes[63] = (byte) (effectFive >>> 24);
		itemAsBytes[64] = (byte) (minValueFive >>> 0);
		itemAsBytes[65] = (byte) (minValueFive >>> 8);
		itemAsBytes[66] = (byte) (minValueFive >>> 16);
		itemAsBytes[67] = (byte) (minValueFive >>> 24);
		itemAsBytes[68] = (byte) (maxValueFive >>> 0);
		itemAsBytes[69] = (byte) (maxValueFive >>> 8);
		itemAsBytes[70] = (byte) (maxValueFive >>> 16);
		itemAsBytes[71] = (byte) (maxValueFive >>> 24);
		itemAsBytes[72] = (byte) (effectSix >>> 0);
		itemAsBytes[73] = (byte) (effectSix >>> 8);
		itemAsBytes[74] = (byte) (effectSix >>> 16);
		itemAsBytes[75] = (byte) (effectSix >>> 24);
		itemAsBytes[76] = (byte) (minValueSix >>> 0);
		itemAsBytes[77] = (byte) (minValueSix >>> 8);
		itemAsBytes[78] = (byte) (minValueSix >>> 16);
		itemAsBytes[79] = (byte) (minValueSix >>> 24);
		itemAsBytes[80] = (byte) (maxValueSix >>> 0);
		itemAsBytes[81] = (byte) (maxValueSix >>> 8);
		itemAsBytes[82] = (byte) (maxValueSix >>> 16);
		itemAsBytes[83] = (byte) (maxValueSix >>> 24);

		//System.out.println("ORIG: " + Arrays.toString(itemBytes));
		//System.out.println("BACK: " + Arrays.toString(itemAsBytes));
		//System.out.println();

		return itemAsBytes;
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

	public int getItemType() {
		return itemType;
	}

	public void setItemType(int itemType) {
		this.itemType = itemType;
	}

	public int getQualityLevel() {
		return qualityLevel;
	}

	public void setQualityLevel(int qualityLevel) {
		this.qualityLevel = qualityLevel;
	}

	public int getNumberOfEffects() {
		return numberOfEffects;
	}

	public void setNumberOfEffects(int numberOfEffects) {
		this.numberOfEffects = numberOfEffects;
	}

	public long getGoldValue() {
		return goldValue;
	}

	public void setGoldValue(long goldValue) {
		this.goldValue = goldValue;
	}

	public long getEffectOne() {
		return effectOne;
	}

	public void setEffectOne(long effectOne) {
		this.effectOne = effectOne;
	}

	public long getMinValueOne() {
		return minValueOne;
	}

	public void setMinValueOne(long minValueOne) {
		this.minValueOne = minValueOne;
	}

	public long getMaxValueOne() {
		return maxValueOne;
	}

	public void setMaxValueOne(long maxValueOne) {
		this.maxValueOne = maxValueOne;
	}

	public long getEffectTwo() {
		return effectTwo;
	}

	public void setEffectTwo(long effectTwo) {
		this.effectTwo = effectTwo;
	}

	public long getMinValueTwo() {
		return minValueTwo;
	}

	public void setMinValueTwo(long minValueTwo) {
		this.minValueTwo = minValueTwo;
	}

	public long getMaxValueTwo() {
		return maxValueTwo;
	}

	public void setMaxValueTwo(long maxValueTwo) {
		this.maxValueTwo = maxValueTwo;
	}

	public long getEffectThree() {
		return effectThree;
	}

	public void setEffectThree(long effectThree) {
		this.effectThree = effectThree;
	}

	public long getMinValueThree() {
		return minValueThree;
	}

	public void setMinValueThree(long minValueThree) {
		this.minValueThree = minValueThree;
	}

	public long getMaxValueThree() {
		return maxValueThree;
	}

	public void setMaxValueThree(long maxValueThree) {
		this.maxValueThree = maxValueThree;
	}

	public long getEffectFour() {
		return effectFour;
	}

	public void setEffectFour(long effectFour) {
		this.effectFour = effectFour;
	}

	public long getMinValueFour() {
		return minValueFour;
	}

	public void setMinValueFour(long minValueFour) {
		this.minValueFour = minValueFour;
	}

	public long getMaxValueFour() {
		return maxValueFour;
	}

	public void setMaxValueFour(long maxValueFour) {
		this.maxValueFour = maxValueFour;
	}

	public long getEffectFive() {
		return effectFive;
	}

	public void setEffectFive(long effectFive) {
		this.effectFive = effectFive;
	}

	public long getMinValueFive() {
		return minValueFive;
	}

	public void setMinValueFive(long minValueFive) {
		this.minValueFive = minValueFive;
	}

	public long getMaxValueFive() {
		return maxValueFive;
	}

	public void setMaxValueFive(long maxValueFive) {
		this.maxValueFive = maxValueFive;
	}

	public long getEffectSix() {
		return effectSix;
	}

	public void setEffectSix(long effectSix) {
		this.effectSix = effectSix;
	}

	public long getMinValueSix() {
		return minValueSix;
	}

	public void setMinValueSix(long minValueSix) {
		this.minValueSix = minValueSix;
	}

	public long getMaxValueSix() {
		return maxValueSix;
	}

	public void setMaxValueSix(long maxValueSix) {
		this.maxValueSix = maxValueSix;
	}
}
