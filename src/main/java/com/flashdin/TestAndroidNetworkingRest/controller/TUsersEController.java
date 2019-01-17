/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flashdin.TestAndroidNetworkingRest.controller;

import com.flashdin.TestAndroidNetworkingRest.entity.TUsers;
import com.flashdin.TestAndroidNetworkingRest.service.BaseEService;
import com.flashdin.TestAndroidNetworkingRest.service.BaseService;
import com.flashdin.TestAndroidNetworkingRest.service.impl.TUsersServiceImpl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hehe
 */
@RestController
public class TUsersEController {

    @Autowired
    @Qualifier("TUsersEServiceImpl")
    private BaseEService baseEService;

    @GetMapping(value = "/userse/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TUsers> views(@PathVariable("userName") String userName) {
        TUsers tUsers = new TUsers();
        tUsers.setUserName(userName);
        return baseEService.views(tUsers);
    }

    @PostMapping(value = "/userse", produces = MediaType.APPLICATION_JSON_VALUE)
    public String insert(TUsers params) {
        return baseEService.insert(params);
    }

    @PutMapping(value = "/userse", produces = MediaType.APPLICATION_JSON_VALUE)
    public String update(@RequestBody JSONObject params) {
        TUsers tUsers = new TUsers();
        System.out.println(params.get("user_id"));
        tUsers.setUserId(Integer.parseInt(params.get("user_id").toString()));
        tUsers.setUserName(params.get("user_name").toString());
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            Date date = dateFormat.parse(dateFormat.format(params.get("user_date")));
//            tUsers.setUserDate(date);
        tUsers.setUserPhoto(params.get("user_photo").toString());
        tUsers.setUserPhotopath(params.get("user_photopath").toString());
        return baseEService.update(tUsers);
    }

    @DeleteMapping(value = "/userse", produces = MediaType.APPLICATION_JSON_VALUE)
    public String delete(@RequestBody JSONObject params) {
        TUsers tUsers = new TUsers();
        tUsers.setUserId(Integer.parseInt(params.get("user_id").toString()));
        return baseEService.delete(tUsers);
    }

}
