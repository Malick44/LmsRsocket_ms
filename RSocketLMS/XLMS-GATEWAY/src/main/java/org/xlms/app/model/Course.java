package org.xlms.app.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.io.Serializable;

/**
 * A Course.
 */
@Document(collection = "course")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;

    @Field("title")
    private String title;

    @Field("author_id")
    private String authorId;

    @Field("author_name")
    private String authorName;

    @Field("name")
    private String name;

    @Field("description")
    private String description;

    @Field("category")
    private String category;

    @Field("sub_category")
    private String subCategory;

    @Field("level")
    private String level;

    @Field("language")
    private String language;

    @Field("duration")
    private String duration;

    @Field("price")
    private String price;

    @Field("rating")
    private String rating;

    @Field("rating_count")
    private String ratingCount;

    @Field("thumbnail")
    private String thumbnail;

    @Field("url")
    private String url;

    @Field("instructor_id")
    private String instructorId;

    // jhipster-needle-entity-add-field - JHipster will add fields here


}
