package models.validators;

public class LocationValidator {
    public boolean validateX (String value) {
        try {
            double temp = Double.parseDouble(value);
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }
    public boolean validateY (String value) {
        try {
            double temp = Double.parseDouble(value);
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }
}
