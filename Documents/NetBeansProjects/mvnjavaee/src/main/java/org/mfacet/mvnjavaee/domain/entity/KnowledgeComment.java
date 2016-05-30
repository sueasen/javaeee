/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mfacet.mvnjavaee.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author suehara
 */
@Entity
@Table(name = "KNOWLEDGE_COMMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KnowledgeComment.findAll", query = "SELECT k FROM KnowledgeComment k"),
    @NamedQuery(name = "KnowledgeComment.findById", query = "SELECT k FROM KnowledgeComment k WHERE k.id = :id"),
    @NamedQuery(name = "KnowledgeComment.findByCreateAt", query = "SELECT k FROM KnowledgeComment k WHERE k.createAt = :createAt"),
    @NamedQuery(name = "KnowledgeComment.findByUpdateAt", query = "SELECT k FROM KnowledgeComment k WHERE k.updateAt = :updateAt")})
public class KnowledgeComment implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CREATE_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    @Lob
    @Column(name = "MESSAGE")
    private String message;
    @Column(name = "UPDATE_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID")
    @ManyToOne
    private Account accountId;
    @JoinColumn(name = "KNOWLEDGE_ID", referencedColumnName = "ID")
    @ManyToOne
    private Knowledge knowledgeId;

    public KnowledgeComment() {
    }

    public KnowledgeComment(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    public Knowledge getKnowledgeId() {
        return knowledgeId;
    }

    public void setKnowledgeId(Knowledge knowledgeId) {
        this.knowledgeId = knowledgeId;
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
        if (!(object instanceof KnowledgeComment)) {
            return false;
        }
        KnowledgeComment other = (KnowledgeComment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.mfacet.mvnjavaee.domain.KnowledgeComment[ id=" + id + " ]";
    }
    
}
