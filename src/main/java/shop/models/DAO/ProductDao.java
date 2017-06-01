package shop.models.DAO;

import shop.models.entity.Product;

import javax.transaction.Transactional;
import java.util.List;


public interface ProductDao{

    void save(Product entity);

    void delete(Product entity);

    Product getByCode (String code);

    Product getByTitle (String title);

    Product getById(long id);

    void update(Product entity);

    List<Product> listProducts();



}
