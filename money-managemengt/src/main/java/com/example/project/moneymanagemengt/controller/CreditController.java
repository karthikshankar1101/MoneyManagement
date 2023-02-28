package com.example.project.moneymanagemengt.controller;

import com.example.project.moneymanagemengt.exception.ResourceNotFound;
import com.example.project.moneymanagemengt.model.Credit;
import com.example.project.moneymanagemengt.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class CreditController {

    @Autowired
    private CreditRepository repo;

    @GetMapping(path = "/credit")
    public List<Credit> getAllCreditDetails(){
        return repo.findAll();
    }


    @PostMapping(path = "/credit")
    public Credit addCreditdetails(@RequestBody Credit credit){
        return repo.save(credit);
    }


    @GetMapping(path = "/credit/{id}")
    public ResponseEntity<Credit> getCreditDetailsById(@PathVariable int id)
    {
       Credit credit = repo.findById(id).orElseThrow(() ->new ResourceNotFound("Id does not exist"));
        return ResponseEntity.ok(credit);
    }


    @PutMapping(path = "/credit/{id}")
    public ResponseEntity<Credit> updateDetails(@PathVariable int id, @RequestBody Credit creditDetails){

        Credit credit = repo.findById(id).orElseThrow(() ->new ResourceNotFound("Id does not exist"));

        credit.setName(creditDetails.getName());
        credit.setAmount(creditDetails.getAmount());

        Credit updatedDetails = repo.save(credit);

        return ResponseEntity.ok(updatedDetails);

    }


    @DeleteMapping(path = "/credit/{id}")
    public void deleteCredit(@PathVariable int id){
        repo.deleteById(id);

    }
}
