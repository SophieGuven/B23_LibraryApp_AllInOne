package com.cydeo.step_defs;

import com.cydeo.utility.DB_Util;
import com.cydeo.utility.LibraryDB_Util;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class DBStepDefs {

    @Then("the information should be same with database  {string}")
    public void the_information_should_be_same_with_database(String moduleName) {


        String moduleQuery = LibraryDB_Util.getModuleQuery(moduleName);
        DB_Util.runQuery(moduleQuery);

        //DB_Util.getCellValue(1, 1);
        String expectedNumber = DB_Util.getFirstRowFirstColumn();

        System.out.println("expectedNumber = " + expectedNumber);

        Assert.assertEquals(expectedNumber, UIStepDefs.actualNumber);
    }

    /**
     * Three Point
     *
     */
    @Then("the informations should be same with database  {string}")
    public void the_informations_should_be_same_with_database(String moduleName) {

        // GET ALL DATA FROM DATABASE
        String moduleQuery = LibraryDB_Util.getModuleQuery(moduleName);
        DB_Util.runQuery(moduleQuery);
        String expectedNumber = DB_Util.getFirstRowFirstColumn();
        System.out.println("expectedNumber = " + expectedNumber);
        // GET ALL DATA FROM API
        System.out.println("APIStepDefs.actualAPINumber = " + APIStepDefs.actualAPINumber);

        // GET ALL DATA FROM UI
        System.out.println("UIStepDefs.actualNumber = " + UIStepDefs.actualNumber);

        // VERIFICATION
        Assert.assertTrue(APIStepDefs.actualAPINumber.equals(expectedNumber)&&UIStepDefs.actualNumber.equals(expectedNumber));


    }

}
