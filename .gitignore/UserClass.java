package homeAway;
import java.util.ArrayList;

public class UserClass implements User{
	
	
	//???????
	private char anfitriao = 'A';
	private char viajante = 'V';
	//???????
	
	
	private ArrayList<Home> homes;
	
	private String idUser;
	private String email;
	private String phone;
	private String name;
	private String nacionalidade;
	private String morada;
	private char type;
	private char type2;

	public UserClass(String idUser, String email, String phone, String name, String nacionalidade, String morada) {
		this.idUser = idUser;
		this.email = email;
		this.phone = phone;
		this.name = name;
		this.nacionalidade = nacionalidade;
		this.morada = morada;
		type = 0;
		type2 = 0;
		
		homes = new ArrayList<Home>();
	}
	
	public String getIdUser() {
		return idUser;
	}


	public String getEmail() {
		return email;
	}

	
	public String getPhone() {
		return phone;
	}

	
	public String getName() {
		return name;
	}

	
	public String getNacionalidade() {
		return nacionalidade;
	}

	
	public String getMorada() {
		return morada;
	}

	
	public void changeInfo(String email, String phone, String morada) {
		this.email = email;
		this.phone = phone;
		this.morada = morada;
		
	}

	
	//?????
	public void addHome(String idHome, int preco, int pessoas, String local, String descricao, String morada) {
		HomeClass home = new HomeClass(idHome, idUser, preco, pessoas, local, descricao, morada);
		homes.add(home);
		type = anfitriao;
	}
	
	public String getIdHome() {
		String idHome = null;
		
		for(int i= 0 ; i<homes.size(); i++) {
			idHome = homes.get(i).getIdHome();
		}
		return idHome;
	}
	
	public String getAllInfo() {
		return name + ": " + morada + ", " + nacionalidade + ", " + email + ", " + phone;
	}
	
	
}
