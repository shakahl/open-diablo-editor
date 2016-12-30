package uk.me.karlsen.ode;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.TestCase;
import uk.me.karlsen.ode.ReaderWriter;
import uk.me.karlsen.ode.TomeOfKnowledge;
import uk.me.karlsen.ode.stores.UniqueMonsterStore;

public class TestUniqueMonster extends TestCase {

	private byte[][] originalUniqueMonsterBytes;
	
	private UniqueMonsterStore ums;
	
	public void readInUniqueMonsterBytes(ReaderWriter rw) {
		originalUniqueMonsterBytes = new byte[TomeOfKnowledge.NUMBER_OF_UNIQUE_MONSTERS][TomeOfKnowledge.UNIQUE_MONSTER_LENGTH_IN_BYTES];
		long pos = TomeOfKnowledge.UNIQUE_MONSTERS_OFFSET;
		rw.seek(pos);
		for(int i = 0; i < TomeOfKnowledge.NUMBER_OF_UNIQUE_MONSTERS; i++){
			byte[] monsterBytes = new byte[TomeOfKnowledge.UNIQUE_MONSTER_LENGTH_IN_BYTES];
			monsterBytes = rw.readBytes(TomeOfKnowledge.UNIQUE_MONSTER_LENGTH_IN_BYTES);
			originalUniqueMonsterBytes[i] = monsterBytes;
			pos = pos + TomeOfKnowledge.UNIQUE_MONSTER_LENGTH_IN_BYTES;
			rw.seek(pos);
		}
	}
	
	@Override
	protected void setUp(){
		ReaderWriter rw = new ReaderWriter("input/Diablo.exe");
		ums = new UniqueMonsterStore(rw);
		readInUniqueMonsterBytes(rw);
	}
	
	@Test
	public void testGetUniqueAsBytes(){
		for(int i = 0; i < TomeOfKnowledge.NUMBER_OF_UNIQUE_MONSTERS; i++){
			byte[] retrievedBytes = ums.getUniqueAsBytes(i);
			String retrievedString = Arrays.toString(retrievedBytes);
			String originalString = Arrays.toString(originalUniqueMonsterBytes[i]);
			assertEquals(originalString, retrievedString);
		}
	}
}
