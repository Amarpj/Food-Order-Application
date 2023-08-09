package COM.TY.SpringBoot_FoodApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import COM.TY.SpringBoot_FoodApp.dto.User;

public interface UserRepo extends JpaRepository<User, Integer> 
{

}
