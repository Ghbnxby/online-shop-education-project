package shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import shop.models.entity.Category;
import shop.models.entity.Product;
import shop.service.CategoryService;
import shop.service.ProductService;

import java.util.List;

@Controller
public class ProductController {


    private ProductService productService;
    private CategoryService categoryService;


    @Autowired(required = true)
    @Qualifier(value = "categoryService")
    public void setProductService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @Autowired(required = true)
    @Qualifier(value = "productService")
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }


    /*  Open data Product in viewProduct.ftl     */
    @RequestMapping("/product/view")
    public ModelAndView viewProduct(long id) {
        Product product = (Product) this.productService.getById(id);
        return new ModelAndView("viewProduct", "product", product);
    }

    /* This command delete Product by Id and redirect on listProducts */
    @RequestMapping("/product/delete")
    public String deleteProduct(long id) {
        Product pr = (Product) this.productService.getById(id);
        this.productService.delete(pr);
        return "redirect:/product/list";
    }

    /*  Getting Product's list and view  */
    @RequestMapping(value = "/product/list")
    public ModelAndView listProducts() {

        List<Product> list = this.productService.listProducts();
        return new ModelAndView("listProducts", "list", list);
    }

    /*  Update Product and redirect on listProducts */
    @RequestMapping(value = "/product/edit", method = RequestMethod.POST)
    public String editProduct(@ModelAttribute("product") Product product, long id) {
        product.setId(id);
        this.productService.update(product);
        return "redirect:/product/list";
    }

    /*  Open page addProduct.ftl for add to product   */
    @RequestMapping(value = "/product/add")
    public ModelAndView addProduct() {

        List<Category> list =  this.categoryService.listCategorys();

        return new ModelAndView("addProduct", "list", list);
    }

    /*   This command add new Product in database  */
    @RequestMapping(value = "/product/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        if (product.getId() == 0) {
            //new person, add it
            this.productService.save(product);
        } else {
            //existing person, call update
            this.productService.update(product);
        }
        return "redirect:/product/list";
    }

}
