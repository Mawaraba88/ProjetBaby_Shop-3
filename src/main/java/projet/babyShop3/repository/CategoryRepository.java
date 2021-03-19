package projet.babyShop3.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import projet.babyShop3.entity.Category;



public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	/*public Page<Category> findByNameCategory(String mc);*/

}
