public class Expense {
    private double amount;
    private String category;
    private String date;

    //Constructors
    public Expense(double amount, String category, String date){
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    //Getters
    public double getAmount(){
        return amount;
    }

    public String getCategory(){
        return category;
    }

    public String date(){
        return date;
    }

    //Setters
    public void setAmount(double amount){
        this.amount = amount;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public void setDate(String date){
        this.date = date;
    }

    //Print
    @Override
    public String toString() {
        return "Expense {" +
                "Amount = " + amount +
                ", Category = " + category +
                ", Date = " + date + "}";
    }
}



