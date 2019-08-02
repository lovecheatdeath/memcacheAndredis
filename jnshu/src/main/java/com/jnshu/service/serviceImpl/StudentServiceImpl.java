package com.jnshu.service.serviceImpl;

import com.jnshu.mapper.StudentMapper;
import com.jnshu.pojo.Student;
import com.jnshu.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
@CacheConfig(cacheNames="Student")
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;
//    @Autowired
//    MemcachedClient memcachedClient;


    private static Logger logger = LogManager.getLogger(StudentService.class);


    @Override
    @SuppressWarnings("unchecked")
    @Cacheable
    public List upLoadStudent(@Param("status")Integer status){
        return studentMapper.upLoadStudent(status);
    }
//    public List upLoadStudent(@Param("status")Integer status)throws TimeoutException,InterruptedException,MemcachedException {
//
//        List studentList = new ArrayList<>();
//        if (null == memcachedClient.get("upLoadStudent")) {
//            studentList = studentMapper.upLoadStudent(status);
//            logger.info("first select from mysql");
//            memcachedClient.set("upLoadStudent", 0, studentList);
//            return studentList;
//        } else {
//            logger.info("select data from cache");
//            return (List) memcachedClient.get("upLoadStudent");
//        }
//    }


    @Override
    public Boolean deleteStudent(@Param("id")Integer id){
        return studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer insertStudent(Student student){
        Long createTime=System.currentTimeMillis();
        student.setCreateAt(createTime);
        return studentMapper.insert(student);
    }

    @Override
    public Boolean updateStudent(@Param("id") Integer id,
                                 @Param("key") String key,
                                 @Param("value") Object value
                                 ){
        Long updateTime=System.currentTimeMillis();
        return studentMapper.update(id,key,value,updateTime);
    }

}
