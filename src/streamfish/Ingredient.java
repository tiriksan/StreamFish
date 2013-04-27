package streamfish;

/**
 * @author Sindre
 */
public class Ingredient {
        
        private int ingredientID;
        private String name;
        private int amount;
        private String expiryDate;
		private String unit;
        
        public Ingredient(int ingID, String name, int amount, String expiryDate, String unit){
            this.ingredientID = ingID;
            this.name = name;
            this.amount = amount;
            this.expiryDate = expiryDate;
			this.unit = unit;
        }
        
        public Ingredient(String name, int amount, String expiryDate, String unit) {
            this.name = name;
            this.amount = amount;
            this.expiryDate = expiryDate;
			this.unit = unit;
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
		public String getUnit() {
			return unit;
		}
        
        public int getAmount(){
            return amount;
        }
        
        public void setAmount(int newAmount){
            amount = newAmount;
        }
		
		@Override
		public String toString(){
			String res = "";
			res += "Ingredient ID: " + ingredientID + ", Name: " + name + ", Expiry date: " + expiryDate + ", Amount: " + amount;
			return res;
		}

	
}

