package Controller;

import java.io.IOException;
import java.util.ArrayList;

import Utils.FileManager;
import Utils.InnputManger;
import dao.UserDAO;
import vo.User;

public class ShopController {
	private UserDAO user;
	private FileManager f;
	private InnputManger inp;
	private String name;
	public ShopController() {
		// TODO Auto-generated constructor stub
		f = FileManager.getInstance();
		inp = InnputManger.getInstance();
		user = UserDAO.getInstance();
	}

	public void run() {
		FirstMenu();
	}
	private boolean CheckNum(int inp,int max) {
		if(inp < 0 || inp > max) {
			System.out.println("0 ~ "+max+"까지 입력 가능");
			return true;
		}
		return false;
	}
	private boolean CheckNum(int inp,int max,int max2) {
		if(inp < 0 || inp > max && inp != max2) {
			System.out.println("0 ~ "+max+" or "+max2+" 입력 가능");
			return true;
		}
		return false;
	}
	private void FirstMenu() {
		while (true) {
			int inp = this.inp.getInt("[1.가입] [2.탈퇴] [3.로그인] [4.로그아웃]" + "\n[100.관리자] [0.종료] ");
			if(inp == 0) break;
			else if(CheckNum(inp,4,100)) continue;
			
			if(inp == 1) {
				String id = this.inp.getString("[가입]아이디 입력");
				if(user.getIdIdx(id) != -1) {
					System.out.println("중복된 아이디 입니다");
					continue;
				}
				String pw = this.inp.getString("[가입]비밀번호 입력");
				String name = this.inp.getString("[가입]이름 입력");
				user.NewUseradd(id, pw, name);
			}else if(inp == 2) {
				if(user.getCountUser() == 0) {
					System.err.println("no data");
					continue;
				}
				String id = this.inp.getString("[가입]아이디 입력");
				if(user.getIdIdx(id) == -1) {
					System.err.println("[탈퇴]아이디를 확인하세요");
					continue;
				}
				
			}else if(inp == 3) {
				
			}
			else if(inp == 4) {
			}
			else if(inp == 100) {
				name = "관리자";
				ManagerMenu();
			}
			
		}
		System.out.println("프로그램 종료");
	}
	private void LogOut() {
		name = "";
	}
	//관리자 메뉴
	private void ManagerMenu() {
		while(true) {
			int inp = this.inp.getInt("[1.아이템관리] [2.카테고리관리] [3.장바구니관리] [4.유저관리] [0.뒤로가기] ");
			if(inp == 0) { LogOut(); break;}
			else if(CheckNum(inp, 4)) continue;
			
			if(inp == 1) {
				
			}
			else if(inp == 2) {
				
			}
			else if(inp == 3) {
				
			}
			else if(inp == 4) {
				
			}
		}
	}
	//사용자 메뉴
	private void LoginMenu() {
		while (true) {
			int inp = this.inp.getInt("[1.쇼핑] [2.장바구니목록] [0.뒤로가기]");
			if(inp == 0) { LogOut(); break;}
			else if(CheckNum(inp, 4)) continue;
			
			if(inp == 1) {
				
			}
			else if(inp == 2) {
				
			}
		}
	}
	//마이페이지
	private void UserMenu() {
		while (true) {
			int inp = this.inp.getInt("[1.내 장바구니] [2.삭제] [3.구입] [0.뒤로가기]");
			if(inp == 0) {break;}
			else if(CheckNum(inp, 4)) continue;
			
		}

	}
// 	System.out.println("[1.아이템관리] [2.카테고리관리] [3.장바구니관리] [4.유저관리] [0.뒤로가기] ");
	// System.out.println("[1.가입] [2.탈퇴] [3.로그인] [4.로그아웃]" + "\n[100.관리자] [0.종료] ");

	// System.out.println("[1.쇼핑] [2.장바구니목록] [0.뒤로가기]");

	// System.out.println("[1.내 장바구니] [2.삭제] [3.구입] [0.뒤로가기]");
}
// 	System.out.println("[1.아이템관리] [2.카테고리관리] [3.장바구니관리] [4.유저관리] [0.뒤로가기] ");