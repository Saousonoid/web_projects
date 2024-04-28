package com.mvc.app.entity;

import javax.persistence.*;

import java.util.Collection;
@Table(name = "users") 
@Entity(name = "users")
public class UserEntity {

    public UserEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String username;
    private String password;
    private String fname;
    private String Lname;
    private String phone;
    
    
    @JoinColumn(name = "role_id")
    @ManyToOne()
    private RoleEntity role;
    
    
    
    
    public Long getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getFname() {
        return this.fname;
    }

    public String getLname() {
        return this.Lname;
    }

    public String getPhone() {
        return this.phone;
    }
    
    public RoleEntity getRole() {
        return this.role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public void setRole(RoleEntity role) {
        this.role=role;
    }

    
    
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UserEntity)) return false;
        final UserEntity other = (UserEntity) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$fname = this.getFname();
        final Object other$fname = other.getFname();
        if (this$fname == null ? other$fname != null : !this$fname.equals(other$fname)) return false;
        final Object this$lname = this.getLname();
        final Object other$lname = other.getLname();
        if (this$lname == null ? other$lname != null : !this$lname.equals(other$lname)) return false;
        final Object this$phone = this.getPhone();
        final Object other$phone = other.getPhone();
        if (this$phone == null ? other$phone != null : !this$phone.equals(other$phone)) return false;
        final Object this$role = this.getRole();
        final Object other$role = other.getRole();
        if (this$role == null ? other$role != null : !this$role.equals(other$role)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UserEntity;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $fname = this.getFname();
        result = result * PRIME + ($fname == null ? 43 : $fname.hashCode());
        final Object $lname = this.getLname();
        result = result * PRIME + ($lname == null ? 43 : $lname.hashCode());
        final Object $phone = this.getPhone();
        result = result * PRIME + ($phone == null ? 43 : $phone.hashCode());
        final Object $role = this.getRole();
        result = result * PRIME + ($role == null ? 43 : $role.hashCode());
        return result;
    }

    public String toString() {
        return "UserEntity(id=" + this.getId() + ", email=" + this.getEmail() + ", username=" + this.getUsername() + ", password=" + this.getPassword() + ", fname=" + this.getFname() + ", Lname=" + this.getLname()   +", phone=" + this.getPhone() + ", role="+this.getRole() + ")";
    }
}
