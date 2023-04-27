package models.validators;

public class LocationYValidator implements IValidatorable {
    @Override
    public boolean validate(String value) {
        try {
            double temp = Double.parseDouble(value);
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }
}
