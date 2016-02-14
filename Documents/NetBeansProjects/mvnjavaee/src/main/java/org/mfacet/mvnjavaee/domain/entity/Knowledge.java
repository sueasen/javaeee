/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mfacet.mvnjavaee.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author suehara
 */
@Entity
@Table(name = "KNOWLEDGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Knowledge.findAll", query = "SELECT k FROM Knowledge k"),
    @NamedQuery(name = "Knowledge.findById", query = "SELECT k FROM Knowledge k WHERE k.id = :id"),
    @NamedQuery(name = "Knowledge.findByCreateAt", query = "SELECT k FROM Knowledge k WHERE k.createAt = :createAt"),
    @NamedQuery(name = "Knowledge.findByLastCommentAt", query = "SELECT k FROM Knowledge k WHERE k.lastCommentAt = :lastCommentAt"),
    @NamedQuery(name = "Knowledge.findByTitle", query = "SELECT k FROM Knowledge k WHERE k.title = :title"),
    @NamedQuery(name = "Knowledge.findByUpdateAt", query = "SELECT k FROM Knowledge k WHERE k.updateAt = :updateAt")})
public class Knowledge implements Serializable {

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
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "LAST_COMMENT_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastCommentAt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "TITLE")
    private String title;
    @Column(name = "UPDATE_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
    @ManyToMany(mappedBy = "knowledgeCollection")
    private Collection<Category> categoryCollection;
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID")
    @ManyToOne
    private Account accountId;
    @OneToMany(mappedBy = "knowledgeId")
    private Collection<KnowledgeComment> knowledgeCommentCollection;

    public Knowledge() {
    }

    public Knowledge(BigDecimal id) {
        this.id = id;
    }

    public Knowledge(BigDecimal id, String title) {
        this.id = id;
        this.title = title;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLastCommentAt() {
        return lastCommentAt;
    }

    public void setLastCommentAt(Date lastCommentAt) {
        this.lastCommentAt = lastCommentAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @XmlTransient
    public Collection<Category> getCategoryCollection() {
        return categoryCollection;
    }

    public void setCategoryCollection(Collection<Category> categoryCollection) {
        this.categoryCollection = categoryCollection;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    @XmlTransient
    public Collection<KnowledgeComment> getKnowledgeCommentCollection() {
        return knowledgeCommentCollection;
    }

    public void setKnowledgeCommentCollection(Collection<KnowledgeComment> knowledgeCommentCollection) {
        this.knowledgeCommentCollection = knowledgeCommentCollection;
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
        if (!(object instanceof Knowledge)) {
            return false;
        }
        Knowledge other = (Knowledge) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.mfacet.mvnjavaee.domain.Knowledge[ id=" + id + " ]";
    }
    
}
