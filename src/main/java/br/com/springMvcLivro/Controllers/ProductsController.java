package br.com.springMvcLivro.Controllers;

import br.com.springMvcLivro.DAO.ProductDAO;
import br.com.springMvcLivro.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Transactional
public class ProductsController {

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping("/produtos")
    public String save(Product product){
        productDAO.save(product);
        System.out.println("Cadastrando o produto " + product);
        return "products/ok";
    }

    @RequestMapping("/produtos/form")
    public String form(){
        return "products/form";
    }
}
