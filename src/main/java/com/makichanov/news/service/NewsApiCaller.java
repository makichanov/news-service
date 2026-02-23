package com.makichanov.news.service;

import com.makichanov.news.model.NewsRecord;
import com.makichanov.news.repository.NewsRepository;
import com.makichanov.news.thirdparty.mediastack.NewsApiClient;
import com.makichanov.news.thirdparty.mediastack.dto.GetNewsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class NewsApiCaller {

    private final NewsApiClient newsApiClient;
    private final NewsRepository newsRepository;

    @Scheduled(fixedRate = 1, timeUnit = TimeUnit.HOURS)
    public void reportCurrentTime() {
        GetNewsResponse response = newsApiClient.getAllNews();

        if (response != null && response.getData() != null) {
            newsRepository.saveAll(response.getData()
                .stream()
                .map(n -> new NewsRecord(n.getDescription(), n.getTitle()))
                .collect(Collectors.toSet()));
        }
    }
}