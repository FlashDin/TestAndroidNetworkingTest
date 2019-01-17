/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flashdin.TestAndroidNetworkingRest.entity;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author hehe
 */
@Getter
@Setter
public class TUsers {

    private int userId;
    private String userName;
    private Date userDate;
    private String userPhoto; //blob
    private String userPhotopath;

}
