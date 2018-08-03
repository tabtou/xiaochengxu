package com.mxl.base;


import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class GenericController<T extends BaseEntityModel, PK extends Serializable, M extends GenericManager<T, PK>> extends BaseController {
    protected M manager;
    protected PK id;
    protected T model;
    protected Page<T> page;
    protected int pageNumber = 0;
    protected int pageSize = 20;
    protected Pageable pageable;

    public GenericController() {
        this.pageable = new PageRequest(this.pageNumber, this.pageSize, new Sort(Direction.ASC, new String[]{"id"}));
    }

    @RequestMapping(
            value = {"/"},
            method = {RequestMethod.POST},
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    @ResponseBody
    public T create(@RequestBody T model) throws Exception {
        Date date = new Date();
        model.setDateCreated(date);
        model.setDateModified(date);
        model = this.manager.save(model);
        return model;
    }

    @RequestMapping(
            value = {"/{id}"},
            method = {RequestMethod.DELETE},
            produces = {"application/json"}
    )
    @ResponseBody
    public void delete(@PathVariable PK id) throws IOException {
        this.manager.delete(id);
    }

    @RequestMapping(
            value = {"/"},
            method = {RequestMethod.DELETE},
            produces = {"application/json"}
    )
    @ResponseBody
    public void deleteInBatch(@RequestBody List<T> entities) throws IOException, IllegalAccessException, InstantiationException {
        this.manager.deleteInBatch(entities);
    }

    @RequestMapping(
            value = {"/"},
            method = {RequestMethod.GET},
            produces = {"application/json"}
    )
    @ResponseBody
    public Page<T> get(HttpServletRequest request, HttpServletResponse response) {
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        int pageNumber = 0;
        if (StringUtils.isNotBlank(page)) {
            pageNumber = Integer.valueOf(page) - 1;
        }

        int pageSize = 20;
        if (StringUtils.isNotBlank(limit)) {
            pageSize = Integer.valueOf(limit);
        }

        Pageable pageable = new PageRequest(pageNumber, pageSize, new Sort(Direction.DESC, new String[]{"id"}));
        return this.manager.findAll(pageable);
    }

    @RequestMapping(
            value = {"/{id}"},
            method = {RequestMethod.GET},
            produces = {"application/json"}
    )
    @ResponseBody
    public T get(@PathVariable PK id) {
        return this.manager.findById(id);
    }

    @RequestMapping(
            value = {"/{id}"},
            method = {RequestMethod.PUT},
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    @ResponseBody
    public T update(@PathVariable PK id, @RequestBody T model) {
        model.setId(Long.valueOf(id.toString()));
        model.setDateModified(new Date());
        model = this.manager.save(model);
        return model;
    }
}

