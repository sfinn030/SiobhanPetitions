package org.example;

import java.util.List;

public class Petition {

    private Long id;
    public String name;

    private String signName;
    private String signemail;
    public String content;
    private String signDate;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSignemail() {
        return signemail;
    }
    public void setSignemail(String email){
        this.signemail= email;
    }

    private String image;
    private List<Signature> signatures;

    public void setSignatures(List<Signature> signatures) {
        this.signatures = signatures;
    }

    public List<Signature> getSignatures() {
        return signatures;
    }
    public void addSignature(Signature signature){
        this.signatures.add(signature);
    }

    public Long getId() {
        return id;
    }


    public void setContent(String content) {
        this.content = content;
    }
    public String getContent(){
        return this.content;
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

