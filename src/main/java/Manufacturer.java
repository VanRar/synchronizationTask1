import java.util.ArrayList;
import java.util.List;

public class Manufacturer {
    private String brand;
    CarShowroom carShowroom = new CarShowroom(this);
    List<Car> cars = new ArrayList<>(10);

    public Manufacturer(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public Car sellCar(){
        return carShowroom.sellCar();
    }
    public void acceptCar(){
        carShowroom.receiveCar();
    }
    List<Car> getCars(){
        return cars;
    }
}
