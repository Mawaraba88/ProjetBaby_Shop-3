package projet.babyShop3.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import projet.babyShop3.entity.Category;
import projet.babyShop3.entity.Product;
import projet.babyShop3.model.GlobalData;
import projet.babyShop3.repository.CategoryRepository;
import projet.babyShop3.repository.ProductRepository;

@Controller
@Transactional
public class MainController {
	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private ProductRepository productRepo;

	List<Product> listProductCart = new ArrayList<>();


	@GetMapping("/")
	public String home(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "size", defaultValue = "4") int size
																		) {

		Page<Product> listProduct = productRepo.findByNameContains(name, PageRequest.of(page, size));
		model.addAttribute("listProduct", listProduct);
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("name", name);
		model.addAttribute("page", new int[listProduct.getTotalPages()]);
		  model.addAttribute("cartCount", GlobalData.cart.size());
		List<Category> listCategory = categoryRepo.findAll();
		model.addAttribute("listCategory", listCategory);
		

		return "index";
	}
	

	 // Liste des produits
	  
	  @GetMapping("/products")
	  public String listProducts(Model model,
			  @RequestParam(name="page", defaultValue="0") int page,
			  @RequestParam(name="name", defaultValue="") String name,
			  @RequestParam(name="size", defaultValue="4") int size) 
	  {
	  
		  Page<Product> listProduct = productRepo.findAll(name, PageRequest.of(page, size));
		  model.addAttribute("listProduct", listProduct);
		  model.addAttribute("currentPage", page);
		  model.addAttribute("size", size);
		  model.addAttribute("name",name);
		  model.addAttribute("page",new int [listProduct.getTotalPages()]);
		 
	  return "productList"; 
	  }

	// Controle des catégories
	@GetMapping("/category")
	public String listCategory(Model model) {
		List<Category> listCategory = categoryRepo.findAll();
		model.addAttribute("listCategory", listCategory);
	
		return "categories";

	}

	@GetMapping("/category/new")
	public String showCategoriesNewForm(Model model) {

		model.addAttribute("category", new Category());

		return "categories_form";
	}

	
	// POur les produits

	@PostMapping("/category/save")
	public String saveCategory(@ModelAttribute(name = "category") Category cat,
			@RequestParam("picture") MultipartFile multipartFile) throws IOException {

		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		cat.setPhoto(fileName);
		Category saveCat = categoryRepo.save(cat);
		String uploadDir = "./imageBabyShop/" + saveCat.getIdcategory();

		Path uploadPath = Paths.get(uploadDir);
		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		try (InputStream inputStream = multipartFile.getInputStream()) {
			Path filePath = uploadPath.resolve(fileName);
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			throw new IOException("Could not save upload file: " + fileName);
		}

		return "redirect:/category";

	}

	// Affichage des produits par catégory

	@GetMapping("/shop/category/{idCat}")
	public String showByCategory(Model model, @PathVariable Category idCat) {
		List<Product> listProduct = productRepo.findAllProductByCategory(idCat);
		model.addAttribute("listProduct", listProduct);

		List<Category> listCategory = categoryRepo.findAll();
		  model.addAttribute("cartCount", GlobalData.cart.size());
		model.addAttribute("listCategory", listCategory);

		return "index";

	}
	
	//Affichage des produits par ID
	@GetMapping("/shop/product/{code}")
	public String showViewProduct(Model model,
		@PathVariable String code
		 
			 ) {
		Product listProduct = productRepo.findByCode(code).get();
		  model.addAttribute("cartCount", GlobalData.cart.size());
		model.addAttribute("product", listProduct);

		return "productListView";

	}

	
	  @GetMapping("/buyProduct/{code}") public String addShopping(Model
	  model, @PathVariable("code") String code) { 
		  
		  
		  GlobalData.cart.add(productRepo.findByCode(code).get());
		  return "redirect:/shoppingCart";
			
	  } 
	  
	  @GetMapping("/shoppingCart")
	 public String cartGet(Model model) {
		  model.addAttribute("cartCount", GlobalData.cart.size());
		  model.addAttribute("total", GlobalData.cart.stream()
				.mapToDouble(Product::getPrice).sum());
		  model.addAttribute("cart", GlobalData.cart);
		  return "shoppingCart";
	  }

	  
	  @GetMapping("/cart/removeItem/{index}")
       public String cartItemRemove(@PathVariable int index) {
    	  GlobalData.cart.remove(index);
    	   return "redirect:/shoppingCart";
       }
	  
	  @GetMapping("/checkout")
	  public String checkout(Model model) {
		  model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
		  return "shoppingCartCustomer";
	  }
	  
	  @GetMapping("/payNow")
	  public String payNow() {
		  
		  
		  return "redirect:/shoppingCartFinalize";
	  }

}

