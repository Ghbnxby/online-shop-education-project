package shop.models.DAO;


import shop.models.entity.User;

public interface UserDao {

    void save(User entity);

     void delete(User entity);

     User getByLoginAndPassword (String login, String password);

     User getById(long id);

     void update(User entity);

     boolean listUser();

}
