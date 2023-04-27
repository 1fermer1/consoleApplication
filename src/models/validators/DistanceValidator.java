package models.validators;

public class DistanceValidator implements IValidatorable {
    @Override
    public boolean validate(String value) {
        try {
            int temp = Integer.parseInt(value);
            return temp > 1;
        }
        catch (Exception ex) {
            return false;
        }
    }
}
