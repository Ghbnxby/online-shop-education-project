package shop.models.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.models.entity.User;

import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao<User, Long> {

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }


    @Override
    public void save(User user) {
        getSession().save(user);
        return;
    }

    @Override
    public void delete(User user) {
        getSession().delete(user);
        return;
    }

    @Override
    public User getByLoginAndPassword (String login, String password) {
        return (User) getSession().createQuery("from User where login = :login and password = :password")
                .setParameter("login", login).setParameter("password", password)
                .uniqueResult();
    }

    @Override
    public User getById(Long id) {
        return (User) getSession().load(User.class, id);
    }

    @Override
    public void update(User user) {
        getSession().update(user);
        return;
    }

}
