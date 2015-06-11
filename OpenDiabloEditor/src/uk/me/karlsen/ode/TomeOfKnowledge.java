package uk.me.karlsen.ode;

public class TomeOfKnowledge {

	public static final long QUESTS_OFFSET = 653536l;
	public static final int NUMBER_OF_QUESTS = 16;
	public static final int QUEST_LENGTH_IN_BYTES = 16;
	
	public static final long SPELLS_OFFSET = 655872l;
	public static final int NUMBER_OF_SPELLS = 36;
	public static final int SPELL_LENGTH_IN_BYTES = 56;
	
	public static final long SHRINE_POINTERS_OFFSET = 648827l; //648831l;
	public static final long SHRINE_MIN_LEVELS_OFFSET = 648932l;
	public static final long SHRINE_MAX_LEVELS_OFFSET = 648960l;
	public static final long SHRINE_GAME_TYPE_OFFSET = 648990l;
	public static final int NUMBER_OF_SHRINES = 26;
	
	public static final long MODIFIERS_OFFSET = 498344l;
	public static final int NUMBER_OF_MODIFIERS = 83;
	public static final int MODIFIER_LENGTH_IN_BYTES = 48;
	public static final int NUMBER_OF_ITEM_EFFECTS = 4;
	
	public static final long DIABLO_POINTERS_OFFSET = 4203008l;
	public static final long HELLFIRE_POINTERS_OFFSET = 4199936l;
	
	public static final long UNIQUE_ITEMS_OFFSET = 506984;
	public static final int UNIQUE_ITEM_LENGTH_IN_BYTES = 84;
	public static final int NUMBER_OF_UNIQUE_ITEMS = 50;
	
	public static final long MIN_STATS_OFFSET = 650716;
	public static final long MAX_STATS_OFFSET = 650788;
	public static final long BLOCKING_BONUSES_OFFSET = 650764;
	public static final int BONUSES_AND_FRAMESETS_OFFSET = 650632;
	
	public static final long CHARACTER_ZERO_SKILL_LOC_1 = 305285; //1024 (hex editor) <=> 4198400 (asm) [-s 4197376 or 0x0400C00]
	public static final long CHARACTER_ZERO_SKILL_LOC_2 = 306884;
	public static final long CHARACTER_ZERO_SPELL_LOC_1 = 15564;
	public static final long CHARACTER_ONE_SKILL_LOC_1 = 305296; //TODO
	public static final long CHARACTER_ONE_SKILL_LOC_2 = 306894;
	public static final long CHARACTER_ONE_SPELL_LOC_1 = 15574;
	public static final long CHARACTER_TWO_SKILL_LOC_1 = 305392;
	public static final long CHARACTER_TWO_SKILL_LOC_2 = 306910;
	public static final long CHARACTER_TWO_SPELL_LOC_1 = 15590;
	
	
	public static final long BASE_ITEMS_OFFSET = 578568;
	public static final int BASE_ITEM_LENGTH_IN_BYTES = 76;
	public static final int NUMBER_OF_BASE_ITEMS = 35;
	
	public static final long BASE_MONSTERS_OFFSET = 613384;
	public static final int BASE_MONSTER_LENGTH_IN_BYTES = 128;
	public static final int NUMBER_OF_BASE_MONSTERS = 111;
	public static final long MONSTER_ACTIVATION_BYTES_OFFSET = 627848;
	
	public static final long UNIQUE_MONSTERS_OFFSET = 627960;
	public static final int NUMBER_OF_UNIQUE_MONSTERS = 97;
	public static final int UNIQUE_MONSTER_LENGTH_IN_BYTES = 32;
	
	static String[] createSpellNamesArray(){
		String[] spellNames = new String[37];
		spellNames[0] = "none";
		spellNames[1] = "Firebolt";
		spellNames[2] = "Healing";
		spellNames[3] = "Lightning";
		spellNames[4] = "Flash";
		spellNames[5] = "Identify";
		spellNames[6] = "FireWall";
		spellNames[7] = "Town Portal";
		spellNames[8] = "Stone Curse";
		spellNames[9] = "Infravision";
		spellNames[10] = "Phasing";
		spellNames[11] = "Mana Shield";
		spellNames[12] = "FireBall";
		spellNames[13] = "Guardian";
		spellNames[14] = "Chain Lightning";
		spellNames[15] = "Flame Wave";
		spellNames[16] = "Doom Serpents";
		spellNames[17] = "Blood Ritual";
		spellNames[18] = "Nova";
		spellNames[19] = "Invisibility";
		spellNames[20] = "Inferno";
		spellNames[21] = "Golem";
		spellNames[22] = "Blood Boil";
		spellNames[23] = "Teleport";
		spellNames[24] = "Apocalypse";
		spellNames[25] = "Etherealize";
		spellNames[26] = "Item Repair";
		spellNames[27] = "Staff recharge";
		spellNames[28] = "Trap Disarm";
		spellNames[29] = "Elemental";
		spellNames[30] = "Charged Bolt";
		spellNames[31] = "Holy Bolt";
		spellNames[32] = "Resurrect";
		spellNames[33] = "Telekinesis";
		spellNames[34] = "Heal Other";
		spellNames[35] = "Blood Star";
		spellNames[36] = "Bone Spirit";
		return spellNames;
	}

	/* Skill numbers:
	Firebolt....... 	0100 0000 	Infravision........... 	0001 0000
	Healing........ 	0200 0000 	Phasing............... 	0002 0000
	Lightning...... 	0400 0000 	Mana Shield........... 	0004 0000
	Flash.......... 	0800 0000 	Fireball.............. 	0008 0000
	Identify....... 	1000 0000 	Guardian.............. 	0010 0000
	FireWall....... 	2000 0000 	Chain Lightning....... 	0020 0000
	Town Portal.... 	4000 0000 	Flame Wave............ 	0040 0000
	Stone Curse.... 	8000 0000 	Doom Serpents......... 	0080 0000
	Blood Ritual... 	0000 0100 	Etherealize........... 	0000 0001
	Nova........... 	0000 0200 	Item Repair........... 	0000 0002
	Invisibility... 	0000 0400 	Staff Recharge........ 	0000 0004
	Inferno........ 	0000 0800 	Trap Disarm........... 	0000 0008
	Golem.......... 	0000 1000 	Elemental............. 	0000 0010
	Rage(HF)....... 	0000 2000 	Charged Bolt.......... 	0000 0020
	Teleport....... 	0000 4000 	Holy Bolt............. 	0000 0040
	Apocalypse..... 	0000 8000 	Resurrect............. 	0000 0080
	*/
	public static byte[][] createSkillBytesArray() {
		byte[][] skillBytes = {
				{0,0,0,0}, //invalid					(00)
				{1,0,0,0}, //Firebolt 					(01)
				{2,0,0,0}, //Healing 					(02)
				{4,0,0,0}, //Lightning 					(03)
				{8,0,0,0}, //Flash						(04)
				{10,0,0,0}, //Identify 					(05)
				{20,0,0,0}, //Firewall 					(06)
				{40,0,0,0}, //Town Portal 				(07)
				{80,0,0,0}, //Stone curse 				(08)
				{0,1,0,0}, //Infravision 				(09)
				{0,2,0,0}, //Phasing 					(10)
				{0,4,0,0}, //Mana shield 				(11)
				{0,8,0,0}, //Fireball 					(12)
				{0,10,0,0}, //Guardian 					(13)
				{0,20,0,0}, //Chain Lightning 			(14)
				{0,40,0,0}, //Flame Wave 				(15)
				{0,80,0,0}, //Doom Serpents 				(16)
				{0,0,1,0}, //Blood ritual 				(17)
				{0,0,2,0}, //Nova 						(18)
				{0,0,4,0}, //Invisibility 				(19)
				{0,0,8,0}, //Inferno 					(20)
				{0,0,10,0}, //Golem 						(21)
				{0,0,20,0}, //Rage (HF) / Blood Boil?	(22)
				{0,0,40,0}, //Teleport					(23)
				{0,0,80,0}, //Apocalypse					(24)
				{0,0,0,1}, //Etheralize					(25)
				{0,0,0,2}, //Item Repair				(26)
				{0,0,0,4}, //Staff Recharge				(27)
				{0,0,0,8}, //Trap Disarm				(28)
				{0,0,0,10}, //Elemental					(29)
				{0,0,0,20}, //Charged Bolt				(30)
				{0,0,0,40}, //Holy Bolt					(31)
				{0,0,0,80}  //Resurrect					(32)
		};
		return skillBytes;
	}
}
