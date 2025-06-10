package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@WebFilter(filterName = "AuthenFilter", urlPatterns = {"/*"})
public class AuthenFilter implements Filter {

    private static final Set<String> STATIC_RESOURCES = new HashSet<>(Arrays.asList(
            ".css", ".js", ".jpg", ".jpeg", ".png", ".gif", ".woff", ".svg", ".ico"
    ));

    private static final Set<String> PUBLIC_PATHS = new HashSet<>(Arrays.asList(
            "/login", "/login.jsp", "/logout"
    ));

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("AuthenFilter initialized.");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        String contextPath = req.getContextPath();
        String path = uri.substring(contextPath.length());

        // Bỏ qua tài nguyên tĩnh
        if (isStaticResource(path)) {
            chain.doFilter(request, response);
            return;
        }

        // Cho phép truy cập login/logout
        if (PUBLIC_PATHS.contains(path)) {
            chain.doFilter(request, response);
            return;
        }

        // Kiểm tra đăng nhập
        HttpSession session = req.getSession(false);
        User user = (session != null) ? (User) session.getAttribute("user") : null;

        if (user == null) {
            res.sendRedirect(contextPath + "/login.jsp");
            return;
        }

        String role = user.getRole();

        // ADMIN → không giới hạn quyền
        if ("admin".equalsIgnoreCase(role)) {
            chain.doFilter(request, response);
            return;
        }

        // USER → kiểm soát chặt chẽ
        if ("user".equalsIgnoreCase(role)) {

            // Cho phép xem danh sách
            if (path.startsWith("/user/list") || path.startsWith("/product/list")) {
                chain.doFilter(request, response);
                return;
            }

            // Chặn thêm mới
            if (path.contains("/add")) {
                res.sendRedirect(contextPath + "/accessDenied.jsp");
                return;
            }

            // Sửa/xóa chính mình
            if (path.startsWith("/user/edit") || path.startsWith("/user/delete")) {
                String idParam = req.getParameter("id");
                if (idParam != null && idParam.equals(String.valueOf(user.getId()))) {
                    chain.doFilter(request, response);
                    return;
                } else {
                    res.sendRedirect(contextPath + "/accessDenied.jsp");
                    return;
                }
            }

            // Không cho phép sửa/xóa user khác, hoặc tác động đến product
            res.sendRedirect(contextPath + "/accessDenied.jsp");
            return;
        }

        // Role không xác định
        res.sendRedirect(contextPath + "/accessDenied.jsp");
    }

    @Override
    public void destroy() {
    }

    private boolean isStaticResource(String path) {
        for (String ext : STATIC_RESOURCES) {
            if (path.endsWith(ext)) return true;
        }
        return false;
    }
}
