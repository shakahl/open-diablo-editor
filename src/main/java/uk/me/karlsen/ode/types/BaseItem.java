package uk.me.karlsen.ode.types;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uk.me.karlsen.ode.ReaderWriter;
import uk.me.karlsen.ode.TomeOfKnowledge;
import uk.me.karlsen.ode.utils.BinEditHelper;

/**
 * Each BaseItem object acts as a repository for the information
 * pertaining to a particular in-game item. This is for
 * base items only (i.e. the item before it is affected by
 * any prefixes or suffixes).
 */
public class BaseItem {

	/**
	 * Textual descriptions for each item type.
	 * Item type ranges from 01 to 05.
	 */
	String[] itemTypes = {
		"invalid",					//00
		"Weapons",					//01
		"All armors",				//02
		"Jewelry, potion, scrolls",	//03
		"Gold",						//04
		"Novelty items"				//05
	};

	/**
	 * Equip location determines whether the item is equippable
	 * and, if so, in which location it may be equipped. An
	 * equip location of 07 indicates the item is unequippable.
	 * Equip location values of 01 to 06 indicate the item
	 * may be equipped in the relevant slot shown below. Items
	 * given an equip location value of 02 occupy both hand slots.
	 */
	String[] equipLocations = {
		"invalid",										//00
		"One handed (weapons and shields)",				//01
		"Two handed (bows, axes, staves, big swords)",	//02
		"Body",											//03
		"Head",											//04
		"Ring",											//05
		"Amulet",										//06
		"Unequippable"									//07
	};

	/**
	 * The item's graphic value is taken from the range
	 * 00 to 168 (0xA8) and indicates how the item appears
	 * in the character's inventory.
	 */
	String[] graphicValues = {
		"Potion of Full Mana",				//00 (00)
		"White Scroll",						//01 (01)
		"Brown Scroll",						//02 (02)
		"Blue Scroll",						//03 (03)
		"Small Gold Pile",					//04 (04)
		"Medium Gold Pile",					//05 (05)
		"Large Gold Pile",					//06 (06)
		"Thick Gold Ring",					//07 (07)
		"The Bleeder",						//08 (08)
		"Bramble",							//09 (09)
		"Ring of Truth",					//10 (0A)
		"Ring of Regha",					//11 (0B)
		"Ring",								//12 (0C)
		"Ring of Engagement",				//13 (0D)
		"Constricting Ring",				//14 (0E)
		"Spectral Elixir",					//15 (0F)
		"Rainbow Elixir",					//16 (10)
		"Golden Elixir",					//17 (11)
		"Empyrean Band",					//18 (12)
		"Ear w/ steel earring",				//19 (13)
		"Ear",								//20 (14)
		"Ear w/ gold earring",				//21 (15)
		"orange sphere",					//22 (16)
		"Hellraiser Box",					//23 (17)
		"gold pyramid",						//24 (18)
		"Blood Stone",						//25 (19)
		"red sphere",						//26 (1A)
		"blue cube",						//27 (1B)
		"orange pyramid",					//28 (1C)
		"thin black vial",					//29 (1D)
		"large black vial",					//30 (1E)
		"Elixir of Vitality",				//31 (1F)
		"Potion of Healing",				//32 (20)
		"Potion of Full Rejuvenation",		//33 (21)
		"Elixir of Magic",					//34 (22)
		"Potion of Full Healing",			//35 (23)
		"Elixir of Dexterity",				//36 (24)
		"Potion of Rejuvenation",			//37 (25)
		"Elixir of Strength",				//38 (26)
		"Potion of Mana, Potion of Mana",	//39 (27)
		"Brain",							//40 (28)
		"Claw",								//41 (29)
		"Tooth",							//42 (2A)
		"loaf of bread",					//43 (2B)
		"Optic Amulet",						//44 (2C)
		"Amulet",							//45 (2D)
		"black pendant",					//46 (2E)
		"bug brooch",						//47 (2F)
		"ankh necklace",					//48 (30)
		"pouch",							//49 (31)
		"Wizardspike",						//50 (32)
		"Dagger",							//51 (33)
		"bottle of brew",					//52 (34)
		"Black Razor",						//53 (35)
		"thick dagger",						//54 (36)
		"knuckle knife",					//55 (37)
		"Blade",							//56 (38)
		"Bastard Sword",					//57 (39)
		"The Executioner's Blade",			//58 (3A)
		"Mace",								//59 (3B)
		"Long Sword",						//60 (3C)
		"Broad Sword",						//61 (3D)
		"Falchion",							//62 (3E)
		"Morning Star",						//63 (3F)
		"Short Sword",						//64 (40)
		"Claymore",							//65 (41)
		"Club",								//66 (42)
		"Sabre",							//67 (43)
		"Gryphons Claw, The Falcon's Talon",//68 (44)
		"bone club",						//69 (45)
		"Spiked Club",						//70 (46)
		"board w/ nail",					//71 (47)
		"Scimitar",							//72 (48)
		"angel sword",						//73 (49)
		"rusted, grey sword",				//74 (4A)
		"Full Helm",						//75 (4B)
		"Magic Rock",						//76 (4C)
		"Helm of Sprits",					//77 (4D)
		"skull crown",						//78 (4E)
		"Royal Circlet",					//79 (4F)
		"Fool's Crest",						//80 (50)
		"Harlequin Crest",					//81 (51)
		"Helm",								//82 (52)
		"Buckler",							//83 (53)
		"horned helm",						//84 (54)
		"Veil of Steel, Gotterdamerung",	//85 (55)
		"black book",						//86 (56)
		"red book",							//87 (57)
		"blue book",						//88 (58)
		"Black Mushroom",					//89 (59)
		"Skull Cap",						//90 (5A)
		"Cap",								//91 (5B)
		"Torn Flesh of Souls",				//92 (5C)
		"Thinking Cap",						//93 (5D)
		"red tunic",						//94 (5E)
		"Crown",							//95 (5F)
		"Map of the Stars",					//96 (60)
		"Fungal Tome",						//97 (61)
		"Great Helm",						//98 (62)
		"Overlord's Helm",					//99 (63)
		"lightning shield",					//100 (64)
		"Battle Axe",						//101 (65)
		"Hunter's Bow, Long Bow",			//102 (66)
		"Plate Mail, Field Plate",			//103 (67)
		"Stonecleaver",						//104 (68)
		"Small Shield",						//105 (69)
		"Cleaver",							//106 (6A)
		"Studded Leather Armor",			//107 (6B)
		"Deadly Hunter, Eaglehorn",			//108 (6C)
		"Short Staff, Quarter Staff",		//109 (6D)
		"Two-Handed Sword",					//110 (6E)
		"Chain Mail",						//111 (6F)
		"Small Axe",						//112 (70)
		"Kite Shield",						//113 (71)
		"Scale Mail",						//114 (72)
		"large, thick shield",				//115 (73)
		"Split Skull Shield",				//116 (74)
		"Dragon's Breach",					//117 (75)
		"Short Bow, Short Bow",				//118 (76)
		"Long Battle Bow, Long War Bow",	//119 (77)
		"fish bow",							//120 (78)
		"War Hammer",						//121 (79)
		"Maul, The Cranium Basher",			//122 (7A)
		"Long Staff",						//123 (7B)
		"War Staff",						//124 (7C)
		"shaman's staff",					//125 (7D)
		"Tavern Sign",						//126 (7E)
		"Hard Leather Armor",				//127 (7F)
		"Rags",								//128 (80)
		"Quilted Armor",					//129 (81)
		"3 spiked balls 'n chain flail",	//130 (82)
		"Flail",							//131 (83)
		"Tower Shield",						//132 (84)
		"Composite Bow",					//133 (85)
		"Great Sword",						//134 (86)
		"Leather Armor",					//135 (87)
		"Splint Mail",						//136 (88)
		"Robe",								//137 (89)
		"The Rainbow Cloak, Wisdom's Wrap, Nightscape", //138 (8A)
		"leather shirt",					//139 (8B)
		"Anvil of Fury",					//140 (8C)
		"Broad Axe",						//141 (8D)
		"Large Axe",						//142 (8E)
		"Great Axe",						//143 (8F)
		"Axe",								//144 (90)
		"grey cleaver",						//145 (91)
		"Blackoak Shield, Holy Defender",	//146 (92)
		"Large Shield",						//147 (93)
		"Gothic Shield",					//148 (94)
		"Cloak",							//149 (95)
		"Cape",								//150 (96)
		"Full Plate Mail",					//151 (97)
		"Gothic Plate",						//152 (98)
		"Breast Plate",						//153 (99)
		"Ring Mail",						//154 (9A)
		"Staff of Lazarus",					//155 (9B)
		"ruby axe",							//156 (9C)
		"Arkaine's Valor",					//157 (9D)
		"The Needler",						//158 (9E)
		"Naj's Light Plate",				//159 (9F)
		"The Grizzly",						//160 (A0)
		"The Grandfather",					//161 (A1)
		"The Protector",					//162 (A2)
		"Messerschmidt's Reaver",			//163 (A3)
		"Windforce",						//164 (A4)
		"Short War Bow",					//165 (A5)
		"Composite Staff",					//166 (A6)
		"Short Battle Bow",					//167 (A7)
		"Gold"								//168 (A8)
	};

	/**
	 * Contains textual descriptions for each item code
	 * (in the range 00 to 13 (0x0D).
	 */
	String[] itemCodes = {
		"All other items",					//00 (00) -- (novelties, potions, scrolls, books, etc)
		"Swords",							//01 (01)
		"Axes and cleavers",				//02 (02)
		"Bows",								//03 (03)
		"Blunt weapons",					//04 (04)
		"Shields",							//05 (05)
		"Light armor (cloth and leather)",	//06 (06)
		"Helms and crowns",					//07 (07)
		"Medium armor (chain and splint)",	//08 (08)
		"Heavy armor (plate)",				//09 (09)
		"Staves",							//10 (0A)
		"Gold",								//11 (0B)
		"Rings",							//12 (0C)
		"Amulets"							//13 (0D)
	};

	//TODO -- investigate this property and comment
	String[] baseItemActivationTriggers = {
		"Item will never be found",		//00
		"Item will be findable",		//01
		"Findable, 2X occurance rate"	//02
	};

	//Note: does not relate to "qualityLevel" which has values from 0 to 15
	String[] qualityLevels = {
		"Normal",	// 00
		"Magic",	// 01
		"Unique",	// 02
	};

	/**
	 * A list of special effect codes used to validate
	 * the argument supplied to setSpecialEffects().
	 */
	List<Integer> specialEffectCodes = Arrays.asList(
		0x00000000, //i.e. no special effect
		0x01000000,
		0x02000000,
		0x04000000,
		0x08000000,
		0x10000000,
		0x20000000,
		0x40000000,
		0x80000000,
		0x00010000,
		0x00020000,
		0x00040000,
		0x00080000,
		0x00100000,
		0x00200000,
		0x00400000,
		0x00800000,
		0x00000100,
		0x00000200,
		0x00000400,
		0x00000800,
		0x00001000,
		0x00002000,
		0x00004000,
		0x00008000,
		0x00000001,
		0x00000002,
		0x00000004,
		0x00000008,
		0x00000010,
		0x00000020,
		0x00000040,
		0x00000080
	);

	String[] magicCodes = {
		"Nothing", //00 (00)
		"???", //01 (01)
		"Potion of Full Healing", //02 (02)
		"Potion of Healing", //03
		"???", //04 (04)
		"???", //05 (05)
		"Potion of Mana", //06 (06)
		"Potion of Full Mana", //07 (07)
		"???", //08 (08)
		"???", //09 (09)
		"Elixir of Strength", //10 (0A)
		"Elixir of Magic", //11 (0B)
		"Elixir of Dexterity", //12 (0C)
		"Elixir of Vitality", //13 (0D)
		"???", //14 (0E)
		"???", //15 (OF)
		"???", //16 (10)
		"???", //17 (11)
		"Potion of Rejuvenation", //18 (12)
		"Potion of Full Rejuventaion", //19 (13)
		"???", //20 (14)
		"Scroll of Healing, Identify, Town Portal, Infravision, Phasing, Mana Shield, Nova, Teleport, Apocalypse", //21 (15)
		"Scroll of Resurrect, Lightning, FireWall, Inferno, Flash, Flame Wave, Fireball, Stone Curse, Chain Lightning, Guardian, Golem", //22 (16)
		"Staves", //23 (17)
		"Books", //24 (18)
		"Rings", //25 (19)
		"Amulets", //26 (1A)
		"Unique Items", //27 (1B)
		"???", //28 (1C)
		"???", //29 (1D)
		"???", //30 (1E)
		"???", //31 (1F)
		"???", //32 (20)
		"???", //33 (21)
		"???", //34 (22)
		"???", //35 (23)
		"???", //36 (24)
		"???", //37 (25)
		"???", //38 (26)
		"???", //39 (27)
		"???", //40 (28)
		"???", //41 (29)
		"Map of the Stars", //42 (2A)
		"Ear/Heart", //43 (2B)
		"Spectral Elixir" //44 (2C)
	};

	String[] useCountStrings = {
		"Nothing",																	//00
		"Right clicking the item will make it disappear (potions, scrolls, books)"	//01
	};

	private long activationTrigger;
	private int itemType;
	private int equipLocation;
	private int byteSix;
	private int byteSeven;
	private long graphicValue;
	private int itemCode;
	private int uniqueItemCode;
	private int byteFourteen;
	private int byteFifteen;
	private long namePointer;
	private String name;
	private long magicalNamePointer;
	private String magicalName;
	private long qualityLevel;
	private long durability;
	private long minAttackDamage;
	private long maxAttackDamage;
	private long minAc;
	private long maxAc;
	private int requiredStr;
	private int requiredMag;
	private int requiredDex;
	private int requiredVit;
	private long specialEffects;
	private long magicCode;
	private long spellNumber;
	private long singleUseFlag;
	private long priceOne;
	private long priceTwo;
	private int slotNumber;
	private boolean changed;
	
	private ReaderWriter rw;

	public BaseItem(int slotNumber, byte[] itemBytes, ReaderWriter rw) {
		changed = false;
		this.slotNumber = slotNumber;
		BinEditHelper beh = new BinEditHelper(rw);
		activationTrigger = beh.convertFourBytesToNumber(itemBytes, 0);
		itemType = beh.convertUnsignedByteToInt(itemBytes[4]);
		equipLocation = beh.convertUnsignedByteToInt(itemBytes[5]);
		byteSix = beh.convertUnsignedByteToInt(itemBytes[6]);
		byteSeven = beh.convertUnsignedByteToInt(itemBytes[7]);
		graphicValue = beh.convertFourBytesToNumber(itemBytes, 8);
		itemCode = beh.convertUnsignedByteToInt(itemBytes[12]);
		uniqueItemCode = beh.convertUnsignedByteToInt(itemBytes[13]);
		byteFourteen = beh.convertUnsignedByteToInt(itemBytes[14]);
		byteFifteen = beh.convertUnsignedByteToInt(itemBytes[15]);
		namePointer = beh.convertFourBytesToOffset(itemBytes, 16);
		name = beh.getNameUsingPointer(namePointer);			
		magicalNamePointer = beh.convertFourBytesToOffset(itemBytes, 20);
		magicalName = beh.getNameUsingPointer(magicalNamePointer);
		qualityLevel = beh.convertFourBytesToNumber(itemBytes, 24);
		durability = beh.convertFourBytesToNumber(itemBytes, 28);
		minAttackDamage = beh.convertFourBytesToNumber(itemBytes, 32);
		maxAttackDamage = beh.convertFourBytesToNumber(itemBytes, 36);
		minAc = beh.convertFourBytesToNumber(itemBytes, 40);
		maxAc = beh.convertFourBytesToNumber(itemBytes, 44);
		requiredStr = beh.convertUnsignedByteToInt(itemBytes[48]);
		requiredMag = beh.convertUnsignedByteToInt(itemBytes[49]);
		requiredDex = beh.convertUnsignedByteToInt(itemBytes[50]);
		requiredVit = beh.convertUnsignedByteToInt(itemBytes[51]);
		specialEffects = beh.convertFourBytesToNumber(itemBytes, 52);
		magicCode = beh.convertFourBytesToNumber(itemBytes, 56);
		spellNumber = beh.convertFourBytesToNumber(itemBytes, 60);
		singleUseFlag = beh.convertFourBytesToNumber(itemBytes, 64);
		priceOne = beh.convertFourBytesToNumber(itemBytes, 68);
		priceTwo = beh.convertFourBytesToNumber(itemBytes, 72);
	}

	public byte[] getItemAsBytes(){
		byte[] bytes = new byte[TomeOfKnowledge.BASE_ITEM_LENGTH_IN_BYTES];
		BinEditHelper beh = new BinEditHelper(rw);
		beh.setLongAsFourBytes(activationTrigger, bytes, 0);
		bytes[4] = (byte) itemType;
		bytes[5] = (byte) equipLocation;
		bytes[6] = (byte) byteSix;
		bytes[7] = (byte) byteSeven;
		beh.setLongAsFourBytes(graphicValue, bytes, 8);
		bytes[12] = (byte) itemCode;
		bytes[13] = (byte) uniqueItemCode;
		bytes[14] = (byte) byteFourteen;
		bytes[15] = (byte) byteFifteen;
		beh.setPointerAsFourBytes(namePointer, bytes, 16);
		beh.setPointerAsFourBytes(magicalNamePointer, bytes, 20);
		beh.setLongAsFourBytes(qualityLevel, bytes, 24);
		beh.setLongAsFourBytes(durability, bytes, 28);
		beh.setLongAsFourBytes(minAttackDamage, bytes, 32);
		beh.setLongAsFourBytes(maxAttackDamage, bytes, 36);
		beh.setLongAsFourBytes(minAc, bytes, 40);
		beh.setLongAsFourBytes(maxAc, bytes, 44);
		bytes[48] = (byte) requiredStr;
		bytes[49] = (byte) requiredMag;
		bytes[50] = (byte) requiredDex;
		bytes[51] = (byte) requiredVit;
		beh.setLongAsFourBytes(specialEffects, bytes, 52);
		beh.setLongAsFourBytes(magicCode, bytes, 56);
		beh.setLongAsFourBytes(spellNumber, bytes, 60);
		beh.setLongAsFourBytes(singleUseFlag, bytes, 64);
		beh.setLongAsFourBytes(priceOne, bytes, 68);
		beh.setLongAsFourBytes(priceTwo, bytes, 72);
		return bytes;
	}

	public void printItem() {
		String[] uniqueItemCodes = UniqueItem.createNewItemTypeArray();
		String[] spellNumbers = TomeOfKnowledge.createSpellNamesArray();
		Map<Integer,String> specialEffectMap = this.getSpecialEffectMap();
		System.out.println("Slot number: " + slotNumber + " (hex: " + Integer.toHexString(slotNumber) + ")" + "\n" +
			"Name: " + name + "\n" +
			"Name pointer: " + namePointer + "\n" +
			"Magical name: " + magicalName + "\n" +
			"Magical name pointer: " + magicalNamePointer + "\n" +
			"Activation trigger: " + baseItemActivationTriggers[(int) activationTrigger] + "\n" +
			"Item type: " + itemTypes[itemType] + "\n" +
			"Equip location: " + equipLocations[equipLocation] + "\n" +
			"Byte six: " + byteSix + "\n" +
			"Byte seven: " + byteSeven + "\n" +
			"Graphic: " + graphicValues[(int) graphicValue] + "\n" +
			"Item code: " + itemCodes[itemCode] + "\n" +
			"Unique item code: " + uniqueItemCodes[uniqueItemCode] + "\n" +
			"Byte fourteen: " + byteFourteen + "\n" +
			"Byte fifteen: " + byteFifteen + "\n" +
			"Quality level: " + qualityLevel + "\n" +
			"Durability: " + durability + "\n" +
			"Min attack damage: " + minAttackDamage + "\n" +
			"Max attack damage: " + maxAttackDamage + "\n" +
			"Min ac: " + minAc + "\n" +
			"Max ac: " + maxAc + "\n" +
			"Required Str: " + requiredStr + "\n" +
			"Required Mag: " + requiredMag + "\n" +
			"Required Dex: " + requiredDex + "\n" +
			"Required Vit: " + requiredVit + "\n" +
			"Special effects: " + Long.toHexString(specialEffects) + "\n" + //specialEffectMap.get()
			"Magic code: " + magicCodes[(int) magicCode] + "\n" +
			"Spell number: " + spellNumbers[(int) spellNumber] + "\n" +
			"Single use flag: " + useCountStrings[(int) singleUseFlag] + "\n" +
			"Price one: " + priceOne + "\n" +
			"Price two: " + priceTwo + "\n"
		);
	}

	public long getActivationTrigger() {
		return activationTrigger;
	}

	public void setActivationTrigger(long activationTrigger) {
		if(activationTrigger >= 0 && activationTrigger <= 2) {
			this.activationTrigger = activationTrigger;
			this.setChanged();
		} else {
			System.err.println("Error: BaseItem's setActivationTrigger() was"
					+ " supplied with an argument outside the supported range (0 to 2)");
		}
	}

	public int getItemType() {
		return itemType;
	}

	public void setItemType(int itemType) {
		if(itemType >= 1 && itemType <= 5) {
			this.itemType = itemType;
			this.setChanged();
		} else {
			System.err.println("Error: BaseItem's setItemType() was"
					+ "supplied with an argument outside the supported range (1 to 5)");
		}
	}

	public int getEquipLocation() {
		return equipLocation;
	}

	public void setEquipLocation(int equipLocation) {
		if(equipLocation >= 1 && equipLocation <= 7) {
			this.equipLocation = equipLocation;
			this.setChanged();
		} else {
			System.err.println("Error: BaseItem's setEquipLocation() was"
					+ "supplied with an argument outside the supported range (1 to 7)");
		}
	}

	public long getGraphicValue() {
		return graphicValue;
	}

	//range 0 to A8 (168)
	public void setGraphicValue(long graphicValue) {
		if(graphicValue >= 0 && graphicValue <= 168) {
			this.graphicValue = graphicValue;
			this.setChanged();
		} else {
			System.err.println("Error: BaseItem's setGraphicValue() was"
					+ "supplied with an argument outside the supported range (0 to 168)");
		}
	}

	public int getItemCode() {
		return itemCode;
	}

	//range 00 to 0D (13)
	public void setItemCode(int itemCode) {
		if(itemCode >= 0 && itemCode <= 13){
			this.itemCode = itemCode;
			this.setChanged();
		} else {
			System.err.println("Error: BaseItem's setItemCode() was"
					+ "supplied with an argument outside the supported range (0 to 13)");
		}
	}

	public int getUniqueItemCode() {
		return uniqueItemCode;
	}

	//1 to 0x44 (68)
	public void setUniqueItemCode(int uniqueItemCode) {
		if(uniqueItemCode >= 1 && uniqueItemCode <= 68){
			this.uniqueItemCode = uniqueItemCode;
			this.setChanged();
		} else {
			System.err.println("Error: BaseItem's setIniqueItemCode() was"
					+ "supplied with an argument outside the supported range (0 to 68)");
		}
	}

	public long getNamePointer() {
		return namePointer;
	}

	//1024 to 0x6B1800 (7018496)
	public void setNamePointer(long namePointer) {
		if(namePointer >= 1024 && namePointer <= 7018496){
			this.namePointer = namePointer;
			this.setChanged();
		} else {
			System.err.println("Error: BaseItem's setNamePointer() was"
					+ "supplied with an argument outside the supported range (1024 to 7018496)");
		}
	}

	//TODO -- private String getName()

	//TODO -- private void setName(String name)

	public long getMagicalNamePointer() {
		return magicalNamePointer;
	}

	public void setMagicalNamePointer(long magicalNamePointer) {
		if(magicalNamePointer == 0 || magicalNamePointer >= 1024 && magicalNamePointer <= 7018496){
			this.magicalNamePointer = magicalNamePointer;
			this.setChanged();
		} else {
			System.err.println("Error: BaseItem's setMagicalNamePointer() was"
					+ "supplied with a value of " + magicalNamePointer + " -- outside the supported range (0; 1024 to 7018496)");
		}
	}

	//TODO -- private String getMagicalName()

	//TODO -- private void setMagicalName(String magicalName)

	public long getQualityLevel() {
		return qualityLevel;
	}

	public void setQualityLevel(long qualityLevel) {
		if(qualityLevel >= 0 && qualityLevel <= 15){
			this.qualityLevel = qualityLevel;
			this.setChanged();
		} else {
			System.err.println("Error: BaseItem's setQualityLevel() was"
					+ "supplied with an argument outside the supported range (0 to 15)");
		}
	}

	public long getDurability() {
		return durability;
	}

	public void setDurability(long durability) {
		if(durability >= 0 && durability <= 255){
			this.durability = durability;
			this.setChanged();
		} else {
			System.err.println("Error: BaseItem's setDurability() was"
					+ "supplied with an argument outside the supported range (0 to 255)");
		}
	}

	public long getMinAttackDamage() {
		return minAttackDamage;
	}

	public void setMinAttackDamage(long minAttackDamage) {
		if(minAttackDamage >= 0 && minAttackDamage <= 255){
			this.minAttackDamage = minAttackDamage;
			this.setChanged();
		} else {
			System.err.println("Error: BaseItem's setMinAttackDamage() was"
					+ "supplied with an argument outside the supported range (0 to 255)");
		}
	}

	public long getMaxAttackDamage() {
		return maxAttackDamage;
	}

	public void setMaxAttackDamage(long maxAttackDamage) {
		if(maxAttackDamage >= 0 && maxAttackDamage <= 255){
			this.maxAttackDamage = maxAttackDamage;
			this.setChanged();
		} else {
			System.err.println("Error: BaseItem's setMaxAttackDamage() was"
					+ "supplied with an argument outside the supported range (0 to 255)");
		}
	}

	public long getMinAc() {
		return minAc;
	}

	public void setMinAc(long minAc) {
		if(minAc >= 0 && minAc <= 255){
			this.minAc = minAc;
			this.setChanged();
		} else {
			System.err.println("Error: BaseItem's setMinAc() was"
					+ "supplied with an argument outside the supported range (0 to 255)");
		}
	}

	public long getMaxAc() {
		return maxAc;
	}

	public void setMaxAc(long maxAc) {
		if(maxAc >= 0 && maxAc <= 255){
			this.maxAc = maxAc;
			this.setChanged();
		} else {
			System.err.println("Error: BaseItem's setMaxAc() was"
					+ "supplied with an argument outside the supported range (0 to 255)");
		}
	}

	public int getRequiredStr() {
		return requiredStr;
	}

	public void setRequiredStr(int requiredStr) {
		if(requiredStr >= 0 && requiredStr <= 255){
			this.requiredStr = requiredStr;
			this.setChanged();
		} else {
			System.err.println("Error: BaseItem's setRequiredStr() was"
					+ "supplied with an argument outside the supported range (0 to 255)");
		}
	}

	public int getRequiredMag() {
		return requiredMag;
	}

	public void setRequiredMag(int requiredMag) {
		if(requiredMag >= 0 && requiredMag <= 255){
			this.requiredMag = requiredMag;
			this.setChanged();
		} else {
			System.err.println("Error: BaseItem's setRequiredMag() was"
					+ "supplied with an argument outside the supported range (0 to 255)");
		}
	}

	public int getRequiredDex() {
		return requiredDex;
	}

	public void setRequiredDex(int requiredDex) {
		if(requiredDex >= 0 && requiredDex <= 255){
			this.requiredDex = requiredDex;
			this.setChanged();
		} else {
			System.err.println("Error: BaseItem's setRequiredDex() was"
					+ "supplied with an argument outside the supported range (0 to 255)");
		}
	}

	public int getRequiredVit() {
		return requiredVit;
	}

	public void setRequiredVit(int requiredVit) {
		if(requiredVit >= 0 && requiredVit <= 255){
			this.requiredVit = requiredVit;
			this.setChanged();
		} else {
			System.err.println("Error: BaseItem's setRequiredVit() was"
					+ "supplied with an argument outside the supported range (0 to 255)");
		}
	}

	public long getSpecialEffects() {
		return specialEffects;
	}

	public void setSpecialEffects(long specialEffects) {
		if(specialEffectCodes.contains((int) specialEffects)){
			this.specialEffects = specialEffects;
			this.setChanged();
		} else {
			System.err.println("Error: BaseItem's setSpecialEffects() was"
					+ "supplied with an unsupported argument");
		}
	}

	public long getMagicCode() {
		return magicCode;
	}

	public void setMagicCode(long magicCode) {
		if(magicCode >= 0 && magicCode <= 44){
			this.magicCode = magicCode;
			this.setChanged();
		} else {
			System.err.println("Error: BaseItem's setMagicCode() was"
					+ "supplied with an argument outside the supported range (0 to 44)");
		}
	}

	public long getSpellNumber() {
		return spellNumber;
	}

	//1 to 24
	public void setSpellNumber(long spellNumber) {
		if(spellNumber >= 1 && spellNumber <= 24){
			this.spellNumber = spellNumber;
			this.setChanged();
		} else {
			System.err.println("Error: BaseItem's setSpellNumber() was"
					+ "supplied with an argument outside the supported range (1 to 24)");
		}
	}

	public long getSingleUseFlag() {
		return singleUseFlag;
	}

	public void setSingleUseFlag(long singleUseFlag) {
		if(singleUseFlag == 0 || singleUseFlag == 1){
			this.singleUseFlag = singleUseFlag;
			this.setChanged();
		} else {
			System.err.println("Error: BaseItem's setSingleUseFlag() was"
					+ "supplied with an argument outside the supported range (0 to 1)");
		}
	}

	public long getPriceOne() {
		return priceOne;
	}

	//0 to 999999
	public void setPriceOne(long priceOne) {
		if(priceOne >= 0 && priceOne <= 999999){
			this.priceOne = priceOne;
			this.setChanged();
		} else {
			System.err.println("Error: BaseItem's setPriceOne() was"
					+ "supplied with an argument outside the supported range (0 to 999999)");
		}
	}

	public long getPriceTwo() {
		return priceTwo;
	}

	public void setPriceTwo(long priceTwo) {
		if(priceTwo >= 0 && priceTwo <= 999999){
			this.priceTwo = priceTwo;
			this.setChanged();
		} else {
			System.err.println("Error: BaseItem's setPriceTwo() was"
					+ "supplied with an argument outside the supported range (0 to 999999)");
		}
	}
	
	public String getName() {
		return name;
	}

	public boolean isChanged() {
		return changed;
	}

	public void setChanged() {
		this.changed = true;
	}
	
	public Map<Integer,String> getSpecialEffectMap(){
		Map<Integer,String> specialEffectMap = new HashMap<Integer,String>();
		specialEffectMap.put(0x01000000, "Infravision");
		specialEffectMap.put(0x02000000, "Random Life Stealing");
		specialEffectMap.put(0x04000000, "Random Speed Arrows");
		specialEffectMap.put(0x08000000, "Burning Damage");
		specialEffectMap.put(0x10000000, "Extra Fire Damage");
		specialEffectMap.put(0x20000000, "Extra Lighning Damage");
		specialEffectMap.put(0x40000000, "Cursed Hit Points");
		specialEffectMap.put(0x80000000, "Effect Unknown");
		specialEffectMap.put(0x00010000, "User can't heal");
		specialEffectMap.put(0x00020000, "Effect Unknown");
		specialEffectMap.put(0x00040000, "Effect Unknown");
		specialEffectMap.put(0x00080000, "Knock Target Back");
		specialEffectMap.put(0x00100000, "Hit monster doesn't heal");
		specialEffectMap.put(0x00200000, "Steal 3% Mana");
		specialEffectMap.put(0x00400000, "Steal 5% Mana");
		specialEffectMap.put(0x00800000, "Steal 3% Life");
		specialEffectMap.put(0x00000100, "Steal 5% Life");
		specialEffectMap.put(0x00000200, "Quick Attack");
		specialEffectMap.put(0x00000400, "Fast Attack");
		specialEffectMap.put(0x00000800, "Faster Attack");
		specialEffectMap.put(0x00001000, "Fastest Attack");
		specialEffectMap.put(0x00002000, "Fast Hit Recovery");
		specialEffectMap.put(0x00004000, "Faster Hit Recovery");
		specialEffectMap.put(0x00008000, "Fastest Hit Recovery");
		specialEffectMap.put(0x00000001, "Fast Block");
		specialEffectMap.put(0x00000002, "1-6 Additional Lightning Damage");
		specialEffectMap.put(0x00000004, "Attacker Takes 1-3 Thorn Damage");
		specialEffectMap.put(0x00000008, "Cursed Mana");
		specialEffectMap.put(0x00000010, "Absorb Half Trap Damage");
		specialEffectMap.put(0x00000020, "Effect Unknown");
		specialEffectMap.put(0x00000040, "+200% Damage to Demons");
		specialEffectMap.put(0x00000080, "Cursed Resistance");
		return specialEffectMap;
	}

	public void setName(String name) {
		this.name = name;
	}
}
