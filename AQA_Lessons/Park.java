public class Park {
    private String parkName;
    private String parkLocation;
    public Park (String parkName, String parkLocation){
        this.parkLocation = parkLocation;
        this.parkName = parkName;
    }
    public class Attractions{
        private String attractionName;
        private String workTime;
        private double ticketPrice;
        public Attractions (String attractionName, String workTime, double ticketPrice){
            this.attractionName = attractionName;
            this.workTime = workTime;
            this.ticketPrice = ticketPrice;
        }
        public void printAttractionInfo(){
            System.out.println("Название аттрациона: "+ attractionName);
            System.out.println("Время работы: "+ workTime);
            System.out.println("Стоимость билета: " + ticketPrice +"р.");
        }
    }
    public void printParkInfo(){
        System.out.println("Название парка: "+ parkName);
        System.out.println("Местоположение: "+ parkLocation);

    }

    public static void main(String[] args) {
        Park Gorky = new Park("Им. Горького", "Москва");
        Park.Attractions carousel = Gorky.new Attractions("Карусель", "С 10-00 до 20-00", 155.50);
        Gorky.printParkInfo();
        carousel.printAttractionInfo();
    }

}

