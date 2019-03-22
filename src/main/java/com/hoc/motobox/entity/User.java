
package com.hoc.motobox.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hoc.motobox.utils.SuperEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User extends SuperEntity {

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role", nullable = true)
    private Role role;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "User_Ad", 
        joinColumns = { @JoinColumn(name = "user_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "ad_id") }
    )
    @JsonIgnore
    Set<Ad> panier = new HashSet<Ad>();

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendor", fetch = FetchType.EAGER, orphanRemoval = true)
    @Column(name = "ads", nullable = true)
    private Collection<Ad> ads;


    public Set<Ad> getPanier() {
        return panier;
    }

    public void setPanier(Set<Ad> panier) {
        this.panier = panier;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**²
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}

