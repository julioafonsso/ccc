package br.com.julios.ccc.negocio;

import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.model.DescontosDO;

@Service
public class DescontosApi {
	
//	@Autowired
//	DescontosDAO descontosDAO;
//	
	public Iterable<DescontosDO> getdescontos() {
		return null;	
//		return descontosDAO.findByDataExclusaoIsNull();
}

	public void cadastrar(DescontosDO desconto) {
//		descontosDAO.save(desconto);
	}

	public DescontosDO getdesconto(Long id) {
//		return descontosDAO.findOne(id);
		return null;
	}

	public void alterar(DescontosDO desconto) {
//		descontosDAO.save(desconto);
	}

	public void validaExisteDescontoMatriculaAtiva(DescontosDO desconto) throws Exception {
//		if(!desconto.getMatriculas().isEmpty())
//			throw new Exception("Desconto não pode ser excluido! \n Existe matriculas com esse desconto!");
		
	}

	public void deletar(DescontosDO desconto) {
//		desconto.setDataExclusao(new Date());
//		descontosDAO.save(desconto);
	}

}
