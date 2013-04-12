package streamfish;

/**
 * @author Sindre
 */
public class Ingredient {
        
        private int ingredientID;
        private String name;
        private int amount;
        private String expiryDate;
        
        public Ingredient(int ingID, String name, int amount, String expiryDate){
            this.ingredientID = ingID;
            this.name = name;
            this.amount = amount;
            this.expiryDate = expiryDate;
        }
        
        public Ingredient(String name, int amount, String expiryDate) {
            this.name = name;
            this.amount = amount;
            this.expiryDate = expiryDate;
        } 
                
        public int getID(){
            return ingredientID;
        }
        
        public void setID(int newID){
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
        
        public int getAmount(){
            return amount;
        }
        
        public void setAmount(int newAmount){
            amount = newAmount;
        }
}

