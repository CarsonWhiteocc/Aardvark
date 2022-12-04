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

public class AdminView 
{
    static private Middleware mw;
    static private Scene sc;
    static private Stage stg;
    
    static private GridPane gp;
    static private GridPane subgp;
    
    static private TableView tv1;
    static private TableView tv2;
    
    static private TextField txtfld1;
    static private TextField txtfld2;
    static private TextField txtfld3;
    
    static private Button vampires;
    static private Button donors;
    static private Button bloodbags;
    static private Button banks;
    static private Button bloodtypes;
    static private Button inventories;
    static private Button transactions;
    static private Button accounts;
    
    static private Button addAccount;
    static private Button addBank;
    static private Button addDonor;
    static private Button addBloodbag;
    
    static private Button openBank;
    
    static private Button confirm;
    public AdminView(Stage s)
    {
        stg = s;
        setScene("Donor");
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
        
        addAccount = new Button("Add Account");
        addBank = new Button("Add Bank");
        addDonor = new Button("Add Donor");
        addBloodbag = new Button("Add Bloodbag");
        
        openBank = new Button("Open Bank");
        
        sc = new Scene(gp, 500, 500);
        subgp.addRow(0, vampires, donors, bloodbags, banks);
        subgp.addRow(1, bloodtypes, inventories, transactions, accounts);
        subgp.addRow(2, addAccount, addBank, addDonor, addBloodbag);
        subgp.addRow(3, openBank);
        
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
        addBank.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent arg0) 
            {    
                addBankScene();
            }
        });
        addAccount.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent arg0) 
            {    
                addAccountScene();
            }
        });
        addDonor.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent arg0) 
            {    
                addDonorScene();
            }
        });
        addBloodbag.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent arg0) 
            {    
                addBloodbagScene();
            }
        });
        openBank.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent arg0) 
            {    
                openBankScene();
            }
        });
        stg.setScene(sc);
        stg.show();
    }
    public static void addBankScene()
    {
        mw = new Middleware();
        tv1 = mw.viewTable("Bank");

        gp = new GridPane();
        
        txtfld1 = new TextField("Enter Location Here");
        
        confirm = new Button("Confirm");
        
        gp.addRow(0, txtfld1);
        gp.addRow(1, confirm);
        gp.addRow(2, tv1);
        
        sc = new Scene(gp, 500, 500);
        stg.setScene(sc);
        stg.show();
        confirm.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent arg0) 
            {    
                mw.addBank(txtfld1.getText());
                setScene("Bank");
            }
        });
    }
    public static void addAccountScene()
    {
        mw = new Middleware();
        tv1 = mw.viewTable("addAccount");
        mw = new Middleware();
        tv2 = mw.viewTable("Bloodtype");

        gp = new GridPane();
        subgp = new GridPane();
        
        txtfld1 = new TextField("Enter ID Here");
        txtfld2 = new TextField("Enter Allowance Here");
        txtfld3 = new TextField("Enter Bloodtype ID Preference Here (Optional)");
        
        confirm = new Button("Confirm");
        
        subgp.addRow(0, txtfld1);
        subgp.addRow(1, txtfld2);
        subgp.addRow(2, txtfld3);
        subgp.addRow(3, confirm);
        
        gp.addRow(0, subgp);
        gp.addRow(1, tv1, tv2);
        
        sc = new Scene(gp, 500, 500);
        stg.setScene(sc);
        stg.show();
        confirm.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent arg0) 
            {    
                mw.addAccount(txtfld1.getText(), 
                        txtfld2.getText(), txtfld3.getText());
                setScene("viewAccount");
            }
        });
    }
    public static void addDonorScene()
    {
        mw = new Middleware();
        tv1 = mw.viewTable("Bloodtype");

        gp = new GridPane();
        
        txtfld1 = new TextField("Enter Bloodtype ID Here");
        txtfld2 = new TextField("Enter Personal Info Here");
        
        confirm = new Button("Confirm");
        
        
        gp.addRow(0, txtfld1);
        gp.addRow(1, txtfld2);
        gp.addRow(2, confirm);
        gp.addRow(3, tv1);
        
        sc = new Scene(gp, 500, 500);
        stg.setScene(sc);
        stg.show();
        confirm.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent arg0) 
            {    
                mw.addDonor(txtfld1.getText(), 
                        txtfld2.getText());
                setScene("Donor");
            }
        });
    }
    public static void addBloodbagScene()
    {
        mw = new Middleware();
        tv1 = mw.viewTable("Donor");
        mw = new Middleware();
        tv2 = mw.viewTable("Bank");

        gp = new GridPane();
        
        txtfld1 = new TextField("Enter Donor ID");
        txtfld2 = new TextField("Enter Bank ID");
        
        confirm = new Button("Confirm");
        
        gp.addRow(0, txtfld1);
        gp.addRow(1, txtfld2);
        gp.addRow(2, confirm);
        gp.addRow(3, tv1, tv2);
        
        confirm.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent arg0) 
            {    
                mw.addBloodbag(txtfld1.getText(), 
                        txtfld2.getText());
                setScene("Bloodbag");
            }
        });
        sc = new Scene(gp, 500, 500);
        stg.setScene(sc);
        stg.show();
    }
    public static void openBankScene()
    {
        mw = new Middleware();
        tv1 = mw.viewTable("newBank");

        gp = new GridPane();
        
        txtfld1 = new TextField("Enter Bank ID");
        
        confirm = new Button("Confirm");
        
        gp.addRow(0, txtfld1);
        gp.addRow(2, confirm);
        gp.addRow(3, tv1);
        
        confirm.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent arg0) 
            {    
                mw.openBank(txtfld1.getText());
                setScene("Bank");
            }
        });
        sc = new Scene(gp, 500, 500);
        stg.setScene(sc);
        stg.show();
    }
}
