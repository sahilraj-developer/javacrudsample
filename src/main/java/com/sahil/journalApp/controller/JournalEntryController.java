package com.sahil.journalApp.controller;

import com.sahil.journalApp.entity.JournalEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    private Map<Long, JournalEntry> journalEntries  = new HashMap<>();
   
    @GetMapping("/abc")
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping("/abc")
    public boolean create(@RequestBody JournalEntry myEntry){
        journalEntries.put(myEntry.getId(),myEntry);
        return true;
    }

    @GetMapping("/abc/{id}")
    public JournalEntry getJournalEntryById(@PathVariable long id){
       return  journalEntries.get(id);
    }

    @DeleteMapping("/abc/{id}")
    public JournalEntry deleteJournalEntryById(@PathVariable long id){
       return  journalEntries.remove(id);
    }


    @PutMapping("/abc/{id}")
    public JournalEntry deleteJournalEntryById(@PathVariable long id,@RequestBody JournalEntry myEntry){
       return  journalEntries.put(id,myEntry);
    }
    
}
