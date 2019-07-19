package br.com.springMvcLivro.controllers;

import br.com.springMvcLivro.DAO.ProductDAO;
import br.com.springMvcLivro.infra.FileSaver;
import br.com.springMvcLivro.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@Transactional
@RequestMapping("/produtos")
public class ProductsController {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private FileSaver fileSaver;

    /* Indica para o Spring que esse método deve ser chamado sempre que um request cair na controller em questão.
       Utilizado para validações */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        // não precisa por enquanto, utilizaremos os padroes do Hibernate
        //binder.setValidator(new ProductValidator());
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("products/list");
        modelAndView.addObject("products", productDAO.list());

        return modelAndView;
    }

    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView save(MultipartFile summary, @Valid Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return form(product);
        }

        // webPath = caminho onde arquivo será salvo
        String webPath = fileSaver.write("uploaded-images",summary);
        product.setSummaryPath(webPath);
        productDAO.save(product);

        redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso");
        return new ModelAndView("redirect:produtos");
    }

    @RequestMapping("/form")
    public ModelAndView form(@ModelAttribute Product product){
        ModelAndView modelAndView = new ModelAndView("products/form");
        //modelAndView.addObject("bookTypes", Price.BookType.values());

        return modelAndView;
    }
}
