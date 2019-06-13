package bbs.xqdxc.dao;

import bbs.xqdxc.model.UserDomain;

import java.util.List;

public interface UserDao {

    int insert(UserDomain record);

    List<UserDomain> selectUsers();
}
