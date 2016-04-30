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
	
	public void writeByte(byte b, long pos){
		try {
			raf.seek(pos);
			raf.write(b);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
}
