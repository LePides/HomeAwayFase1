package homeAway;

import java.util.ArrayList;
import java.util.Iterator;


public class HomeAwayClass implements HomeAway {

	private ArrayList<User> users;
	private ArrayList<Home> homes;

	
	public HomeAwayClass() {
		users = new ArrayList<User>();
		homes = new ArrayList<Home>();
	}

//--------User--------//
	
	public void addUser(String idUser, String email, String phone, String name, String nacionalidade, String morada) {
		UserClass user = new UserClass(idUser, email, phone, name, nacionalidade, morada);
		users.add(user);
	}

	
	public void changeInfoUser(String idUser, String email, String phone, String morada) {
		getUser(idUser).changeInfo(email, phone, morada);		
	}

	public void removeUser(String idUser) {
		users.remove(getUser(idUser));	
	}

	public User getUser(String idUser) {
		
		User user = null;
		
		for(int i= 0 ; i<users.size(); i++) {
			if(users.get(i).getIdUser().equals(idUser)) {
				user = users.get(i);
			}
		}
		return user;
	}

	
//----------Home----------//	
	
	
	public void addHome(String idHome, String idUser, int preco, int pessoas, String local, String descricao,
			String morada) {
		HomeClass home = new HomeClass(idHome, idUser, preco, pessoas, local, descricao, morada);
		homes.add(home);
	}

	public void removeHome(String idHome) {
		homes.remove(getHome(idHome));
		
	}

	public Home getHome(String idHome) {
		Home home = null;
		
		for(int i= 0 ; i<homes.size(); i++) {
			if(homes.get(i).getIdHome().equals(idHome)) {
				home = homes.get(i);
			}
		}
		return home;
	}
	
	public Home getOwnerHome(String idUser) {
		Home home = null;
		
		for(int i= 0 ; i<homes.size(); i++) {
			if(homes.get(i).getIdUser().equals(idUser)) {
				home = homes.get(i);
			}
		}
		return home;
	}

	
//-------Estadias--------//	
	
	public void addStay(String idUser, String idHome, int points) {
		getHome(idHome).addVisits();
		getHome(idHome).addPoints(points);
		
	}
	
	public void addStayOwner(String idUser, String idHome) {
		getHome(idHome).addVisits();
		
	}

	
//----------EXTRAS-----------//	
	
	
	public boolean hasidUser(String idUser) {
		if(getUser(idUser) != null) {
			return true;
		}
		return false;
	}

	public boolean hasIdHome(String idHome) {
		if(getHome(idHome) != null) {
			return true;
		}
		return false;
	}

	public boolean hasHome(String idUser) {
		boolean found = false;
		
		for(int i = 0 ; i<homes.size(); i++) {
			if(homes.get(i).getIdUser().equals(idUser)){
				found = true;
			}
		}
		
		return found;
	}

	public boolean hasBeenVisited(String idHome) {
		if(getHome(idHome).getVisits() > 0) {
			return true;
		}
		return false;
	}

	//Nao esta a funicionar e nao sei porque?
	public boolean isHomeThisUser(String idUser, String idHome) {
		if(getHome(idHome).getIdUser().equals(idUser)) {
			return true;
		}
		 
			return false;
	}
	
	public Iterator<Home> homeIterator() {
		return homes.listIterator();
	}
	
}
