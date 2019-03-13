package com.hoc.motobox.entity;

import com.hoc.motobox.utils.SuperEntity;
import org.apache.catalina.User;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
public class Cart extends SuperEntity {

    /*todo : sur le user car sinon on suprime le user
     TODO comme la class etend SuperEntity comment on cible l'element id @Column()   "@Column(name = "ADDRESS_ID")"
    @OneToOne(cascade = {
            CascadeType.REMOVE,
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
    }, mappedBy = "user")
    */

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "cart")
    private  User user;

    private Ad ad;

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user =  user;
    }

    public Ad getAd(){
        return ad;
    }

    public void setAd(Ad ad){
        this.ad = ad;
    }
}
