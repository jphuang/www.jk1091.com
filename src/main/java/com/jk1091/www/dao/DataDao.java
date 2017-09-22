package com.jk1091.www.dao;

import com.jk1091.www.bean.Data;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Copyright (C), 2017-2017, 真知码
 * FileName: DataDao
 * Author:   jphuang
 * Date:     2017/9/22 14:41
 * Description: 数据Dao
 */
public interface DataDao extends JpaRepository<Data, Long> {
}
