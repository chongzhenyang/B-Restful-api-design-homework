package com.thoughtworks.capability.gtb.restfulapidesign.model;

import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Group {
    @Getter
    private final long id;

    @Getter@NonNull
    private String name;

    @Getter@Setter
    private String note;
}
