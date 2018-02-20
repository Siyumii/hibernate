/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HRM;

import java.util.List;
//import HRM.SessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Kasuni
 */
public class DBHandler {
    
    Session session; 
    Transaction tx = null;
    public DBHandler() {
        this.session = SessionFactoryUtil.getCurrentSession(); 
    }
    public List getEmployeeById(int employeeID) {         
        List employeeList = null;      
        try {             
            
            tx = session.beginTransaction();
            
            employeeList = session.createQuery("SELECT employee FROM Employee AS employee WHERE employee.employeeID =:employeeID")
                    .setParameter("employeeID",employeeID).list();
            System.out.println("Valid Employee List : "+ employeeList.toString());
            tx.commit();
            session.flush();
            //session.close();
        } catch (RuntimeException e) {             
            if (tx != null && tx.isActive()) {                 
                try {                 
                    tx.rollback();                 
                } catch (HibernateException e1) {                     
                    System.out.println("Error when rolling back transaction");                 
                }                 
                throw e;             
            }         
        }
        return employeeList;
    }
     public List getRoleById(int roleID) {         
        List rolesList = null;      
        try {             
            
            tx = session.beginTransaction();
            
            rolesList = session.createQuery("SELECT role FROM Role AS role WHERE role.roleID =:roleID")
                    .setParameter("roleID",roleID).list();
            System.out.println("Valid Role List : "+ rolesList.toString());
            tx.commit();
            session.flush();
            //session.close();
        } catch (RuntimeException e) {             
            if (tx != null && tx.isActive()) {                 
                try {                 
                    tx.rollback();                 
                } catch (HibernateException e1) {                     
                    System.out.println("Error when rolling back transaction");                 
                }                 
                throw e;             
            }         
        }
        return rolesList;
    }
    public List getTaskById(int taskID) {         
        List tasksList = null;      
        try {             
            
            tx = session.beginTransaction();
            
            tasksList = session.createQuery("SELECT task FROM Task AS task WHERE task.taskID =:taskID")
                    .setParameter("taskID",taskID).list();
            System.out.println("Valid Task List : "+ tasksList.toString());
            tx.commit();
            session.flush();
            //session.close();
        } catch (RuntimeException e) {             
            if (tx != null && tx.isActive()) {                 
                try {                 
                    tx.rollback();                 
                } catch (HibernateException e1) {                     
                    System.out.println("Error when rolling back transaction");                 
                }                 
                throw e;             
            }         
        }
        return tasksList;
    }
    
    // 
    
     public List getTaskByemployeeId(int employeeID) {         
        List tasksList = null;      
        try {             
            
            tx = session.beginTransaction();
            
            tasksList = session.createQuery("SELECT task FROM Task AS task WHERE task.employee.employeeID =:employeeID")
                    .setParameter("employeeID",employeeID).list();
            System.out.println("Valid Task List : "+ tasksList.toString());
            tx.commit();
            session.flush();
            //session.close();
        } catch (RuntimeException e) {             
            if (tx != null && tx.isActive()) {                 
                try {                 
                    tx.rollback();                 
                } catch (HibernateException e1) {                     
                    System.out.println("Error when rolling back transaction");                 
                }                 
                throw e;             
            }         
        }
        return tasksList;
    }
    
    
    //
    
           public List listValidTasks() {         
        List tasksList = null;      
        try {             
            
            tx = session.beginTransaction();
            
            tasksList = session.createQuery("SELECT task FROM Task AS task WHERE task.employee = null")
                    .list();
            System.out.println("Valid Task List : "+ tasksList.toString());
            tx.commit();
            session.flush();
            //session.close();
        } catch (RuntimeException e) {             
            if (tx != null && tx.isActive()) {                 
                try {                 
                    tx.rollback();                 
                } catch (HibernateException e1) {                     
                    System.out.println("Error when rolling back transaction");                 
                }                 
                throw e;             
            }         
        }
        return tasksList;
    }
       public List listValidRoles() {         
        List rolesList = null;      
        try {             
            
            tx = session.beginTransaction();
           
            rolesList = session.createQuery("SELECT role FROM Role AS role WHERE NOT EXISTS "
                    + "(SELECT employee FROM Employee AS employee WHERE role.roleID = employee.role  )")
                    .list();
            System.out.println("Valid Roles List : "+rolesList.toString());
            tx.commit();
            session.flush();
            //session.close();
        } catch (RuntimeException e) {             
            if (tx != null && tx.isActive()) {                 
                try {                 
                    tx.rollback();                 
                } catch (HibernateException e1) {                     
                    System.out.println("Error when rolling back transaction");                 
                }                 
                throw e;             
            }         
        }
        return rolesList;
    }  
    public List listRoles() {         
        List rolesList = null;      
        try {             
            tx = session.beginTransaction();
            rolesList = session.createQuery("SELECT role FROM Role AS role").list();
            System.out.println("Roles List : "+rolesList.toString());
            tx.commit();
            session.flush();
            //session.close();
        } catch (RuntimeException e) {             
            if (tx != null && tx.isActive()) {                 
                try {                 
                    tx.rollback();                 
                } catch (HibernateException e1) {                     
                    System.out.println("Error when rolling back transaction");                 
                }                 
                throw e;             
            }         
        }
        return rolesList;
    } 
        
    public void addRole(Role role) {         
              
        try {             
            tx = session.beginTransaction();
            session.save(role);             
            tx.commit(); 
            session.flush();
            //session.close();
        } catch (RuntimeException e) {             
            if (tx != null && tx.isActive()) {                 
                try {                 
                    tx.rollback();                 
                } catch (HibernateException e1) {                     
                    System.out.println("Error when rolling back transaction");                 
                }                 
                throw e;             
            }         
        }    
    }
    
    public void editRole(Role role) { 
        try {             
            tx = session.beginTransaction();
            session.update(role);
            session.flush();
            tx.commit();
            //session.close();
        } catch (RuntimeException e) {             
            if (tx != null && tx.isActive()) {                 
                try {                 
                    tx.rollback();                 
                } catch (HibernateException e1) {                     
                    System.out.println("Error when rolling back transaction");                 
                }                 
                throw e;             
            }         
        }     
    }
    
    public List listTasks() {         
        List tasksList = null;      
        try {             
            tx = session.beginTransaction();
            tasksList = session.createQuery("SELECT task FROM Task AS task").list();
            System.out.println("Tasks List : "+tasksList.toString());
            tx.commit();
            session.flush();
            //session.close();
        } catch (RuntimeException e) {             
            if (tx != null && tx.isActive()) {                 
                try {                 
                    tx.rollback();                 
                } catch (HibernateException e1) {                     
                    System.out.println("Error when rolling back transaction");                 
                }                 
                throw e;             
            }         
        }
        return tasksList;
    } 
        
    public void addTask(Task task) {         
              
        try {             
            tx = session.beginTransaction();
            session.save(task);             
            tx.commit(); 
            session.flush();
            //session.close();
        } catch (RuntimeException e) {             
            if (tx != null && tx.isActive()) {                 
                try {                 
                    tx.rollback();                 
                } catch (HibernateException e1) {                     
                    System.out.println("Error when rolling back transaction");                 
                }                 
                throw e;             
            }         
        }    
    }
    
    public void editTask(Task task) { 
        try {             
            tx = session.beginTransaction();
            session.update(task);
            session.flush();
            tx.commit();
            //session.close();
        } catch (RuntimeException e) {             
            if (tx != null && tx.isActive()) {                 
                try {                 
                    tx.rollback();                 
                } catch (HibernateException e1) {                     
                    System.out.println("Error when rolling back transaction");                 
                }                 
                throw e;             
            }         
        }     
    }
    
        public List listEmployees() {         
        List employeesList = null;      
        try {             
            tx = session.beginTransaction();
            employeesList = session.createQuery("SELECT employee FROM Employee AS employee").list();
            System.out.println("Employees List : "+ employeesList.toString());
            tx.commit();
            session.flush();
            //session.close();
        } catch (RuntimeException e) {             
            if (tx != null && tx.isActive()) {                 
                try {                 
                    tx.rollback();                 
                } catch (HibernateException e1) {                     
                    System.out.println("Error when rolling back transaction");                 
                }                 
                throw e;             
            }         
        }
        return employeesList;
    } 
        
    public void addEmployee(Employee employee) {         
              
        try {             
            tx = session.beginTransaction();
            session.save(employee);             
            tx.commit(); 
            session.flush();
            //session.close();
        } catch (RuntimeException e) {             
            if (tx != null && tx.isActive()) {                 
                try {                 
                    tx.rollback();                 
                } catch (HibernateException e1) {                     
                    System.out.println("Error when rolling back transaction");                 
                }                 
                throw e;             
            }         
        }    
    }
    
    public void editEmployee(Employee employee) { 
        try {             
            tx = session.beginTransaction();
            session.update(employee);
            session.flush();
            tx.commit();
           // session.close();
        } catch (RuntimeException e) {             
            if (tx != null && tx.isActive()) {                 
                try {                 
                    tx.rollback();                 
                } catch (HibernateException e1) {                     
                    System.out.println("Error when rolling back transaction");                 
                }                 
                throw e;             
            }         
        }     
    }
    
}
