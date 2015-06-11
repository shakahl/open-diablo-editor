package uk.me.karlsen.ode;

public class GeneralHelper {

	public static boolean isInRange(long numberToCheck, long firstNumber, long lastNumber){
		boolean inRange = false;
		if(numberToCheck >= firstNumber && numberToCheck <= lastNumber){
			inRange = true;
		}
		return inRange;
	}
}
