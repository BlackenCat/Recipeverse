package com.recipverse.service;

import com.recipverse.entity.Comment;
import com.recipverse.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public Comment create(Comment comment) {
        comment.setPostedAt(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    public List<Comment> getByRecipe(Long recipeId) {
        return commentRepository.findByRecipeId(recipeId);
    }

    public void delete(Long id) {
        commentRepository.deleteById(id);
    }
}
