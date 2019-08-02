package org.generation.brazil.backend.comment;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter @Getter
public class CommentDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String content;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date commData;

    public CommentDTO(Comment obj){
        id = obj.getId();
        content = obj.getContent();
        commData = obj.getCommData();
    }

    public CommentDTO(){
    }
}
