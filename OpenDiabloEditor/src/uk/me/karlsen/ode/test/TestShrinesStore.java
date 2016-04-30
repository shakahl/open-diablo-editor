package uk.me.karlsen.ode.test;

import java.util.Arrays;

import org.junit.Test;

import uk.me.karlsen.ode.ReaderWriter;
import uk.me.karlsen.ode.TomeOfKnowledge;
import uk.me.karlsen.ode.stores.ShrinesStore;
import uk.me.karlsen.ode.types.Shrine;
import uk.me.karlsen.ode.utils.BinEditHelper;
import junit.framework.TestCase;

public class TestShrinesStore extends TestCase {

	protected byte[] origShrinePointerBytes;
	protected byte[] origMinShrineLevelBytes;
	protected byte[] origMaxShrineLevelBytes;
	protected byte[] origGameTypesInWhichPresentBytes;
	
	protected ShrinesStore ss;
	
	public void readInAllShrineBytes(ReaderWriter rw){

		long pos = TomeOfKnowledge.SHRINE_POINTERS_OFFSET;
		rw.seek(pos);
		origShrinePointerBytes = rw.readBytes(TomeOfKnowledge.NUMBER_OF_SHRINES*4);
		rw.seek(pos);

		pos = TomeOfKnowledge.SHRINE_MIN_LEVELS_OFFSET;
		rw.seek(pos);
		origMinShrineLevelBytes = rw.readBytes(TomeOfKnowledge.NUMBER_OF_SHRINES);
		rw.seek(pos);

		pos = TomeOfKnowledge.SHRINE_MAX_LEVELS_OFFSET;
		rw.seek(pos);
		origMaxShrineLevelBytes = rw.readBytes(TomeOfKnowledge.NUMBER_OF_SHRINES);
		rw.seek(pos);

		pos = TomeOfKnowledge.SHRINE_GAME_TYPE_OFFSET;
		rw.seek(pos);
		origGameTypesInWhichPresentBytes = rw.readBytes(TomeOfKnowledge.NUMBER_OF_SHRINES);
		rw.seek(pos);
	}
	
	@Override
	protected void setUp(){
		ReaderWriter rw = new ReaderWriter(false);
		ss = new ShrinesStore(rw);
		readInAllShrineBytes(rw);
	}
	
	@Test
	public void testGetShrinePointerBytes(){
		byte[] shrinePointerBytes = ss.getShrinePointerBytes();
		assertEquals(Arrays.toString(origShrinePointerBytes), Arrays.toString(shrinePointerBytes));
	}
	
	@Test
	public void testGetMinShrineLevelBytes(){
		byte[] minShrineLevelBytes = ss.getMinShrineLevelBytes();
		assertEquals(Arrays.toString(origMinShrineLevelBytes), Arrays.toString(minShrineLevelBytes));
	}
	
	@Test
	public void testGetMaxShrineLevelBytes(){
		byte[] maxShrineLevelBytes = ss.getMaxShrineLevelBytes();
		assertEquals(Arrays.toString(origMaxShrineLevelBytes), Arrays.toString(maxShrineLevelBytes));
	}
	
	@Test
	public void testGetGameTypeBytes(){
		byte[] gameTypesInWhichPresentBytes = ss.getGameTypesInWhichPresentBytes();
		assertEquals(Arrays.toString(origGameTypesInWhichPresentBytes), Arrays.toString(gameTypesInWhichPresentBytes));
	}
}
