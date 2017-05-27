package shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import shop.models.entity.Admin;
import shop.models.entity.Product;
import shop.models.entity.Share;
import shop.service.AdminService;
import shop.service.ProductService;
import shop.service.ShareService;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    private AdminService adminService;
    private ProductService productService;
    private ShareService shareService;

    @Autowired(required = true)
    @Qualifier(value = "adminService")
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
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

    @GetMapping("/")
    public String start(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", this.message);
        return "start";
    }

    @RequestMapping(value = "/admin/save", method = RequestMethod.POST)
    public ModelAndView saveAdmin(@ModelAttribute("admin") Admin admin) {

        if (admin.getId() == 0) {
            //new person, add it
            this.adminService.save(admin);
        } else {
            //existing person, call update
            this.adminService.update(admin);
        }

        return new ModelAndView("view", "admin", admin);

    }

    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    public ModelAndView loginAdmin(@ModelAttribute("admin") Admin admin) {

        this.adminService.getByLoginAndPassword(admin.getLogin(), admin.getPassword());

        return new ModelAndView("view", "admin", admin);

    }

    @RequestMapping(value = "/product/view", method = RequestMethod.POST)
    public ModelAndView listProducts() {

        List<Product> list = productService.listProducts();
        return new ModelAndView("listProducts", "list", list);

    }

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public ModelAndView saveProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        return new ModelAndView("addProduct", "product", product);
    }

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
