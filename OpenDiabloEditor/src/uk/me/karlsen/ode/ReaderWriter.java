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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			
		}
			File f = new File("input/Diablo.exe");
			File newFile = this.createNewFile(f);
			try {
				raf = new RandomAccessFile(newFile, "rw");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	private File createNewFile(File originalFile) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(originalFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File newFile = new File("output/ODEDiablo.exe");
		try {
			newFile.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(newFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileChannel fisChannel = fis.getChannel();
		FileChannel fosChannel = fos.getChannel();
		try {
			fosChannel.transferFrom(fisChannel, 0, fisChannel.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fisChannel.close();
			fosChannel.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newFile;
	}

	public void seek(long position){
		try {
			raf.seek(position);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int read(){
		int read = -1;
		try {
			read = raf.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return read;
	}
	
	public byte readByte(){
		byte read = -1;
		try {
			read = raf.readByte();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return read;
	}
	
	public byte[] readBytes(int numBytes){
		byte[] bytes = new byte[numBytes];
		try {
			raf.read(bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bytes;
	}
	
	public void writeBytes(byte[] bytes, long pos){
		try {
			raf.seek(pos);
			raf.write(bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeByte(byte byteValue, long pos){
		try {
			raf.seek(pos);
			raf.writeByte(byteValue);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public long convertThreeBytesToOffset(int... fourBytes){
		long value = -1;
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
		value = Long.parseLong(str, 16);
		value = value - 4203008l;
		return value;
	}
	
	public long convertFourBytesToNumber(int... bytes){
		long value = -1;
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
		value = Long.parseLong(str, 16);
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
	
	public int convertUnsignedByteToInt(byte b){
		return (int) b & 0xFF;
	}
}
