import java.util.Objects;

public class Prepaid extends Offers{

    private String Provider;
    private String Name;
    private String Price;
    private String Minutes;
    private String Texts;
    private String Internet;
    private String Student;
    private String Discount;
    private boolean T_carry;
    private boolean M_carry;
    private boolean I_carry;
    public Prepaid(String Provider, String Name, String Price, String Minutes, String Texts, String internet, boolean M_carry, boolean T_carry, boolean I_carry, String Student, String Discount)
    {
        this.Provider= Provider;
        this.Name= Name;
        this.Price= Price;
        this.Minutes= Minutes;
        this.Texts= Texts;
        this.Internet= internet;
        this.I_carry= I_carry;
        this.M_carry= M_carry;
        this.T_carry= T_carry;
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
    public String toString() {
        return "Prepaid{" +
                "Provider='" + Provider + '\'' +
                ", Name='" + Name + '\'' +
                ", Price='" + Price + '\'' +
                ", Minutes=" + Minutes +
                ", Texts=" + Texts +
                ", Internet=" + Internet +
                ", Student='" + Student + '\'' +
                ", Discount='" + Discount + '\'' +
                ", T_carry=" + T_carry +
                ", M_carry=" + M_carry +
                ", I_carry=" + I_carry +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prepaid)) return false;
        Prepaid prepaid = (Prepaid) o;
        return getMinutes() == prepaid.getMinutes() && getTexts() == prepaid.getTexts() && getInternet() == prepaid.getInternet() && T_carry == prepaid.T_carry && M_carry == prepaid.M_carry && I_carry == prepaid.I_carry && Objects.equals(getProvider(), prepaid.getProvider()) && Objects.equals(Name, prepaid.Name) && Objects.equals(getPrice(), prepaid.getPrice()) && Objects.equals(getStudent(), prepaid.getStudent()) && Objects.equals(getDiscount(), prepaid.getDiscount());
    }

    public boolean isI_carry() {
        return I_carry;
    }

    public boolean isM_carry() {
        return M_carry;
    }

    public boolean isT_carry() {
        return T_carry;
    }
}
