package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


    @RestController
    public class TimeStoriesController {

        private final List<Story> latestStories;

        public TimeStoriesController() {
            latestStories = new ArrayList<>();
            // Initialize the list of stories with the provided titles and links
            latestStories.add(new Story("Amy Schneider’s Jeopardy! Streak Ends at 40 Consecutive Wins and $1.4 Million", "https://time.com/6142934/amy-schneider-jeopardy-streak-ends/"));
            latestStories.add(new Story("'Writing With Fire' Shines a Light on All-Women News Outlet", "https://time.com/6142628/writing-with-fire-india-documentary/"));
            latestStories.add(new Story("Moderna Booster May Wane After 6 Months", "https://time.com/6142852/moderna-booster-wanes-omicron/"));
            latestStories.add(new Story("Pressure Mounts for Biden to Nominate a Black Woman to the Supreme", "https://time.com/6142743/joe-biden-supreme-court-nominee-black-woman-campaign-promise/"));
            latestStories.add(new Story("The James Webb Space Telescope Is in Position—And Now We Wait", "https://time.com/6142769/james-webb-space-telescope-reaches-l2/"));
            latestStories.add(new Story("We Urgently Need a New National COVID-19 Response Plan", "https://time.com/6142718/we-need-new-national-covid-19-response-plan/"));
        }

        @GetMapping("/getTimeStories")
        public List<Story> getTimeStories() {
            return latestStories;
        }

        @PostMapping("/insertStory")
        public void insertStory(@RequestBody Story story) {
            latestStories.add(story);
        }

        public static class Story {
            private String title;
            private String link;

            public Story() {}

            public Story(String title, String link) {
                this.title = title;
                this.link = link;
            }

            // Getters and setters
            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }
        }
    }
