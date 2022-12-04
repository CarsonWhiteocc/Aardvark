/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aardvarkdb;

import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;  
import javafx.event.EventHandler; 
import javafx.scene.control.TextField;

public class CustomerView 
{
    private static Stage stg;
    
    private static Middleware mw;
    
    private static String accNum;
    private static String preference;
    
    private static int allowance;
            
    private static Scene sc;
    
    private static GridPane gp;
    private static GridPane subGp;
    
    private static TextField txtfld1;
    
    private static TableView tv1;
    private static TableView tv2;
    
    private static Button transHistory;
    private static Button account;
    private static Button inventory;
    
    private static Button changePref;
    private static Button makeTrans;
    
    private static Button confirm;
    
    public CustomerView(Stage s)
    {
        stg = s;
        txtfld1 = new TextField("Enter your account number");
        confirm = new Button("Confirm");
        gp = new GridPane();
        gp.addRow(0, txtfld1);
        gp.addRow(0, confirm);
        mw = new Middleware();
        
        sc = new Scene(gp);
        confirm.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent arg0) 
            {   
                accNum = txtfld1.getText();
                if(mw.findAccount(accNum) != null)
                {
                    stg.close();
                    allowance = mw.findAllowance(accNum);
                    setScene("transHist");
                }
                else
                {
                    System.out.println("Couldn't find that account");
                }
            }
        });
        stg.setScene(sc);
        stg.show();
    }
    public static void setScene(String str)
    {
        mw = new Middleware();
        
        switch(str)
        {
            default:
                tv1 = mw.viewTable(str);
                break;
            case "transHist":
                tv1 = mw.viewHistory(accNum);
                break;
            case "account":
                tv1 = mw.account(accNum);
                break;
        }
        transHistory = new Button("View Your History");
        account = new Button("View Your Account");
        inventory = new Button("View Available Bloodbags");
        changePref = new Button("Change Preference");
        makeTrans = new Button("Make Transaction");
        
        gp = new GridPane();
        subGp = new GridPane();
        
        subGp.addRow(0, transHistory, account, inventory);
        subGp.addRow(1, makeTrans, changePref);
        gp.addRow(0, subGp);
        gp.addRow(1, tv1);
        
        sc = new Scene(gp);
        
        transHistory.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent arg0) 
            {   
                setScene("transHist");
            }
        });
        account.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent arg0) 
            {   
                setScene("account");
            }
        });
        inventory.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent arg0) 
            {   
                setScene("cusView");
            }
        });        
        changePref.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent arg0) 
            {   
                changePrefScene();
            }
        });
        makeTrans.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent arg0) 
            {   if(allowance > 0)
                    transactionScene();
            }
        });
        stg.setScene(sc);
        stg.show();
    }
    public static void changePrefScene()
    {
        mw = new Middleware();
        tv1 = mw.account(accNum);
        mw = new Middleware();        
        tv2 = mw.viewTable("Bloodtype");
        
        txtfld1 = new TextField("New Preference ID");
        
        confirm = new Button("Confirm");
        
        gp = new GridPane();
        subGp = new GridPane();
        
        subGp.addRow(0, txtfld1);
        subGp.addRow(1, confirm);
        gp.addRow(0, subGp);
        gp.addRow(1, tv1, tv2);
        
        sc = new Scene(gp);
        confirm.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent arg0) 
            {   
                mw.changePreference(txtfld1.getText(), accNum);
                setScene("account");
            }
        });
        stg.setScene(sc);
        stg.show();
    }
    public static void transactionScene()
    {
        mw = new Middleware();
        tv1 = mw.viewTable("cusView");
        
        txtfld1 = new TextField("Enter Bloodbag ID");
        
        confirm = new Button("Confirm");
        
        gp = new GridPane();
        
        gp.addRow(0, txtfld1);
        gp.addRow(1, confirm);
        gp.addRow(2, tv1);
        
        sc = new Scene(gp);
        confirm.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent arg0) 
            {   
                mw.makeTransaction(accNum, txtfld1.getText());
                allowance = mw.findAllowance(accNum);
                setScene("transHist");
            }
        });
        stg.setScene(sc);
        stg.show();
    }
}
