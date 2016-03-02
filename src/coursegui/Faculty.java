package coursegui;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alpha
 */
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
//Department to which he is affiliated, his name, address,4
//mobile number, and e-mail address.
public class Faculty implements Serializable{
    private String Department;
    private String Name;
    private String Address;
    private String MobNo;
    private String Email;

    public String getDepartment() {
        return Department;
    }

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }

    public String getMobNo() {
        return MobNo;
    }

    public String getEmail() {
        return Email;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setMobNo(JTextField tf) {
        String mobno = tf.getText();
        String pattern = "[0-9]{6,15}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(mobno);
        if(m.find()){
            this.MobNo = mobno;
        }
        else {
            JOptionPane.showMessageDialog(null,"Please enter a valid mobile number"
                    + " comprising of 6-15 digits.","Wrong Number Format",
                    JOptionPane.ERROR_MESSAGE);
            tf.setText("");
        }
    }

    public void setEmail(JTextField tf) {
        String pattern="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        String email = tf.getText();
        Matcher m = p.matcher(email);
        if(m.find()){
            this.Email=email;
        }
        else {
            JOptionPane.showMessageDialog(null,"Not a valid email address.!"
                    + "","Wrong Number Format",
                    JOptionPane.ERROR_MESSAGE);
            tf.setText("");
        }
        
    }
    
    
}
