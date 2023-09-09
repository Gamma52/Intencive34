package ru.aston.tarakanov_aa.task4.Dao;

import java.util.List;

public interface DaoDataEntityLayer<T> {
    public List<T> findAll();
    public T findEntityById(long id);
    public boolean delete(long id);
    public boolean create(T t);
    public T update(T t);
}
