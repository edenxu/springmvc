package com.mvc.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mvc.pojo.UserInfo;

@Component
public interface ITestDAO {
	/**
	 * ���һ���µ��û���¼
	 * 
	 * @param ui
	 *            �û�������Ϣ
	 * @return �������
	 */
	public int add(UserInfo ui);

	/**
	 * �����û������ѯ�û���Ϣ
	 * 
	 * @param userCode
	 *            �û�����
	 * @return �û���Ϣ����
	 */
	public UserInfo queryByUserCode(String userCode);

	/**
	 * ��ѯ�����û���Ϣ
	 * 
	 * @return �û���Ϣ���󼯺�
	 */
	public List<UserInfo> getAllUserInfo();
}
