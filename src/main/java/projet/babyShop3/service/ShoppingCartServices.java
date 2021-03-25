
  package projet.babyShop3.service;
  
  import java.util.List;
  
  import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.stereotype.Service;
  
  import projet.babyShop3.entity.Account; import
  projet.babyShop3.entity.CartItem; import
  projet.babyShop3.repository.CartItemRepository;
  
  
  @Service public class ShoppingCartServices {
  
  
  @Autowired private CartItemRepository cartRepo;
  
  public List<CartItem> listCartItems(Account account){ return
  cartRepo.findByAccount(account); }
  
  
  }
 