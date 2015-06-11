package uk.me.karlsen.ode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BaseMonster {

	private long animationSize;
	private long seedingSize;
	private long animationFilePointer;
	private String animationFileName;
	private long secondAttack;
	private long soundPointer;
	private long hasSecondAttackSound;
	private long usesTrnToModColor;
	private long trnPointer;
	private long idleFrameset;
	private long walkFrameset;
	private long attackFrameset;
	private long hitRecoveryFrameset;
	private long deathFrameset;
	private long secondAttackFrameset;
	private long idlePlaybackSpeed;
	private long walkPlaybackSpeed;
	private long attackPlaybackSpeed;
	private long hitRecoverySpeed;
	private long deathPlaybackSpeed;
	private long secondAttackSpeed;
	private long namePointer;
	private String name;
	private int minDungeonLevel;
	private int maxDungeonLevel;
	private int monsterItemLevel;
	private long minHitPoints;
	private long maxHitPoints;
	private int attackType1;
	private int attackType2;
	private int attackType3;
	private int attackType4;
	private int attackType5;
	private int monsterIntelligence;
	private int attackType7;
	private int attackType8;
	private int subType;
	private int monsterPriChanceToHit;
	private int priToHitFrame;
	private int priMinAttackDamage;
	private int priMaxAttackDamage;
	private int secToHitChance;
	private int secToHitFrame;
	private int secMinAttackDamage;
	private int secMaxAttackDamage;
	private int monsterAc;
	private int monsterType;
	private String resistancesNormAndNightmare;
	private String resistancesHell;
	private int itemDropSpecials;
	private int monsterSelectionOutline;
	private long experiencePoints;
	private int enabled;
	private boolean changed;
	private byte[] monsterBytesOrig;
	int slotNumber;

	public BaseMonster(int slotNumber, byte[] monsterBytes, byte activationByte, ReaderWriter rw) {
		this.slotNumber = slotNumber;
		animationSize = rw.convertFourBytesToNumber(monsterBytes[0], monsterBytes[1], monsterBytes[2], monsterBytes[3]);
		seedingSize = rw.convertFourBytesToNumber(monsterBytes[4], monsterBytes[5], monsterBytes[6], monsterBytes[7]);
		animationFilePointer = rw.convertFourBytesToOffset(monsterBytes[8], monsterBytes[9], monsterBytes[10], monsterBytes[11]);
		BinEditHelper nf = new BinEditHelper();
		animationFileName = nf.getNameUsingPointer(animationFilePointer);
		secondAttack = rw.convertFourBytesToNumber(monsterBytes[12], monsterBytes[13], monsterBytes[14], monsterBytes[15]);
		soundPointer = rw.convertFourBytesToOffset(monsterBytes[16], monsterBytes[17], monsterBytes[18], monsterBytes[19]);
		hasSecondAttackSound = rw.convertFourBytesToNumber(monsterBytes[20], monsterBytes[21], monsterBytes[22], monsterBytes[23]);
		usesTrnToModColor = rw.convertFourBytesToNumber(monsterBytes[24], monsterBytes[25], monsterBytes[26], monsterBytes[27]);
		trnPointer = rw.convertFourBytesToOffset(monsterBytes[28], monsterBytes[29], monsterBytes[30], monsterBytes[31]);
		idleFrameset = rw.convertFourBytesToNumber(monsterBytes[32], monsterBytes[33], monsterBytes[34], monsterBytes[35]);
		walkFrameset = rw.convertFourBytesToNumber(monsterBytes[36], monsterBytes[37], monsterBytes[38], monsterBytes[39]);
		attackFrameset = rw.convertFourBytesToNumber(monsterBytes[40], monsterBytes[41], monsterBytes[42], monsterBytes[43]);
		hitRecoveryFrameset = rw.convertFourBytesToNumber(monsterBytes[44], monsterBytes[45], monsterBytes[46], monsterBytes[47]);
		deathFrameset = rw.convertFourBytesToNumber(monsterBytes[48], monsterBytes[49], monsterBytes[50], monsterBytes[51]);
		secondAttackFrameset = rw.convertFourBytesToNumber(monsterBytes[52], monsterBytes[53], monsterBytes[54], monsterBytes[55]);
		idlePlaybackSpeed = rw.convertFourBytesToNumber(monsterBytes[56], monsterBytes[57], monsterBytes[58], monsterBytes[59]);
		walkPlaybackSpeed = rw.convertFourBytesToNumber(monsterBytes[60], monsterBytes[61], monsterBytes[62], monsterBytes[63]);
		attackPlaybackSpeed = rw.convertFourBytesToNumber(monsterBytes[64], monsterBytes[65], monsterBytes[66], monsterBytes[67]);
		hitRecoverySpeed = rw.convertFourBytesToNumber(monsterBytes[68], monsterBytes[69], monsterBytes[70], monsterBytes[71]);
		deathPlaybackSpeed = rw.convertFourBytesToNumber(monsterBytes[72], monsterBytes[73], monsterBytes[74], monsterBytes[75]);
		secondAttackSpeed = rw.convertFourBytesToNumber(monsterBytes[76], monsterBytes[77], monsterBytes[78], monsterBytes[79]);
		namePointer = rw.convertFourBytesToOffset(monsterBytes[80], monsterBytes[81], monsterBytes[82], monsterBytes[83]);
		name = nf.getNameUsingPointer(namePointer);
		minDungeonLevel = rw.convertUnsignedByteToInt(monsterBytes[84]);
		maxDungeonLevel = rw.convertUnsignedByteToInt(monsterBytes[85]);
		// ### [ NOTE ] ###
		// monsterItemLevel occupies only byte monsterBytes[86]. The following
		// byte (monsterBytes[87]) is reserved.
		//
		// TODO: Update the relevant code to reflect this.
		// ### [/ NOTE ] ###
		monsterItemLevel = rw.convertTwoBytesToInt(monsterBytes[86], monsterBytes[87]);
		minHitPoints = rw.convertFourBytesToNumber(monsterBytes[88], monsterBytes[89], monsterBytes[90], monsterBytes[91]);
		maxHitPoints = rw.convertFourBytesToNumber(monsterBytes[92], monsterBytes[93], monsterBytes[94], monsterBytes[95]);
		attackType1 = rw.convertUnsignedByteToInt(monsterBytes[96]);
		attackType2 = rw.convertUnsignedByteToInt(monsterBytes[97]);
		attackType3 = rw.convertUnsignedByteToInt(monsterBytes[98]);
		attackType4 = rw.convertUnsignedByteToInt(monsterBytes[99]);
		attackType5 = rw.convertUnsignedByteToInt(monsterBytes[100]);
		monsterIntelligence = rw.convertUnsignedByteToInt(monsterBytes[101]);
		attackType7 = rw.convertUnsignedByteToInt(monsterBytes[102]);
		attackType8 = rw.convertUnsignedByteToInt(monsterBytes[103]);
		subType = rw.convertUnsignedByteToInt(monsterBytes[104]);
		monsterPriChanceToHit = rw.convertUnsignedByteToInt(monsterBytes[105]);
		priToHitFrame = rw.convertUnsignedByteToInt(monsterBytes[106]);
		priMinAttackDamage = rw.convertUnsignedByteToInt(monsterBytes[107]);
		priMaxAttackDamage = rw.convertUnsignedByteToInt(monsterBytes[108]);
		secToHitChance = rw.convertUnsignedByteToInt(monsterBytes[109]);
		secToHitFrame = rw.convertUnsignedByteToInt(monsterBytes[110]);
		secMinAttackDamage = rw.convertUnsignedByteToInt(monsterBytes[111]);
		secMaxAttackDamage = rw.convertUnsignedByteToInt(monsterBytes[112]);
		monsterAc = rw.convertUnsignedByteToInt(monsterBytes[113]);
		monsterType = rw.convertTwoBytesToInt(monsterBytes[114], monsterBytes[115]);
		resistancesNormAndNightmare = String.format("%16s", Integer.toBinaryString(rw.convertUnsignedByteToInt(monsterBytes[116]))).replace(' ', '0') +
				String.format("%16s", Integer.toBinaryString(rw.convertUnsignedByteToInt(monsterBytes[117]))).replace(' ', '0');
		resistancesHell = String.format("%16s", Integer.toBinaryString(rw.convertUnsignedByteToInt(monsterBytes[118]))).replace(' ', '0') +
				String.format("%16s", Integer.toBinaryString(rw.convertUnsignedByteToInt(monsterBytes[119]))).replace(' ', '0');
		itemDropSpecials = rw.convertTwoBytesToInt(monsterBytes[120], monsterBytes[121]);
		monsterSelectionOutline = rw.convertTwoBytesToInt(monsterBytes[122], monsterBytes[123]);
		experiencePoints = rw.convertFourBytesToNumber(monsterBytes[124], monsterBytes[125], monsterBytes[126], monsterBytes[127]);
		enabled = rw.convertUnsignedByteToInt(activationByte);
		changed = false;
		this.monsterBytesOrig = monsterBytes;
	}

	public MonsterAsBytes getMonsterAsBytes(){
		byte[] monsterBytes = new byte[TomeOfKnowledge.BASE_MONSTER_LENGTH_IN_BYTES];
		monsterBytes[0] = (byte)(animationSize >>>  0);
		monsterBytes[1] = (byte)(animationSize >>>  8);
		monsterBytes[2] = (byte)(animationSize >>> 16);
		monsterBytes[3] = (byte)(animationSize >>> 24);
		monsterBytes[4] = (byte)(seedingSize >>>  0);
		monsterBytes[5] = (byte)(seedingSize >>>  8);
		monsterBytes[6] = (byte)(seedingSize >>> 16);
		monsterBytes[7] = (byte)(seedingSize >>> 24);
		long animationFilePointerRev = animationFilePointer + TomeOfKnowledge.DIABLO_POINTERS_OFFSET;
		monsterBytes[8] = (byte)(animationFilePointerRev >>>  0);
		monsterBytes[9] = (byte)(animationFilePointerRev >>>  8);
		monsterBytes[10] = (byte)(animationFilePointerRev >>> 16);
		monsterBytes[11] = (byte)(animationFilePointerRev >>> 24);
		monsterBytes[12] = (byte)(secondAttack >>>  0);
		monsterBytes[13] = (byte)(secondAttack >>>  8);
		monsterBytes[14] = (byte)(secondAttack >>> 16);
		monsterBytes[15] = (byte)(secondAttack >>> 24);
		long soundPointerRev = soundPointer + TomeOfKnowledge.DIABLO_POINTERS_OFFSET;
		monsterBytes[16] = (byte)(soundPointerRev >>>  0);
		monsterBytes[17] = (byte)(soundPointerRev >>>  8);
		monsterBytes[18] = (byte)(soundPointerRev >>> 16);
		monsterBytes[19] = (byte)(soundPointerRev >>> 24);
		monsterBytes[20] = (byte)(hasSecondAttackSound >>>  0);
		monsterBytes[21] = (byte)(hasSecondAttackSound >>>  8);
		monsterBytes[22] = (byte)(hasSecondAttackSound >>> 16);
		monsterBytes[23] = (byte)(hasSecondAttackSound >>> 24);
		monsterBytes[24] = (byte)(usesTrnToModColor >>>  0);
		monsterBytes[25] = (byte)(usesTrnToModColor >>>  8);
		monsterBytes[26] = (byte)(usesTrnToModColor >>> 16);
		monsterBytes[27] = (byte)(usesTrnToModColor >>> 24);
		long trnPointerRev = trnPointer + TomeOfKnowledge.DIABLO_POINTERS_OFFSET;
		monsterBytes[28] = (byte)(trnPointerRev >>>  0);
		monsterBytes[29] = (byte)(trnPointerRev >>>  8);
		monsterBytes[30] = (byte)(trnPointerRev >>> 16);
		monsterBytes[31] = (byte)(trnPointerRev >>> 24);
		monsterBytes[32] = (byte)(idleFrameset >>>  0);
		monsterBytes[33] = (byte)(idleFrameset >>>  8);
		monsterBytes[34] = (byte)(idleFrameset >>> 16);
		monsterBytes[35] = (byte)(idleFrameset >>> 24);
		monsterBytes[36] = (byte)(walkFrameset >>>  0);
		monsterBytes[37] = (byte)(walkFrameset >>>  8);
		monsterBytes[38] = (byte)(walkFrameset >>> 16);
		monsterBytes[39] = (byte)(walkFrameset >>> 24);
		monsterBytes[40] = (byte)(attackFrameset >>>  0);
		monsterBytes[41] = (byte)(attackFrameset >>>  8);
		monsterBytes[42] = (byte)(attackFrameset >>> 16);
		monsterBytes[43] = (byte)(attackFrameset >>> 24);
		monsterBytes[44] = (byte)(hitRecoveryFrameset >>>  0);
		monsterBytes[45] = (byte)(hitRecoveryFrameset >>>  8);
		monsterBytes[46] = (byte)(hitRecoveryFrameset >>> 16);
		monsterBytes[47] = (byte)(hitRecoveryFrameset >>> 24);
		monsterBytes[48] = (byte)(deathFrameset >>>  0);
		monsterBytes[49] = (byte)(deathFrameset >>>  8);
		monsterBytes[50] = (byte)(deathFrameset >>> 16);
		monsterBytes[51] = (byte)(deathFrameset >>> 24);
		monsterBytes[52] = (byte)(secondAttackFrameset >>>  0);
		monsterBytes[53] = (byte)(secondAttackFrameset >>>  8);
		monsterBytes[54] = (byte)(secondAttackFrameset >>> 16);
		monsterBytes[55] = (byte)(secondAttackFrameset >>> 24);
		monsterBytes[56] = (byte)(idlePlaybackSpeed >>>  0);
		monsterBytes[57] = (byte)(idlePlaybackSpeed >>>  8);
		monsterBytes[58] = (byte)(idlePlaybackSpeed >>> 16);
		monsterBytes[59] = (byte)(idlePlaybackSpeed >>> 24);
		monsterBytes[60] = (byte)(walkPlaybackSpeed >>>  0);
		monsterBytes[61] = (byte)(walkPlaybackSpeed >>>  8);
		monsterBytes[62] = (byte)(walkPlaybackSpeed >>> 16);
		monsterBytes[63] = (byte)(walkPlaybackSpeed >>> 24);
		monsterBytes[64] = (byte)(attackPlaybackSpeed >>>  0);
		monsterBytes[65] = (byte)(attackPlaybackSpeed >>>  8);
		monsterBytes[66] = (byte)(attackPlaybackSpeed >>> 16);
		monsterBytes[67] = (byte)(attackPlaybackSpeed >>> 24);
		monsterBytes[68] = (byte)(hitRecoverySpeed >>>  0);
		monsterBytes[69] = (byte)(hitRecoverySpeed >>>  8);
		monsterBytes[70] = (byte)(hitRecoverySpeed >>> 16);
		monsterBytes[71] = (byte)(hitRecoverySpeed >>> 24);
		monsterBytes[72] = (byte)(deathPlaybackSpeed >>>  0);
		monsterBytes[73] = (byte)(deathPlaybackSpeed >>>  8);
		monsterBytes[74] = (byte)(deathPlaybackSpeed >>> 16);
		monsterBytes[75] = (byte)(deathPlaybackSpeed >>> 24);
		monsterBytes[76] = (byte)(secondAttackSpeed >>>  0);
		monsterBytes[77] = (byte)(secondAttackSpeed >>>  8);
		monsterBytes[78] = (byte)(secondAttackSpeed >>> 16);
		monsterBytes[79] = (byte)(secondAttackSpeed >>> 24);
		long namePointerRev = namePointer + TomeOfKnowledge.DIABLO_POINTERS_OFFSET;
		monsterBytes[80] = (byte)(namePointerRev >>>  0);
		monsterBytes[81] = (byte)(namePointerRev >>>  8);
		monsterBytes[82] = (byte)(namePointerRev >>> 16);
		monsterBytes[83] = (byte)(namePointerRev >>> 24);
		monsterBytes[84] = (byte) minDungeonLevel;
		monsterBytes[85] = (byte) maxDungeonLevel;
		monsterBytes[86] = (byte) monsterItemLevel;
		monsterBytes[87] = (byte)0;
		monsterBytes[88] = (byte)(minHitPoints >>>  0);
		monsterBytes[89] = (byte)(minHitPoints >>>  8);
		monsterBytes[90] = (byte)(minHitPoints >>> 16);
		monsterBytes[91] = (byte)(minHitPoints >>> 24);
		monsterBytes[92] = (byte)(maxHitPoints >>>  0);
		monsterBytes[93] = (byte)(maxHitPoints >>>  8);
		monsterBytes[94] = (byte)(maxHitPoints >>> 16);
		monsterBytes[95] = (byte)(maxHitPoints >>> 24);
		monsterBytes[96] = (byte) attackType1; //attackType1
		monsterBytes[97] = (byte) attackType2; //attackType2
		monsterBytes[98] = (byte) attackType3; //attackType3
		monsterBytes[99] = (byte) attackType4; //attackType4
		monsterBytes[100] = (byte) attackType5; //attackType5
  		monsterBytes[101] = (byte) monsterIntelligence; //monsterIntelligence
		monsterBytes[102] = (byte) attackType7; //attackType7
		monsterBytes[103] = (byte) attackType8; //attackType8
		monsterBytes[104] = (byte) subType; //subType
		monsterBytes[105] = (byte) monsterPriChanceToHit; //monsterPriChanceToHit
		monsterBytes[106] = (byte) priToHitFrame; //priToHitFrame
		monsterBytes[107] = (byte) priMinAttackDamage; //priMinAttackDamage
		monsterBytes[108] = (byte) priMaxAttackDamage; //priMaxAttackDamage
		monsterBytes[109] = (byte) secToHitChance; //secToHitChance
		monsterBytes[110] = (byte) secToHitFrame; //secToHitFrame
		monsterBytes[111] = (byte) secMinAttackDamage; //secMinAttackDamage
		monsterBytes[112] = (byte) secMaxAttackDamage; //secMaxAttackDamage
		monsterBytes[113] = (byte) monsterAc; //monsterAc
		monsterBytes[114] = (byte)(monsterType >>>  0); //monsterType
		monsterBytes[115] = (byte)(monsterType >>>  8);
		String res1 = resistancesNormAndNightmare.substring(0, 8);
		String res2 = resistancesNormAndNightmare.substring(8, 16);
		monsterBytes[116] = (byte) Integer.parseInt(res2, 2);
		monsterBytes[117] = (byte) Integer.parseInt(res1, 2);
		String res3 = resistancesHell.substring(0, 8);
		String res4 = resistancesHell.substring(8, 16);
		monsterBytes[118] = (byte) Integer.parseInt(res4, 2); //resistancesHell
		monsterBytes[119] = (byte) Integer.parseInt(res3, 2);
		monsterBytes[120] = (byte)(itemDropSpecials >>>  0); //itemDropSpecials
		monsterBytes[121] = (byte)(itemDropSpecials >>>  8);
		monsterBytes[122] = (byte)(monsterSelectionOutline >>>  0); //monsterSelectionOutline
		monsterBytes[123] = (byte)(monsterSelectionOutline >>>  8);
		monsterBytes[124] = (byte)(experiencePoints >>>  0);
		monsterBytes[125] = (byte)(experiencePoints >>>  8);
		monsterBytes[126] = (byte)(experiencePoints >>> 16);
		monsterBytes[127] = (byte)(experiencePoints >>> 24);
		MonsterAsBytes mab = new MonsterAsBytes(monsterBytes, (byte) enabled);
		//System.out.println("ORIG: " + Arrays.toString(monsterBytesOrig));
		//System.out.println("BACK: " + Arrays.toString(monsterBytes) + "\n");
		return mab;
	}

	public void printMonster() {
		System.out.println( "+--------------------------------------+" + "\n" +
							"| Slot number: " + slotNumber + " (hex: " + Integer.toHexString(slotNumber) + ")" + "\n" +
							"| Monster name: " + name + "\n" +
							"| Enabled: " + enabled + "\n" +
							"| Animation size: " + animationSize + "\n" +
							"| Seeding size: " + seedingSize + "\n" +
							"| Animation file pointer: " + animationFilePointer + "\n" +
							"| Animation file name: " + animationFileName + "\n" +
							"| Second attack: " + secondAttack + "\n" +
							"| Sound pointer: " + soundPointer + "\n" +
							"| Has second attack sound: " + hasSecondAttackSound + "\n" +
							"| Uses TRN to mod color: " + usesTrnToModColor + "\n" +
							"| TRN pointer: " + trnPointer + "\n" +
							"| Idle frameset: " + idleFrameset + "\n" +
							"| Walk frameset: " + walkFrameset + "\n" +
							"| Attack frameset: " + attackFrameset + "\n" +
							"| Hit recovery frameset: " + hitRecoveryFrameset + "\n" +
							"| Death frameset: " + deathFrameset + "\n" +
							"| Second attack frameset: " + secondAttackFrameset + "\n" +
							"| Idle playback speed: " + idlePlaybackSpeed + "\n" +
							"| Walk playback speed: " + walkPlaybackSpeed + "\n" +
							"| Attack playback speed: " + attackPlaybackSpeed + "\n" +
							"| Hit recovery speed: " + hitRecoverySpeed + "\n" +
							"| Death playback speed: " + deathPlaybackSpeed + "\n" +
							"| Second attack speed: " + secondAttackSpeed + "\n" +
							"| Name pointer: " + namePointer + "\n" +
							"| Min dungeon level: " + minDungeonLevel + "\n" +
							"| Max dungeon level: " + maxDungeonLevel + "\n" +
							"| Monster item level: " + monsterItemLevel + "\n" +
							"| HPs: " + minHitPoints + "--" + maxHitPoints + "\n" +
							"| Attack type (byte 1): " + attackType1 + "\n" +
							"| Attack type (byte 2): " + attackType2 + "\n" +
							"| Attack type (byte 3): " + attackType3 + "\n" +
							"| Attack type (byte 4): " + attackType4 + "\n" +
							"| Attack type (byte 5): " + attackType5 + "\n" +
							"| Monster intelligence: " + monsterIntelligence + "\n" +
							"| Attack type (byte 7): " + attackType7 + "\n" +
							"| Attack type (byte 8): " + attackType8 + "\n" +
							"| Monster sub-type: " + subType + "\n" +
							"| Primary attack % hit: " + monsterPriChanceToHit + "\n" +
							"| Primary to-hit frame: " + priToHitFrame + "\n" +
							"| Primary damage: " + priMinAttackDamage + "--" + priMaxAttackDamage + "\n" +
							"| Sec. attack % hit: " + secToHitChance + "\n" +
							"| Sec. to-hit frame: " + secToHitFrame + "\n" +
							"| Secondary damage: " + secMinAttackDamage + "--" + secMaxAttackDamage + "\n" +
							"| Monster AC: " + monsterAc + "\n" +
							"| Monster type: " + monsterType + "\n" +
							"| Resistances (norm. and nightmare): " + resistancesNormAndNightmare + "\n" +
							"| Resistances (hell mode): " + resistancesHell + "\n" +
							"| Item drop specials: " + itemDropSpecials + "\n" +
							"| Monster selection outline: " + monsterSelectionOutline + "\n" +
							"| XP: " + experiencePoints + "\n" +
							"+--------------------------------------+" + "\n" );
	}

	public long getAnimationSize() {
		return animationSize;
	}

	//128, 160, 96
	public void setAnimationSize(long animationSize) {
		Integer[] animationSizes = {96, 128, 160};
		List<Integer> animationSizeList = Arrays.asList(animationSizes);
		if(animationSizeList.contains((int) animationSize)){
			this.animationSize = animationSize;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setAnimationSize() was"
					+ "supplied with an argument outside the supported range of options (96, 128, 160)");
		}
	}

	public long getSeedingSize() {
		return seedingSize;
	}

	public void setSeedingSize(long seedingSize) {
		if(seedingSize >= 0 && seedingSize <= 2500){
			this.seedingSize = seedingSize;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setSetSeedingSize() was"
					+ "supplied with an argument outside the supported range (0 to 2500)");
		}
	}

	public long getAnimationFilePointer() {
		return animationFilePointer;
	}


	public void setAnimationFilePointer(long animationFilePointer) {
		if(animationFilePointer >= 1024 && animationFilePointer <= 7018496){
			this.animationFilePointer = animationFilePointer;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setAnimationFilePointer() was"
					+ "supplied with an argument outside the supported range (1024 to 7018496)");
		}
	}

	//TODO
	private String getAnimationFileName() {
		return animationFileName;
	}

	//TODO
	private void setAnimationFileName(String animationFileName) {
		this.animationFileName = animationFileName;
	}

	public long getSecondAttackOnOrOff() {
		return secondAttack;
	}

	public void setSecondAttackOnOrOff(long secondAttack) {
		if(secondAttack == 1 || secondAttack == 0){
			this.secondAttack = secondAttack;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setSecondAttackOnOrOff() requires"
					+ "that the second attack either be enabled (1) or disabled (0)");
		}
	}

	public long getSoundPointer() {
		return soundPointer;
	}

	public void setSoundPointer(long soundPointer) {
		if(soundPointer >= 1024 && soundPointer <= 7018496){
			this.soundPointer = soundPointer;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setSoundPointer() was"
					+ "supplied with an argument outside the supported range (1024 to 7018496)");
		}
	}

	public long getHasSecondAttackSound() {
		return hasSecondAttackSound;
	}

	public void setHasSecondAttackSound(long hasSecondAttackSound) {
		if(hasSecondAttackSound >= 0 && hasSecondAttackSound <= 1){
			this.hasSecondAttackSound = hasSecondAttackSound;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setHasSecondAttackSound() was"
					+ "supplied with an argument outside the supported range (0 to 1)");
		}
	}

	public long getUsesTrnToModColor() {
		return usesTrnToModColor;
	}

	public void setUsesTrnToModColor(long usesTrnToModColor) {
		if(usesTrnToModColor >= 0 && usesTrnToModColor <= 1){
			this.usesTrnToModColor = usesTrnToModColor;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setUsesTrnToModColor() was"
					+ "supplied with an argument outside the supported range (0 to 1)");
		}
	}

	public long getTrnPointer() {
		return trnPointer;
	}

	public void setTrnPointer(long trnPointer) {
		if(trnPointer <= 1024 && trnPointer >= 7018496){
			this.trnPointer = trnPointer;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setUsesTrnPointer() was"
					+ "supplied with an argument outside the supported range (1024 to 7018496)");
		}
	}

	public long getIdleFrameset() {
		return idleFrameset;
	}

	public void setIdleFrameset(long idleFrameset) {
		if(idleFrameset > 0 && idleFrameset <= 24){
			this.idleFrameset = idleFrameset;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setIdleFrameset() was"
					+ "supplied with an argument outside the supported range (1 to 24)");
		}
	}

	public long getWalkFrameset() {
		return walkFrameset;
	}

	public void setWalkFrameset(long walkFrameset) {
		if(walkFrameset > 0 && walkFrameset <= 24){
			this.walkFrameset = walkFrameset;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setWalkFrameset() was"
					+ "supplied with an argument outside the supported range (1 to 24)");
		}
	}

	public long getAttackFrameset() {
		return attackFrameset;
	}

	public void setAttackFrameset(long attackFrameset) {
		if(attackFrameset > 0 && attackFrameset <= 24){
			this.attackFrameset = attackFrameset;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setAttackFrameset() was"
					+ "supplied with an argument outside the supported range (1 to 24)");
		}
	}

	public long getHitRecoveryFrameset() {
		return hitRecoveryFrameset;
	}

	public void setHitRecoveryFrameset(long hitRecoveryFrameset) {
		if(hitRecoveryFrameset > 0 && hitRecoveryFrameset <= 24){
			this.hitRecoveryFrameset = hitRecoveryFrameset;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setHitRecoveryFrameset() was"
					+ "supplied with an argument outside the supported range (1 to 24)");
		}
	}

	public long getDeathFrameset() {
		return deathFrameset;
	}

	public void setDeathFrameset(long deathFrameset) {
		if(deathFrameset > 0 && deathFrameset <= 24){
			this.deathFrameset = deathFrameset;
			this.setChanged();
		}
	}

	public long getSecondAttackFrameset() {
		return secondAttackFrameset;
	}

	public void setSecondAttackFrameset(long secondAttackFrameset) {
		if(secondAttackFrameset > 0 && secondAttackFrameset <= 24){
			this.secondAttackFrameset = secondAttackFrameset;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setSecondAttackFrameset() was"
					+ "supplied with an argument outside the supported range (1 to 24)");
		}
	}

	public long getIdlePlaybackSpeed() {
		return idlePlaybackSpeed;
	}

	public void setIdlePlaybackSpeed(long idlePlaybackSpeed) {
		if(idlePlaybackSpeed >= 0 && idlePlaybackSpeed <= 10){
			this.idlePlaybackSpeed = idlePlaybackSpeed;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setIdlePlaybackSpeed() was"
					+ "supplied with an argument outside the supported range (0 to 10)");
		}
	}

	public long getWalkPlaybackSpeed() {
		return walkPlaybackSpeed;
	}

	public void setWalkPlaybackSpeed(long walkPlaybackSpeed) {
		if(walkPlaybackSpeed >= 0 && walkPlaybackSpeed <= 10){
			this.walkPlaybackSpeed = walkPlaybackSpeed;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setWalkPlaybackSpeed() was"
					+ "supplied with an argument outside the supported range (0 to 10)");
		}
	}

	public long getAttackPlaybackSpeed() {
		return attackPlaybackSpeed;
	}

	public void setAttackPlaybackSpeed(long attackPlaybackSpeed) {
		if(attackPlaybackSpeed >= 0 && attackPlaybackSpeed <= 10){
			this.attackPlaybackSpeed = attackPlaybackSpeed;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setAttackPlaybackSpeed() was"
					+ "supplied with an argument outside the supported range (0 to 10)");
		}
	}

	public long getHitRecoverySpeed() {
		return hitRecoverySpeed;
	}

	public void setHitRecoverySpeed(long hitRecoverySpeed) {
		if(hitRecoverySpeed >= 0 && hitRecoverySpeed <= 10){
			this.hitRecoverySpeed = hitRecoverySpeed;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setHitRecoverySpeed() was"
					+ "supplied with an argument outside the supported range (0 to 10)");
		}
	}

	public long getDeathPlaybackSpeed() {
		return deathPlaybackSpeed;
	}

	public void setDeathPlaybackSpeed(long deathPlaybackSpeed) {
		if(deathPlaybackSpeed >= 0 && deathPlaybackSpeed <= 10){
			this.deathPlaybackSpeed = deathPlaybackSpeed;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setDeathPlaybackSpeed() was"
					+ "supplied with an argument outside the supported range (0 to 10)");
		}
	}

	public long getSecondAttackSpeed() {
		return secondAttackSpeed;
	}

	public void setSecondAttackSpeed(long secondAttackSpeed) {
		if(secondAttackSpeed >= 0 && secondAttackSpeed <= 10){
			this.secondAttackSpeed = secondAttackSpeed;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setSecondAttackSpeed() was"
					+ "supplied with an argument outside the supported range (0 to 10)");
		}
	}

	public long getNamePointer() {
		return namePointer;
	}

	public void setNamePointer(long namePointer) {
		if(namePointer <= 1024 && namePointer >= 7018496){
			this.namePointer = namePointer;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setNamePointer() was"
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

	public int getMinDungeonLevel() {
		return minDungeonLevel;
	}

	public void setMinDungeonLevel(int minDungeonLevel) {
		if(minDungeonLevel >= 0 && minDungeonLevel <= 50){
			this.minDungeonLevel = minDungeonLevel;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setMinDungeonLevel() was"
					+ "supplied with an argument outside the supported range (0 to 50)");
		}
	}

	public int getMaxDungeonLevel() {
		return maxDungeonLevel;
	}

	public void setMaxDungeonLevel(int maxDungeonLevel) {
		if(maxDungeonLevel <= 0 && maxDungeonLevel <= 50){
			this.maxDungeonLevel = maxDungeonLevel;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setMaxDungeonLevel() was"
					+ "supplied with an argument outside the supported range (0 to 50)");
		}
	}

	public int getMonsterItemLevel() {
		return monsterItemLevel;
	}

	public void setMonsterItemLevel(int monsterItemLevel) {
		if(monsterItemLevel <= 1 && monsterItemLevel >= 30){
			this.monsterItemLevel = monsterItemLevel;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setMonsterItemLevel() was"
					+ "supplied with an argument outside the supported range (1 to 30)");
		}
	}

	public long getMinHitPoints() {
		return minHitPoints;
	}

	public void setMinHitPoints(long minHitPoints) {
		if(minHitPoints >= 1 && minHitPoints <= 9999){
			this.minHitPoints = minHitPoints;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setMinHitPoints() was"
					+ "supplied with an argument outside the supported range (1 to 9999)");
		}
	}

	public long getMaxHitPoints() {
		return maxHitPoints;
	}

	public void setMaxHitPoints(long maxHitPoints) {
		if(maxHitPoints >= 1 && maxHitPoints <= 9999){
			this.maxHitPoints = maxHitPoints;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setMaxHitPoints() was"
					+ "supplied with an argument outside the supported range (1 to 9999)");
		}
	}

	public int getAttackType1() {
		return attackType1;
	}

	//0 to 25
	public void setAttackType1(int attackType1) {
		if(attackType1 >= 0 && attackType1 <= 31){
			this.attackType1 = attackType1;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setAttackType1() was"
					+ "supplied with an argument outside the supported range (0 to 25)");
		}
	}

	public int getAttackType2() {
		return attackType2;
	}

	public void setAttackType2(int attackType2) {
		if(attackType2 >= 0 && attackType2 <= 0){
			this.attackType2 = attackType2;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setAttackType2() was"
					+ "supplied with an argument outside the supported range (0 to 0)");
		}
	}

	public int getAttackType3() {
		return attackType3;
	}

	public void setAttackType3(int attackType3) {
		if(attackType3 >= 0 && attackType3 <= 0){
			this.attackType3 = attackType3;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setAttackType3() was"
					+ "supplied with an argument outside the supported range (0 to 0)");
		}
	}

	public int getAttackType4() {
		return attackType4;
	}

	public void setAttackType4(int attackType4) {
		if(attackType4 >= 0 && attackType4 <= 0){
			this.attackType4 = attackType4;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setAttackType4() was"
					+ "supplied with an argument outside the supported range (0 to 0)");
		}
	}

	public int getAttackType5() {
		return attackType5;
	}

	public void setAttackType5(int attackType5) {
		if(attackType5 >= 0 && attackType5 <= 128){
			this.attackType5 = attackType5;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setAttackType5() was"
					+ "supplied with an argument outside the supported range (0 to 128)");
		}
	}

	public int getMonsterIntelligence() {
		return monsterIntelligence;
	}

	public void setMonsterIntelligence(int monsterIntelligence) {
		if(monsterIntelligence >=0 && monsterIntelligence <= 3){
			this.monsterIntelligence = monsterIntelligence;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setMonsterIntelligence() was"
					+ "supplied with an argument outside the supported range (0 to 3)");
		}
	}

	public int getAttackType7() {
		return attackType7;
	}

	public void setAttackType7(int attackType7) {
		if(attackType7 == 0){
			this.attackType7 = attackType7;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setAttackType7() was"
					+ "supplied with an argument outside the supported range (0 to 0)");
		}
	}

	public int getAttackType8() {
		return attackType8;
	}

	public void setAttackType8(int attackType8) {
		if(attackType8 == 0){
			this.attackType8 = attackType8;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setAttackType8() was"
					+ "supplied with an argument outside the supported range (0 to 0)");
		}
	}

	public int getSubType() {
		return subType;
	}

	public void setSubType(int subType) {
		if(subType >= 0  && subType <= 3){
			this.subType = subType;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setSubType() was"
					+ "supplied with an argument outside the supported range (0 to 3)");
		}
	}

	public int getMonsterPriChanceToHit() {
		return monsterPriChanceToHit;
	}

	public void setMonsterPriChanceToHit(int monsterPriChanceToHit) {
		if(monsterPriChanceToHit >= 0 && monsterPriChanceToHit <= 100){
			this.monsterPriChanceToHit = monsterPriChanceToHit;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setMonsterPriChanceToHit() was"
					+ "supplied with an argument outside the supported range (0 to 100)");
		}
	}

	public int getPriToHitFrame() {
		return priToHitFrame;
	}

	public void setPriToHitFrame(int priToHitFrame) {
		if(priToHitFrame >= 0 && priToHitFrame <= 25){
			this.priToHitFrame = priToHitFrame;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setPriToHitFrame() was"
					+ "supplied with an argument outside the supported range (0 to 25)");
		}
	}

	public int getPriMinAttackDamage() {
		return priMinAttackDamage;
	}

	public void setPriMinAttackDamage(int priMinAttackDamage) {
		if(priMinAttackDamage >= 0 && priMinAttackDamage <= 255){
			this.priMinAttackDamage = priMinAttackDamage;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setPriMinAttackDamage() was"
					+ "supplied with an argument outside the supported range (0 to 255)");
		}
	}

	public int getPriMaxAttackDamage() {
		return priMaxAttackDamage;
	}

	public void setPriMaxAttackDamage(int priMaxAttackDamage) {
		if(priMaxAttackDamage >= 0 && priMaxAttackDamage <= 255){
			this.priMaxAttackDamage = priMaxAttackDamage;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setPriMaxAttackDamage() was"
					+ "supplied with an argument outside the supported range (0 to 255)");
		}
	}

	public int getSecToHitChance() {
		return secToHitChance;
	}

	public void setSecToHitChance(int secToHitChance) {
		if(secToHitChance >= 0 && secToHitChance <= 100){
			this.secToHitChance = secToHitChance;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setSecToHitChance() was"
					+ "supplied with an argument outside the supported range (0 to 100)");
		}
	}

	public int getSecToHitFrame() {
		return secToHitFrame;
	}

	public void setSecToHitFrame(int secToHitFrame) {
		if(secToHitFrame >= 0 && secToHitFrame <= 25){
			this.secToHitFrame = secToHitFrame;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setSecToHitChance() was"
					+ "supplied with an argument outside the supported range (0 to 25)");
		}
	}

	public int getSecMinAttackDamage() {
		return secMinAttackDamage;
	}

	public void setSecMinAttackDamage(int secMinAttackDamage) {
		if(secMinAttackDamage >= 0 && secMinAttackDamage <= 255){
			this.secMinAttackDamage = secMinAttackDamage;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setSecMinAttackDamage() was"
					+ "supplied with an argument outside the supported range (0 to 255)");
		}
	}

	public int getSecMaxAttackDamage() {
		return secMaxAttackDamage;
	}

	public void setSecMaxAttackDamage(int secMaxAttackDamage) {
		if(secMaxAttackDamage >= 0 && secMaxAttackDamage <= 255){
			this.secMaxAttackDamage = secMaxAttackDamage;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setSecMaxAttackDamage() was"
					+ "supplied with an argument outside the supported range (0 to 255)");
		}
	}

	public int getMonsterAc() {
		return monsterAc;
	}

	public void setMonsterAc(int monsterAc) {
		if(monsterAc >= 0 & monsterAc <= 255){
			this.monsterAc = monsterAc;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setMonsterAc() was"
					+ "supplied with an argument outside the supported range (0 to 255)");
		}
	}

	public int getMonsterType() {
		return monsterType;
	}

	public void setMonsterType(int monsterType) {
		if(monsterType >= 0 && monsterType <= 3){
			this.monsterType = monsterType;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setMonsterType() was"
					+ "supplied with an argument outside the supported range (0 to 3)");
		}
	}

	public String getResistancesNormAndNightmare() {
		return resistancesNormAndNightmare;
	}

	public void setResistancesNormAndNightmare(
			String resistancesNormAndNightmare) {
		if(resistancesNormAndNightmare.matches("(0|1){16}")){ //if resistancesNormAndNightmare matches 16 x (0 or 1) [2 bytes displayed in binary]
			this.resistancesNormAndNightmare = resistancesNormAndNightmare;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setResistancesNormAndNightmare() was"
					+ "supplied with an incorrect argument");
		}
	}

	public String getResistancesHell() {
		return resistancesHell;
	}

	public void setResistancesHell(String resistancesHell) {
		if(resistancesHell.matches("(0|1){16}")){
			this.resistancesHell = resistancesHell;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setResistancesNormAndNightmare() was"
					+ "supplied with an incorrect argument");
		}
	}

	public int getItemDropSpecials() {
		return itemDropSpecials;
	}

	public void setItemDropSpecials(int itemDropSpecials) {
		if(itemDropSpecials >=0 && itemDropSpecials <= 65536){
			this.itemDropSpecials = itemDropSpecials;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setItemDropSpecials() was"
					+ "supplied with an argument outside the supported range (0 to 65536)");
		}
	}

	public int getMonsterSelectionOutline() {
		return monsterSelectionOutline;
	}

	public void setMonsterSelectionOutline(int monsterSelectionOutline) {
		if(monsterSelectionOutline >= 0 && monsterSelectionOutline <= 24){
			this.monsterSelectionOutline = monsterSelectionOutline;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setMonsterSelectionOutline() was"
					+ "supplied with an argument outside the supported range (0 to 24)");
		}
	}

	public long getExperiencePoints() {
		return experiencePoints;
	}

	public void setExperiencePoints(long experiencePoints) {
		if(experiencePoints >= 0 && experiencePoints <= 99999){
			this.experiencePoints = experiencePoints;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setExperiencePoints() was"
					+ "supplied with an argument outside the supported range (0 to 99999)");
		}
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		if(enabled <= 0 && enabled >= 1){
			this.enabled = enabled;
			this.setChanged();
		} else {
			System.err.println("Error: BaseMonster's setEnabled() was"
					+ "supplied with an argument outside the supported range (0 to 1)");
		}
	}

	public boolean isChanged() {
		return changed;
	}

	public void setChanged() {
		this.changed = true;
	}

	public byte[] getMonsterBytesOrig() {
		return monsterBytesOrig;
	}

	public void setMonsterBytesOrig(byte[] monsterBytesOrig) {
		this.monsterBytesOrig = monsterBytesOrig;
	}

}
