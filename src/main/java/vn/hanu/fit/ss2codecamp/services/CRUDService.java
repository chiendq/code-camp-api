package vn.hanu.fit.ss2codecamp.services;

import java.util.List;

public interface CRUDService<T> {
    List<T> getAll();

    T getById(int id);

    void deleteById(int id);

    T updateById(int id, T t);

    T save(T t);
}
