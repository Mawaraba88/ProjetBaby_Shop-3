package projet.babyShop3.repository;





import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet.babyShop3.entity.Product;



public interface ProductRepository extends JpaRepository<Product, String> {
	
	
	/*
	public interface ProductRepository extends PagingAndSortingRepository<Product, String> {
	

	@Query("SELECT p FROM Product p WHERE " + "CONCAT(p.code, p.name, p.categroy, p.price)" + "LIKE %?1%")
	public Page<Product>findAll(String keyword, Pageable pageable);
	

	/*public Page<Product> findByName(String name, Pageable pageable);
	// POur une requête complexe;
	@Query("select p from Product p where p.name like :x")
	public Page<Product> searchProduct(@Param("x") String motCle, Pageable pageable);*/
	
	//Méthode pour rechercher les produits par catégorie
	public Page<Product> findByNameContains(String name, Pageable pageable);
	//public Page<Product> findByIdCategory(String cat, Pageable pageable);
	


	@Query("SELECT p FROM Product p WHERE " + "CONCAT(p.code, p.name, p.category.idcategory, p.price)" + "LIKE %?1%")
	public Page<Product>findAll(String keyword, Pageable pageable);

	
	  //Selections des produits d'une categorie donnée
	  
	  @Query("SELECT p FROM Product p WHERE  p.category.idcategory LIKE %?1%")
	  public Page<Product> searchProductByCategory(String idCat, Pageable pageable);
	 
	
}
    
	


