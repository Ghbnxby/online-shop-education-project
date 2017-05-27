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
public class CategoryDaoImpl implements CategoryDao<Category, Long> {

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }


    @Override
    public void save(Category category) {
        getSession().save(category);
        return;
    }

    @Override
    public void delete(Category category) {

        getSession().delete(category);
        return;
    }

    @Override
    public Category getById(Long id) {
        return (Category) getSession().load(Category.class, id);
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
}
