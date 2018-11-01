package util;

import org.junit.Test;

import java.io.IOException;

public class UrlReaderTest {

    @Test
    public void readUrlTest_machine(){
        try {
            UrlReader.readURL("machine", 5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readUrlTest_non(){
        try {
            UrlReader.readURL("non", 4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readUrlTest_oui(){
        try {
            UrlReader.readURL("oui", 4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readUrlTest_peutetre(){
        try {
            UrlReader.readURL("peut-être", 4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readUrlTest_planete(){
        try {
            UrlReader.readURL("planète", 4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void readUrlTest_question(){
        try {
            UrlReader.readURL("question", 4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void readUrlTest_reponse(){
        try {
            UrlReader.readURL("réponse", 4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void readUrlTest_cuisine(){
        try {
            UrlReader.readURL("cuisine", 4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void readUrlTest_heure(){
        try {
            UrlReader.readURL("heure", 4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
