package com.gyb.dao;

import com.gyb.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @Author gb
 * @Date 2020/7/29 22:01
 * @Version 1.0
 * description:
 */

public interface MemberDao {
    /**
     * create by: gb
     * description: 查询所有会员
     * create time: 2020/7/29 22:02
     *
     * @param id
     * @return
     */
    @Select("select * from member where id=#{id}")
    Member findById(String id);
}
