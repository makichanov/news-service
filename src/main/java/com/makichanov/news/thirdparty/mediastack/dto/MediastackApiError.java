package com.makichanov.news.thirdparty.mediastack.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class MediastackApiError {
    private String code;
    private String message;
    private String context;
}
