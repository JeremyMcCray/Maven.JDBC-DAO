package models;

public class Cars {
    int id;
    String make;
    String model;
    Integer year;
    String color;
    String vin;


    public Cars(){}


    public int getId() {
        return id;
    }

    public Cars(int id, String make, String model, Integer year, String color, String vin){
        this.id = id;
        this.color=color;
        this.make=make;
        this.model=model;
        this.year=year;
        this.vin=vin;
    }

    public Cars(String make, String model, Integer year, String color, String vin){

        this.color=color;
        this.make=make;
        this.model=model;
        this.year=year;
        this.vin=vin;
    }



    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}
