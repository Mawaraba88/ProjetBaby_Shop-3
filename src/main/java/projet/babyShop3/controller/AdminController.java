package projet.babyShop3.controller;


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import projet.babyShop3.entity.Category;
import projet.babyShop3.entity.Product;
import projet.babyShop3.repository.CategoryRepository;
import projet.babyShop3.repository.ProductRepository;

@Controller
//@Transactional
public class AdminController {
	@Autowired
	private ProductRepository productRepo;
	//private ProductService productService;
	@Autowired
	private CategoryRepository categoryRepo;
	
	
	   @RequestMapping(value = { "/admin/login" }, method = RequestMethod.GET)
	   public String login(Model model) {
	 
	      return "login";
	   }
	   
		
	// GET: Show product.// Insertion de nouveaux produits
	   @RequestMapping(value = { "/product/new" }, method = RequestMethod.GET)
	   public String product(Model model) {
	      /*ProductForm productForm = null;
	 
	      if (code != null && code.length() > 0) {
	         Product product = productDAO.findProduct(code);
	         if (product != null) {
	            productForm = new ProductForm(product);
	         }
	      }
	      if (productForm == null) {
	         productForm = new ProductForm();
	         productForm.setNewProduct(true);
	      }
	      model.addAttribute("productForm", productForm);*/
		   List<Category> listCategory = categoryRepo.findAll();
			model.addAttribute("product", new Product());
			model.addAttribute("listCategory", listCategory);
			
	      return "product";// formulaire de saisie
	   }
	   
		
		  
		 
		/*
		 * // POST: Save product
		 * 
		 * @RequestMapping(value = { "/admin/product" }, method = RequestMethod.POST)
		 * public String productSave(Model model, //
		 * 
		 * @ModelAttribute("productForm") @Validated ProductForm productForm, //
		 * BindingResult result, // final RedirectAttributes redirectAttributes) {
		 * 
		 * if (result.hasErrors()) { return "product"; } try {
		 * productDAO.save(productForm); } catch (Exception e) { Throwable rootCause =
		 * ExceptionUtils.getRootCause(e); String message = rootCause.getMessage();
		 * model.addAttribute("errorMessage", message); // Show product form. return
		 * "product"; }
		 * 
		 * return "redirect:/productList"; }
		 */
	   
		
	
	// POST: Save product
		//@PostMapping("/admin/product")
		@PostMapping("/products/save")
		public String saveProduct(@ModelAttribute (name = "product") Product p, 
				RedirectAttributes ra,
				@RequestParam("picture")MultipartFile multipartFile)throws IOException {
			
			String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
			p.setImage(fileName);
			
			 Product savePro = productRepo.save(p);
			
			 String uploadDir = "./imageBabyShop/" + savePro.getCode();
			 
			 Path uploadPath = Paths.get(uploadDir);
			 if(!Files.exists(uploadPath)) {
				 Files.createDirectories(uploadPath);
			 }
			 try (InputStream inputStream = multipartFile.getInputStream()){
				 Path filePath = uploadPath.resolve(fileName);
				 Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
			 }catch(IOException e) {
				 throw new IOException("Could not save upload file: " + fileName);
			 }
			
			ra.addFlashAttribute("message", "Ajout reussi");
			//productRepo.add("listProduct", listProduct);
			return "redirect:/products";
			
		}
		
		 // Liste des produits
		  
		  @GetMapping("/products")
		  public String listProducts(Model model,
				  @RequestParam(name="page", defaultValue="0") int page,
				  @RequestParam(name="name", defaultValue="") String name,
				  @RequestParam(name="size", defaultValue="2") int size) 
		  {
		  
			  Page<Product> listProduct = productRepo.findAll(name, PageRequest.of(page, size));
			  model.addAttribute("listProduct", listProduct);
			  model.addAttribute("currentPage", page);
			  model.addAttribute("size", size);
			  model.addAttribute("name",name);
			  model.addAttribute("page",new int [listProduct.getTotalPages()]);
			  
				/*
				 * List<Product> listProduct = productRepo.findAll();
				 * model.addAttribute("listProduct", listProduct);
				 */
		  
		  return "productList"; 
		  }
	
	
		
		  @GetMapping("products/edit/{code}") public String
		  showEditProductForm(@PathVariable("code") String code, Model model, RedirectAttributes ra) {
		  
		  Product product = productRepo.findById(code).get();
		  model.addAttribute("product", product);
		  List<Category> listCategory = categoryRepo.findAll();
			model.addAttribute("listCategory", listCategory);
			ra.addFlashAttribute("message", "Vos modifications ont été prises en compte");
		
		  return "product";
		  
		  }
		  
		  
		  @GetMapping("products/delete/{code}") public String
		  deleteProduct(@PathVariable("code") String code, Model model) {
		  productRepo.deleteById(code);
		  
		  return "redirect:/products";
		  }
		 
		
		
	
}
