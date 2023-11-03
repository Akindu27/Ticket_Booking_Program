public class Ticket {
    private final int row;
    private final int seat;
    private final int price;
    private final Person person;

    public Ticket(Person person,int row,int seat,int price){                    //constructor method for Ticket class
        this.row=row;
        this.seat=seat;
        this.price=price;
        this.person=person;
    }

    public int getPrice() {                                     //getter method for price attribute
        return price;
    }

    public int getRow() {                                       //getter method for row attribute
        return row;
    }

    public int getSeat() {                                      //getter method for seat attribute
        return seat;
    }
                                                                //operational print method to print the data when the method is called.
    public String print(){
        String dataToPrint=("\nName: "+person.getName()+"\nSurname: "+person.getSurname()+"\nE-mail: "+person.getEmail()+"\nRow no: "+row+"\nSeat no: "+seat+"\nTicket price: £"+price+"\n");
        return dataToPrint;
    }

}
