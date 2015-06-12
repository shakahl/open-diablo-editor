package uk.me.karlsen.ode;

public class Spell {

	String[] castingSounds = {"Fire", "Lighting", "Utility", "Other"};
	String[] animationsWhenCasting = {"fire", "lightning", "magic/other"};

	private int unmoddedSpellIndex;
	private int manaToCast;
	private int animationWhenCasting;
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
		if(byteArray.length != 56){
			System.err.println("byteArray supplied to Spell constructor of incorrect length (not 56).");
			System.exit(-1);
		}
		this.index = index+1; //spell index starts from 1, loop in SpellsStore starts from 0
		BinEditHelper beh = new BinEditHelper();
		//this.spellBytes = byteArray;
		unmoddedSpellIndex = beh.convertUnsignedByteToInt(byteArray[0]);
		manaToCast = beh.convertUnsignedByteToInt(byteArray[1]);
		animationWhenCasting = beh.convertTwoBytesToInt(byteArray[2], byteArray[3]);
		pointerToNameAsSpell = beh.convertFourBytesToOffset(byteArray, 4);
		nameAsSpell = getNameUsingPointer(pointerToNameAsSpell);
		if(byteArray[8] + byteArray[9] + byteArray[10] + byteArray[11] > 0){
			pointerToNameAsSkill = beh.convertFourBytesToOffset(byteArray, 8);
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
		spellbookQuality = beh.convertFourBytesToNumber(byteArray, 12);
		staffQuality = beh.convertFourBytesToNumber(byteArray, 16);
		byteTwenty = beh.convertUnsignedByteToInt(byteArray[20]);
		byteTwentyone = beh.convertUnsignedByteToInt(byteArray[21]);
		byteTwentytwo = beh.convertUnsignedByteToInt(byteArray[22]);
		byteTwentythree = beh.convertUnsignedByteToInt(byteArray[23]);
		spellActiveInTown = beh.convertFourBytesToNumber(byteArray, 24);
		baseRequiredMagic = beh.convertFourBytesToNumber(byteArray, 28);
		castingSound = beh.convertUnsignedByteToInt(byteArray[32]);
		spellEffects = new byte[3];
		spellEffects[0] = byteArray[33];
		spellEffects[1] = byteArray[34];
		spellEffects[2] = byteArray[35];
		manaStep = beh.convertUnsignedByteToInt(byteArray[36]);
		minCastingCost = beh.convertUnsignedByteToInt(byteArray[37]);
		byteThirtyEight = beh.convertUnsignedByteToInt(byteArray[38]);
		byteThirtyNine = beh.convertUnsignedByteToInt(byteArray[39]);
		minCharges = beh.convertFourBytesToNumber(byteArray, 40);
		maxCharges = beh.convertFourBytesToNumber(byteArray, 44);
		bookCost = beh.convertFourBytesToNumber(byteArray, 48);
		staffCostMultiplier = beh.convertFourBytesToNumber(byteArray, 52);
		
		if((pointerToNameAsSkill == 0) && (pointerToNameAsSpell != 0)){
			pointerToNameAsSkill = pointerToNameAsSpell;
		}
		if((pointerToNameAsSpell == 0) && (pointerToNameAsSkill != 0)){
			pointerToNameAsSpell = pointerToNameAsSkill;
		}
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
			"Unholy Altar portal (no effect)",//41
			"Apocalypse Fireplar?",//42
			"Apocalypse Fireplar?" //43
		};
		return spellEffects;
	}

	public byte[] getSpellAsBytes() {
		BinEditHelper beh = new BinEditHelper();
		byte[] spellAsBytes = new byte[56];
		spellAsBytes[0] = (byte) unmoddedSpellIndex;
		spellAsBytes[1] = (byte) manaToCast;
		spellAsBytes[2] = (byte) (animationWhenCasting >>> 0);
		spellAsBytes[3] = (byte) (animationWhenCasting >>> 8);
		beh.setPointerAsFourBytes(pointerToNameAsSpell, spellAsBytes, 4);
		beh.setPointerAsFourBytes(pointerToNameAsSkill, spellAsBytes, 8);
		beh.setLongAsFourBytes(spellbookQuality, spellAsBytes, 12);
		beh.setLongAsFourBytes(staffQuality, spellAsBytes, 16);
		spellAsBytes[20] = (byte) byteTwenty;
		spellAsBytes[21] = (byte) byteTwentyone;
		spellAsBytes[22] = (byte) byteTwentytwo;
		spellAsBytes[23] = (byte) byteTwentythree;
		beh.setLongAsFourBytes(spellActiveInTown, spellAsBytes, 24);
		beh.setLongAsFourBytes(baseRequiredMagic, spellAsBytes, 28);
		spellAsBytes[32] = (byte) castingSound;
		spellAsBytes[33] = (byte) spellEffects[0];
		spellAsBytes[34] = (byte) spellEffects[1];
		spellAsBytes[35] = (byte) spellEffects[2];
		spellAsBytes[36] = (byte) manaStep;
		spellAsBytes[37] = (byte) minCastingCost;
		spellAsBytes[38] = (byte) byteThirtyEight;
		spellAsBytes[39] = (byte) byteThirtyNine;
		beh.setLongAsFourBytes(minCharges, spellAsBytes, 40);
		beh.setLongAsFourBytes(maxCharges, spellAsBytes, 44);
		beh.setLongAsFourBytes(bookCost, spellAsBytes, 48);
		beh.setLongAsFourBytes(staffCostMultiplier, spellAsBytes, 52);

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
