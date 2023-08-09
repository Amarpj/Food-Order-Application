package COM.TY.SpringBoot_FoodApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import COM.TY.SpringBoot_FoodApp.config.ResponseStructure;
import COM.TY.SpringBoot_FoodApp.dao.ProductDao;
import COM.TY.SpringBoot_FoodApp.dto.Product;
import COM.TY.SpringBoot_FoodApp.exception.UserIdNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductDao dao;
	
	public ResponseEntity<ResponseStructure<Product>> saveproduct(Product product) {
		ResponseStructure<Product> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("saved");
		responseStructure.setData(dao.saveProduct(product));
		return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.OK);

	}
	
	public ResponseEntity<ResponseStructure<Product>> updateproduct(int pid,Product product) {
		Product product2 = dao.updateproduct(pid, product);
		ResponseStructure<Product> responseStructure=new ResponseStructure<>();
		if(product2 !=null) {
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("updated");
			responseStructure.setData(product);	
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.CREATED);

		}else {
			throw new UserIdNotFoundException("user id not found");

		}
	}
	  public ResponseStructure<Product> deleteproduct(int pid) {
		Product product =dao.deleteproduct(pid);
		ResponseStructure<Product> responseStructure=new ResponseStructure<>();
		if(product !=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("deleted");
			responseStructure.setData(product);	
			return responseStructure;
		}else {
			throw new UserIdNotFoundException("user id not found");

		}
	}
	  public ResponseEntity<ResponseStructure<Product>> getproductbyid(int pid) {
		Product product = dao.getproductbyid(pid);
		ResponseStructure<Product> responseStructure=new ResponseStructure<>();
		if(product !=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("found");
			responseStructure.setData(product);	
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.FOUND);

		}else {
			throw new UserIdNotFoundException("user id not found");

		}
	}
	 
}
