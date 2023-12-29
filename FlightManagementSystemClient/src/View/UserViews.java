package View;

import Service.AirlineInterface;
import Service.UserviewInterface;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import Model.Airline;
import Service.DestinationInterface;
import Model.Destination;
import Model.UserView;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author ericbuturo
 */
public class UserViews extends javax.swing.JFrame {
    
    private DefaultTableModel tableModel = new DefaultTableModel();

    /**
     * Creates new form UserView
     */
    
    public UserViews() {
        initComponents();
        airlineitem();
        destinationitem();
        addcolumn();
        search_data();
    }
    
    
    private void airlineitem(){
        airlinecombo.removeAllItems();
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 6000);
            AirlineInterface intrf = (AirlineInterface)registry.lookup("Airline");
            List<Airline> airlines = intrf.retrieveAirline();
            Iterator iter = airlines.iterator();
            while(iter.hasNext()){
            Airline air = (Airline)iter.next();
            airlinecombo.addItem(air.getName());
        }
        } catch (Exception e) {
          e.printStackTrace();
        }
    }
    
    private void destinationitem(){
        destinationcombo.removeAllItems();
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 6000);
                DestinationInterface intrf = (DestinationInterface)registry.lookup("Destination");
                List<Destination> destinations = intrf.retrieveDestination();
                Iterator iter = destinations.iterator();
                while(iter.hasNext()){
                    Destination des = (Destination)iter.next();
                    destinationcombo.addItem(des.getCountry());
                }
            
        } catch (Exception e) {
        e.printStackTrace();
        }
    }    
   
    public void addcolumn() {
        tableModel.addColumn("Flight ID");
        tableModel.addColumn("Airline");
        tableModel.addColumn("Booking Date");
        tableModel.addColumn("Destination");
        tableModel.addColumn("First Name");
        tableModel.addColumn("Last Name");
        tableModel.addColumn("Payment Status");
        tableModel.addColumn("Seat Number");
        tableModel.addColumn("Seat type");
        Info.setModel(tableModel);
    }
    
    public void read() {
        try {

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 6000);
            UserviewInterface intrf = (UserviewInterface) registry.lookup("Userview");
            List<UserView> usrv = intrf.getUserViews();
            Iterator inter = usrv.iterator();

            tableModel.setRowCount(0);

            while (inter.hasNext()) {
                UserView uusrv = (UserView) inter.next();
                tableModel.addRow(new Object[]{
                    uusrv.getFlightid(),
                    uusrv.getAirline(),
                    uusrv.getBookingdate(),
                    uusrv.getDestination(),
                    uusrv.getFirstname(),
                    uusrv.getLastname(),
                    uusrv.getPaymentstatus(),
                    uusrv.getSeatnumber(),
                    uusrv.getSeattype()
                });
                Info.setModel(tableModel);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void initiateDownload() {
          // Retrieve the table data from the server
          try{
          Registry registry = LocateRegistry.getRegistry("127.0.0.1",6000);
          UserviewInterface service = (UserviewInterface)registry.lookup("Userview");
          List<UserView> tableData = service.retrieveTableData();

          // Call a method to save the table data to a file
          saveTableDataToFile(tableData);
          }catch(Exception ex){
              ex.printStackTrace();
          }
      }
    
    private void saveTableDataToFile(List<UserView> tableData) {
    try {
        // Create a file chooser to select the save location
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            File file = fileChooser.getSelectedFile();

            // Append the ".pdf" extension if not already present
            if (!file.getAbsolutePath().endsWith(".pdf")) {
                file = new File(file.getAbsolutePath() + ".pdf");
            }

            // Create a new PDF document
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();

            // Write the table data to the PDF document
            for (UserView data : tableData) {
                document.add(new Paragraph(data.toString()));
            }

            document.close();

            JOptionPane.showMessageDialog(this, "Downloaded Successfully!");
        }
    } catch (IOException | DocumentException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error Downloading Data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
    public void search_data() {
        try {

            Registry reg = LocateRegistry.getRegistry("127.0.0.1", 6000);
            UserviewInterface serv = (UserviewInterface) reg.lookup("Userview");
            List<UserView> user = serv.getUserViews();
            Iterator iterator = user.iterator();
            while (iterator.hasNext()) {
                UserView users = (UserView) iterator.next();
                searchcombo.addItem(users.getFlightid().toString());
            }

        }catch (Exception e) {
         e.printStackTrace();
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        viewFname = new javax.swing.JTextField();
        viewLname = new javax.swing.JTextField();
        viewSeattype = new javax.swing.JTextField();
        viewSeatnber = new javax.swing.JTextField();
        viewBookingdate = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Info = new javax.swing.JTable();
        insertBtn = new javax.swing.JButton();
        readBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        viewPaymentstatus = new javax.swing.JTextField();
        airlinecombo = new javax.swing.JComboBox<>();
        destinationcombo = new javax.swing.JComboBox<>();
        backbtn = new javax.swing.JButton();
        deletetxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        viewFlightid = new javax.swing.JTextField();
        downloadbtn = new javax.swing.JButton();
        searchcombo = new javax.swing.JComboBox<>();
        searchbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 51, 51));

        jLabel1.setText("FIRST NAME");

        jLabel2.setText("LAST NAME");

        jLabel4.setText("AIRLINE");

        jLabel5.setText("DESTINATION");

        jLabel6.setText("SEAT TYPE");

        jPanel1.setBackground(new java.awt.Color(38, 51, 84));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("FLIGHT MANAGEMENT SYSTEM - ADMIN VIEW");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(323, 323, 323))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        jLabel8.setText("SEAT NUMBER");

        jLabel9.setText("PAYMENT STATUS");

        jLabel10.setText("BOOKING DATE");

        Info.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FIRST NAME", "LAST NAME", "FLIGHT ID ", "AIRLINE", "DESTINATION", "SEAT TYPE", "SEAT NUMBER", "PAYMENT STATUS", "BOOKING DATE"
            }
        ));
        jScrollPane1.setViewportView(Info);

        insertBtn.setText("INSERT");
        insertBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBtnActionPerformed(evt);
            }
        });

        readBtn.setText("READ");
        readBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readBtnActionPerformed(evt);
            }
        });

        updateBtn.setText("UPDATE");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("DELETE");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        logoutBtn.setText("LOGOUT");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        airlinecombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        destinationcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        destinationcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinationcomboActionPerformed(evt);
            }
        });

        backbtn.setText("BACK");
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });

        jLabel3.setText("FLIGHT ID");

        downloadbtn.setText("DOWNLOAD");
        downloadbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadbtnActionPerformed(evt);
            }
        });

        searchcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Search" }));
        searchcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchcomboActionPerformed(evt);
            }
        });

        searchbtn.setText("SEARCH");
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewLname)
                    .addComponent(viewFname)
                    .addComponent(airlinecombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(destinationcombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewFlightid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(185, 185, 185)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(viewBookingdate, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(viewSeattype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewSeatnber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewPaymentstatus))
                .addGap(126, 126, 126)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchbtn))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(logoutBtn)
                        .addComponent(backbtn)))
                .addContainerGap(67, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(insertBtn)
                .addGap(32, 32, 32)
                .addComponent(readBtn)
                .addGap(35, 35, 35)
                .addComponent(updateBtn)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deletetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(deleteBtn)))
                .addGap(120, 120, 120)
                .addComponent(downloadbtn)
                .addGap(234, 234, 234))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {airlinecombo, destinationcombo, viewBookingdate, viewFlightid, viewFname, viewLname, viewPaymentstatus, viewSeatnber, viewSeattype});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {backbtn, deleteBtn, insertBtn, logoutBtn, readBtn, updateBtn});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {searchbtn, searchcombo});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchbtn))
                        .addGap(72, 72, 72)
                        .addComponent(backbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(logoutBtn)
                            .addComponent(jLabel10)
                            .addComponent(viewBookingdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(viewPaymentstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(viewLname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(viewSeattype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(viewFlightid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(viewSeatnber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(viewFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(airlinecombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(destinationcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(insertBtn)
                            .addComponent(readBtn)
                            .addComponent(updateBtn)
                            .addComponent(deleteBtn)
                            .addComponent(deletetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(downloadbtn))
                        .addGap(35, 35, 35)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {airlinecombo, destinationcombo, viewBookingdate, viewFlightid, viewFname, viewLname, viewPaymentstatus, viewSeatnber, viewSeattype});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {backbtn, deleteBtn, insertBtn, logoutBtn, readBtn, updateBtn});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {searchbtn, searchcombo});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void readBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readBtnActionPerformed
        // TODO add your handling code here:
        
        read();
        tableModel.setRowCount(0);
        read();
    }//GEN-LAST:event_readBtnActionPerformed

    private void insertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBtnActionPerformed
        // TODO add your handling code here:
        try {
    if (viewFlightid.getText().trim().isEmpty() || viewFname.getText().trim().isEmpty() || viewLname.getText().trim().isEmpty() || viewSeattype.getText().trim().isEmpty() || viewSeatnber.getText().trim().isEmpty() || viewPaymentstatus.getText().trim().isEmpty() || viewBookingdate.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please provide all information", "Data Required", JOptionPane.ERROR_MESSAGE);
    } else {
        if (!viewFname.getText().equals(viewFname.getText().toUpperCase()) || !viewLname.getText().equals(viewLname.getText().toUpperCase()) || !viewSeattype.getText().equals(viewSeattype.getText().toUpperCase()) || !viewPaymentstatus.getText().equals(viewPaymentstatus.getText().toUpperCase()) || !viewBookingdate.getText().equals(viewBookingdate.getText().toUpperCase())) {
            JOptionPane.showMessageDialog(this, "Please enter uppercase letters only", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int seatNumber;
        try {
            seatNumber = Integer.parseInt(viewSeatnber.getText());
            if (seatNumber < 1 || seatNumber > 100) {
                JOptionPane.showMessageDialog(this, "Seat number should be between 1 and 100", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid seat number", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Model.UserView pst = new Model.UserView();
        pst.setFlightid(Integer.parseInt(viewFlightid.getText()));
        pst.setFirstname(viewFname.getText());
        pst.setLastname(viewLname.getText());
        pst.setSeattype(viewSeattype.getText());
        pst.setSeatnumber(viewSeatnber.getText());
        pst.setPaymentstatus(viewPaymentstatus.getText());
        pst.setBookingdate(viewBookingdate.getText());
        pst.setAirline(airlinecombo.getSelectedItem().toString());
        pst.setDestination(destinationcombo.getSelectedItem().toString());
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 6000);
        UserviewInterface intrf = (UserviewInterface) registry.lookup("Userview");
        String feedback = intrf.registeruser(pst);
        JOptionPane.showMessageDialog(this, feedback, "Successfully Inserted", JOptionPane.INFORMATION_MESSAGE);

        tableModel.setRowCount(0);
        read();
    }
} catch (Exception e) {
    e.printStackTrace();
}

    }//GEN-LAST:event_insertBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        try {
            if(viewFlightid.getText().trim().isEmpty() || viewFname.getText().trim().isEmpty() || viewLname.getText().trim().isEmpty() || viewSeattype.getText().trim().isEmpty() || viewSeatnber.getText().trim().isEmpty() || viewPaymentstatus.getText().trim().isEmpty() || viewBookingdate.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(this, "Please provide all information","Data Required",JOptionPane.ERROR_MESSAGE);
            }else{
            
            Model.UserView pst = new Model.UserView();
            pst.setFlightid(Integer.parseInt(viewFlightid.getText()));
            pst.setFirstname(viewFname.getText());
            pst.setLastname(viewLname.getText());
            pst.setSeattype(viewSeattype.getText());
            pst.setSeatnumber(viewSeatnber.getText());
            pst.setPaymentstatus(viewPaymentstatus.getText());
            pst.setBookingdate(viewBookingdate.getText());
            pst.setAirline(airlinecombo.getSelectedItem().toString());
            pst.setDestination(destinationcombo.getSelectedItem().toString());
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 6000);
            UserviewInterface intrf = (UserviewInterface)registry.lookup("Userview");
            String feedback = intrf.updateuser(pst);
            JOptionPane.showMessageDialog(this, feedback,"Successfully Updated",JOptionPane.INFORMATION_MESSAGE);
            
            tableModel.setRowCount(0);
            read();
            
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here
        try {
           
            if(deletetxt.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(this, "Please provide ID","Data Required",JOptionPane.ERROR_MESSAGE);
            }else{
                Model.UserView pst = new Model.UserView();
                pst.setFlightid(Integer.parseInt(deletetxt.getText()));
                Registry registry = LocateRegistry.getRegistry("127.0.0.1", 6000);
                UserviewInterface intrf = (UserviewInterface)registry.lookup("Userview");
                String feedback = intrf.deleteuser(pst);
            JOptionPane.showMessageDialog(this, feedback,"Successfully Deleted",JOptionPane.INFORMATION_MESSAGE);
            
            tableModel.setRowCount(0);
            read();
            
            }
            
        } catch (Exception e) {
        e.printStackTrace();
        }
        
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // TODO add your handling code here:
        Login logt = new Login();
        logt.show();
        dispose();
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        // TODO add your handling code here:
        Choice chocie = new Choice();
        chocie.show();
        dispose();
    }//GEN-LAST:event_backbtnActionPerformed

    private void downloadbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadbtnActionPerformed
        // TODO add your handling code here:
        initiateDownload();
    }//GEN-LAST:event_downloadbtnActionPerformed

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
        // TODO add your handling code here:
        try {

            if (searchcombo.getSelectedItem().toString().equalsIgnoreCase("select")) {

                JOptionPane.showMessageDialog(this, "Fill in the Flight ID", "Data Required", JOptionPane.WARNING_MESSAGE);

            } else {

                Registry reg = LocateRegistry.getRegistry("127.0.0.1", 6000);
                UserviewInterface serv = (UserviewInterface) reg.lookup("Userview");

                UserView ussv = new UserView();
                ussv.setFlightid(Integer.valueOf(searchcombo.getSelectedItem().toString()));

                UserView ussiv = serv.catch_userview(ussv);

                if (ussiv != null) {

                    tableModel.setRowCount(0);

                    tableModel.addRow(new Object[]{
                        ussiv.getFlightid(),
                        ussiv.getAirline(),
                        ussiv.getBookingdate(),
                        ussiv.getDestination(),
                        ussiv.getFirstname(),
                        ussiv.getLastname(),
                        ussiv.getPaymentstatus(),
                        ussiv.getSeatnumber(),
                        ussiv.getSeattype()
                    });
                    Info.setModel(tableModel);

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_searchbtnActionPerformed

    private void searchcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchcomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchcomboActionPerformed

    private void destinationcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinationcomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_destinationcomboActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserViews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserViews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserViews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserViews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserViews().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Info;
    private javax.swing.JComboBox<String> airlinecombo;
    private javax.swing.JButton backbtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField deletetxt;
    private javax.swing.JComboBox<String> destinationcombo;
    private javax.swing.JButton downloadbtn;
    private javax.swing.JButton insertBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton readBtn;
    private javax.swing.JButton searchbtn;
    private javax.swing.JComboBox<String> searchcombo;
    private javax.swing.JButton updateBtn;
    private javax.swing.JTextField viewBookingdate;
    private javax.swing.JTextField viewFlightid;
    private javax.swing.JTextField viewFname;
    private javax.swing.JTextField viewLname;
    private javax.swing.JTextField viewPaymentstatus;
    private javax.swing.JTextField viewSeatnber;
    private javax.swing.JTextField viewSeattype;
    // End of variables declaration//GEN-END:variables
}
