package com.mxl.domain;
;
import com.mxl.base.BaseEntityModel;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * Created by topcom on 2017/7/4 0004.
 */
@Entity
@Table(name = "t_books")
@EntityListeners({AuditingEntityListener.class})
public class Books extends BaseEntityModel {



    @Column(name = "addr")
    private String addr;

    /**
     * 拼音
     */
    @Column(name = "name")
    private String name;


    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
