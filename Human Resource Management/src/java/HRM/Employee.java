/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HRM;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Kasuni
 */
@Entity
@Table(name="EMPLOYEE")

public class Employee implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int employeeID;
    private String name;
    @OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name="employeeID")
    //private int role_id;
    private Set<Task> tasks;
    
    public Employee()
    {
        this.tasks = new HashSet();
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
    
    
    public void addTask(Task task){
        this.tasks.add(task);
    }
    
    public void removeTask(Task task)
    {
        this.tasks.remove(task);
    }
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="roleID")
    private Role role;
    
        public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeid) {
        this.employeeID = employeeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    
    
    public String toString()
    {
         String personString = "Employee{" + "employeeID=" + getEmployeeID() + ", name=" + getName() +  '}';
        String taskString = "";
        for (Iterator iter = tasks.iterator(); iter.hasNext();) {
            Task task = (Task) iter.next();
            taskString = taskString + "\t\t"+ task.toString()+"\n";
        }
        return personString + "\n" + taskString;
    }
    
}
