package com.devsuperior.dsList.controllers;

import com.devsuperior.dsList.DTO.GameListDTO;
import com.devsuperior.dsList.services.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @RequestMapping(value = "/lists")
public class ListsController {

    @Autowired
    private ListService listService;

    @GetMapping
    public List<GameListDTO> findAll(){
        return listService.findAllLists();
    }
}
