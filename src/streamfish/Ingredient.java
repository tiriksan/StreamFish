package streamfish;

/**
 * @author Sindre
 */
public class Ingredient {
        
        private String ingredientID;
        private String name;
        private double amount;
        private String expiryDate;
        
        public Ingredient(String ingID, String name, double amount, String expiryDate){
            this.ingredientID = ingID;
            this.name = name;
            this.amount = amount;
            this.expiryDate = expiryDate;
        }
        public String getID(){
            return ingredientID;
        }
        public void setID(String newID){
            ingredientID = newID;
        }
        public String getName(){
            return name;
        }
        public void setName(String newName){
            name = newName;
        }
        public String getExpDate(){
            return expiryDate;
        }
        public void setExpDate(String newDate){
            expiryDate = newDate;
        }
        public double getAmount(){
            return amount;
        }
        public void setAmount(double newAmount){
            amount = newAmount;
        }
}

