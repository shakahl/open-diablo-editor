package uk.me.karlsen.ode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseItem {
	
	String[] itemTypes = {
		"invalid",					//00
		"Weapons",					//01
		"All armors",				//02
		"Jewelry, potion, scrolls",	//03
		"Gold",						//04
		"Novelty items"				//05
	};
	
	String[] equipLocations = {
		"invalid",										//00
		"One handed (weapons and shields)",				//01
		"Two handed (bows, axes, staves, big swords)",	//02
		"Body",											//03
		"Head",											//04
		"Ring",											//05
		"Amulet",										//06
		"Unequipable"									//07
	};
	
	String[] graphicValues = {
		"Potion of Full Mana", //00
		"White Scroll", //01
		"Brown Scroll", //02
		"Blue Scroll", //03
		"Small Gold Pile", //04
		"Medium Gold Pile", //05
		"Large Gold Pile", //06
		"Thick Gold Ring", //07
		"The Bleeder", //08
		"Bramble", //09
		"Ring of Truth", //10 (0A)
		"Ring of Regha", //11 (0B)
		"Ring", //12 (0C)
		"Ring of Engagement", //13 (0D)
		"Constricting Ring", //14 (0E)
		"Spectral Elixir", //15 (0F)
		"Rainbow Elixir", //16 (10)
		"Golden Elixir", //17 (11)
		"Empyrean Band", //18 (12)
		"Ear w/ steel earring", //19 (13)
		"Ear", //20 (14)
		"Ear w/ gold earring", //21 (15)
		"orange sphere", //22 (16)
		"Hellraiser Box", //23 (17)
		"gold pyramid", //24 (18)
		"Blood Stone", //25 (19)
		"red sphere", //26 (1A)
		"blue cube", //27 (1B)
		"orange pyramid", //28 (1C)
		"thin black vial", //29 (1D)
		"large black vial", //30 (1E)
		"Elixir of Vitality", //31 (1F)
		"Potion of Healing", //32 (20)
		"Potion of Full Rejuvenation", //33 (21)
		"Elixir of Magic", // (22)
		"Potion of Full Healing", // (23)
		"Elixir of Dexterity", // (24)
		"Potion of Rejuvenation", // (25)
		"Elixir of Strength", // (26)
		"Potion of Mana, Potion of Mana", // (27)
		"Brain", // (28)
		"Claw", // (29)
		"Tooth", // (2A)
		"loaf of bread", // (2B)
		"Optic Amulet", // (2C)
		"Amulet", // (2D)
		"black pendant", // (2E)
		"bug brooch", // (2F)
		"ankh necklace", // (30)
		"pouch", // (31)
		"Wizardspike", // (32)
		"Dagger", // (33)
		"bottle of brew", // (34)
		"Black Razor", // (35)
		"thick dagger", // (36)
		"knuckle knife", // (37)
		"Blade", // (38)
		"Bastard Sword", // (39)
		"The Executioner's Blade", // (3A)
		"Mace", // (3B)
		"Long Sword", // (3C)
		"Broad Sword", // (3D)
		"Falchion", // (3E)
		"Morning Star", // (3F)
		"Short Sword", // (40)
		"Claymore", // (41)
		"Club", // (42)
		"Sabre", // (43)
		"Gryphons Claw, The Falcon's Talon", // (44)
		"bone club", // (45)
		"Spiked Club", // (46)
		"board w/ nail", // (47)
		"Scimitar", // (48)
		"angel sword", // (49)
		"rusted, grey sword", // (4A)
		"Full Helm", // (4B)
		"Magic Rock", // (4C)
		"Helm of Sprits", // (4D)
		"skull crown", // (4E)
		"Royal Circlet", // (4F)
		"Fool's Crest", // (50)
		"Harlequin Crest", // (51)
		"Helm", // (52)
		"Buckler", // (53)
		"horned helm", // (54)
		"Veil of Steel, Gotterdamerung", // (55)
		"black book", // (56)
		"red book", // (57)
		"blue book", // (58)
		"Black Mushroom", // (59)
		"Skull Cap", // (5A)
		"Cap", // (5B)
		"Torn Flesh of Souls", // (5C)
		"Thinking Cap", // (5D)
		"red tunic", // (5E)
		"Crown", // (5F)
		"Map of the Stars", // (60)
		"Fungal Tome", // (61)
		"Great Helm", // (62)
		"OverLord's Helm", // (63)
		"lightning shield", // (64)
		"Battle Axe", // (65)
		"Hunter's Bow, Long Bow", // (66)
		"Plate Mail, Field Plate", // (67)
		"Stonecleaver", // (68)
		"Small Shield", // (69)
		"Cleaver", // (6A)
		"Studded Leather Armor", // (6B)
		"Deadly Hunter, Eaglehorn", // (6C)
		"Short Staff, Quarter Staff", // (6D)
		"Two-Handed Sword", // (6E)
		"Chain Mail", // (6F)
		"Small Axe", // (70)
		"Kite Shield", // (71)
		"Scale Mail", // (72)
		"large, thick shield", // (73)
		"Split Skull Shield", // (74)
		"Dragon's Breach", // (75)
		"Short Bow, Short Bow", // (76)
		"Long Battle Bow, Long War Bow", // (77)
		"fish bow", // (78)
		"War Hammer", // (79)
		"Maul, The Cranium Basher", // (7A)
		"Long Staff", // (7B)
		"War Staff", // (7C)
		"shaman's staff", // (7D)
		"Tavern Sign", // (7E)
		"Hard Leather Armor", // (7F)
		"Rags", // (80)
		"Quilted Armor", // (81)
		"3 spiked balls 'n chain flail", // (82)
		"Flail", // (83)
		"Tower Shield", // (84)
		"Composite Bow", // (85)
		"Great Sword", // (86)
		"Leather Armor", // (87)
		"Splint Mail", // (88)
		"Robe", // (89)
		"The Rainbow Cloak, Wisdom's Wrap, Nightscape", // (8A)
		"leather shirt", // (8B)
		"Anvil of Fury", // (8C)
		"Broad Axe", // (8D)
		"Large Axe", // (8E)
		"Great Axe", // (8F)
		"Axe", // (90)
		"grey cleaver", // (91)
		"Blackoak Shield, Holy Defender", // (92)
		"Large Shield", // (93)
		"Gothic Shield", // (94)
		"Cloak", // (95)
		"Cape", // (96)
		"Full Plate Mail", // (97)
		"Gothic Plate", // (98)
		"Breast Plate", // (99)
		"Ring Mail", // (9A)
		"Staff of Lazarus", // (9B)
		"ruby axe", // (9C)
		"Arkaine's Valor", // (9D)
		"The Needler", // (9E)
		"Naj's Light Plate", // (9F)
		"The Grizzly", // (A0)
		"The Grandfather", // (A1)
		"The Protector", // (A2)
		"Messerschmidt's Reaver", // (A3)
		"Windforce", // (A4)
		"Short War Bow", // (A5)
		"Composite Staff", // (A6)
		"Short Battle Bow", // (A7)
		"Gold" // (A8)
	};
	
	String[] itemCodes = {
			"All other items (novelties, potions, scrolls, books, etc)", //00
			"Swords", //01
			"Axes, Cleaver", //02
			"Bows", //03
			"Blunt weapons (maces, hammers, mauls, clubs)", //04
			"Shields", //05
			"Light armor (rags, capes, leather armor, etc)", //06
			"Helms, crowns", //07
			"Mid armor (Arkaine's Valor, chain mail, splint mail, etc)", //08
			"Heavy plates (Full Plate Mail, Gothic Plate, Breast Plate, etc)", //09
			"Staves", //0A
			"Gold", //0B
			"Rings", //0C
			"Amulets" //0D	
	};
	
	String[] baseItemActivationTriggers = {
			"Item will never be found",		//00
			"Item will be findable",		//01
			"Findable, 2X occurance rate"	//02
		};
	
	List<Integer> specialEffectCodes = Arrays.asList(
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
			0x00000080);

	
	
	/*
	Some effects do not work on certain base items
	0x0100000 = Infravision
	0x02000000 = Random Life Stealing
	0x04000000 = Random Speed Arrows
	0x08000000 = Burning Damage
	0x10000000 = Extra Fire Damage
	0x20000000 = Extra Lighning Damage
	0x40000000 = Cursed Hit Points
	0x80000000 = ???
	0x00010000 = ???
	0x00020000 = ???
	0x00040000 = ???
	0x00080000 = Knock target back
	0x00100000 = ???
	0x00200000 = Steal 3% Mana
	0x00400000 = Steal 5% Mana
	0x00800000 = Steal 3% Life
	0x00000100 = Steal 5% life
	0x00000200 = Quick Attack
	0x00000400 = Fast Attack
	0x00000800 = Faster Attack
	0x00001000 = Fastest Attack
	0x00002000 = Fast Hit Recovery
	0x00004000 = Faster Hit Recovery
	0x00008000 = Fastest Hit Recovery
	0x00000001 = Fast Block
	0x00000002 = 1-6 additional lightning damage
	0x00000004 = Attacker takes 1-3 thorn damage
	0x00000008 = Cursed Mana
	0x00000010 = Absorb Half Trap Damage
	0x00000020 = ???
	0x00000040 = +200% Damage to Demons
	0x00000080 = Cursed Resistance
	*/
	
	/*
	Magic codes:
	00 = Nothing
	02 = Potion of Full Healing
	03 = Potion of Healing
	06 = Potion of Mana
	07 = Potion of Full Mana
	0A = Elixir of Strength
	0B = Elixir of Magic
	0C = Elixir of Dexterity
	0D = Elixir of Vitality
	12 = Potion of Rejuvenation
	13 = Potion of Full Rejuventaion
	15 = Scroll of Healing, Identify, Town Portal, Infravision, Phasing, Mana
	         Shield, Nova, Teleport, Apocalypse
	16 = Scroll of Resurrect, Lightning, FireWall, Inferno, Flash, Flame Wave,
	         Fireball, Stone Curse, Chain Lightning, Guardian, Golem
	17 = Staves
	18 = Books
	19 = Rings
	1A = Amulets
	1B = Unique items
	2A = Map of the Stars
	2B = Ear/Heart
	2C = Spectral Elixir
	*/
	
	/*
	Spell number
	01 = Firebolt
	02 = Healing
	03 = Lightning
	04 = Flash
	05 = Identify
	06 = FireWall
	07 = Town Portal
	08 = Stone Curse
	09 = Infravision
	0A = Phasing
	0B = Mana Shield
	0C = FireBall
	0D = Guardian
	0E = Chain Lightning
	0F = Flame Wave
	10 = Doom Serpents
	11 = Blood Ritual
	12 = Nova
	13 = Invisibility
	14 = Inferno
	15 = Golem
	16 = Blood Boil
	17 = Teleport
	18 = Apocalypse
	19 = Etherealize
	1A = Item Repair
	1B = Staff recharge
	1C = Trap Disarm
	1D = Elemental
	1E = Charged Bolt
	1F = Holy Bolt
	20 = Resurrect
	21 = Telekinesis
	22 = Heal Other
	23 = Blood Star
	24 = Bone Spirit
	*/
	
	/*
	Use once flag:
	00 = Nothing
	01 = Right clicking the item will make it disappear (potions, scrolls, books)
	*/
	
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
	//private byte[] itemBytes;
	private int slotNumber;
	private boolean changed;
	
	public BaseItem(int slotNumber, byte[] itemBytes, ReaderWriter rw) {
		changed = false;
		this.slotNumber = slotNumber;
		//this.itemBytes = itemBytes;
		activationTrigger = rw.convertFourBytesToNumber(itemBytes[0], itemBytes[1], itemBytes[2], itemBytes[3]);
		itemType = rw.convertUnsignedByteToInt(itemBytes[4]);
		equipLocation = rw.convertUnsignedByteToInt(itemBytes[5]);
		byteSix = rw.convertUnsignedByteToInt(itemBytes[6]);
		byteSeven = rw.convertUnsignedByteToInt(itemBytes[7]);
		graphicValue = rw.convertFourBytesToNumber(itemBytes[8], itemBytes[9], itemBytes[10], itemBytes[11]);
		itemCode = rw.convertUnsignedByteToInt(itemBytes[12]);
		uniqueItemCode = rw.convertUnsignedByteToInt(itemBytes[13]);
		byteFourteen = rw.convertUnsignedByteToInt(itemBytes[14]);
		byteFifteen = rw.convertUnsignedByteToInt(itemBytes[15]);
		BinEditHelper nf = new BinEditHelper();
		if((itemBytes[16] + itemBytes[17] + itemBytes[18] + itemBytes[19]) == 0){
			namePointer = 0;
			name = "None";
		} else {
			namePointer = rw.convertFourBytesToOffset(itemBytes[16], itemBytes[17], itemBytes[18], itemBytes[19]);
			name = nf.getNameUsingPointer(namePointer);			
		}
		if((itemBytes[20] + itemBytes[21] + itemBytes[22] + itemBytes[23]) == 0){
			magicalNamePointer = 0;
			magicalName = "None";
		} else {
			magicalNamePointer = rw.convertFourBytesToOffset(itemBytes[20], itemBytes[21], itemBytes[22], itemBytes[23]);
			magicalName = nf.getNameUsingPointer(magicalNamePointer);
		}
		qualityLevel = rw.convertFourBytesToNumber(itemBytes[24], itemBytes[25], itemBytes[26], itemBytes[27]);
		durability = rw.convertFourBytesToNumber(itemBytes[28], itemBytes[29], itemBytes[30], itemBytes[31]);
		minAttackDamage = rw.convertFourBytesToNumber(itemBytes[32], itemBytes[33], itemBytes[34], itemBytes[35]);
		maxAttackDamage = rw.convertFourBytesToNumber(itemBytes[36], itemBytes[37], itemBytes[38], itemBytes[39]);
		minAc = rw.convertFourBytesToNumber(itemBytes[40], itemBytes[41], itemBytes[42], itemBytes[43]);
		maxAc = rw.convertFourBytesToNumber(itemBytes[44], itemBytes[45], itemBytes[46], itemBytes[47]);
		requiredStr = rw.convertUnsignedByteToInt(itemBytes[48]);
		requiredMag = rw.convertUnsignedByteToInt(itemBytes[49]);
		requiredDex = rw.convertUnsignedByteToInt(itemBytes[50]);
		requiredVit = rw.convertUnsignedByteToInt(itemBytes[51]);
		specialEffects = rw.convertFourBytesToNumber(itemBytes[52], itemBytes[53], itemBytes[54], itemBytes[55]);
		magicCode = rw.convertFourBytesToNumber(itemBytes[56], itemBytes[57], itemBytes[58], itemBytes[59]);
		spellNumber = rw.convertFourBytesToNumber(itemBytes[60], itemBytes[61], itemBytes[62], itemBytes[63]);
		singleUseFlag = rw.convertFourBytesToNumber(itemBytes[64], itemBytes[65], itemBytes[66], itemBytes[67]);
		priceOne = rw.convertFourBytesToNumber(itemBytes[68], itemBytes[69], itemBytes[70], itemBytes[71]);
		priceTwo = rw.convertFourBytesToNumber(itemBytes[72], itemBytes[73], itemBytes[74], itemBytes[75]);
	}
	
	public byte[] getItemAsBytes(){
		byte[] bytes = new byte[TomeOfKnowledge.BASE_ITEM_LENGTH_IN_BYTES];
		bytes[0] = (byte)(activationTrigger >>>  0);
		bytes[1] = (byte)(activationTrigger >>>  8);
		bytes[2] = (byte)(activationTrigger >>> 16);
		bytes[3] = (byte)(activationTrigger >>> 24);
		//System.out.println("Orig: " + itemBytes[0] + "; " + itemBytes[1] + "; " + itemBytes[2] + "; " + itemBytes[3]);
		//System.out.println("Attempt: " + bytes[0] + "; " + bytes[1] + "; " + bytes[2] + "; " + bytes[3]);
		bytes[4] = (byte) itemType;
		bytes[5] = (byte) equipLocation;
		bytes[6] = (byte) byteSix;
		bytes[7] = (byte) byteSeven;
		bytes[8] = (byte)(graphicValue >>>  0);
		bytes[9] = (byte)(graphicValue >>>  8);
		bytes[10] = (byte)(graphicValue >>> 16);
		bytes[11] = (byte)(graphicValue >>> 24);
		bytes[12] = (byte) itemCode;
		bytes[13] = (byte) uniqueItemCode;
		bytes[14] = (byte) byteFourteen;
		bytes[15] = (byte) byteFifteen;
		long namePointerReverse;
		if(namePointer == 0){
			namePointerReverse = 0;
		} else {
			namePointerReverse = namePointer + TomeOfKnowledge.DIABLO_POINTERS_OFFSET;
		}
		bytes[16] = (byte)(namePointerReverse >>>  0);
		bytes[17] = (byte)(namePointerReverse >>>  8);
		bytes[18] = (byte)(namePointerReverse >>> 16);
		bytes[19] = (byte)(namePointerReverse >>> 24);
		long magPointerReverse;
		if(magicalNamePointer == 0){
			magPointerReverse = 0;
		} else {
			magPointerReverse = magicalNamePointer + TomeOfKnowledge.DIABLO_POINTERS_OFFSET;
		}
		bytes[20] = (byte)(magPointerReverse >>>  0);
		bytes[21] = (byte)(magPointerReverse >>>  8);
		bytes[22] = (byte)(magPointerReverse >>> 16);
		bytes[23] = (byte)(magPointerReverse >>> 24);
		bytes[24] = (byte)(qualityLevel >>>  0);
		bytes[25] = (byte)(qualityLevel >>>  8);
		bytes[26] = (byte)(qualityLevel >>> 16);
		bytes[27] = (byte)(qualityLevel >>> 24);
		bytes[28] = (byte)(durability >>>  0);
		bytes[29] = (byte)(durability >>>  8);
		bytes[30] = (byte)(durability >>> 16);
		bytes[31] = (byte)(durability >>> 24);
		bytes[32] = (byte)(minAttackDamage >>>  0);
		bytes[33] = (byte)(minAttackDamage >>>  8);
		bytes[34] = (byte)(minAttackDamage >>> 16);
		bytes[35] = (byte)(minAttackDamage >>> 24);
		bytes[36] = (byte)(maxAttackDamage >>>  0);
		bytes[37] = (byte)(maxAttackDamage >>>  8);
		bytes[38] = (byte)(maxAttackDamage >>> 16);
		bytes[39] = (byte)(maxAttackDamage >>> 24);
		bytes[40] = (byte)(minAc >>>  0);
		bytes[41] = (byte)(minAc >>>  8);
		bytes[42] = (byte)(minAc >>> 16);
		bytes[43] = (byte)(minAc >>> 24);
		bytes[44] = (byte)(maxAc >>>  0);
		bytes[45] = (byte)(maxAc >>>  8);
		bytes[46] = (byte)(maxAc >>> 16);
		bytes[47] = (byte)(maxAc >>> 24);
		bytes[48] = (byte) requiredStr;
		bytes[49] = (byte) requiredMag;
		bytes[50] = (byte) requiredDex;
		bytes[51] = (byte) requiredVit;
		bytes[52] = (byte)(specialEffects >>>  0);
		bytes[53] = (byte)(specialEffects >>>  8);
		bytes[54] = (byte)(specialEffects >>> 16);
		bytes[55] = (byte)(specialEffects >>> 24);
		bytes[56] = (byte)(magicCode >>>  0);
		bytes[57] = (byte)(magicCode >>>  8);
		bytes[58] = (byte)(magicCode >>> 16);
		bytes[59] = (byte)(magicCode >>> 24);
		bytes[60] = (byte)(spellNumber >>>  0);
		bytes[61] = (byte)(spellNumber >>>  8);
		bytes[62] = (byte)(spellNumber >>> 16);
		bytes[63] = (byte)(spellNumber >>> 24);
		bytes[64] = (byte)(singleUseFlag >>>  0);
		bytes[65] = (byte)(singleUseFlag >>>  8);
		bytes[66] = (byte)(singleUseFlag >>> 16);
		bytes[67] = (byte)(singleUseFlag >>> 24);
		bytes[68] = (byte)(priceOne >>>  0);
		bytes[69] = (byte)(priceOne >>>  8);
		bytes[70] = (byte)(priceOne >>> 16);
		bytes[71] = (byte)(priceOne >>> 24);
		bytes[72] = (byte)(priceTwo >>>  0);
		bytes[73] = (byte)(priceTwo >>>  8);
		bytes[74] = (byte)(priceTwo >>> 16);
		bytes[75] = (byte)(priceTwo >>> 24);
		//System.out.println("ORIG: " + Arrays.toString(itemBytes));
		//System.out.println("BACK: " + Arrays.toString(bytes));
		//System.out.println();
		return bytes;
	}

	public void printItem() {
		System.out.println("Slot number: " + slotNumber + " (hex: " + Integer.toHexString(slotNumber) + ")");
		System.out.println("Name: " + name);
		System.out.println("Name pointer: " + namePointer);
		System.out.println("Magical name: " + magicalName);
		System.out.println("Magical name pointer: " + magicalNamePointer);
		System.out.println("Activation trigger: " + baseItemActivationTriggers[(int) activationTrigger]);
		System.out.println("Item type: " + itemTypes[itemType]);
		System.out.println("Equip location: " + equipLocations[equipLocation]);
		System.out.println("Byte six: " + byteSix);
		System.out.println("Byte seven: " + byteSeven);
		System.out.println("Graphic: " + graphicValues[(int) graphicValue]);
		System.out.println("Item code: " + itemCodes[itemCode]);
		String[] uniqueItemCodes = UniqueItem.createNewItemTypeArray();
		System.out.println("Unique item code: " + uniqueItemCodes[uniqueItemCode]);
		System.out.println("Byte fourteen: " + byteFourteen);
		System.out.println("Byte fifteen: " + byteFifteen);
		System.out.println("Quality level: " + qualityLevel);
		System.out.println("Durability: " + durability);
		System.out.println("Min attack damage: " + minAttackDamage);
		System.out.println("Max attack damage: " + maxAttackDamage);
		System.out.println("Min ac: " + minAc);
		System.out.println("Max ac: " + maxAc);
		System.out.println("Required Str: " + requiredStr);
		System.out.println("Required Mag: " + requiredMag);
		System.out.println("Required Dex: " + requiredDex);
		System.out.println("Required Vit: " + requiredVit);
		System.out.println("Special effects: " + specialEffects);
		System.out.println("Magic code: " + magicCode);
		System.out.println("Spell number: " + spellNumber);
		System.out.println("Single use flag: " + singleUseFlag);
		System.out.println("Price one: " + priceOne);
		System.out.println("Price two: " + priceTwo);
		System.out.println();
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

	//TODO
	private String getName() {
		return name;
	}

	//TODO
	private void setName(String name) {
		this.name = name;
	}

	public long getMagicalNamePointer() {
		return magicalNamePointer;
	}

	public void setMagicalNamePointer(long magicalNamePointer) {
		if(magicalNamePointer >= 1024 && magicalNamePointer <= 7018496){
			this.magicalNamePointer = magicalNamePointer;
			this.setChanged();
		} else {
			System.err.println("Error: BaseItem's setMagicalNamePointer() was"
					+ "supplied with an argument outside the supported range (1024 to 7018496)");
		}
	}

	//TODO
	private String getMagicalName() {
		return magicalName;
	}

	//TODO
	private void setMagicalName(String magicalName) {
		this.magicalName = magicalName;
	}

	public long getQualityLevel() {
		return qualityLevel;
	}

	//0 to 15
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

	public boolean isChanged() {
		return changed;
	}

	public void setChanged() {
		this.changed = true;
	}
}
