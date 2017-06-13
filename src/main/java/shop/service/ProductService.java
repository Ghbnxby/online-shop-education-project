package shop.service;

import shop.models.entity.Product;

import java.util.List;

/**
 * Created by toshiba_admin on 23.05.2017.
 */
public interface ProductService<K,T> {
    void save(K entity);

    void delete(K entity);

    K getByCode (T code);

    K getByTitle (T title);

    K getById(long id);

    void update(K entity);

    List<K> listProducts();
}
