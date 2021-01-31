package edu.qc.seclass.glm.http;


public class PostBean {
    private String calss;
    private String name;
    private String cid;
    private String method;

    public PostBean(String calss, String name, String cid) {
        this.calss = calss;
        this.name = name;
        this.cid = cid;
    }

    public PostBean(String calss, String name, String cid, String method) {
        this.calss = calss;
        this.name = name;
        this.cid = cid;
        this.method = method;
    }

    public String getCalss() {
        return calss;
    }

    public void setCalss(String calss) {
        this.calss = calss;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
