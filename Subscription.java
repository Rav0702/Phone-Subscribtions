import java.util.Objects;

public class Subscription extends Offers{

    private String Provider;
    private String Name;
    private String Price;
    private String Minutes;
    private String Texts;
    private String Internet;
    private String Student;
    private String Discount;


    public Subscription(String Provider, String Name, String Price, String Minutes, String Texts, String internet, String Student, String Discount)
    {
        this.Provider= Provider;
        this.Name= Name;
        this.Price= Price;
        this.Minutes= Minutes;
        this.Texts= Texts;
        this.Internet= internet;
        if(Student.equals("0"))
        {
            this.Student="There is no Student discount";
            this.Discount= "0%";
        }
        else
        {
            this.Student= "There is Student discount";
            this.Discount= Discount;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subscription)) return false;
        Subscription that = (Subscription) o;
        return getMinutes() == that.getMinutes() && getTexts() == that.getTexts() && getInternet() == that.getInternet() && Objects.equals(getProvider(), that.getProvider()) && Objects.equals(Name, that.Name) && Objects.equals(getPrice(), that.getPrice()) && Objects.equals(getStudent(), that.getStudent()) && Objects.equals(getDiscount(), that.getDiscount());
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "Provider='" + Provider + '\'' +
                ", Name='" + Name + '\'' +
                ", Price='" + Price + '\'' +
                ", Minutes=" + Minutes +
                ", Texts=" + Texts +
                ", Internet=" + Internet +
                ", Student='" + Student + '\'' +
                ", Discount='" + Discount + '\'' +
                '}';
    }


}
