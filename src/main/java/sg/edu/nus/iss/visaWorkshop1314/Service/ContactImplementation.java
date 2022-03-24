package sg.edu.nus.iss.visaWorkshop1314.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.visaWorkshop1314.Model.Contact;

@Service
public class ContactImplementation implements ContactInterface{

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @Override
    public void save(Contact contact) {
        // TODO Auto-generated method stub
        String CONTACT_ENTITY = "contact";
        redisTemplate.opsForList().leftPush(CONTACT_ENTITY, contact.getId());
        redisTemplate.opsForHash().put(CONTACT_ENTITY + "_Map", contact.getId(), contact);
    
        
    }

    @Override
    public List<Contact> findAll() {
        // TODO Auto-generated method stub
        var key = "contact_Map";
        var result = (List<Contact>)(Object)redisTemplate.opsForHash().values(key); 
        // casting type, telling program that the keys from redisTemplate is casted as an object in the list of contacts
        return result;
    }
    
    @Override   
    public Contact findById(String uniqueId){
        Contact result = (Contact)redisTemplate.opsForHash().get("contact" + "_Map", uniqueId);
        return result;
        
    }
    
}
