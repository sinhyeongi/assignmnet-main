package dao;

import java.util.ArrayList;

import vo.User;

public class UserDAO {
	private static ArrayList<User> list;
	private UserDAO(){
		if(list == null)
			list = new ArrayList<User>();
	}
	
	private static UserDAO instance;
	public static UserDAO getInstance() {
		if(instance == null) instance = new UserDAO();
		return instance;
	}
	//id인덱스 값 반환
	public int getIdIdx(String id){
		for(int i = 0 ; i < list.size(); i++)
			if(id.equals(list.get(i).getId()))
				return i;
		return -1;
	}
	//유저 수 리턴
	public int getCountUser() {
		return list.size();
	}
	//유저 생성
	public void NewUseradd(String id,String pw,String name) {
		list.add(new User(id, pw, name));
	}
	//유저 삭제
	public void DeleteUser(int idx) {
		list.remove(idx);
		System.out.println("[탈퇴]탈퇴 완료");
	}
}
