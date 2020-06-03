package com.adekah.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "users", type = "user") // replicas and shards for research
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String id;

    @Field(name = "name", type = FieldType.Text)
    private String name;

    @Field(name = "surname", type = FieldType.Text)
    private String surname;

    @Field(name = "adress", type = FieldType.Text)
    private String adress;

    @Field(name = "birthDate", type = FieldType.Text)
    private Date birthDate;
}
