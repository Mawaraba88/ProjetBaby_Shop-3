package projet.babyShop3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import projet.babyShop3.entity.Category;
import projet.babyShop3.repository.CategoryRepository;


@Controller
public class CategoryController {
	
	@Autowired
	private CategoryRepository repo;
	@GetMapping("/category")
	public String listCategory(Model model) {
		List<Category> listCategory = repo.findAll();
		model.addAttribute("listCategory", listCategory);
		return "categories";
		
	}
	
	@GetMapping("/category/new")
	public String showCategoriesNewForm(Model model) {
		
		model.addAttribute("category", new Category());
		return "categories_form";
		
	}
	
	@PostMapping("/category/save")
	public String saveCategory(Category category) {
		repo.save(category);
		return "redirect:/categories";
	}
	
	
	

}
