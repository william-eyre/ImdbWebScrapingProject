package services;

import model.Movie;

import java.io.IOException;
import java.util.List;


public interface ISearch {
    List <Movie> searchForTitle(String searchTerm) throws IOException;
    List <Movie> top250List() throws IOException;
}
