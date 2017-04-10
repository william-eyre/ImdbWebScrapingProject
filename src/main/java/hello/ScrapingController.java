package hello;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import services.IMDBSearchService;

import java.io.IOException;

/**
 * Created by william.eyre on 23/03/2017.
 *
 */

@Controller
public class ScrapingController {

    // dependency injection / spring autowiring
    private IMDBSearchService search = new IMDBSearchService();
    // race conditions, thread safe and deadlock
    private Gson gson = new Gson();



    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("titleSearch", new TitleSearch());
        return "Greeting";
    }

    @RequestMapping("/ImdbConnect")
    public String imdbConnect(@ModelAttribute TitleSearch titleSearch, Model model) {
        // log.debug("got here")
        String json = null;
        // log.info(help ful info)
        try {
            json = gson.toJson(search.searchForTitle(titleSearch.getContent()));
        } catch (IOException e) {
            e.printStackTrace();
            //console out or console error
            // use log4j log.error(e)
        }
        model.addAttribute("json", json);
        return "result";
    }

//    @RequestMapping("/web") // maps the HTTP request to the greeting method
//    public String web(Model model) {
//
//        Gson gson = new Gson();
//
//        JsonReader reader = null;
//        try { // reads the local Json file created
//            reader = new JsonReader(new FileReader("/Users/william.eyre/Documents/work/code/java/springMvcBasics/film.json"));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        // creates an array of the Movie object
//        Movie[] movies = gson.fromJson(reader, Movie[].class);
//        model.addAttribute("movies", movies);
//
//        return "web";
//    }


}