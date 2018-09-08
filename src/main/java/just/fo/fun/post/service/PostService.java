package just.fo.fun.post.service;

import just.fo.fun.entities.Post;
import just.fo.fun.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post save(Post post){
        return postRepository.save(post);
    }

    public Post findOne(Long id){
        return postRepository.findOne(id);
    }

    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public void delete(Long id){
        postRepository.delete(id);
    }


    public Page<Post> getAll(Pageable pageable) {
         return postRepository.getAll(pageable);
    }
}
