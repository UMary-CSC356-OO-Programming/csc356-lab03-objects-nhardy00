 import java.util.Scanner;

class Employee
{
	/* Task 3B: Add instance variables */
	private String firstName;
	private String lastName;
	private int employeeId;
	private double salary;
  
   
	/* Task 3C: Add three constructors */
   public Employee()
   {
	   this.firstName = "No First Name";
	   this.lastName = "No Last Name";
	   this.employeeId = 0;
	   this.salary = 0;
   }
   
   public Employee(String first, String last)
   {
	   this();
	   this.firstName = first;
	   this.lastName = last;
   }
   
   public Employee(String first, String last, int id, double wage)
   {
	   this.firstName = first;
	   this.lastName = last;
	   this.employeeId = id;
	   this.salary = wage;
   }
   
	/* Task 3D: Add set (mutator) and get (accessor) meethods*/
	public void setFirstName(String name)
	{
		this.firstName = name;
	}
	public String getFirstName()
	{
		return this.firstName;
	}
	public void setLastName(String name)
	{
		this.lastName = name;
	}
	public String getLastName()
	{
		return this.lastName;
	}
	public void setEmployeeId(int id)
	{
		this.employeeId = id;
	}
	public int getEmployeeId()
	{
		return this.employeeId;
	}
	public void setSalary(double wage)
	{
		this.salary = wage;
	}
	public double getSalary()
	{
		return this.salary;
	}

   
	/* Task 3F: Add toString method */
	@Override
	public String toString()
	{
		return String.format( " %s, %s \n %14s %d ", this.lastName, this.firstName, "ID Number:", this.employeeId);
		//  "Employee: " + this.employeeId + " Name: " + this.firstName.toUpperCase() + " " + this.lastName.toUpperCase() + " has salary of $" + this.salary ;
	}
   
   
	/* Task 3G: Add equals method */
	public Boolean equals(String name)
	{
		
		return name.equalsIgnoreCase(this.lastName);
	}
   
}


public class EmployeeApp 
{
	public static final int MAX_EMPLOYEES = 5;
   
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner( System.in );
		Employee[]  employees = new Employee[MAX_EMPLOYEES];
		Employee    currentEmployee;
		String      inputString;
		int         inputInt;
		double      inputDouble;
		char        choice;
		int         empCount=0;
      
		employees[empCount++] = new Employee( "Mitchum", "Robert", 120402, 34000.0 );
		employees[empCount++] = new Employee( "Ryan", "Cornelius" );
		employees[empCount++] = new Employee( "Asimov", "Isaac" );

		do 
		{
			System.out.println( "\n   Enter Selection\n   ===============" );
			System.out.println( "A> Add new Employee" );
			System.out.println( "E> Edit Employee" );
			System.out.println( "L> List Employees" );
			System.out.println( "Q> Quit" );
			System.out.print(  "   Select: " );
			inputString = keyboard.nextLine();
			choice = inputString.toUpperCase().charAt( 0 );
			System.out.println();

			switch( choice )
			{
				case 'A':
					if ( empCount < MAX_EMPLOYEES-1 )
					{
						// Create object for new Employee
						employees[empCount] = new Employee();
                
						// Task 3E: Prompt for user information and set the object 
						// parameters via the mutator methods
						
						//employee ID set
						System.out.print("Employee ID number: ");
						inputInt = keyboard.nextInt();
						employees[empCount].setEmployeeId( inputInt);
						//employee First Name set
						System.out.print("First Name: ");
						inputString = keyboard.next();
						System.out.print(""); //clears buffer
						employees[empCount].setFirstName( inputString );
						//employee Last Name set
						System.out.print("Last Name: ");
						inputString = keyboard.next();
						employees[empCount].setLastName( inputString );
						//employee Salary set
						System.out.print("Salary: ");
						inputDouble = keyboard.nextDouble();
						employees[empCount].setSalary( inputDouble );
						
						

   
						empCount++;
					}
					keyboard.nextLine();
				break;
               
				case 'E':
					System.out.printf( "Enter Last Name of Employee to Edit: " );
					inputString = keyboard.nextLine();
					for ( int lp=0; lp<MAX_EMPLOYEES; lp++ )
					{
						// Verify that the employee entry has been allocated before Editing
						if ( employees[lp] != null )
						{
							if ( employees[lp].equals( inputString ) == true )
							{
								System.out.print( "Enter Employee ID    : " );
								inputInt = keyboard.nextInt();
								employees[lp].setEmployeeId( inputInt );
                  
								System.out.print( "Enter Employee Salary: " );
								inputDouble = keyboard.nextDouble();
								employees[lp].setSalary( inputDouble );
   
								keyboard.nextLine();
							}
						}
					}
				break;
              
				case 'L':
					for ( int lp=0; lp<MAX_EMPLOYEES; lp++ )
					{
						System.out.println( employees[lp] );
					}
				break;
			}
			keyboard.reset();
		} while( choice != 'Q' );
	}  
}
