package my.accesscontrol;

import java.util.regex.*;

public class HouseValidator {

    Pattern houseNumberPattern = Pattern.compile("^\\d{1,2}");
    Pattern codePattern = Pattern.compile("^\\d{4}");
    Pattern ownerPattern = Pattern.compile("^\\w+\\s+\\w+");
    
    public boolean isHouseNumberCorrect(String houseNumber) {
        return houseNumberPattern.matcher(houseNumber).matches();
    }
    
    public boolean isCodePatternCorrect(String code) {
        return codePattern.matcher(code).matches();
    }
    
    public boolean isOwnerPatternCorrect(String owner) {
        return ownerPattern.matcher(owner).matches();
    }
    
    public boolean notDuplicate(String houseNumber) {
        return House.notDuplicate(Integer.parseInt(houseNumber));
    }
}
