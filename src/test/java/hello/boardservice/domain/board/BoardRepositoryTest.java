package hello.boardservice.domain.board;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BoardRepositoryTest {

    BoardRepository boardRepository = new BoardRepository();

    @AfterEach
    void afterEach() {
        boardRepository.clearPage();
    }

    @Test
    void save() {
        //given
        Board board = new Board("boardA", "안녕하세요.");

        //when
        Board savedBoard = boardRepository.save(board);

        //then
        Board findBoard = boardRepository.findById(board.getId());
        assertThat(findBoard).isEqualTo(savedBoard);
    }

    @Test
    void findAll() {
        //given
        Board board1 = new Board("board1", "안녕하세요.");
        Board board2 = new Board("board2", "반갑습니다.");

        boardRepository.save(board1);
        boardRepository.save(board2);

        //when
        List<Board> result = boardRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(board1, board2);
    }

    @Test
    void updateBoard() {
        //given
        Board board = new Board("board1", "안녕하세요.");

        Board savedBoard = boardRepository.save(board);
        Long boardId = savedBoard.getId();

        //when
        Board updateParam = new Board("board2", "인사올립니다.");
        boardRepository.update(boardId, updateParam);

        //then
        Board findBoard = boardRepository.findById(boardId);

        assertThat(findBoard.getBoardTitle()).isEqualTo(updateParam.getBoardTitle());
        assertThat(findBoard.getContent()).isEqualTo(updateParam.getContent());

    }
}