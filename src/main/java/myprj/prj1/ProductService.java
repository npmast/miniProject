package myprj.prj1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {
Map<String, Product> products = new HashMap<>();		// 객체들의 리스트
	
	public ProductService() {
		Product p = new Product("101","애플사과폰 12","애플전자",1200000,"2020.12.12");
		products.put("101", p);		
		p = new Product("102","삼성갤럭시폰 21","삼성전자",1300000,"2021.2.2");
		products.put("102", p);
		p = new Product("103","엘지듀얼폰","LG전자",1500000,"2021.3.2");
		products.put("103", p);
	}
	
	public List<Product> findAll() {					// Product 타입의 list 출력
		return new ArrayList<>(products.values());		// Map 객체의 values들을 list타입으로 변환하여 리턴한다.
	}
	
	public Product find(String id) {					// id를 Map에서 찾아서 key값을 리턴한다.
		return products.get(id);
	}
}

/*
 * Map<String, Object> tmap = new HashMap<>();
 * tmap.put("key", "value");
 * */
