/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flashdin.TestAndroidNetworkingRest.service.impl;

import com.flashdin.TestAndroidNetworkingRest.dao.BaseDAO;
import com.flashdin.TestAndroidNetworkingRest.dao.BaseEDAO;
import com.flashdin.TestAndroidNetworkingRest.entity.TUsers;
import com.flashdin.TestAndroidNetworkingRest.service.BaseEService;
import com.flashdin.TestAndroidNetworkingRest.service.BaseService;
import java.util.List;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author hehe
 */
@Service
public class TUsersEServiceImpl implements BaseEService {
    
    @Autowired
    @Qualifier("TUsersEDAOImpl")
    private BaseEDAO baseEDAO;

    @Override
    public List<TUsers> views(TUsers params) {
        return baseEDAO.views(params);
    }

    @Override
    public String insert(TUsers params) {
        return baseEDAO.insert(params);
    }

    @Override
    public String update(TUsers params) {
        return baseEDAO.update(params);
    }

    @Override
    public String delete(TUsers params) {
        return baseEDAO.delete(params);
    }


}
