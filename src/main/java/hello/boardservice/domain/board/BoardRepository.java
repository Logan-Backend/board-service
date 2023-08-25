package hello.boardservice.domain.board;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BoardRepository {

    private static final Map<Long, Board> page = new HashMap<>(); // static
    private static long sequence = 0L; // static

    public Board save(Board board) {
        board.setId(++sequence);
        page.put(board.getId(), board);
        return board;
    }

    public Board findById(Long id) {
        return page.get(id);
    }

    public List<Board> findAll() {
        return new ArrayList<>(page.values());
    }

    public void update(Long boardId, Board updateParam) {
        Board findBoard = findById(boardId);
        findBoard.setBoardTitle(updateParam.getBoardTitle());
        findBoard.setContent(updateParam.getContent());
    }

    public void clearPage() {
        page.clear();
    }

}
