package com.jk1091.www.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Copyright (C), 2017-2017, 真知码
 * FileName: Data
 * Author:   jphuang
 * Date:     2017/9/22 14:35
 * Description: 数据表
 */
@lombok.Data
@Entity
public class Data implements  Serializable{
    private static final long serialVersionUID = -306711786619276695L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "remark")
    private String desc;
    private String source;
    private String type;
    private String url;
    @Column(name = "created_at")
    private Date publishedAt;
    @Column(name = "published_at")
    private Date createdAt;

    public Data(String id, String desc, String source, String type, String url, Date publishedAt, Date createdAt) {
        this.id = id;
        this.desc = desc;
        this.source = source;
        this.type = type;
        this.url = url;
        this.publishedAt = publishedAt;
        this.createdAt = createdAt;
    }

    public Data() {
    }
}
