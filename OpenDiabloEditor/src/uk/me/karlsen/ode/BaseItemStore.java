package uk.me.karlsen.ode;

import java.util.ArrayList;
import java.util.List;

public class BaseItemStore {

	ReaderWriter rw;
	List<BaseItem> baseItems;

	public BaseItemStore(ReaderWriter rw) {
		this.rw = rw;
		baseItems = new ArrayList<BaseItem>();
		this.readInItems();
	}

	public void readInItems() {
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

	public byte[] getItemAsBytes(int index){
		return baseItems.get(index).getItemAsBytes();
	}

	public void printItems() {
		for(BaseItem bi : baseItems){
			bi.printItem();
		}
	}

	public void writeItemsToEXE() {
		long pos = TomeOfKnowledge.BASE_ITEMS_OFFSET;
		for(int i = 0; i < TomeOfKnowledge.NUMBER_OF_BASE_ITEMS; i++){
			byte[] itemAsBytes = this.getItemAsBytes(i);
			rw.writeBytes(itemAsBytes, pos);
			pos = pos + TomeOfKnowledge.BASE_ITEM_LENGTH_IN_BYTES;
		}

	}
}
