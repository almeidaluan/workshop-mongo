package com.br.workshopmongo.workshopmongo.domain;

import com.br.workshopmongo.workshopmongo.dto.AuthorDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class Post implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    private String id;

    private LocalDate date;
    private String title;
    private String body;


}
