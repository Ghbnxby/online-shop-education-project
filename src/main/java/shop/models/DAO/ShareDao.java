package shop.models.DAO;


import shop.models.entity.Share;

import java.util.List;

public interface ShareDao {
    void save(Share entity);

    void delete(Share entity);

    Share getById(long id);

    void update(Share entity);
    List<Share> listShare();
}
