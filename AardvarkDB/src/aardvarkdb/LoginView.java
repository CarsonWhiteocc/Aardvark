/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aardvarkdb;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginView 
{
    Stage stg;
    public LoginView(Stage s)
    {
        stg = s;

        Button admin = new Button("Admin");
        Button cus = new Button("Customer");
        Button emp = new Button("Employee");
        
        GridPane gp = new GridPane();
        
        gp.addRow(0, admin);
        gp.addRow(1, cus);
        gp.addRow(2, emp);
        
        Scene sc = new Scene(gp);
        admin.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent arg0) 
            {   
                stg.close();
                AdminView av = new AdminView(stg);
            }
        });
        cus.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent arg0) 
            {   
                stg.close();
                CustomerView cv = new CustomerView(stg);
            }
        });
        emp.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent arg0) 
            {   
                stg.close();
                EmployeeView ev = new EmployeeView(stg);
            }
        });
        stg.setScene(sc);
        stg.show();
    }
}
