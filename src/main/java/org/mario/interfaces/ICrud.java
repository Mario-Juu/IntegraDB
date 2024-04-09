package org.mario.interfaces;

import org.mario.model.Contato;

import java.util.List;

public interface ICrud<T> {
    T create(T t);
    T delete(Integer id);
    T getById(Integer id);
    List<T> getAll();
    T update(T t, Integer id);

}
