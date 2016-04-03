package my.accesscontrol;

public class DataHandler {
    
    
    public static void getDataFromController() {
        /*Beleteszi a House class houseList mezőjébe a controlleren lévő adatokat*/
        testReader();
    }   

    
    public static void updateController() {
        /*Frissíti a controlleren lévő adatokat.*/
    }
    
    static void testReader() {
        House.getHouseList().add(new House(2, 122, "Velekey Evelin"));
        House.getHouseList().add(new House(3, 456, "Kocsis Vanda"));
        House.getHouseList().add(new House(4, 789, "Borsós Zoltán"));
    }
}
