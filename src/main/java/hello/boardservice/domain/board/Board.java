package hello.boardservice.domain.board;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Board {

    private Long id;
    private String boardTitle;
    private String content;

    public Board() {
    }

    public Board(String boardTitle, String content) {
        this.boardTitle = boardTitle;
        this.content = content;
    }
}
