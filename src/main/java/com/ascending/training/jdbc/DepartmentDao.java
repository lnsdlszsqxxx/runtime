package com.ascending.training.jdbc;

import com.ascending.training.model.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DepartmentDao {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Logger logger2 = LoggerFactory.getLogger(this.getClass());
    private Logger logger3 = LoggerFactory.getLogger(this.getClass());


    //STEP 1: Database information
    static final String DB_URL = "jdbc:postgresql://localhost:5431/dealer";
    static final String USER = "admin";
    static final String PASS = "password";
    public List<Department> getDepartments() {
        List<Department> departments = new ArrayList();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //STEP 3: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM department";
            rs = stmt.executeQuery(sql);
            //STEP 4: Extract data from result set
            while(rs.next()) {
                //Retrieve by column name
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String location = rs.getString("location");
                //Fill the object
                Department department = new Department();
                department.setId(id);
                department.setName(name);
                department.setDescription(description);
                department.setLocation(location);
                departments.add(department);

                logger.debug(String.format("The department %s is",department.toString()));

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            //STEP 6: finally block used to close resources
            try {
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            }
            catch(SQLException se) {
                se.printStackTrace();
            }
        }






        return departments;
    }

    public static void main(String[] args){
        DepartmentDao departmentDao = new DepartmentDao();
        List<Department> departments = departmentDao.getDepartments();



        for (Department department: departments) {
            System.out.println(department.getName());


        }
    }

}