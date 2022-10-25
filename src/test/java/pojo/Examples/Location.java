package pojo.Examples;

import java.util.List;

import lombok.Data;

@Data
public class Location {

    private int id;
    private String city;
    private String country;
    private List<Address> address;

/*    Location(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCoutry(String coutry) {
        this.country = coutry;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }


*/

}
