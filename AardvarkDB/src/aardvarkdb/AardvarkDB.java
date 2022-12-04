/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aardvarkdb;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

public class AardvarkDB extends Application
{
    @Override
    public void start(Stage s)
    {
        LoginView lv = new LoginView(s);
    }
    public static void main(String[] args)
    {
        launch(args);
    }
}
