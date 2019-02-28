package com.br.workshopmongo.workshopmongo.domain;

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
public class Comment implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    private String id;

    private String text;
    private String date;


}
