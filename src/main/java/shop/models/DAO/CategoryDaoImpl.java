package shop.models.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.models.entity.Category;
import shop.models.entity.Product;
import javax.transaction.Transactional;

import java.util.List;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {

    private Session session;
    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        session = _sessionFactory.getCurrentSession();
        return session;
    }


    @Override
    public void save(Category category) {
        getSession().save(category);
        return;
    }

    @Override
    public void delete(Category category) {
        session.close();
        getSession().delete(category);
        return;
    }

    @Override
    public Category getById(long id) {
        return  getSession().<Category>load(Category.class, id);
    }

    @Override
    public void update(Category category) {

        getSession().update(category);
        return;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> getProductsbyCategory(Category category) {
       return  (List<Product>)  getSession().createQuery("from Product where category = :category")
                .setParameter("category", category).list();

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Category> listCategorys() {

        return  getSession().createQuery("from Category").list();

    }

}
