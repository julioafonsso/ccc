package br.com.julios.ccc.infra.bd.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="vale_transporte")
@PrimaryKeyJoinColumn(name="id")
public class ValeTransporteDO extends PagamentoFuncionariosDO {

}
