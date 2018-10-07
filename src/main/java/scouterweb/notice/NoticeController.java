package scouterweb.notice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

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
        model.addAttribute("testAttr", "test-value17");
        res.setHeader("X-Scouter-ETag", DigestUtils.md5DigestAsHex("-scouter-20180929-01".getBytes()));
        return "latestNotice";
    }

    @GetMapping("/latest-notice2")
    public String getLatestNotice2(Model model, HttpServletRequest req, HttpServletResponse res) {
        model.addAttribute("testAttr", "test-value17");
        res.setHeader("X-Scouter-ETag", DigestUtils.md5DigestAsHex("-scouter-20180929-01".getBytes()));
        return "latestNotice2";
    }

    @GetMapping("/scouter-paper/latest-notice")
    @ResponseBody
    public NoticeResponse getPaperLatestNotice(HttpServletRequest req, HttpServletResponse res) {
        if (!StringUtils.isEmptyOrWhitespace(req.getHeader("X-Scouter-Notice-Token"))) {
            res.setHeader("X-Scouter-Notice-Token", Long.toHexString(UUID.randomUUID().getMostSignificantBits()));
        }
        String noticeToken = DigestUtils.md5DigestAsHex("scouter-paper-20181007-01".getBytes());
        res.setHeader("X-Scouter-Notice-ETag", noticeToken);

        ;
        return new NoticeResponse(noticeToken, Arrays.asList(new PaperNotice("", "", "", "")));
    }

    public static class NoticeResponse {
        String noticeToken;
        List<PaperNotice> notices;

        public NoticeResponse(String noticeToken, List<PaperNotice> notices) {
            this.noticeToken = noticeToken;
            this.notices = notices;
        }

        public String getNoticeToken() {
            return noticeToken;
        }

        public List<PaperNotice> getNotices() {
            return notices;
        }
    }

    public static class PaperNotice {
        String noticeId;
        String title;
        String contents;
        String dummy;

        public PaperNotice(String noticeId, String title, String contents, String dummy) {
            this.noticeId = noticeId;
            this.title = title;
            this.contents = contents;
            this.dummy = dummy;
        }

        public String getNoticeId() {
            return noticeId;
        }

        public String getTitle() {
            return title;
        }

        public String getContents() {
            return contents;
        }

        public String getDummy() {
            return dummy;
        }
    }
}
