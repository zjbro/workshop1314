package sg.edu.nus.iss.visaWorkshop1314.Service;

import java.util.List;

import sg.edu.nus.iss.visaWorkshop1314.Model.Contact;

public interface ContactInterface {
    public void save(Contact contact);

    public List<Contact> findAll();

    public Contact findById(String uniqueId);
}
    
