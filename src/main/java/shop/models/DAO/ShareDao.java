package shop.models.DAO;


import java.util.List;

public interface ShareDao<K,T> {
    void save(K entity);

    void delete(K entity);

    K getById(T id);

    void update(K entity);
    List<K> listShare();
}
