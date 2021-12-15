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

        Assert.assertEquals(expectedNumber, new UIStepDefs().actualNumber);
    }

}
