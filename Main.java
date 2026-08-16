class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    
    public void displayInfo() {
        System.out.println("ID:" + id);
        System.out.println("Name:" + name);
        System.out.println("Salary:" + salary);
    }

    public void increaseSalary(double percentage) {
        salary += salary * (percentage / 100.0);
    }

    public double getAnnualSalary() {
        return salary * 12;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
}


class Department {
    private String departmentName;
    private Employee manager;
    private Employee employee1;
    private Employee employee2;

    public Department(String departmentName, Employee manager) {
        this.departmentName = departmentName;
        this.manager = manager;
        this.employee1 = null;
        this.employee2 = null;
    }

    public void addEmployee(Employee employee) {
        if (employee1 == null) {
            employee1 = employee;
        } else if (employee2 == null) {
            employee2 = employee;
        } else {
            System.out.println("Department is full.");
        }
    }

    
    public void displayDepartmentInfo() {
        System.out.println("Department:" + departmentName);
        System.out.println("Manager:");
        manager.displayInfo();
        System.out.println("Employees:");
        if (employee1 != null) employee1.displayInfo();
        if (employee2 != null) employee2.displayInfo();
    }

    public double getTotalSalary() {
        double total = manager.getSalary();
        if (employee1 != null) total += employee1.getSalary();
        if (employee2 != null) total += employee2.getSalary();
        return total;
    }
}


class Project {
    private String projectName;
    private Employee projectManager;
    private Employee assignedEmployee1;
    private Employee assignedEmployee2;

    public Project(String projectName, Employee projectManager) {
        this.projectName = projectName;
        this.projectManager = projectManager;
        this.assignedEmployee1 = null;
        this.assignedEmployee2 = null;
    }

    public void assignEmployee(Employee employee) {
        if (assignedEmployee1 == null) {
            assignedEmployee1 = employee;
        } else if (assignedEmployee2 == null) {
            assignedEmployee2 = employee;
        } else {
            System.out.println("Project is full.");
        }
    }

    
    public void displayProjectInfo() {
        System.out.println("Project:" + projectName);
        System.out.println("Project Manager:" + projectManager.getName());
        System.out.println("Employee1:" + assignedEmployee1.getName());
        System.out.println("Employee2:" + assignedEmployee2.getName());
    }
}





public class CompanyApp {
    public static void main(String[] args) {
       
        Employee empMohamed = new Employee(100, "Mohammed", 15000);
        Employee empAhmed = new Employee(101, "Ahmed", 10000);
        Employee empAli = new Employee(102, "Ali", 9000);

       
        Department dept = new Department("Software Engineering", empMohamed);

        
        dept.addEmployee(empAhmed);
        dept.addEmployee(empAli);

        
        dept.displayDepartmentInfo();

        
        empAhmed.increaseSalary(10);
        
        System.out.println("New Salary:" + empAhmed.getSalary());

        
        dept.displayDepartmentInfo();

        
        System.out.println("Total Monthly Salary:" + dept.getTotalSalary());

        
        Project project = new Project("E-Commerce Automation", empMohamed);
        project.assignEmployee(empAhmed);
        project.assignEmployee(empAli);
        project.displayProjectInfo();
    }
}