import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Connecting to Database
        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            System.out.println("Connected to Database through DBConnection!");
        }

        try {
            // 1. Get a connection from your DBConnection class
            conn = DBConnection.getConnection();

            // 2. Insert a new expense
            String insertSql = "INSERT INTO expenses (amount, category, date) VALUES (?, ?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertSql);

            // TODO: set the values for amount, category, and date here
            insertStmt.setDouble(1, 12.50);          // amount
            insertStmt.setString(2, "Food");         // category
            insertStmt.setString(3, "2025-09-30");   // date (YYYY-MM-DD)

            // TODO: execute the insert
            insertStmt.executeUpdate();

            insertStmt.close();

            System.out.println("Expense inserted successfully!");

            // 3. Read all expenses
            String selectSql = "SELECT * FROM expenses";
            PreparedStatement selectStmt = conn.prepareStatement(selectSql);
            ResultSet rs = selectStmt.executeQuery();

            // TODO: loop through the ResultSet and print each expense
            System.out.println("Current Expenses in DB:");
            while (rs.next()) {
                int id = rs.getInt("id");
                double amount = rs.getDouble("amount");
                String category = rs.getString("category");
                String date = rs.getString("date");

                System.out.println(id + ": $" + amount + " - " + category + " on " + date);
            }

            rs.close();
            selectStmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

//        // 1. Create the manager
//        ExpenseManager manager = new ExpenseManager();
//        // 2. Create a few Expense objects
//        Expense lunch = new Expense(10.00, "Food", "2025-09-30");
//        Expense gas = new Expense(35.00, "Gas", "2025-09-29");
//        // 3. Add them to the manager
//        manager.addExpense(lunch);
//        manager.addExpense(gas);
//        // 4. List all expenses
//        manager.listExpenses();
//        // 5. Print the total
//        manager.total();
    }
}