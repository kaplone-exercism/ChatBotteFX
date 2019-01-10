package util;

public enum WebReplace {
    C3A9("%C3%A9", "é"),
    C3A8("%C3%A8", "è"),
    IT_1("<i>", ""),
    IT_2("</i>", ""),
    BOLD_1("<b>", ""),
    BOLD_2("</b>", ""),
    DIV("<div .*>", ""),
    DIV_1("</div>", ""),
    SPAN("<span .*>", ""),
    SPAN_1("</span>", ""),
    END("^.*</a></li></ul></div>", "")
    ;

    String in;
    String out;

    WebReplace(String in, String out){
        this.in = in;
        this.out = out;
    }

    public String getIn() {
        return in;
    }

    public String getOut() {
        return out;
    }
}
