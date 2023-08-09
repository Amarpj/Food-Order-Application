package COM.TY.SpringBoot_FoodApp.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class FoodOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fid;
	@NotNull(message = "foodorder name should not be null")
	private String fname;
	private String address;
	@Min(value = 6000000000l ,message="invalid phone")
	@Max(value = 9999999999l , message = "invalid phone")
	private long phone;
	private double totalprice;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Item> list;
}
