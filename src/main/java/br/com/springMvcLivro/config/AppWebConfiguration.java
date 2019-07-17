package br.com.springMvcLivro.config;

import br.com.springMvcLivro.Controllers.HomeController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/*
    Classe com o objetivo principal de expor para a Servlet do Spring MVC
    quais são as classes que devem ser lidas e carregadas.
 */

@EnableWebMvc
@ComponentScan(basePackageClasses = {HomeController.class})
public class AppWebConfiguration {

    // indica para o Spring que o retorno desse método deve ser registrado como um objeto gerenciado pelo container
    @Bean
    public InternalResourceViewResolver
    internalResourceViewResolver() {
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

}