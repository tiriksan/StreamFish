package streamfish;

import java.util.ArrayList;

/**
 * @author Sindre
 */
public class Dish {
        
        private String name;
        private int dishID;
		private int price;
        
        public Dish(String name){
            this.name = name;
        }
        public Dish(String name, int dishID){
            this.name = name;
            this.dishID = dishID;
        }
		public Dish(String name, int dishID, int price){
            this.name = name;
            this.dishID = dishID;
			this.price = price;
        }
        public Dish(int dishID, String name, String desc, ArrayList<Ingredient> ing){
            this.dishID = dishID;
            this.name = name;
        }
        public String getName(){
            return name;
        }
        public void setName(String newName){
            name = newName;
        }
        public int getID(){
            return dishID;
        }
        public void setID(int newID){
            dishID = newID;
        }  
		public int getPrice(){
			return price;
		}
		
		@Override
		public String toString(){
			String res = "";
			res += "ID: " + dishID + ", name: " + name + ", price:" + price;
			return res;
		}
}