package tests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Assert;
import org.junit.Test;
import services.IMDBSearchService;

import java.io.*;
import java.util.Objects;

/**
 * Created by william.eyre on 27/03/2017.
 *
 */
public class GsonTest {

    @Test
    public void testGson() {
        Gson gson = new GsonBuilder().create();
        gson.toJson("Hello", System.out);
        gson.toJson(123, System.out);
    }


    @Test
    public void testGsonWriting() throws IOException {
        Writer writer = new FileWriter("Out.json");

        Gson gson = new GsonBuilder().create();
        gson.toJson("Hello", writer);
        gson.toJson(123, writer);


        writer.close();
    }

    @Test
    public void testGsonUtf8() throws IOException {
        IMDBSearchService search = new IMDBSearchService();

        try(Writer writer = new OutputStreamWriter(new FileOutputStream("film.json") , "UTF-8")){
            Gson gson = new GsonBuilder().create();
            gson.toJson(search.searchForTitle("The Dark Knight"), writer);

        }
    }





    @Test
    public void testTheTest() {
        String hello = "Hello";
        String hello2 = "Hello";

        Assert.assertTrue(Objects.equals(hello, hello2));
    }
}

