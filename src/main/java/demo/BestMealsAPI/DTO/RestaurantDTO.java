package demo.BestMealsAPI.DTO;

import demo.BestMealsAPI.Model.Restaurant;


public class RestaurantDTO {

    private int id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zipCode;


    public RestaurantDTO() {
    }

    public RestaurantDTO(Restaurant restaurant) {
        this.id = restaurant.getId();
        this.name = restaurant.getName();
        this.address = restaurant.getAddress();
        this.city = restaurant.getCity();
        this.state = restaurant.getState();
        this.zipCode = restaurant.getZipCode();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}
