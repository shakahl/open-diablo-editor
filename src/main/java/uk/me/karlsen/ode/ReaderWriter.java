package uk.me.karlsen.ode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.Date;

public class ReaderWriter {

	RandomAccessFile raf = null;

	public ReaderWriter(String path, boolean readOnly){
		File f = new File(path);
		try {
			if(readOnly) {
				raf = new RandomAccessFile(f, "r");
			} else {
				raf = new RandomAccessFile(f, "rw");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public ReaderWriter(String origPath, String newPath){
		File f = new File(origPath);
		File newFile = this.createNewFile(f, newPath);
		try {
			raf = new RandomAccessFile(newFile, "rw");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	private File createNewFile(File originalFile, String newPath) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(originalFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		File newFile = new File(newPath);
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
		System.out.println("Writing bytes to " + pos);
		try {
			raf.seek(pos);
			raf.write(bytes);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public void writeByte(byte b, long pos){
		System.out.println("Writing byte to " + pos);
		try {
			raf.seek(pos);
			raf.write(b);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
}
