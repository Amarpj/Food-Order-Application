package COM.TY.SpringBoot_FoodApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import COM.TY.SpringBoot_FoodApp.dto.Product;
import COM.TY.SpringBoot_FoodApp.repo.ProductRepo;

@Repository
public class ProductDao {

	@Autowired
	private ProductRepo repo;
	
	public Product saveProduct(Product product) {
		return repo.save(product);
	}
	
	public Product updateproduct(int pid, Product product) {
		Optional<Product> product2 = repo.findById(pid);
		if(product2.isPresent()) {
			product.setPid(pid);
			repo.save(product);
			return product2.get();
		}
		return null;
	}
	 public Product deleteproduct(int pid) {
		Optional<Product> product = repo.findById(pid);
		if(product.isPresent()) {
			repo.deleteById(pid);
			return product.get();
		}else {
			return null;
		}
	}
	 public Product getproductbyid(int pid) {
		Optional<Product> product=repo.findById(pid);
		if(product.isPresent()) {
			return product.get();
		}else {
			return null;
		}
	}
}
