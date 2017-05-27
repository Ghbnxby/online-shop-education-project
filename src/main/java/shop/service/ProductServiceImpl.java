package shop.service;

import org.springframework.stereotype.Service;
import shop.models.DAO.ProductDao;
import shop.models.entity.Product;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService<Product, String> {

    private ProductDao productDao;

    public  void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void save(Product entity) {

        this.productDao.save(entity);
    }

    @Override
    public void delete(Product entity) {

        this.productDao.delete(entity);
    }

    @Override
    public Product getByCode(String code) {
        return (Product) this.productDao.getByCode(code);
    }

    @Override
    public Product getByTitle(String title) {
        return (Product) this.productDao.getByTitle(title);
    }

    @Override
    public Product getById(long id) {
        return (Product) this.productDao.getById(id);
    }

    @Override
    public void update(Product entity) {

        this.productDao.update(entity);
    }

    @Override
    public List<Product> listProducts() {
        return (List<Product>) this.productDao.listProducts();

    }

    public ProductServiceImpl(){}
    public ProductServiceImpl(ProductDao productDao) {
        setProductDao(productDao);
    }
}
