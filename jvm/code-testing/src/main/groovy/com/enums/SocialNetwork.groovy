package com.enums

enum SocialNetwork {
    FACEBOOK("Facebook"),
    TWITTER("Twitter"),
    VIMEO("Vimeo"),
    YOUTUBE("Youtube"),
    MYSPACE("MySpace"),
    LINKEDIN("LinkedIn"),
    FLICKR("Flickr"),
    GPLUS("Google Plus"),
    BEHANCE("Behance"),
    FLAVORS("Flavors Me"),
    GITHUB("GitHub"),
    BITBUCKET("BitBucket")

    final String value

    SocialNetwork(String valor) {
        this.value = valor
    }

    @Override
    String toString() { value }

    String getKey() { name() }

    static String getSocialNetwork(String network) {
        return getSocialNetworkData(network).url
    }

    static String getSocialNetworkIcon(String network) {
        return getSocialNetworkData(network).icon
    }

    static Map getSocialNetworkData(String network) {
        def map = [url: "", icon: "", name: ""]
        if (network) {
            switch (network) {
                case FACEBOOK.value:
                    map = [url: "https://www.facebook.com/", icon: "fa-facebook", name: "facebook"]
                    break
                case BEHANCE.value:
                    map = [url: "https://www.behance.net/", icon: "fa-behance", name: "behance"]
                    break
                case BITBUCKET.value:
                    map = [url: "https://bitbucket.org/", icon: "fa-bitbucket", name: "bitbucket"]
                    break
                case FLAVORS.value:
                    map = [url: "http://flavors.me/", icon: "fa-flavors", name: "flavors"]
                    break
                case FLICKR.value:
                    map = [url: "http://www.flickr.com/people/", icon: "fa-flickr", name: "flickr"]
                    break
                case GITHUB.value:
                    map = [url: "https://github.com", icon: "fa-github", name: "github"]
                    break
                case GPLUS.value:
                    map = [url: "https://plus.google.com/", icon: "fa-google-plus", name: "google"]
                    break
                case LINKEDIN.value:
                    map = [url: "https://www.linkedin.com/in/", icon: "fa-linkedin", name: "linkedin"]
                    break
                case MYSPACE.value:
                    map = [url: "https://myspace.com/", icon: "fa-myspace", name: "myspace"]
                    break
                case TWITTER.value:
                    map = [url: "https://twitter.com/", icon: "fa-twitter", name: "twitter"]
                    break
                case VIMEO.value:
                    map = [url: "https://vimeo.com/", icon: "fa-vimeo", name: "vimeo"]
                    break
                case YOUTUBE.value:
                    map = [url: "http://www.youtube.com/user/", icon: "fa-youtube", name: "youtube"]
                    break
            }
        }
        return map
    }
}
