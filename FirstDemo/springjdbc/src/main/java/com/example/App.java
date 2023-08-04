package com.example;
import java.util.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scan=new Scanner(System.in);
        ApplicationContext context=new ClassPathXmlApplicationContext("com/example/Bean.xml");
        StudentDao studentDao=context.getBean("studentdao",StudentDao.class);
        //Student student=new Student(155, "Ahg uyf", "Bagha");
        Student student=new Student();
        String name,address;
        int id;
        System.out.println("Enter your Key (: Press 1 to insert data, Press 2 to update name and Address, Press 3 to update Name, press 4 to update Address, Press 5 to update ID, Press 6 to delete record from database and Press 7 to see the record");
        while(true){
            int key=scan.nextInt();
            if(key==1){
                System.out.println("Write down id, name and address");
                id = scan.nextInt();
                name=scan.next();
                address=scan.next();
                student.setId(id);
                student.setName(name);
                student.setAddress(address);
                System.out.println(studentDao.insert(student));
                break;
            }else if(key==2){
                System.out.println("Write down id, name and address");
                id = scan.nextInt();
                name=scan.next();
                address=scan.next();
                student.setId(id);
                student.setName(name);
                student.setAddress(address);
                System.out.println(studentDao.change(student));
                break;
            }else if(key==3){
                System.out.println("Write down id and name");
                id = scan.nextInt();
                name=scan.nextLine();
                student.setId(id);
                student.setName(name);
                System.out.println(studentDao.changeName(student));
                break;
            }else if(key==4){
                System.out.println("Write down id and address");
                id = scan.nextInt();
                address=scan.next();
                student.setId(id);
                student.setAddress(address);
                System.out.println(studentDao.changeAddress(student));
                break;
            }else if(key==5){
                System.out.println("Write down id, name and address");
                id = scan.nextInt();
                name=scan.next();
                address=scan.next();
                student.setId(id);
                student.setName(name);
                student.setAddress(address);
                System.out.println(studentDao.changeId(student));
                break;
            }else if(key==6){
                System.out.println("Write down id");
                id=scan.nextInt();
                student.setId(id);
                System.out.println(studentDao.deleteTouple(student));
            }else if(key==7){
                System.out.println("Write down id");
                id=scan.nextInt();
                student.setId(id);
                System.out.println(studentDao.getStudent(student));
                break;
            }
        }
    }
}
