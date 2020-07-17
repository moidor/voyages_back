package com.cham.api.voyages.controller;

import java.util.ArrayList;
import java.util.List;

import com.cham.api.voyages.repo.Destination2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cham.api.voyages.model.Destination;
import com.cham.api.voyages.repo.DestinationRepository;

// @CrossOrigin(origins = "*", allowedHeaders = "*") -> autorise les connexions
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DestinationController {
    @Autowired
    DestinationRepository repository;

    @Autowired
    Destination2Repository repository2;

    @GetMapping(value = "/destinations")
    public List<Destination> getAllDestinations() {
        System.out.println("Get all Destinations...");

        List<Destination> destinations = new ArrayList<>();
        repository.findAll().forEach(destinations::add);

        return destinations;
    }

    @PostMapping(value = "/destinations")
    public Destination postDestination(@RequestBody Destination destination) {

        return repository.save(new Destination(
                destination.getTitle(),
                destination.getArticle(),
                destination.getYear(),
                destination.getImage(),
                destination.getCurrency()));
    }

    @DeleteMapping("/destinations/{id}")
    public ResponseEntity<String> deleteDestination(@PathVariable("id") long id) {
        System.out.println("Delete Destination with ID = " + id + "...");
        repository.deleteById(id);
        return new ResponseEntity<>("Destination has been deleted!", HttpStatus.OK);
    }

    @DeleteMapping("/destinations/delete")
    public ResponseEntity<String> deleteAllDestinations() {
        System.out.println("Delete All Destinations...");
        repository.deleteAll();
        return new ResponseEntity<>("All destinations have been deleted!", HttpStatus.OK);
    }

    @GetMapping(value = "/destinations/year/{year}")
    public List<Destination> findByYear(@PathVariable int year) {
        System.out.println("Selected article in " + year);
        return repository.findByYear(year);
    }

    // Les méthodes commençant par "findBy" doivent contenir le même nom après que celui du paramètre
    @GetMapping(value = "/destinations/title/{title}")
    public List<Destination> findByTitle(@PathVariable String title) {
        System.out.println("Selected destination by title: " + title);
        return repository2.findByTitle(title);
    }

    @GetMapping(value = "/destinations/article/{article}")
    public ArrayList<Destination> findByArticle(@PathVariable String article) {
        System.out.println("Selected destination by searched word : " + article);
        ArrayList<Destination> result =new ArrayList<>();
        for (Destination dest : this.getAllDestinations()) {
            if (dest.getArticle().toLowerCase().contains(article)) {
                result.add(dest);
            }
        }
        return result;
    }

    @GetMapping("/destinations/login")
    public String login(){
        System.out.println("Authenticated successfully");
        return "Authenticated successfully" ;
    }

/*  @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
        System.out.println("Update Customer with ID = " + id + "...");

        Optional<Customer> customerData = repository.findById(id);

        if (customerData.isPresent()) {
            Customer _customer = customerData.get();
            _customer.setName(customer.getName());
            _customer.setAge(customer.getAge());
            _customer.setActive(customer.isActive());
            return new ResponseEntity<>(repository.save(_customer), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
*/
}
