package com.hoc.motobox.utils;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public abstract class SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date createdAt;

    @Column(nullable = false, updatable = true)
    private Date modifiedAt;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id =  id;
    }

    public Date getCreatedAt(){
        return createdAt;
    }

    public void setCreatedAt(Date createdAt){
        this.createdAt =  createdAt;
    }

    public Date getModifiedAt(){
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt){
        this.modifiedAt =  modifiedAt;
    }
}
