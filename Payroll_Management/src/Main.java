import java.util.ArrayList;

abstract class Employee
{
    private String name;
    private int ID;

    public Employee(String name,int ID)
    {
        this.name = name;
        this.ID   = ID;
    }

    public String getName()
    {
        return name;
    }
    public int getID()
    {
        return ID;
    }
    abstract public double calculateSalary();

    @Override
    public String toString()
    {
        return "Employee [name=" + name + ", id=" + ID + ", salary=" + calculateSalary() + "]";
    }
}

class FulltimeEmployee extends Employee
{
    private double monthlySalary;

    public FulltimeEmployee(String name,int ID, double monthlySalary)
    {
        super(name,ID);
        this.monthlySalary=monthlySalary;
    }
    public double calculateSalary()
    {
        return monthlySalary;
    }
}

class ParttimeEmployee extends Employee
{
    private double hourlySalary;
    private double hoursWorked;

    public ParttimeEmployee(String name,int ID, double hourlySalary,double hoursWorked)
    {
        super(name,ID);
        this.hourlySalary=hourlySalary;
        this.hoursWorked=hoursWorked;
    }
    public double calculateSalary()
    {
        return hourlySalary*hoursWorked;
    }
}

class Payroll
{
    private ArrayList<Employee> employeeList;

    public Payroll()
    {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee)
    {
        employeeList.add(employee);
    }

    public void removeEmployee(int id)
    {
        Employee employeeToRemove = null;
        for (Employee employee : employeeList)
        {
            if (employee.getID() == id)
            {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null)
        {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployee()
    {
        for(Employee employee:employeeList)
        {
            System.out.println(employee);
        }
    }
}
public class Main
{
    public static void main(String[] args)
    {
        Payroll payrollSystem = new Payroll();

        FulltimeEmployee emp1 = new FulltimeEmployee("Suhas Pai", 101, 100000.0);
        ParttimeEmployee emp2 = new ParttimeEmployee("Jane Smith", 102, 2000, 15.0);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);

        System.out.println("Initial Employee Details:");
        payrollSystem.displayEmployee();

        System.out.println("\nRemoving Employee...");
        payrollSystem.removeEmployee(102);

        System.out.println("\nRemaining Employee Details:");
        payrollSystem.displayEmployee();
    }
}