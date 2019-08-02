package com.jnshu.service;

import com.jnshu.pojo.Student;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.concurrent.TimeoutException;

public interface StudentService {
    List upLoadStudent(@Param("status")Integer status);

    Boolean deleteStudent(@Param("id")Integer id);

    Integer insertStudent(Student student);

    Boolean updateStudent(@Param("id") Integer id,
                          @Param("key") String key,
                          @Param("value") Object value
                         );
}
