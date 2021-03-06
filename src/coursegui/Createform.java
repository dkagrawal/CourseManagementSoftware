/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursegui;

import com.toedter.calendar.JDateChooser;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Createform extends javax.swing.JFrame {

    private String title;
    private String buttonname;
    private String old;
    int oldyr;
    private int type;
    frontpage main;
    Course course;
    SimpleDateFormat sdf;
    int currentyr;
    public Createform(frontpage main,String title,String buttonname,int type,Course course) {
        old = course.getCourseName();
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.title=title;
        this.buttonname=buttonname;
        this.type=type;
        this.course=course;
        this.main=main;
        this.addWindowListener(new FrameListener());
        initComponents();
        DataEntered data = new DataEntered(jButton1,type);
        data.addTextField(headdep);
        data.addTextField(headname);
        data.addTextField(coursename);
        data.addTextArea(headadd);
        data.addTextField(heademail);
        data.addTextField(headno);
        data.addTextField(coursefee);
        data.addTextField(duration);
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        currentyr = cal.get(Calendar.YEAR);
        switch(type){
            case 1://creating a course
                break;
            case 2://display a course
                jLabel11.setVisible(false);
                jLabel12.setVisible(false);
                jButton1.setVisible(false);
                setvalue();
                break;
            case 3://modify course
                Calendar cal2 = Calendar.getInstance();
                try {
                    cal2.setTime(sdf.parse(course.getSt_date()));
                } catch (ParseException ex) {
                    //do nothing
                }
        
                oldyr = cal2.get(Calendar.YEAR)-currentyr;
                setvalue();
                break;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        coursename = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        headname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        headadd = new javax.swing.JTextArea();
        headdep = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        coursefee = new javax.swing.JTextField();
        duration = new javax.swing.JTextField();
        heademail = new javax.swing.JTextField();
        headno = new javax.swing.JTextField();
        date = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null,title, javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 3, 14)));

        jLabel1.setText("Course Name:");

        coursename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coursenameActionPerformed(evt);
            }
        });

        jLabel2.setText("Course Fee:");

        jLabel3.setText("Start date(dd/mm/yyyy):");

        jLabel4.setText("Course Duration:");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel5.setText("Co-ordinator details:");

        jLabel6.setText("Name:");

        jLabel7.setText("Department:");

        jLabel8.setText("Address:");

        headadd.setColumns(20);
        headadd.setRows(5);
        jScrollPane1.setViewportView(headadd);

        jLabel9.setText("Email:");

        jLabel10.setText("Number:");

        jButton1.setText(buttonname);
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Go to Main menu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel11.setForeground(java.awt.Color.red);
        jLabel11.setText("NOTE:");

        jLabel12.setText("Button will be enabled only when none of the text fields are empty.");

        duration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                durationActionPerformed(evt);
            }
        });

        date.setDateFormatString("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int year = cal.get(Calendar.YEAR);
        String lowerdate = "01/01/"+year;
        String higherdate = "31/12/"+(year+4);
        try{
            Date lowerdt = sdf.parse(lowerdate);
            Date higherdt = sdf.parse(higherdate);
            date.setMinSelectableDate(lowerdt);
            date.setMaxSelectableDate(higherdt);
        }
        catch(ParseException e){
            //do nothing
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(coursename, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                    .addComponent(coursefee)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(duration, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(headdep, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(headname, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(headno)
                            .addComponent(heademail)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coursename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(coursefee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(duration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(headname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(headdep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(heademail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(headno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel11))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void coursenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coursenameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coursenameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int year = cal.get(Calendar.YEAR);
        String lowerdate = "01/01/"+year;
        String higherdate = "31/12/"+(year+4);
        Date today = null;
        Date last = null;
        try{
            today = sdf.parse(lowerdate);
            last = sdf.parse(higherdate);
        }
        catch(ParseException e){
        //do nothing
        }
        if(type==1){
            if(date.getDate()==null||date.getDate().before(today)||date.getDate().after(last)){
                JOptionPane.showMessageDialog(this,"This is not a valid date.");
                return;
            }
            course.setCourseName(coursename);
            course.setFee(coursefee);
            course.setSt_date(date.getDate());
            course.setduration(duration);
            course.head.setName(headname.getText());
            course.head.setDepartment(headdep.getText());
            course.head.setAddress(headadd.getText());
            course.head.setMobNo(headno);
            course.head.setEmail(heademail);
            if(jButton1.isEnabled()){
                Calendar cal2 = Calendar.getInstance();
                cal2.setTime(date.getDate());
                int yr = cal2.get(Calendar.YEAR)-currentyr;
                switch(yr){
                    case 0:
                        if(main.course1.size()==10){
                            JOptionPane.showMessageDialog(this,"No more courses"
                                    + " can be added.","Course Limit Exceeded!",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        main.course1.add(course);
                        main.jComboBox1.setSelectedIndex(0);
                        main.addlistelement(course,main.course1,main.listmodel1);
                        break;
                    case 1:
                        if(main.course2.size()==10){
                            JOptionPane.showMessageDialog(this,"No more courses"
                                    + " can be added.","Course Limit Exceeded!",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        main.course2.add(course);
                        main.jComboBox1.setSelectedIndex(1);
                        main.addlistelement(course,main.course2,main.listmodel2);
                        break;
                    case 2:
                        if(main.course3.size()==10){
                            JOptionPane.showMessageDialog(this,"No more courses"
                                    + " can be added.","Course Limit Exceeded!",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        main.course3.add(course);
                        main.jComboBox1.setSelectedIndex(2);
                        main.addlistelement(course,main.course3,main.listmodel3);
                        break;
                    case 3:
                        if(main.course4.size()==10){
                            JOptionPane.showMessageDialog(this,"No more courses"
                                    + " can be added.","Course Limit Exceeded!",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        main.course4.add(course);
                        main.jComboBox1.setSelectedIndex(3);
                        main.addlistelement(course,main.course4,main.listmodel4);
                        break;
                    case 4:
                        if(main.course5.size()==10){
                            JOptionPane.showMessageDialog(this,"No more courses"
                                    + " can be added.","Course Limit Exceeded!",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        main.course5.add(course);
                        main.jComboBox1.setSelectedIndex(4);
                        main.addlistelement(course,main.course5,main.listmodel5);
                        break;
                }
                
                this.dispose();
                try {
                    main.tryserialize();
                } catch (IOException ex) {
                    System.out.println("do nothing");
                }
                main.setVisible(true);
            }
            
        }
        else if(type==3){
            if(date.getDate()==null||date.getDate().before(today)||date.getDate().after(last)){
                JOptionPane.showMessageDialog(this,"This is not a valid date.");
                return;
            }
            course.setCourseName(coursename);
            course.setFee(coursefee);
            course.setSt_date(date.getDate());
            course.setduration(duration);
            course.head.setName(headname.getText());
            course.head.setDepartment(headdep.getText());
            course.head.setAddress(headadd.getText());
            course.head.setMobNo(headno);
            course.head.setEmail(heademail);
            if(jButton1.isEnabled()){
                Calendar cal3 = Calendar.getInstance();
                cal3.setTime(date.getDate());
                int yr = cal3.get(Calendar.YEAR)-currentyr;
                if(yr!=oldyr){
                    JOptionPane.showMessageDialog(this,"Course must be in the same session"
                            + "("+(oldyr+currentyr)+").",
                            "ERROR",JOptionPane.ERROR_MESSAGE);
                    date.setDate(null);
                }
                else{
                    switch(yr){
                        case 0:
                            main.modifylistelement(course,main.course1,main.listmodel1);
                            break;
                        case 1:
                            main.modifylistelement(course,main.course2,main.listmodel2);
                            break;
                        case 2:
                            main.modifylistelement(course,main.course3,main.listmodel3);
                            break;
                        case 3:
                            main.modifylistelement(course,main.course4,main.listmodel4);
                            break;
                        case 4:
                            main.modifylistelement(course,main.course5,main.listmodel5);
                            break;
                    }
                    try {
                        main.tryserialize();
                    } catch (IOException ex) {
                        System.out.println("do nothing");
                    }
                    this.dispose();
                    main.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        main.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void durationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_durationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_durationActionPerformed


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField coursefee;
    private javax.swing.JTextField coursename;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JTextField duration;
    private javax.swing.JTextArea headadd;
    private javax.swing.JTextField headdep;
    private javax.swing.JTextField heademail;
    private javax.swing.JTextField headname;
    private javax.swing.JTextField headno;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    private void setvalue(){
        coursename.setText(course.getCourseName());
        coursefee.setText(Double.toString(course.getFee()));
        try{
            date.setDate(sdf.parse(course.getSt_date()));
        }
        catch(ParseException e){
            //do nothing
        }
        duration.setText(Integer.toString(course.getduration()));
        headname.setText(course.head.getName());
        headdep.setText(course.head.getDepartment());
        headadd.setText(course.head.getAddress());
        heademail.setText(course.head.getEmail());
        headno.setText(course.head.getMobNo());
    }
    
    class DataEntered implements DocumentListener,PropertyChangeListener{
        private JButton button;
        List<JTextField> txtfields=new ArrayList<>();
        List<JDateChooser> datefields = new ArrayList<>();
        JTextArea ta;
        private int opt;
        public DataEntered(JButton button,int type){
            this.button=button;
            this.opt=type;
        }
        public void addTextField(JTextField txtfield){
            txtfields.add(txtfield);
            if(opt==2)
                txtfield.setEditable(false);
            txtfield.getDocument().addDocumentListener(this);
        }
        public void addTextArea(JTextArea ta){
            this.ta=ta;
            if(opt==2)
                ta.setEditable(false);
            ta.getDocument().addDocumentListener(this);
        }
        
        public void adddate(JDateChooser dater){
            datefields.add(dater);
            if(opt==2)
                dater.setEnabled(false);
            dater.getDateEditor().addPropertyChangeListener(this);
        }

        public boolean isDataEntered(){
            for(JTextField txtfield:txtfields){
                if(txtfield.getText().length()==0)
                return false;
            }
            return ta.getText().trim().length() != 0;
        }
        
        public boolean isDateEntered(){
            Calendar cal = Calendar.getInstance();
            Date today = cal.getTime();
            cal.add(Calendar.YEAR, 5);
            Date last = cal.getTime();
            for(JDateChooser date:datefields){
                if(date.getDate()==null)
                    return false;
                else if(date.getDate().before(today)||date.getDate().after(last))
                    return false;
            }
            return true;
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
        checkdata();
        }
        @Override
        public void removeUpdate(DocumentEvent e) {
        checkdata();
        }
        @Override
        public void changedUpdate(DocumentEvent e) {
        checkdata();
        }
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            checkdata();
        }
        public void checkdata(){
            button.setEnabled(isDataEntered() && isDateEntered());
        }
    }
    
    class FrameListener extends WindowAdapter{
        public void windowClosing(WindowEvent e){
            main.setVisible(true);
        }
    }
}

