package mvc.webmvcproducts.web;

import mvc.webmvcproducts.entities.Product;
import mvc.webmvcproducts.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller

public class ProductController {
    @Autowired
    private ProductRepo productRepo;
    @GetMapping("/index")
    public String index(Model model){
        List<Product> products = productRepo.findAll();
        model.addAttribute("products", products);
        return "products";
    }

}
