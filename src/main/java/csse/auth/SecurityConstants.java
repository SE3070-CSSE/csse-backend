package csse.auth;

public class SecurityConstants {

    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 1_800_000; // 10 days->8640_000_000 *30 mins->1_800_000
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/user/register";
    public static final String LOGIN_URL = "/user/login";
    public static final String USER_LIST_URL = "/user/list";
    public static final String GET_USER_URL = "/user/{username}";
    public static final String DEACTIVATE_URL = "/user/deactivate/{username}"; 
    public static final String EDIT_USER_URL = "/user/editUser/{username}";
    public static final String RESET_PASSWORD_URL ="user/resetPassword/{username}";
}