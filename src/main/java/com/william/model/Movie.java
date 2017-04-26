package com.william.model;

import java.util.List;

/**
 * Created by william.eyre on 21/02/2017.
 *
 */
public class Movie {

    private String title;
    private String rating;
    private String summary;
    private String director;
    private String producer;
    private String duration;



    public List<Actors> actors;

    public List<Actors> getActors() {
        return actors;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setActors(List<Actors> actors) {
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        title = newTitle;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String newRating) {
        rating = newRating;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String newSummary) {
        summary = newSummary;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String newDirector) {
        director = newDirector;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String newProducer) {
        producer = newProducer;
    }

}
