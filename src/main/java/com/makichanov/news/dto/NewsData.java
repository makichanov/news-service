package com.makichanov.news.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class NewsData {
    private String author;

    private String description;

    private String title;
}
