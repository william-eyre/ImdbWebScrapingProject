package com.william.services;

import com.william.model.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class IMDBSearchService implements ISearch{

    @Override
    public List<Movie> searchForTitle(String searchTerm) throws IOException {

        String url = "http://www.imdb.com/find?q=" + searchTerm;
        Document doc = Jsoup.connect(url).get();


        String link = doc.select(".findMoreMatches a").attr("href");
        String secondUrl = "http://www.imdb.com" + link;
        secondUrl = secondUrl.replaceAll("%20", " ");
        Document page = Jsoup.connect(secondUrl).get();

        List<Movie> movieList = new ArrayList<>();

        /* loops over list of movies and gets the first 5 results. */
        Elements rows = page.select("table.findList tr");
        int y = 0;
        for(Element row : rows) {
            String href = row.select(".result_text a").attr("href");
            Movie myMovie = processMoviePage(href);
            movieList.add(myMovie);
            y++;
            System.out.println(y);
            if(y == 5) {
                break;
            }
        }
        return movieList;
    }


    public Movie processMoviePage(String Id) throws IOException {


        // gets the information from the search results.
        Movie m = new Movie();

        String URL = "http://www.imdb.com" + Id;

        Document doc = Jsoup.connect(URL).get();


        Elements titleWrapper = doc.select("body");
        String title = titleWrapper.select(".title_bar_wrapper h1").text();
        String rating = titleWrapper.select(".ratingValue").text();
        String summary = titleWrapper.select(".summary_text").text();
        String duration = titleWrapper.select(".subtext time").text();
        String director = titleWrapper.select(".plot_summary .credit_summary_item a").first().text();

        m.setTitle(title);
        m.setRating(rating);
        m.setSummary(summary);
        m.setDuration(duration);
        m.setDirector(director);
        m.setActors(processMovieActors(doc));

//        int limit = 40;
//
//        for (int start = 0; start <= summary.length(); start += limit) {
//            int end = start + limit;
//            if (end >= summary.length()) {
//                end = summary.length();
//            }
//            String str = summary.substring(start, end);
//            System.out.println(str);
//        }

        return m;
    }

    private List<Actors> processMovieActors(Document doc) throws IOException {

        List<Actors> actorsList = new ArrayList<Actors>();

        for(Element row : doc.select("table.cast_list tr")) {
            Actors a = new Actors();

            String actor = row.select(".itemprop a").text();
            String character = row.select(".character").text();

            a.setName(actor);
            a.setCharacter(character);

            actorsList.add(a);
        }
        return actorsList;
    }

    public List<Movie> top250List() throws IOException {

        // tells Jsoup what URL to look at
        Document document = Jsoup.connect("http://www.imdb.com/chart/top").get();

        // picks what element to look at on the page, in this case the table
        for (Element row : document.select("table.chart.full-width tr")) {

            // picks the class names in the tables to look at what information to collect
            String title = row.select(".titleColumn a").text();
            String rating = row.select(".imdbRating").text();

            //prints out my results
            System.out.println(title + " -> Rating: " + rating);

        }
        return null;
    }

}
