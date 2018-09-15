package com.example.demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.metamodel.SetAttribute;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

@Controller
public class OrderController {

	@Autowired
	OrderRepository orderRepository;

	@RequestMapping("/")
	public String home() {
		return "Home";
	}

	ModelAndView mv = new ModelAndView();
	Gson gson = new Gson();

	@RequestMapping("getAllOrders")
	public ModelAndView getAllOrders() {
		System.out.println("entered the get");

		java.util.List<Orders> orders = orderRepository.findAll();
		mv.setViewName("Display");
		mv.addObject("OrderDetails", orders);
		System.out.println("fetched daata");
		return mv;
	}

	@GetMapping("getAllOrder")
	@ResponseBody
	public java.util.List<Orders> getAllOrdersRest() {
		java.util.List<Orders> orders = orderRepository.findAll();
		return orders;
	}

	// Without usin SQL
	
	@RequestMapping("getAllOrderDetail")
	public ModelAndView getAllOrderDetail() throws Exception {
		System.out.println("enterd the getAllOrderDetail");
		BufferedReader br = new BufferedReader(new FileReader("OrderList.json"));
		Order order = gson.fromJson(br, Order.class);
		mv.setViewName("Display");
		mv.addObject("OrderDetails", order.getOrderList());
		System.out.println("fetched the getAllOrderDetail");
		return mv;
	}
	
	
	
	@RequestMapping("getTotalNoOfOrders")
	public ModelAndView getTotalNoOfOrders() throws Exception {
		
		int sum = 0;
		BufferedReader br = new BufferedReader(new FileReader("OrderList.json"));
			Order order = gson.fromJson(br, Order.class);

			List<OrderList> list = order.getOrderList();
			// Total no of orders
			int TotalNoOfOrders = list.size();
			//System.out.println("Total no of orders" + i);
			mv.setViewName("Display3");
			mv.addObject("OrderDetails",TotalNoOfOrders);
			return mv;
	}
	
	@RequestMapping("getTotalAmount")
	public ModelAndView getTotalAmount() throws Exception {
		
		int sum = 0;
		BufferedReader br = new BufferedReader(new FileReader("OrderList.json"));
			Order order = gson.fromJson(br, Order.class);

			List<OrderList> list = order.getOrderList();
			// TOtal amount of orders
			if (list != null) {
				for (OrderList ol : list) {
					sum = sum + ol.getAmount();
				}
			}
			//System.out.println("Total amount of orders = " + sum);
			mv.setViewName("Display3");
			mv.addObject("OrderDetails", sum);
			return mv;
	}
	
	@RequestMapping("getOneTimeOrder")
	public ModelAndView getOneTimeOrder() throws Exception {
		
		HashMap<String, Integer> hashMap = new HashMap<>();
	//	LinkedHashSet linkedHashSet = new LinkedHashSet();
		BufferedReader br = new BufferedReader(new FileReader("OrderList.json"));
			Order order = gson.fromJson(br, Order.class);
//
//			List<OrderList> list = order.getOrderList();
//			if (list != null) {
//				for (OrderList ol : list) {
//					linkedHashSet.add(ol.getName());
//				}
//			}
//			//System.out.println("ordered once +" + linkedHashSet);
//			//System.out.println("Total no of orders =" + linkedHashSet.size());
//			mv.setViewName("Display3");
//			mv.addObject("OneTimeOrder", linkedHashSet);
//			return mv;
		List<OrderList> list = order.getOrderList();
		if (list != null) {
			for (OrderList ol : list) {
				if (hashMap.containsKey(ol.getName())) {
					hashMap.put(ol.getName(), hashMap.get(ol.getName()) + 1);
				} else {
					hashMap.put(ol.getName(), 1);
				}		
			}
		}
		Map<Integer, Integer> map=new HashMap<>();
		System.out.println("Size of the Hash map in one costomer =" + hashMap.size());
			Set<String> keySet = hashMap.keySet();
			Iterator<String> keySetIterator = keySet.iterator();
			while (keySetIterator.hasNext()) {
			   String key = keySetIterator.next();
			   if (map.containsKey(hashMap.get(key))) {
					map.put(hashMap.get(key), map.get(hashMap.get(key)) + 1);
				} else {
					map.put(hashMap.get(key), 1);
				}
			}

		System.out.println("Size of the Hash map in one costomer =" + hashMap.size());
		//System.out.println("Name By orders = " + hashMap);
		mv.setViewName("Display4");
		mv.addObject("OrderDetails", map);
		return mv;	
	}

	@RequestMapping("getNameByOrders")
	public ModelAndView orderByName() {
		
		HashMap<String, Integer> hashMap = new HashMap<>();
		int sum = 0;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("OrderList.json"));
			Order order = gson.fromJson(br, Order.class);

			List<OrderList> list = order.getOrderList();
			if (list != null) {
				for (OrderList ol : list) {
					if (hashMap.containsKey(ol.getName())) {
						hashMap.put(ol.getName(), hashMap.get(ol.getName()) + 1);
					} else {
						hashMap.put(ol.getName(), 1);
					}
				}
			}
			
			System.out.println("Size of the Hash map =" + hashMap.size());
			Set<Entry<String, Integer>> set = hashMap.entrySet();
	        List<Entry<String, Integer>> entrylist = new ArrayList<Entry<String, Integer>>(set);
	                
	        Collections.sort(entrylist, new Comparator<Map.Entry<String, Integer>>() {
	            public int compare(Map.Entry<String, Integer> value1,
	                    Map.Entry<String, Integer> value2) {
	                return value1.getValue().compareTo(value2.getValue());
	            }
	        });
			//System.out.println("Name By orders = " + hashMap);
			mv.setViewName("Display2");
			mv.addObject("OrderDetails", entrylist);
			
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}		
		
		finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return mv;
	}
	
	@RequestMapping("getNameOfOneTime")
	public ModelAndView getNameOfOneTimeOrder() throws Exception {
		
		Map<String, Integer> hashMap = new HashMap<>();
		BufferedReader br = new BufferedReader(new FileReader("OrderList.json"));
			Order order = gson.fromJson(br, Order.class);
		List<OrderList> list = order.getOrderList();
		if (list != null) {
			for (OrderList ol : list) {
				if (hashMap.containsKey(ol.getName())) {
					hashMap.put(ol.getName(), hashMap.get(ol.getName()) + 1);
				} else {
					hashMap.put(ol.getName(), 1);
				}		
			}
		}
		Set<String> keySet = hashMap.keySet();
		Iterator<String> keySetIterator = keySet.iterator();
		while (keySetIterator.hasNext()) {
		String key = keySetIterator.next();
		if (hashMap.get(key)>=2) {
			keySetIterator.remove();
		}
		}
		System.out.println("Total Number of Customers Ordered Once =" + hashMap.size());
		mv.setViewName("Display2");
		mv.addObject("OrderDetails", hashMap);
		return mv;	
	}
}
