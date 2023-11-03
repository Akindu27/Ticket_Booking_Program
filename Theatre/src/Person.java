public class Person {
    private final String name;
    private final String surname;
    private final String email;

    public Person (String name,String surname,String email){                    //constructor method for Person class
        this.name=name;
        this.surname=surname;
        this.email=email;
    }

    public String getName() {                           //getter method for name attribute
        return name;
    }

    public String getSurname() {                        //getter method for surname attribute
        return surname;
    }

    public String getEmail() {                          //getter method for email attribute
        return email;
    }
}
