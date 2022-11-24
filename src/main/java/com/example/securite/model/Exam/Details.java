package com.example.securite.model.Exam;





public class Details {
    
    
    private String email;
    private String name ;
    private String prenom ;
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Language[] getLangages() {
        return langages;
    }

    public void setLangages(Language[] langages) {
        this.langages = langages;
    }

    public Language[] langages;






    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

 
 

}