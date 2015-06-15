package uk.me.karlsen.ode_test;

import java.util.Arrays;

import org.junit.Test;

import uk.me.karlsen.ode.QuestStore;
import uk.me.karlsen.ode.ReaderWriter;
import uk.me.karlsen.ode.TomeOfKnowledge;
import junit.framework.TestCase;

public class TestQuest extends TestCase {

	//TODO -- check with hex editor
	byte[][] originalQuestBytes = {
		{5, -1, -1, 0, 100, 0, 0, 0, 0, 0, 0, 0, 115, 0, 0, 0},
		{9, -1, -1, 1, 100, 0, 0, 0, 0, 0, 0, 0, -128, 0, 0, 0},
		{4, -1, -1, 2, 100, 0, 0, 0, 0, 0, 0, 0, -112, 0, 0, 0},
		{8, -1, -1, 3, 100, 0, 0, 0, 0, 0, 0, 0, -108, 0, 0, 0},
		{14, -1, -1, 4, 100, 0, 0, 0, 0, 0, 0, 0, 81, 0, 0, 0},
		{15, -1, -1, 5, 100, 0, 0, 0, 1, 0, 0, 0, 25, 0, 0, 0},
		{2, 2, -1, 6, 100, 0, 0, 0, 1, 0, 0, 0, 63, 0, 0, 0},
		{4, -1, -1, 7, 100, 0, 0, 0, 0, 0, 0, 0, 12, 0, 0, 0},
		{7, -1, -1, 8, 100, 0, 0, 0, 0, 0, 0, 0, -19, 0, 0, 0},
		{5, -1, -1, 9, 100, 0, 0, 0, 0, 0, 0, 0, -20, 0, 0, 0},
		{10, -1, -1, 10, 100, 0, 0, 0, 0, 0, 0, 0, 88, 0, 0, 0},
		{13, -1, -1, 11, 100, 0, 0, 0, 0, 0, 0, 0, -18, 0, 0, 0},
		{3, 3, 1, 12, 100, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
		{2, -1, 3, 13, 100, 4, 0, 0, 0, 0, 0, 0, 39, 0, 0, 0},
		{6, -1, 2, 14, 100, 2, 0, 0, 0, 0, 0, 0, -21, 0, 0, 0},
		{15, 15, 1, 15, 100, 5, 0, 0, 1, 0, 0, 0, 23, 0, 0, 0}
	};
	
	protected QuestStore qs;
	
	protected void setUp(){
		ReaderWriter rw = new ReaderWriter(false);
		qs = new QuestStore(rw);
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
