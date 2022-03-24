package sg.edu.nus.iss.visaWorkshop1314.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.nus.iss.visaWorkshop1314.Model.Contact;
import sg.edu.nus.iss.visaWorkshop1314.Service.ContactInterface;

@Controller
@RequestMapping("/")


public class AddressBookController {

    @Autowired
    ContactInterface cService;

    @RequestMapping("/")
    public String landingPage(Model model) {
        Contact contact = new Contact();
        model.addAttribute("contact",contact);
        return "index";
    }

    @RequestMapping("/save")
    public String saveContact(@ModelAttribute("contact") Contact contact, Model model){
        Contact c1 = new Contact(contact.getName(), contact.getEmail(), contact.getPhoneNumber());
        cService.save(c1);
        List<Contact> allContact = cService.findAll();
        model.addAttribute("allContact", allContact);        
        return "success";
    }

    @RequestMapping("/search")
    public String searchContact(@RequestParam(value = "id", required = false) String uniqueId, Model model){
        Contact contact = cService.findById(uniqueId);
        String error = "";
        model.addAttribute("contact", contact);
        if(contact == null) {
            error = "User not found!";
        }
        model.addAttribute("error", error);
        return "searchResult";

    }

}
