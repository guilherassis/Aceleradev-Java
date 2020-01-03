package br.com.codenation;

import java.math.BigDecimal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import br.com.codenation.desafio.MeuTimeInterface;
import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;
import br.com.codenation.entity.Jogador;
import br.com.codenation.entity.Time;


public class DesafioMeuTimeApplication implements MeuTimeInterface {
	
	private List<Time> listaTime = new ArrayList<>();
	private List<Jogador> listaJogador = new ArrayList<>();
	
	
	

	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal,
			String corUniformeSecundario) {
				
		Time time = new Time();
		
			
		if(listaTime.stream().filter(listatime -> 
		listatime.getIdTime().equals(id)).findFirst().isPresent()) {
			
			throw new IdentificadorUtilizadoException();
	
		}

		time.setIdTime(id);
		time.setNomeTime(nome);
		time.setDataCriacao(dataCriacao);
		time.setCorUniformePrincipal(corUniformePrincipal);
		time.setCorUniformeSecundario(corUniformeSecundario);
		
		
		listaTime.add(time);
		
			
		
		
	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		Jogador jogador = new Jogador();
		jogador.setIdid(id);
		jogador.setIdTime(idTime);
		jogador.setNome(nome);
		jogador.setDataNascimento(dataNascimento);
		jogador.setNivelHabilidade(nivelHabilidade);
		jogador.setSalario(salario);
		
		if(listaJogador.stream().filter(jogadoresId -> 
		jogadoresId.getIdid().equals(jogador.getIdid())).findFirst().isPresent()) {
			
			throw new IdentificadorUtilizadoException();
			
		}else {
			
			if(!listaTime.stream().filter(verificarTimeJog -> verificarTimeJog.getIdTime().equals(jogador.getIdTime())).findFirst().isPresent()){
		
			
			throw new TimeNaoEncontradoException();
			
						
		}else {
			
			listaJogador.add(jogador);
			
		}
		
	}
		
		
}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {
		
		
		if(!listaJogador.stream().filter(jogadorExiste -> 
		jogadorExiste.getIdid().equals(idJogador)).findFirst().isPresent()) {
				
			throw new JogadorNaoEncontradoException();
				
				
			}	
		
			Jogador dadosJogador = listaJogador.stream().filter(jogadorDados -> 
			jogadorDados.getIdid().equals(idJogador)).findFirst().get();
			
			
			Time dadosTime= listaTime.stream().filter(timeUser -> 
			timeUser.getIdTime().equals(dadosJogador.getIdTime())).findFirst().get();
			
			dadosTime.setIdJogadorCapitao(idJogador);
			
			
			int posicaoTime = listaTime.indexOf(dadosJogador.getIdTime());
			
			if(posicaoTime != -1) {
				
				
				listaTime.set(posicaoTime, dadosTime);
		
			
		}
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {
		
				
		if(!listaTime.stream().filter(existeTime ->
		existeTime.getIdTime().equals(idTime)).findFirst().isPresent()) {
		
			throw new TimeNaoEncontradoException();
			
		}
			

			Time capitao = listaTime.stream().filter(time ->
			time.getIdTime().equals(idTime)).findFirst().get();
			
			if(capitao.getIdJogadorCapitao()==null){
				throw new CapitaoNaoInformadoException();
				
			}else {
				
				return capitao.getIdJogadorCapitao();
			}
		
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {
		
		if(!listaJogador.stream().filter(findName -> 
		findName.getIdid().equals(idJogador)).findFirst().isPresent()) {
			throw new JogadorNaoEncontradoException();
			
			
		}
			

			Jogador findName = listaJogador.stream().filter(nome -> 
			nome.getIdid().equals(idJogador)).findFirst().get();
			
			return findName.getNome();
				
		
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {
		
		if(!listaTime.stream().filter(findTime ->
		findTime.getIdTime().equals(idTime)).findFirst().isPresent()) {
			throw new TimeNaoEncontradoException();
			
		}
			Time nomeTime = listaTime.stream().filter(time -> 
			time.getIdTime().equals(idTime)).findFirst().get();
			
			return nomeTime.getNomeTime();
		
	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {
		
		if(!listaTime.stream().filter(findTime ->
		findTime.getIdTime().equals(idTime)).findFirst().isPresent()) {
			throw new TimeNaoEncontradoException();
			
		}			

			List<Long> jogadoresId = new ArrayList<>();		
						
			listaJogador.forEach(item ->{
			if(item.getIdTime().equals(idTime)) {
				jogadoresId.add(item.getIdid());
			}	
					
			});
			Collections.sort(jogadoresId);
			return jogadoresId;
				
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {
		
		if(!listaTime.stream().filter(findTime ->
		findTime.getIdTime().equals(idTime)).findFirst().isPresent()) {
			throw new TimeNaoEncontradoException();
			
		}
		Jogador melhor;
		
		melhor = listaJogador.stream().filter(time ->
		time.getIdTime().equals(idTime))
		.max(Comparator.comparing(Jogador::getNivelHabilidade))
		.orElseThrow(NoSuchElementException::new);
					
		return melhor.getIdid();
			
			
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {
		
		if(!listaTime.stream().filter(findTime ->
		findTime.getIdTime().equals(idTime)).findFirst().isPresent()) {
			throw new TimeNaoEncontradoException();
			
			
		}
		Jogador velho;
		
		velho = listaJogador.stream().filter(time ->
		time.getIdTime().equals(idTime))
		.min(Comparator.comparing(Jogador::getDataNascimento))
		.orElseThrow(NoSuchElementException::new);
		
					
		return velho.getIdid();
			
		
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
		

		return listaTime.stream().sorted(Comparator.comparing(Time::getIdTime))
				.map(Time::getIdTime)
				.collect(Collectors.toList());
		
		
	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {

		if(!listaTime.stream().filter(findTime ->
		findTime.getIdTime().equals(idTime)).findFirst().isPresent()) {
			throw new TimeNaoEncontradoException();
			
		}
		Jogador salarioMaior;
		
		salarioMaior = listaJogador.stream().filter(time ->
		time.getIdTime().equals(idTime))
		.max(Comparator.comparing(Jogador::getSalario))
		.orElseThrow(NoSuchElementException::new);
					
		return salarioMaior.getIdid();
	
		
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		
		if(!listaJogador.stream().filter(jogador ->
		jogador.getIdid().equals(idJogador)).findFirst().isPresent()) {
			
			throw new JogadorNaoEncontradoException();
			
		}
		Jogador salario = listaJogador.stream().filter(jogador ->
		jogador.getIdid().equals(idJogador)).findFirst().get();
		
		return salario.getSalario();
	
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {
		
		return listaJogador.stream()
				.sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed()
				.thenComparing(Jogador::getIdid))
				.limit(top).map(Jogador::getIdid)
				.collect(Collectors.toList());
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
		if (!listaTime.stream().anyMatch(time -> time.getIdTime().equals(timeDaCasa))) {
			throw new TimeNaoEncontradoException();
		}
		
		if (!listaTime.stream().anyMatch(time -> time.getIdTime().equals(timeDeFora))) {
			throw new TimeNaoEncontradoException();
		}
		
		Time timeCasa = listaTime.stream().filter(time -> time.getIdTime().equals(timeDaCasa)).findFirst().get();
		Time timeFora = listaTime.stream().filter(time -> time.getIdTime().equals(timeDeFora)).findFirst().get();

		if (timeCasa.getCorUniformePrincipal().equals(timeFora.getCorUniformePrincipal())) {
			return timeFora.getCorUniformeSecundario();
		} else {
			return timeFora.getCorUniformePrincipal();
		}
		
	}

}
