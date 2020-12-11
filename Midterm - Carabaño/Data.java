package data;

import java.util.*;
import java.util.Scanner;

public class Data {
    private String m_name;
    private int m_age;
    
    static ArrayList<Data> students = new ArrayList<Data>();
    
    public Data( String name, int age)
    {
        m_name = name;
        m_age = age;
    }
    public String getName()
    {
        return m_name;
    }

    public int getAge()
    {
        return m_age;
    }

    public String toString()
    {
        return  "Name: " + m_name + " \n " + "       Age: " + m_age;
    }
    public static void main(String[] args) {
       System.out.println("West Visayas State University");
       System.out.println(" Student Information System ");
         menu();
    }
     public static void menu() {
       Scanner input = new Scanner(System.in);
       System.out.println("     ==== Options ====");
       System.out.println("     1. Add Item");
       System.out.println("     2. Delete Items");
       System.out.println("     3. View Items");
       System.out.println("     4. Update List");
       System.out.println("     5. Exit");
       System.out.println("     Enter you choice: ");
       int choice = input.nextInt();
       System.out.println("-------------------------------");
       System.out.println("\n");
       
       switch(choice)
         {
            case 1:
               add();
               menu();
               break;
          case 2:
               delete();
               menu();
               break;
            case 3:
                view();
                menu();
                break;
           case 4:
                update();
                menu();
                break;          
           case 5:
                System.exit(0);
                break;
           default:
                System.out.println("     Invalid Input");
                break;
        }
}
    static public void add(){
        Scanner in = new Scanner(System.in);
        System.out.println("     === Add Item ==="); 
        System.out.println("     Enter Name:");
        String name = in.nextLine();     
        System.out.println("     Enter Age:");
        int age = Integer.parseInt(in.nextLine());      
        Data student = new Data(name, age);
        students.add(student);
        System.out.println("\n");
        System.out.println("-------------------------------");
        System.out.println("\n");
    }    
    
    static public void delete(){
        Scanner in = new Scanner(System.in);
        System.out.println("     === Delete Items ===");
            if(students.isEmpty())
            {
                System.out.println("     The list is empty " +"\n");
            }
            else
            {
                System.out.println("        List of Entries:");
                for(int i=0 ; i<students.size();i++)
                    {
                    System.out.println( "     " + i + ". " + students.get(i) + " ");
                    }
                System.out.println(" Enter the index that you want to delete: ");
                int num = in.nextInt();
                students.remove(num);
                System.out.println("The data under index " + num + " was successfully deleted ");
            }
        System.out.println("\n");
        System.out.println("-------------------------------");
        System.out.println("\n");    
    }    
    
    static public void view(){
        System.out.println("     === View Items ===");
            if(students.isEmpty())
            {
                System.out.println("     The list is empty " +"\n");
            }
            else
            {
                System.out.println("      List of Entries:");
                for(int i=0 ; i<students.size();i++)
                    System.out.println( "     "+i+". "+ students.get(i)+ " ");
            }
        System.out.println("\n");
        System.out.println("-------------------------------");
        System.out.println("\n");     
    }
 
    static public void update(){
        Scanner in = new Scanner(System.in);
        int num, age;
        String name;
        System.out.println("     === Update List ===");
        System.out.println("     List of Entries:");
        for(int i=0 ; i<students.size();i++)
        {
            System.out.println("     "+ i+". "+ students.get(i)+ " ");
        }
        try
        {      
        System.out.println("     Enter index of the data that you want to update");
        num=in.nextInt();
        System.out.println("     Enter name");
        name=in.next();
        System.out.println("     Enter age");
        age=in.nextInt();
        Data student = new Data(name, age);
        students.set(num, student);
        System.out.println("   The name " +name + " was successfully added to the list \n");
        } 
        catch(IndexOutOfBoundsException e)
        {
           System.err.println("caught IndexOutOfBoundsException: specified position is empty "+e.getMessage());   
        }
        System.out.println("\n");
        System.out.println("-------------------------------");
        System.out.println("\n");
    }   
}