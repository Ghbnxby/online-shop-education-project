package shop.models.DAO;

import shop.models.entity.Product;

import java.util.List;


public interface CategoryDao<K,T> {

    void save(K entity);

    void delete(K entity);

    K getById(T id);

    void update(K entity);

    List<Product> getProductsbyCategory(K entity);
}
