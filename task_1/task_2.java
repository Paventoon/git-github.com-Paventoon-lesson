public class  task_2 {

}
    

    int id;
    String manufacturer;
    int size;
    String processor;
    int ram;
    int hdd;
    String os;
    String color;
    int price;

    @Override
    public String toString() {
    
        return String.format("\nПроизводитель: %s, Диагональ экрана: %d,\n" +
                "Процессор: %s, Объем оперативной памяти: %d, Объем HDD: %d,\n" +
                "Операционная система: %s, Цвет: %s, Цена: %d\n", manufacturer, size, processor, ram, hdd, os, color, price);
    }    
