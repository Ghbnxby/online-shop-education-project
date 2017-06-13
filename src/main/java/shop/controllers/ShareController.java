package shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import shop.models.entity.Share;
import shop.service.ShareService;

import java.util.List;

@Controller
public class ShareController {

    private ShareService shareService;

    @Autowired(required = true)
    @Qualifier(value = "shareService")
    public void setShareService(ShareService shareService) {
        this.shareService = shareService;
    }

    /*  Open data Share in viewShare.ftl     */
    @RequestMapping("/share/view")
    public ModelAndView viewShare(long id) {
        Share share = (Share) this.shareService.getById(id);
        return new ModelAndView("viewShare", "share", share);
    }

    /* This command delete Share by Id and redirect on listShares */
    @RequestMapping("/share/delete")
    public String deleteShare(long id) {
        Share share = (Share) this.shareService.getById(id);
        this.shareService.delete(share);
        return "redirect:/share/list";
    }

    /*  Getting Share's list and view  */
    @RequestMapping("/share/list")
    public ModelAndView listShares() {

        List<Share> list = shareService.listShares();
        return new ModelAndView("listShares", "list", list);
    }

    /*  Update Share and redirect on listShares */
    @RequestMapping("/share/edit")
    public String editShare(@ModelAttribute("share") Share share, long id) {
        share.setId(id);
        this.shareService.update(share);
        return "redirect:/share/list";
    }

    /*  Open page addShare.ftl for add to product   */
    @RequestMapping(value = "/share/add")
    public String addShare() {

        return "addShare";
    }

    /*   This command add new Share in database  */
    @RequestMapping(value = "/share/save")
    public String saveShare(@ModelAttribute("share") Share share) {
        if (share.getId() == 0) {
            //new person, add it
            this.shareService.save(share);
        } else {
            //existing person, call update
            this.shareService.update(share);
        }
        return "redirect:/share/list";
    }

}
