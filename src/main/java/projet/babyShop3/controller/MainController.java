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
	private double totalPrice = 0;

	@GetMapping("/")
	   public String home(Model model/*, //
		         @RequestParam(value = "name", defaultValue = "") String likeName,
		         @RequestParam(value = "page", defaultValue = "1")int page,
		         @RequestParam(value = "size", defaultValue = "4") int size*/) {
		
		
		List<Category> listCategory = categoryRepo.findAll();
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
		List<Category> listCategory = categoryRepo.findAll();
		model.addAttribute("listCategory", listCategory);
		return "categories";
		
	}
	
	@GetMapping("/category/new")
	public String showCategoriesNewForm(Model model) {
		
		model.addAttribute("category", new Category());
		return "categories_form";	
	}
	
	

	 // Liste des produits par catégorie
	  
	  @GetMapping("productsByCategory/{idcategory}")
	  public String listProductsByCategory(Model model,
			  @RequestParam(name="page", defaultValue="0") int page,
			  @RequestParam(name="name", defaultValue="") String name,
			  @RequestParam(name="size", defaultValue="2") int size,
			  @RequestParam(name="idCat", defaultValue="") Integer idcategory) 
	  {
	  
		  Page<Product> listProduct = productRepo.searchProductByCategory(name,idcategory, PageRequest.of(page, size));
		  model.addAttribute("listProduct", listProduct);
		  model.addAttribute("currentPage", page);
		  model.addAttribute("size", size);
		  model.addAttribute("name",name);
		  model.addAttribute("idcategory",idcategory);
		  model.addAttribute("page",new int [listProduct.getTotalPages()]);
		  
			/*
			 * List<Product> listProduct = productRepo.findAll();
			 * model.addAttribute("listProduct", listProduct);
			 */
	  
	  return "productListByCategory"; 
	  }

	//Pour faire la validation avec l'annotation @Valid, on ajoute l'attribut BindingResult
	
	/*
	 * @PostMapping("/category/save") public String saveCategory( @ModelAttribute
	 * (name = "category") Category cat, BindingResult bindingResult,
	 * 
	 * @RequestParam("picture")MultipartFile multipartFile)throws IOException {
	 * 
	 * String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
	 * cat.setPhoto(fileName);
	 * 
	 * //condition de verification si les paramètre de validation sont ok
	 * if(bindingResult.hasErrors()) { return "categories_form"; } Category saveCat
	 * = categoryRepo.save(cat); String uploadDir = "./imageBabyShop/" +
	 * saveCat.getIdcategory();
	 * 
	 * Path uploadPath = Paths.get(uploadDir); if(!Files.exists(uploadPath)) {
	 * Files.createDirectories(uploadPath); } try (InputStream inputStream =
	 * multipartFile.getInputStream()){ Path filePath =
	 * uploadPath.resolve(fileName); Files.copy(inputStream, filePath,
	 * StandardCopyOption.REPLACE_EXISTING); }catch(IOException e) { throw new
	 * IOException("Could not save upload file: " + fileName); }
	 * //FileUploadUtil.saveFile(uploadDir,fileName, multipartFile );
	 * 
	 * return "redirect:/category";
	 * 
	 * }
	 */
	
	// POur les produits
	
	



	/*
	 * @GetMapping("/category") public String listCategory(Model model , //
	 * 
	 * @RequestParam(value = "name", defaultValue = "") String name,
	 * 
	 * @RequestParam(value = "page", defaultValue = "0")int page,
	 * 
	 * @RequestParam(value = "size", defaultValue = "4") int size) {
	 * 
	 * 
	 * 
	 * List<Category> listCategory = categoryRepo.findAll();
	 * model.addAttribute("listCategory", listCategory);
	 * 
	 * 
	 * Page<Category> listCategory = categoryRepo.findByNameCategory(name,
	 * PageRequest.of(page, size)); model.addAttribute("listCategory",
	 * listCategory); model.addAttribute("currentPage", page);
	 * model.addAttribute("size", size); model.addAttribute("name", name);
	 * model.addAttribute("pages", new int[listCategory.getTotalPages()]);
	 * 
	 * return "categories"; }
	 */
	

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
		// FileUploadUtil.saveFile(uploadDir,fileName, multipartFile );

		return "redirect:/category";

	}
	
	//Pour le panier
	// Ajout panier
	
	/*
	 * @RequestMapping("/buyProduct") public String addShopping(HttpServletRequest
	 * request, Model model,
	 * 
	 * @RequestParam(value = "code", defaultValue = "") String code) { if(code !=
	 * null) { Product productCart = productRepo.getOne(code);
	 * listProductCart.add(productCart);
	 * 
	 * totalPrice = totalPrice + productCart.getPrice();
	 * 
	 * model.addAttribute("listProductCart", listProductCart);
	 * model.addAttribute("totalPrice", totalPrice);
	 * 
	 * return "shoppingCart"; } else {
	 * 
	 * model.addAttribute("listProductCart", listProductCart);
	 * model.addAttribute("totalPrice", totalPrice);
	 * 
	 * return "shoppingCart";
	 * 
	 * } }
	 */
	 
	
	
	
	  @GetMapping("/buyProduct/{code}") 
	  public String addShopping(Model model, @PathVariable("code")String
	  code) { if(code != null)
	  
	  { Product productCart = productRepo.getOne(code);
	  listProductCart.add(productCart);
	  
	  totalPrice = totalPrice + productCart.getPrice();
	  
	  model.addAttribute("listProductCart", listProductCart);
	  model.addAttribute("totalPrice", totalPrice);
	  
	  return "shoppingCart"; } else {
	  
	  model.addAttribute("listProductCart", listProductCart);
	  model.addAttribute("totalPrice", totalPrice);
	  
	  return "shoppingCart";
	  
	  } }
	 
	  //Suppression produit du panier
	  
		/*
		 * @RequestMapping("/shoppingCartRemoveProduct") public String
		 * removeProductHandler(HttpServletRequest request, Model model,
		 * 
		 * @RequestParam(value = "code", defaultValue = "") String code) {
		 * 
		 * for (int i = 0; i < listProductCart.size(); i++) { if(code ==
		 * listProductCart.get(i).getCode()) { totalPrice = totalPrice -
		 * listProductCart.get(i).getPrice(); listProductCart.remove(i); }
		 * 
		 * } model.addAttribute("listProductCart", listProductCart);
		 * model.addAttribute("totalPrice", totalPrice);
		 * 
		 * return "shoppingCart"; }
		 */
		 
	  
		/*
		 * @GetMapping("/shoppingCartRemoveProduct") public String removeProductHandler(
		 * Model model,
		 * 
		 * String code) {
		 * 
		 * for (int i = 0; i < listProductCart.size(); i++) { if(code ==
		 * listProductCart.get(i).getCode()) { totalPrice = totalPrice -
		 * listProductCart.get(i).getPrice(); listProductCart.remove(i); }
		 * 
		 * } model.addAttribute("listProductCart", listProductCart);
		 * model.addAttribute("totalPrice", totalPrice);
		 * 
		 * return "shoppingCart"; }
		 */
	 
	
}

	// POur les produits

	// Liste des produits par category

	/*
	 * @GetMapping("/category") public String listProductsByCategory(Model model,
	 * 
	 * @RequestParam(name="page", defaultValue="0") int page,
	 * 
	 * @RequestParam(name="name", defaultValue="") String cat,
	 * 
	 * @RequestParam(name="size", defaultValue="2") int size) {
	 * 
	 * Page<Product> listProduct = productRepo.searchProductByCategory(cat,
	 * PageRequest.of(page, size)); model.addAttribute("listProduct", listProduct);
	 * model.addAttribute("currentPage", page); model.addAttribute("size", size);
	 * model.addAttribute("name",cat); model.addAttribute("page",new int
	 * [listProduct.getTotalPages()]);
	 * 
	 * 
	 * List<Product> listProduct = productRepo.findAll();
	 * model.addAttribute("listProduct", listProduct);
	 * 
	 * 
	 * return "productList"; }
	 */



// POur les l'achat

// Methode pour recuprer la photo
/*
 * @RequestMapping(value="/categoryImage", produces=MediaType.IMAGE_JPEG_VALUE)
 * 
 * public byte[] getPhoto(Integer id) { File f = new File()); return
 * 
 * 
 * 
 * }
 */
/*
 * @RequestMapping(value = { "/categoryImage" }, method = RequestMethod.GET)
 * public void categoryImage(HttpServletRequest request, HttpServletResponse
 * response, Model model,
 * 
 * @RequestParam("idCategory") Integer idCategory) throws IOException { Category
 * category = null; if (idCategory != null) { category =
 * this.repo.findCategory(idCategory); } if (category != null &&
 * category.getPhoto() != null) {
 * response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
 * //response.encodeRedirectURL(category.getPhoto());
 * //getOutputStream().write(0);
 * response.getOutputStream().write(category.getPhoto()); }
 * response.getOutputStream().close(); }
 */
