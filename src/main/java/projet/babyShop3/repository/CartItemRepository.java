
  package projet.babyShop3.repository;
  
  import java.util.List;
  
  import org.springframework.data.jpa.repository.JpaRepository; import
  org.springframework.stereotype.Repository;
  
  import projet.babyShop3.entity.Account;
  import projet.babyShop3.entity.CartItem;
  
  @Repository public interface CartItemRepository extends
  JpaRepository<CartItem, Integer> {
	  public List<CartItem>findByAccount(Account account);
  
  }
 
 