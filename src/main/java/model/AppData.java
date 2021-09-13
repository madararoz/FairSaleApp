package model;

import javafx.scene.control.DatePicker;

public class AppData {

        private static model.AppData appData_instance;
        private String comboBoxValue = null;
        private String orderDate = null;
        private String soldDate = null;

    AppData(){
        }

        public static AppData getInstance() {
            if(appData_instance == null) appData_instance = new AppData();
            return appData_instance;
        }


    public String getComboBoxValue() {

        return comboBoxValue;
    }

    public void setComboBoxValue(String comboBoxValue) {
       this.comboBoxValue= comboBoxValue;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setSoldDate(String soldDate) {
        this.soldDate = soldDate;
    }

    public String getSoldDate() {
            return soldDate;
        }

}

