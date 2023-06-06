package com.powernode.mybatis.Mapper;

import com.powernode.mybatis.pojo.Car;

import java.util.List;

/**
 * @Author wen
 * @Data 2023/6/6 0:01
 */
public interface CarMapper {
    //插入汽车信息
    int insert(Car car);
    //根据id删除汽车信息
    int deleteById(long id);
    //修改汽车信息
    int updateById(Car car);
    //根据id查询汽车信息
    int selectById(long id);

    //获取所有汽车信息
    List<Car> selectAll();

}
