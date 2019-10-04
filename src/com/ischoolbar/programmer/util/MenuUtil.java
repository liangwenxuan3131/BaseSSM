package com.ischoolbar.programmer.util;

import java.util.ArrayList;
import java.util.List;

import com.ischoolbar.programmer.entity.admin.Menu;

/**
 * ���ڲ˵�������һЩ���÷���
 * @author llq
 *
 */
public class MenuUtil {
	/**
	 * �Ӹ����Ĳ˵��з������ж����˵�
	 * @param menuList
	 * @return
	 */
	public static List<Menu> getAllTopMenu(List<Menu> menuList){
		List<Menu> ret = new ArrayList<Menu>();
		for(Menu menu:menuList){
			if(menu.getParentId() == 0){
				ret.add(menu);
			}
		}
		return ret;
	}
	
	/**
	 * ��ȡ���еĶ����˵�
	 * @param menuList
	 * @return
	 */
	public static List<Menu> getAllSecondMenu(List<Menu> menuList){
		List<Menu> ret = new ArrayList<Menu>();
		List<Menu> allTopMenu = getAllTopMenu(menuList);
		for(Menu menu:menuList){
			for(Menu topMenu:allTopMenu){
				if(menu.getParentId() == topMenu.getId()){
					ret.add(menu);
					break;
				}
			}
		}
		return ret;
	}
	
	/**
	 * ��ȡĳ�������˵��µİ�ť
	 * @param menuList
	 * @param
	 * @return
	 */
	public static List<Menu> getAllThirdMenu(List<Menu> menuList,Long seid){
		List<Menu> ret = new ArrayList<Menu>();

		for(Menu menu:menuList){
			if (menu.getParentId() == seid) {
					ret.add(menu);
			}
		}
		return ret;
	}
}
