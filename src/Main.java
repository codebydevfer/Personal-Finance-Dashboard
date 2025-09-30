//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // 1. Create the manager
        ExpenseManager manager = new ExpenseManager();
        // 2. Create a few Expense objects
        Expense lunch = new Expense(10.00, "Food", "2025-09-30");
        Expense gas = new Expense(35.00, "Gas", "2025-09-29");
        // 3. Add them to the manager
        manager.addExpense(lunch);
        manager.addExpense(gas);
        // 4. List all expenses
        manager.listExpenses();
        // 5. Print the total
        manager.total();
    }
}