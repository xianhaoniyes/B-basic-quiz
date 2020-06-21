package com.thoughtworks.gtb.myquiz.repository;

import com.thoughtworks.gtb.myquiz.exception.NoSuchUserException;
import com.thoughtworks.gtb.myquiz.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserRepo {

    private HashMap<Long, User> userHashMap;

    public UserRepo(){
        userHashMap = new HashMap<>();
        // user0 is only for test use
        User user = new User(1L,"xianhao",25L,"this is xianhao's photo",
                "I heard the echo, from the valleys and the heart " +
                        "Open to the lonely soul of sickle harvesting " +
                        "Repeat outrightly, but also repeat the well-being of " +
                        "Eventually swaying in the desert oasis " +
                        "I believe I am");
        userHashMap.put(1L,user);
    }

    public User putUser(User user){
        user.setUserId(userHashMap.size()+1L);
        userHashMap.put(user.getUserId(),user);
        return user;

    }

    public User getUser(Long userId) throws NoSuchUserException {
        User user = userHashMap.get(userId);
        if(user == null)
            throw new NoSuchUserException();
        return user;

    }

}
