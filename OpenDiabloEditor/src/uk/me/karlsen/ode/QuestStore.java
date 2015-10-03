package uk.me.karlsen.ode;

import java.util.ArrayList;
import java.util.List;

public class QuestStore {

	ReaderWriter rw = null;
	List<Quest> quests = null;

	public QuestStore(ReaderWriter rw){
		this.rw = rw;
		quests = new ArrayList<Quest>();
		this.readInQuests();
	}

	public void readInQuests(){
		//seek and read
		long pos = TomeOfKnowledge.QUESTS_OFFSET; //quests
		long spacing = 20l;
		for(int i = 0; i < TomeOfKnowledge.NUMBER_OF_QUESTS; i++){
			readQuest(i, pos);
			pos = pos + spacing;
		}
	}

	/*
	   0 	SP dungeon level the quest appears in.
	1 	MP dungeon level the quest appears in.
	2 	Dungeon type (Cathedral, catacombs, caves, hell)
	   All have FF here ("None"), except those with a value at byte 5...
	3 	Quest number
	4 	Don't know....
	5 	Special level setting (SP only)
	   01 = King Leoric's Tomb
	   02 = The Chamber of Bone
	   03 = Maze
	   For some odd reason, the Ogden's Sign quest, which uses this,
	   does not have this value at this location.
	   04 = Dark Passage
	   05 = Unholy Altar
	6-7 	Always zero
	>8-11 	MultiPlayer trigger flag
	   00 = SP only quest
	   01 = SP and MP quest
	12-15 	Text entry IDX
	   00 = "Ahh, the story of our King, is it?"
	   01 = "The village needs your help, good master!"
	*/
	public void readQuest(int slot, long position){
		long pos = position;
		rw.seek(position);
		byte[] readIn = new byte[TomeOfKnowledge.QUEST_LENGTH_IN_BYTES];
		readIn[0] = rw.readByte();
		for(int i = 1; i < 16; i++){
			pos++;
			rw.seek(pos);
			readIn[i] = rw.readByte();
		}

		Quest q = new Quest(slot, readIn, rw);
		quests.add(q);
	}

	public void printQuests(){
		for(Quest q : quests){
			q.printQuest();
		}
	}

	public byte[] getQuestAsBytes(int i) {
		return quests.get(i).getQuestAsBytes();
	}

	public void writeQuestsToEXE() {
		long pos = TomeOfKnowledge.QUESTS_OFFSET;
		for(int i = 0; i < TomeOfKnowledge.NUMBER_OF_QUESTS; i++){
			byte[] questAsBytes = this.getQuestAsBytes(i);
			rw.writeBytes(questAsBytes, pos);
			pos = pos + TomeOfKnowledge.QUEST_LENGTH_IN_BYTES;
		}
	}

	public String[] getQuestNames() {
		String[] questNames = new String[quests.size()];
		for(int i = 0; i < quests.size(); i++){
			questNames[i] = String.valueOf(quests.get(i).getQuestNumber());
		}
		return questNames;
	}
}
