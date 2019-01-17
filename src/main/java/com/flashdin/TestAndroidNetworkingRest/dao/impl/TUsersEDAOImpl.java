/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flashdin.TestAndroidNetworkingRest.dao.impl;

import com.flashdin.TestAndroidNetworkingRest.dao.BaseEDAO;
import com.flashdin.TestAndroidNetworkingRest.entity.TUsers;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hehe
 */
@Repository
public class TUsersEDAOImpl implements BaseEDAO<TUsers> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<TUsers> views(TUsers params) {
        String sql = "select * from t_users where user_name like ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + params.getUserName() + "%"}, new BeanPropertyRowMapper<>(TUsers.class));
    }

    @Override
    public String insert(TUsers params) {
        String sql = "insert into t_users (user_name,user_date,user_photo,user_photopath) values (?,?,?,?)";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, params.getUserName());
            ps.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(params.getUserDate()));
            ps.setString(3, params.getUserPhoto());
            ps.setString(4, params.getUserPhotopath());
            return ps;
        });
        if (rtn <= 0) {
            return "Gagal simpan data";
        } else {
            return "Sukses simpan data";
        }
    }

    @Override
    public String update(TUsers params) {
        String sql = "update t_users set user_name=?,user_date=?,user_photo=?,user_photopath=? where user_id=?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, params.getUserId());
            ps.setString(2, params.getUserName());
            ps.setString(3, "2017-01-01");
            ps.setString(4, "");
            ps.setString(5, params.getUserPhotopath());
            return ps;
        });
        if (rtn <= 0) {
            return "Gagal update data";
        } else {
            return "Sukses update data";
        }
    }

    @Override
    public String delete(TUsers params) {
        String sql = "delete from t_users where user_id=?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, params.getUserId());
            return ps;
        });
        if (rtn <= 0) {
            return "Gagal hapus data";
        } else {
            return "Sukses hapus data";
        }
    }


}
