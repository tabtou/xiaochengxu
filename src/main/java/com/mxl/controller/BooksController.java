package com.mxl.controller;

import com.mxl.base.GenericController;
import com.mxl.domain.Books;
import com.mxl.service.BooksManager;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books/")
@Api("订单管理接口")
public class BooksController extends
        GenericController<Books, Long, BooksManager> {

    BooksManager booksManager;

    @Autowired
    public void setBooksManager(BooksManager booksManager) {
        this.booksManager = booksManager;
        this.manager = booksManager;
    }
}
