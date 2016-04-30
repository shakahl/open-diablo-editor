package uk.me.karlsen.ode.test;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.TestCase;
import uk.me.karlsen.ode.ReaderWriter;
import uk.me.karlsen.ode.TomeOfKnowledge;
import uk.me.karlsen.ode.stores.ItemModifiersStore;
import uk.me.karlsen.ode.types.ItemModifier;

public class TestItemModifier extends TestCase {

	protected byte[][] origItemModifierBytes;
	
	protected ItemModifiersStore ims;
	
	public void readInAllModifierBytes(ReaderWriter rw){
		origItemModifierBytes = new byte[TomeOfKnowledge.NUMBER_OF_MODIFIERS][TomeOfKnowledge.MODIFIER_LENGTH_IN_BYTES];
		long pos = TomeOfKnowledge.MODIFIERS_OFFSET;
		long spacing = TomeOfKnowledge.MODIFIER_LENGTH_IN_BYTES;
		for(int i = 0; i < TomeOfKnowledge.NUMBER_OF_MODIFIERS; i++){
			origItemModifierBytes[i] = readModifierBytes(rw, pos);
			pos = pos + spacing;
		}
	}

	private byte[] readModifierBytes(ReaderWriter rw, long position) {
		long pos = position;
		rw.seek(pos);
		byte[] readIn = new byte[TomeOfKnowledge.MODIFIER_LENGTH_IN_BYTES];
		for(int j = 0; j < TomeOfKnowledge.MODIFIER_LENGTH_IN_BYTES; j++){
			readIn[j] = rw.readByte();
			pos++;
			rw.seek(pos);
		}
		return readIn;
	}
	
	@Override
	protected void setUp() {
		ReaderWriter rw = new ReaderWriter(false);
		ims = new ItemModifiersStore(rw);
		readInAllModifierBytes(rw);
	}
	
	@Test
	public void testGetModifierAsBytes() {
		for(int i = 0; i < TomeOfKnowledge.NUMBER_OF_MODIFIERS; i++){
			byte[] returnedModifierBytes = ims.getModifierAsBytes(i);
			String returnedModifierString = Arrays.toString(returnedModifierBytes);
			String origModifierString = Arrays.toString(origItemModifierBytes[i]);
			assertEquals(origModifierString, returnedModifierString);
		}
	}
}
