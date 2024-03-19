package coursera;
//IMPORTS
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ZetechUnits extends javax.swing.JFrame {
private static final String username="root";
private static final String password="";
private static final String dataconn="jdbc:mysql://localhost:4306/zcoursedata";

Connection sqlConn=null;
PreparedStatement pst=null;
ResultSet rs=null;
int q,i,id,deleteItem;
    public ZetechUnits() {
        initComponents();
    }
Connection con;
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("Fetch Units");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "unitcode", "unitname", "class_group", "lecturer"
            }
        ));
        jScrollPane1.setViewportView(jTable7);

        jButton2.setText("Dashboard");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Logout");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Delete Selected");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Clear");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Refresh");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Save Changes");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(28, 28, 28)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)
                        .addGap(43, 43, 43)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jButton1)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          // open stock
       DefaultTableModel tblModel = (DefaultTableModel) jTable7.getModel();
boolean recordsRetrieved = false;  // Variable to track whether any records were retrieved

try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:4306/zcoursedata?useSSL=false", "root", "");

    // Retrieve data from the "product" table
    String query = "SELECT * FROM courses";
    try (PreparedStatement prepstmt = con.prepareStatement(query);
         ResultSet resultSet = prepstmt.executeQuery()) {
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String unitcode = resultSet.getString("unitcode");
            String unitname = resultSet.getString("unitname");
            String class_group = resultSet.getString("class_group");
            String lecturer = resultSet.getString("lecturer");
            // Add a new row to the table model
            tblModel.addRow(new Object[]{id, unitcode, unitname, class_group,lecturer});
            recordsRetrieved = true;  // Set to true if at least one record is retrieved
        }
    }

    if (recordsRetrieved) {
        JOptionPane.showMessageDialog(this, "Data Retrieved successfully!");
    } else {
        JOptionPane.showMessageDialog(this, "Table Is Empty");
    }

} catch (ClassNotFoundException e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(this, "Error: MySQL JDBC Driver not found");
} catch (SQLException e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(this, "Error: Unable to connect to the database");
}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dashboard DAS = new dashboard();
        DAS.show();
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        login LN= new login();
        LN.show();
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // DELETE SELECTED
        DefaultTableModel tblModel = (DefaultTableModel) jTable7.getModel();

        // Check if there are rows in the table
        if (tblModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Table Is Empty");
        } else {
            try {
                int[] selectedRows = jTable7.getSelectedRows();

                // Check if any row is selected
                if (selectedRows.length == 0) {
                    JOptionPane.showMessageDialog(this, "Please select rows to delete");
                    return;
                }

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:4306/zcoursedata?useSSL=false", "root", "");

                // Delete query using the primary key "idnumber" for each selected row
                String deleteQuery = "DELETE FROM courses WHERE id=?";
                try (PreparedStatement prepstmt = con.prepareStatement(deleteQuery)) {
                    for (int selectedRow : selectedRows) {
                        String idnumber = tblModel.getValueAt(selectedRow, 0).toString();
                        prepstmt.setString(1, idnumber);
                        prepstmt.addBatch(); // Add each delete statement to the batch
                    }

                    // Execute the batch delete
                    int[] deleteCounts = prepstmt.executeBatch();

                    // Check if all rows were deleted successfully
                    boolean allDeleted = true;
                    for (int count : deleteCounts) {
                        if (count != 1) {
                            allDeleted = false;
                            break;
                        }
                    }

                    if (allDeleted) {
                        // Remove the deleted rows from the table model
                        for (int i = selectedRows.length - 1; i >= 0; i--) {
                            tblModel.removeRow(selectedRows[i]);
                        }

                        JOptionPane.showMessageDialog(this, "Deleted successfully!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Error: Unable to delete selected ");
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: Unable to delete Employee");
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //clear table
        DefaultTableModel model = (DefaultTableModel) jTable7.getModel();
        model.setRowCount(0);
        JOptionPane.showMessageDialog(this, "Table Cleared!");
    }//GEN-LAST:event_jButton5ActionPerformed
//reeeeefresh method
    private void refreshTable() {
    DefaultTableModel tblModel = (DefaultTableModel) jTable7.getModel();

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:4306/zcoursedata?useSSL=false", "root", "");

        // Clear existing rows in the table
        tblModel.setRowCount(0);

        // Retrieve the updated data from the database
        String selectQuery = "SELECT * FROM courses ORDER BY id";
        try (PreparedStatement selectStmt = con.prepareStatement(selectQuery);
             ResultSet resultSet = selectStmt.executeQuery()) {

            while (resultSet.next()) {
                tblModel.addRow(new Object[]{
                        resultSet.getString("id"),
                        resultSet.getString("unitcode"),
                        resultSet.getString("unitname"),
                        resultSet.getString("class_group"),
                        resultSet.getString("lecturer"),                    
                        // Add other columns as needed
                });
            }
        }

        // Update the "id" column to maintain consistency
        String updateIdQuery = "SET @new_id := 0;";
        try (PreparedStatement updateIdStmt = con.prepareStatement(updateIdQuery)) {
            updateIdStmt.executeUpdate();
        }

        String updateOrderQuery = "UPDATE courses SET id = (@new_id := @new_id + 1) ORDER BY id;";
        try (PreparedStatement updateOrderStmt = con.prepareStatement(updateOrderQuery)) {
            updateOrderStmt.executeUpdate();
        }

        JOptionPane.showMessageDialog(this, "Courses table Refreshed successfully!");

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error: Unable to refresh table");
    }
    }
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // refresh
        refreshTable();
    }//GEN-LAST:event_jButton6ActionPerformed
private boolean isValueChanged(String id, String unitcode, String unitname, String class_group, String lecturer) {
    try {
        // Fetch the corresponding value from the database
        String query = "SELECT * FROM courses WHERE unitcode = ?";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:4306/zcoursedata?useSSL=false", "root", "");
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, unitcode);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                // Compare each value with the database
                return 
                        !unitname.equals(resultSet.getString("unitname")) ||
                        !class_group.equals(resultSet.getString("class_group")) ||
                        !lecturer.equals(resultSet.getString("lecturer"))||
                        !id.equals(resultSet.getString("id"));
                        }            
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
// Button action for saving changes
    DefaultTableModel tblModel = (DefaultTableModel) jTable7.getModel();

// Check if there are rows in the table
if (tblModel.getRowCount() == 0) {
    JOptionPane.showMessageDialog(this, "Table Is Empty");
} else {
    boolean changesMade = false; // Flag to track changes

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:4306/zcoursedata?useSSL=false", "root", "");

        // Iterate through the JTable rows and update the database
        for (int i = 0; i < tblModel.getRowCount(); i++) {
            String unitcode = tblModel.getValueAt(i, 1).toString();
            String unitname = tblModel.getValueAt(i, 2).toString();
            String class_group = tblModel.getValueAt(i, 3).toString();
            String lecturer = tblModel.getValueAt(i, 4).toString();
            String id = tblModel.getValueAt(i, 0).toString(); // Assuming id is the last column

            // Check if any values are different from the database
            if (isValueChanged(unitcode, unitname, class_group, lecturer, id)) {
                // Update query using the primary key "admission"
                String updateQuery = "UPDATE ictmedia SET email=?, department=?, course=?, yob=?, emergency=?, fullname=?, gender=?, status=?, religion=? WHERE admission=?";
                try (PreparedStatement prepstmt = con.prepareStatement(updateQuery)) {
                    prepstmt.setString(1, unitcode);
                    prepstmt.setString(2, unitname);
                    prepstmt.setString(3, class_group);
                    prepstmt.setString(4, lecturer);
            

                    prepstmt.executeUpdate();
                }

                changesMade = true;
            }
        }

        if (changesMade) {
            JOptionPane.showMessageDialog(this, "Changes saved successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "No changes made.");
        }

    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error: Unable to save changes - " + e.getMessage());
    }
}
        
    }//GEN-LAST:event_jButton7ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ZetechUnits().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable7;
    // End of variables declaration//GEN-END:variables
}
