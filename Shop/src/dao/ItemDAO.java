package dao;

import java.util.ArrayList;

import vo.Cart;
import vo.Item;

public class ItemDAO {
	private static ArrayList<Item> list;
	private static ArrayList<String> categorylist;
	private static ArrayList<Cart> cartlist;

	private ItemDAO() {
		list = new ArrayList<Item>();
		categorylist = new ArrayList<String>();
		cartlist = new ArrayList<Cart>();
	}

	private static ItemDAO instance;

	public static ItemDAO getInstance() {
		if (instance == null)
			instance = new ItemDAO();
		return instance;
	}

	// 아이템 사이즈 리턴
	public int GetItemSize() {
		return list.size();
	}

	// 카테고리 사이즈 리턴
	public int GetcategorySize() {
		return categorylist.size();
	}
	public int GetCartSize() {
		return cartlist.size();
	}
	// 아이템 이름에 해당 인덱스 리턴
	public int GetItemIdx(String name) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(name))
				return i;
		}
		return -1;
	}

	// 카테고리 이름에 해당 인덱스 리턴
	public int GetcategoryIdx(String name) {
		for (int i = 0; i < categorylist.size(); i++) {
			if (categorylist.get(i).equals(name))
				return i;
		}
		return -1;
	}

	// 새로운 카테고리 추가
	public void Newcategory(String name) {
		categorylist.add(name);
	}

	// 카테고리 삭제
	public void Deletecategory(int idx) {

		DeleteItemCategory(categorylist.get(idx));
		if (categorylist.size() == 1) {
			categorylist.clear();
		} else {
			categorylist.remove(idx);
		}
	}

	// 카테고리 삭제시 아이템 삭제
	private void DeleteItemCategory(String category) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCategory().equals(category)) {
				DeleteCart(list.get(i).getName());
				if (list.size() == 1) {
					list.clear();
					break;
				} else {
					list.remove(i);
				}
				i--;
			}
		}
	}

	// 카테고리 삭제시 카트 삭제
	private void DeleteCart(String name) {
		for (int i = 0; i < cartlist.size(); i++) {
			if (name.equals(cartlist.get(i).getItemName())) {
				if(cartlist.size() == 1) {
					cartlist.clear();
					break;
				}else {
					cartlist.remove(i);
				}
				i--;
			}
		}
	}

	// 아이템 출력
	public void PrintItem() {
		System.out.printf("no %6s\t%4s\t%5s\n","아이템 이름","카테고리","가격");
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%d. %6s\t%4s\t%5s원\n",(i + 1) , list.get(i).getName(),list.get(i).getCategory(),list.get(i).getPrice());
		}
	}

	// 카테고리 출력
	public void PrintCategory() {
		System.out.println(" === 카테고리 ===");
		for (int i = 0; i < categorylist.size(); i++) {
			System.out.println((i + 1) + ". " + categorylist.get(i));
		}
	}

	// 구매내역 출력
	public void PrintCart() {
		int c = 1;
		System.out.println("구매자\t아이템 이름");
		for (int i = cartlist.size() - 1; i >= 0; i--) {
			System.out.println(cartlist.get(i).getUserId() + "\t" + cartlist.get(i).getItemName());
		}
	}

	// 새로운 아이템 추가
	public void NewItem(String name, String category, int price) {
		list.add(new Item(name, price, category));
		System.out.println("아이템 : " + name + " 카테고리 : " + category + " 가격 : " + price + "원 추가 완료");
	}
	//아이템 삭제
	public void DeleteItem(int idx) {
		if(list.size() == 1) {
			list.clear();
		}else {
			list.remove(idx);
		}
	}
	//회원 아이디별 카트 출력
	public void UserCartData(String userId) {
		for(int i = 0 ; i < list.size(); i++) {
			String s = list.get(i).getName() + "\t";
			int count = 0;
			int sum = 0;
			for(int i2 = 0 ; i2 < cartlist.size();i2++) {
				if(cartlist.get(i2).getUserId().equals(userId) && list.get(i).getName().equals(cartlist.get(i2).getItemName())) {
					count++;
					sum += list.get(i).getPrice();
				}
			}
			if(count != 0) {
				s += "구매 수량 : "+count +"\t 총금액 :"+sum+"원";
				System.out.println(s);
			}
		}
	}
}
