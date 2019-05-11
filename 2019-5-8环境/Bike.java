
//自行车类，用来创建自行车的蓝图
public class Bike {
	int level=0;	//档位
	int speed=0;	//当前速度
	
	//获取当前档位
	int getLevel(){
		return level;
	}
	
	//获取当前速度
	int getSpeed(){
		return speed;
	}
	
	//加档
	void addLevel(){
		if(level<6){
			level++;
		}
	}
	
	//用力蹬
	void addSpeed(){
		if(speed<100){
			speed+=10;
		}
	}
	
	public static void main(String[] args){
		Bike bike1 = new Bike();
		//bike1就是对象，是真正的自行车
		Bike bike2 = new Bike();
		//bike2也是对象，是另一辆自行车
		
		bike1.addSpeed();
		System.out.println(bike1.getSpeed());
		System.out.println(bike2.getSpeed());
		
	}
}