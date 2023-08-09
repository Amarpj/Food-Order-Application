package COM.TY.SpringBoot_FoodApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import COM.TY.SpringBoot_FoodApp.dto.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> 
{

}
