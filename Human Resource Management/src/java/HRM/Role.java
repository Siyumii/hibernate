/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HRM;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Kasuni
 */
@Entity
@Table(name="ROLE")
public class Role {
     @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="ROLEID")
    private Integer roleID;
    private String title;

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleid) {
        this.roleID = roleid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
   @Override
    public String toString() {
        
        return "Role{" + "roleID=" + getRoleID() + ", title=" + getTitle() + '}';
        
    }
    
    
    
}
