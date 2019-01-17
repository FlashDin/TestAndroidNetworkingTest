/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flashdin.TestAndroidNetworkingRest.dao;

import java.util.List;

/**
 *
 * @author hehe
 */
public interface BaseEDAO<T> {
    
    List<T> views(T params);
    String insert(T params);
    String update(T params);
    String delete(T params);
    
}
