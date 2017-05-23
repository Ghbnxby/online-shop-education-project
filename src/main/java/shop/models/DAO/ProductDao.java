package shop.models.DAO;



public interface ProductDao<K,T> {

    void save(K entity);

    void delete(K entity);

    K getByCode (T code);

    K getByTitle (T title);

    K getById(long id);

    void update(K entity);



}
