package com.mxl.base;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericDao<T extends BaseEntityModel, PK extends Serializable> extends JpaRepository<T, PK>, JpaSpecificationExecutor<T> {
}