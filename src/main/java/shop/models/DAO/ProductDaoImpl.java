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
public class ProductDaoImpl implements ProductDao<Product,String> {

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    @Override
    public void save(Product product) {
        getSession().save(product);
        return;
    }

    @Override
    public void delete(Product product) {
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
        return (Product) getSession().load(Product.class, id);
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
