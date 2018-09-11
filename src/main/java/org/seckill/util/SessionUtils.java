package org.seckill.util;

import org.seckill.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {

    public static User getUser(HttpServletRequest request) {
        return getSession(request, "_user", User.class);
    }

    public static void setUser(HttpServletRequest request,User user) {
        setSessionAttribute(request, "_user", user);

    }

    public static <T> T getSession(HttpServletRequest request, String key, Class<T> clazz) {
        HttpSession session = request.getSession();
        Object o = session.getAttribute(key);
        return o == null ? null :clazz.cast(o);
    }

    public static void setSessionAttribute(HttpServletRequest request, String key, Object value) {
        HttpSession session = request.getSession();
        session.setAttribute(key, value);
        session.setMaxInactiveInterval(10*60);
    }

    public static void removeSessionAttribute(HttpServletRequest request, String key) {
        HttpSession session = request.getSession();
        session.removeAttribute(key);
    }


    public static boolean hasAttribute(HttpServletRequest request, String key) {
        HttpSession session = request.getSession();
        Object o = session.getAttribute(key);
        return o != null && !StringUtils.isEmpty(o.toString());
    }
}
