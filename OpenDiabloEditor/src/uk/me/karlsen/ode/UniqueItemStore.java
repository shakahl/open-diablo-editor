package uk.me.karlsen.ode;

import java.util.ArrayList;
import java.util.List;

public class UniqueItemStore {

	ReaderWriter rw;
	List<UniqueItem> uniqueItems;

	public UniqueItemStore(ReaderWriter rw){
		this.rw = rw;
		uniqueItems = new ArrayList<UniqueItem>();
		this.readInItems();
	}

	public void readInItems() {
		long pos = TomeOfKnowledge.UNIQUE_ITEMS_OFFSET;
		long spacing = TomeOfKnowledge.UNIQUE_ITEM_LENGTH_IN_BYTES;
		for(int i = 0; i < TomeOfKnowledge.NUMBER_OF_UNIQUE_ITEMS; i++){
			readItem(pos);
			pos = pos + spacing;
		}
	}

	private void readItem(long position){
		long pos = position;
		rw.seek(pos);
		byte[] readIn = new byte[TomeOfKnowledge.UNIQUE_ITEM_LENGTH_IN_BYTES];
		for(int j = 0; j < TomeOfKnowledge.UNIQUE_ITEM_LENGTH_IN_BYTES; j++){
			readIn[j] = rw.readByte();
			pos++;
			rw.seek(pos);
		}

		UniqueItem ui = new UniqueItem(readIn, rw);
		uniqueItems.add(ui);
	}

	public void printItems() {
		for(UniqueItem ui : uniqueItems){
			ui.printItem();
		}
	}

	public byte[] getItemAsBytes(int i) {
		return uniqueItems.get(i).getItemAsBytes();
	}

	public void writeItemsToEXE() {
		long pos = TomeOfKnowledge.UNIQUE_ITEMS_OFFSET;
		for(int i = 0; i < TomeOfKnowledge.NUMBER_OF_UNIQUE_ITEMS; i++){
			byte[] itemAsBytes = this.getItemAsBytes(i);
			rw.writeBytes(itemAsBytes, pos);
			pos = pos + TomeOfKnowledge.UNIQUE_ITEM_LENGTH_IN_BYTES;
		}
	}

	public String[] getItemNames() {
		String[] itemNames = new String[uniqueItems.size()];
		for(int i = 0; i < uniqueItems.size(); i++){
			itemNames[i] = uniqueItems.get(i).getName();
		}
		return itemNames;
	}
}
