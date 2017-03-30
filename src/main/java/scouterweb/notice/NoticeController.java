package scouterweb.notice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Gun Lee (gunlee01@gmail.com) on 2017. 3. 2.
 */
@Controller
@Slf4j
public class NoticeController {

    @GetMapping("/latest-notice")
    public String getLatestNotice(Model model, HttpServletRequest req, HttpServletResponse res) {
//        Enumeration<String> headerNames = req.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            String name = headerNames.nextElement();
//            log.info("header : {} -> {}", name, req.getHeader(name));
//        }
        model.addAttribute("testAttr", "test-value2");
        res.setHeader("X-Scouter-ETag", DigestUtils.md5DigestAsHex("-scouter-20170330-01".getBytes()));
        return "latestNotice";
    }

    @GetMapping("/latest-notice2")
    public String getLatestNotice2(Model model, HttpServletRequest req, HttpServletResponse res) {
//        Enumeration<String> headerNames = req.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            String name = headerNames.nextElement();
//            log.info("header : {} -> {}", name, req.getHeader(name));
//        }
        model.addAttribute("testAttr", "test-value");
        res.setHeader("X-Scouter-ETag", DigestUtils.md5DigestAsHex("-scouter-20170303-01".getBytes()));
        return "latestNotice2";
    }
}
