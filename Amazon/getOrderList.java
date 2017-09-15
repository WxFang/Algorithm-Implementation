package amazon;

import java.util.*;

public class getOrderList {

	static class Order{
		String order = "";
		public Order(String string){
			this.order = string;
		}
	}
	
	static class OrderDependency{
		Order cur;
		Order pre;
		public OrderDependency(Order o1, Order o2){
			this.cur = o1;
			this.pre = o2;
		}
	}
	
	public static List<Order> _getOrderList(List<OrderDependency> list){
		List<Order> res = new ArrayList<>();
		
		Map<Order, ArrayList<Order>> map = new HashMap<>();
		Map<Order, Integer> inMap = new HashMap<>();
		Set<Order> set = new HashSet<>();
		for(OrderDependency od: list){
			Order cur = od.cur;
			Order pre = od.pre;
			set.add(cur);
			set.add(pre);
			inMap.put(cur, inMap.getOrDefault(cur, 0) + 1);
			if(!inMap.containsKey(pre)) inMap.put(pre, 0);
			if(map.containsKey(pre)) map.get(pre).add(cur);
			else{
				map.put(pre, new ArrayList<>());
				map.get(pre).add(cur);
			}
			if(!map.containsKey(cur)) map.put(cur, new ArrayList<Order>());
		}
		
		Queue<Order> q = new LinkedList<>();
		
		for(Order od: inMap.keySet())
			if(inMap.get(od) == 0)
				q.offer(od);
		
		while(!q.isEmpty()){
			Order order = q.poll();
			res.add(order);
			for(Order temp: map.get(order)){
				inMap.put(temp, inMap.get(temp) - 1);
				if(inMap.get(temp) == 0) 
					q.offer(temp);
			}
		}
		
		if(res.size() != set.size()) return new ArrayList<Order>();
		return res;
	}
	
    public static void main(String[] args) {
        Order o1 = new Order("A");
        Order o2 = new Order("B");
        Order o3 = new Order("C");
        Order o4 = new Order("D");
        OrderDependency od1 = new OrderDependency(o1, o2);
        OrderDependency od2 = new OrderDependency(o2, o3);
        OrderDependency od3 = new OrderDependency(o3, o1);
        List<OrderDependency> list = new ArrayList<>();
        list.add(od1);
        list.add(od2);
        list.add(od3);

        for (Order o : _getOrderList(list)){
            System.out.println(o.order);
        }
    }
}
