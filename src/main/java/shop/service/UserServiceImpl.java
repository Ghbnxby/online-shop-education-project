package shop.service;

import org.springframework.stereotype.Service;
import shop.models.DAO.UserDao;
import shop.models.entity.User;
@Service
public class UserServiceImpl implements UserService<User, Long> {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public void save(User entity) {

        this.userDao.save(entity);
    }

    @Override
    public void delete(User entity) {

        this.userDao.delete(entity);
    }

    @Override
    public User getByLoginAndPassword(String login, String password) {
        return  (User) this.userDao.getByLoginAndPassword(login, password);
    }

    @Override
    public User getById(Long id) {
        return (User) this.userDao.getById(id);
    }

    @Override
    public void update(User entity) {

        this.userDao.update(entity);
    }

    public UserServiceImpl() {}

    public UserServiceImpl(UserDao userDao) {

        setUserDao(userDao);}
}
