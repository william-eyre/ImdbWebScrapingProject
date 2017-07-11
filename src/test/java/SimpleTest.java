import com.william.model.Actor;
import com.william.model.Movie;
import com.william.services.IMDBSearchService;

import java.io.IOException;

public class SimpleTest {

    public static void main(String[] args) throws IOException{

        try {
            IMDBSearchService xmlTestOutput = new IMDBSearchService();

            Movie m = xmlTestOutput.processMoviePage("/title/tt0468569/?ref_=fn_tt_tt_1");
            System.out.println("Title:\n" + m.getTitle());
            System.out.println();
            System.out.println("Rating:\n" + m.getRating());
            System.out.println();
            System.out.println("Summary:\n" + m.getSummary());
            System.out.println();
            for (Actor a : m.getActors()) {
                System.out.println("Actor: " + a.getName() + "\t...\t Character Played: " + a.getCharacter());
            }
            System.out.println();

            } catch(Exception e){
                System.out.println("oh no, it went wrong");
            }


//        try {
//            IMDBMenu workingTitle2 = new IMDBMenu();
//            workingTitle2.title("star wars");
//        } catch (Exception e) {
//            System.out.println("oh no, it went wrong");
//        }

//        try {
//            IMDBMenu wrongTitle = new IMDBMenu();
//            wrongTitle.searchTitle("dfhgjhbdfg'''//.,./{}{}{}");
//        } catch (Exception e) {
//            System.out.println("oh no, it went wrong");
//        }
//
//        try {
//            IMDBMenu noSpaces = new IMDBMenu();
//            noSpaces.searchTitle("thedarkknight");
//        } catch (Exception e) {
//            System.out.println("oh no, it went wrong");
//        }
//
//        try {
//            IMDBMenu workingURL = new IMDBMenu();
//            workingURL.searchTitle("http://www.imdb.com/title/tt0468569/");
//        } catch (Exception e) {
//            System.out.println("oh no, it went wrong");
//        }
//
//        try {
//            IMDBMenu workingURL2 = new IMDBMenu();
//            workingURL2.searchTitle("http://www.imdb.com/title/tt0114369/");
//        } catch (Exception e) {
//            System.out.println("oh no, it went wrong");
//        }
//
//        try {
//            IMDBMenu brokenURL = new IMDBMenu();
//            brokenURL.searchTitle("http://www.imdb.com/title/tt04dfglk///111");
//        } catch (Exception e) {
//            System.out.println("oh no, it went wrong");
//        }


    }
}
