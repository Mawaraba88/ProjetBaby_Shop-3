package projet.babyShop3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import projet.babyShop3.entity.Category;
import projet.babyShop3.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

	

	@Query("SELECT p FROM Product p WHERE " + "CONCAT(p.code, p.name, p.price)" + "LIKE %?1%")
	public Page<Product> findByNameContains(String keyword, Pageable pageable);
	@Query("SELECT p FROM Product p WHERE " + "CONCAT(p.code, p.name, p.price)" + "LIKE %?1%")
	public Page<Product>findAll(String name, Pageable pageable);
	

	 public List<Product> findAllProductByCategory(Category idCat); 
	 
	  //Pour rechercher un produit par le code
	
	public Optional<Product> findByCode(String code);
	
	 
}
