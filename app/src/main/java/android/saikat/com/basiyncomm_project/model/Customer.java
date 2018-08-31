package android.saikat.com.basiyncomm_project.model;

/**
 * Created by trisys on 14/7/18.
 */

public class Customer {
    private String name;
    private String adreess;
    private String date;

    public Customer(String name, String adreess, String date) {
        this.name = name;
        this.adreess = adreess;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getAdreess() {
        return adreess;
    }

    public String getDate() {
        return date;
    }
}
