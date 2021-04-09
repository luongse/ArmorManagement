package luongnd.Server2;

public class Validate {
    
    public boolean checkCode(String code) {
        if (code.matches("[\\w]{1,10}"))
            return true;
        return false;
    }
    
    public boolean checkClassification(String classification) {
        if (classification.matches("^[a-z A-Z 0-9]{1,}$"))
            return true;
        return false;
    }
    
    public boolean checkDescription(String description) {
        if (description.matches("^[a-z A-Z 0-9]{1,}$"))
            return true;
        return false;
    }
    
    public boolean checkDefense(int defense) {
        if (defense < 0)
            return true;
        return false;
    }
}
