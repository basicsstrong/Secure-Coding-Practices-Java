package com.basicsstrong.securecoding;

public class AccessControl {
    public static void main(String[] args) {
        
    	System.out.println(viewProfile(12, new User(13, "Ron", 25, true)));
    
    }

    
    
    public static String viewProfile(int userId, User requestingUser) {
    	if( requestingUser.isAdmin() || requestingUser.getId() == userId) {
        User profile = fetchProfileFromDatabase(userId);

        if (profile != null) {
            return profile.toString();
        } else {
            return "Profile not found.";
        }
        }else {
        	return "User is not authorized";
        }
    }

    
    
    public static User fetchProfileFromDatabase(int userId) {
        return new User(userId, "John", 45, false);
    }
}



class User {
    private int id;
    private String name;
    private int age;
    private boolean isAdmin;

    public User(int id, String name, int age, boolean isAdmin) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.isAdmin = isAdmin;
    }
    
    

    public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public boolean isAdmin() {
		return isAdmin;
	}



	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}



	@Override
    public String toString() {
        return String.format("User(id=%d, name=%s, age=%d, is_admin=%b)", id, name, age, isAdmin);
    }
}

