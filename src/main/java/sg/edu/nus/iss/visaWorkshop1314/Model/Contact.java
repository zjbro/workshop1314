package sg.edu.nus.iss.visaWorkshop1314.Model;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Contact")
public class Contact implements Serializable{
    private String name;
    private String email;
    private String phoneNumber;
    private String id;

    public Contact(String name, String email, String phoneNumber){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.id = setUniqueId();
        
    }

    public Contact(){}

    public String setUniqueId(){
        String uniqueId = UUID.randomUUID().toString();
        return uniqueId.substring(0,8);
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    
    
}
