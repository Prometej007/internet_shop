package com.web.edu.internetshop.model;

import com.web.edu.internetshop.model.product.Product;
import com.web.edu.internetshop.model.utils.pattern.DateCreate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.List;

@Entity
public class User extends DateCreate<User> implements UserDetails {

    @ManyToMany
    private List<Product> seeProducts;

    private String email;
    private String password;
    private Boolean isAccountNonLocked;
    private Boolean isEnabled;
    private String uuid;

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isAccountNonLocked=" + isAccountNonLocked +
                ", isEnabled=" + isEnabled +
                '}';
    }

    public List<Product> getSeeProducts() {
        return seeProducts;
    }

    public User setSeeProducts(List<Product> seeProducts) {
        this.seeProducts = seeProducts;
        return this;
    }

    public Boolean getAccountNonLocked() {
        return isAccountNonLocked;
    }

    public User setAccountNonLocked(Boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
        return this;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public User setEnabled(Boolean enabled) {
        isEnabled = enabled;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public User setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }


}
