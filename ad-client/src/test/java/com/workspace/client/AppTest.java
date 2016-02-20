package com.workspace.client;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */

@Test
public class AppTest 
{

    @BeforeClass
    public void beforeClass() throws Exception {
        System.out.println("Running before class");
        throw new Exception();

    }
    @AfterClass
    public void afterClass() throws IOException {
        System.out.println("Running after class");
        FileUtils.deleteDirectory(new File("/Users/deepak.barr/apcdddd/dfsdfd"));

    }
    @Test
    public void test1(){
        Assert.assertTrue(true);
        System.out.println("Running test1");
    }

    @Test
    public void test2(){
        Assert.assertTrue(true);
        System.out.println("Running test2");
    }

}
