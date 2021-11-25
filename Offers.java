public abstract class Offers {

    private String Provider;
    private String Name;
    private String Price;
    private int Minutes;
    private int Texts;
    private int Internet;
    private String Student;
    private String Discount;


    public abstract String toString();

    public abstract boolean equals(Object O);

    public int getInternet() {
        return Internet;
    }

    public int getMinutes() {
        return Minutes;
    }

    public int getTexts() {
        return Texts;
    }

    public String getPrice() {
        return Price;
    }

    public String getProvider() {
        return Provider;
    }

    public String getStudent() {
        return Student;
    }

    public String getDiscount() {
        return Discount;
    }
}
