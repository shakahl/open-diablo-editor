package uk.me.karlsen.ode.types;

import java.util.logging.Logger;

public class Character {
	
	private final static Logger LOGGER = Logger.getLogger(Character.class.getName());

	private String className;
	private long initStrength;
	private long maxStrength;
	private long initMagic;
	private long maxMagic;
	private long initDexterity;
	private long maxDexterity;
	private long initVitality;
	private long maxVitality;
	private long blockingBonus;
	private int dungeonIdleFrameset;
	private int attackingFrameset;
	private int dungeonWalkFrameset;
	private int blockSpeed; //NOTE: # framesets must not be < speed value on any speed
	private int deathFrameset;
	private int castingFrameset;
	private int hitRecoverySpeed;
	private int townIdleFrameset;
	private int townWalkFrameset;
	private int oneHandedAttackSpeed;
	private int castingSpeed;

	public Character(){}

	public void printCharacter() {
		LOGGER.info(
			"Class: " + className + "\n" +
			"STR: " + initStrength + "--" + maxStrength + "\n" +
			"MAG: " + initMagic + "--" + maxMagic + "\n" +
			"DEX: " + initDexterity + "--" + maxDexterity + "\n" +
			"VIT: " + initVitality + "--" + maxVitality + "\n" +
			"Blocking bonus: " + blockingBonus + "\n" +
			"Dungeon idle frameset: " + dungeonIdleFrameset + "\n" +
			"Attacking frameset: " + attackingFrameset + "\n" +
			"Dungeon walk frameset: " + dungeonWalkFrameset + "\n" +
			"Block speed: " + blockSpeed + " (" + (0.05 * blockSpeed) + "secs)" + "\n" +
			"Death frameset: " + deathFrameset + "\n" +
			"Casting frameset: " + castingFrameset + "\n" +
			"Hit recovery speed: " + hitRecoverySpeed + " (" + (0.05 * hitRecoverySpeed) + "secs)" + "\n" +
			"Town idle frameset: " + townIdleFrameset + "\n" +
			"Town walk frameset: " + townWalkFrameset + "\n" +
			"One handed attack speed: " + oneHandedAttackSpeed + "\n" +
			"Casting speed: " + castingSpeed + " (" + (0.05 * castingSpeed) + "secs)" + "\n"
		);
	}

	public long getInitStrength() {
		return initStrength;
	}

	public void setInitStrength(long initStrength) {
		this.initStrength = initStrength;
	}

	public long getMaxStrength() {
		return maxStrength;
	}

	public void setMaxStrength(long maxStrength) {
		this.maxStrength = maxStrength;
	}

	public long getInitMagic() {
		return initMagic;
	}

	public void setInitMagic(long initMagic) {
		this.initMagic = initMagic;
	}

	public long getMaxMagic() {
		return maxMagic;
	}

	public void setMaxMagic(long maxMagic) {
		this.maxMagic = maxMagic;
	}

	public long getInitDexterity() {
		return initDexterity;
	}

	public void setInitDexterity(long initDexterity) {
		this.initDexterity = initDexterity;
	}

	public long getMaxDexterity() {
		return maxDexterity;
	}

	public void setMaxDexterity(long maxDexterity) {
		this.maxDexterity = maxDexterity;
	}

	public long getInitVitality() {
		return initVitality;
	}

	public void setInitVitality(long initVitality) {
		this.initVitality = initVitality;
	}

	public long getMaxVitality() {
		return maxVitality;
	}

	public void setMaxVitality(long maxVitality) {
		this.maxVitality = maxVitality;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String name) {
		this.className = name;
	}

	public long getBlockingBonus() {
		return blockingBonus;
	}

	public void setBlockingBonus(long blockingBonus) {
		this.blockingBonus = blockingBonus;
	}

	public int getDungeonIdleFrameset() {
		return dungeonIdleFrameset;
	}

	public void setDungeonIdleFrameset(int dungeonIdleFrameset) {
		this.dungeonIdleFrameset = dungeonIdleFrameset;
	}

	public int getAttackingFrameset() {
		return attackingFrameset;
	}

	public void setAttackingFrameset(int attackingFrameset) {
		this.attackingFrameset = attackingFrameset;
	}

	public int getDungeonWalkFrameset() {
		return dungeonWalkFrameset;
	}

	public void setDungeonWalkFrameset(int dungeonWalkFrameset) {
		this.dungeonWalkFrameset = dungeonWalkFrameset;
	}

	public int getBlockSpeed() {
		return blockSpeed;
	}

	public void setBlockSpeed(int blockSpeed) {
		this.blockSpeed = blockSpeed;
	}

	public int getDeathFrameset() {
		return deathFrameset;
	}

	public void setDeathFrameset(int deathFrameset) {
		this.deathFrameset = deathFrameset;
	}

	public int getCastingFrameset() {
		return castingFrameset;
	}

	public void setCastingFrameset(int castingFrameset) {
		this.castingFrameset = castingFrameset;
	}

	public int getHitRecoverySpeed() {
		return hitRecoverySpeed;
	}

	public void setHitRecoverySpeed(int hitRecoverySpeed) {
		this.hitRecoverySpeed = hitRecoverySpeed;
	}

	public int getTownIdleFrameset() {
		return townIdleFrameset;
	}

	public void setTownIdleFrameset(int townIdleFrameset) {
		this.townIdleFrameset = townIdleFrameset;
	}

	public int getTownWalkFrameset() {
		return townWalkFrameset;
	}

	public void setTownWalkFrameset(int townWalkFrameset) {
		this.townWalkFrameset = townWalkFrameset;
	}

	public int getOneHandedAttackSpeed() {
		return oneHandedAttackSpeed;
	}

	public void setOneHandedAttackSpeed(int oneHandedAttackSpeed) {
		this.oneHandedAttackSpeed = oneHandedAttackSpeed;
	}

	public int getCastingSpeed() {
		return castingSpeed;
	}

	public void setCastingSpeed(int castingSpeed) {
		this.castingSpeed = castingSpeed;
	}

}
