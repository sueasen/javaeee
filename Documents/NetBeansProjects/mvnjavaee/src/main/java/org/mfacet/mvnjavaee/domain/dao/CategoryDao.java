/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mfacet.mvnjavaee.domain.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.mfacet.mvnjavaee.domain.entity.Category;

/**
 *
 * @author suehara
 */
@Stateless
public class CategoryDao extends AbstractDao<Category> {

    @PersistenceContext(unitName = "mfacet_mvnjavaee_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoryDao() {
        super(Category.class);
    }
    
}
