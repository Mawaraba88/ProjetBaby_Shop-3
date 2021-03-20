package projet.babyShop3.repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import projet.babyShop3.entity.Category;


@EnableJpaRepositories
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	public List<Category> findByNameCategory(String nameCat);

}
