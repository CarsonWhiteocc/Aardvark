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
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 

public class Middleware 
{
    private static final Backend be = new Backend();
    private ObservableList<Table> data = 
            FXCollections.observableArrayList();

            
    public Middleware()
    {
    }
    public TableView viewTable(String tableName)
    {
        String query = "Select * from " + tableName;
        query = query.toUpperCase();
        ResultSet rs = be.handleQuery(query);
        return createTable(rs);
    }
    public TableView viewHistory(String accountId)
    {
        String query = "Select * from Transaction where Account_id = " + 
                accountId + " order by TDate";
        query = query.toUpperCase();
        ResultSet rs = be.handleQuery(query);
        return createTable(rs);
    }
    public TableView account(String accountId)
    {
        String query = "Select * from viewAccount where id_Account = " + 
                accountId;
        query = query.toUpperCase();
        ResultSet rs = be.handleQuery(query);
        return createTable(rs);
    }
    public String findAccount(String accountId)
    {
        String query = "Select * from VAccount where id_Account = " + accountId;
        query = query.toUpperCase();
        ResultSet rs = be.handleQuery(query);
        try
        { 
            rs.next();
            if(rs.getObject(1) != null)
            {
                if(rs.getObject(5) == null)
                {
                    return "None";
                }
                else
                {
                    return rs.getObject(5).toString();
                }
            }
            else
                return null;
        }
        catch(Exception e)
        {
            System.out.println("Could not find account without error");
            return null;
        }
    }
    public int findAllowance(String accId)
    {
        String query = "Select * from VAccount where id_Account = " + accId;
        query = query.toUpperCase();
        ResultSet rs = be.handleQuery(query);
        try
        {
            rs.next();
            return rs.getInt(4);
        }
        catch(Exception e)
        {
            System.out.println("Could not get allowance");
            return 0;
        }
    }
    public static String testNull(String s)
    {
        if(s == null)
        {
            s = "None";
        }
        return s;
    }
    public TableView createTable(ResultSet rs)
    {
        TableView out = new TableView();
        TableColumn[] columns = {null, null, null, null, null, null};
        String[] in = {null, null, null, null, null, null};
       
        try
        {
            switch(rs.getMetaData().getColumnCount())
            {
                case 2:
                    for(int i = 0; i < rs.getMetaData().getColumnCount(); i++)
                    {
                        columns[i] = new TableColumn(convert(
                                rs.getMetaData().getColumnName(i + 1))); 
                    }
                    columns[0].setCellValueFactory(new PropertyValueFactory<>(
                            "placeZero"));
                    columns[1].setCellValueFactory(new PropertyValueFactory<>(
                            "placeOne"));
                    
                    out.setItems(data);
                    out.getColumns().addAll(columns[0], columns[1]);
                    while(rs.next())
                    {
                        for(int i = 0; i < rs.getMetaData().getColumnCount(); 
                                i++)
                        {
                            if(rs.getObject(i + 1) == null)
                                in[i] = "None";
                            else
                                in[i] = testNull(
                                        rs.getObject(i + 1).toString());
                        }
                        data.add(new Table(in));
                    }
                    break;
                case 5:
                    for(int i = 0; i < rs.getMetaData().getColumnCount(); i++)
                    {
                        columns[i] = new TableColumn(convert(
                                rs.getMetaData().getColumnName(i + 1))); 
                    }
                    columns[0].setCellValueFactory(new PropertyValueFactory<>(
                            "placeZero"));
                    columns[1].setCellValueFactory(new PropertyValueFactory<>(
                            "placeOne"));
                    columns[2].setCellValueFactory(new PropertyValueFactory<>(
                            "placeTwo"));
                    columns[3].setCellValueFactory(new PropertyValueFactory<>(
                            "placeThree"));
                    columns[4].setCellValueFactory(new PropertyValueFactory<>(
                            "placeFour"));
                    
                    out.setItems(data);
                    out.getColumns().addAll(columns[0], columns[1], columns[2], 
                            columns[3], columns[4]);
                    while(rs.next())
                    {
                        for(int i = 0; i < rs.getMetaData().getColumnCount(); 
                                i++)
                        {
                            if(rs.getObject(i + 1) == null)
                                in[i] = "None";
                            else
                                in[i] = testNull(
                                        rs.getObject(i + 1).toString());
                        }
                        data.add(new Table(in));
                    }
                    break;
                case 3:
                    for(int i = 0; i < rs.getMetaData().getColumnCount(); i++)
                    {
                        columns[i] = new TableColumn(convert(
                                rs.getMetaData().getColumnName(i + 1))); 
                    }
                    columns[0].setCellValueFactory(new PropertyValueFactory<>(
                            "placeZero"));
                    columns[1].setCellValueFactory(new PropertyValueFactory<>(
                            "placeOne"));
                    columns[2].setCellValueFactory(new PropertyValueFactory<>(
                            "placeTwo"));
                    
                    out.setItems(data);
                    out.getColumns().addAll(columns[0], columns[1], columns[2]);
                    while(rs.next())
                    {
                        for(int i = 0; i < rs.getMetaData().getColumnCount(); 
                                i++)
                        {
                            if(rs.getObject(i + 1) == null)
                                in[i] = "None";
                            else
                                in[i] = testNull(
                                        rs.getObject(i + 1).toString());
                        }
                        data.add(new Table(in));
                    }
                    break;
                case 6:
                    for(int i = 0; i < rs.getMetaData().getColumnCount(); i++)
                    {
                        columns[i] = new TableColumn(convert(
                                rs.getMetaData().getColumnName(i + 1))); 
                    }
                    columns[0].setCellValueFactory(new PropertyValueFactory<>(
                            "placeZero"));
                    columns[1].setCellValueFactory(new PropertyValueFactory<>(
                            "placeOne"));
                    columns[2].setCellValueFactory(new PropertyValueFactory<>(
                            "placeTwo"));
                    columns[3].setCellValueFactory(new PropertyValueFactory<>(
                            "placeThree"));
                    columns[4].setCellValueFactory(new PropertyValueFactory<>(
                            "placeFour"));
                    columns[5].setCellValueFactory(new PropertyValueFactory<>(
                            "placeFive"));
                    
                    out.setItems(data);
                    out.getColumns().addAll(columns[0], columns[1], columns[2], 
                            columns[3], columns[4], columns[5]);
                    while(rs.next())
                    {
                        for(int i = 0; i < rs.getMetaData().getColumnCount(); 
                                i++)
                        {
                            if(rs.getObject(i + 1) == null)
                                in[i] = "None";
                            else
                                in[i] = testNull(
                                        rs.getObject(i + 1).toString());
                        }
                        data.add(new Table(in));
                    }
                    break;
            }
        }
        catch(Exception e)
        {
            System.out.println("Couldn't parse TableView");
        }
        return out;
    }
    public static class Table
    {
        private SimpleStringProperty placeZero;
        private SimpleStringProperty placeOne;
        private SimpleStringProperty placeTwo;
        private SimpleStringProperty placeThree;
        private SimpleStringProperty placeFour;
        private SimpleStringProperty placeFive;

        public Table(String[] cols)
        {
            this.placeZero = new SimpleStringProperty(cols[0]);
            this.placeOne = new SimpleStringProperty(cols[1]);
            this.placeTwo = new SimpleStringProperty(cols[2]);
            this.placeThree = new SimpleStringProperty(cols[3]);
            this.placeFour = new SimpleStringProperty(cols[4]);
            this.placeFive = new SimpleStringProperty(cols[5]);
        }
        public String getPlaceZero()
        {
            return placeZero.get();
        }
        public String getPlaceOne()
        {
            return placeOne.get();
        }
        public String getPlaceTwo()
        {
            return placeTwo.get();
        }
        public String getPlaceThree()
        {
            return placeThree.get();
        }
        public String getPlaceFour()
        {
            return placeFour.get();
        }
        public String getPlaceFive()
        {
            return placeFive.get();
        }
    }
    public static String convert(String s)
    {
        switch(s)
        {
            case "id_Vampire":
            case "id_Account":
            case "id_Donor":
            case "id_Bloodtype":
            case "id_BloodBag":
            case "id_Bank":
                s = "ID";
                break;
            case "Open_Date":
                s = "Opening Date";
                break;
            case "Donor_Id":
                s = "Donor ID";
                break;
            case "Retr_Date":
                s = "Retrieval Date";
                break;
            case "bType":
                s = "Bloodtype";
                break;
            case "Bloodtype_id":
                s = "Bloodtype ID";
                break;
            case "Lst_Donation":
                s = "Last Donation";
                break;
            case "Pers_Info":
                s = "Personal Info";
                break;
            case "Date_Start":
                s = "Starting Date";
                break;
            case "Bloodbag_id":
                s = "Bloodbag ID";
                break;
            case "Bank_id":
                s = "Bank ID";
                break;
            case "Account_id":
                s = "Account ID";
                break;
            case "TDate":
                s = "Transaction Date";
                break;
            case "Vampire_id":
                s = "Vampire ID";
                break;
            case "preference":
                s = "Preference";
                break;
            case "allowance":
                s = "Allowance";
                break;
            case "Create_Date":
                s = "Creation Date";
                break;
            case "FName":
                s = "First Name";
                break;
            case "LName":
                s = "Last Name";
                break;
        }
        return s;
    }   
    public void addBank(String location)
    {
        String queries[] = {"Insert into Bank(Location) values('" + location + 
                "')"};
        be.updateQuery(queries);
    }
    public void addAccount(String vampId, String allo, String pref)
    {
        if(pref.equals("") || pref.equals("Enter Bloodtype ID "
                + "Preference Here (Optional)"))
        {
            pref = null;
        }
        String date = this.getDateSql();
        String queries[] = {"insert into VAccount (Vampire_id, allowance, "
                + "preference, Create_Date) values (" + vampId + ", " + allo + 
                ", " + pref + ", '" + date + "')"};
        be.updateQuery(queries);
    }
    public void addDonor(String bTypeID, String persInfo)
    { 
        String date = this.getDateSql();
        String queries[] = {"Insert into Donor(Bloodtype_id, Pers_Info, "
                + "Date_Start) values(" + bTypeID + ", '" + persInfo + "', '" + 
                date + "')"};
        be.updateQuery(queries);
    }
    public void addBloodbag(String donorId, String bankId)
    {
        ResultSet rs = be.handleQuery("select max(id_Bloodbag) from "
                + "Bloodbag");
        String maxBagId;
        try
        {   
            rs.next();
            maxBagId = rs.getObject(1).toString();
        }
        catch (Exception e)
        {
            System.out.println("Could not process addition");
            return;
        }
        maxBagId = "" + (Integer.parseInt(maxBagId) + 1);
        String date = this.getDateSql();
        String[] queries = {"Update Donor set Lst_Donation = '" + date + "' "
                + "where id_donor = " + donorId, "Insert into "
                + "Bloodbag(id_Bloodbag, Donor_id, Retr_Date) values(" + 
                maxBagId + ", " + donorId + ", '" + date +"')", "Insert into "
                + "Inventory(Bloodbag_id, Bank_id) values(" + maxBagId + ", " + 
                bankId + ")"};
        be.updateQuery(queries);
    }
    public void openBank(String bankId)
    {
        String date = this.getDateSql();
        String[] queries = {"update Bank set Open_Date = '" + date + "' where " 
                + bankId + " = 10"};
        be.updateQuery(queries);
    }
    public void changePreference(String prefId, String accId)
    {
        if(prefId.length() != 1)
        {
            prefId = "null";
        }
        String[] queries = {"update VAccount set preference = " + prefId + " "
                + "where id_account = " + accId};
        be.updateQuery(queries);
    }
    public void makeTransaction(String accId, String bBagId)
    {
        String date = this.getDateSql();
        String[] queries = {"update VAccount set allowance = allowance - 1 "
                + "where id_account = " + accId, "delete from Inventory where "
                + "Bloodbag_id = " + bBagId, "Insert into "
                + "Transaction(Bloodbag_id, Account_id, TDate) values(" + 
                bBagId + ", " + accId + ", '" + date + "')"};
        be.updateQuery(queries);
    }
    public String getDateSql()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        LocalDateTime now = LocalDateTime.now();  
        String date = dtf.format(now); 
        return date;
    }
}
