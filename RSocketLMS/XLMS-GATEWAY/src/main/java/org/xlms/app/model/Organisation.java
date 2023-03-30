package org.xlms.app.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.validation.constraints.*;
import java.io.Serializable;

/**
 * A Organisation.
 */
@Document(collection = "organisation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Organisation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull(message = "must not be null")
    @Size(min = 3)
    @Field("name")
    private String name;

    @Field("description")
    private String description;

    // jhipster-needle-entity-add-field - JHipster will add fields here

}
