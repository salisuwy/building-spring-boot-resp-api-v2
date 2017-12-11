package me.salisuwy;

import java.util.ArrayList;
import java.util.List;

public class BlogMockedData {
    //list of blog posts
    private List<Blog> blogs;

    private static BlogMockedData instance = null;
    public static BlogMockedData getInstance(){
         if(instance == null){
             instance = new BlogMockedData();
         }
         return instance;
    }


    public BlogMockedData(){
        blogs = new ArrayList<Blog>();
        blogs.add(new Blog(1, "Go up, up and away with your Google Assistant",
                "With holiday travel coming up, and 2018 just around the corner, " +
                        "you may be already thinking about getaways for next year. Consider " +
                        "the Google Assistant your new travel buddy, ready at the drop of a hat—or a passport"));
        blogs.add(new Blog(2, "Get local help with your Google Assistant",
                "No matter what questions you’re asking—whether about local traffic or " +
                        "a local business—your Google Assistant should be able to help. And starting " +
                        "today, it’s getting better at helping you, if you’re looking for nearby services " +
                        "like an electrician, plumber, house cleaner and more"));
        blogs.add(new Blog(3, "The new maker toolkit: IoT, AI and Google Cloud Platform",
                "Voice interaction is everywhere these days—via phones, TVs, laptops and smart home devices " +
                        "that use technology like the Google Assistant. And with the availability of maker-friendly " +
                        "offerings like Google AIY’s Voice Kit, the maker community has been getting in on the action " +
                        "and adding voice to their Internet of Things (IoT) projects."));
        blogs.add(new Blog(4, "Learn more about the world around you with Google Lens and the Assistant",
                "Looking at a landmark and not sure what it is? Interested in learning more about a movie as " +
                        "you stroll by the poster? With Google Lens and your Google Assistant, you now have a helpful " +
                        "sidekick to tell you more about what’s around you, right on your Pixel."));
        blogs.add(new Blog(5, "7 ways the Assistant can help you get ready for Turkey Day",
                "Thanksgiving is just a few days away and, as always, your Google Assistant is ready to help. " +
                        "So while the turkey cooks and the family gathers, here are some questions to ask your Assistant."));
    }

    // return all blogs
    public List<Blog> fetchBlogs() {
        return blogs;
    }

    // return blog by id
    public Blog getBlogById(int id) {
        for(Blog b: blogs) {
            if(b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    // search blog by text
    public List<Blog> searchBlogs(String searchTerm) {
        List<Blog> searchedBlogs = new ArrayList<Blog>();
        for(Blog b: blogs) {
            if(b.getTitle().toLowerCase().contains(searchTerm.toLowerCase()) ||
               b.getContent().toLowerCase().contains(searchTerm.toLowerCase())) {
                searchedBlogs.add(b);
            }
        }

        return searchedBlogs;
    }

    // create blog
    public Blog createBlog(int id, String title, String content) {
        Blog newBlog = new Blog(id, title, content);
        blogs.add(newBlog);
        return newBlog;
    }

    // update blog
    public Blog updateBlog(int id, String title, String content) {
        for(Blog b: blogs) {
            if(b.getId() == id) {
                int blogIndex = blogs.indexOf(b);
                b.setTitle(title);
                b.setContent(content);
                blogs.set(blogIndex, b);
                return b;
            }

        }

        return null;
    }

    // delete blog by id
    public boolean delete(int id){
        int blogIndex = -1;
        for(Blog b: blogs) {
            if(b.getId() == id) {
                blogIndex = blogs.indexOf(b);
                continue;
            }
        }
        if(blogIndex > -1){
            blogs.remove(blogIndex);
        }
        return true;
    }


}
