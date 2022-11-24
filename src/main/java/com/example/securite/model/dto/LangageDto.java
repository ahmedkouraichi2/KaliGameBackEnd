package com.example.securite.model.dto;



public class LangageDto {
    
    private Long id;
    private String name;
    private String description;

@Override
    public String toString() {
        return "LangageDto [id=" + id + ", name=" + name + "]";
    }
public LangageDto() {
        super();
        // TODO Auto-generated constructor stub
    }


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
public String getDescription() {
    return description;
}
public void setDescription(String description) {
    this.description = description;
}

    

}

