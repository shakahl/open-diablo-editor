package uk.me.karlsen.ode.stores;

import java.util.ArrayList;
import java.util.List;

import uk.me.karlsen.ode.ReaderWriter;
import uk.me.karlsen.ode.TomeOfKnowledge;
import uk.me.karlsen.ode.types.UniqueItem;

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

	public void writeItemsToEXE(ReaderWriter writer) {
		long pos = TomeOfKnowledge.UNIQUE_ITEMS_OFFSET;
		for(int i = 0; i < TomeOfKnowledge.NUMBER_OF_UNIQUE_ITEMS; i++){
			byte[] itemAsBytes = this.getItemAsBytes(i);
			writer.writeBytes(itemAsBytes, pos);
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

	public UniqueItem getUniqueItemByName(String uniqueItemName) {
		UniqueItem itemToReturn = null;
		for(UniqueItem i : uniqueItems)
		{
			if(i.getName().equals(uniqueItemName))
			{
				itemToReturn = i;
				break;
			}
		}
		return itemToReturn;
	}
}
