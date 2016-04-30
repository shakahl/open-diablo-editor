package uk.me.karlsen.ode.types;

import java.util.ArrayList;
import java.util.List;

import uk.me.karlsen.ode.ReaderWriter;
import uk.me.karlsen.ode.utils.BinEditHelper;

public class UniqueItem {

	private long namePointer;
	private String name;
	private int itemType;
	private int qualityLevel;
	private int numberOfEffects;
	private long goldValue;
	private List<ItemEffect> itemEffects;
	private String[] effectsArray;

	public UniqueItem(byte[] readIn, ReaderWriter rw){
		effectsArray = this.createNewItemEffectsArray();
		BinEditHelper beh = new BinEditHelper();
		itemEffects = new ArrayList<ItemEffect>();
		namePointer = beh.convertFourBytesToOffset(readIn, 0);
		name = beh.getNameUsingPointer(namePointer);
		itemType = beh.convertUnsignedByteToInt(readIn[4]);
		qualityLevel = beh.convertUnsignedByteToInt(readIn[5]);
		numberOfEffects = beh.convertTwoBytesToInt(readIn[6], readIn[7]);
		goldValue = beh.convertFourBytesToNumber(readIn, 8);
		for(int offset = 12; offset < 84; offset = offset + 12){
			ItemEffect ie = new ItemEffect(readIn, offset);
			itemEffects.add(ie);
		}
	}

	public void printItem() {
		System.out.println("Name: " + name);
		System.out.println("Name pointer: " + namePointer);
		String[] itemTypesArray = UniqueItem.createNewItemTypeArray();
		System.out.println("Item type: " + itemTypesArray[itemType]);
		System.out.println("Quality level: " + qualityLevel);
		System.out.println("Number of effects: " + numberOfEffects);
		System.out.println("Gold value: " + goldValue);
		for(ItemEffect ie : itemEffects){
			System.out.println("Effect " + ie.getEffectNumber() + ": " + 
					effectsArray[(int) ie.getEffect()] +"; " + ie.getMinValue() + "; " + ie.getMaxValue());
		}
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

	public byte[] getItemAsBytes() {
		byte[] itemAsBytes = new byte[84];
		BinEditHelper beh = new BinEditHelper();
		beh.setPointerAsFourBytes(namePointer, itemAsBytes, 0);
		itemAsBytes[4] = (byte) itemType;
		itemAsBytes[5] = (byte) qualityLevel;
		itemAsBytes[6] = (byte) (numberOfEffects >>> 0);
		itemAsBytes[7] = (byte) (numberOfEffects >>> 8);
		beh.setLongAsFourBytes(goldValue, itemAsBytes, 8);
		for(int offset = 12; offset < 84; offset = offset + 12){
			ItemEffect ie = itemEffects.get( (offset / 12 ) - 1);
			beh.setLongAsFourBytes(ie.getEffect(), itemAsBytes, offset);
			beh.setLongAsFourBytes(ie.getMinValue(), itemAsBytes, offset+4);
			beh.setLongAsFourBytes(ie.getMaxValue(), itemAsBytes, offset+8);
		}

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

	public long getEffect(int effectIndex) {
		return itemEffects.get(effectIndex-1).getEffect();
	}

	public void setEffect(long effect, int effectIndex) {
		ItemEffect ie = itemEffects.get(effectIndex-1);
		ie.setEffect(effect);
	}

	public long getMinValue(int effectIndex) {
		return itemEffects.get(effectIndex-1).getMinValue();
	}

	public void setMinValue(long minValue, int effectIndex) {
		ItemEffect ie = itemEffects.get(effectIndex-1);
		ie.setMinValue(minValue);
	}

	public long getMaxValue(int effectIndex) {
		return itemEffects.get(effectIndex-1).getMaxValue();
	}

	public void setMaxValue(long maxValue, int effectIndex) {
		ItemEffect ie = itemEffects.get(effectIndex-1);
		ie.setMaxValue(maxValue);
	}
	
	public long getEffectNumber(int effectIndex) {
		return itemEffects.get(effectIndex-1).getEffectNumber();
	}
	
	public String getEffectName(int effectIndex) {
		return itemEffects.get(effectIndex-1).getEffectName();
	}
}
