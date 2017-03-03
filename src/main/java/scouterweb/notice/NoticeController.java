package scouterweb.notice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Gun Lee (gunlee01@gmail.com) on 2017. 3. 2.
 */
@Controller
public class NoticeController {

    @GetMapping("/latest-notice")
    public String getLatestNotice(Model model, HttpServletResponse res) {
        model.addAttribute("testAttr", "test-value");
        res.setHeader("X-Scouter-ETag", DigestUtils.md5DigestAsHex("-scouter-20170303-01".getBytes()));
        return "latestNotice";
    }
}
