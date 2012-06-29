package hotel;

import hotel.util.ObservableList;
import hotel.util.ValidationException;

import java.util.Map;
import java.util.TreeMap;

public class Hotel {
	
	// --------------------------------------------------
	// Constructor(s)
	
	private Hotel() {
		generateRoomCategories();
		generateRooms();
		generateClients();
		generateUsers();
	}
	
	// --------------------------------------------------
	// Accessor(s)
	
	public static Hotel getInstance() {
		return instance;
	}
	
	public ObservableList<Room.Category> getRoomCategories() {
		return roomCategories;
	}
	
	public Room.Category getRoomCategory(int id) {
		for (Room.Category cat : roomCategories) {
			if (cat.getId() == id)
				return cat;
		}
		
		return null;
	}
	
	public Map<Room.Category, Integer> getTotalRoomCategories() {
		Map<Room.Category, Integer> categoriesOccurences = new TreeMap<Room.Category, Integer>();
		
		for (Room.Category c : roomCategories) {
			categoriesOccurences.put(c, 5);
		}
		
		return categoriesOccurences;
	}
	
	public ObservableList<Room> getRooms() {
	    return rooms;
	}
	
	public ObservableList<Client> getClients() {
		return clients;
	}
	
	public ObservableList<User> getUsers() {
		return users;
	}
	
	// --------------------------------------------------
	// Mutators(s)
	
	// --------------------------------------------------
	// Method(s)
	
	/**
	 * Genere une liste de catégories de chambre
	 */
	private void generateRoomCategories() {
		roomCategories.add(new Room.Category("Cheap"));
		roomCategories.add(new Room.Category("Normal"));
		roomCategories.add(new Room.Category("Deluxe"));
	}
	
	 /**
     * Genere une liste de chambres
     */
    private void generateRooms() {
        rooms.add(new Room(1001, roomCategories.get(0)));
        rooms.add(new Room(1002, roomCategories.get(0)));
        rooms.add(new Room(1105, roomCategories.get(0)));
        rooms.add(new Room(1110, roomCategories.get(0)));
        rooms.add(new Room(1120, roomCategories.get(0)));
        rooms.add(new Room(1210, roomCategories.get(0)));
        rooms.add(new Room(1235, roomCategories.get(0)));
        rooms.add(new Room(2005, roomCategories.get(1)));
        rooms.add(new Room(2010, roomCategories.get(1)));
        rooms.add(new Room(2015, roomCategories.get(1)));
        rooms.add(new Room(2205, roomCategories.get(1)));
        rooms.add(new Room(2235, roomCategories.get(1)));
        rooms.add(new Room(2315, roomCategories.get(1)));
        rooms.add(new Room(2320, roomCategories.get(1)));
        rooms.add(new Room(3045, roomCategories.get(2)));
        rooms.add(new Room(3050, roomCategories.get(2)));
        rooms.add(new Room(3055, roomCategories.get(2)));
        rooms.add(new Room(3060, roomCategories.get(2)));
        rooms.add(new Room(3135, roomCategories.get(2)));
        rooms.add(new Room(3250, roomCategories.get(2)));
        rooms.add(new Room(3255, roomCategories.get(2)));
    }

	/**
	 * Genere une liste de client
	 */
	private void generateClients() {
		try {
			clients.add(new Client("Gilles",     "111 111-1111"));
			clients.add(new Client("Paul",       "222 222-2222"));
			clients.add(new Client("Robert",     "333 333-3333"));
			clients.add(new Client("Abraham",    "444 444-4444"));
			clients.add(new Client("Erménégile", "555 555-5555"));
		} catch (ValidationException e) {
			e.printStackTrace();
		}
	}
	
	private void generateUsers() {
		try {
			users.add(new User("admin", ""));
		} catch (ValidationException e) {
			e.printStackTrace();
		}
	}
	
	// --------------------------------------------------
	// Attribute(s)
	
	private static Hotel                  instance = new Hotel();
	private ObservableList<Room.Category> roomCategories = new ObservableList<Room.Category>();
	private ObservableList<Room>          rooms = new ObservableList<Room>();
	private ObservableList<Client>        clients = new ObservableList<Client>();
	private ObservableList<User>          users = new ObservableList<User>();
}
