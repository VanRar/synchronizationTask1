public class Main {
    public static void main(String[] args) {
        Manufacturer manufacturer1 = new Manufacturer("Toyota");
        CarShowroom carShowroom = new CarShowroom(manufacturer1);

        new Thread(null, carShowroom::sellCar, "Покупатель 1").start();
        new Thread(null, carShowroom::sellCar, "Покупатель 2").start();
        new Thread(null, carShowroom::sellCar, "Покупатель 3").start();
        new Thread(null, carShowroom::sellCar, "Покупатель 4").start();
        // Водитель хлебопекарни, чья работа заключается в том, чтобы привезти хлеб - shop.acceptBread()
        new Thread(null, carShowroom::receiveCar, "Производитель").start();


    }
}