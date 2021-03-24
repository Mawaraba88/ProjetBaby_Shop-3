package projet.babyShop3.repository;





import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projet.babyShop3.entity.Product;



public interface ProductRepository extends JpaRepository<Product, String> {
	
	
	/*
	public interface ProductRepository extends PagingAndSortingRepository<Product, String> {
	

	@Query("SELECT p FROM Product p WHERE " + "CONCAT(p.code, p.name, p.categroy, p.price)" + "LIKE %?1%")
	public Page<Product>findAll(String keyword, Pageable pageable);
	*/

	/*public Page<Product> findByName(String name, Pageable pageable);
	// POur une requête complexe;
	@Query("select p from Product p where p.name like :x and p.category.idcategory like :y")
	public Page<Product> searchProduct(@Param("x") String motCle, @Param("y") Integer id, Pageable pageable);
	

	
}
    
	


