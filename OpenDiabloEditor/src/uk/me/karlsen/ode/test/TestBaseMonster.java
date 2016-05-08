package uk.me.karlsen.ode.test;

import java.util.Arrays;

import org.junit.Test;

import uk.me.karlsen.ode.ReaderWriter;
import uk.me.karlsen.ode.TomeOfKnowledge;
import uk.me.karlsen.ode.stores.BaseMonsterStore;
import uk.me.karlsen.ode.types.MonsterAsBytes;
import junit.framework.TestCase;

public class TestBaseMonster extends TestCase {

	protected byte[][] readInMonsterBytes;
	protected byte[] readInMonsterActivationBytes;
	
	protected BaseMonsterStore bms;
	
	public void readInAllMonsterBytes(ReaderWriter rw) {
		readInMonsterBytes = new byte[TomeOfKnowledge.NUMBER_OF_BASE_MONSTERS][TomeOfKnowledge.BASE_MONSTER_LENGTH_IN_BYTES];
		long pos = TomeOfKnowledge.MONSTER_ACTIVATION_BYTES_OFFSET;
		rw.seek(pos);
		readInMonsterActivationBytes = rw.readBytes(TomeOfKnowledge.NUMBER_OF_BASE_MONSTERS);
		pos = TomeOfKnowledge.BASE_MONSTERS_OFFSET;
		rw.seek(pos);
		for(int i = 0; i < TomeOfKnowledge.NUMBER_OF_BASE_MONSTERS; i++){
			readInMonsterBytes[i] = rw.readBytes(TomeOfKnowledge.BASE_MONSTER_LENGTH_IN_BYTES);
			pos = pos + TomeOfKnowledge.BASE_MONSTER_LENGTH_IN_BYTES;
			rw.seek(pos);
		}
	}
	
	@Override
	protected void setUp(){
		ReaderWriter rw = new ReaderWriter("input/Diablo.exe");
		bms = new BaseMonsterStore(rw);
		readInAllMonsterBytes(rw);
	}
	
	/**
	 * This tests to ensure that getMonsterAsBytes() 
	 * returns the correct sequence of bytes
	 * for each monster.
	 */
	@Test
	public void testGetMonsterAsBytes(){
		byte[] reconstructedActivationBytes = new byte[TomeOfKnowledge.NUMBER_OF_BASE_MONSTERS];
		for(int i = 0; i < TomeOfKnowledge.NUMBER_OF_BASE_MONSTERS; i++){
			MonsterAsBytes mab = bms.getMonsterAsBytes(i);
			reconstructedActivationBytes[i] = mab.getEnabledByte();
			byte[] monsterAsBytes = mab.getMainBytes();
			String monsterAsString = Arrays.toString(monsterAsBytes);
			String originalString = Arrays.toString(readInMonsterBytes[i]);
			assertEquals(originalString, monsterAsString);
		}
		
		//Now compare original activation bytes to reconstructed ones
		String rabString = Arrays.toString(reconstructedActivationBytes);
		String oabString = Arrays.toString(readInMonsterActivationBytes);
		assertEquals(oabString, rabString);
	}
}
