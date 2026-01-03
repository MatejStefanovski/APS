import java.util.Scanner;

class Person {
    String name;
    int age;
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "<" + name + ", " + age + ">";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person p = (Person) o;
        return age == p.age && name.equals(p.name);
    }
    @Override
    public int hashCode() {
        return age * (int) name.charAt(0);
    }
}

class Project {
    int time;
    int rate;

    Project(int time, int rate) {
        this.time = time;
        this.rate = rate;
    }

    int totalSalary() {
        return time * rate;
    }

    @Override
    public String toString() {
        return "<" + time + ", " + rate + ">";
    }
}

public class Proekti {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CBHT<Person, Project> table = new CBHT<>(10);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int age = sc.nextInt();
            int time = sc.nextInt();
            int rate = sc.nextInt();
            Person p = new Person(name, age);
            Project newProject = new Project(time, rate);
            SLLNode<MapEntry<Person, Project>> node = table.search(p);
            if (node == null) {
                table.insert(p, newProject);
            } else {
                Project oldProject = node.element.value;
                if (newProject.totalSalary() > oldProject.totalSalary()) {
                    table.insert(p, newProject);
                }
            }
        }
        System.out.println(table);
    }
}
