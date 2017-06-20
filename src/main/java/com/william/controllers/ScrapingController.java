package com.william.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.william.model.TitleSearch;
import com.william.services.IMDBSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created by william.eyre on 23/03/2017.
 *
 */

@Controller
public class ScrapingController {

    private IMDBSearchService search;
    private Gson jsonMaker;

    @Autowired
    public ScrapingController(Gson jsonMaker, IMDBSearchService search) {
        this.jsonMaker = new GsonBuilder().setPrettyPrinting().create(); // .setPrettyPrinting makes the Json output more readable.
        this.search = search;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("titleSearch", new TitleSearch());
        return "Greeting";
    }


    @PostMapping(value = "/ImdbConnect", produces = "application/json") // tells the web page that it will be receiving a Json response.
    @ResponseBody
    public String imdbConnect(@ModelAttribute TitleSearch titleSearch) {
        String json = null;
        try {
           json = jsonMaker.toJson(search.searchForTitle(titleSearch.getContent()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

}
