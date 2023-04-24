package models.validators;

public class CoordinatesValidator {
    public boolean validateX (String value) {
        try {
            long temp = Long.parseLong(value);
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }
    public boolean validateY (String value) {
        try {
            int temp = Integer.parseInt(value);
            return temp > -807;
        }
        catch (Exception ex) {
            return false;
        }
    }


}
