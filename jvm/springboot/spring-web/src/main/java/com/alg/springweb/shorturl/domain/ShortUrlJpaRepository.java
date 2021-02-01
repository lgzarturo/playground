package com.alg.springweb.shorturl.domain;

import com.alg.springweb.shorturl.projection.ShortUrlDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "short_urls", collectionResourceRel = "short_urls", excerptProjection = ShortUrlDetail.class)
public interface ShortUrlJpaRepository extends JpaRepository<ShortUrl, Long> {
    List<ShortUrl> findByShortUrl(String shortUrl);
    ShortUrl findFirstByNameIgnoreCase(String name);
    List<ShortUrl> findByIsActiveIsTrue();
}
