package projet.babyShop3.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import projet.babyShop3.entity.Category;


@EnableJpaRepositories
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	public Page<Category> findByNameCategory(String nameCat, Pageable pageable);
	

}
