/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mfacet.mvnjavaee.domain.logic;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.mfacet.mvnjavaee.domain.dao.AccountDao;
import org.mfacet.mvnjavaee.domain.entity.Account;

/**
 *
 * @author suehara
 */
@Stateless
public class AccountLogic {
    
    @Inject
    private AccountDao accountDao;

    /**
     *
     * @param account
     * @return 
     */
    public Account create(Account account) {
        this.accountDao.create(account);
        return account;
    }
    
    /**
     * 
     * 
     * @return 
     */
    public List<Account> findAll() {
        return this.accountDao.findAll();
    }
}
