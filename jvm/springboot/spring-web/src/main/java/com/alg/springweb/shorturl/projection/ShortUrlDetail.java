package com.alg.springweb.shorturl.projection;

import com.alg.springweb.shorturl.domain.ShortUrl;
import com.alg.springweb.user.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "short_urls_detail", types = {ShortUrl.class})
public interface ShortUrlDetail {
    String getName();
    String getUrlDestination();
    String getShortUrl();
    @Value("#{target.users}")
    List<User> getOwners();
    @Value("#{target.users.size()}")
    int getOwnersCount();
}
