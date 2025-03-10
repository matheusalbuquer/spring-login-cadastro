package br.appLogin.appLogin.services;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Optional;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieService {

	public static void setCookie(HttpServletResponse response, String key, String valor, int segundos) throws UnsupportedEncodingException {
		Cookie cookie = new Cookie(key, URLEncoder.encode(valor,"UTF-8"));
		cookie.setMaxAge(segundos);
		response.addCookie(cookie);
	}

	public static String getCookie(HttpServletRequest request, String key) {
        String valor = Optional.ofNullable(request.getCookies())
                .flatMap(cookies -> Arrays.stream(cookies)
                        .filter(cookie -> key.equals(cookie.getName()))
                        .findAny()
                )
                .map(Cookie::getValue)
                .orElse(null);

        if (valor != null) {
            return URLDecoder.decode(valor, StandardCharsets.UTF_8);
        }
        return valor;
    }
	
	
	
}
