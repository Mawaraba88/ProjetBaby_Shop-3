package projet.babyShop3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projet.babyShop3.entity.Account;



public interface AccountRepository extends JpaRepository<Account, String> {

	Account findByUserName(String username);
	
	

}
