package com.bemarzprj.controller;

import com.bemarzprj.exception.ExceptionMassages;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainWindowController
{
    CustomerController customerController;
    @FXML
    private Label welcomeText;

    @FXML
    protected void getCustomerById() throws ExceptionMassages
    {
        customerController.getAll();
    }
}