/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flashdin.TestAndroidNetworkingRest.dao.impl;

import com.flashdin.TestAndroidNetworkingRest.dao.BaseDAO;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hehe
 */
@Repository
public class TUsersDAOImpl implements BaseDAO<JSONObject> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public JSONObject views(JSONObject params) {
        String sql = "select * from t_users"; //  where user_name like ?
//        List list = jdbcTemplate.queryForList(sql, new Object[]{"%" + params.get("user_name") + "%"});
//        Map<String, Object> map = list.stream().collect(Collectors.toMap(keyMapper, valueMapper));
        Map<String, Object> map = jdbcTemplate.queryForMap(sql);
        JSONObject jSONObject = new JSONObject();
        jSONObject.putAll(map);
        return jSONObject;
    }

    @Override
    public JSONObject insert(JSONObject params) {
        String sql = "insert into t_users (user_name,user_date,user_photo,user_photopath) values (?,?,?,?)";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, params.get("user_name").toString());
            ps.setString(2, params.get("user_date").toString());
            ps.setString(3, params.get("user_photo").toString());
            ps.setString(4, params.get("user_photopath").toString());
            return ps;
        });
        JSONObject jSONObject = new JSONObject();
        if (rtn <= 0) {
            jSONObject.put("result", "Gagal simpan data");
        } else {
            jSONObject.put("result", "Sukses simpan data");
        }
        return jSONObject;
    }

    @Override
    public JSONObject update(JSONObject params) {
        String sql = "update t_users set user_name=?,user_date=?,user_photo=?,user_photopath=? where user_id=?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, params.get("user_id").toString());
            ps.setString(2, params.get("user_name").toString());
            ps.setString(3, params.get("user_date").toString());
            ps.setString(4, params.get("user_photo").toString());
            ps.setString(5, params.get("user_photopath").toString());
            return ps;
        });
        JSONObject jSONObject = new JSONObject();
        if (rtn <= 0) {
            jSONObject.put("result", "Gagal update data");
        } else {
            jSONObject.put("result", "Sukses update data");
        }
        return jSONObject;
    }

    @Override
    public JSONObject delete(JSONObject params) {
        String sql = "delete from t_users where user_id=?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, params.get("user_id").toString());
            return ps;
        });
        JSONObject jSONObject = new JSONObject();
        if (rtn <= 0) {
            jSONObject.put("result", "Gagal update data");
        } else {
            jSONObject.put("result", "Sukses update data");
        }
        return jSONObject;
    }

}
