package shop.service;

import org.springframework.stereotype.Service;
import shop.models.DAO.CategoryDao;
import shop.models.entity.Category;
import shop.models.entity.Product;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService<Category, Long> {

    private CategoryDao categoryDao;

    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public void save(Category entity) {

        this.categoryDao.save(entity);

    }

    @Override
    public void delete(Category entity) {
        this.categoryDao.delete(entity);

    }

    @Override
    public Category getById(Long id) {
        return (Category) this.categoryDao.getById(id);
    }

    @Override
    public void update(Category entity) {
        this.categoryDao.update(entity);

    }

    @Override
    public List<Product> getProductsbyCategory(Category entity) {
        return (List<Product>) this.categoryDao.getProductsbyCategory(entity);
    }
}
