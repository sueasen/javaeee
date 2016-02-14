/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mfacet.mvnjavaee.web;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import org.mfacet.mvnjavaee.domain.entity.Account;
import org.mfacet.mvnjavaee.domain.logic.AccountLogic;

/**
 * REST Web Service
 *
 * @author suehara
 */
@Path("generic")
public class GenericResource {

    @Inject
    private AccountLogic accountLogic;
    
    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of org.mfacet.mvnjavaee.web.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> getJson() {
        List<Account> accountList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Account account = new Account();
            account.setUserId("test" + i);
            accountList.add(account);
        }
        return accountList;
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
