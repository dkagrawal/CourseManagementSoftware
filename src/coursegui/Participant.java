package coursegui;


import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
//name, address, mobile
//number, organization name, and e-mail address
public class Participant implements Serializable{
    private String name;
    private String address;
    private String mobno;
    private String Orgname;
    private String email;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMobno(JTextField tf) {
        String mobno = tf.getText();
        String pattern = "[0-9]{6,15}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(mobno);
        if(m.find()){
            this.mobno = mobno;
        }
        else {
            JOptionPane.showMessageDialog(null,"Please enter a valid mobile number"
                    + " comprising of 6-15 digits.","Wrong Number Format",
                    JOptionPane.ERROR_MESSAGE);
            tf.setText("");
        }
    }

    public void setOrgname(String Orgname) {
        this.Orgname = Orgname;
    }

    public void setEmail(JTextField tf) {
        String pattern="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        String email = tf.getText();
        Matcher m = p.matcher(email);
        if(m.find()){
            this.email=email;
        }
        else {
            JOptionPane.showMessageDialog(null,"Not a valid email address.!"
                    + "","Wrong Number Format",
                    JOptionPane.ERROR_MESSAGE);
            tf.setText("");
        }
        
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getMobno() {
        return mobno;
    }

    public String getOrgname() {
        return Orgname;
    }

    public String getEmail() {
        return email;
    }
}
