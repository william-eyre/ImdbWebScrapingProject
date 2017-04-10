package tests;

import model.Movie;
import org.junit.Assert;
import org.junit.Test;
import services.IMDBSearchService;

import java.io.IOException;
import java.util.List;

/**
 * Created by william.eyre on 02/03/2017.
 *
 */
public class TestCases {

    @Test
    public void workingTitle1() throws IOException {
        IMDBSearchService workingTitle1 = new IMDBSearchService();
        List <Movie> title1 = workingTitle1.searchForTitle("Star wars");

        Assert.assertEquals(title1.size(), 5);

        Movie movie1 = title1.get(0);
        Assert.assertEquals(movie1.getTitle(), "Star Wars: Episode IV - A New Hope (1977)");
        Assert.assertEquals(movie1.getRating(), "8.7/10");

    }

    @Test
    public void workingTitle2() throws IOException {
        IMDBSearchService workingTitle2 = new IMDBSearchService();
        List <Movie> title2 = workingTitle2.searchForTitle("The dark knight");

        Assert.assertEquals(title2.size(), 5);

        Movie movie2 = title2.get(0);
        Assert.assertEquals(movie2.getTitle(), "The Dark Knight (2008)");
        Assert.assertEquals(movie2.getRating(), "9.0/10");
    }

    @Test
    public void incorrectTitle1() throws IOException {
        IMDBSearchService wrongTitle1 = new IMDBSearchService();
        List <Movie> wrong1 = wrongTitle1.searchForTitle("hjbsdfbjhsdfbhjsdf");

        Assert.assertEquals(wrong1.size(), 0);
    }

    @Test
    public void incorrectTitle2() throws IOException {
        IMDBSearchService wrongTitle2 = new IMDBSearchService();
        List <Movie> wrong2 = wrongTitle2.searchForTitle("yg12378t12ebwejhf7128ge");

        Assert.assertEquals(wrong2.size(), 0);
    }
}
