package uk.me.karlsen.ode.test;

import java.util.Arrays;

import uk.me.karlsen.ode.ReaderWriter;
import uk.me.karlsen.ode.stores.CharacterStore;
import junit.framework.TestCase;

public class TestCharacterStore extends TestCase {
	
	//TODO -- check these 4 arrays in a hex editor (don't rely on read-in methods)
	protected byte[] origInitStatBytes = {30, 0, 0, 0, 20, 0, 0, 0, 15, 0, 0, 0, 10, 0, 0, 0, 15, 0, 0, 0, 35, 0, 0, 0, 20, 0, 0, 0, 30, 0, 0, 0, 15, 0, 0, 0, 25, 0, 0, 0, 20, 0, 0, 0, 20, 0, 0, 0};
	
	protected byte[] origMaxStatBytes = {-6, 0, 0, 0, 50, 0, 0, 0, 60, 0, 0, 0, 100, 0, 0, 0, 55, 0, 0, 0, 70, 0, 0, 0, -6, 0, 0, 0, 80, 0, 0, 0, 45, 0, 0, 0, -6, 0, 0, 0, 85, 0, 0, 0, 80, 0, 0, 0};
	
	protected byte[] origBlockingBonusBytes = {30, 0, 0, 0, 20, 0, 0, 0, 10, 0, 0, 0};
	
	protected byte[] origBonusAndFramesetBytes = {10, 16, 8, 2, 20, 20, 6, 20, 8, 9, 14, 8, 18, 8, 4, 20, 16, 7, 20, 8, 10, 12, 8, 16, 8, 6, 20, 12, 8, 20, 8, 12, 8};
	
	protected CharacterStore cs;
	
	protected void setUp(){
		ReaderWriter rw = new ReaderWriter(false);
		cs = new CharacterStore(rw);
	}
	
	public void testGetInitStatBytes(){
		byte[] retrievedInitStatBytes = cs.getInitStatBytes();
		String retrievedInitStatString = Arrays.toString(retrievedInitStatBytes);
		String origInitStatString = Arrays.toString(origInitStatBytes);
		assertEquals(origInitStatString, retrievedInitStatString);
	}
	
	public void testGetMaxStatBytes(){
		byte[] retrievedMaxStatBytes = cs.getMaxStatBytes();
		String retrievedMaxStatString = Arrays.toString(retrievedMaxStatBytes);
		String origMaxStatString = Arrays.toString(retrievedMaxStatBytes);
		assertEquals(origMaxStatString, retrievedMaxStatString);
	}
	
	public void testGetBlockingBonusBytes(){
		byte[] retrievedBlockingBonusBytes = cs.getBlockingBonusBytes();
		String retrievedBlockingBonusString = Arrays.toString(retrievedBlockingBonusBytes);
		String origBlockingBonusString = Arrays.toString(origBlockingBonusBytes);
		assertEquals(origBlockingBonusString, retrievedBlockingBonusString);
	}
	
	public void testGetBonusesAndFramesetBytes(){
		byte[] retrievedBonusAndFramesetBytes = cs.getBonusesAndFramesetBytes();
		String retrievedBonusAndFramesetString = Arrays.toString(retrievedBonusAndFramesetBytes);
		String origBonusAndFramesetString = Arrays.toString(origBonusAndFramesetBytes);
		assertEquals(origBonusAndFramesetString, retrievedBonusAndFramesetString);
	}
}
