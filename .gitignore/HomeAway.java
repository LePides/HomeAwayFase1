/**
 * 
 */
package homeAway;

import java.util.Iterator;

/**
 * @author celso
 *
 */
public interface HomeAway {

	
//----------User---------//
	
	/**
	 * Cria um novo User 
	 * @param idUser
	 * @param email
	 * @param phone
	 * @param name
	 * @param nacionalidade
	 * @param morada
	 * pre: hasIdUser() == False
	 */
	void addUser(String idUser, String email, String phone, String name, String nacionalidade, String morada);

	
	/**
	 * Actualiza as infos(email, telefone, morada) do User
	 * @param idUser
	 * @param email
	 * @param phone
	 * @param morada
	 * pre: hasidUser() == True
	 */
	void changeInfoUser(String idUser, String email, String phone, String morada);
	
	/**
	 * Remove um User que nao tenha propriedades
	 * @param idUser
	 * pre: hasIdUser() == true && hasHome() == False
	 */
	void removeUser(String idUser);
	
	/**
	 * Infos do User
	 * @param idUser
	 * @return morada, nacionalidade, email, telefone
	 */
	User getUser(String idUser);
	//String != User
	
//--------Home-------//
	
	/**
	 * Adiciona uma nova propriedade para aluguer
	 * @param idHome
	 * @param idUser
	 * @param preco
	 * @param pessoas
	 * @param local
	 * @param descricao
	 * @param morada
	 * pre: hasIdUser() == True && hasIdHome() == False && preco, pessoas >= 0
	 */
	void addHome(String idHome, String idUser, int preco, int pessoas, String local, String descricao, String morada);
	
	/**
	 * Remove uma propriedade
	 * @param idHome
	 * pre: hasBeenVisited() == False
	 */
	void removeHome(String idHome);
	
	/**
	 * Devolve a info da propriedade
	 * @param idHome
	 * @return morada, local, preco, pessoas, pontos, nomeProp
	 */
	Home getHome(String idHome);
	
	
//--------Estadia--------//
	
	/**
	 * Adiciona uma estadia de um User numa propriedade e da a sua avaliaçao(pontos)
	 * @param idUser
	 * @param idHome
	 * @param points
	 * pre: hasIdUser == True && hasIdHome == True && isHomeThisUser == False && points >= 0
	 */
	void addStay(String idUser, String idHome, int points);
	
	/**
	 * Adiciona uma estadia do User na sua propriedade
	 * @param idUser
	 * @param idHome
	 * pre: hasIdUser == True && hasIdHome == True && isHomeThisUser == True
	 */
	void addStayOwner(String idUser, String idHome);
	
	
//------Extras--------//
	
	/**
	 * Verifica se existe idUser
	 * @param idUser
	 * @return True if idUser exists
	 */
	boolean hasidUser(String idUser);
	
	/**
	 * Verifica se existe idHome
	 * @param idHome
	 * @return True if idHome exists
	 */
	boolean hasIdHome(String idHome);
	
	/**
	 * Verifica se um User tem uma propriedade 
	 * @param idUser
	 * @return True if User has a Home
	 */
	boolean hasHome(String idUser);
	
	/**
	 * Verifica se a propriedade ja foi visitada
	 * @param idHome
	 * @return True if Home has been visited
	 */
	boolean hasBeenVisited(String idHome);
	
	/**
	 * Verifica se a propriedade pertence ao User
	 * @param idUser
	 * @param idHome
	 * @return True if Home belongs to User
	 */
	boolean isHomeThisUser(String idUser, String idHome);
	
	public Iterator<Home> homeIterator();
}
