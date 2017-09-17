package ar.edu.unlam.tallerweb1.controladores;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

@Controller
public class ControladorSuma {
	
	@RequestMapping("/operacion/valor1/{valor1}/valor2/{valor2}")
	public ModelAndView Sumar(@PathVariable("valor1") int valor1, @PathVariable("valor2") int valor2){
		
		
		
		if(valor1 >= 0 && valor2 >= 0){
			
			int total = valor1 + valor2;
			ModelMap modelo = new ModelMap();
			modelo.put("total",total);
			return new ModelAndView("resultado", modelo);
		}else{
			return new ModelAndView("error");
		}
		
	}

}
