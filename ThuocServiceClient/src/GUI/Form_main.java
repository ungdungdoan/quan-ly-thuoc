package GUI;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.ParseConversionEvent;

import org.apache.axis2.AxisFault;

import servicethuoc.ManagerSQLExceptionException;
import servicethuoc.ManagerStub;
import servicethuoc.ManagerStub.AddThuoc;
import servicethuoc.ManagerStub.DeleteThuoc;
import servicethuoc.ManagerStub.UpdateThuoc;
import thuocForm.Thuoc;
import thuocForm.ThuocManager;
import thuocimpl.ListServiceGetStub;
import thuocimpl.ListServiceGetStub.StringListGetByJson;
import thuocimpl.ListServiceGetStub.StringListGetByJsonResponse;

import java.awt.event.*;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.util.List;
@SuppressWarnings("serial")
public class Form_main extends ManagerThuoc{
      String gender = "";
      ResultSet rst,rstLast;
      Object[][] data;
      int serialNo; 
      String SHOW = "Show";
      ManagerThuoc formGUIObject;

      // Defining Constructor
      Form_main(){
    	  idField.enable(true);
            nameField.addKeyListener(new KeyAdapter() {
                  public void keyTyped(KeyEvent e) {
                  if(nameField.getText().length()>50)
                        e.consume();
                  }
            });
            male.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                        gender = "Male";
                  }
            });
            female.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                        gender = "Female";
                  }
            });
            addressField.addKeyListener(new KeyAdapter() {
                  public void keyTyped(KeyEvent e) {
                  if(addressField.getText().length()>90)
                        e.consume();
                  }
            });
            contactField.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                if(contactField.getText().length()>90)
                      e.consume();
                }
          });
            
            exitButton.addActionListener(new ActionListener(){
                  public void actionPerformed(ActionEvent arg0) {
                        try{
                           
                              System.exit(0);
                        }catch(Exception ex){
                               System.out.println(ex.getMessage());
                        }
                  }
            });
            registerButton.addActionListener(new AbstractAction(SHOW){
                   public void actionPerformed(ActionEvent ae){
                         try{
                            if (ae.getSource() == registerButton) {

                                if (idField.getText().equals(""))
                                   JOptionPane.showMessageDialog(idField, 
                                               "Dien Ma Thuoc");
                                
                                else if (nameField.getText().equals(""))
                                   JOptionPane.showMessageDialog(nameField, 
                                               "Dien Ten Thuoc");
                                else if(addressField.getText().equals(""))
                                   JOptionPane.showMessageDialog(idField, 
                                               "Dien Ten Thuoc");
                                else if(contactField.getText().equals(""))
                                   JOptionPane.showMessageDialog(idField, "Dien So Luong Thuoc");
                                else if(gender.equals(""))
                                   JOptionPane.showMessageDialog(idField, "Dien Gia Thuoc");
                                else {
                                	ManagerStub mn = new ManagerStub();
                                	AddThuoc adt = new AddThuoc();
                                	adt.setMathuoc(Integer.parseInt(idField.getText()));
                                	adt.setTenthuoc(nameField.getText());
                                 	if(male.isSelected()==true && female.isSelected()==false){
                                		adt.setDonvitinh("Hop");}
                                	else if(female.isSelected()==true && male.isSelected()==false){
                                		adt.setDonvitinh("Vy");}
                                	adt.setSoluong(Integer.parseInt(addressField.getText()));
                                	
                                	adt.setDongia(Integer.parseInt(contactField.getText()));
                                	
                                	mn.addThuoc(adt);
                                	refreshTable();
                                    int i=1;                            
                                	if(i==1){
                                  JOptionPane.showMessageDialog(panel, 
                                               "Them Thanh Cong");
                                 }
 
                                 // showing last row 
                                //rstLast = stmt.executeQuery("select *from regForm");
                               
 
                                 // fields are blank
                                 blankFields();
                               }
                              }
                       }catch(Exception ex){
                              System.out.println(ex.getMessage()); 
                       }
                   }
            });
 
            updateButton.addActionListener(new AbstractAction(SHOW){
              public void actionPerformed(ActionEvent e){
            	  idField.enable(false);
            	 
                            int r = table.getSelectedRow();
                      
                            if(r>=0){
										try {
											ManagerStub	mn = new ManagerStub();
                                    	UpdateThuoc udt = new UpdateThuoc();
                                    	udt.setMathuoc(Integer.parseInt(idField.getText()));
                                    	udt.setTenthuoc(nameField.getText());
                                    	udt.setSoluong(Integer.parseInt(addressField.getText()));
                                    	System.out.println(contactField.getText());
                                    	udt.setDongia(Integer.parseInt(contactField.getText()));
                                       	if(male.isSelected()==true && female.isSelected()==false){
                                    		udt.setDonvitinh("Hop");}
                                    	else if(female.isSelected()==true && male.isSelected()==false){
                                    		udt.setDonvitinh("Vy");}
                                    
											mn.updateThuoc(udt);
											refreshTable();
										} catch (AxisFault | ManagerSQLExceptionException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										} catch (RemoteException e1) {
											// TODO Auto-generated catch block
											System.out.println(e1);
											e1.printStackTrace();
										}
                                   int i=1;
                               }
                                 
                               
                             
                }}
              
          );
 
            //Registering Anonymous Listener Class
            deleteButton.addActionListener(new AbstractAction(SHOW){ 
              public void actionPerformed(ActionEvent e){
            	  idField.enable(false);
                  try{ 
                  //Getting Selected Row No
                  int r = table.getSelectedRow(); 
                  if(r>=0){ 
                        if (JOptionPane.showConfirmDialog(panel,
                            "Ban Co Muon Xoa Khong","WARNING",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                              String id = (String)table.getModel().getValueAt(r,1);
 
                              // Executing MySQL Update Command
                              //int i = stmt.executeUpdate("delete from regForm where id="+id);
                              if(true){
                                  
                            	  	ManagerStub xoa = new ManagerStub();
                            	  	
                            	  	DeleteThuoc qq = new DeleteThuoc();
                            	  	qq.setMathuoc(r);
                            	  	xoa.deleteThuoc(qq);
 
                                    // fields are blank
                                    blankFields();
                                    registerButton.setEnabled(true);
                                    deleteButton.setEnabled(false);
                                    updateButton.setEnabled(false);
                                    refreshTable();
                              }
                        }
                  }
                  }catch(Exception ex){
                         System.out.println(ex.getMessage());
                  }
              }
          });
 
           //Registering Anonymous Listener Class
            resetButton.addActionListener(new ActionListener(){
                  public void actionPerformed(ActionEvent arg0) {
                        // calling method resetFields()
                        resetFields();
                        registerButton.setEnabled(true);
                        updateButton.setEnabled(false);
                        deleteButton.setEnabled(false);
                        resetButton.setEnabled(false);
                  }
            });

            // Registering Anonymous Listener Class
            refresh.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent arg0) {
                        //calling  refresh() method
                        refreshTable();
                  }
            });

            //Registering Anonymous Listener Class
            table.addMouseListener(new MouseListener(){
                  public void mouseClicked(MouseEvent arg0){ 
                        //Getting Selected Row No
                	  idField.enable(false);
                  int r = table.getSelectedRow();
                  if(r>=0){ 
                        deleteButton.setEnabled(true);
                        updateButton.setEnabled(true);
                        resetButton.setEnabled(true);
                        registerButton.setEnabled(false); 

                        //Fetching records from Table on Fields
                        idField.setText(""+table.getModel().getValueAt(r,0));
                        nameField.setText(""+table.getModel().getValueAt(r,1));
                        if(table.getModel().getValueAt(r,2).equals("Vy"))
                              female.setSelected(true);
                        else
                              male.setSelected(true);
                        addressField.setText(""+table.getModel().getValueAt(r,3));
                        contactField.setText(""+table.getModel().getValueAt(r,4));
                  }
                  }

//                @Override
                  public void mouseReleased(MouseEvent arg0) {}
//                @Override
                  public void mousePressed(MouseEvent arg0) {}
//                @Override 
                  public void mouseExited(MouseEvent arg0) {}
//                @Override 
                  public void mouseEntered(MouseEvent arg0) {}
            });

            // Displaying rows into the Frame table
            addRows();
      }

      // addRows method
      private void addRows(){
            try{
            	ThuocManager tm = new ThuocManager();
            	List<Thuoc> lithuoc = tm.getAllThuoc();

            Object[] row = null;
       
            for (int i = 0; i < lithuoc.size(); i++) {
                  String string = lithuoc.get(i).getMathuoc()+","+lithuoc.get(i).getTenthuoc()+","+lithuoc.get(i).getDonvitinh()+","+lithuoc.get(i).getSoluong()+","+lithuoc.get(i).getDongia()+",";
                  row = string.split(",");
                  // Adding records in table model 
                  model.addRow(row);
            }
            panel.revalidate();
            }catch(Exception ex){ System.out.println(ex.getMessage()); }
      }

      private void resetFields(){ 
    	  	idField.enable(true);
            //calling method blankfields() 
            blankFields();
      }
 
      // refresh method
      private void refreshTable(){
 
            // removing all the rows of the table
            DefaultTableModel dm = (DefaultTableModel)table.getModel();
            dm.getDataVector().removeAllElements();
            System.out.println("Refresh Table");

            //calling method addRows
            addRows();
      }

      private void blankFields(){
            // fields will be blank
            idField.setText("");
            nameField.setText("");
            gender = "";
            bg.clearSelection();
            addressField.setText("");
            contactField.setText("");
      }

      // main() method
      public static void main(String[] args) {
            new Form_main();
      }     
}
 