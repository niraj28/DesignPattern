package walmart;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LoyalCustomer {
	/* * Given two list S1 (day1) and S2 (day2) having element as timestamp,
	 *  customer ID and SKU(productID) 
	 *  Find loyal customer satisfying below 
	 *  2 conditions Have visited site on both days. -> Map<Customer, integer> 
	 *  Have seen more than K unique SKUs. Map <customer, set<sku>> */
	public class Customer { 
		public int getCustomerId() 
		{ return customerId; } 
		public void setCustomerId(int customerId) 
		{ this.customerId = customerId; } 
		public Date getTimestamp() 
		{ return timestamp; } 
		public void setTimestamp(Date timestamp) 
		{ this.timestamp = timestamp; } 
		public int getSku() 
		{ return sku; } 
		public void setSku(int sku) 
		{ this.sku = sku; } 
		int customerId; 
		Date timestamp; 
		int sku; 
		}
	
	public List<Integer> loyalCustomer(List<Customer> s1, List<Customer> s2, int k) {

	    Map<Integer, Set<Integer>> customerSkuMap = new HashMap<>();

	    // Day 1: store customer -> unique SKUs
	    for (Customer c : s1) {
	        customerSkuMap
	            .computeIfAbsent(c.getCustomerId(), id -> new HashSet<>())
	            .add(c.getSku());
	    }

	    Set<Integer> result = new HashSet<>();

	    // Day 2: customer must exist in day1
	    for (Customer c : s2) {
	        if (customerSkuMap.containsKey(c.getCustomerId())) {

	            Set<Integer> skuSet = customerSkuMap.get(c.getCustomerId());
	            skuSet.add(c.getSku());

	            if (skuSet.size() > k) {
	                result.add(c.getCustomerId());
	            }
	        }
	    }

	    return new ArrayList<>(result);
	}
	
	public static void main(String[] args) {
	    LoyalCustomer lc = new LoyalCustomer();

	    List<Customer> s1 = new ArrayList<>();
	    List<Customer> s2 = new ArrayList<>();

	    Customer c1 = lc.new Customer();
	    c1.setCustomerId(1);
	    c1.setSku(101);
	    s1.add(c1);

	    Customer c2 = lc.new Customer();
	    c2.setCustomerId(1);
	    c2.setSku(102);
	    s1.add(c2);

	    Customer c3 = lc.new Customer();
	    c3.setCustomerId(2);
	    c3.setSku(201);
	    s1.add(c3);

	    Customer c4 = lc.new Customer();
	    c4.setCustomerId(1);
	    c4.setSku(103);
	    s2.add(c4);

	    Customer c5 = lc.new Customer();
	    c5.setCustomerId(2);
	    c5.setSku(201);
	    s2.add(c5);

	    Customer c6 = lc.new Customer();
	    c6.setCustomerId(3);
	    c6.setSku(301);
	    s2.add(c6);

	    int k = 2;

	    List<Integer> result = lc.loyalCustomer(s1, s2, k);

	    System.out.println(result); // [1]
	}
	
}
