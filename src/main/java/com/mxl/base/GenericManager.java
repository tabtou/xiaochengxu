package com.mxl.base;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public interface GenericManager<T extends BaseEntityModel, PK extends Serializable> {
    Page<T> findAll(Pageable var1);

    List<T> findAll();

    Page<T> findAll(Specification<T> var1, Pageable var2);

    List<T> findAll(Specification<T> var1, Sort var2);

    List<T> findAll(Specification<T> var1);

    List<T> findAll(Example<T> var1);

    List<T> findAll(Example<T> var1, Sort var2);

    Page<T> findAll(Example<T> var1, Pageable var2);

    T findById(PK var1);

    T save(T var1);

    List<T> save(Iterable<T> var1);

    void delete(PK var1);

    void deleteInBatch(Iterable<T> var1);
}