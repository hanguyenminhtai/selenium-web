package tests.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    @Test(dataProvider = "usernameData")
    public void testDataProvider(User user){
        System.out.println(user);
    }

    @DataProvider
    public User[] usernameData(){
        User rover = new User("rover", 16);
        User eli = new User("eli", 34);
        return new User[]{rover, eli};
    }

    public static class User{
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
