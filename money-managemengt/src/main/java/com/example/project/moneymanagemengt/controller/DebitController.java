package com.example.project.moneymanagemengt.controller;

import com.example.project.moneymanagemengt.exception.ResourceNotFound;
import com.example.project.moneymanagemengt.model.Debit;
import com.example.project.moneymanagemengt.repository.DebitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api/v1")
public class DebitController {

    @Autowired
    private DebitRepository repo;

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping(path = "/debit")
    public List<Debit> getAllDebitDetails(){
        return repo.findAll();
    }


    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping(path = "/debit")
    public Debit addDebit(@RequestBody Debit debit){
        return repo.save(debit);
    }


    @GetMapping(path = "/debit/{id}")
    public ResponseEntity <Debit> getDetailsById(@PathVariable int id){

        Debit debit = repo.findById(id).orElseThrow(() ->new ResourceNotFound("Id does not exist"));
        return ResponseEntity.ok(debit);

    }

    @PutMapping(path = "/debit/{id}")
    public ResponseEntity<Debit> updateDetails(@PathVariable int id,@RequestBody Debit debitDetails){

        Debit debit = repo.findById(id).orElseThrow(() ->new ResourceNotFound("Id does not exist"));

        debit.setName(debitDetails.getName());
        debit.setAmount(debitDetails.getAmount());

        Debit updatedDetails = repo.save(debit);

        return ResponseEntity.ok(updatedDetails);

    }

    @DeleteMapping(path = "/debit/{id}")
    public void deleteDebit(@PathVariable int id){
        repo.deleteById(id);

    }

}
