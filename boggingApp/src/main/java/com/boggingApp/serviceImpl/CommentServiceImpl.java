package com.boggingApp.serviceImpl;

import org.springframework.stereotype.Service;

import com.boggingApp.Services.CommentService;
@Service
public class CommentServiceImpl implements CommentService {

//	@Autowired
//	private PostRepository postRepository;
//	@Autowired
//	private CommentRepository commentRepository;
//	@Autowired
//	private ModelMapper modelMapper;
//	@Override
//	public CommentDto createComment(CommentDto commentDto, Integer postId) {
//		Post post = postRepository.findById(postId).orElseThrow(()-> new  ResourceNotFoundException("Post", "post id", postId));
//		Comment comment = modelMapper.map(commentDto, Comment.class);
//		comment.setPost(post);
//		Comment savedComment = commentRepository.save(comment);
//		return modelMapper.map(savedComment, CommentDto.class);
//		
//	}

//	@Override
//	public void deleteComment(Integer commentId) {
//		Comment com = commentRepository.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment", "comment id", commentId));
//		commentRepository.delete(com);
//	}

}
