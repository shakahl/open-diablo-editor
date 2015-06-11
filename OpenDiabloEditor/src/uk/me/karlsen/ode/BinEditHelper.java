package uk.me.karlsen.ode;

import java.util.Arrays;

public class BinEditHelper {

	public BinEditHelper(){

	}

	public String getNameUsingPointer(long pointer){
		ReaderWriter rwTemp = new ReaderWriter(true);
		rwTemp.seek(pointer);
		byte[] bytes = rwTemp.readBytes(40);
		int endByte = -1;
		for(int i = 0; i < bytes.length; i++){
			if(bytes[i] == 0){
				endByte = i;
				break;
			}
		}
		String name;
		if(endByte == -1){
			name = "nullString";
		} else {
			name = new String(bytes, 0, endByte);
		}
		return name;
	}

	//TODO -- replace/simplify much content from the get<ObjectName>AsBytes methods using this method
	public void setLongAsFourBytes(long numberToConvert, byte[] destinationArray, int firstDestinationByte){
		byte[] bytesToSet = new byte[4];
		bytesToSet[0] = (byte)(numberToConvert >>>  0);
		bytesToSet[1] = (byte)(numberToConvert >>>  8);
		bytesToSet[2] = (byte)(numberToConvert >>> 16);
		bytesToSet[3] = (byte)(numberToConvert >>> 24);
		System.arraycopy(bytesToSet, 0, destinationArray, firstDestinationByte, bytesToSet.length);
	}
}
