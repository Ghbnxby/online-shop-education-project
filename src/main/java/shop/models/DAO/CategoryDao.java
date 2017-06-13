package shop.models.DAO;

import shop.models.entity.Category;
import shop.models.entity.Product;

import java.util.List;


public interface CategoryDao{

    void save(Category entity);

    void delete(Category entity);

    Category getById(long id);

    void update(Category entity);

    List<Product> getProductsbyCategory(Category entity);

    List<Category> listCategorys();
}
