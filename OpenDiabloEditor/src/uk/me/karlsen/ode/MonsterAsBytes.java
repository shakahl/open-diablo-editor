package uk.me.karlsen.ode;

public class MonsterAsBytes {

	byte[] mainBytes;
	byte enabledByte;

	public MonsterAsBytes(byte[] mainBytes, byte enabledByte){
		this.mainBytes = mainBytes;
		this.enabledByte = enabledByte;
	}

	public byte[] getMainBytes(){
		return mainBytes;
	}

	public byte getEnabledByte(){
		return enabledByte;
	}
}
