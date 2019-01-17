/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flashdin.TestAndroidNetworkingRest.dao;

/**
 *
 * @author hehe
 */
public interface BaseDAO<T> {
    
    T views(T params);
    T insert(T params);
    T update(T params);
    T delete(T params);
    
}
