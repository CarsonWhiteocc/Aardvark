/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aardvarkdb;

import javafx.scene.control.*;
import java.sql.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class Middleware 
{
    private Backend be;
    private ObservableList<Table> data = 
            FXCollections.observableArrayList();

            
    public Middleware()
    {
        be = new Backend();
    }
    public TableView viewTable(String tableName)
    {
        String query = "Select * from " + tableName;
        query = query.toUpperCase();
        ResultSet rs = be.handleQuery(query);
        return createTable(rs);
    }
    public TableView createTable(ResultSet rs)
    {
        TableView out = new TableView();
       
        try
        {
            switch(rs.getMetaData().getTableName(1).toLowerCase())
            {
                case "bloodtype":
                {
                    
                    TableColumn id = new TableColumn("ID");
                    id.setCellValueFactory(new PropertyValueFactory<>(
                            "id"));
                   
                    TableColumn bloodtype = new TableColumn("BloodType");
                    bloodtype.setCellValueFactory(new PropertyValueFactory<>(
                            "bloodtype"));
                   
                    out.setItems(data);
                    out.getColumns().addAll(id, bloodtype);
                   
                    while(rs.next())
                    {
                        data.add(new Bloodtype(rs.getObject(1).toString(),
                                rs.getObject(2).toString()));
                    }
                    break;
                }
                case "donor":
                {
                    TableColumn id = new TableColumn("ID");
                    id.setCellValueFactory(new PropertyValueFactory<>(
                            "id"));
                   
                    TableColumn bloodtype = new TableColumn("BloodType");
                    bloodtype.setCellValueFactory(new PropertyValueFactory<>(
                            "bloodtype"));
                    
                    TableColumn lstDn = new TableColumn("Last Donation");
                    lstDn.setCellValueFactory(new PropertyValueFactory<>(
                            "lstDn"));
                   
                    TableColumn persInfo = 
                            new TableColumn("Personal Info");
                    persInfo.setCellValueFactory(new PropertyValueFactory<>(
                            "persInfo"));
                    
                    TableColumn dateStart =
                            new TableColumn("Starting Date");
                    dateStart.setCellValueFactory(new PropertyValueFactory<>(
                            "dateStart"));
                    
                    out.setItems(data);
                    out.getColumns().addAll(id, bloodtype, 
                            lstDn, persInfo, dateStart);
                   
                    while(rs.next())
                    {
                        data.add(new Donor(rs.getObject(1).toString(),
                                rs.getObject(2).toString(), 
                                rs.getObject(3).toString(), 
                                rs.getObject(4).toString(), 
                                rs.getObject(5).toString()));
                    }
                    break;
                }
                case "bloodbag":
                {
                    TableColumn id = new TableColumn("ID");
                    id.setCellValueFactory(new PropertyValueFactory<>(
                            "id"));
                   
                    TableColumn donor = new TableColumn("Donor");
                    donor.setCellValueFactory(new PropertyValueFactory<>(
                            "donor"));
                    
                    TableColumn retrDate = new TableColumn("Retrieval Date");
                    retrDate.setCellValueFactory(new PropertyValueFactory<>(
                            "retrDate"));
                    
                    out.setItems(data);
                    out.getColumns().addAll(id, donor, 
                            retrDate);
                   
                    while(rs.next())
                    {
                        data.add(new Bloodbag(rs.getObject(1).toString(),
                                rs.getObject(2).toString(), 
                                rs.getObject(3).toString()));
                    }
                    break;
                }
                case "bank":
                {
                    TableColumn id = new TableColumn("ID");
                    id.setCellValueFactory(new PropertyValueFactory<>(
                            "id"));
                   
                    TableColumn location = new TableColumn("Location");
                    location.setCellValueFactory(new PropertyValueFactory<>(
                            "location"));
                    
                    TableColumn openDate = new TableColumn("Opening Date");
                    openDate.setCellValueFactory(new PropertyValueFactory<>(
                            "openDate"));
                    
                    out.setItems(data);
                    out.getColumns().addAll(id, location, 
                            openDate);
                   
                    while(rs.next())
                    {
                        data.add(new Bank(rs.getObject(1).toString(),
                                rs.getObject(2).toString(), 
                                rs.getObject(3).toString()));
                    }
                    break;
                }
                case "inventory":
                {
                    TableColumn bloodbagId = new TableColumn("Bloodbag ID");
                    bloodbagId.setCellValueFactory(new PropertyValueFactory<>(
                            "bloodbagId"));
                   
                    TableColumn bankId = new TableColumn("Bank ID");
                    bankId.setCellValueFactory(new PropertyValueFactory<>(
                            "bankId"));
                    
                    out.setItems(data);
                    out.getColumns().addAll(bloodbagId, bankId);
                   
                    while(rs.next())
                    {
                        data.add(new Inventory(rs.getObject(1).toString(),
                                rs.getObject(2).toString()));
                    }
                    break;
                }
                case "vampire":
                {
                    TableColumn id = new TableColumn("ID");
                    id.setCellValueFactory(new PropertyValueFactory<>(
                            "id"));
                   
                    TableColumn fName = new TableColumn("First Name");
                    fName.setCellValueFactory(new PropertyValueFactory<>(
                            "fName"));
                    
                    TableColumn lName = new TableColumn("Last Name");
                    lName.setCellValueFactory(new PropertyValueFactory<>(
                            "lName"));
                    
                    out.setItems(data);
                    out.getColumns().addAll(id, fName, lName);
                   
                    while(rs.next())
                    {
                        data.add(new Vampire(rs.getObject(1).toString(),
                                rs.getObject(2).toString(), 
                                rs.getObject(3).toString()));
                    }
                    break;
                }
                case "vaccount":
                {
                    TableColumn id = new TableColumn("ID");
                    id.setCellValueFactory(new PropertyValueFactory<>(
                            "id"));
                   
                    TableColumn vampireId = new TableColumn("Vampire ID");
                    vampireId.setCellValueFactory(new PropertyValueFactory<>(
                            "vampireId"));
                    
                    TableColumn preference = new TableColumn("Preference");
                    preference.setCellValueFactory(new PropertyValueFactory<>(
                            "preference"));
                    
                    TableColumn allowance = new TableColumn("Allowance");
                    allowance.setCellValueFactory(new PropertyValueFactory<>(
                            "allowance"));
                    
                    TableColumn createDate = new TableColumn("Creation Date");
                    createDate.setCellValueFactory(new PropertyValueFactory<>(
                            "createDate"));
                    
                    out.setItems(data);
                    out.getColumns().addAll(id, vampireId, 
                            preference, allowance, 
                            createDate);
                   
                    while(rs.next())
                    {
                        String pref = rs.getString(3);
                        if(rs.getString(3) == null)
                            pref = "None";
                        data.add(new VAccount(rs.getObject(1).toString(), 
                                rs.getObject(2).toString(),
                                pref,
                                rs.getObject(4).toString(),
                                rs.getObject(5).toString()));
                    }
                    break;
                }
                case "transaction":
                {
                    TableColumn accountId = new TableColumn("Account ID");
                    accountId.setCellValueFactory(new PropertyValueFactory<>(
                            "accountId"));
                   
                    TableColumn bloodbagId = new TableColumn("Bloodbag ID");
                    bloodbagId.setCellValueFactory(new PropertyValueFactory<>(
                            "bloodbagId"));
                    
                    TableColumn date = new TableColumn("Date");
                    date.setCellValueFactory(new PropertyValueFactory<>(
                            "date"));

                    out.setItems(data);
                    out.getColumns().addAll(accountId, bloodbagId, 
                            date);
                   
                    while(rs.next())
                    {
                        data.add(new Transaction(rs.getObject(1).toString(),
                                rs.getObject(2).toString(), 
                                rs.getObject(3).toString()));
                    }
                    break;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Couldn't parse TableView");
        }
        return out;
    }
    /*public String (String str)
    {

    }*/
    public static class Bloodtype implements Table
    {
        private SimpleStringProperty id = null;
        private SimpleStringProperty bloodtype = null;
        
        public Bloodtype(String id, String bloodtype)
        {
            this.id = new SimpleStringProperty(id);
            this.bloodtype = new SimpleStringProperty(bloodtype);
        }
        public String getId()
        {
            return this.id.get();
        }
        public String getBloodtype()
        {
            return this.bloodtype.get();
        }
    }
    public static class Donor implements Table
    {
        private SimpleStringProperty id = null;
        private SimpleStringProperty bloodtype = null;
        private SimpleStringProperty lstDn = null;
        private SimpleStringProperty persInfo = null;
        private SimpleStringProperty dateStart = null;
        
        public Donor(String id, String bloodtype, String lstDn, String persInfo, String dateStart)
        {
            this.id = new SimpleStringProperty(id);
            this.bloodtype = new SimpleStringProperty(bloodtype);
            this.lstDn = new SimpleStringProperty(lstDn);
            this.persInfo = new SimpleStringProperty(persInfo);
            this.dateStart = new SimpleStringProperty(dateStart);
        }
        public String getId()
        {
            return this.id.get();
        }
        public String getBloodtype()
        {
            return this.bloodtype.get();
        }
        public String getLstDn()
        {
            return this.lstDn.get();
        }
        public String getPersInfo()
        {
            return this.persInfo.get();
        }
        public String getDateStart()
        {
            return this.dateStart.get();
        }
    }
    public static class Bloodbag implements Table
    {
        private SimpleStringProperty id = null;
        private SimpleStringProperty donor = null;
        private SimpleStringProperty retrDate = null;
        
        public Bloodbag(String id, String donor, String retrDate)
        {
            this.id = new SimpleStringProperty(id);
            this.donor = new SimpleStringProperty(donor);
            this.retrDate = new SimpleStringProperty(retrDate);
        }
        public String getId()
        {
            return this.id.get();
        }
        public String getDonor()
        {
            return this.donor.get();
        }
        public String getRetrDate()
        {
            return this.retrDate.get();
        }
    }
    public static class Bank implements Table
    {
        private SimpleStringProperty id = null;
        private SimpleStringProperty location = null;
        private SimpleStringProperty openDate = null;
        
        public Bank(String id, String location, String openDate)
        {
            this.id = new SimpleStringProperty(id);
            this.location = new SimpleStringProperty(location);
            this.openDate = new SimpleStringProperty(openDate);
        }
        public String getId()
        {
            return this.id.get();
        }
        public String getLocation()
        {
            return this.location.get();
        }
        public String getOpenDate()
        {
            return this.openDate.get();
        }
    }
    public static class Inventory implements Table
    {
        private SimpleStringProperty bloodbagId = null;
        private SimpleStringProperty bankId = null;
        
        public Inventory(String bloodbagId, String bankId)
        {
            this.bloodbagId = new SimpleStringProperty(bloodbagId);
            this.bankId = new SimpleStringProperty(bankId);
        }
        public String getBloodbagId()
        {
            return this.bloodbagId.get();
        }
        public String getBankId()
        {
            return this.bankId.get();
        }
    }
    public static class Vampire implements Table
    {
        private SimpleStringProperty id = null;
        private SimpleStringProperty fName = null;
        private SimpleStringProperty lName = null;
        
        public Vampire(String id, String fName, String lName)
        {
            this.id = new SimpleStringProperty(id);
            this.fName = new SimpleStringProperty(fName);
            this.lName = new SimpleStringProperty(lName);
        }
        public String getId()
        {
            return this.id.get();
        }
        public String getFName()
        {
            return this.fName.get();
        }
        public String getLName()
        {
            return this.lName.get();
        }
    }
    public static class VAccount implements Table
    {
        private SimpleStringProperty id = null;
        private SimpleStringProperty vampireId = null;
        private SimpleStringProperty preference = null;
        private SimpleStringProperty allowance = null;
        private SimpleStringProperty createDate = null;
        
        public VAccount(String id, String vampireId, String preference, 
                String allowance, String createDate)
        {
            this.id = new SimpleStringProperty(id);
            this.vampireId = new SimpleStringProperty(vampireId);
            this.preference = new SimpleStringProperty(preference);
            this.allowance = new SimpleStringProperty(allowance);
            this.createDate = new SimpleStringProperty(createDate);
        }
        public String getId()
        {
            return this.id.get();
        }
        public String getVampireId()
        {
            return this.vampireId.get();
        }
        public String getPreference()
        {
            return this.preference.get();
        }
        public String getAllowance()
        {
            return this.allowance.get();
        }
        public String getCreateDate()
        {
            return this.createDate.get();
        }
    }
    public static class Transaction implements Table
    {
        private SimpleStringProperty accountId = null;
        private SimpleStringProperty bloodbagId = null;
        private SimpleStringProperty date = null;
        
        public Transaction(String accountId, String bloodbagId, String date)
        {
            this.accountId = new SimpleStringProperty(accountId);
            this.bloodbagId = new SimpleStringProperty(bloodbagId);
            this.date = new SimpleStringProperty(date);
        }
        public String getAccountId()
        {
            return this.accountId.get();
        }
        public String getBloodbagId()
        {
            return this.bloodbagId.get();
        }
        public String getDate()
        {
            return this.date.get();
        }
    }
    public static interface Table
    {
    }
}
