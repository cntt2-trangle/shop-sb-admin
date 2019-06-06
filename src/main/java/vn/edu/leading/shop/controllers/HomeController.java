package vn.edu.leading.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.edu.leading.shop.services.CategoryService;
import vn.edu.leading.shop.services.ProductService;
import vn.edu.leading.shop.services.SupplierService;

@Controller
public class HomeController {
    public final CategoryService categoryService;

    private final SupplierService supplierService;

    private final ProductService productService;

    public HomeController(CategoryService categoryService, SupplierService supplierService, ProductService productService) {
        this.categoryService = categoryService;
        this.supplierService = supplierService;
        this.productService = productService;
    }

    @GetMapping("/")
    public String home (Model model){
        model.addAttribute("products", productService.findAll());
        model.addAttribute("categories",categoryService.findAll());
        model.addAttribute("supplier",supplierService.findAll());
        return "home/category";
    }
}
