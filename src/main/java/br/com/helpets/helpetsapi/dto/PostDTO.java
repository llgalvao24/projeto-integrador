package br.com.helpets.helpetsapi.dto;

import br.com.helpets.helpetsapi.model.Post;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter @Setter
public class PostDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private String postImage;
    private String content;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date postData;

    public PostDTO(Post obj) {
        id = obj.getId();
        title = obj.getTitle();
        postImage = obj.getPostImage();
        content = obj.getContent();
        postData = obj.getPostData();
    }

    public void PostDTO() {
    }
}
