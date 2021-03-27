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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
import projet.babyShop3.model.GlobalData;
import projet.babyShop3.repository.CategoryRepository;
import projet.babyShop3.repository.ProductRepository;

@Controller

public class AdminController {
	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private CategoryRepository categoryRepo;


	@RequestMapping(value = { "/admin/login" }, method = RequestMethod.GET)
	public String login(Model model) {
		GlobalData.cart.clear();
		return "login";
	}

	@RequestMapping(value = { "/admin/accountInfo" }, method = RequestMethod.GET)
	public String accountInfo(Model model) {

		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(userDetails.getPassword());
		System.out.println(userDetails.getUsername());
		System.out.println(userDetails.isEnabled());

		model.addAttribute("userDetails", userDetails);
		return "accountInfo";
	}  



	// GET: Show product.// Insertion de nouveaux produits
	@RequestMapping(value = { "/product/new" }, method = RequestMethod.GET)
	public String product(Model model) {

		List<Category> listCategory = categoryRepo.findAll();
		model.addAttribute("product", new Product());
		model.addAttribute("listCategory", listCategory);

		return "product";// formulaire de saisie
	}


	// POST: Save product
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

		return "redirect:/products";

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
