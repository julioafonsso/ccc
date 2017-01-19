package br.com.julios.ccc.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.julios.ccc.domains.Mensalidades;

public interface MensalidadesDAO extends JpaRepository<Mensalidades, Long>{
	
	public List<Mensalidades> findByAlunoAndSituacaoNotIn(Long aluno, List<String> situacoes);

}
