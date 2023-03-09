package org.xlms.app.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * A Rating.
 */
@Document(collection = "rating")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Rating implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("rating")
    private Integer rating;

    @Field("course_id")
    private String courseId;

    // jhipster-needle-entity-add-field - JHipster will add fields here

}
