package org.generation.italy.eurisTest.dao;

import org.springframework.stereotype.Repository;

@Repository
public class DaoCosts implements IDaoCosts{
	
	@Override
	public String sumCost(String cost1, String cost2) {
		int pence1 = toPence(cost1);
		int pence2 = toPence(cost2);
		int sumPence = pence1 + pence2;
		return penceToString(sumPence);
	}

	@Override
	public String subCost(String cost1, String cost2) {
		int pence1 = toPence(cost1);
		int pence2 = toPence(cost2);
		int subPence = pence1 - pence2;
		return penceToString(subPence);
	}

	@Override
	public String multCost(String cost, int multiplier) {
		int pence = toPence(cost);
		int multPence = pence*multiplier;
		return penceToString(multPence);
	}

	@Override
	public String divCost(String cost, int divisor) {
		int pence = toPence(cost);
		int divPence = pence/divisor;
		int restPence = pence%divisor;
		return penceToString(divPence) + " (" + penceToString(restPence) + ")";
	}
	
	/**
	 * Metodo accessorio che dal totale del prezzo già convertito in pence, restituisce
	 * la stringa rappresentante il prezzo in pound shilling pence.
	 * es. 1412 -> "5p 17s 8d"
	 * @param totPence (il prezzo totale in pence)
	 * @return il prezzo equivalente in formato string
	 */
	private String penceToString(int totPence) {
		String res = "";
		int pence = totPence%12;
		int totShilling = totPence/12;
		int shilling = totShilling%20;
		int pound = totShilling/20;
		if (pound != 0) {
			res = pound + "p " + shilling + "s " + pence + "d";
		} else if (pound == 0 && shilling != 0) {
			res = shilling + "s " + pence + "d";
		} else if (pound == 0 && shilling == 0) {
			res = pence + "d";
		}
		return res;
	}
	
	/**
	 * Metodo accessorio che dalla stringa rappresentante il prezzo, restituisce
	 * un intero rappresentate il totale del prezzo convertito in pence.
	 * es. "5p 17s 8d" -> 1412
	 * @param cost in formato stringa
	 * @return Un intero raprresentante il prezzo equivalente in pence
	 */
	private int toPence(String cost) {
		int res = 0;
		String currencies[] = cost.split(" ");
		String temp;
		for (int i = 0; i < currencies.length; i++) {
			temp = "";
			for (int j = 0; j < currencies[i].length(); j++) {
				char ch = currencies[i].charAt(j);
				if (Character.isDigit(ch)) {
					temp += ch;
				} else {
					switch (ch) {
					case 'p':
						res += Integer.parseInt(temp)*240;
						break;
					case 's':
						res += Integer.parseInt(temp)*12;
						break;
					case 'd':
						res += Integer.parseInt(temp);
						break;	
					}
				}
			}
		}
		return res;
	}
	
}
