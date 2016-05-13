package com.majiang.controller.mobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.majiang.service.GameService;

@Controller
@RequestMapping("mobile")
public class MobileGameController extends BaseController {

	@Autowired
	private GameService gameService;
}
