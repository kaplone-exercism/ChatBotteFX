package model;

import util.WebReplace;

import java.util.Map;

public class WebResult {

    private Map<String, Integer> results;
    String string;

    public Map<String, Integer> getResults() {
        return results;
    }

    public String getString() {
        return string;
    }

    public WebResult(String s){

        for (WebReplace wr : WebReplace.values()){
            s = s.replaceAll(wr.getIn(), wr.getOut());
        }

        string = s;

    }
}
