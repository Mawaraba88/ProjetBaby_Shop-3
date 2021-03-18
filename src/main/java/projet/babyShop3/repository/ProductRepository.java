package projet.babyShop3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projet.babyShop3.entity.Product;



public interface ProductRepository extends JpaRepository<Product, String> {
	
	
	/*public Page<Product>findByCode(String code);*/

	
}
    
	


