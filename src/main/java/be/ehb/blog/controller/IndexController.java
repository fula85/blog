package be.ehb.blog.controller;


import be.ehb.blog.model.BlogPost;
import be.ehb.blog.model.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @ModelAttribute("all")
    public Iterable<BlogPost> findAll() {return blogPostRepository.findAll(); }

    @ModelAttribute("BlogPost")
    public BlogPost getBlogPost(){
        return new BlogPost();
    }

    @RequestMapping(value = {"/index", "/"} , method = RequestMethod.GET)
    public String showIndex(ModelMap map){
        return "index";
    }


    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String SavePost(@ModelAttribute("BlogPost") BlogPost blogPost, BindingResult bindingResult){
        blogPostRepository.save(blogPost);
        return "redirect:index";
    }



}
