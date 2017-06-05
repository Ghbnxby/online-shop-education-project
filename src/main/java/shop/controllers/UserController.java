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

    /*  **********************        USER            ****************************/

    @RequestMapping({"/loginUser", "/user/loginUser"})
    public String login() {

        return "loginUser";
    }
    @RequestMapping({"/saveUser","/user/saveUser"})
    public String save() {

        return "saveUser";
    }



    @RequestMapping("/user/save")
    public ModelAndView saveUser(@ModelAttribute("user") User user, Map<String, Object> model) {


        if (this.userService.listUser()) {
            this.userService.save(user);
            user = (User) this.userService.getByLoginAndPassword(user.getLogin(), user.getPassword());
            return  new ModelAndView("cabinetUser", "user", user);
        }
        else {
            message = "Администратор уже зарегистрирован, войдите в аккаунт";
            model.put("time", new Date());
            model.put("message", this.message);
            return new ModelAndView("start", "model", model);
        }

    }

    @RequestMapping("/user/login")
    public ModelAndView loginAdmin(@ModelAttribute("user") User user) {

       user = (User) this.userService.getByLoginAndPassword(user.getLogin(), user.getPassword());

        return  new ModelAndView("cabinetUser", "user", user);

    }


    /*  Open data User in viewUser.ftl     */
    @RequestMapping("/user/view")
    public ModelAndView viewUser(long id) {
        User user = (User) this.userService.getById(id);
        return new ModelAndView("viewUser", "user", user);
    }

    @RequestMapping("/user/cabinet")
    public ModelAndView cabinetUser(@ModelAttribute("user") User user) {

         user = (User) this.userService.getById(user.getId());
        return new ModelAndView("cabinetUser", "user", user);
    }

    @RequestMapping("/user/update")
    public ModelAndView updateUser(@ModelAttribute("user") User user, long id) {
        user.setId(id);
        this.userService.update(user);
         user = (User) this.userService.getById(id);

        return  new ModelAndView("cabinetUser", "user", user);

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


    /*  Open data Share in viewShare.ftl     */
    @RequestMapping("/share/view")
    public ModelAndView viewShare(long id) {
        Share share = (Share) this.shareService.getById(id);
        return new ModelAndView("viewShare", "share", share);
    }

    /* This command delete Share by Id and redirect on listShares */
    @RequestMapping("/share/delete")
    public String deleteShare(long id) {
        Share share = (Share) this.shareService.getById(id);
        this.productService.delete(share);
        return "redirect:/share/list";
    }

    /*  Getting Share's list and view  */
    @RequestMapping("/share/list")
    public ModelAndView listShares() {

        List<Share> list = shareService.listShares();
        return new ModelAndView("listShares", "list", list);
    }

    /*  Update Share and redirect on listShares */
    @RequestMapping("/share/edit")
    public String editShare(@ModelAttribute("share") Share share, long id) {
        share.setId(id);
        this.shareService.update(share);
        return "redirect:/share/list";
    }

    /*  Open page addShare.ftl for add to product   */
    @RequestMapping(value = "/share/add")
    public String addShare() {

        return "addShare";
    }

    /*   This command add new Share in database  */
    @RequestMapping(value = "/share/save")
    public String saveShare(@ModelAttribute("share") Share share) {
        if (share.getId() == 0) {
            //new person, add it
            this.shareService.save(share);
        } else {
            //existing person, call update
            this.shareService.update(share);
        }
        return "redirect:/share/list";
    }

}
