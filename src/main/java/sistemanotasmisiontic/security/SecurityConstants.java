package sistemanotasmisiontic.security;

import sistemanotasmisiontic.SpringApplicationContetx;

public class SecurityConstants {

    public static final long expiration_date = 864000000; // 10 dias
    public static final String LOGIN_URL = "/users/login"; // 10 dias
    public static final String TOKEN_PREFIX =  "Bearer ";
    public static final String HEADER_STRING =  "Authorization";

    public static String getTokenSecret () {
        AppProperties appProperties = (AppProperties) SpringApplicationContetx.getBean("AppProperties");
         return  appProperties.getTokenSecret();
    }

}
