package com.zfcraft.web.dao;

import com.zfcraft.web.model.AppLog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogMapper {
    List<AppLog> selectAllCount();

    void insertAllCount(@Param("i") int i, @Param("i1") int i1);

    @Delete("delete from app_log where id = #{id}")
    void delete(AppLog appLog);
}
