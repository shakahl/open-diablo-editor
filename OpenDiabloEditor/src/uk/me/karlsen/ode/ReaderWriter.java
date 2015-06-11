package uk.me.karlsen.ode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class ReaderWriter {

	RandomAccessFile raf = null;

	public ReaderWriter(boolean readOnly){
		if(readOnly){
			File f = new File("input/Diablo.exe");
			try {
				raf = new RandomAccessFile(f, "r");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.exit(-1);
			}
		} else {

		}
			File f = new File("input/Diablo.exe");
			File newFile = this.createNewFile(f);
			try {
				raf = new RandomAccessFile(newFile, "rw");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.exit(-1);
			}
	}

	private File createNewFile(File originalFile) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(originalFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		File newFile = new File("output/ODEDiablo.exe");
		try {
			newFile.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
			System.exit(-1);
		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(newFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		FileChannel fisChannel = fis.getChannel();
		FileChannel fosChannel = fos.getChannel();
		try {
			fosChannel.transferFrom(fisChannel, 0, fisChannel.size());
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		try {
			fisChannel.close();
			fosChannel.close();
			fis.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return newFile;
	}

	public void seek(long position){
		try {
			raf.seek(position);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public int read(){
		int read = -1;
		try {
			read = raf.read();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return read;
	}

	public byte readByte(){
		byte read = -1;
		try {
			read = raf.readByte();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return read;
	}

	public byte[] readBytes(int numBytes){
		byte[] bytes = new byte[numBytes];
		try {
			raf.read(bytes);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return bytes;
	}

	public void writeBytes(byte[] bytes, long pos){
		try {
			raf.seek(pos);
			raf.write(bytes);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/*TODO: Transferred to BinEditHelper in my edit -- confirm no conflict with mewmew's edit...
	public void writeOneByteMultipleTimes(byte oneByte, long pos, int numBytes){
		try {
			raf.seek(pos);
			long p = pos;
			for(int i = 0; i < numBytes; i++){
				raf.write(oneByte);
				p++;
				raf.seek(p);
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public void writeByte(byte byteValue, long pos){
		try {
			raf.seek(pos);
			raf.writeByte(byteValue);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	//FIXME -- this should not exist
	public long convertThreeBytesToOffset(int... fourBytes){
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

	//FIXME -- move to BinEditHelper
	public long convertFourBytesToNumber(int... bytes){
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

	//FIXME -- move to BinEditHelper
	public long convertFourBytesToNumber(byte[] holdingArray, int offset){
		String byte0 = Integer.toHexString(holdingArray[offset+3] & 0xFF);
		String byte1 = Integer.toHexString(holdingArray[offset+2] & 0xFF);
		String byte2 = Integer.toHexString(holdingArray[offset+1] & 0xFF);
		String byte3 = Integer.toHexString(holdingArray[offset] & 0xFF);
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

	//FIXME -- move to BinEditHelper
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

	//FIXME -- move to BinEditHelper
	public long convertFourBytesToOffset(int... fourBytes){
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

	//FIXME -- move to BinEditHelper
	public int convertUnsignedByteToInt(byte b){
		return (int) b & 0xFF;
	}
	*/
}
