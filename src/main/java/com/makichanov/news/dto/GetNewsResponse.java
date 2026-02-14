package com.makichanov.news.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class GetNewsResponse {
    private Object pagination;

    private List<NewsData> data;
}
