package uk.me.karlsen.ode.test;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.TestCase;
import uk.me.karlsen.ode.ReaderWriter;
import uk.me.karlsen.ode.TomeOfKnowledge;
import uk.me.karlsen.ode.stores.SpellsStore;
import uk.me.karlsen.ode.types.Spell;

public class TestSpell extends TestCase {

	protected byte[][] origSpellBytes;
	
	protected SpellsStore ss;
	
	public void readInAllSpellBytes(ReaderWriter rw){
		origSpellBytes = new byte[TomeOfKnowledge.NUMBER_OF_SPELLS][TomeOfKnowledge.SPELL_LENGTH_IN_BYTES];
		long pos = TomeOfKnowledge.SPELLS_OFFSET; //skills
		long spacing = 56l;
		for(int i = 0; i < TomeOfKnowledge.NUMBER_OF_SPELLS; i++){
			origSpellBytes[i] = readSpellBytes(rw, pos, i);
			pos = pos + spacing;
		}
	}

	private byte[] readSpellBytes(ReaderWriter rw, long position, int index) {
		long pos = position;
		rw.seek(position);
		byte[] readIn = new byte[TomeOfKnowledge.SPELL_LENGTH_IN_BYTES];
		readIn[0] = rw.readByte();
		for(int i = 1; i < 56; i++){
			pos++;
			rw.seek(pos);
			readIn[i] = rw.readByte();
		}
		return readIn;
	}
	
	@Override
	protected void setUp(){
		ReaderWriter rw = new ReaderWriter(false);
		ss = new SpellsStore(rw);
		readInAllSpellBytes(rw);
	}
	
	@Test
	public void testGetSpellAsBytes(){
		for(int i = 0; i < TomeOfKnowledge.NUMBER_OF_SPELLS; i++){
			String origString = Arrays.toString(origSpellBytes[i]);
			byte[] retrievedBytes = ss.getSpellAsBytes(i);
			String retrievedString = Arrays.toString(retrievedBytes);
			assertEquals(origString, retrievedString);
		}
	}
}
