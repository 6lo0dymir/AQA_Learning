import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> book;

    public PhoneBook (){
        book = new HashMap<>();
    }
    public void add(String surname, String phoneNumber){
        book.putIfAbsent(surname, new ArrayList<>());
        List<String> phones = book.get(surname);

        if (!phones.contains(phoneNumber)){
            phones.add(phoneNumber);
            System.out.println("Добавлен " + surname + " номер телефона " + phoneNumber);
        }else{
            System.out.println("Номер " + phoneNumber + " уже зарегистрирован на " + surname);
        }
    }
    public List<String> get(String surname){
        return book.getOrDefault(surname, new ArrayList<>());
    }
    public void getAndPrint(String surname){
        List<String> phones = get(surname);

        if (phones.isEmpty()){
            System.out.println("Фамилия " + surname + " не найдена в справочнике");
        }else{
            System.out.println("Телефоны для фамилии " + surname + " : ");
            for (int i=0; i < phones.size(); i++){
                System.out.println((i + 1) + ". " + phones.get(i));
            }
        }

    }
    public boolean remove(String surname, String phoneNumber) {
        List<String> phones = book.get(surname);
        if (phones != null && phones.remove(phoneNumber)) {
            System.out.println("Удалён номер " + phoneNumber + " у " + surname);

            // Если после удаления список пуст - удаляем запись
            if (phones.isEmpty()) {
                book.remove(surname);
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PhoneBook book = new PhoneBook();

        System.out.println("1. ДОБАВЛЕНИЕ ЗАПИСЕЙ:");
        book.add("Иванов", "+7-999-111-22-33");
        book.add("Петров", "+7-999-222-33-44");
        book.add("Сидоров", "+7-999-333-44-55");
        book.add("Иванов", "+7-999-444-55-66"); // Второй номер для Иванова
        book.add("Иванов", "+7-999-111-22-33"); // Дубликат - не должен добавится
        book.add("Петрова", "+7-999-555-66-77");
        book.add("Петров", "+7-999-666-77-88"); // Второй номер Петрова

        book.getAndPrint("Петров");
        book.getAndPrint("Иванов");
        book.getAndPrint("Жданов");
    }


}

