package projet.babyShop3.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import projet.babyShop3.repository.CategoryRepository;
import projet.babyShop3.repository.OrderRepository;
import projet.babyShop3.repository.ProductRepository;




@Controller
@Transactional
public class AdminController {
	
	  @Autowired
	  private CategoryRepository categoryrepo;
		
	  @Autowired
	  private ProductRepository productRepo;
		
	  @Autowired
	  private OrderRepository orderRepo;
	  
	
	   @RequestMapping(value = { "/admin/login" }, method = RequestMethod.GET)
	   public String login(Model model) {
	 
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
	   
		/*
		 * // POST: Save category
		 * 
		 * @RequestMapping(value = { "/category" }, method = RequestMethod.POST) public
		 * String categorySave(Model model, //
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
}
