package uk.me.karlsen.ode;

import java.util.ArrayList;
import java.util.List;

/**
 * A store for base item objects belonging 
 * to the BaseItem class. Interfaces with
 * ReaderWriter for the purposes of reading
 * in items to the store and writing out
 * items back to the EXE. 
 */
public class BaseItemStore {

	private ReaderWriter rw;
	private List<BaseItem> baseItems;

	public BaseItemStore(ReaderWriter rw) {
		this.rw = rw;
		baseItems = new ArrayList<BaseItem>();
		this.readInItems();
	}

	private void readInItems() {
		long pos = TomeOfKnowledge.BASE_ITEMS_OFFSET;
		rw.seek(pos);
		for(int i = 0; i < TomeOfKnowledge.NUMBER_OF_BASE_ITEMS; i++){
			byte[] itemBytes = new byte[TomeOfKnowledge.BASE_ITEM_LENGTH_IN_BYTES];
			itemBytes = rw.readBytes(TomeOfKnowledge.BASE_ITEM_LENGTH_IN_BYTES);
			BaseItem bi = new BaseItem(i, itemBytes, rw);
			baseItems.add(bi);
			pos = pos + TomeOfKnowledge.BASE_ITEM_LENGTH_IN_BYTES;
			rw.seek(pos);
		}

	}

	public void printItems() {
		for(BaseItem bi : baseItems){
			bi.printItem();
		}
	}

	public void writeItemsToEXE() {
		long pos = TomeOfKnowledge.BASE_ITEMS_OFFSET;
		for(BaseItem bi : baseItems){
			byte[] itemAsBytes = bi.getItemAsBytes();
			rw.writeBytes(itemAsBytes, pos);
			pos = pos + TomeOfKnowledge.BASE_ITEM_LENGTH_IN_BYTES;
		}

	}

	public byte[] getItemAsBytes(int i) {
		return baseItems.get(i).getItemAsBytes();
	}

	public String[] getItemNames() {
		String[] itemNames = new String[baseItems.size()];
		int itemNamesIndex = 0;
		for(BaseItem bi : baseItems){
			itemNames[itemNamesIndex] = bi.getName();
			itemNamesIndex++;
		}
		return itemNames;
	}

	public BaseItem getItem(int itemIndex) {
		return baseItems.get(itemIndex);
	}

	public BaseItem getItemByName(String itemName) {
		BaseItem itemToReturn = null;
		for(BaseItem item : baseItems){
			if(item.getName().equals(itemName)){
				itemToReturn = item;
				break;
			}
		}
		return itemToReturn;
	}
}
