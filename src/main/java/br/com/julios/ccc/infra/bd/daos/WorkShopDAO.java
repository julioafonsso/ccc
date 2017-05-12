package br.com.julios.ccc.infra.bd.daos;

import org.springframework.data.repository.CrudRepository;

import br.com.julios.ccc.infra.bd.model.WorkShopDO;

public interface WorkShopDAO extends CrudRepository<WorkShopDO, Long> {

}
