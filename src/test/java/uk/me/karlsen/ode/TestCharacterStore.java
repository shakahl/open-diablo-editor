package uk.me.karlsen.ode;

import java.util.Arrays;

import org.junit.Test;

import uk.me.karlsen.ode.ReaderWriter;
import uk.me.karlsen.ode.TomeOfKnowledge;
import uk.me.karlsen.ode.stores.CharacterStore;
import junit.framework.TestCase;

public class TestCharacterStore extends TestCase {
	
	protected byte[] origInitStatBytes;
	
	protected byte[] origMaxStatBytes;
	
	protected byte[] origBlockingBonusBytes;
	
	protected byte[] origBonusAndFramesetBytes;
	
	protected CharacterStore cs;
	
	public void readInAllCharacterBytes(ReaderWriter rw) {
		
		long pos = TomeOfKnowledge.MIN_STATS_OFFSET;
		rw.seek(pos);
		origInitStatBytes = new byte[TomeOfKnowledge.MIN_STATS_LENGTH_IN_BYTES];
		for(int j = 0; j < TomeOfKnowledge.MIN_STATS_LENGTH_IN_BYTES; j++){
			origInitStatBytes[j] = rw.readByte();
			pos++;
			rw.seek(pos);
		}

		pos = TomeOfKnowledge.MAX_STATS_OFFSET;
		rw.seek(pos);
		origMaxStatBytes = new byte[TomeOfKnowledge.MAX_STATS_LENGTH_IN_BYTES];
		for(int j = 0; j < TomeOfKnowledge.MAX_STATS_LENGTH_IN_BYTES; j++){
			origMaxStatBytes[j] = rw.readByte();
			pos++;
			rw.seek(pos);
		}

		pos = TomeOfKnowledge.BLOCKING_BONUSES_OFFSET;
		rw.seek(pos);
		origBlockingBonusBytes = new byte[TomeOfKnowledge.BLOCKING_BONUSES_LENGTH_IN_BYTES];
		for(int j = 0; j < TomeOfKnowledge.BLOCKING_BONUSES_LENGTH_IN_BYTES; j++){
			origBlockingBonusBytes[j] = rw.readByte();
			pos++;
			rw.seek(pos);
		}

		pos = TomeOfKnowledge.BONUSES_AND_FRAMESETS_OFFSET;
		rw.seek(pos);
		origBonusAndFramesetBytes = new byte[TomeOfKnowledge.BONUSES_AND_FRAMESETS_LENGTH_IN_BYTES];
		for(int j = 0; j < TomeOfKnowledge.BONUSES_AND_FRAMESETS_LENGTH_IN_BYTES; j++){
			origBonusAndFramesetBytes[j] = rw.readByte();
			pos++;
			rw.seek(pos);
		}
	}
		
	@Override
	protected void setUp(){
		ReaderWriter rw = new ReaderWriter("input/Diablo.exe");
		cs = new CharacterStore(rw);
		readInAllCharacterBytes(rw);
	}
	
	@Test
	public void testGetInitStatBytes(){
		byte[] retrievedInitStatBytes = cs.getInitStatBytes();
		String retrievedInitStatString = Arrays.toString(retrievedInitStatBytes);
		String origInitStatString = Arrays.toString(origInitStatBytes);
		assertEquals(origInitStatString, retrievedInitStatString);
	}
	
	@Test
	public void testGetMaxStatBytes(){
		byte[] retrievedMaxStatBytes = cs.getMaxStatBytes();
		String retrievedMaxStatString = Arrays.toString(retrievedMaxStatBytes);
		String origMaxStatString = Arrays.toString(retrievedMaxStatBytes);
		assertEquals(origMaxStatString, retrievedMaxStatString);
	}
	
	@Test
	public void testGetBlockingBonusBytes(){
		byte[] retrievedBlockingBonusBytes = cs.getBlockingBonusBytes();
		String retrievedBlockingBonusString = Arrays.toString(retrievedBlockingBonusBytes);
		String origBlockingBonusString = Arrays.toString(origBlockingBonusBytes);
		assertEquals(origBlockingBonusString, retrievedBlockingBonusString);
	}
	
	@Test
	public void testGetBonusesAndFramesetBytes(){
		byte[] retrievedBonusAndFramesetBytes = cs.getBonusesAndFramesetBytes();
		String retrievedBonusAndFramesetString = Arrays.toString(retrievedBonusAndFramesetBytes);
		String origBonusAndFramesetString = Arrays.toString(origBonusAndFramesetBytes);
		assertEquals(origBonusAndFramesetString, retrievedBonusAndFramesetString);
	}
}
