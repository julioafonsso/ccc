package br.com.julios.ccc.daos;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.domains.DiasSemana;

@Repository
@Transactional
public interface DiasSemanaDAO extends CrudRepository<DiasSemana, Long>{
	
	public DiasSemana findOne(Long id);
	
	public DiasSemana findByDias(String dias);

}
