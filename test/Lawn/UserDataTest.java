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
public class UserDataTest {
    
    public UserDataTest() {
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
     * Test of createUser method, of class UserData.
     */
    @Test
    public void testCreateUser() {
        System.out.println("createUser");
        UserData instance = new UserData();
        String expResult = "";
        String result = instance.createUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //I have no idea what I'm doing....
        fail("The test case is a prototype.");
    }

    /**
     * Test of loginUser method, of class UserData.
     */
    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        UserData instance = new UserData();
        String expResult = "";
        String result = instance.loginUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logoutUser method, of class UserData.
     */
    @Test
    public void testLogoutUser() {
        System.out.println("logoutUser");
        UserData instance = new UserData();
        String expResult = "";
        String result = instance.logoutUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashPass method, of class UserData.
     */
    @Test
    public void testHashPass() {
        System.out.println("hashPass");
        String pw = "";
        UserData instance = new UserData();
        String expResult = "ERROR: Invalid Password";
        String result = instance.hashPass(pw);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getCurrentUser method, of class UserData.
     */
    @Test
    public void testGetCurrentUser() {
        System.out.println("getCurrentUser");
        UserData instance = new UserData();
        User expResult = null;
        User result = instance.getCurrentUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentUser method, of class UserData.
     */
    @Test
    public void testSetCurrentUser() {
        System.out.println("setCurrentUser");
        User currentUser = null;
        UserData instance = new UserData();
        instance.setCurrentUser(currentUser);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class UserData.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        UserData instance = new UserData();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class UserData.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        UserData instance = new UserData();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNextUserId method, of class UserData.
     */
    @Test
    public void testGetNextUserId() {
        System.out.println("getNextUserId");
        UserData instance = new UserData();
        int expResult = 0;
        int result = instance.getNextUserId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNextUserId method, of class UserData.
     */
    @Test
    public void testSetNextUserId() {
        System.out.println("setNextUserId");
        int nextUserId = 0;
        UserData instance = new UserData();
        instance.setNextUserId(nextUserId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUl method, of class UserData.
     */
    @Test
    public void testGetUl() {
        System.out.println("getUl");
        UserData instance = new UserData();
        UserList expResult = null;
        UserList result = instance.getUl();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUl method, of class UserData.
     */
    @Test
    public void testSetUl() {
        System.out.println("setUl");
        UserList ul = null;
        UserData instance = new UserData();
        instance.setUl(ul);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isLoggedIn method, of class UserData.
     */
    @Test
    public void testIsLoggedIn() {
        System.out.println("isLoggedIn");
        UserData instance = new UserData();
        boolean expResult = false;
        boolean result = instance.isLoggedIn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLoggedIn method, of class UserData.
     */
    @Test
    public void testSetLoggedIn() {
        System.out.println("setLoggedIn");
        boolean loggedIn = false;
        UserData instance = new UserData();
        instance.setLoggedIn(loggedIn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class UserData.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        UserData instance = new UserData();
        String expResult = "";
        String result = instance.edit();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveUser method, of class UserData.
     */
    @Test
    public void testSaveUser() {
        System.out.println("saveUser");
        UserData instance = new UserData();
        String expResult = "";
        String result = instance.saveUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
