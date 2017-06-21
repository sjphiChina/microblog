package sjph.life.web.post;

import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author shaohuiguo
 *
 */
@Controller
public class PostController {

    private static final Logger log = LogManager.getLogger(PostController.class);
    
    private PostHandler postHandler;

    @Required
    public void setPostHandler(PostHandler postHandler) {
        this.postHandler = postHandler;
    }

    @RequestMapping("/addPost")
    public ModelAndView showform() {
        // command is a reserved request attribute name, now use <form> tag to show object data
        return new ModelAndView("postForm", "command", new PostBean());
    }

    @RequestMapping(value = "/savePost", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("emp") PostBean postBean) {
        // write code to save emp object
        // here, we are displaying emp object to prove emp has data
        System.out.println(postBean.getContent());
        postHandler.createPost(postBean);
        // return new ModelAndView("empform","command",emp);//will display object data
        return new ModelAndView("redirect:/postsView");// will redirect to viewemp request mapping
    }

    @RequestMapping("/postsView")
    public ModelAndView showPosts() {
        // write the code to get all employees from DAO
        // here, we are writing manual code of list for easy understanding
        List<PostBean> list = new LinkedList<PostBean>();
        list.add(new PostBean("abcde"));
        list.add(new PostBean("fghij"));
        list.add(new PostBean("klmno"));

        return new ModelAndView("postsView", "list", list);
    }
}
