package com.example.jhonlp.proyectofinalapp.repository;

import java.util.List;


public interface IBaseRepository<T> {
    Long insert(T entity);

    void update(T entity);

    void delete(T entity);

    List<T> getTorneoDetalle();

    List<T> getById(Long id);
}
