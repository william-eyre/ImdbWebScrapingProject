package com.william.services;

import com.william.model.Movie;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class IMDBMenu {

    public String title;


    public List<Movie> searchIMDBSiteForTitle() throws IOException {
        IMDBSearchService findURL = new IMDBSearchService();
        List<Movie> listMovies = findURL.searchForTitle(title);
        return listMovies;

    }

    public void listTop250Films() throws IOException {
        IMDBSearchService list = new IMDBSearchService();
        list.top250List();
    }


}

