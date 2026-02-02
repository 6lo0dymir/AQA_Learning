
public class Product {
    private String productName;
    private String dateOfManufacturing;
    private String manufacturer;
    private String country;
    private double price;
    private boolean reserved;

    public Product(String productName, String dateOfManufacturing, String manufacturer, String country, double price, boolean reserved ){
        this.productName = productName;
        this.dateOfManufacturing = dateOfManufacturing;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.reserved = reserved;
    }
    public void printProductInfo(){
        System.out.println();
        System.out.println("Название: "+productName);
        System.out.println("Дата производства: "+ dateOfManufacturing);
        System.out.println("Производитель: "+ manufacturer);
        System.out.println("Страна происхождения: "+ country);
        System.out.println("Цена: "+ price);
        System.out.println("Забронировано: "+ reserved);
        System.out.println();
    }

    public static void main(String[] args) {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",
                "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("Samsung A55", "03.05.2022",
                "Samsung Corp.", "Korea", 13999, false);
        productsArray[2] = new Product("Xiaomi T13", "01.10.2022",
                "Xiaomi", "China", 29990, true);
        productsArray[3] = new Product("Huawei Pura 80 Ultra", "01.02.2024",
                "Huawei", "China", 39990, true);
        productsArray[4] = new Product("Apple iPhone X", "01.02.2017",
                "Apple", "China", 79990, true);
        for (int i=0; i<productsArray.length; i++){
            System.out.println("Товар № " + (i+1));
            productsArray[i].printProductInfo();
        }
    }

}
