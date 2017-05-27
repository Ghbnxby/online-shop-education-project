package shop.service;

import shop.models.entity.Product;

import java.util.List;

/**
 * Created by toshiba_admin on 23.05.2017.
 */

public interface CategoryService<K,T> {

    void save(K entity);

    void delete(K entity);

    K getById(T id);

    void update(K entity);

    List<Product> getProductsbyCategory(K entity);
}
