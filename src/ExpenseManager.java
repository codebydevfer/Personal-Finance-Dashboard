import java.util.ArrayList;

public class ExpenseManager {
    ArrayList<Expense> expensesArray = new ArrayList<Expense>();

    public void addExpense(Expense expense){
        expensesArray.add(expense);
    }

    public void listExpenses(){
        for (int i = 0; i < expensesArray.size(); i++){
            System.out.println(expensesArray.get(i));
        }
    }

    public void total(){
        double sum = 0;
        for (int i = 0; i < expensesArray.size(); i++){
            sum += expensesArray.get(i).getAmount();
        }
        System.out.println("Total spent: " + sum);
    }
}