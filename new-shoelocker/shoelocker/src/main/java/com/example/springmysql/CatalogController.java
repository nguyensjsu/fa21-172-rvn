package com.example.springmysql;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import java.util.Optional;
import java.time.*; 
import java.util.*;
import lombok.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64.Encoder;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import lombok.extern.slf4j.Slf4j;
import java.util.Map;


/**
 * Controller for requests to the {@code /profile} resource. Populates the model
 * with the claims from the
 * {@linkplain OidcUser} for use by the view.
 */
@Slf4j
@Controller
@RequestMapping("/catalog")
public class CatalogController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Getter
    @Setter
    class Message {
        private String msg;
        public Message(String m) { msg = m; }
    }

    class ErrorMessages {
        private ArrayList<Message> messages = new ArrayList<Message>();
        public void add(String msg) { messages.add(new Message(msg)); }
        public ArrayList<Message> getMessages() { return messages; }
        public void print() {
            for(Message m : messages) {
                System.out.println( m.msg );
            }
        }
    }

    @Autowired
	private CatalogCommandRepository catalogRepo;

    @GetMapping
    public String getAction( @ModelAttribute("catalog") Catalog catalog, Model model) {
    	return "catalog" ;
    }

    @PostMapping
    public String postAction(@Valid @ModelAttribute("catalog") Catalog catalog, Errors errors, Model model, RedirectAttributes redirectAttrs) {
        ErrorMessages msgs = new ErrorMessages();

        // Ensure that inputs only recieve numbers
        if (!catalog.shoe1().matches("[0-9]+")) {
            msgs.add("Nike Green Shoe - Invalid Input");
        }
        if (!catalog.shoe2().matches("[0-9]+")) {
            msgs.add("Orange Shoe - Invalid Input");
        }
        if (!catalog.shoe3().matches("[0-9]+")) {
            msgs.add("Sport Shoe - Invalid Input");
        }

        // If no items are added do not move to the payment page
        if (catalog.shoe1().equals("0") && catalog.shoe2().equals("0") && catalog.shoe3().equals("0")) {
            msgs.add("No Shoe were added!");
            return "redirect:creditcards";
        }

        // If error is found do not redirect to payment
        if (msgs.messages.size() > 0) {
            msgs.print();
    		model.addAttribute("messages", msgs.getMessages());
            return "catalog";
        }

        // Each Item Count
        redirectAttrs.addFlashAttribute("shoe1Count", catalog.shoe1());
        redirectAttrs.addFlashAttribute("shoe2Count", catalog.shoe2());
        redirectAttrs.addFlashAttribute("shoe3Count", catalog.shoe3());

        // Each Item Total Price
        redirectAttrs.addFlashAttribute("shoe1Cost", catalog.individualCost("shoe1", catalog.shoe1()));
        redirectAttrs.addFlashAttribute("shoe2Cost", catalog.individualCost("shoe2", catalog.shoe2()));
        redirectAttrs.addFlashAttribute("shoe3Cost", catalog.individualCost("shoe3", catalog.shoe3()));
        redirectAttrs.addFlashAttribute("totalCost", catalog.totalCost());

        return "redirect:creditcards";
    }

}
