package com.ucodeacademy.practice;



public class JUnit4And5Annotations {

   // @Test // Mark the method as a test method JUnit 4 & JUnit 5

    // @Before // runs before each method JUnit 4
    // @BeforeEach // runs before each method JUnit 5

    // @After // runs after each method Junit 4
    // @AfterEach // runs after each method JUnit 5

    //@BeforeClass // runs before all test method in the class JUnit 4
    //@BeforeAll  // runs before all test method in the class JUnit 5

   // @AfterClass // runs after all test method in the class JUnit 4
   // @AfterAll  // runs after all test methods in the class JUnit 5

   // @Ignore // marks test method/class as ignore/ it won't run JUnit 4
   // @Disabled // marks test method/class as ignore/ it won't run JUnit 5


    public void test1(){
        System.out.println("Hello");
    }
}
