package shop.service;

/**
 * Created by toshiba_admin on 23.05.2017.
 */
public interface AdminService<K,T> {

    void save(K entity);

    void delete(K entity);

    K getByLoginAndPassword (String login, String password);

    K getById(T id);

    void update(K entity);
}
