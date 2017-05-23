package shop.models.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.models.entity.Admin;

import javax.transaction.Transactional;

@Repository
@Transactional
public class AdminDaoImpl implements AdminDao<Admin, Long> {

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }


    @Override
    public void save(Admin admin) {
        getSession().save(admin);
        return;
    }

    @Override
    public void delete(Admin admin) {
        getSession().delete(admin);
        return;
    }

    @Override
    public Admin getByLoginAndPassword (String login, String password) {
        return (Admin) getSession().createQuery("from Admin where login = :login and password = :password")
                .setParameter("login", login).setParameter("password", password)
                .uniqueResult();
    }

    @Override
    public Admin getById(Long id) {
        return (Admin) getSession().load(Admin.class, id);
    }

    @Override
    public void update(Admin admin) {
        getSession().update(admin);
        return;
    }

}
