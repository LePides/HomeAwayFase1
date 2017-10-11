/**
 * 
 */
package homeAway;

/**
 * @author celso
 *
 */
public interface User {

	/**
	 * Devolve ID do User
	 * @return idUser
	 */
	String getIdUser();
	
	/**
	 * Devolve email do User
	 * @return email
	 */
	String getEmail();
	
	/**
	 * Devolve telfone do User
	 * @return phone
	 */
	String getPhone();
	
	/**
	 * Devolve o nome do User
	 * @return name
	 */
	String getName();
	
	/**
	 * Devolve a nacionalidade do User
	 * @return nacionalidade
	 */
	String getNacionalidade();
	
	/**
	 * Devolve morada do User
	 * @return morada
	 */
	String getMorada();
	
	/**
	 * Muda as infos do User
	 * @param email
	 * @param phone
	 * @param morada
	 */
	void changeInfo(String email, String phone, String morada);
	
//-------EXTRAS------//
	
	void addHome(String idHome, int preco, int pessoas, String local, String descricao, String morada);
	
	String getIdHome();
	
	String getAllInfo();
	
	//Homes??
}
