package projet.babyShop3.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet.babyShop3.entity.Product;



public interface ProductRepository extends JpaRepository<Product, String> {

	public Page<Product> findByName(String name, Pageable pageable);
	// POur une requête complexe;
	@Query("select p from Product p where p.name like :x and p.category.idcategory like :y")
	public Page<Product> searchProduct(@Param("x") String motCle, @Param("y") Integer id, Pageable pageable);
	
	
}
    
	


