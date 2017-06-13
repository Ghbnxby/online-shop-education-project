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

import java.util.List;

@Controller
public class CategoryController {

    private CategoryService categoryService;


    @Autowired(required = true)
    @Qualifier(value = "categoryService")
    public void setProductService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    /*  Open data Category in viewCategory.ftl     */
    @RequestMapping("/category/view")
    public ModelAndView viewCategory(long id) {
        Category category = (Category) this.categoryService.getById(id);
        return new ModelAndView("viewCategory", "category", category);
    }

    /* This command delete Category by Id and redirect on listCategorys */
    @RequestMapping("/category/delete")
    public String deleteCategory(long id) {
        Category category = (Category) this.categoryService.getById(id);
        this.categoryService.delete(category);
        return "redirect:/category/list";
    }

    /*  Getting Category's list and view  */
    @RequestMapping(value = "/category/list")
    public ModelAndView listCategorys() {

        List<Category> list = categoryService.listCategorys();
        return new ModelAndView("listCategory", "list", list);
    }

    /*  Update Category and redirect on listCategorys */
    @RequestMapping(value = "/category/edit", method = RequestMethod.POST)
    public String editCategory(@ModelAttribute("category") Category category, long id) {
        category.setId(id);
        this.categoryService.update(category);
        return "redirect:/category/list";
    }

    /*  Open page addCategory.ftl for add to category   */
    @RequestMapping(value = "/category/add")
    public String addCategory() {

        return "addCategory";
    }

    /*   This command add new Category in database  */
    @RequestMapping(value = "/category/save")
    public String saveCategory(@ModelAttribute("category") Category category) {
        if (category.getId() == 0) {
            //new person, add it
            this.categoryService.save(category);
        } else {
            //existing person, call update
            this.categoryService.update(category);
        }
        return "redirect:/category/list";
    }

}
