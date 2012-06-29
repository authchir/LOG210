package hotel;

import hotel.util.ObservableList;
import hotel.util.ValidationException;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.TreeMap;

public class Agenda extends ObservableList<Reservation> {
	
	// --------------------------------------------------
	// Constructor(s)
	
	private Agenda() {
	}
	
	// --------------------------------------------------
	// Accessor(s)
	
	// --------------------------------------------------
	// Mutators(s)
	
	public void init() {
		try {
            Calendar calendar = new GregorianCalendar();
			ReservationSystem reservationSystem = new ReservationSystem();
			
			{
    			reservationSystem.startNewReservation();
    			
    			calendar.set(2012, 10, 1);
    			Date arrivalDate = calendar.getTime();
    			calendar.set(2012, 10, 5);
    			Date departureDate = calendar.getTime();
    			
    			reservationSystem.addLine(1, 2, arrivalDate, departureDate);
    			reservationSystem.confirm("Bilbon Saquet", "555 555-5555");
			}
			
			{
    	        reservationSystem.startNewReservation();
    	        
    	        calendar.set(2013, 2, 12);
                Date arrivalDate = calendar.getTime();
                calendar.set(2013, 2, 14);
                Date departureDate = calendar.getTime();
                
                reservationSystem.addLine(3, 1, arrivalDate, departureDate);
                reservationSystem.confirm("Frodon Saquet", "555 666-7777");
			}
			
			{
    	        reservationSystem.startNewReservation();
    	        
    	        calendar.set(2013, 2, 16);
                Date arrivalDate = calendar.getTime();
                calendar.set(2013, 2, 18);
                Date departureDate = calendar.getTime();
                
                reservationSystem.addLine(3, 1, arrivalDate, departureDate);
                reservationSystem.confirm("Gandalf the Grey", "555 777-8888");
			}
			
			{
    	        reservationSystem.startNewReservation();
    	        
    	        calendar.set(2013, 2, 20);
                Date arrivalDate = calendar.getTime();
                calendar.set(2013, 2, 22);
                Date departureDate = calendar.getTime();
                
                reservationSystem.addLine(3, 1, arrivalDate, departureDate);
                reservationSystem.confirm("Gimli fils de Gloin", "555 888-9999");
			}
			
			{
    	        reservationSystem.startNewReservation();
    	        
    	        calendar.set(2013, 2, 24);
                Date arrivalDate = calendar.getTime();
                calendar.set(2013, 2, 26);
                Date departureDate = calendar.getTime();
                
                reservationSystem.addLine(3, 1, arrivalDate, departureDate);
                reservationSystem.confirm("Boromir fils de Denethor", "555 999-0000");
			}
			
			{
    	        reservationSystem.startNewReservation();
    	        
    	        calendar.set(2013, 2, 28);
                Date arrivalDate = calendar.getTime();
                calendar.set(2013, 2, 30);
                Date departureDate = calendar.getTime();
                
                reservationSystem.addLine(3, 1, arrivalDate, departureDate);
                reservationSystem.confirm("Aragorn fils d'Arathorn", "555 111-2222");
			}
		} catch (ValidationException e) {
			e.printStackTrace();
		}
	}
	
	// --------------------------------------------------
	// Method(s)

	public static Agenda getInstance() {
		return instance;
	}
	
	/**
	 * Ajoute une reservation
	 * @param value
	 */
	public void save(Reservation value)
	{
		add(value);
	}
	
	/**
	 * Enleve une reservation
	 * @param value
	 */
	public void delete(Reservation value)
	{
		remove(value);
	}
	
	
	// Here are the different possibilities:
	//                 begin                end
	//                   |                   |
	// arrival departure |                   |
	//           arrival | departure         |
	//           arrival |                   | departure
	//                   | arrival departure |
	//                   |           arrival | departure
	//                   |                   | arrival departure
	/**
	 * Cette fonction retourne la liste, par categorie, du nombre de chambres utilisee dans l'interval de dates donnees
	 * @param begin
	 * @param end
	 * @return
	 */
	public Map<Room.Category, Integer> getUsedRoomCategoriesBetween(Date begin, Date end) {
		Map<Room.Category, Integer> categoriesOccurences = new TreeMap<Room.Category, Integer>();
		
		for (Reservation r : this) {
			for (Reservation.Detail d : r.getDetails()) {
				Date arrival = d.getArrival();
				Date departure = d.getDeparture();
				
				if (arrival.before(begin) && departure.after(begin)
						|| arrival.before(begin) && departure.after(end)
						|| arrival.after(begin) && arrival.before(end) && departure.after(begin) && departure.before(end)
						|| arrival.after(begin) && arrival.before(end) && departure.after(end)) {
					
					Integer count = categoriesOccurences.get(d.getCategory());
					if (count == null)
						count = 0;
					categoriesOccurences.put(d.getCategory(), count + d.getQuantity());
				}	
			}
		}
		
		return categoriesOccurences;
	}
	
	/**
	 * Cette fonction retourne la liste, par categorie, du nombre de chambres libre dans l'interval de dates donnees
	 * @param begin
	 * @param end
	 * @return
	 */
	public Map<Room.Category, Integer> getFreeRoomCategoriesBetween(Date begin, Date end) {
		Map<Room.Category, Integer> categoriesUsed = getUsedRoomCategoriesBetween(begin, end);
		Map<Room.Category, Integer> results = new TreeMap<Room.Category, Integer>();
		
		for (Map.Entry<Room.Category, Integer> entry : Hotel.getInstance().getTotalRoomCategories().entrySet()) {
			Room.Category category = entry.getKey();
			Integer quantity = entry.getValue();
			Integer used = categoriesUsed.get(category);
			used = (used != null ? used : 0);
			results.put(category, quantity - used);
		}
		
		return results;
	}
	
	public Reservation getReservation(int noConfirmation) {
		Reservation r = null;
		for(int i = 0; i < size(); i++) {
			r = get(i);
			if (r.getConfirmationNumber() == noConfirmation)
				return r;
		}
		return null;
	}
	
	// --------------------------------------------------
	// Attribute(s)

	private static Agenda instance = new Agenda();
}