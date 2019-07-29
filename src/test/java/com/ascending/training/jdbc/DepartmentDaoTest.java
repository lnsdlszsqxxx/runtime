package com.ascending.training.jdbc;

import com.ascending.training.model.Department;
import org.junit.*;

import java.util.List;

public class DepartmentDaoTest {

    private DepartmentDao departmentDao;



    @Before
    public void init(){
        departmentDao = new DepartmentDao();
    }

    @After
    public void cleanup(){

    }

//    @Ignore
    @Test
    public void getDepartmentsTest(){

        List<Department> departments = departmentDao.getDepartments();
//        int expectedNumOfDept = 5;
        int i=0;

        for (Department department: departments){

            i++;

            System.out.println(department.getId());

            Assert.assertEquals(i, department.getId());

        }

    }


}
