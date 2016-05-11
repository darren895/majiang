package com.majiang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.majiang.dto.BaseMobileDTO;
import com.majiang.entity.MobileLogin;
import com.majiang.mapper.MobileLoginMapper;
import com.majiang.util.SHAUtil;

@Service
public class MobileCommonService {

	@Autowired
	private MobileLoginMapper mobileLoginMapper;

	public boolean verifyToken(BaseMobileDTO baseMobileDTO) {
		if (baseMobileDTO == null || baseMobileDTO.getUuid() == null || baseMobileDTO.getTime() == null
				|| baseMobileDTO.getToken() == null) {
			return false;
		}
		MobileLogin mobileLogin = this.mobileLoginMapper.getMobileLogin(baseMobileDTO.getUuid());
		if(mobileLogin == null){
			return false;
		}
		String shaToken = baseMobileDTO.getUuid()+baseMobileDTO.getTime()+mobileLogin.getTokenKey();
		try {
			shaToken = SHAUtil.shaEncode(shaToken);
		} catch (Exception e) {
		}
		return baseMobileDTO.getToken().equals(shaToken);
	}
}
