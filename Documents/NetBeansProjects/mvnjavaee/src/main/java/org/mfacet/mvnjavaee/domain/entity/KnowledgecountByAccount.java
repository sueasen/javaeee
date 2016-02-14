/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mfacet.mvnjavaee.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author suehara
 */
@Entity
@Table(name = "KNOWLEDGECOUNT_BY_ACCOUNT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KnowledgecountByAccount.findAll", query = "SELECT k FROM KnowledgecountByAccount k"),
    @NamedQuery(name = "KnowledgecountByAccount.findById", query = "SELECT k FROM KnowledgecountByAccount k WHERE k.id = :id"),
    @NamedQuery(name = "KnowledgecountByAccount.findByAccountId", query = "SELECT k FROM KnowledgecountByAccount k WHERE k.accountId = :accountId"),
    @NamedQuery(name = "KnowledgecountByAccount.findByAccountName", query = "SELECT k FROM KnowledgecountByAccount k WHERE k.accountName = :accountName"),
    @NamedQuery(name = "KnowledgecountByAccount.findByAsOf", query = "SELECT k FROM KnowledgecountByAccount k WHERE k.asOf = :asOf"),
    @NamedQuery(name = "KnowledgecountByAccount.findByCount", query = "SELECT k FROM KnowledgecountByAccount k WHERE k.count = :count")})
public class KnowledgecountByAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "ACCOUNT_ID")
    private BigInteger accountId;
    @Size(max = 255)
    @Column(name = "ACCOUNT_NAME")
    private String accountName;
    @Column(name = "AS_OF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date asOf;
    @Column(name = "COUNT")
    private BigInteger count;

    public KnowledgecountByAccount() {
    }

    public KnowledgecountByAccount(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getAccountId() {
        return accountId;
    }

    public void setAccountId(BigInteger accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Date getAsOf() {
        return asOf;
    }

    public void setAsOf(Date asOf) {
        this.asOf = asOf;
    }

    public BigInteger getCount() {
        return count;
    }

    public void setCount(BigInteger count) {
        this.count = count;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KnowledgecountByAccount)) {
            return false;
        }
        KnowledgecountByAccount other = (KnowledgecountByAccount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.mfacet.mvnjavaee.domain.KnowledgecountByAccount[ id=" + id + " ]";
    }
    
}
