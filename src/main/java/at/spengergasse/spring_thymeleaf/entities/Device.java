package at.spengergasse.spring_thymeleaf.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Device {
    @Id
    private String id;
    private String type;
    private String location;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
