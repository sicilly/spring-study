package com.sicilly.mapper;

import com.sicilly.pojo.User;

import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserMapperImpl implements UserMapper{
//  在原来，我们的所有操作都是用sqlSession来执行，现在我们都使用SqlSessionTemplate
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<User> selectAllUsers() {
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        return mapper.selectAllUsers();
    }
}
