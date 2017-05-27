package shop.models.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.models.entity.Product;
import shop.models.entity.Share;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ShareDaoImpl implements ShareDao<Share, Long> {

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }


    @Override
    public void save(Share share) {
        getSession().save(share);
        return;
    }

    @Override
    public void delete(Share share) {

        getSession().delete(share);
        return;
    }

    @Override
    public Share getById(Long id) {
        return (Share) getSession().load(Share.class, id);
    }

    @Override
    public void update(Share share) {

        getSession().update(share);
        return;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Share> listShare() {

        return  getSession().createQuery("from Share").list();

    }
}
