package life.sanelee.community.mapper;

import life.sanelee.community.model.Comment;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}