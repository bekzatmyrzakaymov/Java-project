package com.spring.project.controller;

import com.spring.project.details.CustomUserDetails;
import com.spring.project.model.Book;
import com.spring.project.model.User;
import com.spring.project.repo.BookRepository;
import com.spring.project.repo.UserRepository;
import com.spring.project.service.BookService;
import com.spring.project.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class BookController {
    @Autowired

    private BookService bookService;
    @Autowired
    private UserService userService;
    @Autowired
   private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("all")
    public String viewHomePage(Model model) {
        model.addAttribute("listBooks", bookService.getAllBooks());
        return "main_page";
    }


    @GetMapping("/addBook")
    public String showNewForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "addBook";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.addBook(book);
        return "redirect:/all";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable(value = "id") int id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "updateBook";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable(value = "id") int id) {
        bookService.deleteBookById(id);
        return "redirect:/all";

    }

//    @PostMapping("/addBookToUSer/{id}")
//    public void addBookToUser( Authentication authentication,@PathVariable(value = "id") int id){
//        Book book = bookRepository.findById((long)id);
//        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
//        User user =customUserDetails.getUser();
//        Set<Book> books = new HashSet<>();
//        books.add(book);
//        user.setBooks(books);
//        userRepository.save(user);
//    }


    @GetMapping("/MyBooks")
    public String MyBook(Authentication authentication,Model model){
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        User user = customUserDetails.getUser();
        List<Book> books = user.getBooks();
        model.addAttribute("user",user);
        model.addAttribute("listBooks",books);
        return "MyBook";
    }

}
