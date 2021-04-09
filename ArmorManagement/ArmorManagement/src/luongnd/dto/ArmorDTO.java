package luongnd.dto;

import java.io.Serializable;

public class ArmorDTO implements Serializable{
    private String armorID;
    private String classification;
    private String description;
    private String status;
    private String date;
    private int defense;

    public ArmorDTO() {
    }

    public ArmorDTO(String armorID, String classification, String description, String status, String date, int defense) {
        this.armorID = armorID;
        this.classification = classification;
        this.description = description;
        this.status = status;
        this.date = date;
        this.defense = defense;
    }

    public String getArmorID() {
        return armorID;
    }

    public void setArmorID(String armorID) {
        this.armorID = armorID;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    
}
