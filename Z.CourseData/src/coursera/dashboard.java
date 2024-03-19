
package coursera;
//IMPORTS
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class dashboard extends javax.swing.JFrame {
//connection
private static final String username="root";
private static final String password="";
private static final String dataconn="jdbc:mysql://localhost:4306/zcoursedata";

Connection sqlConn=null;
PreparedStatement pst=null;
ResultSet rs=null;
int q,i,id,deleteItem;

    public dashboard() {
        
        initComponents();
    }
Connection con;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        uc = new javax.swing.JTextField();
        un = new javax.swing.JTextField();
        cg = new javax.swing.JTextField();
        l = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "unitcode", "unitname", "class_group", "lecturer"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Save Units");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        uc.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        uc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ucKeyPressed(evt);
            }
        });

        un.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N

        cg.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N

        l.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N

        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        jLabel1.setText("U.C");

        jLabel2.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        jLabel2.setText("U.N");

        jLabel3.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        jLabel3.setText("C.G");

        jLabel4.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        jLabel4.setText("L");

        jButton3.setText("See Record");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Logout");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(uc, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(4, 4, 4)
                        .addComponent(un, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(3, 3, 3)
                        .addComponent(cg, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(5, 5, 5)
                        .addComponent(l, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1)
                            .addGap(196, 196, 196)
                            .addComponent(jButton4))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(un, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          // Save Unit
        DefaultTableModel tblModel=(DefaultTableModel)jTable1.getModel();
if (tblModel.getRowCount()==0){
    JOptionPane.showMessageDialog(this, "Table Is Empty");
}else{
    String unitcode,unitname,class_group,lecturer;
      //insert transaction into database//
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:4306/zcoursedata?useSSL=false","root","");
        for(int i=0;i<tblModel.getRowCount();i++){
        unitcode=tblModel.getValueAt(i, 0).toString();
        unitname=tblModel.getValueAt(i, 1).toString();
        class_group=tblModel.getValueAt(i, 2).toString();
        lecturer=tblModel.getValueAt(i, 3).toString();
        String query="insert into courses(unitcode,unitname,class_group,lecturer)values(?,?,?,?)";
        PreparedStatement prepstmt=con.prepareStatement(query);
        prepstmt.setString(1, unitcode);
        prepstmt.setString(2, unitname);
        prepstmt.setString(3, class_group);     
        prepstmt.setString(4, lecturer);
        prepstmt.execute();
    }
        JOptionPane.showMessageDialog(this, "Units Added successfully!");
        tblModel.setRowCount(0);
    }catch(Exception e){
    }
}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // add to table
        if(uc.getText().length()==0 && un.getText().length()==0 && cg.getText().length()==0 && l.getText().length()==0){
        JOptionPane.showMessageDialog(this, "one or more fields empty!");
        return;
    }
         DefaultTableModel model=new DefaultTableModel();
        model=(DefaultTableModel)jTable1.getModel();
        model.addRow(new Object[]
        {
         uc.getText(),
         un.getText(),
         cg.getText(),
         l.getText()
        } );
       uc.setText("");
       un.setText("");
       cg.setText("");
       l.setText("");
      uc.requestFocus();          
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // go to units
        ZetechUnits ZU = new ZetechUnits();
        ZU.show();
        dispose();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        login LN= new login();
        LN.show();
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void ucKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ucKeyPressed
        // check out
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            String UC=uc.getText();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:4306/zcoursedata","root","");
                pst = con.prepareStatement("select * from courses where unitcode =?");
                pst.setString(1, UC);
                rs=pst.executeQuery();
                if(rs.next()==false)
                {
                    JOptionPane.showMessageDialog(this,"code Not found");
                }
                else{
                    String UCC = rs.getString("unitcode");
                    String UN = rs.getString("unitname");
                    String cgg = rs.getString("class_group");
                    String L = rs.getString("lecturer");

        
                    uc.setText(UCC.trim());
                    un.setText(UN.trim());
                    cg.setText(cgg.trim());
                    l.setText(L.trim());

                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ucKeyPressed

    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cg;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField l;
    private javax.swing.JTextField uc;
    private javax.swing.JTextField un;
    // End of variables declaration//GEN-END:variables
}
