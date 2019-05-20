package com.deppatori.mysuperapp.restservice;

import com.deppatori.mysuperapp.model.User;
import com.deppatori.mysuperapp.service.BaseService;
import com.deppatori.mysuperapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.Path;

@Service
@Path("/api/v2/users")
public class RestUserService extends RestBaseService<User>{

    @Autowired
    private UserService userService;

    @Override
    public BaseService<User> getService() {
        return userService;
    }
}
