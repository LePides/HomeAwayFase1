
/**
 * 
 */

import java.util.Scanner;

import dataStructures.*;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import homeAway.*;

/**
 * @author celso
 *
 */
public class Main {

	// Comandos intrucoes
	private static final String CREATE_USER = "IU";
	private static final String CHANGE_USER = "UU";
	private static final String REMOVE_USER = "RU";
	private static final String GET_USER = "GU";
	private static final String ADD_HOME = "AH";
	private static final String REMOVE_HOME = "RH";
	private static final String GET_HOME = "GH";
	private static final String ADD_STAY = "AT";
	private static final String LIST_USER_HOME = "LH";
	private static final String TRAVELER_STAYS = "LT";
	private static final String SEARCH_PROPERTIES = "PH";
	private static final String SEARCH_BEST_PROPERTY = "LB";
	private static final String EXIT = "XS";

	// Messagens sucesso
	private static final String CREATE_USER_OK = "Insercao de utilizador com sucesso.";
	private static final String CHANGE_USER_OK = "Utilizador atualizado com sucesso.";
	private static final String REMOVE_USER_OK = "Utilizador removido com sucesso.";
	private static final String ADD_HOME_OK = "Propriedade adicionada com sucesso.";
	private static final String REMOVE_HOME_OK = "Propriedade removida com sucesso.";
	private static final String ADD_STAY_OK = "Estadia adicionada com sucesso.";

	// Messagens falhanco
	private static final String USER_EXISTS = "Utilizador existente.";
	private static final String USER_NO_EXISTS = "Utilizador inexistente.";
	private static final String USER_HAS_HOME = "Utilizador e proprietario.";
	private static final String WRONG_DATA = "Dados invalidos.";
	private static final String HOME_EXISTS = "Propriedade existente.";
	private static final String HOME_NO_EXISTS = "Propriedade inexistente.";
	private static final String HOME_VISISTED = "Propriedade ja foi visitada.";
	private static final String USER_NOT_OWNER = "Viajante nao e proprietario.";
	private static final String IS_OWNER = "Viajante e o proprietario.";
	private static final String NO_RESULTS = "Pesquisa nao devolveu resultados.";

	// outros
	private static final String LEAVE_SAVE = "Gravado e terminado...";
	private static final String DATA_FILE = "stored.dat";

	// ----------Linhas de comando---------//

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		HomeAwayClass hA = load();
		// HomeAwayClass hA2 = new HomeAwayClass();
		String com = comands(in);

		while (!com.equals(EXIT)) {
			switch (com) {
			case CREATE_USER:
				createUser(in, hA);
				break;
			case CHANGE_USER:
				changeUser(in, hA);
				break;
			case REMOVE_USER:
				removeUser(in, hA);
				break;
			case GET_USER:
				getUser(in, hA);
				break;
			case ADD_HOME:
				addHome(in, hA);
				break;
			case REMOVE_HOME:
				removeHome(in, hA);
				break;
			case GET_HOME:
				getHome(in, hA);
				break;
			case ADD_STAY:
				addStay(in, hA);
				break;
			case LIST_USER_HOME:
				listUserHome(in, hA);
				break;
			case SEARCH_PROPERTIES:
				searchProperties(in, hA);
			case SEARCH_BEST_PROPERTY:
				searchBestProperty(in, hA);
			case TRAVELER_STAYS:
				travelerStays(in, hA);
			case EXIT:
				save(hA);
				break;
			default:
				System.out.println("ERRO!");
				break;
			}
			System.out.println();
			com = comands(in);
		}
		System.out.println(LEAVE_SAVE);
		System.out.println();
		in.close();

	}

	private static String comands(Scanner in) {
		String input = in.next().toUpperCase();
		return input;

	}

	// --------Metodos dos comandos-------//

	// Cria um User
	private static void createUser(Scanner in, HomeAwayClass hA) {
		String idUser = in.next();
		String email = in.next();
		String phone = in.next();
		String name = in.nextLine();
		String nacionalidade = in.nextLine();
		String morada = in.nextLine();
		// in.nextLine();

		if (!hA.hasidUser(idUser)) {
			hA.addUser(idUser, email, phone, name, nacionalidade, morada);
			System.out.println(CREATE_USER_OK);
		} else
			System.out.println(USER_EXISTS);
	}

	// Muda as definicoes de um Utilizador
	private static void changeUser(Scanner in, HomeAwayClass hA) {
		String idUser = in.next();
		String email = in.next();
		String phone = in.nextLine();
		String morada = in.nextLine();

		if (hA.hasidUser(idUser)) {
			hA.changeInfoUser(idUser, email, phone, morada);
			System.out.println(CHANGE_USER_OK);
		} else
			System.out.println(USER_NO_EXISTS);
	}

	// Remove um Utilizador
	private static void removeUser(Scanner in, HomeAwayClass hA) {
		String idUser = in.next();

		if (hA.hasidUser(idUser)) {
			if (!hA.hasHome(idUser)) {
				hA.removeUser(idUser);
				System.out.println(REMOVE_USER_OK);
			} else
				System.out.println(USER_HAS_HOME);
		} else
			System.out.println(USER_NO_EXISTS);
	}

	// Devolve os dados de um Utilizador
	private static void getUser(Scanner in, HomeAwayClass hA) {
		String idUser = in.next();

		if (hA.hasidUser(idUser)) {
			System.out.println(hA.getUser(idUser).getAllInfo().trim());
			// System.out.println("\n"+hA.getUser(idUser).getName()+":
			// "+hA.getUser(idUser).getMorada()+",
			// "+hA.getUser(idUser).getNacionalidade()+",
			// "+hA.getUser(idUser).getEmail()+",
			// "+hA.getUser(idUser).getPhone()+"\n");
		} else
			System.out.println(USER_NO_EXISTS);
	}

	// Adiciona uma propriedade
	private static void addHome(Scanner in, HomeAwayClass hA) {
		String idHome = in.next();
		String idUser = in.next();
		int preco = in.nextInt();
		int pessoas = in.nextInt();
		String local = in.nextLine();
		String descricao = in.nextLine();
		String morada = in.nextLine();

		if (hA.hasidUser(idUser)) {
			if (!hA.hasIdHome(idHome)) {
				if (preco >= 0 && pessoas >= 0 && pessoas <= 20) {
					hA.addHome(idHome, idUser, preco, pessoas, local, descricao, morada);
					hA.getUser(idUser).addHome(idHome, preco, pessoas, local, descricao, morada);
					System.out.println(ADD_HOME_OK);
				} else
					System.out.println(WRONG_DATA);
			} else
				System.out.println(HOME_EXISTS);
		} else
			System.out.println(USER_NO_EXISTS);
	}

	// Remove uma propriedade
	private static void removeHome(Scanner in, HomeAwayClass hA) {
		String idHome = in.next();

		if (hA.hasIdHome(idHome)) {
			if (!hA.hasBeenVisited(idHome)) {
				hA.removeHome(idHome);
				System.out.println(REMOVE_HOME_OK);
			} else
				System.out.println(HOME_VISISTED);
		} else
			System.out.println(HOME_NO_EXISTS);
	}

	// Devolve os dados de uma propriedade
	private static void getHome(Scanner in, HomeAwayClass hA) {
		String idHome = in.next();

		if (hA.hasIdHome(idHome)) {
			System.out.println(
					(hA.getHome(idHome).getHomeInfo() + hA.getUser(hA.getHome(idHome).getIdUser()).getName()).trim());
			// System.out.println("\n"+hA.getHome(idHome).getDescription()+":
			// "+hA.getHome(idHome).getMorada()+","+hA.getHome(idHome).getLocal()+",
			// "+hA.getHome(idHome).getPrice()+",
			// "+hA.getHome(idHome).getPeople()+",
			// "+hA.getHome(idHome).getPoints()+","+hA.getUser(hA.getHome(idHome).getIdUser()).getName());
		} else
			System.out.println(HOME_NO_EXISTS);
	}

	private static void addStay(Scanner in, HomeAwayClass hA) {
		String idUser = in.next();
		String idHome = in.next();
		String blank = in.nextLine().trim();

		if (blank.isEmpty()) {
			if (hA.hasidUser(idUser)) {
				if (hA.hasIdHome(idHome)) {
					if (hA.isHomeThisUser(idUser, idHome)) {
						hA.addStayOwner(idUser, idHome);
						System.out.println(ADD_STAY_OK);

					} else {
						System.out.println(USER_NOT_OWNER);
					}
				} else {
					System.out.println(HOME_NO_EXISTS);
				}
			} else {
				System.out.println(USER_NO_EXISTS);
			}
		} else {
			if (hA.hasidUser(idUser)) {
				if (hA.hasIdHome(idHome)) {
					if (!hA.isHomeThisUser(idUser, idHome)) {
						int points = Integer.parseInt(blank);

						if (points >= 0 && points <= 20) {
							hA.addStay(idUser, idHome, points);
							System.out.print(points);
							System.out.println(ADD_STAY_OK);

						} else {
							System.out.print(WRONG_DATA);
						}
					} else {
						System.out.println(IS_OWNER);
					}
				} else {
					System.out.println(HOME_NO_EXISTS);

				}
			} else {
				System.out.println(USER_NO_EXISTS);
			}
		}
	}
	/*
	 * } try{ int points = in.nextInt();
	 * 
	 * }catch(Exception e){ System.out.println(IS_OWNER);
	 * 
	 * } finally{ if(!hA.hasidUser(idUser)){ System.out.println(USER_NO_EXISTS);
	 * } else if(!hA.hasIdHome(idHome)){ System.out.println(HOME_NO_EXISTS); }
	 * else if(!hA.isHomeThisUser(idUser, idHome)){
	 * System.out.println(USER_NOT_OWNER); } else{ hA.addStay(idUser, idHome,
	 * 0); System.out.println(ADD_STAY_OK); } } }
	 */
	/*
	 * String blank = in.next();
	 * 
	 * if (hA.hasidUser(idUser)) { if (hA.hasIdHome(idHome)) { if
	 * (hA.getUser(idUser).getIdHome() != idHome) { if (blank != null || blank
	 * != "\n") {
	 * 
	 * int points = Integer.parseInt(blank);
	 * 
	 * if (points >= 0 && points < 20) { System.out.println("YUPIE!!"); } else
	 * System.out.println("Almost!"); } else System.out.println("Falhado!"); }
	 * else System.out.println("Not YET!"); } else System.out.println("BURRO!");
	 * }
	 */

	// Esta ainda em trabalho
	// private static void addStayOwner(Scanner in, HomeAwayClass hA) {
	/*
	 * String[] tmp = new String[4]; String idUser = in.next(); tmp[0] = idUser;
	 * String idHome = in.next(); tmp[1] = idHome;
	 * System.out.println(tmp.length); if (tmp.length == 4) {
	 * System.out.println("JA ESTA");
	 */

	// }

	// Lista as propriedades do utilizador(anfintriao)
	private static void listUserHome(Scanner in, HomeAwayClass hA) {

		Iterator<Home> it = hA.homeIterator();
		int counter = 0;
		String idUser = in.next();

		if (hA.hasidUser(idUser)) {
			while (it.hasNext()) {
				Home temp = it.next();
				if (temp.getIdHome().equals(hA.getUser(idUser).getIdHome())) {
					System.out.print("\n" + temp.getAllInfo(idUser));
					counter++;
				}
			}
			if (counter == 0) {
				System.out.println(USER_NOT_OWNER);
			}
		} else
			System.out.println(USER_NO_EXISTS);
	}

	private static void travelerStays(Scanner in, HomeAwayClass hA) {

	}

	private static void searchProperties(Scanner in, HomeAwayClass hA) {

		// Iterator<Home> it = hA.homeIterator();
		int pessoas = in.nextInt();
		String local = in.nextLine();

		if (pessoas > 0) {
			if (!hA.getHomeByLocal(local).equals(local)) {
				System.out.println(hA.getHomeByLocal(local).getHomeInfo());
			} else {
				System.out.println(NO_RESULTS);
			}

		} else {
			System.out.println(WRONG_DATA);
		}

		// if (pessoas > 0) {
		// while (it.hasNext()) {
		// Home temp = it.next();
		// if (temp.getLocal().equals(local)) {
		// System.out.println("\n" + temp.getHomeInfo());
		// counter++;
		// }
		// }
		// if (counter == 0) {
		// System.out.println(NO_RESULTS);
		//
		// }
		// } else
		// System.out.println(WRONG_DATA);

	}

	private static void searchBestProperty(Scanner in, HomeAwayClass hA) {

		// Iterator<Home> it = hA.homeIterator();
		// int counter = 0;
		String local = in.nextLine();

		// while (it.hasNext()) {
		// Home temp = it.next();
		// if (temp.getLocal().equals(local))
		// System.out.println("\n" + temp.getHomeInfo());
		// counter++;
		// }
		// if (counter == 0) {
		// System.out.println(NO_RESULTS);
		// }
		if (!hA.getHomeByLocal(local).equals(local)) {
			System.out.println(hA.getHomeByLocal(local).getHomeInfo());
		} else
			System.out.println(NO_RESULTS);

	}

	// ---------SAVE AND LOAD---------//

	private static final void save(HomeAwayClass hA) {
		try {
			ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(DATA_FILE));
			file.writeObject(hA);
			file.flush();
			file.close();
		} catch (IOException e) {
			System.out.println("Erro!");
		}
	}

	@SuppressWarnings("unchecked")
	private static final HomeAwayClass load() {
		try {
			ObjectInputStream file = new ObjectInputStream(new FileInputStream(DATA_FILE)); //
			//DoublyLinkedList<Integer> hA = (DoublyLinkedList<Integer>) file.readObject();
			HomeAwayClass hA = (HomeAwayClass) file.readObject();
			file.close();
			System.out.println("load: LI FICHEIRO");
			return hA;
		} catch (IOException e) {
			return new HomeAwayClass();
		} catch (ClassNotFoundException e) {
			return new HomeAwayClass();
		}

	}

}
