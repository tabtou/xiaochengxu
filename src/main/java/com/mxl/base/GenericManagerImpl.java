package com.mxl.base;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class GenericManagerImpl<T extends BaseEntityModel, PK extends Serializable> implements GenericManager<T, PK> {
    protected GenericDao<T, PK> dao;

    public GenericManagerImpl() {
    }

    public Page<T> findAll(Pageable page) {
        return this.dao.findAll(page);
    }

    public Page<T> findAll(Specification<T> specification, Pageable pageable) {
        return this.dao.findAll(specification, pageable);
    }

    public List<T> findAll(Specification<T> specification, Sort sort) {
        return this.dao.findAll(specification, sort);
    }

    public List<T> findAll(Specification<T> specification) {
        return this.dao.findAll(specification);
    }

    public List<T> findAll(Example<T> example) {
        return this.dao.findAll(example);
    }

    public List<T> findAll(Example<T> example, Sort sort) {
        return this.dao.findAll(example, sort);
    }

    public Page<T> findAll(Example<T> example, Pageable pageable) {
        return this.dao.findAll(example, pageable);
    }

    public T findById(PK id) {
        return (T) this.dao.findOne(id);
    }

    public T save(T entity) {
        Date date = new Date();
        Long id = entity.getId();
        if (id == null) {
            entity.setDateCreated(date);
        } else {
            entity.setDateModified(date);
        }

        return (T) this.dao.saveAndFlush(entity);
    }

    public List<T> save(Iterable<T> entities) {
        return this.dao.save(entities);
    }

    public List<T> findAll() {
        return this.dao.findAll();
    }

    public void delete(PK id) {
        this.dao.delete(id);
    }

    public void deleteInBatch(Iterable<T> entities) {
        this.dao.deleteInBatch(entities);
    }
}

