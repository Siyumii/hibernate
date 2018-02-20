/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HRM;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Kasuni
 */
@Entity
@Table(name="TASK")
public class Task implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int taskID;
   private String description;
   @ManyToOne( cascade={CascadeType.ALL}, targetEntity=Employee.class )
   @JoinColumn(name="employeeID",insertable=false, updatable=false, nullable=true)
   private Employee employee;

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

     
    @Override
    public String toString() {
        //return "Task{" + "taskID = " + getTaskID() + ", description = " + getDescription() + '}';
        
        if(getEmployee()!= null ){
            return "Task{" + "taskID = " + getTaskID() + ", description = " + getDescription() +", employee=" + getEmployee().getEmployeeID()+ '}';
        }
        return "Task{" + "taskID = " + getTaskID() + ", description = " + getDescription() + ", employee=" + "null" + '}';
    }

   
   
   
}
