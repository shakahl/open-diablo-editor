package uk.me.karlsen.ode;

import java.util.Arrays;

import junit.framework.TestCase;

import org.junit.Test;

import uk.me.karlsen.ode.ReaderWriter;
import uk.me.karlsen.ode.TomeOfKnowledge;
import uk.me.karlsen.ode.stores.BaseItemStore;

public class TestBaseItem extends TestCase{
	
	protected byte[][] readInBytes;
	
	protected BaseItemStore bis;
	
	private void readInAllItemBytes(ReaderWriter rw) {
		readInBytes = new byte[TomeOfKnowledge.NUMBER_OF_BASE_ITEMS][TomeOfKnowledge.BASE_ITEM_LENGTH_IN_BYTES];
		long pos = TomeOfKnowledge.BASE_ITEMS_OFFSET;
		rw.seek(pos);
		for(int i = 0; i < TomeOfKnowledge.NUMBER_OF_BASE_ITEMS; i++){
			readInBytes[i] = rw.readBytes(TomeOfKnowledge.BASE_ITEM_LENGTH_IN_BYTES);
			pos = pos + TomeOfKnowledge.BASE_ITEM_LENGTH_IN_BYTES;
			rw.seek(pos);
		}
	}
	
	@Override
	protected void setUp(){
		ReaderWriter rw = new ReaderWriter("input/Diablo.exe");
		bis = new BaseItemStore(rw);
		readInAllItemBytes(rw);
	}
	
	/**
	 * This tests to ensure that getItemAsBytes() 
	 * returns the correct sequence of bytes
	 * for each item.
	 */
	@Test
	public void testGetItemAsBytes(){
		for(int i = 0; i < TomeOfKnowledge.NUMBER_OF_BASE_ITEMS; i++){
			byte[] itemAsBytes = bis.getItemAsBytes(i);
			String itemAsString = Arrays.toString(itemAsBytes);
			String originalString = Arrays.toString(readInBytes[i]);
			assertEquals(originalString, itemAsString);
		}
	}
}
