package br.com.julios.ccc.daos;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.domains.Turma;


@Repository
@Transactional
public interface TurmaDAO extends CrudRepository<Turma, Long> {

	public Turma findByDataInicio(Date datainicial);
	
	public Turma findByDataTermino(Date datatermino);
	
	public Turma findByHorarioInicial(Date horarioinicial);
	
	public Turma findByHorarioFinal(Date horariofinal);
	
	public Turma findByMensalidade(double mensalidade);
	
	public Turma findByVagas(int vagas);
	
}
