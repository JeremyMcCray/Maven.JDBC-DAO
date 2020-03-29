package daos;

import models.Cars;

import java.util.List;

public interface DAO <T> {

    public T findById(int id);
    public List findAll();
    public boolean update(Cars dto);
    public boolean create(Cars dto);
    public void delete(int id);
}
