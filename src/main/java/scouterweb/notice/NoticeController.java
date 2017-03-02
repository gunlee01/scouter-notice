package scouterweb.notice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Gun Lee (gunlee01@gmail.com) on 2017. 3. 2.
 */
@Controller
public class NoticeController {

    @GetMapping("/latest-notice")
    public String getLatestNotice(Model model) {
        model.addAttribute("name", "gunlee");
        return "latestNotice";
    }
}
