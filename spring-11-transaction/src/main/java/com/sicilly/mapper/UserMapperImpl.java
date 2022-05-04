package com.sicilly.mapper;

import com.sicilly.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper {

    @Override
    public List<User> selectAllUsers() {
        User user = new User(5, "小王", "666");
        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//      添加、删除用户 我们希望是一组事务
        mapper.addUser(user);
        mapper.deleteUser(5);
        return mapper.selectAllUsers();
    }

    @Override
    public int addUser(User user) {
        return getSqlSession().getMapper(UserMapper.class).addUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return getSqlSession().getMapper(UserMapper.class).deleteUser(id);
    }
}
