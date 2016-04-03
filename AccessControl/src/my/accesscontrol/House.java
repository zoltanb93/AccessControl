package my.accesscontrol;

import java.util.ArrayList;
import java.util.List;

public class House {

    private int houseNumber;
    private int code;
    private String residents;

    private static List<House> houseList = new ArrayList<>();

    public House(int houseNumber, int code, String residents) {
        this.houseNumber = houseNumber;
        this.code = code;
        this.residents = residents;
    }
    
    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setResidents(String residents) {
        this.residents = residents;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public int getCode() {
        return code;
    }

    public String getResidents() {
        return residents;
    }

    public static List<House> getHouseList() {
        return houseList;
    }
    

    public static void addToList(House h) {
        houseList.add(h);
    }
    
    public static void editList(int houseNumber, int code, String residents, int index) {
        houseList.get(index).setHouseNumber(houseNumber);
        houseList.get(index).setCode(code);
        houseList.get(index).setResidents(residents);
    }

    public static void removeFromList(int index) {
        houseList.remove(houseList.get(index));
    }
    
    public static boolean notDuplicate(int houseNumber) {
        boolean retVal = true;
        
        for(House h : houseList) {
            if(houseNumber == h.getHouseNumber()) {
                retVal = false;
                return retVal;
            }
            
        }
        
        return  retVal;
    }
    
   
}
