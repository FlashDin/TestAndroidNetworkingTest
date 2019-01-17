/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flashdin.TestAndroidNetworkingRest.service.impl;

import com.flashdin.TestAndroidNetworkingRest.dao.BaseDAO;
import com.flashdin.TestAndroidNetworkingRest.service.BaseService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author hehe
 */
@Service
public class TUsersServiceImpl implements BaseService {
    
    @Autowired
    @Qualifier("TUsersDAOImpl")
    private BaseDAO baseDAO;

    @Override
    public JSONObject views(JSONObject params) {
        JSONObject jSONObject = (JSONObject) baseDAO.views(params);
//        jSONObject.put("result", baseDAO.views(params));
        return jSONObject;
    }

    @Override
    public JSONObject insert(JSONObject params) {
        return (JSONObject) baseDAO.insert(params);
    }

    @Override
    public JSONObject update(JSONObject params) {
        return (JSONObject) baseDAO.update(params);
    }

    @Override
    public JSONObject delete(JSONObject params) {
        return (JSONObject) baseDAO.delete(params);
    }

}
