/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lawn;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author c0537794
 */
public class JobDataTest {
    
    public JobDataTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createJob method, of class JobData.
     */
    @Test
    public void testCreateJob() {
        System.out.println("createJob");
        int creator = 0;
        JobData instance = new JobData();
        String expResult = "";
        String result = instance.createJob(creator);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of assignJobToCutter method, of class JobData.
     */
    @Test
    public void testAssignJobToCutter() throws Exception {
        System.out.println("assignJobToCutter");
        int jobId = 0;
        int cutterID = 0;
        String date = "";
        String time = "";
        JobData instance = new JobData();
        String expResult = "";
        String result = instance.assignJobToCutter(jobId, cutterID, date, time);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteJob method, of class JobData.
     */
    @Test
    public void testDeleteJob() {
        System.out.println("deleteJob");
        int jobId = 0;
        JobData instance = new JobData();
        String expResult = "";
        String result = instance.deleteJob(jobId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeCutterFromJob method, of class JobData.
     */
    @Test
    public void testRemoveCutterFromJob() {
        System.out.println("removeCutterFromJob");
        int jobId = 0;
        JobData instance = new JobData();
        String expResult = "";
        String result = instance.removeCutterFromJob(jobId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentJob method, of class JobData.
     */
    @Test
    public void testGetCurrentJob() {
        System.out.println("getCurrentJob");
        JobData instance = new JobData();
        Job expResult = null;
        Job result = instance.getCurrentJob();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentJob method, of class JobData.
     */
    @Test
    public void testSetCurrentJob() {
        System.out.println("setCurrentJob");
        Job currentJob = null;
        JobData instance = new JobData();
        instance.setCurrentJob(currentJob);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
