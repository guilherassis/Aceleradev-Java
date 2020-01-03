package challenge;

public class CriptografiaCesariana implements Criptografia {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CriptografiaCesariana obj = new CriptografiaCesariana();
		System.out.println(obj.criptografar("a ligeira raposa marrom saltou sobre o cachorro cansado"));
		System.out.println(obj.descriptografar("d oljhlud udsrvd pduurp vdowrx vreuh r fdfkruur fdqvdgr"));
		
	}
	
    @Override
    public String descriptografar(String texto)  {
        
    	if(texto.length() == 0){
            throw new IllegalArgumentException();
        }
        
        texto = texto.toLowerCase();
		String msgcod = "";
		char cod;
		
		for (int aux = 0; aux <texto.length();aux++) {
					
				cod = texto.charAt(aux);
				
				if ((Character.isLetter(cod)) && !(Character.isSpaceChar(cod))) {				
									
						cod = (char) (cod -3);
						if(cod == '^') {
							msgcod += 'x';
							
						}else if(cod == '_') {
							msgcod +='y';
							
						}else if(cod == '`') {
							msgcod +='z';
						}else {
							msgcod +=cod;
						}
							
										
				}else {
					msgcod +=cod;
				}
							
		}
		
		return msgcod;
		       
    }

    @Override
    public String criptografar(String texto){
    	
    	if(texto.length() == 0){
            throw new IllegalArgumentException();
        }
    	
    	texto = texto.toLowerCase();
		String msgcod = "";
		char cod;
    		
    	for (int aux = 0; aux <texto.length();aux++) {
    				
    			cod = texto.charAt(aux);
    			
    			if ((Character.isLetter(cod)) && !(Character.isSpaceChar(cod))) {				
    								
    				cod = (char) (cod +3);
    				if(cod == '{') {
    					msgcod += 'a';
    					
    				}else if(cod == '|') {
    					msgcod +='b';
    					
    				}else if(cod == '}') {
    					msgcod +='c';
    				}else{
    					msgcod +=cod;
    				}
    					
    						
    									
    			 }else {
    				msgcod +=cod;
    			 }
    						
    		}
    	
    	return msgcod;
    	
    }
}
