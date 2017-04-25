package com.william.services;

import com.william.model.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public interface ISearch {
    List <Movie> searchForTitle(String searchTerm) throws IOException;
    List <Movie> top250List() throws IOException;
}
