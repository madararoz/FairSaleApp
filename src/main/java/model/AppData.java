package model;

import javafx.scene.control.DatePicker;

public class AppData {

        private static model.AppData appData_instance;
        private String comboBoxValue = null;
        private DatePicker orderDate;

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

        public void setOrderDate(DatePicker orderDate) {
            this.orderDate = orderDate;
    }
}
