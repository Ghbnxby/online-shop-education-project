package shop.models.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.models.entity.Product;
import shop.models.entity.User;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    private Session session;

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {

        session = _sessionFactory.getCurrentSession();
        return session;

    }


    @Override
    public void save(User user) {
        getSession().save(user);
        return;
    }

    @Override
    public void delete(User user) {
        session.close();
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
    public User getById(long id) {
        return  getSession().<User>load(User.class, id);
    }

    public User getUserByLogin(String login) {
        return (User) getSession().createQuery("from User where login = :login")
                .setParameter("login", login)
                .uniqueResult();
    }
    @Override
    public void update(User user) {
        getSession().update(user);
        return;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean listUser() {
        List<User> users = getSession().createQuery("from User").list();
        if (users.size()==0) {
            return true;
        } else {
            return false; }

          }

}
