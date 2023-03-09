package org.xlms.app.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * A Instructor.
 */
@Document(collection = "instructor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Instructor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("name")
    private String name;

    @Field("email")
    private String email;

    @Field("instructor_url")
    private String instructorUrl;

    @Field("instructor_thumbnail")
    private String instructorThumbnail;

    @Field("instructor_rating")
    private String instructorRating;

    @Field("instructor_rating_count")
    private String instructorRatingCount;

    @Field("instructor_total_students")
    private String instructorTotalStudents;

    @Field("instructor_total_reviews")
    private String instructorTotalReviews;

    @Field("rating_count")
    private String ratingCount;

    // jhipster-needle-entity-add-field - JHipster will add fields here


}
