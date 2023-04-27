package models.validators;

public class CoordinatesYValidator implements IValidatorable {
    @Override
    public boolean validate(String value) {
        try {
            int temp = Integer.parseInt(value);
            return temp > -807;
        }
        catch (Exception ex) {
            return false;
        }
    }
}
