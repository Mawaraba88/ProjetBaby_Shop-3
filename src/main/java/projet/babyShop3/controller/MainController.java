package projet.babyShop3.controller;




import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import projet.babyShop3.entity.Category;
import projet.babyShop3.repository.CategoryRepository;
import projet.babyShop3.repository.ProductRepository;
import projet.babyShop3.validator.FileUploadUtil;

@Controller
@Transactional
public class MainController {
	@Autowired
	private CategoryRepository categoryrepo;
	@Autowired
	private ProductRepository productRepo;
	
	/*
	 * @Value("${dir.images}") private String dirImage;
	 */
	
	
	@GetMapping("/")
	   public String home(Model model/*, //
		         @RequestParam(value = "name", defaultValue = "") String likeName,
		         @RequestParam(value = "page", defaultValue = "1")int page,
		         @RequestParam(value = "size", defaultValue = "4") int size*/) {
		
		
		List<Category> listCategory = categoryrepo.findAll();
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
		List<Category> listCategory = categoryrepo.findAll();
		model.addAttribute("listCategory", listCategory);
		return "categories";
		
	}
	
	@GetMapping("/category/new")
	public String showCategoriesNewForm(Model model) {
		
		model.addAttribute("category", new Category());
		return "categories_form";	
	}
	
	@PostMapping("/category/save")
	public RedirectView saveCategory(Category cat, 
			@RequestParam("picture")MultipartFile multipartFile)throws IOException {
		
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		cat.setPhoto(fileName);
		 Category saveCat = categoryrepo.save(cat);
		 String uploadDir = "imageBabyShop/" + saveCat.getIdcategory();
		 FileUploadUtil.saveFile(uploadDir,fileName, multipartFile );
		 
		  return new RedirectView("/", true);
		 
		
		
		
	}
	
	
}

	/*
	 * @PostMapping("/category/save") public String saveCategory(@Valid Category
	 * category, BindingResult bindingResult,
	 * 
	 * @RequestParam(name="picture")MultipartFile file) throws
	 * IllegalStateException, IOException { if(bindingResult.hasErrors()) return
	 * "categories_form";
	 * 
	 * if(!(file.isEmpty())) { //Pour stocker le nom originale de la base de données
	 * category.setPhoto(file.getOriginalFilename());} categoryrepo.save(category);
	 * if(!(file.isEmpty())) { category.setPhoto(file.getOriginalFilename());
	 * file.transferTo(new File(dirImage+category.getIdcategory())); }
	 * 
	 * 
	 * //categoryrepo.save(category); return "redirect:index"; }
	 */
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
	/*@RequestMapping(value = { "/categoryImage" }, method = RequestMethod.GET)
	   public void categoryImage(HttpServletRequest request, HttpServletResponse response, Model model,
	         @RequestParam("idCategory") Integer idCategory) throws IOException {
	     Category category = null;
	      if (idCategory != null) {
	    	  category = this.repo.findCategory(idCategory);
	      }
	      if (category != null && category.getPhoto() != null) {
	         response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	         //response.encodeRedirectURL(category.getPhoto());
	         //getOutputStream().write(0);
	         response.getOutputStream().write(category.getPhoto());
	      }
	      response.getOutputStream().close();
	   }*/
	


