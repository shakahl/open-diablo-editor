package uk.me.karlsen.ode.test;

import java.util.Arrays;

import org.junit.Test;

import uk.me.karlsen.ode.ReaderWriter;
import uk.me.karlsen.ode.TomeOfKnowledge;
import uk.me.karlsen.ode.stores.QuestStore;
import uk.me.karlsen.ode.types.Quest;
import junit.framework.TestCase;

public class TestQuest extends TestCase {

	byte[][] originalQuestBytes;
	
	protected QuestStore qs;
	
	public void readInAllQuestBytes(ReaderWriter rw){
		originalQuestBytes = new byte[TomeOfKnowledge.NUMBER_OF_QUESTS][TomeOfKnowledge.QUEST_LENGTH_IN_BYTES];
		//seek and read
		long pos = TomeOfKnowledge.QUESTS_OFFSET; //quests
		long spacing = 20l;
		for(int i = 0; i < TomeOfKnowledge.NUMBER_OF_QUESTS; i++){
			originalQuestBytes[i] = readQuestBytes(rw, i, pos);
			pos = pos + spacing;
		}
	}

	public byte[] readQuestBytes(ReaderWriter rw, int slot, long position){
		long pos = position;
		rw.seek(position);
		byte[] readIn = new byte[TomeOfKnowledge.QUEST_LENGTH_IN_BYTES];
		readIn[0] = rw.readByte();
		for(int i = 1; i < 16; i++){
			pos++;
			rw.seek(pos);
			readIn[i] = rw.readByte();
		}
		return readIn;
	}
	
	@Override
	protected void setUp(){
		ReaderWriter rw = new ReaderWriter(false);
		qs = new QuestStore(rw);
		readInAllQuestBytes(rw);
	}
	
	/**
	 * This tests to ensure that getQuestAsBytes() 
	 * returns the correct sequence of bytes
	 * for each quest.
	 */
	@Test
	public void testGetQuestAsBytes(){
		for(int i = 0; i < TomeOfKnowledge.NUMBER_OF_QUESTS; i++){
			byte[] questAsBytes = qs.getQuestAsBytes(i);
			String questAsString = Arrays.toString(questAsBytes);
			String originalString = Arrays.toString(originalQuestBytes[i]);
			assertEquals(originalString, questAsString);
		}
	}
}
