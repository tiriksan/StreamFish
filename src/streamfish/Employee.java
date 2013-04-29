package streamfish;

class Employee {
    private int empl_ID;
    private byte usertype;
    private String username;
    private String password;
    public Employee(byte usertype, String username, String password) {
        if (username == null || password == null || username.equals("") || password.equals("")) {
            throw new IllegalArgumentException("Employee username and password "
                    + "cannot be empty");
        }
        if (username.length() > 30 || password.length() > 40 || password.length() < 4) {
            throw new IllegalArgumentException("Employee username cannot exceed "
                    + "30 letters. Password is not allowed to be less than 13 digits, and no more than 40");
        }
        if (usertype < 0) {
            this.usertype = 0;
        } else {
            this.usertype = usertype;
        }
        this.username = username;
        this.password = password;
    }
    
    public Employee(int empl_ID, byte usertype, String username, String password) {
        this.empl_ID = empl_ID;
        this.usertype = usertype;
        this.username = username;
        this.password = password;
    }
    public int getEmplID(){
        return empl_ID;
    }
    
    public byte getUsertype() {
        return usertype;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public boolean okUsername(String usernameIn) {
        return username.equals(usernameIn);
    }
    
    public boolean okPassword(String passwordIn) {
        return password.equals(passwordIn);
    }
    
    public boolean login(String username, String password) {
        if (okUsername(username) && okPassword(password)) {
            return true;
        }
        return false;
    }

    public boolean changePassword(String oldPass, String newPass) {
        if (oldPass == null || newPass == null) {
            return false;
        }
        if (!password.equalsIgnoreCase(oldPass.trim()) && newPass.length() < 20) {
           return false;
        } else {
           password = newPass.trim();
           return true;
        }
    }
    
    public boolean changeUsername(String newUsername) {
        if (username.trim().equalsIgnoreCase(newUsername) || newUsername == null
                || newUsername.trim().equals("") || newUsername.length() > 30) {
            return false;
        }
        username = newUsername;
        return  true;
    }
    
    public String toString() {
        String utskrift = "Username: " + getUsername() + "\nUsertype: " + getUsertype() + "\nEmpl_ID: " + getEmplID();
        return utskrift;
    }
}
