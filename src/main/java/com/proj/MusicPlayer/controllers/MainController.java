package com.proj.MusicPlayer.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proj.MusicPlayer.modals.LoginDataModal;
import com.proj.MusicPlayer.modals.UserDetailModal;
import com.proj.MusicPlayer.services.UserDetailService;
import com.proj.MusicPlayer.utils.JwtUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private JwtUtil jwtUtil;

    //@RequestMapping(name = "/api/v1/public/auth/register", method = RequestMethod.POST)
    @PostMapping(value = "/api/v1/public/auth/register")
    public String signUp(@RequestBody UserDetailModal userDetailModal){
        UserDetailModal userDetails = userDetailService.findUserByEmail(userDetailModal.getEmail());
        JSONObject jsonObject = new JSONObject();
        if (userDetails != null){
            jsonObject.put("response",false);
            jsonObject.put("message","User already exists!");
        }else {
            userDetailService.saveUser(userDetailModal);
            jsonObject.put("response",true);
            jsonObject.put("message","User registered!");
            jsonObject.put("token",jwtUtil.generateToken(userDetailService.loadUserByUsername(userDetailModal.getEmail())));

        }
        return jsonObject.toString();
    }

    //@RequestMapping(name = "/api/v1/public/auth/login", method = RequestMethod.POST)
    @PostMapping(value = "/api/v1/public/auth/login")
    public String signIn(@RequestBody LoginDataModal loginDataModal){

        return "signIn user";
    }

    @RequestMapping(name = "/hey", method = RequestMethod.GET)
    public String sayHello(){
        return "Hello Amrita";
    }

    public String convertObjectToJson(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
