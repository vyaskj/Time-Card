 package com.cg.tca_services ;
import java.util.*;

import com.cg.tca_services.entities.*;
import com.cg.tca_services.repository.*;
import com.cg.tca_services.services.*;
public class App
{
    public static void main( String[] args )
    {
        IEmployeeService service=new EmployeeService();
        Employees emp=new Employees();
        emp.setEmpId(19L);
        emp.setEmpName("Ramu");
        emp.setPhoneNumber("987654322");
        emp.setEmpEmail("ram.hanuman@gmail.com");
        emp.setSupervisorId(29L);
        service.addEmployee(emp);
        ITimecardDetailsService tservice=new TimecardDetailsService();
        TimecardDetails td=new TimecardDetails();
        td.setDate("20-11-2020");
        td.setHours(9);
        td.setProjectName("JEE-Freshers");
        td.setTaskName("L and D");
        td.setTimecardStatus("pending");
        td.setEmployee(emp);
        tservice.addTimecardDetails(td);
        int i=0;
        while(i==0)
        { TimecardDetails timecard=new TimecardDetails();
        Employees empl=new Employees();
        System.out.println("Enter the Employee ID :: ");
        Scanner sc=new Scanner(System.in);
                    Long id=sc.nextLong();
               service.validateEmployeeById(id);
       List<Employees> emps = service.viewEmployeesUnderSupervisor(id);
           
         for(Employees e : emps) {
         System.out.println(e);
         }
         System.out.println("Enter Employee ID whose details you want to update :: ");
         long eid=sc.nextInt();
         List<TimecardDetails> atti=service.viewTimecardByEmpId(eid);
        for(TimecardDetails a:atti)
        {
       System.out.println(a.toString());
       System.out.println("Update status by");
       String status=sc.next();
       tservice.updateTimecardStatus(a, status);
        System.out.println(a.toString());
       
        }
       
        if(emps.isEmpty()){

        System.out.println("1.Add Timecard Details :: \n 2.View Timecard Details");
        System.out.println("Enter your choice");
        int choice=sc.nextInt();
        switch(choice)
        {
              case 1:
              System.out.println("Provide Required Details:: ");
              System.out.println("Enter the Date :: ");
              String date=sc.next();
                timecard.setDate(date);
              System.out.println("Enter number of Hours ::");
              int hours=sc.nextInt();
              timecard.setHours(hours);
                     System.out.println("Enter your Project Name :: ");
                     String projectName=sc.next();
                    timecard.setProjectName(projectName);
                   System.out.println("Enter your Task Name :: ");
                     String taskName=sc.next();
                     timecard.setTaskName(taskName);
                     timecard.setTimecardStatus("Pending");
                     timecard.setEmployee(emp);
                   tservice.addTimecardDetails(timecard);
                 break;
              case 2:
                List<TimecardDetails> att=service.viewTimecardByEmpId(id);
                for(TimecardDetails a:att)
                {
                System.out.println(a.getDate());
               
                }
              break;
                                             
           
        }
        }
       
        }
 
    }


    }


