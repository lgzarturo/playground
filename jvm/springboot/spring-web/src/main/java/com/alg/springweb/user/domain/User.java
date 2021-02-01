package com.alg.springweb.user.domain;


import com.alg.springweb.shorturl.domain.ShortUrl;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javassist.bytecode.ByteArray;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "users")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id = null;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    private ByteArray photo;
    @ManyToMany(mappedBy = "users")
    @JsonIgnore
    private List<ShortUrl> shortUrls;
}
