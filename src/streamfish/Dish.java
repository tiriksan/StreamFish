package streamfish;

import java.util.ArrayList;

/**
 * @author Sindre
 */
public class Dish {
        
        private String name;
        private String dishID;
        
        public Dish(String name, String desc){
            this.name = name;
        }
        public Dish(String dishID, String name, String desc, ArrayList<Ingredient> ing){
            this.dishID = dishID;
            this.name = name;
        }
        public String getName(){
            return name;
        }
        public void setName(String newName){
            name = newName;
        }
        public String getID(){
            return dishID;
        }
        public void setID(String newID){
            dishID = newID;
        }  
}
