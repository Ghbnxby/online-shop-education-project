package shop.models.DAO;




public interface AdminDao<K,T> {

    void save(K entity);

     void delete(K entity);

     K getByLoginAndPassword (String login, String password);

     K getById(T id);

     void update(K entity);

}
