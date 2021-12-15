package com.cydeo.utility;

public class LibraryDB_Util {

    public static String getModuleQuery(String module){
        String query;
        switch (module){
            case "Users":
                query="select count(*) from users";
                break;
            case "Books":
                query="select count(*) from books";
                break;
            case "Borrowed Books":
                query="select count(*) from books b inner join book_borrow bb on b.id=bb.book_id where bb.is_returned=0";
                break;
            default:
                throw  new RuntimeException("Unexpected Module name "+ module);
        }

        return query;
    }
}
