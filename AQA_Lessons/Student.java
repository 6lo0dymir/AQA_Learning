import java.util.*;

public class Student {
    private String name;
    private String group;
    private int course;
    private Map<String, Integer> grades;

    public Student(String name, String group, int course){
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new HashMap<>();
    }
    public void addGrade (String subject, int grade){
        if (grade < 1 || grade > 5){
            throw new IllegalArgumentException ("Оценка должна быть от 1 до 5");
        }
        grades.put(subject, grade);
    }
    public double getAverageGrade(){
        if (grades.isEmpty()){
            return 0.0;
        }
        int sum = 0;
        for (int grade : grades.values()){
            sum += grade;
        }
        return (double) sum / grades.size();
    }
    public void promoteToNextCourse() {
        if (this.course < 5){
            this.course ++;
            System.out.println(name + " переведен на " + course + " курс.");
        }else {
            System.out.println("Уже выпустился");
        }
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public Map<String, Integer> getGrades() {
        return new HashMap<>(grades);
    }
    @Override
    public String toString(){
        return String.format ("Студент %s, группа %s, курс %d, средний балл %.2f", name, group, course, getAverageGrade());
    }
    @Override
    public boolean equals(Object o){
        if ( this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals (name, student.name) &&
                Objects.equals(group, student.group);

    }
    @Override
    public int hashCode(){
        return Objects.hash(name, group);
    }
}
class StudentsManager {
    private Set<Student> students;

    public StudentsManager() {
        students = new HashSet<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeBadGradeStudents() {
        System.out.println("Отчисляем студентов с плохой средней оценкой");
        System.out.println(" ");
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() < 3) {
                System.out.println("Студент " + student.getName() + " отчислен за неуспеваемость " +
                        " средняя оценка " + String.format("%.2f", student.getAverageGrade()));
                iterator.remove();
            }
        }
    }

    public void promoteGoodGradeStudents() {
        System.out.println("Переводим на следующий курс студентов с хорошими оценками");
        System.out.println(" ");
        for (Student student : students) {
            if (student.getAverageGrade() >= 3) {
                student.promoteToNextCourse();
            }
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        System.out.println("Список студентов " + course + (" курса"));
        boolean found = false;

        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName() + " группа " + student.getGroup() + " средняя оценка " +
                        String.format("%.2f", student.getAverageGrade()));
                found = true;
            }

        }
        if (!found) {
            System.out.println("На курсе " + course + " нет студентов");
        }

    }

    public Set<Student> getStudents() {
        return new HashSet<>(students);
    }

    public void printAllStudents() {
        System.out.println("Список студентов");
        System.out.println(" ");
        if (students.isEmpty()) {
            System.out.println("Нет студентов");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        StudentsManager manager = new StudentsManager();

        Student student1 = new Student("Иванов Иван", "ПИ-111", 1);
        student1.addGrade("Информатика", 2);
        student1.addGrade("Математика", 3);
        student1.addGrade("История", 4);

        Student student2 = new Student("Сидорова Мария", "ПИ-110", 2);
        student2.addGrade("Информатика", 5);
        student2.addGrade("Математика", 4);
        student2.addGrade("История", 4);

        Student student3 = new Student("Алексеев Сергей", "ПИ-109", 3);
        student3.addGrade("Информатика", 2);
        student3.addGrade("Математика", 2);
        student3.addGrade("История", 1);

        Student student4 = new Student("Жданов Евгений", "ПИ-107", 1);
        student4.addGrade("Информатика", 4);
        student4.addGrade("Математика", 4);
        student4.addGrade("История", 1);

        Student student5 = new Student("Иванова Ксения", "ПИ-109", 3);
        student5.addGrade("Информатика", 5);
        student5.addGrade("Математика", 1);
        student5.addGrade("История", 4);

        manager.addStudent(student1);
        manager.addStudent(student2);
        manager.addStudent(student3);
        manager.addStudent(student4);
        manager.addStudent(student5);

        manager.printAllStudents();

        manager.removeBadGradeStudents();

        System.out.println("Список студентов после отчисления");
        manager.printAllStudents();

        manager.promoteGoodGradeStudents();

        System.out.println("Перешли на следующий курс");
        manager.printAllStudents();

        StudentsManager.printStudents(manager.getStudents(), 1);
        StudentsManager.printStudents(manager.getStudents(), 2);
        StudentsManager.printStudents(manager.getStudents(), 3);






    }
}