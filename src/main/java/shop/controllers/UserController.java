package shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import shop.models.entity.User;
import shop.models.entity.Product;
import shop.models.entity.Share;
import shop.service.UserService;
import shop.service.ProductService;
import shop.service.ShareService;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    private UserService userService;
    private ProductService productService;
    private ShareService shareService;

    @Autowired(required = true)
    @Qualifier(value = "adminService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired(required = true)
    @Qualifier(value = "productService")
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired(required = true)
    @Qualifier(value = "shareService")
    public void setShareService(ShareService shareService) {
        this.shareService = shareService;
    }



    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @RequestMapping("/")
    public String start(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", this.message);
        return "start";
    }

    @RequestMapping("/loginUser")
    public String login() {

        return "loginUser";
    }
    @RequestMapping("/saveUser")
    public String save() {

        return "saveUser";
    }

    @RequestMapping("/user/view")
    public ModelAndView userView(Long idUser) {
        User user = (User)this.userService.getById(idUser);
        return new ModelAndView("viewUser", "user", user);
    }

    @RequestMapping("/user/save")
    public ModelAndView saveUser(@ModelAttribute("user") User user) {

        if (user.getId() == 0) {
            //new person, add it
            this.userService.save(user);
        } else {
            //existing person, call update
            this.userService.update(user);
        }

        return new ModelAndView("viewUser", "user", user);

    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public ModelAndView loginAdmin(@ModelAttribute("user") User user) {

        this.userService.getByLoginAndPassword(user.getLogin(), user.getPassword());

        return new ModelAndView("viewUser", "user", user);

    }


    /*  **********************        PRODUCTS            ****************************/

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

        List<Product> list = productService.listProducts();
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
    public String addProduct() {

        return "addProduct";
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


    /*       *******************      SHARE      ***************************/


    @RequestMapping(value = "/share/view", method = RequestMethod.POST)
    public ModelAndView listShare() {
        List<Share> list = shareService.listShares();
        return new ModelAndView("listShares", "list", list);
    }

    @RequestMapping(value = "/share/add", method = RequestMethod.POST)
    public ModelAndView saveShare(@ModelAttribute("share") Share share) {
        productService.save(share);
        return new ModelAndView("addShare", "share", share);
    }


}
