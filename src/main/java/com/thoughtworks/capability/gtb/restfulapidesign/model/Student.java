package com.thoughtworks.capability.gtb.restfulapidesign.model;

import lombok.*;

import javax.persistence.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Student {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter@Setter@NonNull
    private String name;

    @Getter@Setter@NonNull
    private String gender;

    @Getter@Setter
    private String note;
}
