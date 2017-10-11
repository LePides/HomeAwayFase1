package homeAway;

public class HomeClass implements Home{

	private String idHome;
	private String idUser;
	private int preco;
	private int pessoas;
	private String local;
	private String descricao;
	private String morada;
	
	public int visits;
	public int points;
	
	public HomeClass(String idHome, String idUser, int preco, int pessoas, String local, String descricao, String morada) {
		this.idHome = idHome;
		this.idUser = idUser;
		this.preco = preco;
		this.pessoas = pessoas;
		this.local = local;
		this.descricao = descricao;
		this.morada = morada;
		
		//------//
		
		
		visits = 0;
		points = 0;
	}
	
	public String getIdHome() {
		return idHome;
	}

	
	public String getIdUser() {
		return idUser;
	}

	
	public int getPrice() {
		return preco;
	}

	
	public int getPeople() {
		return pessoas;
	}

	
	public String getLocal() {
		return local;
	}

	
	public String getDescription() {
		return descricao;
	}

	
	public String getMorada() {
		return morada;
	}
	
//--------EXTRAS--------//
	
	public int getVisits() {
		return visits;
	}
	
	public int getPoints() {
		return points;
	}
	
	
	public String getHomeInfo() {
		return descricao + ": " + morada + "," + local + ", " + preco + ", " + pessoas + ", " + points+ ",";
	}
	
	public String getAllInfo(String idUser) {
		return idHome + " " + descricao + " " + morada + " " + local + " " + preco + " " + pessoas + " " + points;
	}
	
//-------------//	
	public void addVisits() {
		visits ++;
	}
	
	public void addPoints(int points) {
		this.points += points;
	}
}
