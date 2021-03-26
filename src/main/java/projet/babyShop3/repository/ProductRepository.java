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

	/*
	 * public interface ProductRepository extends
	 * PagingAndSortingRepository<Product, String> {
	 * 
	 * 
	 * @Query("SELECT p FROM Product p WHERE " +
	 * "CONCAT(p.code, p.name, p.categroy, p.price)" + "LIKE %?1%") public
	 * Page<Product>findAll(String keyword, Pageable pageable);
	 * 
	 * 
	 * /*public Page<Product> findByName(String name, Pageable pageable); // POur
	 * une requête complexe;
	 * 
	 * @Query("select p from Product p where p.name like :x") public Page<Product>
	 * searchProduct(@Param("x") String motCle, Pageable pageable);
	 */

	// Méthode pour rechercher les produits par catégorie
	public Page<Product> findByNameContains(String name, Pageable pageable);
	// public Page<Product> findByIdCategory(String cat, Pageable pageable);

	@Query("SELECT p FROM Product p WHERE " + "CONCAT(p.code, p.name, p.price)" + "LIKE %?1%")
	public Page<Product> findAll(String keyword, Pageable pageable);
	
	 //public Page<Product> findAllProductByCategory(Category idCat, Pageable pageable); 
	 public List<Product> findAllProductByCategory(Category idCat); 
	 // Selectionner les produits par ID
	 

	/*
	 * //Selections des produits d'une categorie donnée
	 * 
	 * @Query("SELECT p FROM Product p WHERE  p.Category.idcategory LIKE %?1%")
	 * public Page<Product> searchProductByCategory(String idCat, Pageable
	 * pageable);
	 * 
	 */

	// Selections des produits d'une categorie donnée

	
	/*
	 * @Query("SELECT p FROM Product p WHERE p.category.idcategory LIKE %?1%")
	 * public Page<Product> searchProductByCategory(String idCat, Pageable
	 * pageable);
	 */
	  
	  //Pour rechercher un produit par le code
	
	public Optional<Product> findByCode(String code);
	  // Pour une requête complexe;
		
		/*
		 * @Query("select p from Product p where p.name like :x and p.category.idcategory like :y"
		 * ) public Page<Product> searchProductByCategory(@Param("x") String
		 * nameCat, @Param("y") Integer idCat, Pageable pageable);
		 */
		 
	 
}
