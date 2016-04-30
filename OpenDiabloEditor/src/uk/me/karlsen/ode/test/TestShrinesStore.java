package uk.me.karlsen.ode.test;

import java.util.Arrays;

import org.junit.Test;

import uk.me.karlsen.ode.ReaderWriter;
import uk.me.karlsen.ode.stores.ShrinesStore;
import junit.framework.TestCase;

public class TestShrinesStore extends TestCase {

	protected byte[] origShrinePointerBytes = {0, 12, 11, 74, 0, -116, -41, 73, 0, 4, 11, 74, 0, -80, -11, 72, 0, -4, 10, 74, 0, -12, 10, 74, 0, -24, 10, 74, 0, -36, 10, 74, 0, -52, 10, 74, 0, -64, 10, 74, 0, -72, 10, 74, 0, -4, 10, 74, 0, -84, 10, 74, 0, -92, 10, 74, 0, -100, 10, 74, 0, 124, -12, 72, 0, -108, 10, 74, 0, -120, 10, 74, 0, -128, 10, 74, 0, 116, 10, 74, 0, 108, 10, 74, 0, 100, 10, 74, 0, 88, 10, 74, 0, 80, 10, 74, 0, 68, 10, 74, 0, 60, 10, 74};
	protected byte[] origMinShrineLevelBytes = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
	protected byte[] origMaxShrineLevelBytes = {16, 16, 16, 16, 16, 16, 16, 8, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16};
	protected byte[] origGameTypesInWhichPresentBytes = {1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0};
	
	protected ShrinesStore ss;
	
	protected void setUp(){
		ReaderWriter rw = new ReaderWriter(false);
		ss = new ShrinesStore(rw);
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
