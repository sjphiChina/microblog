package sjph.life.model.post.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import sjph.life.model.post.Post;
import sjph.life.model.post.dao.PostDao;
import sjph.life.model.post.service.PostService;
import sjph.life.ui.exception.PostNotFoundException;

/**
 * @author shaohuiguo
 *
 */
@Service
public class PostServiceImpl implements PostService {
    private static final Logger logger = Logger.getLogger(PostServiceImpl.class);

    @Autowired(required = true)
    private PostDao             postDao;

    @Override
    public long createPost(Post post) {
        logger.info("Create Post: " + post.toString());
        // post.setContent(encodeText(post.getContent()));
        long id = postDao.createPost(post);
        post.setId(id);
        logger.info("Created Post: " + post.toString());
        return id;
    }

    @Override
    public Post findPost(long postId) {
        try {
            Post post = postDao.findPost(postId);
            // post.setContent(decodeText(post.getContent()));
            return post;
        }
        catch (EmptyResultDataAccessException e) {
            throw new PostNotFoundException(postId, "No post found.", e);
        }
    }

    @Override
    public List<Post> listPosts() {
        List<Post> list = postDao.listPosts(true);
        // for (Post post : list) {
        // post.setContent(decodeText(post.getContent()));
        // }
        return list;
    }

    @Override
    public List<Post> listPosts(Long userId) {
        List<Post> list = postDao.listPosts(userId, true);
        // for (Post post : list) {
        // post.setContent(decodeText(post.getContent()));
        // }
        return list;
    }

    @Override
    public boolean updatePost(Post post) {
        // post.setContent(encodeText(post.getContent()));
        if (postDao.updatePost(post) == 1) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean deletePost(Long postId) {
        if (postDao.deletePost(postId) == 1) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean deletePosts(Long userId) {
        if (postDao.deletePosts(userId) >= 1) {
            return true;
        }
        else {
            return false;
        }
    }

    // private String encodeText(String text) {
    // try {
    // if (text != null) {
    // text = TextCodingHelper.encodeText(text, ServiceConfig.CHARACTER_ENCODING_SET);
    // }
    // return text;
    // }
    // catch (UnsupportedEncodingException e) {
    // String message = "Cannot finish request.";
    // logger.error(message, e);
    // throw new ServiceRequestFailedException(message, e);
    // }
    // }
    //
    // private String decodeText(String text) {
    // try {
    // if (text != null) {
    // return TextCodingHelper.decodeText(text, ServiceConfig.CHARACTER_ENCODING_SET);
    // }
    // return text;
    // }
    // catch (UnsupportedEncodingException e) {
    // String message = "Cannot finish request.";
    // logger.error(message, e);
    // throw new ServiceRequestFailedException(message, e);
    // }
    // }
}
