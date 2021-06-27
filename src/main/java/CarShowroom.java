
public class CarShowroom {
    Manufacturer manufacturer;

    public CarShowroom(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public synchronized void receiveCar(){
        try{
            System.out.println("Производитель " + manufacturer.getBrand() + " выпустил 1 авто");
            Thread.sleep(3000);
            manufacturer.getCars().add(new Car("Toyota", "RAV4"));
            System.out.println("Приступаю к продаже авто");
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized Car sellCar() {
        try{
            System.out.println("Покупаю машину");
            while (manufacturer.getCars().size() == 0){
                System.out.println("Машин нет");
                wait();
            }
            Thread.sleep(999);
            System.out.println("Машина куплена");
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return manufacturer.getCars().remove(0);
    }
}
