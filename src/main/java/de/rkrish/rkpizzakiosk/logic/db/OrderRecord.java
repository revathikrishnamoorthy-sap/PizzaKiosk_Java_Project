package de.rkrish.rkpizzakiosk.logic.db;

public class OrderRecord {
        private int id;
        private String customerName;
        private String customerNumber;
        private int totalPrice;

        public OrderRecord(int id, String customerName, String customerNumber, int totalPrice) {
            this.id = id;
            this.customerName = customerName;
            this.customerNumber = customerNumber;
            this.totalPrice = totalPrice;
        }

        public OrderRecord(String customerName, String customerNumber, int totalPrice) {
            this.customerName = customerName;
            this.customerNumber = customerNumber;
            this.totalPrice = totalPrice;
        }

        public int getId() {
            return id;
        }

        public String getCustomerName() {
            return customerName;
        }

        public String getCustomerNumber() {
            return customerNumber;
        }

        public int getTotalPrice() {
            return totalPrice;
        }

    @Override
    public String toString() {
        return "OrderRecord{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", customerNumber='" + customerNumber + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}


