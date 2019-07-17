package br.com.springMvcLivro.config;

import br.com.springMvcLivro.Controllers.HomeController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/*
    Classe com o objetivo principal de expor para a Servlet do Spring MVC
    quais são as classes que devem ser lidas e carregadas.
 */

@EnableWebMvc
@ComponentScan(basePackageClasses = {HomeController.class})
public class AppWebConfiguration {
}