public class Main {
    public static void main(String[] args) {
        Manufacturer manufacturer1 = new Manufacturer("Toyota");
        CarShowroom carShowroom = new CarShowroom(manufacturer1);

        //как-то это выглядит явно не правильно, но работает)
        //по хорошему надо нарна что бы покупарель инициализировал заявку в автосалон, тот уже прокидывал заявку на фабрику
        //ну и да, тут по сути получается у меня нет покупателя.
        for(int i =0 ; i<10; i++){
            // Покупатель, чья работа заключается в том, чтобы купить хлеб - shop.sellBread()
            new Thread(null, carShowroom::sellCar, "Продаём").start();
            // Водитель хлебопекарни, чья работа заключается в том, чтобы привезти хлеб - shop.acceptBread()
            new Thread(null, carShowroom::receiveCar, "Производим").start();
        }
    }
}