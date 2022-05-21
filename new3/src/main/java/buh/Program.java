package buh;

import java.sql.*;
import java.util.Scanner;

public class Program {
    public static void main(String... args) {
        Program program = new Program();
        program.open();

        //  program.insertDepartment();
        // program.insertProjects();
        //program.insertEmployees();
        //program.insertDepartments_employess();
        // program.select1();
        // program.select2();
        //program.select3();
        // program.select4();
        // program.select5();
        //program.select6();
        // program.select7();
        //program.select8();
        // program.select9();

        //program.delete();
        //program.delete2();

        //program.selectDepEmp();
        //program.selectProjDep();
        //program.selectDepEmp2();
        //program.selectProjEmpDep();
        //program.selectDepEmp3();

        program.close();
    }

    Connection co;

    void open() {
        try {

            Class.forName("org.sqlite.JDBC");
            co = DriverManager.getConnection(
                    "jdbc:sqlite:C:\\sqlite2\\new3\\src\\main\\java\\buh\\buhbuhgalteria.db");
            System.out.println("Connected");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void insertDepartment()
    {
        Scanner scanner= new Scanner(System.in);
        System.out.println("---Insert in department--- ");
        System.out.print("Enter id ");
        String id = scanner.nextLine();
        System.out.print("Enter department ");
        String name = scanner.nextLine();

        String query =
                "INSERT INTO departments(id, name) " +
                        "VALUES ('"+ id +"','"+ name +"')";

        try {
            Statement statement= co.createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("ALL OK! Date update.");
    }

    void insertDepartments_employess()
    {
        Scanner scanner= new Scanner(System.in);
        System.out.println("---Insert in departments_employees--- ");
        System.out.print("Enter id ");
        String id = scanner.nextLine();
        System.out.print("Enter department id ");
        String dep_id = scanner.nextLine();
        System.out.print("Enter employees id ");
        String emp_id = scanner.nextLine();
        String query =
                "INSERT INTO departments_employees (id, department_id, employee_id) " +
                        "VALUES ('"+ id +"','"+ dep_id +"','" + emp_id +"')";

        try {
            Statement statement= co.createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("ALL OK! Date update.");
    }

    void insertEmployees()
    {
        Scanner scanner= new Scanner(System.in);
        System.out.println("---Insert in employees--- ");
        System.out.print("Enter id ");
        String id = scanner.nextLine();
        System.out.print("Enter first name ");
        String name = scanner.nextLine();
        System.out.print("Enter father name ");
        String father = scanner.nextLine();
        System.out.print("Enter last name ");
        String last = scanner.nextLine();
        System.out.print("Enter  position ");
        String position = scanner.nextLine();
        System.out.print("Enter salary ");
        String salary = scanner.nextLine();

        String query =
                "INSERT INTO employees (id,first_name,pather_name,last_name,position,salary) " +
                        "VALUES ('"+ id +"','"+ name +"','"+ father +"','"+ last +"','"+ position +"','"+ salary +"')";

        try {
            Statement statement= co.createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("ALL OK! Date update.");
    }

    void insertProjects()
    {
        Scanner scanner= new Scanner(System.in);
        System.out.println("---Insert in Projects--- ");
        System.out.print("Enter id ");
        String id = scanner.nextLine();
        System.out.print("Enter project name ");
        String name = scanner.nextLine();
        System.out.print("Enter cost ");
        String cost = scanner.nextLine();
        System.out.print("Enter department id ");
        String dep_id = scanner.nextLine();
        System.out.print("Enter data begin ");
        String begin = scanner.nextLine();
        System.out.print("Enter date end ");
        String end = scanner.nextLine();
        System.out.print("Enter date and real ");
        String date_and_real = scanner.nextLine();

        String query =
                "INSERT INTO projects (id, name,cost,department_id,date_beg,date_end,date_end_real) " +
                        "VALUES ('"+ id +"','"+ name +"','"+ cost +"','"+ dep_id +"','"+ begin +"','"+ end +"','"+ date_and_real +"')";

        try {
            Statement statement= co.createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("ALL OK! Date update.");
    }

    void select1()
    {
        try
        {
            System.out.println("---Work in department--- ");
            Statement statement= co.createStatement();
            String query =" SELECT id, name FROM departments ORDER BY name";

            ResultSet rs = statement.executeQuery(query);
            while(rs.next())
            {
                int id = rs.getInt("id");
                String name=rs.getString("name");
                System.out.println(id + "\t " + name + "\t ");
            }
            rs.close();
            statement.close();
        }
        catch (Exception e)
        {
            System.out.println (e.getMessage());
        }
    }

    void select2()
    {
        try
        {
            System.out.println("---Work in department_emp--- ");
            Statement statement= co.createStatement();
            String query =" SELECT id, department_id,employee_id FROM departments_employees ORDER BY id";

            ResultSet rs = statement.executeQuery(query);
            while(rs.next())
            {
                int id = rs.getInt("id");
                String dep_id=rs.getString("department_id");
                String emplo_id=rs.getString("employee_id");
                System.out.println(id + "\t " + dep_id + "\t "+ emplo_id+"\t");
            }
            rs.close();
            statement.close();
        }
        catch (Exception e)
        {
            System.out.println (e.getMessage());
        }
    }

    void select3()
    {
        try
        {
            System.out.println("---Work in empl--- ");
            Statement statement= co.createStatement();
            String query =" SELECT id, first_name,pather_name, last_name, position , salary FROM employees ORDER BY id";

            ResultSet rs = statement.executeQuery(query);
            while(rs.next())
            {
                int id = rs.getInt("id");
                String name=rs.getString("first_name");
                String father=rs.getString("pather_name");
                String last=rs.getString("last_name");
                String position=rs.getString("position");
                String salary= rs.getString("salary");
                System.out.println(id + "\t " + name + "\t "+ father +
                        "\t "+ last + "\t "+ position + "\t "+ salary + "\t ");
            }
            rs.close();
            statement.close();
        }
        catch (Exception e)
        {
            System.out.println (e.getMessage());
        }
    }

    void select4()
    {
        try
        {
            System.out.println("---Work in progekt--- ");
            Statement statement= co.createStatement();
            String query =" SELECT id, name,cost,department_id," +
                    "date_beg,date_end,date_end_real FROM projects ORDER BY name";

            ResultSet rs = statement.executeQuery(query);
            while(rs.next())
            {
                int id = rs.getInt("id");
                String name=rs.getString("name");
                int cost= rs.getInt("cost");
                String dep_in=rs.getString("department_id");
                String beg=rs.getString("date_beg");
                String end=rs.getString("date_end");
                String end_real=rs.getString("date_end_real");

                System.out.println(id + "\t " + name + "\t "+ cost + "\t "+ dep_in + "\t " + beg + "\t " +
                        end + "\t " + end_real+ "\t ");
            }
            rs.close();
            statement.close();
        }
        catch (Exception e)
        {
            System.out.println (e.getMessage());
        }
    }

    void select5()
    {
        try {
            System.out.println("---Work in progects--- ");
            Statement statement = co.createStatement();
            String query = " SELECT  name,cost,department_id," +
                    "date_beg,date_end_real FROM projects ORDER BY cost";

            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("name");
                int cost = rs.getInt("cost");
                String dep_in = rs.getString("department_id");
                String beg = rs.getString("date_beg");
                String end_real = rs.getString("date_end_real");

                System.out.println( name + "\t " + cost + "\t " + dep_in + "\t " + beg + "\t "+ end_real + "\t ");
            }
        }
        catch (Exception e)
        {
            System.out.println (e.getMessage());
        }
    }

    void select6()
    {
        try
        { System.out.println("---Work in depar_emplo--- ");
            Statement statement= co.createStatement();
            String query =" SELECT id, department_id,employee_id FROM departments_employees ORDER BY department_id";

            ResultSet rs = statement.executeQuery(query);
            while(rs.next())
            {
                int id = rs.getInt("id");
                String dep_id=rs.getString("department_id");
                String emplo_id=rs.getString("employee_id");
                System.out.println(id + "\t " + dep_id + "\t "+ emplo_id+"\t");
            }
            rs.close();
            statement.close();
        }
        catch (Exception e)
        {
            System.out.println (e.getMessage());
        }
    }

    void select7()
    {
        try
        { System.out.println("---Work in employ--- ");
            Statement statement= co.createStatement();
            String query =" SELECT id, first_name,pather_name, last_name,position, salary FROM employees ORDER BY first_name";

            ResultSet rs = statement.executeQuery(query);
            while(rs.next())
            {
                int id = rs.getInt("id");
                String name=rs.getString("first_name");
                String father=rs.getString("pather_name");
                String last=rs.getString("last_name");
                String position=rs.getString("position");
                String salary= rs.getString("salary");
                System.out.println(id + "\t " + name + "\t "+ father +
                        "\t "+ last + "\t "+ position + "\t "+ salary + "\t ");
            }
            rs.close();
            statement.close();
        }
        catch (Exception e)
        {
            System.out.println (e.getMessage());
        }
    }

    void select8()
    {
        try
        {
            System.out.println("---Work in employ--- ");
            Statement statement= co.createStatement();
            String query =" SELECT id, first_name,pather_name, last_name,position, salary FROM employees ORDER BY salary DESC";

            ResultSet rs = statement.executeQuery(query);
            while(rs.next())
            {
                int id = rs.getInt("id");
                String name=rs.getString("first_name");
                String father=rs.getString("pather_name");
                String last=rs.getString("last_name");
                String position=rs.getString("position");
                String salary= rs.getString("salary");
                System.out.println(id + "\t " + name + "\t "+ father +
                        "\t "+ last + "\t "+ position + "\t "+ salary + "\t ");
            }
            rs.close();
            statement.close();
        }
        catch (Exception e)
        {
            System.out.println (e.getMessage());
        }
    }

    void select9()
    {
        try
        {
            System.out.println("---Work in emplo--- ");
            Statement statement= co.createStatement();
            String query =" SELECT id, first_name,pather_name, last_name,position, salary FROM employees ORDER BY salary DESC";

            ResultSet rs = statement.executeQuery(query);
            while(rs.next())
            {
                int id = rs.getInt("id");
                String name=rs.getString("first_name");
                String father=rs.getString("pather_name");
                String last=rs.getString("last_name");
                String position=rs.getString("position");
                String salary= rs.getString("salary");
                System.out.println(id + "\t " + name + "\t "+ father +
                        "\t "+ last + "\t "+ position + "\t "+ salary + "\t ");
            }
            rs.close();
            statement.close();
        }
        catch (Exception e)
        {
            System.out.println (e.getMessage());
        }
    }

    void delete()
    {
        try
        {
            Scanner scanner= new Scanner(System.in);
            System.out.println("---Delete in employees--- ");
            System.out.print("Enter last name ");
            String last = scanner.nextLine();
            Statement statement= co.createStatement();

            String query =" SELECT id FROM employees WHERE last_name='" + last + "' ;";

            ResultSet rs = statement.executeQuery(query);
            int id = 0;
            while(rs.next())
            {
                id = rs.getInt("id");
            }

            query =" DELETE FROM departments_employees " +
                    " WHERE employee_id = '" + id +"'  ;";

            statement.executeUpdate(query);

            query =" DELETE FROM employees " +
                    " WHERE last_name='" + last + "';";
            statement.executeUpdate(query);

            rs.close();
            statement.close();
            System.out.println("All OK!");
        }
        catch (Exception e)
        {
            System.out.println (e.getMessage());
        }
    }

    void delete2()
    {
        try
        {
            Scanner scanner= new Scanner(System.in);
            System.out.println("---Delete in projects--- ");
            System.out.print("Enter name ");
            String last = scanner.nextLine();
            Statement statement= co.createStatement();

            String query =" DELETE FROM projects " +
                    " WHERE name='" + last + "';";
            statement.executeUpdate(query);

            statement.close();
            System.out.println("All OK!");
        }
        catch (Exception e)
        {
            System.out.println (e.getMessage());
        }
    }

    void selectDepEmp()
    {
        try
        {
            System.out.println("---Work in emplo--- ");
            Statement statement= co.createStatement();
            String query =" SELECT departments.name, employees.first_name,employees.pather_name, employees.last_name,employees.position, employees.salary FROM departments,employees,departments_employees " +
                    "WHERE departments_employees.employee_id = employees.id AND departments_employees.department_id = departments.id ORDER BY salary DESC";

            ResultSet rs = statement.executeQuery(query);
            while(rs.next())
            {
                String id = rs.getString("name");
                String name=rs.getString("first_name");
                String father=rs.getString("pather_name");
                String last=rs.getString("last_name");
                String position=rs.getString("position");
                String salary= rs.getString("salary");
                System.out.println(id + "\t " + name + "\t "+ father +
                        "\t "+ last + "\t "+ position + "\t "+ salary + "\t ");
            }
            rs.close();
            statement.close();
        }
        catch (Exception e)
        {
            System.out.println (e.getMessage());
        }
    }

    void selectDepEmp3()
    {
        try
        {
            System.out.println("---Work in emplo--- ");
            Statement statement= co.createStatement();
            String query =" SELECT departments.name, employees.first_name,employees.pather_name, employees.last_name,employees.position, employees.salary FROM departments,employees,departments_employees " +
                    "WHERE departments_employees.employee_id = employees.id AND departments_employees.department_id = departments.id AND employees.last_name='Volkov' ORDER BY salary DESC";

            ResultSet rs = statement.executeQuery(query);
            while(rs.next())
            {
                String id = rs.getString("name");
                String name=rs.getString("first_name");
                String father=rs.getString("pather_name");
                String last=rs.getString("last_name");
                String position=rs.getString("position");
                String salary= rs.getString("salary");
                System.out.println(id + "\t " + name + "\t "+ father +
                        "\t "+ last + "\t "+ position + "\t "+ salary + "\t ");
            }
            rs.close();
            statement.close();
        }
        catch (Exception e)
        {
            System.out.println (e.getMessage());
        }
    }

    void selectProjDep()
    {
        try
        {
            System.out.println("---Work in project--- ");
            Statement statement= co.createStatement();
            String query =" SELECT projects.name, departments.name ,projects.cost FROM projects,departments " +
                    "WHERE projects.department_id = departments.id ORDER BY cost";

            ResultSet rs = statement.executeQuery(query);
            while(rs.next())
            {
                String id = rs.getString("name");
                String name=rs.getString(2);
                String salary= rs.getString("cost");
                System.out.println(id + "\t " + name + "\t "+ salary + "\t ");
            }
            rs.close();
            statement.close();
        }
        catch (Exception e)
        {
            System.out.println (e.getMessage());
        }
    }

    void selectDepEmp2()
    {
        try
        {
            System.out.println("---Work in emplo--- ");
            Statement statement= co.createStatement();
            String query =" SELECT departments.name, employees.first_name,employees.pather_name, employees.last_name, employees.salary FROM departments,employees,departments_employees " +
                    "WHERE departments_employees.employee_id = employees.id AND departments_employees.department_id = departments.id ORDER BY salary DESC";

            ResultSet rs = statement.executeQuery(query);
            while(rs.next())
            {
                String id = rs.getString("name");
                String name=rs.getString("first_name");
                String father=rs.getString("pather_name");
                String last=rs.getString("last_name");
                String salary= rs.getString("salary");
                System.out.println(id + "\t " + name + "\t "+ father +
                        "\t "+ last + "\t " + salary + "\t ");
            }
            rs.close();
            statement.close();
        }
        catch (Exception e)
        {
            System.out.println (e.getMessage());
        }
    }

    void selectProjEmpDep()
    {
        try
        {
            System.out.println("---Work in project--- ");
            Statement statement= co.createStatement();
            String query =" SELECT projects.name, departments.name ,projects.cost FROM projects,departments " +
                    "WHERE projects.department_id = departments.id AND departments.name = 'Cartoons' ORDER BY cost";

            ResultSet rs = statement.executeQuery(query);
            while(rs.next())
            {
                String id = rs.getString("name");
                String name=rs.getString(2);
                String salary= rs.getString("cost");
                System.out.println(id + "\t " + name + "\t "+ salary + "\t ");
            }
            rs.close();
            statement.close();
        }
        catch (Exception e)
        {
            System.out.println (e.getMessage());
        }
    }

    void close()
    {
        try {
            co.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}