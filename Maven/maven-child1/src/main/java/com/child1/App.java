package com.child1;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );

        Gson gson = new Gson();
        String json = gson.toJson("Hello, Gson!");
        System.out.println("Serialized JSON: " + json);




    }
}
