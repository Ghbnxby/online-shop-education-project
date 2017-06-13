package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.models.DAO.ShareDao;
import shop.models.entity.Share;

import java.util.List;

@Service
public class ShareServiceImpl implements ShareService<Share,Long> {

    @Autowired
    private ShareDao shareDao;

    public void setShareDao(ShareDao shareDao) {
        this.shareDao = shareDao;
    }

    @Override
    public void save(Share entity) {
        this.shareDao.save(entity);
    }

    @Override
    public void delete(Share entity) {
        this.shareDao.delete(entity);

    }

    @Override
    public Share getById(Long id) {
        return (Share) this.shareDao.getById(id);
    }

    @Override
    public void update(Share entity) {
        this.shareDao.update(entity);

    }

    @Override
    public List<Share> listShares() {
        return (List<Share>) this.shareDao.listShare();
    }

    public ShareServiceImpl() {}
    public ShareServiceImpl(ShareDao shareDao) {
        setShareDao(shareDao);
    }
}
