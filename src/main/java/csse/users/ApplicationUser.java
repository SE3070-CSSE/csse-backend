package csse.users;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import java.util.List;

public class ApplicationUser {

    @Id
    private String _id;

    private String username;
    private String password;
    private List<String> roles;

    // @JsonCreator annotation was added because jackson would not detect the constructor automatically
    @JsonCreator
    public ApplicationUser(@JsonProperty("_id") String _id,
                           @JsonProperty("username") String username,
                           @JsonProperty("password") String password,
                           @JsonProperty("roles") List<String> roles) {
        this._id = _id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public String get_id() {
        return _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRole(List<String> roles) {
        this.roles = roles;
    }
}
