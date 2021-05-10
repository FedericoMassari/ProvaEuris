package org.generation.italy.eurisTest.dao;

public interface IDaoCosts {
	
	/**
	 * Metodo che prende da parametro due stringhe costi e
	 * restituisce la stringa rappresentante la somma dei due costi.
	 * es. 5p 17s 8d + 3p 4s 10d = 9p 2s 6d
	 * @param cost1
	 * @param cost2
	 * @return Stringa somma dei costi
	 */
	String sumCost(String cost1, String cost2);
	
	/**
	 * Metodo che prende da parametro due stringhe costi e
	 * restituisce la stringa rappresentante la sottrazione dei due costi
	 * (in ordine cost1-cost2).
	 * es. 5p 17s 8d - 3p 4s 10d = 2p 12s 10d
	 * @param cost1
	 * @param cost2
	 * @return Stringa sottrazione dei costi
	 */
	String subCost(String cost1, String cost2);
	
	/**
	 * Metodo che prende da parametro una stringa costo e un intero e
	 * restituisce la stringa rappresentante il prodotto del costo per l'intero.
	 * es. 5p 17s 8d - 2 = 11p 15s 4d
	 * @param cost
	 * @param multiplier
	 * @return Stringa prodotto del costo per il moltiplicatore
	 */
	String multCost(String cost, int multiplier);
	
	/**
	 * Metodo che prende da parametro una stringa costo e un intero e
	 * restituisce la stringa rappresentante la divisione intera del costo per l'intero
	 * e tra parentesi il resto. 
	 * es. 18p 16s 1d / 15 = 1p 5s 0d (1s 1d)
	 * @param cost
	 * @param divisor
	 * @return Stringa divisione del costo per il divisore + (Stringa resto)
	 */
	String divCost(String cost, int divisor);

}
