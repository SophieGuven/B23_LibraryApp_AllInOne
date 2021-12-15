package com.cydeo.utility;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class LibraryAPI_Util {


    public static String getToken(String userType){


        String email;

        switch (userType){

            case "student" :
                email="student42@library";
                break;
            case "librarian" :
                email="librarian47@library";
                break;
            default:
                throw new RuntimeException("Unexpected value: "+ userType);
        }

        return given()
                .contentType(ContentType.URLENC)
                .formParam("email" , email)
                .formParam("password" , "Sdet2022*").
                when()
                .post("/login")
                .prettyPeek()
                .path("token") ;


    }

    public static String getToken(String email,String password){


        return given()
                .contentType(ContentType.URLENC)
                .formParam("email" , email)
                .formParam("password" , password).
                when()
                .post("/login")
                .prettyPeek()
                .path("token") ;


    }

    public static Map<String,Object> getRandomBookMap(){

        Faker faker = new Faker() ;
        Map<String,Object> bookMap = new LinkedHashMap<>();
        bookMap.put("name", faker.book().title()   );
        bookMap.put("isbn", faker.code().isbn10()   );
        bookMap.put("year", faker.number().numberBetween(1000,2021)   );
        bookMap.put("author",faker.book().author()   );
        bookMap.put("book_category_id", faker.number().numberBetween(1,20)   );  // in library app valid category_id is 1-20
        bookMap.put("description", faker.chuckNorris().fact() );

        return bookMap ;
    }


}
