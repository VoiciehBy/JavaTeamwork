package dbclass;

import connection.DBConnection;

import java.sql.SQLException;

public class EmployeeDAO {
    public static void hireEmployee(String firstName, String secondName, String surname, String date) {
        String insert = "INSERT INTO employees (firstName,secondName,surname,date) VALUES('"
                + firstName + "',"
                + "'" + secondName + "',"
                + "'" + surname + "',"
                + "str_to_date('" + date + "','%Y-%m-d'));";
        try {
            DBConnection.executeDML(insert);
            System.out.println(insert);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println("Following statement cannot be processed:" + insert);
        }
    }

    public static void deleteEmployee(int id, String firstName, String secondName, String surname, String date) {
        String delete = "DELETE FROM employees "
                + "WHERE id =" + id
                + "firstName = '" + firstName + "'"
                + "AND secondName = '" + secondName + "'"
                + "AND surname = '" + surname + "'"
                + "date = 'str_to_date('" + date + "','%Y-%m-d');";
        try {
            DBConnection.executeDML(delete);
            System.out.println(delete);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println("Following statement cannot be processed:" + delete);
        }
    }

    private static void updateStringColumn(int id, String columnName, String value) {
        String update = "UPDATE employees SET" + columnName + " = '" + value + "'"
                + "WHERE id =" + id + ";";
        try {
            DBConnection.executeDML(update);
            System.out.println(update);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println("Following statement cannot be processed:" + update);
        }
    }

    private static void updateDateColumn(int id, String columnName, String date) {
        String update = "UPDATE employees SET" + columnName + "= str_to_date('" + date + "','%Y-%m-d')"
                + "WHERE id =" + id + ";";
        try {
            DBConnection.executeDML(update);
            System.out.println(update);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println("Following statement cannot be processed:" + update);
        }
    }

    public static void updateFirstName(int id, String firstName) {
        updateStringColumn(id, "firstName", firstName);
    }

    public static void updateSecondName(int id, String secondName) {
        updateStringColumn(id, "secondName", secondName);
    }

    public static void updateSurname(int id, String surname) {
        updateStringColumn(id, "surname", surname);
    }

    public static void updateBirthDate(int id, String birthDate) {
        updateDateColumn(id, "birthDate", birthDate);
    }

    public static void updateEmployee(int id, String firstName, String secondName, String surname) {
        updateFirstName(id, firstName);
        updateSecondName(id, secondName);
        updateSurname(id, surname);
    }

    public static void updateEmployee(int id, String firstName, String secondName, String surname, String birthDate) {
        updateFirstName(id, firstName);
        updateSecondName(id, secondName);
        updateSurname(id, surname);
        updateBirthDate(id, birthDate);
    }
}
