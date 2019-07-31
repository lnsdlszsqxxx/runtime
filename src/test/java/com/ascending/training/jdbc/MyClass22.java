package com.ascending.training.jdbc;

import com.ascending.training.model.Department;
import org.junit.Before;
import org.junit.Test;

public class MyClass {
    private DepartmentDao departmentDao;

    @Before
    public void b(){


        departmentDao = new DepartmentDao();
        departmentDao.getDepartments();
    }

    @Test
    public void t1(){

    }


}
