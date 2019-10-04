package com.ischoolbar.programmer.dao;

import com.ischoolbar.programmer.entity.RoomType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RoomTypeDao {
    public int add(RoomType roomType);
    public int edit(RoomType roomType);
    public int delete(Long id);
    public List<RoomType> findList(Map<String,Object> queryMap);
    public List<RoomType> findAll();
    public Integer getTotal(Map<String, Object> queryMap);
    public RoomType find(Long id);
    public int updateNum(RoomType roomType);
}
