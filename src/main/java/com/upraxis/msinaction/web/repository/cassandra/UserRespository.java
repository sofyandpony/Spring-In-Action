/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upraxis.msinaction.web.repository.cassandra;

import com.upraxis.msinaction.web.domain.Users;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jesse
 */
public interface UserRespository extends  CrudRepository<Users, UUID>{
    
}
