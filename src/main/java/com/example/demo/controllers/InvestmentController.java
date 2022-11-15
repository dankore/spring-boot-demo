package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Investment;
import com.example.demo.entities.InvestmentNote;
import com.example.demo.models.CreateInvestment;
import com.example.demo.models.CreateNote;
import com.example.demo.repositories.InvestmentRepository;

@RestController
public class InvestmentController {

    @Autowired
    private InvestmentRepository repo;

    @GetMapping("/investments")
    @ResponseStatus(HttpStatus.OK)
    public List<Investment> getInvestments(){
        return repo.findAll();
    }

    @PostMapping("/investments")
    @ResponseStatus(HttpStatus.CREATED)
    public void createInvestment(@RequestBody CreateInvestment createInvestment){
        repo.save(Investment.builder()
            .amount(createInvestment.getAmount())
            .build());
    }

    @GetMapping("/investments/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Investment getInvestment(@PathVariable Long id){
        return repo.findById(id).get();
    }

    @GetMapping("/investments/byAmount/{amount}")
    @ResponseStatus(HttpStatus.OK)
    public List<Investment> getInvestmentsByAmount(@PathVariable int amount){
        return repo.findAllByAmount(amount);
    }

    @GetMapping("/investments/{id}/note")
    @ResponseStatus(HttpStatus.CREATED)
    public List<InvestmentNote> getInvestmentNotes(@PathVariable Long id){
        return getInvestment(id).getNotes();
    }

    @PostMapping("/investments/{id}/note")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNote(@PathVariable Long id, @RequestBody CreateNote createNote){
        var investment = getInvestment(id);
        investment.getNotes().add(
            InvestmentNote.builder()
                .text(createNote.getText())
                .investment(investment)
                .build());
        repo.save(investment);
    }

}
 