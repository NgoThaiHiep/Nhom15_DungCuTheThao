package iuh.se.fit.controller.client;





import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import iuh.se.fit.service.ProductService;



@Controller
@RequestMapping(value = "/client")
public class SearchProductClientController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/search")
    public String search(HttpServletRequest request,
            @RequestParam(name = "pricing", required = false) String pricing,
            @RequestParam(name = "sort", required = false) String sort,
            @RequestParam(name = "text", required = false) String text) {
        int pageIndex = 0;
        int pageSize = 9;

        double priceFrom = 0;
        double priceTo = 0;
        if (pricing != null) {
            if (pricing.equals("under300")) {
                priceTo = 300000;
            } else if (pricing.equals("300to500")) {
                priceFrom = 300000;
                priceTo = 500000;
            } else if (pricing.equals("greaterthan500")) {
                priceFrom = 500000;
                priceTo = 10000000;
            }
        } else {
            pricing = "default";
        }

        long categoryId = 1;
        if (request.getParameter("categoryId") != null) {
            categoryId = Long.parseLong(request.getParameter("categoryId"));
        }

        if (request.getParameter("pageSize") != null) {
            pageSize = Integer.parseInt(request.getParameter("pageSize"));
        }

        if (request.getParameter("pageIndex") != null) {
            pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
        }

        int totalPage = 0;
        int count = productService.countBySearch(categoryId, pricing, priceFrom, priceTo, text);
        if (count % pageSize == 0) {
            totalPage = count / pageSize;
        } else {
            totalPage = count / pageSize + 1;
        }

        request.setAttribute("pageSize", pageSize);
        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("text", text);
        request.setAttribute("sort", sort);
        request.setAttribute("pricing", pricing);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("categoryId", categoryId);
        request.setAttribute("checkSearch", true);
        if (count == 0) {
            request.setAttribute("checkSearch", false);
            return "client/error";
        } else {
            request.setAttribute("products", productService.search(categoryId, pricing, priceFrom, priceTo, sort, text, pageIndex, pageSize));
            return "client/products_grid";
        }
    }

    @GetMapping(value = "/textSearch")
    public String searchProductByName(HttpServletRequest request, HttpSession session) {
        int pageIndex = 0;
        int pageSize = 9;

        if (request.getParameter("pageSize") != null) {
            pageSize = Integer.parseInt(request.getParameter("pageSize"));
        }

        if (request.getParameter("pageIndex") != null) {
            pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
        }

        int totalPage = 0;
        String pcName = request.getParameter("pcName");
        int count = productService.countByProductName(pcName);
        if (count % pageSize == 0) {
            totalPage = count / pageSize;
        } else {
            totalPage = count / pageSize + 1;
        }
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("nameP", pcName);
        if (count == 0) {
            return "client/error";
        } else {
            request.setAttribute("productz", productService.findAllProductByName(pcName, pageIndex, pageSize));
            return "client/findProducts";
        }
    }
}
