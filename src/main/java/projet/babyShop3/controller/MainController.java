package projet.babyShop3.controller;




import java.io.File;
import java.io.FileInputStream;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import projet.babyShop3.entity.Category;
import projet.babyShop3.repository.CategoryRepository;

@Controller
@Transactional
public class MainController {
	@Autowired
	private CategoryRepository repo;
	//private ProductRepository productRepo;
	
	@Value("${dir.images}")
	private String dirImage;
	
	
	@GetMapping("/")
	   public String home(Model model/*, //
		         @RequestParam(value = "name", defaultValue = "") String likeName,
		         @RequestParam(value = "page", defaultValue = "1")int page,
		         @RequestParam(value = "size", defaultValue = "4") int size*/) {
		
		
		List<Category> listCategory = repo.findAll();
		model.addAttribute("listCategory", listCategory);
		/*Page<Category> listCategory = repo.findByNameCategory(likeName, PageRequest.of(page, size));
		model.addAttribute("listCategory", listCategory);
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("likename", likeName);
		model.addAttribute("pages", new int[listCategory.getTotalPages()]);*/
	   
	      return "index";
	   }
	
	//Controle des catégories
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
	// Methode pour recuprer la photo
	//@RequestMapping(value="/getPhoto", produces=MediaType.IMAGE_JPEG_VALUE)
	//@ResponseBody
	/*public byte[] getPhoto(Long id) {
		File f = new File(dirImage+id);
	
		
		
	}*/
	

}
