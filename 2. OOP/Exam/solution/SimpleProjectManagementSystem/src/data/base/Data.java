package data.base;

import models.base.IHaveId;

import java.util.List;

public interface Data<T extends IHaveId> {
    void add(T entity);

    List<T> getAll();

    T getById(int id);
}
