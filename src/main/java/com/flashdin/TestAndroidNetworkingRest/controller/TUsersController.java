/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flashdin.TestAndroidNetworkingRest.controller;

import com.flashdin.TestAndroidNetworkingRest.service.BaseService;
import com.flashdin.TestAndroidNetworkingRest.service.impl.TUsersServiceImpl;
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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hehe
 */
@RestController
public class TUsersController {
    
    @Autowired
    @Qualifier("TUsersServiceImpl")
    private BaseService baseService;
    
    @GetMapping(value = "/users/{user_name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject views(@PathVariable("user_name") String user_name) {
        System.out.println(user_name);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("user_name", user_name);
        System.out.println(baseService.views(jSONObject));
        return baseService.views(jSONObject);
    }

    @PostMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject insert(@RequestBody JSONObject params) {
        return baseService.insert(params);
    }

    @PutMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject update(@RequestBody JSONObject params) {
        return baseService.update(params);
    }

    @DeleteMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject delete(@RequestBody JSONObject params) {
        return baseService.delete(params);
    }
    
}
