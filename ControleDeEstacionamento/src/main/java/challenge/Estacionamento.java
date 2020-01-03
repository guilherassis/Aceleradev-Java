package challenge;

import java.util.ArrayList;
import java.util.List;

import challenge.Carro.CarroBuilder;
import challenge.Motorista.MotoristaBuilder;


public class Estacionamento {
	List<Carro> listaCarro = new ArrayList<>();
	
	

    public void estacionar(Carro carro) {
    	
    	String motorista = carro.toString();
    	
    	
    	if(motorista.contains("motorista=null")){
    		
    		throw new EstacionamentoException("Não pode carro ter carro autonomo.");
    		
    	}
    	
    	
    	if(carro.getMotorista().getIdade()<=17) {
    		
    		throw new EstacionamentoException("Motorista Menor de idade.");
    		
    		
    	}
    	
    	if(carro.getMotorista().getPontos()>20) {
    		
    		throw new EstacionamentoException("Motorista Sem pontos na carteira.");
    		
    	}
    	    	
    	if(carrosEstacionados()>=10) {
    		   			
	    	Carro retirar0 =listaCarro.get(0);
	    	if(retirar0.getMotorista().getIdade()<=55) {
	        			
	    		listaCarro.remove(0);
	        			
	        }else {
	    	
		    	if(listaCarro.stream().filter(velho ->velho.getMotorista().getIdade()<55).findFirst().isPresent()){
		    		
		    		Carro remover = listaCarro.stream().filter(velho ->
		    		velho.getMotorista().getIdade()<55).findFirst().get();
		    		listaCarro.remove(remover);
		    		
		    	}
	        }
	    		    	
	       
	        Long count = listaCarro.stream().filter(velho ->velho.getMotorista().getIdade()>=55).count();
        	if(count>=10L) {
        		throw new EstacionamentoException("Não tem vaga, todos são senior.");
        	}
	    	
    		
    		
    	}
    	
    	
    	listaCarro.add(carro);
    	
    		
      
    }

    public int carrosEstacionados() {
        
        return listaCarro.size();
    }

    public boolean carroEstacionado(Carro carro) {
    	
    	return listaCarro.contains(carro);
    	
        
    }
}
