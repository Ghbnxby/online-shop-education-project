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
import java.util.*;

@Controller
public class UserController {

    private UserService userService;


    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }






    @RequestMapping("/")
    public String start(Model model) {

        return "start";
    }

    @RequestMapping("/login?error")
    public String error(Model model) {

        return "error";
    }

    /*  **********************        USER            ****************************/

    @RequestMapping({"/saveUser","/user/saveUser"})
    public String save() {

        return "saveUser";
    }



    @RequestMapping("/user/save")
    public ModelAndView saveUser(@ModelAttribute("user") User user, Map<String, Object> model) {



            this.userService.save(user);
            user = (User) this.userService.getByLoginAndPassword(user.getLogin(), user.getPassword());
            return  new ModelAndView("cabinetUser", "user", user);



    }



//    @RequestMapping("/user/login")
//    public ModelAndView loginAdmin(@ModelAttribute("user") User user) {
//
//       user = (User) this.userService.getByLoginAndPassword(user.getLogin(), user.getPassword());
//
//        return  new ModelAndView("cabinetUser", "user", user);
//
//    }


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







}
