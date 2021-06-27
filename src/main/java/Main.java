public class Main {
    public static void main(String[] args) {
        Manufacturer manufacturer1 = new Manufacturer("Toyota");
        CarShowroom carShowroom = new CarShowroom(manufacturer1);

        for(int i =0 ; i<10; i++){
            // Покупатель, чья работа заключается в том, чтобы купить хлеб - shop.sellBread()
            new Thread(null, carShowroom::sellCar, "Продаём").start();
            // Водитель хлебопекарни, чья работа заключается в том, чтобы привезти хлеб - shop.acceptBread()
            new Thread(null, carShowroom::receiveCar, "Производим").start();
        }
    }
}