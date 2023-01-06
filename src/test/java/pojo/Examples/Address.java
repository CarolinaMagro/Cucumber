package pojo.Examples;

import lombok.Builder;
import lombok.Data;

@Data
public class Address {
    private String street;
    private String flat_no;
    private int pincode;
    private String type;

 /*   public String getStreet() {
        return street;
    }

    Address(){}

    public void setStreet(String street) {
        this.street = street;
    }

    public String getFlat_no() {
        return flat_no;
    }

    public void setFlat_no(String flat_no) {
        this.flat_no = flat_no;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

*/


}
