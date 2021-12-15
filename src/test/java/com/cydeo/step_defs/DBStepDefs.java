package com.cydeo.step_defs;

import com.cydeo.utility.DB_Util;
import com.cydeo.utility.LibraryDB_Util;
import io.cucumber.java.en.*;

public class DBStepDefs {

    @Then("the information should be same with database  {string}")
    public void the_information_should_be_same_with_database(String moduleName) {


        String moduleQuery = LibraryDB_Util.getModuleQuery(moduleName);
        DB_Util.runQuery(moduleQuery);

    }

}
