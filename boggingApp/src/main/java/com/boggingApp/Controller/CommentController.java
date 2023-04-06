package com.boggingApp.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
//	@Autowired
//	private CommentService commentService;
	
//	@PostMapping("/post/{postId}/comments")
//	public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @PathVariable Integer postId){
//		
//		CommentDto createComment = commentService.createComment(commentDto, postId);
//		return new ResponseEntity<CommentDto>(createComment, HttpStatus.OK);
//	}
//	
//	@DeleteMapping("/comments/{commentId}")
//	public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId){
//		
//		commentService.deleteComment(commentId);
//		return new ResponseEntity<ApiResponse>(new ApiResponse("comment deleted successfully", true), HttpStatus.OK);
//	}
}
