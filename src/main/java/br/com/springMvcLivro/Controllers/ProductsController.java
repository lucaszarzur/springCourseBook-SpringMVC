package br.com.springMvcLivro.Controllers;

import br.com.springMvcLivro.DAO.ProductDAO;
import br.com.springMvcLivro.models.Price;
import br.com.springMvcLivro.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Transactional
@RequestMapping("/produtos")
public class ProductsController {

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("products/list");
        modelAndView.addObject("products", productDAO.list());

        return modelAndView;
    }

    @RequestMapping(method=RequestMethod.POST)
    public String save(Product product, RedirectAttributes redirectAttributes) {
        productDAO.save(product);
        redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso");

        return "redirect:produtos";
    }

    @RequestMapping("/form")
    public String form(Model model) {
        model.addAttribute("types", Price.BookType.values());

        return "products/form";
    }
}
