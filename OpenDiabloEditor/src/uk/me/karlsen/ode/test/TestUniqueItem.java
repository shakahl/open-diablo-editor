package uk.me.karlsen.ode.test;

import java.util.Arrays;

import org.junit.Test;

import uk.me.karlsen.ode.ReaderWriter;
import uk.me.karlsen.ode.TomeOfKnowledge;
import uk.me.karlsen.ode.stores.UniqueItemStore;
import uk.me.karlsen.ode.types.UniqueItem;
import junit.framework.TestCase;

public class TestUniqueItem extends TestCase {

	private byte[][] originalUniqueItemBytes;
	
	private UniqueItemStore uis;
	
	public void readInAllItemBytes(ReaderWriter rw) {
		originalUniqueItemBytes = new byte[TomeOfKnowledge.NUMBER_OF_UNIQUE_ITEMS][TomeOfKnowledge.UNIQUE_ITEM_LENGTH_IN_BYTES];
		long pos = TomeOfKnowledge.UNIQUE_ITEMS_OFFSET;
		long spacing = TomeOfKnowledge.UNIQUE_ITEM_LENGTH_IN_BYTES;
		for(int i = 0; i < TomeOfKnowledge.NUMBER_OF_UNIQUE_ITEMS; i++){
			originalUniqueItemBytes[i] = readItemBytes(rw, pos);
			pos = pos + spacing;
		}
	}

	private byte[] readItemBytes(ReaderWriter rw, long position){
		long pos = position;
		rw.seek(pos);
		byte[] readIn = new byte[TomeOfKnowledge.UNIQUE_ITEM_LENGTH_IN_BYTES];
		for(int j = 0; j < TomeOfKnowledge.UNIQUE_ITEM_LENGTH_IN_BYTES; j++){
			readIn[j] = rw.readByte();
			pos++;
			rw.seek(pos);
		}
		return readIn;
	}
	
	@Override
	protected void setUp(){
		ReaderWriter rw = new ReaderWriter(true);
		uis = new UniqueItemStore(rw);
		readInAllItemBytes(rw);
	}
	
	@Test
	public void testGetItemAsBytes(){
		for(int i = 0; i < TomeOfKnowledge.NUMBER_OF_UNIQUE_ITEMS; i++){
			byte[] retrievedItemBytes = uis.getItemAsBytes(i);
			String retrievedItemString = Arrays.toString(retrievedItemBytes);
			String originalItemString = Arrays.toString(originalUniqueItemBytes[i]);
			assertEquals(originalItemString, retrievedItemString);
		}
	}
	
}
