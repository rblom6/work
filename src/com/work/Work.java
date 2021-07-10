// Here we define the class Employee, the subclass HourlyEmployee, and
// the all-static (main) class Work.  Note the use of the keywords
// "extends" and "super".

// Could have more subclasses: CommissionEmployee, Volunteer, etc.

package com.work;

class Employee
{
    String name;
    double salary;		// weekly
    Employee boss;

    Employee(String n, double s)
    {
	name = n;
	salary = s;
    }

    double getSalary() { return salary; }

    void doWork(double hours)
    {
         System.out.println(name + " does " + hours + " hours of work");
    }

    public String toString()
    {
	if (boss == null)
	    return name;
	else
	    return name + " (working for " + boss + ")";
    }
}

class HourlyEmployee extends Employee
{
    final double hourlyRate;
    double hoursWorked = 0.0;

    HourlyEmployee(String n, double r)
    {
	super(n, 0.0);
	hourlyRate = r;
    }

    double getSalary()
    {
	double ret = hourlyRate * hoursWorked;
	hoursWorked = 0.0;
	return ret;
    }

    void doWork(double hours)
    {
        super.doWork(hours);
	hoursWorked += hours;
    }
}

// This class just for main (same name as the file)
public class Work
{
    public static void main(String[] args)
    {
	Employee a = new Employee("Alice", 400.0);
	Employee c = new Employee("Carl", 300.0);
	Employee b = new HourlyEmployee("Bob", 7.5);
	c.boss = a;
	b.boss = c;

	System.out.println("First week, they both work no hours:");
	System.out.println(a + " earns " + a.getSalary());
	System.out.println(b + " earns " + b.getSalary());
	
	System.out.println();
	System.out.println("Second week, the both work 80 hours:");
	a.doWork(80);
	b.doWork(80);
	System.out.println(a + " earns " + a.getSalary());
	System.out.println(b + " earns " + b.getSalary());
    }
}
