package com.makichanov.news.thirdparty.mediastack;

import com.makichanov.news.thirdparty.mediastack.dto.GetNewsResponse;
import com.makichanov.news.thirdparty.mediastack.error.MediastackApiError;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
public class NewsApiClient {

    @Value("${secret.apiKey}")
    private String apiKey;

    private final RestClient restClient;

    public GetNewsResponse getAllNews() {
        return restClient.get()
            .uri("https://api.mediastack.com/v1/news?access_key=" + apiKey)
            .retrieve()
            .onStatus(HttpStatusCode::isError,
                (req, resp) -> {
                    throw new MediastackApiError(resp.getStatusText());
                })
            .body(GetNewsResponse.class);
    }
}
