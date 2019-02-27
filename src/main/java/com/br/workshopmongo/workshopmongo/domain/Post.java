package com.br.workshopmongo.workshopmongo.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

@Document
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Post implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    private String id;

    private LocalDate date;
    private String title;
    private String body;


}
