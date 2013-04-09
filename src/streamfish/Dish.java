package streamfish;

import java.util.ArrayList;

/**
 * @author Sindre
 */
public class Dish {
        
        private String name;
        private String description;
        private String dishID;
        private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
        
        public Dish(String name, String desc, ArrayList<Ingredient> ing){
            this.name = name;
            this.description = desc;
            this.ingredients = ing;
        }
        public Dish(String dishID, String name, String desc, ArrayList<Ingredient> ing){
            this.dishID = dishID;
            this.name = name;
            this.description = desc;
            this.ingredients = ing;
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
        public ArrayList<Ingredient> getIngredients(){
            return ingredients;
        }
        public void addIngredient(Ingredient ing){
            ingredients.add(ing);
        }
        public void removeIngredient(Ingredient ing){
            ingredients.remove(ing);
        }
        public Ingredient findIngredient(String name){ //find ingridient by name
            
            for(Ingredient aIngredient : ingredients){
                if(aIngredient.getName().equals(name)){
                    return aIngredient;
                }
            }
            
            return null;
        }
        
}
