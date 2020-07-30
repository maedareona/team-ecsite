package jp.co.internous.sky.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.sky.model.domain.MstUser;
import jp.co.internous.sky.model.mapper.MstUserMapper;
import jp.co.internous.sky.model.session.LoginSession;

@Controller
@RequestMapping("/sky/mypage")
public class MyPageController {

	@Autowired
	protected LoginSession loginSession;

	@Autowired
	private MstUserMapper mstUserMapper;

	@RequestMapping("/")
	public String index(Model m) {
		List<MstUser> mstUser =  mstUserMapper.findByUserNameAndPassword(loginSession.getUserName(), loginSession.getPassword());
		m.addAttribute("mstUser",mstUser);
		m.addAttribute("loginSession", loginSession);
		return "my_page";
	}

}