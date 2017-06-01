package shop.models.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.models.entity.Category;
import shop.models.entity.Product;
import shop.models.entity.Share;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao{

    private Session session;
    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        session = _sessionFactory.getCurrentSession();
        return session;
    }

    @Override
    public void save(Product product) {
        getSession().save(product);
        return;
    }

    @Override
    public void delete(Product product) {
        session.close();
        getSession().delete(product);
        return;
    }

    @Override
    public Product getByCode(String code) {

        return (Product) getSession().createQuery("from Products where code = :code")
                .setParameter("code", code)
                .uniqueResult();
    }

    @Override
    public Product getByTitle(String title) {
        return (Product) getSession().createQuery("from Products where title = :title")
                .setParameter("title", title)
                .uniqueResult();
    }


    @Override
    public Product getById(long id) {
        return getSession().<Product>load(Product.class, id);
    }


    @Override
    public void update(Product entity) {

        getSession().update(entity);
        return;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> listProducts() {

        return  getSession().createQuery("from Product").list();

    }



}
