package com.mxl.service.impl;

import com.mxl.base.GenericManagerImpl;
import com.mxl.dao.BooksDao;
import com.mxl.domain.Books;
import com.mxl.service.BooksManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "booksManager")
@Transactional
public class BooksManagerImpl extends GenericManagerImpl<Books, Long>
        implements BooksManager {

    BooksDao booksDao;

    @Autowired
    public void setBooksDao(BooksDao booksDao) {
        this.booksDao = booksDao;
        this.dao = booksDao;
    }
}
