package com.makichanov.news.thirdparty.mediastack.dto;

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
