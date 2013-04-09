package streamfish;

import java.util.ArrayList;

/**
 * @author Sindre
 */
public class Dish {
        
        private String name;
        private String description;
        private String dishID;
        
        public Dish(String name, String desc){
            this.name = name;
            this.description = desc;
        }
        public Dish(String dishID, String name, String desc, ArrayList<Ingredient> ing){
            this.dishID = dishID;
            this.name = name;
            this.description = desc;
        }
        public String getName(){
            return name;
        }
        public void setName(String newName){
            name = newName;
        }
        public String getDescription(){
            return description;
        }
        public void setDescription(String desc){
            description = desc;
        }     
}
