/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upraxis.msinaction.web.repository.solr;

import com.upraxis.msinaction.web.domain.Users;
import java.util.List;
import org.springframework.data.solr.repository.SolrCrudRepository;

/**
 *
 * @author jesse
 */
public interface UserRepository extends SolrCrudRepository<Users, String>{
    List<Users> findByNameEndsWith(String name);
}
