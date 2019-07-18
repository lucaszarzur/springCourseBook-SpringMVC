package br.com.springMvcLivro.Controllers;

import br.com.springMvcLivro.DAO.ProductDAO;
import br.com.springMvcLivro.models.Price;
import br.com.springMvcLivro.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Transactional
public class ProductsController {

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping("/produtos")
    public ModelAndView list(){
        ModelAndView modelAndView =
                new ModelAndView("products/list");
        modelAndView.addObject("products", productDAO.list());
        return modelAndView;
    }

    @RequestMapping("/produtos")
    public String save(Product product){
        productDAO.save(product);
        System.out.println("Cadastrando o produto " + product);
        return "products/ok";
    }

    @RequestMapping("/produtos/form")
    public String form(Model model){
        model.addAttribute("types", Price.BookType.values());
        return "products/form";
    }
}
