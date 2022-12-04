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

public class EmployeeView 
{
    static private Middleware mw;
    
    static private Scene sc;
    
    static private Stage stg;
    
    static private GridPane gp;
    static private GridPane subgp;
    
    static private TableView tv1;

    static private Button vampires;
    static private Button donors;
    static private Button bloodbags;
    static private Button banks;
    static private Button bloodtypes;
    static private Button inventories;
    static private Button transactions;
    static private Button accounts;

    public EmployeeView(Stage s)
    {
        stg = s;
        setScene("Bloodbag");
    }
    public static void setScene(String tablename)
    {
        mw = new Middleware();
        tv1 = mw.viewTable(tablename);
        
        gp = new GridPane();
        
        subgp = new GridPane();
        
        vampires = new Button("View Vampires");
        donors = new Button("View Donors");
        bloodbags = new Button("View Bloodbags");
        banks = new Button("View Banks");
        bloodtypes = new Button("View Bloodtypes");
        inventories = new Button("View Inventories");
        accounts = new Button("View Accounts");
        transactions = new Button("View Transactions");
        
        sc = new Scene(gp, 500, 500);
        subgp.addRow(0, vampires, donors, bloodbags);
        subgp.addRow(1, banks,bloodtypes, inventories);
        subgp.addRow(2, transactions, accounts);
        
        gp.addRow(0, subgp);
        gp.addRow(1, tv1);
        vampires.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent arg0) 
            {    
                setScene("Vampire");
            }
        });
        donors.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent arg0) 
            {    
                setScene("Donor");
            }
        });
        bloodbags.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent arg0) 
            {    
                setScene("Bloodbag");
            }
        });
        banks.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent arg0) 
            {    
                setScene("Bank");
            }
        });
        bloodtypes.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent arg0) 
            {    
                setScene("Bloodtype");
            }
        });
        inventories.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent arg0) 
            {    
                setScene("Inventory");
            }
        });
        transactions.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent arg0) 
            {    
                setScene("Transaction");
            }
        });
        accounts.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent arg0) 
            {    
                setScene("viewAccount");
            }
        });
        stg.setScene(sc);
        stg.show();
    }
}