/**
 * 
 */
package homeAway;

/**
 * @author celso
 *
 */
public interface Home {
	
	/**
	 * Devolve o ID da propriedade
	 * @return idHome
	 */
	String getIdHome();
	
	/**
	 * sera necessario???
	 * Devolve o proprietario da propriedade
	 * @return idUser
	 */
	String getIdUser();
	
	/**
	 * Devolve o preco da estadia
	 * @return preco
	 */
	int getPrice();
	
	/**
	 * Devovle o numero de pessoas que podem prenoitar na propriedade
	 * @return pessoas
	 */
	int getPeople();
	
	/**
	 * Devolve o local da propriedade
	 * @return local
	 */
	String getLocal();
	
	/**
	 * Devolve a descricao da propriedade
	 * @return descricao
	 */
	String getDescription();
	
	/**
	 * Devolve a morada da propriedade
	 * @return morada
	 */
	String getMorada();
	
//--------EXTRAS--------//	
	
	int getVisits();
	
	int getPoints();
	
	void addVisits();
	
	void addPoints(int points);
	
	String getAllInfo(String idUser);
	
	String getHomeInfo();
}
