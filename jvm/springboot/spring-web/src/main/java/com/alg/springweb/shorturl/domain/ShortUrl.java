package com.alg.springweb.shorturl.domain;

import com.alg.springweb.user.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "short_urls")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class ShortUrl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id = null;
    @NonNull
    private String name;
    @NonNull
    private String urlDestination;
    @NonNull
    private String shortUrl;
    @NonNull
    private Boolean isActive;

    @ManyToMany
    @JoinTable(
            name = "short_url_users",
            joinColumns = {@JoinColumn(name = "short_url_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private List<User> users;
}
