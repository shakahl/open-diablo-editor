package uk.me.karlsen.ode;

public class Character {

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
		System.out.println(
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

	long getInitStrength() {
		return initStrength;
	}

	void setInitStrength(long initStrength) {
		this.initStrength = initStrength;
	}

	long getMaxStrength() {
		return maxStrength;
	}

	void setMaxStrength(long maxStrength) {
		this.maxStrength = maxStrength;
	}

	long getInitMagic() {
		return initMagic;
	}

	void setInitMagic(long initMagic) {
		this.initMagic = initMagic;
	}

	long getMaxMagic() {
		return maxMagic;
	}

	void setMaxMagic(long maxMagic) {
		this.maxMagic = maxMagic;
	}

	long getInitDexterity() {
		return initDexterity;
	}

	void setInitDexterity(long initDexterity) {
		this.initDexterity = initDexterity;
	}

	long getMaxDexterity() {
		return maxDexterity;
	}

	void setMaxDexterity(long maxDexterity) {
		this.maxDexterity = maxDexterity;
	}

	long getInitVitality() {
		return initVitality;
	}

	void setInitVitality(long initVitality) {
		this.initVitality = initVitality;
	}

	long getMaxVitality() {
		return maxVitality;
	}

	void setMaxVitality(long maxVitality) {
		this.maxVitality = maxVitality;
	}

	String getClassName() {
		return className;
	}

	void setClassName(String name) {
		this.className = name;
	}

	long getBlockingBonus() {
		return blockingBonus;
	}

	void setBlockingBonus(long blockingBonus) {
		this.blockingBonus = blockingBonus;
	}

	int getDungeonIdleFrameset() {
		return dungeonIdleFrameset;
	}

	void setDungeonIdleFrameset(int dungeonIdleFrameset) {
		this.dungeonIdleFrameset = dungeonIdleFrameset;
	}

	int getAttackingFrameset() {
		return attackingFrameset;
	}

	void setAttackingFrameset(int attackingFrameset) {
		this.attackingFrameset = attackingFrameset;
	}

	int getDungeonWalkFrameset() {
		return dungeonWalkFrameset;
	}

	void setDungeonWalkFrameset(int dungeonWalkFrameset) {
		this.dungeonWalkFrameset = dungeonWalkFrameset;
	}

	int getBlockSpeed() {
		return blockSpeed;
	}

	void setBlockSpeed(int blockSpeed) {
		this.blockSpeed = blockSpeed;
	}

	int getDeathFrameset() {
		return deathFrameset;
	}

	void setDeathFrameset(int deathFrameset) {
		this.deathFrameset = deathFrameset;
	}

	int getCastingFrameset() {
		return castingFrameset;
	}

	void setCastingFrameset(int castingFrameset) {
		this.castingFrameset = castingFrameset;
	}

	int getHitRecoverySpeed() {
		return hitRecoverySpeed;
	}

	void setHitRecoverySpeed(int hitRecoverySpeed) {
		this.hitRecoverySpeed = hitRecoverySpeed;
	}

	int getTownIdleFrameset() {
		return townIdleFrameset;
	}

	void setTownIdleFrameset(int townIdleFrameset) {
		this.townIdleFrameset = townIdleFrameset;
	}

	int getTownWalkFrameset() {
		return townWalkFrameset;
	}

	void setTownWalkFrameset(int townWalkFrameset) {
		this.townWalkFrameset = townWalkFrameset;
	}

	int getOneHandedAttackSpeed() {
		return oneHandedAttackSpeed;
	}

	void setOneHandedAttackSpeed(int oneHandedAttackSpeed) {
		this.oneHandedAttackSpeed = oneHandedAttackSpeed;
	}

	int getCastingSpeed() {
		return castingSpeed;
	}

	void setCastingSpeed(int castingSpeed) {
		this.castingSpeed = castingSpeed;
	}

}
