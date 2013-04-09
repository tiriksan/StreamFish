package streamfish;

/**
 * @author Sindre
 */
public class Ingredient {
        
        private String name;
        private String description;
        
        public Ingredient(String name, String desc){
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

