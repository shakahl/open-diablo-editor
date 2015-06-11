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
	
	/*
	0 	
	1 	Attacking frameset
	2 	Walking frameset in dungeon
	3 	Blocking speed
	4 	Death frameset
	5 	Frameset for magic casting
	6 	Hit recovery speed
	7 	Idle frameset in town
	8 	Walking frameset in town
	9 	Single handed weapon attacking speed 
	10 	Spell casting speed
	*/
	
	public Character(){
		
	}
	
	public void printCharacter() {
		System.out.println("Class: " + className);
		System.out.println("STR: " + initStrength + "--" + maxStrength);
		System.out.println("MAG: " + initMagic + "--" + maxMagic);
		System.out.println("DEX: " + initDexterity + "--" + maxDexterity);
		System.out.println("VIT: " + initVitality + "--" + maxVitality);
		System.out.println("Blocking bonus: " + blockingBonus);
		System.out.println("Dungeon idle frameset: " + dungeonIdleFrameset);
		System.out.println("Attacking frameset: " + attackingFrameset);
		System.out.println("Dungeon walk frameset: " + dungeonWalkFrameset);
		System.out.println("Block speed: " + blockSpeed + " (" + (0.05 * blockSpeed) + "secs)");
		System.out.println("Death frameset: " + deathFrameset);
		System.out.println("Casting frameset: " + castingFrameset);
		System.out.println("Hit recovery speed: " + hitRecoverySpeed + " (" + (0.05 * hitRecoverySpeed) + "secs)");
		System.out.println("Town idle frameset: " + townIdleFrameset);
		System.out.println("Town walk frameset: " + townWalkFrameset);
		System.out.println("One handed attack speed: " + oneHandedAttackSpeed);
		System.out.println("Casting speed: " + castingSpeed + " (" + (0.05 * castingSpeed) + "secs)");
		System.out.println();
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
