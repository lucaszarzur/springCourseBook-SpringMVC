package br.com.springMvcLivro.config;

import br.com.springMvcLivro.FileSaver;
import br.com.springMvcLivro.controllers.HomeController;
import br.com.springMvcLivro.DAO.ProductDAO;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/*
    Classe com o objetivo principal de expor para a Servlet do Spring MVC
    quais são as classes que devem ser lidas e carregadas.
*/

@EnableWebMvc
@ComponentScan(basePackageClasses = {HomeController.class, ProductDAO.class, FileSaver.class})
public class AppWebConfiguration extends WebMvcConfigurerAdapter {


    @Bean // -> indica para o Spring que o retorno desse método deve ser registrado como um objeto gerenciado pelo container
    public InternalResourceViewResolver internalResourceViewResolver() {
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

    // formatador do Spring para data
    @Bean
    public FormattingConversionService mvcConversionService() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(true);
        DateFormatterRegistrar registrar = new DateFormatterRegistrar();
        registrar.setFormatter(new DateFormatter("yyyy-MM-dd"));
        registrar.registerFormatters(conversionService);

        return conversionService;
    }

    // provem uma implementação dessa interface para que o Spring MVC possa fazer seu trabalho
    @Bean
    public MultipartResolver multipartResolver(){
        return new StandardServletMultipartResolver();
    }
}