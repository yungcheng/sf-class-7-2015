package airforce;

import java.util.List;

public class SpySquadron<E extends Flyer & Photographer> {
	List<E> theAircraft;
	
	public void startFlight() {
		theAircraft.get(0).takeOff();
		theAircraft.get(0).takePhoto();
	}
}
