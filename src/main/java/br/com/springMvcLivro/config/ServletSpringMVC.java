package br.com.springMvcLivro.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
    Responsável por tratar todas as requisições que chegam para o Spring MVC.
    Essa classe é a DispatcherServlet, essencial para receber requisições web.
*/

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    // Indica quais outras classes devem ser lidas durante o carregamento da aplicação web
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppWebConfiguration.class, JPAConfiguration.class};
    }

    // Especifica padrão de endereço que vai ser delegado para o Servlet do Spring MVC
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}