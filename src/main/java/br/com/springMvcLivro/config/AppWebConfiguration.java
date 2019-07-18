package br.com.springMvcLivro.config;

import br.com.springMvcLivro.Controllers.HomeController;
import br.com.springMvcLivro.DAO.ProductDAO;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/*
    Classe com o objetivo principal de expor para a Servlet do Spring MVC
    quais são as classes que devem ser lidas e carregadas.
 */

@EnableWebMvc
@ComponentScan(basePackageClasses = {HomeController.class, ProductDAO.class})
public class AppWebConfiguration extends WebMvcConfigurerAdapter {

    // indica para o Spring que o retorno desse método deve ser registrado como um objeto gerenciado pelo container
    @Bean
    public InternalResourceViewResolver
    internalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    // indica para o Spring onde ele deve buscar as mensagens de erros corretas
    @Bean(name="messageSource")
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource bundle = new ReloadableResourceBundleMessageSource();
        bundle.setBasename("/WEB-INF/messages");
        bundle.setDefaultEncoding("UTF-8");
        // indica que o arquivo de mensagens deve ser recarregado a cada intervalo de tempo, no caso, foi configurado apenas um segundo
        bundle.setCacheSeconds(1);
        return bundle;
    }
}