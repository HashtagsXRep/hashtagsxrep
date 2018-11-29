package cat.xarxarepublicana.hashtagsxrep.domain.twitter;

import cat.xarxarepublicana.hashtagsxrep.domain.user.User;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Date;

import static cat.xarxarepublicana.hashtagsxrep.domain.service.TimeConverter.toLocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id_str",
        scope = TwitterUser.class,
        resolver = RepeatedObjectIdResolver.class
)
public class TwitterUser {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "EEE MMM dd HH:mm:ss Z yyyy", locale = "en")
    private Date createdAt;
    private String idStr;
    private String screenName;
    private String name;
    private Long followersCount;
    private Long friendsCount;
    private String lang;
    private String location;
    private String profileImageUrlHttps;
    private boolean verified;
    @JsonProperty("protected")
    private boolean _protected;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public Long getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Long followersCount) {
        this.followersCount = followersCount;
    }

    public Long getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(Long friendsCount) {
        this.friendsCount = friendsCount;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getProfileImageUrlHttps() {
        return profileImageUrlHttps;
    }

    public void setProfileImageUrlHttps(String profileImageUrlHttps) {
        this.profileImageUrlHttps = profileImageUrlHttps;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public boolean isProtected() {
        return _protected;
    }

    public void setProtected(boolean _protected) {
        this._protected = _protected;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User toUser() {
        return new User(
                getIdStr(),
                getScreenName(),
                getName(),
                null,
                toLocalDateTime(getCreatedAt()),
                getFollowersCount(),
                getFriendsCount(),
                getLang(),
                getLocation(),
                getProfileImageUrlHttps(),
                isVerified(),
                isProtected()
        );
    }
}
