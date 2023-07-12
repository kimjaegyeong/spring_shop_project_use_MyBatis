package spring.project.shop.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spring.project.shop.domain.Delivery;
import spring.project.shop.domain.Member;
import spring.project.shop.service.deliveryservice.MemoryDeliveryService;
import spring.project.shop.service.memberservice.MybatisMemberService;


import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/shop")
public class MybatisMemberController {
    private final MybatisMemberService mybatisMemberService;
    private final MemoryDeliveryService memoryDeliveryService;

    @GetMapping("/main")
    public String main(){
        return "shop/main";
    }

    @GetMapping("/sign-up")
    public String signUp_page(){
        return "shop/sign-up";
    }

    @PostMapping("/sign-up")
    public String signUp(Member member, RedirectAttributes redirectAttributes){
        //일반적인 회원가입은 모두 general 등급

        String memberId=mybatisMemberService.general_signUp(member);
        redirectAttributes.addAttribute("memberId", memberId);

        return "redirect:/shop/login";
    }

    @GetMapping("/login")
    public String login_page(){
        return "shop/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String memberId, @RequestParam String password,
                        HttpSession httpSession,RedirectAttributes redirectAttributes){
        String id= mybatisMemberService.login(memberId, password);
        //세션부여
        if(memberId.equals(id)) {
            httpSession.setAttribute("loginMember", memberId);
            redirectAttributes.addAttribute("memberId", memberId);
            log.warn(id);
        }

        return "redirect:/shop/main";
    }

    @GetMapping("/mypage/{memberId}")
    public String mypage(@PathVariable String memberId, Model model){
        //들어올 때 id, password 검증
        Member member =mybatisMemberService.userInfo(memberId);
        model.addAttribute("member",member);
        return "shop/mypage";
    }

    @GetMapping("/mypage/update/{memberId}")
    public String updatePage(@PathVariable String memberId, Model model){
        //바람직한 방법은 아니라고 생각. mypage에서 정보를 다 끌어오되,
        // mypage를 조회할 때 password 부분을 히든필드로 두어 노출되지 않게 지정하여 페이지 자체에서 정보를 얻어올 수 있도록 해야할듯
        Member member = mybatisMemberService.userInfo(memberId);
        model.addAttribute("member", member);

        return "shop/update-mypage";
    }

    @PostMapping("/mypage/update")
    public String mypageUpdate(Member member){
        String update_memberId = mybatisMemberService.userUpdate(member);
        String return_address = "redirect:/shop/mypage/"+update_memberId;
        log.warn(return_address);
        return return_address;
    }

    @GetMapping("/logout/{memberId}")
    public String logout(@PathVariable String memberId, HttpSession httpSession ,RedirectAttributes redirectAttributes){
        httpSession.invalidate(); //세션만료
        redirectAttributes.addAttribute("logout");
        //나중에 login-logout 관리하는 데이터베이스나 로그가 생기면 추가 로직 필요
        return "redirect:/shop/main";
    }
    //임시메소드
    @GetMapping("/findAll")
    public String findAll(){
        mybatisMemberService.findAll();
        return "shop/main";
    }
}
//    @GetMapping("/mypage/order/{deliveryCode}")
//    public String myOrderPage(@PathVariable String deliveryCode, Model model){
//        Delivery delivery = memoryDeliveryService.showDelivery(deliveryCode);
//        model.addAttribute("delivery", delivery);
//        return "shop/myOrderPage";
//    }

    /**
     *
     * 테스트용 데이터 추가
     */
//    @PostConstruct
//    public void init(){
//        Member member = new Member("user1","user1","여","010-2222-2222","email@e.com");
//        mybatisMemberService.general_signUp(member); }
//}
