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
		BinEditHelper beh = new BinEditHelper();
		namePointer = beh.convertFourBytesToOffset(readIn, 0);
		name = this.getNameUsingPointer(namePointer);
		itemType = beh.convertUnsignedByteToInt(readIn[4]);
		qualityLevel = beh.convertUnsignedByteToInt(readIn[5]);
		numberOfEffects = beh.convertTwoBytesToInt(readIn[6], readIn[7]);
		goldValue = beh.convertFourBytesToNumber(readIn, 8);
		effectOne = beh.convertFourBytesToNumber(readIn, 12);
		minValueOne = beh.convertFourBytesToNumber(readIn, 16);
		maxValueOne = beh.convertFourBytesToNumber(readIn, 20);
		effectTwo = beh.convertFourBytesToNumber(readIn, 24);
		minValueTwo = beh.convertFourBytesToNumber(readIn, 28);
		maxValueTwo = beh.convertFourBytesToNumber(readIn, 32);
		effectThree = beh.convertFourBytesToNumber(readIn, 36);
		minValueThree = beh.convertFourBytesToNumber(readIn, 40);
		maxValueThree = beh.convertFourBytesToNumber(readIn, 44);
		effectFour = beh.convertFourBytesToNumber(readIn, 48);
		minValueFour = beh.convertFourBytesToNumber(readIn, 52);
		maxValueFour = beh.convertFourBytesToNumber(readIn, 56);
		effectFive = beh.convertFourBytesToNumber(readIn, 60);
		minValueFive = beh.convertFourBytesToNumber(readIn, 64);
		maxValueFive = beh.convertFourBytesToNumber(readIn, 68);
		effectSix = beh.convertFourBytesToNumber(readIn, 72);
		minValueSix = beh.convertFourBytesToNumber(readIn, 76);
		maxValueSix = beh.convertFourBytesToNumber(readIn, 80);
	}

	public void printItem() {
		System.out.println("Name: " + name);
		System.out.println("Name pointer: " + namePointer);
		String[] itemTypesArray = UniqueItem.createNewItemTypeArray();
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
		BinEditHelper beh = new BinEditHelper();
		beh.setPointerAsFourBytes(namePointer, itemAsBytes, 0);
		itemAsBytes[4] = (byte) itemType;
		itemAsBytes[5] = (byte) qualityLevel;
		itemAsBytes[6] = (byte) (numberOfEffects >>> 0);
		itemAsBytes[7] = (byte) (numberOfEffects >>> 8);
		beh.setLongAsFourBytes(goldValue, itemAsBytes, 8);
		beh.setLongAsFourBytes(effectOne, itemAsBytes, 12);
		beh.setLongAsFourBytes(minValueOne, itemAsBytes, 16);
		beh.setLongAsFourBytes(maxValueOne, itemAsBytes, 20);
		beh.setLongAsFourBytes(effectTwo, itemAsBytes, 24);
		beh.setLongAsFourBytes(minValueTwo, itemAsBytes, 28);
		beh.setLongAsFourBytes(maxValueTwo, itemAsBytes, 32);
		beh.setLongAsFourBytes(effectThree, itemAsBytes, 36);
		beh.setLongAsFourBytes(minValueThree, itemAsBytes, 40);
		beh.setLongAsFourBytes(maxValueThree, itemAsBytes, 44);
		beh.setLongAsFourBytes(effectFour, itemAsBytes, 48);
		beh.setLongAsFourBytes(minValueFour, itemAsBytes, 52);
		beh.setLongAsFourBytes(maxValueFour, itemAsBytes, 56);
		beh.setLongAsFourBytes(effectFive, itemAsBytes, 60);
		beh.setLongAsFourBytes(minValueFive, itemAsBytes, 64);
		beh.setLongAsFourBytes(maxValueFive, itemAsBytes, 68);
		beh.setLongAsFourBytes(effectSix, itemAsBytes, 72);
		beh.setLongAsFourBytes(minValueSix, itemAsBytes, 76);
		beh.setLongAsFourBytes(maxValueSix, itemAsBytes, 80);

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
