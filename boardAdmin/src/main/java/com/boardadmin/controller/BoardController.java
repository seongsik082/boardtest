package com.boardadmin.controller;

import com.boardadmin.entity.Board;
import com.boardadmin.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/boards")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("boards", boardService.findAll());
        return "board/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("board", new Board());
        return "board/form";
    }

    @PostMapping
    public String create(Board board) {
        boardService.save(board);
        return "redirect:/boards";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable Long id, Model model) {
        Board board = boardService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid board Id:" + id));
        model.addAttribute("board", board);
        return "board/view";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Board board = boardService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid board Id:" + id));
        model.addAttribute("board", board);
        return "board/edit";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, Board updatedBoard) {
        Board board = boardService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid board Id:" + id));
        board.setTitle(updatedBoard.getTitle());
        board.setContent(updatedBoard.getContent());
        board.setWriter(updatedBoard.getWriter());
        board.setModifiedDate(updatedBoard.getModifiedDate());
        boardService.save(board);
        return "redirect:/boards";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        boardService.deleteById(id);
        return "redirect:/boards";
    }
}
