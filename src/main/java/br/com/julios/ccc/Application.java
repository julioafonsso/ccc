package br.com.julios.ccc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.daos.ProfessorDAO;
import br.com.julios.ccc.domains.Professor;

@SpringBootApplication
//@EnableAutoConfiguration
@Controller
public class Application {

	@Autowired
	ProfessorDAO pDAO;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
    
    @RequestMapping("/find/{id}")
    @ResponseBody
    public Professor get(@PathVariable("id") int id){
    	return pDAO.findOne(id);
    	
    }
    @RequestMapping("/teste")
    @ResponseBody
    public void save(){
    	Professor p = new Professor();
    	
    	p.setCpf(1231);
    	p.setNome("Julio");
    	p.setEmail("julioafonsso@gmail.com");
    	
    	pDAO.save(p);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}
