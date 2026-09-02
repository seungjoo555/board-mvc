package kr.ac.kopo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;

/**
 * 게시판 요청 처리 컨트롤러
 */
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	// 전체 게시글 조회 요청
	@RequestMapping("/board")	// RequestMapping은 GET, POST 요청 둘다 처리가능
	public String list(Model model) throws Exception {
		/*
		BoardVO board = new BoardVO(1, "제목입니다", "홍길동", "2026-08-26");
		BoardVO board2 = new BoardVO(2, "제목2입니다", "홍길순", "2026-08-26");
		BoardVO board3 = new BoardVO(3, "제목3입니다", "홍길순", "2026-08-26");
		BoardVO board4 = new BoardVO(4, "제목4입니다", "홍길순", "2026-08-26");
		
		//BoardVO[] boardList = new BoardVO[] {board, board2, board3, board4};
		List<BoardVO> boardList = new ArrayList<>();
		boardList.add(board);
		boardList.add(board2);
		boardList.add(board3);
		boardList.add(board4);
		*/
		List<BoardVO> boardList = boardService.getBoardList();
		model.addAttribute("boardList", boardList);
		
		return "board/list";
	}
	
//	@RequestMapping(value="/board/write", method=RequestMethod.GET)
	@GetMapping("/board/write")
	public void writeForm(Model model) {

		model.addAttribute("boardVO", new BoardVO());
	}
	
//	@GetMapping("/board/write")
	public String writeForm2() {
		System.out.println("GET");
		return "board/write2";
	}
	
	@PostMapping("/board/write")
	public String write(@Valid BoardVO board, BindingResult result) throws Exception{
		System.out.println("Post");
		
		if(result.hasErrors()) {
			return "board/write";
		}
		
		boardService.addNewBoard(board);
		return "redirect:/board";
	}
	
//	@RequestMapping(value="/board/write", method=RequestMethod.POST)
	//@PostMapping("/board/write")
	//public void write(HttpServletRequest request) {
	//public void write(@RequestParam("title") String title, @RequestParam("writer") String writer) {
	public String write2(@ModelAttribute("board") BoardVO board) throws Exception{
		System.out.println("Post");
		
//		String title = request.getParameter("title");
//		String writer = request.getParameter("writer");
//		BoardVO board = new BoardVO();
//		board.setTitle(title);
//		board.setWriter(writer);
		
//		boardService.addBoard(board);
		System.out.println(board);
		System.out.println(board.getTitle() + " : " + board.getWriter());
		//@ModelAttribute를 붙이면 BoardVO라는 이름으로 감 그런데 ()괄호안에 이름 명시 가능 어노테이션 안붙여도 같은 기능을 함 Model객체 불필요
//		model.addAttribute("board", board);
		boardService.addNewBoard(board);
		//return "board/writeResult"
		return "redirect:/board";
	}
	
	// 11번 게시글 상세조회
	// http://localhost:8080/board-mvc/board/detail?no=11
	@GetMapping("/board/detail")
	public String detail(@RequestParam("no") int boardNo, Model model) throws Exception {
		
		//System.out.println("boardNo : " + boardNo);
		BoardVO board = boardService.getBoardByBoardNo(boardNo);
		
		model.addAttribute("board", board);
		
		return "board/detail";
	}
	
	// 11번 게시글 상세조회
	// http://localhost:8080/board-mvc/board/11
	@GetMapping("/board/{no}")
	public String detail2(@PathVariable("no") int boardNo, Model model) throws Exception {
		
		//System.out.println("boardNo : " + boardNo);
		BoardVO board = boardService.getBoardByBoardNo(boardNo);
		
		model.addAttribute("board", board);
		
		return "board/detail";
	}
	
	
	
	
}
