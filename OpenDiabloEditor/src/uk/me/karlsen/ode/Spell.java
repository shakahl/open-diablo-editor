package uk.me.karlsen.ode;

public class Spell {

	String[] castingSounds = {"Fire", "Lighting", "Utility", "Other"};
	String[] animationsWhenCasting = {"fire", "lightning", "magic/other"};

	private int unmoddedSpellIndex;
	private int manaToCast;
	private int animatiyonWhenCasting;
	private long pointerToNameAsSpell;
	private String nameAsSpell;
	private long pointerToNameAsSkill;
	private String nameAsSkill;
	private long spellbookQuality;
	private long staffQuality;
	private int byteTwenty;
	private int byteTwentyone;
	private int byteTwentytwo;
	private int byteTwentythree;
	private long spellActiveInTown;
	private long baseRequiredMagic;
	private int castingSound;
	private byte[] spellEffects;
	private int manaStep;
	private int minCastingCost;
	private int byteThirtyEight;
	private int byteThirtyNine;
	private long minCharges;
	private long maxCharges;
	private long bookCost;
	private long staffCostMultiplier;
	//private byte[] spellBytes;
	int index;

	public Spell(int index, byte[] byteArray, ReaderWriter rw) {
		this.index = index+1; //spell index starts from 1, loop in SpellsStore starts from 0
		if(byteArray.length != 56){
			System.err.println("byteArray supplied to Spell constructor of incorrect length (not 56).");
			System.exit(-1);
		}
		//this.spellBytes = byteArray;
		unmoddedSpellIndex = rw.convertUnsignedByteToInt(byteArray[0]);
		manaToCast = rw.convertUnsignedByteToInt(byteArray[1]);
		animationWhenCasting = rw.convertTwoBytesToInt(byteArray[2], byteArray[3]);
		pointerToNameAsSpell = rw.convertFourBytesToOffset(byteArray[4], byteArray[5], byteArray[6], byteArray[7]);
		nameAsSpell = getNameUsingPointer(pointerToNameAsSpell);
		if(byteArray[8] + byteArray[9] + byteArray[10] + byteArray[11] > 0){
			pointerToNameAsSkill = rw.convertFourBytesToOffset(byteArray[8], byteArray[9], byteArray[10], byteArray[11]);
		} else {
			pointerToNameAsSkill = 0; //sometimes pointer is 00000000 and therefore useless
		}
		if(pointerToNameAsSkill != 0){
			nameAsSkill = getNameUsingPointer(pointerToNameAsSkill);
		} else {
			nameAsSkill = "not set";
		}
		if((pointerToNameAsSkill == 0) && (pointerToNameAsSpell != 0)){
			pointerToNameAsSkill = pointerToNameAsSpell;
		}
		if((pointerToNameAsSpell == 0) && (pointerToNameAsSkill != 0)){
			pointerToNameAsSpell = pointerToNameAsSkill;
		}
		spellbookQuality = rw.convertFourBytesToNumber(byteArray[12], byteArray[13], byteArray[14], byteArray[15]);
		staffQuality = rw.convertFourBytesToNumber(byteArray[16], byteArray[17], byteArray[18], byteArray[19]);
		byteTwenty = rw.convertUnsignedByteToInt(byteArray[20]);
		byteTwentyone = rw.convertUnsignedByteToInt(byteArray[21]);
		byteTwentytwo = rw.convertUnsignedByteToInt(byteArray[22]);
		byteTwentythree = rw.convertUnsignedByteToInt(byteArray[23]);
		spellActiveInTown = rw.convertFourBytesToNumber(byteArray[24], byteArray[25], byteArray[26], byteArray[27]);
		baseRequiredMagic = rw.convertFourBytesToNumber(byteArray[28], byteArray[29], byteArray[30], byteArray[31]);
		castingSound = rw.convertUnsignedByteToInt(byteArray[32]);
		spellEffects = new byte[3];
		spellEffects[0] = byteArray[33];
		spellEffects[1] = byteArray[34];
		spellEffects[2] = byteArray[35];
		manaStep = rw.convertUnsignedByteToInt(byteArray[36]);
		minCastingCost = rw.convertUnsignedByteToInt(byteArray[37]);
		byteThirtyEight = rw.convertUnsignedByteToInt(byteArray[38]);
		byteThirtyNine = rw.convertUnsignedByteToInt(byteArray[39]);
		minCharges = rw.convertFourBytesToNumber(byteArray[40], byteArray[41], byteArray[42], byteArray[43]);
		maxCharges = rw.convertFourBytesToNumber(byteArray[44], byteArray[45], byteArray[46], byteArray[47]);
		bookCost = rw.convertFourBytesToNumber(byteArray[48], byteArray[49], byteArray[50], byteArray[51]);
		staffCostMultiplier = rw.convertFourBytesToNumber(byteArray[52], byteArray[53], byteArray[54], byteArray[55]);
	}

	//TODO -- refactor duplicate code (is in Spell and ShrinesStore)
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
		String name = new String(bytes, 0, endByte);
		return name;
	}

	//Important note: Gap bytes are 32, whereas end-of-strings are 0
	public void printSpell() {
		System.out.println("Spell #: " + index);
		String[] unmoddedSpellNames = TomeOfKnowledge.createSpellNamesArray();
		String[] spellEffectsStrings = createSpellEffectsArray();
		System.out.println("Unmodded Name: " + unmoddedSpellNames[unmoddedSpellIndex]);
		System.out.println("Mana to cast + mana from reading: " + manaToCast);
		System.out.println("Animation when casting: " + animationsWhenCasting[animationWhenCasting]);
		System.out.println("Pointer to name as spell: " + pointerToNameAsSpell);
		System.out.println("Name as spell: " + nameAsSpell);
		if(pointerToNameAsSkill != -1){
			System.out.println("Pointer to name as skill: " + pointerToNameAsSkill);
		} else {
			System.out.println("Pointer to name as skill: not set");
		}
		System.out.println("Name as skill: " + nameAsSkill);
		System.out.println("Quality level of spellbook: " + spellbookQuality);
		System.out.println("Quality level of staff: " + staffQuality);
		System.out.println("Byte twenty: " + byteTwenty);
		System.out.println("Byte twentyone: " + byteTwentyone);
		System.out.println("Byte twentytwo: " + byteTwentytwo);
		System.out.println("Byte twentythree: " + byteTwentythree);
		System.out.println("Spell active in town: " + spellActiveInTown);
		System.out.println("Base required magic: " + baseRequiredMagic);
		int castingSoundIndex = -1;
		if(castingSound == 76){
			castingSoundIndex = 0;
		} else if (castingSound == 78) {
			castingSoundIndex = 1;
		} else if (castingSound == 80) {
			castingSoundIndex = 2;
		} else if (castingSound == 82) {
			castingSoundIndex = 3;
		} else {
			//do nothing
		}
		System.out.println("Casting sound: " + castingSounds[castingSoundIndex]);
		System.out.println("Spell Effects: " + spellEffectsStrings[spellEffects[0]] + "; " + spellEffectsStrings[spellEffects[1]] + "; " + spellEffectsStrings[spellEffects[2]]);
		System.out.println("Mana step: " + manaStep);
		System.out.println("Min casting cost: " + minCastingCost);
		System.out.println("Zero: " + byteThirtyEight);
		System.out.println("Zero: " + byteThirtyNine);
		System.out.println("Min charges: " + minCharges);
		System.out.println("Max charges: " + maxCharges);
		System.out.println("Book cost: " + bookCost);
		System.out.println("Staff cost multiplier: " + staffCostMultiplier);
		System.out.println();
	}

	private String[] createSpellEffectsArray() {
		String[] spellEffects = {
			"Misc effect", //00
			"Firebolt", //01
			"Guardian", //02
			"Phasing", //03
			"Lightning Ball (no damage)", //04
			"Fire Trap", //05
			"Fireball", //06
			"Lightning", //07
			"Lightning Trap (no damage)", //08
			"Magblos?", //09
			"Town Portal", //0A
			"Flash (bottom side)", //0B
			"Flash (top side)", //OC
			"Mana Shield", //0D
			"Another type of Flame Wave", //0E
			"Chain Lightning", //0F
			"Crash!!!", //10
			"Blood", //11
			"looks like the impact of the Bone Spirit spell", //12
			"Stone Curse dust??", //13
			"Gloom?", //14
			"Magball?", //15
			"Thin lightning (many)", //16
			"Thin lightning", //17
			"Blood Star", //18
			"Flare explosion", //19
			"Teleport", //1A
			"Fire Arrow", //1B
			"Doom", //1C
			"Another Fire Trap", //1D
			"Stone Curse", //1E
			"No effect", //1F
			"Invisible", //20
			"Golem", //21
			"Etherealize", //22
			"Blodbur?", //23
			"Apocalypse?", //24
			"Healing", //25
			"Fire Wall", //26
			"Infravision", //27
			"Identify", //28
			"Flame Wave", //29
			"Nova", //2A
			"Blood Boil", //2B
			"Apocalypse", //2C
			"Item Repair", //2D
			"Staff Recharge", //2E
			"Trap Disarm", //2F
			"Inferno?", //30
			"Inferno", //31
			"Golem?", //32
			"Krull", //33
			"Charged Bolt", //34
			"Holy Bolt", //35
			"Resurrect", //36
			"Telekinesis", //37
			"Lightning arrow", //38
			"Acid bf?", //39
			"Acid splash", //3A
			"Acid pud", //3B
			"Heal Other", //3C
			"Elemental", //3D
			"Resurrect (sun ray)", //3E
			"Bone Spirit", // 3F
			"charged bolt..small...on caster..no damage", //40
			"Unholy Altar portal (no effect)"//41
			"Apocalypse Fireplar?"//42
			"Apocalypse Fireplar?"//43
		};
		return spellEffects;
	}

	public byte[] getSpellAsBytes() {
		byte[] spellAsBytes = new byte[56];
		spellAsBytes[0] = (byte) unmoddedSpellIndex;
		spellAsBytes[1] = (byte) manaToCast;
		spellAsBytes[2] = (byte) (animationWhenCasting >>> 0);
		spellAsBytes[3] = (byte) (animationWhenCasting >>> 8);
		long spellNamePonterRev = 0;
		if(pointerToNameAsSpell > 0){
			spellNamePonterRev = pointerToNameAsSpell + TomeOfKnowledge.DIABLO_POINTERS_OFFSET;
		}
		spellAsBytes[4] = (byte) (spellNamePonterRev >>> 0);
		spellAsBytes[5] = (byte) (spellNamePonterRev >>> 8);
		spellAsBytes[6] = (byte) (spellNamePonterRev >>> 16);
		spellAsBytes[7] = (byte) (spellNamePonterRev >>> 24);
		long skillNamePointerRev = 0;
		if(pointerToNameAsSkill > 0){
			skillNamePointerRev = pointerToNameAsSkill + TomeOfKnowledge.DIABLO_POINTERS_OFFSET;
		}
		if((pointerToNameAsSkill == 0) && (pointerToNameAsSpell != 0)){
			pointerToNameAsSkill = pointerToNameAsSpell;
		}
		if((pointerToNameAsSpell == 0) && (pointerToNameAsSkill != 0)){
			pointerToNameAsSpell = pointerToNameAsSkill;
		}
		spellAsBytes[8] = (byte) (skillNamePointerRev >>> 0);
		spellAsBytes[9] = (byte) (skillNamePointerRev >>> 8);
		spellAsBytes[10] = (byte) (skillNamePointerRev >>> 16);
		spellAsBytes[11] = (byte) (skillNamePointerRev >>> 24);
		spellAsBytes[12] = (byte) (spellbookQuality >>> 0); //spellbookQuality
		spellAsBytes[13] = (byte) (spellbookQuality >>> 8); //spellbookQuality
		spellAsBytes[14] = (byte) (spellbookQuality >>> 16); //spellbookQuality
		spellAsBytes[15] = (byte) (spellbookQuality >>> 24); //spellbookQuality
		spellAsBytes[16] = (byte) (staffQuality >>> 0); //staffQuality
		spellAsBytes[17] = (byte) (staffQuality >>> 8); //staffQuality
		spellAsBytes[18] = (byte) (staffQuality >>> 16); //staffQuality
		spellAsBytes[19] = (byte) (staffQuality >>> 24); //staffQuality
		spellAsBytes[20] = (byte) byteTwenty;
		spellAsBytes[21] = (byte) byteTwentyone;
		spellAsBytes[22] = (byte) byteTwentytwo;
		spellAsBytes[23] = (byte) byteTwentythree;
		spellAsBytes[24] = (byte) (spellActiveInTown >>> 0); //spellActiveInTown
		spellAsBytes[25] = (byte) (spellActiveInTown >>> 8); //spellActiveInTown
		spellAsBytes[26] = (byte) (spellActiveInTown >>> 16); //spellActiveInTown
		spellAsBytes[27] = (byte) (spellActiveInTown >>> 24); //spellActiveInTown
		spellAsBytes[28] = (byte) (baseRequiredMagic >>> 0); //baseRequiredMagic
		spellAsBytes[29] = (byte) (baseRequiredMagic >>> 8); //baseRequiredMagic
		spellAsBytes[30] = (byte) (baseRequiredMagic >>> 16); //baseRequiredMagic
		spellAsBytes[31] = (byte) (baseRequiredMagic >>> 24); //baseRequiredMagic
		spellAsBytes[32] = (byte) castingSound;
		spellAsBytes[33] = (byte) spellEffects[0];
		spellAsBytes[34] = (byte) spellEffects[1];
		spellAsBytes[35] = (byte) spellEffects[2];
		spellAsBytes[36] = (byte) manaStep;
		spellAsBytes[37] = (byte) minCastingCost;
		spellAsBytes[38] = (byte) byteThirtyEight;
		spellAsBytes[39] = (byte) byteThirtyNine;
		spellAsBytes[40] = (byte) (minCharges >>> 0); //minCharges
		spellAsBytes[41] = (byte) (minCharges >>> 8); //minCharges
		spellAsBytes[42] = (byte) (minCharges >>> 16); //minCharges
		spellAsBytes[43] = (byte) (minCharges >>> 24); //minCharges
		spellAsBytes[44] = (byte) (maxCharges >>> 0); //maxCharges
		spellAsBytes[45] = (byte) (maxCharges >>> 8); //maxCharges
		spellAsBytes[46] = (byte) (maxCharges >>> 16); //maxCharges
		spellAsBytes[47] = (byte) (maxCharges >>> 24); //maxCharges
		spellAsBytes[48] = (byte) (bookCost >>> 0); //bookCost
		spellAsBytes[49] = (byte) (bookCost >>> 8); //bookCost
		spellAsBytes[50] = (byte) (bookCost >>> 16); //bookCost
		spellAsBytes[51] = (byte) (bookCost >>> 24); //bookCost
		spellAsBytes[52] = (byte) (staffCostMultiplier >>> 0); //staffCostMultiplier
		spellAsBytes[53] = (byte) (staffCostMultiplier >>> 8); //staffCostMultiplier
		spellAsBytes[54] = (byte) (staffCostMultiplier >>> 16); //staffCostMultiplier
		spellAsBytes[55] = (byte) (staffCostMultiplier >>> 24); //staffCostMultiplier

		//System.out.println("ORIG: " + Arrays.toString(spellBytes));
		//System.out.println("BACK: " + Arrays.toString(spellAsBytes));
		//System.out.println();

		return spellAsBytes;
	}

	public int getUnmoddedSpellIndex() {
		return unmoddedSpellIndex;
	}

	public void setUnmoddedSpellIndex(int unmoddedSpellIndex) {
		this.unmoddedSpellIndex = unmoddedSpellIndex;
	}

	public int getManaToCast() {
		return manaToCast;
	}

	public void setManaToCast(int manaToCast) {
		this.manaToCast = manaToCast;
	}

	public int getAnimationWhenCasting() {
		return animationWhenCasting;
	}

	public void setAnimationWhenCasting(int animationWhenCasting) {
		this.animationWhenCasting = animationWhenCasting;
	}

	public long getPointerToNameAsSpell() {
		return pointerToNameAsSpell;
	}

	public void setPointerToNameAsSpell(long pointerToNameAsSpell) {
		this.pointerToNameAsSpell = pointerToNameAsSpell;
	}

	public String getNameAsSpell() {
		return nameAsSpell;
	}

	public void setNameAsSpell(String nameAsSpell) {
		this.nameAsSpell = nameAsSpell;
	}

	public long getPointerToNameAsSkill() {
		return pointerToNameAsSkill;
	}

	public void setPointerToNameAsSkill(long pointerToNameAsSkill) {
		this.pointerToNameAsSkill = pointerToNameAsSkill;
	}

	public String getNameAsSkill() {
		return nameAsSkill;
	}

	public void setNameAsSkill(String nameAsSkill) {
		this.nameAsSkill = nameAsSkill;
	}

	public long getSpellbookQuality() {
		return spellbookQuality;
	}

	public void setSpellbookQuality(long spellbookQuality) {
		this.spellbookQuality = spellbookQuality;
	}

	public long getStaffQuality() {
		return staffQuality;
	}

	public void setStaffQuality(long staffQuality) {
		this.staffQuality = staffQuality;
	}

	public int getByteTwenty() {
		return byteTwenty;
	}

	public void setByteTwenty(int byteTwenty) {
		this.byteTwenty = byteTwenty;
	}

	public int getByteTwentyone() {
		return byteTwentyone;
	}

	public void setByteTwentyone(int byteTwentyone) {
		this.byteTwentyone = byteTwentyone;
	}

	public int getByteTwentytwo() {
		return byteTwentytwo;
	}

	public void setByteTwentytwo(int byteTwentytwo) {
		this.byteTwentytwo = byteTwentytwo;
	}

	public int getByteTwentythree() {
		return byteTwentythree;
	}

	public void setByteTwentythree(int byteTwentythree) {
		this.byteTwentythree = byteTwentythree;
	}

	public long getSpellActiveInTown() {
		return spellActiveInTown;
	}

	public void setSpellActiveInTown(long spellActiveInTown) {
		this.spellActiveInTown = spellActiveInTown;
	}

	public long getBaseRequiredMagic() {
		return baseRequiredMagic;
	}

	public void setBaseRequiredMagic(long baseRequiredMagic) {
		this.baseRequiredMagic = baseRequiredMagic;
	}

	public int getCastingSound() {
		return castingSound;
	}

	public void setCastingSound(int castingSound) {
		this.castingSound = castingSound;
	}

	public byte[] getSpellEffects() {
		return spellEffects;
	}

	public void setSpellEffects(byte[] spellEffects) {
		this.spellEffects = spellEffects;
	}

	public int getManaStep() {
		return manaStep;
	}

	public void setManaStep(int manaStep) {
		this.manaStep = manaStep;
	}

	public int getMinCastingCost() {
		return minCastingCost;
	}

	public void setMinCastingCost(int minCastingCost) {
		this.minCastingCost = minCastingCost;
	}

	public int getByteThirtyEight() {
		return byteThirtyEight;
	}

	public void setByteThirtyEight(int byteThirtyEight) {
		this.byteThirtyEight = byteThirtyEight;
	}

	public int getByteThirtyNine() {
		return byteThirtyNine;
	}

	public void setByteThirtyNine(int byteThirtyNine) {
		this.byteThirtyNine = byteThirtyNine;
	}

	public long getMinCharges() {
		return minCharges;
	}

	public void setMinCharges(long minCharges) {
		this.minCharges = minCharges;
	}

	public long getMaxCharges() {
		return maxCharges;
	}

	public void setMaxCharges(long maxCharges) {
		this.maxCharges = maxCharges;
	}

	public long getBookCost() {
		return bookCost;
	}

	public void setBookCost(long bookCost) {
		this.bookCost = bookCost;
	}

	public long getStaffCostMultiplier() {
		return staffCostMultiplier;
	}

	public void setStaffCostMultiplier(long staffCostMultiplier) {
		this.staffCostMultiplier = staffCostMultiplier;
	}
}
