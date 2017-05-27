package shop.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import shop.models.DAO.AdminDao;
import shop.models.DAO.AdminDaoImpl;
import shop.models.entity.Admin;
@Service
public class AdminServiceImpl implements AdminService<Admin, Long> {

    private AdminDao adminDao;

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }
    @Override
    public void save(Admin entity) {

        this.adminDao.save(entity);
    }

    @Override
    public void delete(Admin entity) {

        this.adminDao.delete(entity);
    }

    @Override
    public Admin getByLoginAndPassword(String login, String password) {
        return  (Admin) this.adminDao.getByLoginAndPassword(login, password);
    }

    @Override
    public Admin getById(Long id) {
        return (Admin) this.adminDao.getById(id);
    }

    @Override
    public void update(Admin entity) {

        this.adminDao.update(entity);
    }

    public AdminServiceImpl() {}

    public AdminServiceImpl(AdminDao adminDao) {

        setAdminDao(adminDao);}
}
