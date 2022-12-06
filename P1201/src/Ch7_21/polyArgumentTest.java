package Ch7_21;
class Product {
	int price;	//제품의 가격
	int bonusPoint;  // 제품 구매시 제공되는 보너스점수
	
	Product (int price){
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}
	Product() {} // 기본 생성자
}

class Tv extends Product {
	Tv() {
		super(100);
	}
	public String toString() {return "Tv";}
	
}
class Computer extends Product {
	Computer() {super(200);}
	
	public String toString() {return "Computer";}
}
class Audio extends Product {
	Audio() {super(200);}
	public String toString() {return "Audio";}
}
class Buyer {
	int money = 1000;
	int bonusPoint= 0;
	Product[] item = new Product[10];
	int i = 0;
	
	void Buy(Product p) {
		if(money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다");
			return;
		}
		money -=p.price;
		bonusPoint += p.bonusPoint;
		item[i++] = p;
		System.out.println(p + "을 구입하셧습니다,");
	}
	void summary() {
		int sum = 0;
		String itemList = "";
		
		for(int i=0; i<item.length; i++) {
			if(item[i] == null) break;
			sum += item[i].price;
			itemList += item[i] + " ,";
		}
		System.out.println("구입하신 물건의 총 금액은" + sum + "만원입니다");
		System.out.println("구입하신 제품은" + itemList + "입니다");
	}
}

public class polyArgumentTest {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		
		b.Buy(new Tv());
		b.Buy(new Computer());
		b.Buy(new Audio());
		b.summary();
		
//		b.Buy(new Tv());
//		b.Buy(new Computer());
//		
//		System.out.println("현재남은돈은 " + b.money + "만원입니다");
//		System.out.println("현재 보너스 점수는" + b.bonusPoint + "점입니다");

	}

}
