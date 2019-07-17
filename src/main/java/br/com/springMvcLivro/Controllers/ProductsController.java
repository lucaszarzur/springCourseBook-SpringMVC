package br.com.springMvcLivro.Controllers;

import br.com.springMvcLivro.models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductsController {

    @RequestMapping("/produtos")
    public String save(Product product){
        System.out.println("Cadastrando o produto " + product);
        return "products/ok";
    }

    @RequestMapping("/produtos/form")
    public String form(){
        return "products/form";
    }
}
