package org.helper.demo.service.impl;

import org.helper.demo.entity.User;
import org.helper.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserServiceImpl implements UserService {
    private static ConcurrentHashMap<Long,User> data = new ConcurrentHashMap() ;
    static{
        User user = new User();
        user.setId(1l);
        user.setName("a");
        user.setAge(5);
        data.put(user.getId(),user);
    }

    @Override
    public List<User> getUserList() {
        Set<Long> ids = data.keySet();
        List<User> result = new ArrayList<>();
        for(Long id: ids){
            result.add(data.get(id));
        }
        return result;
    }

    @Override
    public Long createUser(User user) {
        Long id = generateId();
        user.setId(id);
        data.put(id,user);
        return id;
    }

    @Override
    public User getUser(Long id) {
        return data.get(id);
    }

    @Override
    public User updateUser(Long id, User user) {
        data.put(id,user);
        return data.get(id);
    }

    @Override
    public User deleteUser(Long id) {
        return data.remove(id);
    }


    private synchronized Long generateId() {
        return System.currentTimeMillis();
    }
}
