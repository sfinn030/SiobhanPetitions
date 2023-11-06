package org.example;

public class Petition {

    private Long id;
    private String name;

    private String signName;

    private String signDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    public String getSignName() {
        return signName;
    }
}
