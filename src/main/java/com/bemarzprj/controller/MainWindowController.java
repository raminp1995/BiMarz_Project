package com.bemarzprj.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainWindowController
{
    CustomerController customerController;
    @FXML
    private Label welcomeText;

    @FXML
    protected void getCustomerById() {
        customerController.getAll();
    }
}