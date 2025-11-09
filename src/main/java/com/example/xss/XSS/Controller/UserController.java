package com.example.xss.XSS.Controller;

import com.example.xss.XSS.entity.User;
import com.example.xss.XSS.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    // 취약한 로그인 처리
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, RedirectAttributes redirectAttributes){

        // 취약한 쿼리 사용
        Optional<User> userOptional = userRepository.findVulnerableUser(username, password);

        if (userOptional.isPresent()){
            redirectAttributes.addFlashAttribute("message", "관리자 페이지에 오신 것을 환영합니다!");
            return "redirect:/admin";
        } else {
            redirectAttributes.addFlashAttribute("error", "로그인 실패: 사용자 이름 또는 비밀번호가 올바르지 않습니다.");
            return "redirect:login";
        }
    }
}
