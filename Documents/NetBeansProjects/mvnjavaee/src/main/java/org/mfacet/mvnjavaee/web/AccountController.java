/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mfacet.mvnjavaee.web;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.mfacet.mvnjavaee.domain.entity.Account;
import org.mfacet.mvnjavaee.domain.logic.AccountLogic;

/**
 *
 * @author suehara
 */
@Path("accountTest")
@RequestScoped
public class AccountController {

    @Inject
    private AccountLogic accountLogic;

    public AccountController() {
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> getAccounts() {
        return this.accountLogic.findAll();
    }
    
}
