/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adbms_miniproject;

import java.awt.Dimension;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Dell
 */
//database schema is used for stror data releted database
class dataBaseSchema{
        String extension;
        String database;
        List<String> tables;
        public dataBaseSchema(String ext,String db, List tab){
            extension=ext;
            database=db;
            tables=tab;
        }
}

public class home extends javax.swing.JFrame {
        JFileChooser chooser=new JFileChooser();
        String masterTable=null;
        String fileExtension;
        String db;
        String Accessdb;
        List<String> tb;
        ArrayList<dataBaseSchema> aldb=new ArrayList<dataBaseSchema>();
        boolean extraction=false;
        boolean transformation=false;
        boolean loding=false;
        // Declare the JDBC objects.
            Connection con = null;
            Statement stmt = null;
            ResultSet rs = null;
                String SQL= null;
    public home() {
        initComponents();
        //setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(400, 300));
        pack();
        //setContentPane(new JLabel((new ImageIcon("D:\\Project\\Adbms\\Images\\background_image.jpg"))));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dataSourcePart = new javax.swing.JPanel();
        dbName = new javax.swing.JTextField();
        dbChoser = new javax.swing.JButton();
        titleBarDb = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableList = new javax.swing.JList<>();
        connectDB = new javax.swing.JButton();
        resetDB = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tableConnect = new javax.swing.JButton();
        extractedDB = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        selectedDb = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        translatedDB = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbiList = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lodedDB = new javax.swing.JPanel();
        exT = new javax.swing.JButton();
        traN = new javax.swing.JButton();
        loD = new javax.swing.JButton();
        log = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        logs = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        homeMenu = new javax.swing.JMenu();
        newDataBase = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        importMenu = new javax.swing.JMenu();
        mssql = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        msAccess_2007 = new javax.swing.JMenuItem();
        msAccess_2003 = new javax.swing.JMenuItem();
        mysql = new javax.swing.JMenuItem();
        exportMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Data Switch");

        dataSourcePart.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        dbName.setText("Select Database file");
        dbName.setToolTipText("Select your Databse File");
        dbName.setEnabled(false);
        dbName.setFocusable(false);
        dbName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dbNameFocusGained(evt);
            }
        });
        dbName.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                dbNameInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        dbChoser.setText("...");
        dbChoser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbChoserActionPerformed(evt);
            }
        });

        titleBarDb.setBackground(new java.awt.Color(51, 51, 51));
        titleBarDb.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Select Your DataSource Details ");

        javax.swing.GroupLayout titleBarDbLayout = new javax.swing.GroupLayout(titleBarDb);
        titleBarDb.setLayout(titleBarDbLayout);
        titleBarDbLayout.setHorizontalGroup(
            titleBarDbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleBarDbLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        titleBarDbLayout.setVerticalGroup(
            titleBarDbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titleBarDbLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        tableList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "--No Tables--" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        tableList.setFocusable(false);
        tableList.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tableListFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(tableList);

        connectDB.setText("Connect Database");
        connectDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectDBActionPerformed(evt);
            }
        });

        resetDB.setText("Reset");
        resetDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetDBActionPerformed(evt);
            }
        });

        jLabel2.setText("Select Table");

        tableConnect.setText("Connect Table");
        tableConnect.setEnabled(false);
        tableConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tableConnectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dataSourcePartLayout = new javax.swing.GroupLayout(dataSourcePart);
        dataSourcePart.setLayout(dataSourcePartLayout);
        dataSourcePartLayout.setHorizontalGroup(
            dataSourcePartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleBarDb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(dataSourcePartLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(dbName, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dbChoser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(connectDB, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resetDB, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addGroup(dataSourcePartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(dataSourcePartLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tableConnect)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dataSourcePartLayout.setVerticalGroup(
            dataSourcePartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataSourcePartLayout.createSequentialGroup()
                .addComponent(titleBarDb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dataSourcePartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dataSourcePartLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(4, 4, 4)
                        .addGroup(dataSourcePartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dataSourcePartLayout.createSequentialGroup()
                                .addGroup(dataSourcePartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dbName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dbChoser)
                                    .addComponent(connectDB)
                                    .addComponent(resetDB))
                                .addContainerGap(28, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataSourcePartLayout.createSequentialGroup()
                        .addComponent(tableConnect)
                        .addGap(28, 28, 28))))
        );

        extractedDB.setBackground(new java.awt.Color(0, 0, 0));

        selectedDb.setColumns(20);
        selectedDb.setRows(5);
        jScrollPane3.setViewportView(selectedDb);

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(" Selected Database");

        javax.swing.GroupLayout extractedDBLayout = new javax.swing.GroupLayout(extractedDB);
        extractedDB.setLayout(extractedDBLayout);
        extractedDBLayout.setHorizontalGroup(
            extractedDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(extractedDBLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 118, Short.MAX_VALUE))
        );
        extractedDBLayout.setVerticalGroup(
            extractedDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, extractedDBLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        translatedDB.setBackground(new java.awt.Color(0, 0, 0));

        jScrollPane4.setViewportView(tbiList);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Selected Tables");

        javax.swing.GroupLayout translatedDBLayout = new javax.swing.GroupLayout(translatedDB);
        translatedDB.setLayout(translatedDBLayout);
        translatedDBLayout.setHorizontalGroup(
            translatedDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
            .addGroup(translatedDBLayout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        translatedDBLayout.setVerticalGroup(
            translatedDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(translatedDBLayout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane4))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        exT.setText("EXTRACTION");
        exT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exTActionPerformed(evt);
            }
        });

        traN.setText("TRANSFORMATION");
        traN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                traNActionPerformed(evt);
            }
        });

        loD.setText("LODING");
        loD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lodedDBLayout = new javax.swing.GroupLayout(lodedDB);
        lodedDB.setLayout(lodedDBLayout);
        lodedDBLayout.setHorizontalGroup(
            lodedDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lodedDBLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exT, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(traN, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(loD, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        lodedDBLayout.setVerticalGroup(
            lodedDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lodedDBLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(lodedDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(loD, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addGroup(lodedDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(traN, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                        .addComponent(exT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout logLayout = new javax.swing.GroupLayout(log);
        log.setLayout(logLayout);
        logLayout.setHorizontalGroup(
            logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        logLayout.setVerticalGroup(
            logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 86, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(logs);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Logs");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        homeMenu.setText("  Home  ");

        newDataBase.setText("Create DataBase");
        newDataBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newDataBaseActionPerformed(evt);
            }
        });
        homeMenu.add(newDataBase);

        jMenuItem3.setText("Drop DataBase");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        homeMenu.add(jMenuItem3);

        jMenuBar1.add(homeMenu);

        importMenu.setText("  Import  ");

        mssql.setText("  MS SQL  ");
        mssql.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mssqlActionPerformed(evt);
            }
        });
        importMenu.add(mssql);

        jMenu1.setText("  MS Access  ");

        msAccess_2007.setText("MS Access 2007");
        msAccess_2007.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msAccess_2007ActionPerformed(evt);
            }
        });
        jMenu1.add(msAccess_2007);

        msAccess_2003.setText("MS Access 2003");
        jMenu1.add(msAccess_2003);

        importMenu.add(jMenu1);

        mysql.setText("  MY SQL  ");
        importMenu.add(mysql);

        jMenuBar1.add(importMenu);

        exportMenu.setText("  Export  ");
        jMenuBar1.add(exportMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(extractedDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(translatedDB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lodedDB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(log, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dataSourcePart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dataSourcePart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(extractedDB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(translatedDB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lodedDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newDataBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newDataBaseActionPerformed
        System.out.println("new DataBase Menu is Selected ");
        new createDatabase().setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_newDataBaseActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        System.out.println("Drop Database Menu is Selected ");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void mssqlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mssqlActionPerformed

    }//GEN-LAST:event_mssqlActionPerformed

    private void msAccess_2007ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msAccess_2007ActionPerformed

    }//GEN-LAST:event_msAccess_2007ActionPerformed

    private void dbNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dbNameFocusGained

    }//GEN-LAST:event_dbNameFocusGained

    private void tableListFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableListFocusLost

    }//GEN-LAST:event_tableListFocusLost

    private void resetDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetDBActionPerformed
        dbName.setText("Select Database file");
        String listData[]={"--No Tables--"};
        tableList.setListData(listData);
    }//GEN-LAST:event_resetDBActionPerformed

    private void dbChoserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbChoserActionPerformed
        try{
            
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Database File", "db","mdf","accdb","mdb","myd");
                chooser.setFileFilter(filter);
                chooser.showOpenDialog(null);
                File file;
                    if(chooser.isFileSelectionEnabled()){
                        file=chooser.getSelectedFile();
                        dbName.setText(file.getName());
                            // Insert the Table in list tableDB
                           tableConnect.setEnabled(true);
                    }
        }
        catch(Exception e){
             String textPanel=logs.getText();
            logs.setText(textPanel+"\nDatabase file are not selected ");
            System.out.println("Database not Selected : "+e);
        }
    }//GEN-LAST:event_dbChoserActionPerformed

    private void dbNameInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_dbNameInputMethodTextChanged
        System.out.println("Context is Changed : ");
    }//GEN-LAST:event_dbNameInputMethodTextChanged

    private void connectDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectDBActionPerformed
        String fileName=dbName.getText();
        fileName=fileName.substring(fileName.lastIndexOf("."),fileName.length());
        System.out.println("Filename : "+fileName);
        fileExtension=fileName;
        /*
        System.out.println("index : "+index);
            switch(fileName){
                case ".mdf":
                    fileExtension=".mdf";
                break;
                case ".accdb":
                    fileExtension=".accdb";
                break;
                case ".mdb":
                    fileExtension=".mdb";
                break;
                case ".db":
                    fileExtension=".db";
                break;
            }
        */
        db=dbName.getText().substring(0,dbName.getText().indexOf("."));
        System.out.println("database Name : "+db);
         try{
            connectDbSystem(fileExtension);
            String sql=null;
                switch(fileExtension){
                    case ".mdf":
                        sql="select TABLE_NAME from INFORMATION_SCHEMA.TABLES " +
                        "where TABLE_TYPE = 'BASE TABLE'";
                    break;
                    case ".accdb":
                        sql="select TABLE_NAME from INFORMATION_SCHEMA.TABLES " +
                        "where TABLE_TYPE = 'BASE TABLE'";
                    break;
                    case ".mdb":
                        sql="select TABLE_NAME from INFORMATION_SCHEMA.TABLES " +
                        "where TABLE_TYPE = 'BASE TABLE'";    
                    break;
                }
            rs=SQLquery(sql);
                int row=getRows();
                System.out.println(row);
                String tbname[]=new String[row];
                int i=0;
                while(rs.next()){
                    tbname[i]=rs.getString("TABLE_NAME");
                    i++;
                }
                tableList.setListData(tbname);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(this, ""+ex.getMessage(),"Connecting error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_connectDBActionPerformed

    private void tableConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tableConnectActionPerformed
        tb=tableList.getSelectedValuesList();
        aldb.add(new dataBaseSchema(fileExtension,db,tb));
        /*System.out.println("fileExtension : "+fileExtension+"\ndb : "+db+"\ntb"+tb);
        System.out.println("Table is added into arraylist : ");*/
            for(int i=0;i<aldb.size();i++){
                System.out.println(""+aldb.get(i).database+"\nSystem : "+aldb.get(i).extension+"\nTables : "+aldb.get(i).tables);
            }
    }//GEN-LAST:event_tableConnectActionPerformed

    private void exTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exTActionPerformed
        if(aldb.isEmpty()){
            JOptionPane.showMessageDialog(this, "Database view does not exists ","Extraction error",JOptionPane.ERROR_MESSAGE);
        }
        else{
            extraction=true;
            String finalEx=null;
            String dbName=null;
            ImageIcon icon = new ImageIcon("D:\\Project\\Adbms\\Images\\middle.gif");
            masterTable = (String)JOptionPane.showInputDialog(this,"Enter the name of master table "+ "\nFrom the selected tables \n","Master Table",JOptionPane.PLAIN_MESSAGE,icon, null,"ham");
            System.out.println("Master table : "+masterTable);
                for(int i=0;i<aldb.size();i++){
                    if(aldb.get(i).tables.contains(masterTable)){
                        finalEx=aldb.get(i).extension;
                        dbName=aldb.get(i).database;
                        break;
                    }
                }
            System.out.println("final Table : "+finalEx);
            db=dbName;
            switch(finalEx){
                case ".mdf":
                    try{
                        msSqlConnectivity();
                    }
                    catch(Exception ex){
                        JOptionPane.showMessageDialog(this, ""+ex.getMessage(),"Connecting error",JOptionPane.ERROR_MESSAGE);
                    }
                break;
                case ".accdb":
                    try{
                        accessConnectivity();
                    }
                    catch(Exception ex){
                        JOptionPane.showMessageDialog(this, ""+ex.getMessage(),"Connecting error",JOptionPane.ERROR_MESSAGE);
                    }
                break;
                case ".mdb":
                    try{
                        accessConnectivity();
                    }
                    catch(Exception ex){
                        JOptionPane.showMessageDialog(this, ""+ex.getMessage(),"Connecting error",JOptionPane.ERROR_MESSAGE);
                    }
                break;
            }
            ArrayList<ResultSet> alrs=new ArrayList<ResultSet>();
            ArrayList<String> alCol=new ArrayList<String>();
            String sql="SELECT name FROM syscolumns WHERE id=OBJECT_ID('"+masterTable+"')";
            try {
                rs = SQLquery(sql);
                while(rs.next()){
                    alCol.add(rs.getString("name"));
                }
                    System.out.println("Col name : "+alCol);
            } catch (SQLException ex) {
                Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
            }
            //File Extansion
            ArrayList<String> fileExtension=new ArrayList<String>();
            // End of connectivity 
            String SQL="Select * Into "+masterTable+"_01 From "+masterTable+" Where 1 = 2";
            try {
                    if(createTable(SQL)){
                        System.out.println("SQL : "+SQL);   // table created successfully 
                            for(int i=0;i<aldb.size();i++){
                                dbName=null;
                                dbName=aldb.get(i).database;
                                finalEx=null;
                                finalEx=aldb.get(i).extension;
                                    // SQL retrive
                            switch(finalEx){
                                case ".mdf":
                                    try{
                                        msSqlConnectivity();
                                            for(int j=0;j<aldb.get(i).tables.size();j++){
                                                SQL="SELECT * FROM "+aldb.get(i).tables.get(j)+"";
                                                alrs.add(SQLquery(SQL));
                                                fileExtension.add(".mdf");
                                            }
                                    }
                                    catch(Exception ex){
                                        JOptionPane.showMessageDialog(this, ""+ex.getMessage(),"Connecting error",JOptionPane.ERROR_MESSAGE);
                                    }
                                break;
                                case ".accdb":
                                    try{
                                        accessConnectivity();
                                        for(int j=0;j<aldb.get(i).tables.size();j++){
                                                SQL="SELECT * FROM "+aldb.get(i).tables.get(j)+"";
                                                alrs.add(SQLquery(SQL));
                                                fileExtension.add(".accdb");
                                        }
                                    }
                                    catch(Exception ex){
                                        JOptionPane.showMessageDialog(this, ""+ex.getMessage(),"Connecting error",JOptionPane.ERROR_MESSAGE);
                                    }
                                break;
                                case ".mdb":
                                        try{
                                            accessConnectivity();
                                            for(int j=0;j<aldb.get(i).tables.size();j++){
                                                SQL="SELECT * FROM "+aldb.get(i).tables.get(j)+"";
                                                alrs.add(SQLquery(SQL));
                                                fileExtension.add(".mdb");
                                            }
                                        }
                                        catch(Exception ex){
                                            JOptionPane.showMessageDialog(this, ""+ex.getMessage(),"Connecting error",JOptionPane.ERROR_MESSAGE);
                                        }
                                break;
                                }
                            }
                        for(int i=0;i<alrs.size();i++){
                            while(alrs.get(i).next()){
                                switch(fileExtension.get(i)){
                                    case ".mdf":
                                            msSqlConnectivity();
                                    break;
                                    case ".accdb":
                                            accessConnectivity();
                                    break;
                                    case ".mdb":
                                            accessConnectivity();
                                    break;
                                    }
                                SQL="insert into "+masterTable+"_01 values ('"+alrs.get(i).getString(alCol.get(0))+"','"+alrs.get(i).getString(alCol.get(1))+"','"+alrs.get(i).getString(alCol.get(2))+"','"+alrs.get(i).getString(alCol.get(3))+"','"+alrs.get(i).getString(alCol.get(4))+"')";
                                System.out.println(SQL);
                                    msSqlConnectivity();
                                    if(insertTable(SQL)){
                                        System.out.println("Data inserted into master table successfully : ");
                                    }                                
                            }
                        }
                        //msSqlConnectivity();
                    }
            } catch (SQLException ex) {
                Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_exTActionPerformed
    private boolean createTable(String sql)throws SQLException{
        SQL=sql;
        stmt = con.createStatement();
        stmt.executeUpdate(SQL);
        return true;
    }
    private boolean insertTable(String sql)throws SQLException{
        SQL=sql;
        stmt = con.createStatement();
        stmt.executeUpdate(SQL);
        return true;
    }
    private boolean updateTable(String sql)throws SQLException{
        SQL=sql;
        stmt = con.createStatement();
        stmt.executeUpdate(SQL);
        return true;
    }
    private void traNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_traNActionPerformed
        if(extraction){
            transformation=true;
            String SQL="UPDATE "+masterTable+"_01 SET gender='Male' where gender='M'";
            try {
                msSqlConnectivity();
                updateTable(SQL);
                SQL="UPDATE "+masterTable+"_01 SET gender='Female' where gender='F'";
                updateTable(SQL);
                JOptionPane.showMessageDialog(this, "Transformed Successfully  ","Transformation ",JOptionPane.PLAIN_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        else{
            JOptionPane.showMessageDialog(this, "Database is not extracted  ","Transformation error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_traNActionPerformed

    private void loDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loDActionPerformed
        if(transformation){
            loding=true;
            String SQL="Select * Into "+masterTable+"_Final From "+masterTable+"";
            
        }
        else{
            JOptionPane.showMessageDialog(this, "Database is not transformed  ","Transformation error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_loDActionPerformed

    private void connectDbSystem(String fileEx)throws SQLException,ClassNotFoundException{
        switch(fileEx){
            case ".mdf":
                    msSqlConnectivity();
            break;
            case ".accdb":
                File file=chooser.getSelectedFile();
                Accessdb=file.getAbsolutePath();
                    accessConnectivity();
            break;
            case ".mdb":
                    accessConnectivity();
            break;
        }
    }    
    private void msSqlConnectivity()throws SQLException,ClassNotFoundException{
        System.out.println("ms sql Connectivity ");
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");                   
        String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
                            "databaseName="+db+";integratedSecurity=true;";
        con = DriverManager.getConnection(connectionUrl);
    }
    public ResultSet SQLquery(String sql)throws SQLException{
        ResultSet tempRs=null;
        SQL=sql;
        stmt = con.createStatement();
        tempRs= stmt.executeQuery(SQL);
        return tempRs;
    }
    public int getRows()throws SQLException{
        String sql="SELECT COUNT(TABLE_NAME) FROM INFORMATION_SCHEMA.TABLES " +
                        "where TABLE_TYPE = 'BASE TABLE'";
        ResultSet rsSet=SQLquery(sql);
        int row=0;
        while(rsSet.next()){
            row=rsSet.getInt(1);
        }
        return row;
    }
    public void closeConnection()throws SQLException{
        con.close();
        rs.close();
        stmt.close();
    }
    private void accessConnectivity(){
        try{    
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                con=DriverManager.getConnection("jdbc:ucanaccess://"+Accessdb);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(this, ""+ex.getMessage(),"Connecting error",JOptionPane.ERROR_MESSAGE);
        }
    }
    private void mysqlConnectivity(){
        
    }
    private boolean validedData(){
            //Database validation is not available 
        return false;
    }

    public static void main(String args[])throws SQLException, ClassNotFoundException {
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
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>       
         try {
            
            // Select the Look and Feel
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");         
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    // Start the application
                    new home().setVisible(true);                            
                }
            });            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connectDB;
    private javax.swing.JPanel dataSourcePart;
    private javax.swing.JButton dbChoser;
    private javax.swing.JTextField dbName;
    private javax.swing.JButton exT;
    private javax.swing.JMenu exportMenu;
    private javax.swing.JPanel extractedDB;
    private javax.swing.JMenu homeMenu;
    private javax.swing.JMenu importMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton loD;
    private javax.swing.JPanel lodedDB;
    private javax.swing.JPanel log;
    private javax.swing.JTextPane logs;
    private javax.swing.JMenuItem msAccess_2003;
    private javax.swing.JMenuItem msAccess_2007;
    private javax.swing.JMenuItem mssql;
    private javax.swing.JMenuItem mysql;
    private javax.swing.JMenuItem newDataBase;
    private javax.swing.JButton resetDB;
    private javax.swing.JTextArea selectedDb;
    private javax.swing.JButton tableConnect;
    private static javax.swing.JList<String> tableList;
    private javax.swing.JTextPane tbiList;
    private javax.swing.JPanel titleBarDb;
    private javax.swing.JButton traN;
    private javax.swing.JPanel translatedDB;
    // End of variables declaration//GEN-END:variables
}
