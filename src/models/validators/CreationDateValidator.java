package models.validators;

import java.time.ZonedDateTime;

public class CreationDateValidator implements IValidatorable {
    @Override
    public boolean validate(String value) {
        try {
            ZonedDateTime temp = ZonedDateTime.parse(value);
            return temp.compareTo(ZonedDateTime.now()) < 1;
        }
        catch (Exception ex) {
            return false;
        }
    }
}
