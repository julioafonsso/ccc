package br.com.julios.ccc;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.com.julios.ccc.domains.FluxoCaixa;
import br.com.julios.ccc.domains.TipoFluxoCaixa;
import br.com.julios.ccc.domains.Usuario;
import br.com.julios.ccc.negocio.FluxoCaixaApi;
import br.com.julios.ccc.negocio.TipoFluxoCaixaApi;
import br.com.julios.ccc.negocio.UsuarioApi;

@SpringBootApplication
@Controller
@RequestMapping("/")
public class Application extends SpringBootServletInitializer{

	@Autowired 
	UsuarioApi usuarioAPI;
	
	@Autowired
	FluxoCaixaApi fluxoAPI;
	
	@Autowired
	TipoFluxoCaixaApi tipoFluxo;

	@Bean
	 public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**/*").allowedMethods("GET", "POST","DELETE", "POST").allowedOrigins("http://localhost:4200");
            }
        };
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
        
    }

    
    
    
    @RequestMapping("fluxo")
    public void cargaFluxos()
    {
    	Usuario user = usuarioAPI.getUsuarios().iterator().next();
    	Date data = new Date("01/01/2010");
    	
    	List<TipoFluxoCaixa> fluxos = new ArrayList<TipoFluxoCaixa>();
    	
    	Iterable<TipoFluxoCaixa> iFluxos = tipoFluxo.getTipoFluxoCaixa();
    	
    	for (TipoFluxoCaixa tipoFluxoCaixa : iFluxos) {
			fluxos.add(tipoFluxoCaixa);
		}
    	
    	Random r = new Random();
    	
    	
    	for (int i=0; i<3000; i++)
    	{
    		Calendar c = Calendar.getInstance();
        	c.setTime(data);
        	c.add(Calendar.DATE, 1);
        	data = c.getTime();
        	
        	for(int j = 0;j<3; j++){
        		TipoFluxoCaixa tipo = fluxos.get(r.nextInt(fluxos.size()));
            	
            	FluxoCaixa fl = new FluxoCaixa();
            	
            	Double valor = r.nextDouble()* 100;
            	
            	
            	fl.setDataFluxo(data);
            	fl.setDescricao(tipo.getNome());
            	fl.setValor(valor);
            	fl.setTipoFluxo(tipo);
            	
            	fluxoAPI.cadastrarFluxoCaixa(fl);
            	
        	}
        	
        		
    	}
    	
    }
    
}
