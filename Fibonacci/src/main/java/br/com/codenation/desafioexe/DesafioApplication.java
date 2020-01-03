package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

import br.com.codenation.TestadorFibonacci;
import br.com.codenation.annotation.Desafio;

public class DesafioApplication {
	 	
	public static void main(String[] args) {
		new TestadorFibonacci().testaDesafio(DesafioApplication.class);
	}

	@Desafio("Fibonacci")
	public static List<Integer> fibonacci() {
		List<Integer> fiboList = new ArrayList<Integer>();
		int valor = 0;     
	    int valorAnt = 0; 
	     
	     for (int n = 0; n < 14; n++) {
	            
		        for (int i = 1; i <= n; i++) {
		  
		            if (i == 1) {
		            	valor = 1;
		                valorAnt = 0;
		            } else {
		            	valor += valorAnt;
		                valorAnt = valor - valorAnt;
		            }
		  
		        }
		      	fiboList.add(valor);
	        }
	          
	        return fiboList;
	    }

	@Desafio("isFibonacci")
	public static Boolean isFibonacci(Integer a) {
		List<Integer> fiboListTeste = fibonacci();
		
    	
		if (fiboListTeste.contains(a)) {
			return true;
			
        }else {
        	return false;	
        }
	}

}
