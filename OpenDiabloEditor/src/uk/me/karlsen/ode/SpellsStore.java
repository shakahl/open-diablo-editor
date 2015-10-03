package uk.me.karlsen.ode;

import java.util.ArrayList;
import java.util.List;

public class SpellsStore {

	ReaderWriter rw = null;
	List<Spell> spells = null;

	public SpellsStore(ReaderWriter rw){
		this.rw = rw;
		this.spells = new ArrayList<Spell>();
		this.readInSpells();
	}

	public void readInSpells(){
		long pos = TomeOfKnowledge.SPELLS_OFFSET; //skills
		long spacing = 56l;
		for(int i = 0; i < TomeOfKnowledge.NUMBER_OF_SPELLS; i++){
			readSpell(pos, i);
			pos = pos + spacing;
		}
	}

	private void readSpell(long position, int index) {
		long pos = position;
		rw.seek(position);
		byte[] readIn = new byte[TomeOfKnowledge.SPELL_LENGTH_IN_BYTES];
		readIn[0] = rw.readByte();
		for(int i = 1; i < 56; i++){
			pos++;
			rw.seek(pos);
			readIn[i] = rw.readByte();
		}

		Spell s = new Spell(index, readIn, rw);
		spells.add(s);


	}

	public void printSpells() {
		for(Spell s : spells){
			s.printSpell();
		}
	}

	public byte[] getSpellAsBytes(int i) {
		return spells.get(i).getSpellAsBytes();
	}

	public void writeSpellsToEXE() {
		long pos = TomeOfKnowledge.SPELLS_OFFSET;
		for(int i = 0; i < TomeOfKnowledge.NUMBER_OF_SPELLS; i++){
			byte[] spellAsBytes = this.getSpellAsBytes(i);
			rw.writeBytes(spellAsBytes, pos);
			pos = pos + TomeOfKnowledge.SPELL_LENGTH_IN_BYTES;
		}
	}

	public String[] getSpellNames() {
		String[] spellNames = new String[spells.size()];
		for(int i = 0; i < spells.size(); i++){
			spellNames[i] = String.valueOf(spells.get(i).getUnmoddedSpellIndex());
		}
		return spellNames;
	}
}
