package models.validators;

public class NameValidator implements IValidatorable {
    @Override
    public boolean validate(String value) {
        return !value.equals("");
    }
}
