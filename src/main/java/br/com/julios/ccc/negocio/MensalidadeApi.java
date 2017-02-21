package br.com.julios.ccc.negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.daos.MensalidadesDAO;
import br.com.julios.ccc.daos.MensalidadesPagasDAO;
import br.com.julios.ccc.daos.MesReferenciaDAO;
import br.com.julios.ccc.domains.FluxoCaixa;
import br.com.julios.ccc.domains.Matricula;
import br.com.julios.ccc.domains.Mensalidades;
import br.com.julios.ccc.domains.MensalidadesPagas;
import br.com.julios.ccc.domains.MesReferencia;
import br.com.julios.ccc.domains.TipoFluxoCaixa;

@Service
public class MensalidadeApi {

	@Autowired
	MatriculaApi matriculaApi;
	
	@Autowired
	MesReferenciaDAO mesDAO;
	
	@Autowired
	MensalidadesPagasDAO mensalidadesPagasDAO;
	
	@Autowired
	MensalidadesDAO mensalidadeDAO;
	
	public void cadastrarMensalidadePaga(Mensalidades mensalidade, FluxoCaixa fluxo) {
		MensalidadesPagas mensalidadePaga = new MensalidadesPagas();

		Matricula matricula = matriculaApi.getMatricula(mensalidade.getMatricula());
		MesReferencia mes = mesDAO.findOne(mensalidade.getMes());

		mensalidadePaga.setFluxoCaixa(fluxo);
		mensalidadePaga.setMatricula(matricula);
		mensalidadePaga.setMesReferencia(mes);

		mensalidadesPagasDAO.save(mensalidadePaga);
		
	}
	
	public List<Mensalidades> getMensalidadesParaPagar(Long idAluno) {
		List<String> situacoes = new ArrayList<String>();
		situacoes.add(Mensalidades.PAGO);
		return mensalidadeDAO.findByAlunoAndSituacaoNotIn(idAluno, situacoes);
	}

	
}
