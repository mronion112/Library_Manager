package org.example.library_management_backend.Model.Repository;

import org.example.library_management_backend.Model.Entity.Book;

import java.util.List;

public interface EntityRepository<T> {

    public T saveEntity(T entity);

    public T getEntityById(int Id);

    public void deleteEntityById(int Id);

    public List<T> getAllEntity();


}
