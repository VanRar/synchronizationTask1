
public class CarShowroom {
    public static final int SLEEP_TIME = 100;

    public static int salesPlan = 10;

    Manufacturer manufacturer;

    public CarShowroom(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public synchronized void receiveCar() {
        try {
            //наполняем салон автомобилями

            System.out.println("Производитель " + manufacturer.getBrand() + " выпустил 1 авто");
            Thread.sleep(SLEEP_TIME);
            manufacturer.getCars().add(new Car("Toyota", "RAV4"));

            System.out.println("Автосалон готов к продаже авто");

            notifyAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (salesPlan == 0 && !Thread.currentThread().isInterrupted()) {
            System.out.println(Thread.currentThread().getName() + " ПОКИДАЕТ");
            Thread.currentThread().interrupt();
        }

    }

    public synchronized void sellCar() {
        try {
            while (salesPlan > 1) {
                System.out.println(Thread.currentThread().getName() + " зашел в автосалон");

                while (manufacturer.getCars().size() == 0) {
                    System.out.println("Машин нет");
                    receiveCar();

                    if (!Thread.currentThread().isInterrupted()) {
                        wait();
                        Thread.sleep(SLEEP_TIME);
                    }
                }
                System.out.println(Thread.currentThread().getName() + " купил машину");
                manufacturer.getCars().remove(manufacturer.getCars().size() - 1);
                salesPlan -= 1;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!Thread.currentThread().isInterrupted()) {
            System.out.println(Thread.currentThread().getName() + " ПОКИДАЕТ МАГАЗИН");
            Thread.currentThread().interrupt();
        }

    }
}