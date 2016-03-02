package coursegui;


import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alpha
 */
//contains course name, course fee, date on which it starts and the duration
public class Course implements Serializable{
    private String CourseName;
    private double Fee;
    private String st_date;
    private int duration;
    private int No_instructors;
    private int No_participants;
    Faculty head;
    ArrayList<Faculty> instructors;
    ArrayList<Participant> participants;
    //Iterator itr1 = instructors.iterator();
    //Iterator itr2 = participants.iterator();

    public Course() {
        this.instructors = new ArrayList<>();
        this.participants = new ArrayList<>();
        head = new Faculty();
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(JTextField tf) {
        this.CourseName = tf.getText();
    }

    public double getFee() {
        return Fee;
    }

    public void setFee(JTextField tf) {
        Double fee;
            try{
                fee = Double.parseDouble(tf.getText());
                this.Fee = fee;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Fee can take only numerical values",
                        "Wrong fee format",JOptionPane.ERROR_MESSAGE);
                tf.setText("");
            }
    }

    public String getSt_date() {
        return st_date;
    }

    public void setSt_date(Date lastdat) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String lastdate = sdf.format(lastdat);
        this.st_date=lastdate;
    }

    public int getduration() {
        return duration;
    }

    public void setduration(JTextField tf) {
        int duration;
            try{
                duration = Integer.parseInt(tf.getText());
                if(duration>14)
                    throw new IOException();
                this.duration = duration;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Duration can take only numerical values",
                        "Wrong duration format",JOptionPane.ERROR_MESSAGE);
                tf.setText("");
            }
            catch(IOException e){
                JOptionPane.showMessageDialog(null,"Duration must be less than 14 days.",
                        "Wrong duration format",JOptionPane.ERROR_MESSAGE);
                tf.setText("");
            }
    }

    public int getNo_instructors() {
        return No_instructors;
    }

    public void setNo_instructors(int No_instructors) {
        this.No_instructors = No_instructors;
    }

    public int getNo_participants() {
        return No_participants;
    }

    public void setNo_participants(int No_participants) {
        this.No_participants = No_participants;
    }
    
    public void setdate(String d){
        this.st_date=d;
    }
    
    public void setfee(Double fee){
        this.Fee=fee;
    }
    
    public String emailchecker(){
        Scanner reader = new Scanner(System.in);
        String pattern="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        String email;
        while(true){
            email = reader.nextLine();
            Matcher m = p.matcher(email);
            if(m.find())
                return email;
            else
                System.out.println("Invalid email address.Please try again.");
        }
    }
    
    public void addinstructor(String type,int n){
        String name,dep,add,mob,email;
        for(int i=0;i<n;++i){
            Faculty temp;
            if("a".equals(type)){
                System.out.println("Please enter the instructor "+(i+1)+" details..");
                temp = new Faculty();
                instructors.add(temp);
            }
            else {
                head = new Faculty();
                temp = head;
            }
            Scanner scanner = new Scanner (System.in);
            System.out.println("Enter the name:");
            name = scanner.nextLine();
            temp.setName(name);
            System.out.println("Enter the department:");
            dep = scanner.nextLine();
            temp.setDepartment(dep);
            System.out.println("Enter the Address:");
            add = scanner.nextLine();
            temp.setAddress(add);
            System.out.println("Enter the Mobile No.:");
            mob = scanner.nextLine();
            //temp.setMobNo(mob);
            System.out.println("Enter the Email:");
            email = emailchecker();
            //temp.setEmail(email);
        }
    }
    
    public void addparticipants(int n){
        String name,org,mob,add,email;
        for(int i=0;i<n;++i){
            Participant f = new Participant();
            System.out.println("Please enter the participant "+(i+1)+" details..");
            Scanner scanner = new Scanner (System.in);
            System.out.println("Enter the name:");
            name = scanner.nextLine();
            f.setName(name);
            System.out.println("Enter the Organisation:");
            org = scanner.nextLine();
            f.setOrgname(org);
            System.out.println("Enter the Address:");
            add = scanner.nextLine();
            //f.setAddress(add);
            System.out.println("Enter the Mobile No.:");
            mob = scanner.nextLine();
            //f.setMobno(mob);
            System.out.println("Enter the Email:");
            email = emailchecker();
            //f.setEmail(email);
            participants.add(f);
        }
    }
    
    public void displaycourse(){
        System.out.println("Course name: "+this.CourseName);
        System.out.println("Course fee: "+this.Fee);
        System.out.println("Course start date: "+this.st_date);
        System.out.println("Course duration: "+this.duration + " days");
        System.out.println("Course-coordinator: "+this.head.getName());
        System.out.println("              dep: "+head.getDepartment());
        System.out.println("          address: "+head.getAddress());
        System.out.println("            email: "+head.getEmail());
        System.out.println("              No.: "+head.getMobNo());
        System.out.println("No. of Instructors: "+this.No_instructors);
        int i=0;
        for(Faculty instructr: instructors){
            i++;
            System.out.println("Instructor " +i+" name: "+instructr.getName());
            System.out.println("              dep: "+instructr.getDepartment());
            System.out.println("          address: "+instructr.getAddress());
            System.out.println("            email: "+instructr.getEmail());
            System.out.println("              No.: "+instructr.getMobNo());
        }
        System.out.println("No. of Participants: "+this.No_participants);
        int j=0;
        for(Participant particip: participants){
            j++;
            System.out.println("Participant " +j+" name: "+particip.getName());
            System.out.println("               Org: "+particip.getOrgname());
            System.out.println("           address: "+particip.getAddress());
            System.out.println("             email: "+particip.getEmail());
            System.out.println("               No.: "+particip.getMobno());
        }
    }
}

