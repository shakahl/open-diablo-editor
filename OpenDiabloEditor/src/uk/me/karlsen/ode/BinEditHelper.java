package uk.me.karlsen.ode;

public class BinEditHelper {

	public BinEditHelper(){

	}

	public String getNameUsingPointer(long pointer){
		String name = "Unnamed";
		if(pointer > 0){
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
			
			if(endByte == -1){
				name = "Could Not Retrieve Name String";
			} else {
				name = new String(bytes, 0, endByte);
			}
		}
		return name;
	}

	public void setLongAsFourBytes(long numberToConvert, byte[] destinationArray, int firstDestinationByte){
		byte[] bytesToSet = new byte[4];
		bytesToSet[0] = (byte)(numberToConvert >>>  0);
		bytesToSet[1] = (byte)(numberToConvert >>>  8);
		bytesToSet[2] = (byte)(numberToConvert >>> 16);
		bytesToSet[3] = (byte)(numberToConvert >>> 24);
		System.arraycopy(bytesToSet, 0, destinationArray, firstDestinationByte, bytesToSet.length);
	}
	
	public void setIntAsTwoBytes(int numberToConvert, byte[] destinationArray, int firstDestinationByte){
		byte[] bytesToSet = new byte[2];
		bytesToSet[0] = (byte)(numberToConvert >>>  0);
		bytesToSet[1] = (byte)(numberToConvert >>>  8);
		System.arraycopy(bytesToSet, 0, destinationArray, firstDestinationByte, bytesToSet.length);
	}
	
	public void setPointerAsFourBytes(long numberToConvert, byte[] destinationArray, int firstDestinationByte){
		long numberToConvertModified = 0;
		if(numberToConvert != 0){
			numberToConvertModified = numberToConvert + TomeOfKnowledge.DIABLO_POINTERS_OFFSET;
		}
		byte[] bytesToSet = new byte[4];
		bytesToSet[0] = (byte)(numberToConvertModified >>>  0);
		bytesToSet[1] = (byte)(numberToConvertModified >>>  8);
		bytesToSet[2] = (byte)(numberToConvertModified >>> 16);
		bytesToSet[3] = (byte)(numberToConvertModified >>> 24);
		System.arraycopy(bytesToSet, 0, destinationArray, firstDestinationByte, bytesToSet.length);
	}

	//FIXME -- this should not exist
	long convertThreeBytesToOffset(int... fourBytes){
		String byte0 = Integer.toHexString(fourBytes[3] & 0xFF);
		String byte1 = Integer.toHexString(fourBytes[2] & 0xFF);
		String byte2 = Integer.toHexString(fourBytes[1] & 0xFF);
		//String byte3 = Integer.toHexString(fourBytes[0]);
		if(byte0.length() < 2){
			byte0 = "0" + byte0;
		}
		if(byte1.length() < 2){
			byte1 = "0" + byte1;
		}
		if(byte2.length() < 2){
			byte2 = "0" + byte2;
		}
		//if(byte3.length() < 2){
		//	byte3 = "0" + byte3;
		//}
		String str = byte0 + byte1 + byte2; //+ byte3;
		long value = Long.parseLong(str, 16) - TomeOfKnowledge.DIABLO_POINTERS_OFFSET;
		return value;
	}
	
	private long convertFourBytesToNumber(int... bytes){
		String byte0 = Integer.toHexString(bytes[3] & 0xFF);
		String byte1 = Integer.toHexString(bytes[2] & 0xFF);
		String byte2 = Integer.toHexString(bytes[1] & 0xFF);
		String byte3 = Integer.toHexString(bytes[0] & 0xFF);
		if(byte0.length() < 2){
			byte0 = "0" + byte0;
		}
		if(byte1.length() < 2){
			byte1 = "0" + byte1;
		}
		if(byte2.length() < 2){
			byte2 = "0" + byte2;
		}
		if(byte3.length() < 2){
			byte3 = "0" + byte3;
		}
		String str = byte0 + byte1 + byte2 + byte3;
		long value = Long.parseLong(str, 16);
		return value;
	}
	
	/**
	 * Converts four bytes on the specified array to a long.
	 * The particular bytes in question are determined by the offset
	 * (from the start of the array).
	 * 
	 * @param holdingArray : the array to get the four bytes from
	 * @param offset : the offset of the bytes on the array
	 * @return a long value converted from the four bytes
	 */
	public long convertFourBytesToNumber(byte[] holdingArray, int offset){
		StringBuilder sb = new StringBuilder();
		for(int i = 3; i > -1; i--){
			String byteValue = Integer.toHexString(holdingArray[offset+i] & 0xFF);
			if(byteValue.length() == 1){
				sb.append(0);
			}
			sb.append(byteValue);
		}
		String str = sb.toString();
		long value = Long.parseLong(str, 16);
		return value;
	}
	
	public int convertTwoBytesToInt(int... bytes){
		int value = -1;
		String byte0 = Integer.toHexString(bytes[1] & 0xFF);
		String byte1 = Integer.toHexString(bytes[0] & 0xFF);
		if(byte0.length() < 2){
			byte0 = "0" + byte0;
		}
		if(byte1.length() < 2){
			byte1 = "0" + byte1;
		}
		String str = byte0 + byte1;
		value = Integer.parseInt(str, 16);
		return value;
	}
	
	public long convertFourBytesToOffset(byte[] holdingArray, int offset){
		long value = this.convertFourBytesToNumber(holdingArray, offset);
		if(value != 0){
			value = value - TomeOfKnowledge.DIABLO_POINTERS_OFFSET;			
		}
		return value;
	}
	
	private long convertFourBytesToOffset(int... fourBytes){
		long value = -1;
		String byte0 = Integer.toHexString(fourBytes[3] & 0xFF);
		String byte1 = Integer.toHexString(fourBytes[2] & 0xFF);
		String byte2 = Integer.toHexString(fourBytes[1] & 0xFF);
		String byte3 = Integer.toHexString(fourBytes[0] & 0xFF);
		if(byte0.length() < 2){
			byte0 = "0" + byte0;
		}
		if(byte1.length() < 2){
			byte1 = "0" + byte1;
		}
		if(byte2.length() < 2){
			byte2 = "0" + byte2;
		}
		if(byte3.length() < 2){
			byte3 = "0" + byte3;
		}
		String str = byte0 + byte1 + byte2 + byte3;
		value = Long.parseLong(str, 16);
		value = value - TomeOfKnowledge.DIABLO_POINTERS_OFFSET;
		return value;
	}
	
	public int convertUnsignedByteToInt(byte b){
		return (int) b & 0xFF;
	}
	
	public String convertByteToBinaryString(byte b){
		int i = this.convertUnsignedByteToInt(b);
		String s = Integer.toBinaryString(i);
		return String.format("%8s", s).replace(' ', '0');
	}
}
