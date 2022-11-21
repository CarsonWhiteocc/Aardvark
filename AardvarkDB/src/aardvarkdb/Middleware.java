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
        TableColumn[] columns = {null, null, null, null, null};
        String[] in = {null, null, null, null, null};
       
        try
        {
            switch(rs.getMetaData().getTableName(1).toLowerCase())
            {
                case "inventory":
                case "bloodtype":
                    for(int i = 0; i < rs.getMetaData().getColumnCount(); i++)
                    {
                        columns[i] = new TableColumn(convert(rs.getMetaData().getColumnName(i + 1))); 
                    }
                    columns[0].setCellValueFactory(new PropertyValueFactory<>(
                            "placeZero"));
                    columns[1].setCellValueFactory(new PropertyValueFactory<>(
                            "placeOne"));
                    
                    out.setItems(data);
                    out.getColumns().addAll(columns[0], columns[1]);
                    while(rs.next())
                    {
                        for(int i = 0; i < rs.getMetaData().getColumnCount(); i++)
                        {
                            if(rs.getObject(i + 1) == null)
                                in[i] = "None";
                            else
                                in[i] = testNull(rs.getObject(i + 1).toString());
                        }
                        data.add(new Table(in));
                    }
                    break;
                case "donor":
                case "vaccount":
                    for(int i = 0; i < rs.getMetaData().getColumnCount(); i++)
                    {
                        columns[i] = new TableColumn(convert(rs.getMetaData().getColumnName(i + 1))); 
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
                    out.getColumns().addAll(columns[0], columns[1], columns[2], columns[3], columns[4]);
                    while(rs.next())
                    {
                        for(int i = 0; i < rs.getMetaData().getColumnCount(); i++)
                        {
                            if(rs.getObject(i + 1) == null)
                                in[i] = "None";
                            else
                                in[i] = testNull(rs.getObject(i + 1).toString());
                        }
                        data.add(new Table(in));
                    }
                    break;
                case "bank":
                case "transaction":
                case "bloodbag":
                case "vampire":
                    for(int i = 0; i < rs.getMetaData().getColumnCount(); i++)
                    {
                        columns[i] = new TableColumn(convert(rs.getMetaData().getColumnName(i + 1))); 
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
                        for(int i = 0; i < rs.getMetaData().getColumnCount(); i++)
                        {
                            if(rs.getObject(i + 1) == null)
                                in[i] = "None";
                            else
                                in[i] = testNull(rs.getObject(i + 1).toString());
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

        public Table(String[] cols)
        {
            this.placeZero = new SimpleStringProperty(cols[0]);
            this.placeOne = new SimpleStringProperty(cols[1]);
            this.placeTwo = new SimpleStringProperty(cols[2]);
            this.placeThree = new SimpleStringProperty(cols[3]);
            this.placeFour = new SimpleStringProperty(cols[4]);
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
}
