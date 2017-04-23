package com.dream9.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by dream9 on 2017/2/19.
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
