package uk.me.karlsen.ode;

public class BinEditHelper {

	public BinEditHelper(){
		
	}
	
	public String getNameUsingPointer(long pointer){
		ReaderWriter rwTemp = new ReaderWriter(true);
		rwTemp.seek(pointer);
		byte[] bytes = rwTemp.readBytes(40);
		int endByte = -1;
		for(int i = 0; i < bytes.length; i++){
			if(bytes[i] == 0){
				endByte = i;
				break;
			}
		}
		String name;
		if(endByte == -1){
			name = "nullString";
		} else {
			name = new String(bytes, 0, endByte);
		}
		return name;
	}
}
