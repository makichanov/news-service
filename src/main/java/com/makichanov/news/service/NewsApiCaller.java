package com.makichanov.news.service;

import com.makichanov.news.dto.GetNewsResponse;
import com.makichanov.news.model.NewsRecord;
import com.makichanov.news.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class NewsApiCaller {

    @Value("${secret.apiKey}")
    private String apiKey;

    private final RestClient restClient;
    private final NewsRepository newsRepository;

    @Scheduled(fixedRate = 1, timeUnit = TimeUnit.HOURS)
    public void reportCurrentTime() {
        GetNewsResponse response = restClient.get()
            .uri("https://api.mediastack.com/v1/news?access_key=" + apiKey)
            .retrieve()
            .body(GetNewsResponse.class);

        if (response != null && response.getData() != null) {
            newsRepository.saveAll(response.getData()
                .stream()
                .map(n -> new NewsRecord(n.getDescription(), n.getTitle()))
                .collect(Collectors.toSet()));
        }
    }
}