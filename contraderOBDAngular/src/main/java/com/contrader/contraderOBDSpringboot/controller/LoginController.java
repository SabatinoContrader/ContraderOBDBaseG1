package com.contrader.contraderOBDSpringboot.controller;

import com.contrader.contraderOBDSpringboot.model.LoginEntity;
import com.contrader.contraderOBDSpringboot.util.Constant;
import com.contrader.contraderOBDSpringboot.util.GenericResponse;
import com.contrader.contraderOBDSpringboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {

    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public GenericResponse<LoginEntity> login(@RequestParam(name = "username", required = true) String username,
                                              @RequestParam(name = "password", required = true) String password) {
        LoginEntity loginEntity = loginService.login(username, password);
        if( loginEntity != null) {
            return new GenericResponse(loginEntity, Constant.SUCCESS_MSG, Constant.SUCCESS);
        }
        else {
            return new GenericResponse(null, Constant.ERROR_MSG, Constant.ERROR);
        }
    }

}
