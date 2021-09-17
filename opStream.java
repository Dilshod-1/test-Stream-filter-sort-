package lesson2_stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class opStream {
    public enum None{
        USA,BELARUS,RUSSIA
    }

    public static void main(String[] args) {
        List<User> persons = getUsers();
      List<User> userList = persons.stream()
        // filer steams
//              .filter(user -> user.getNone().equals(None.BELARUS))
//              .collect(Collectors.toList());
//      userList.forEach(System.out::println);
              //Sort
        .sorted(Comparator.comparing(User::getAge).thenComparing(User::getNone).reversed())
              .collect(Collectors.toList());
                persons.forEach(System.out::println);
    }

    private static List<User> getUsers() {
        return List.of(
                new User(2,"Dilshod",25,None.BELARUS),
                new User(1,"Oleg",27,None.RUSSIA),
                new User(3,"Jori",21,None.USA)
        );
    }

    public static class  User{
        private long id;
        private String name;
        private int age;
        private None none;

        public User(long id, String name, int age, None none) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.none = none;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", none=" + none +
                    '}';
        }

        public None getNone() {
            return none;
        }

        public void setNone(None none) {
            this.none = none;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
