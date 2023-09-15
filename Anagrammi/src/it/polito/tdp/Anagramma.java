package it.polito.tdp;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// data una parola, restituisca tutti gli anagrammi di una parola

// prendere c e fare anagramma di iao, prendere i seguito da tutte anagramma
// di cao, ecc.
public class Anagramma {
	
	
	public List<String> anagrammi(String parola) {
	    if (parola.length() == 1) {
	        List<String> risultato = new LinkedList<>();
	        risultato.add(parola);
	        return risultato;
	    } else {
	        List<String> risultato = new LinkedList<>();
	        Set<String> duplicati = new HashSet<>(); // Utilizziamo un set per gestire i duplicati
	        
	        for (int pos = 0; pos < parola.length(); pos++) {
	            char lettera = parola.charAt(pos);
	            String restanti = parola.substring(0, pos) + parola.substring(pos + 1);
	            List<String> anagrammiRestanti = anagrammi(restanti);
	            
	            for (String sol : anagrammiRestanti) {
	                String permutazione = lettera + sol;
	                // Verifica se la permutazione è già stata aggiunta
	                if (!duplicati.contains(permutazione)) {
	                    risultato.add(permutazione);
	                    duplicati.add(permutazione);
	                }
	            }
	        }
	        return risultato;
	    }
	}
	
	
	
	

	public static void main(String[] args) {
		
		Anagramma a = new Anagramma();
		
		System.out.println(a.anagrammi("mimmi"));
	

	}

}
