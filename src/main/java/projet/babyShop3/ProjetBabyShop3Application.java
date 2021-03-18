package projet.babyShop3;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import projet.babyShop3.entity.Account;
import projet.babyShop3.entity.Category;
import projet.babyShop3.entity.Product;
import projet.babyShop3.repository.AccountRepository;
import projet.babyShop3.repository.CategoryRepository;
import projet.babyShop3.repository.ProductRepository;

@SpringBootApplication
public class ProjetBabyShop3Application implements CommandLineRunner {
	
	
	@Autowired
	private AccountRepository accountRepo;
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	

	public static void main(String[] args) {
		SpringApplication.run(ProjetBabyShop3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Insertion des données Account
				accountRepo.save(new Account("Mawaraba",true, "$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu", "ROLE_EMPLOYEE"));
				accountRepo.save(new Account("Fatoumata", true, "$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu", "ROLE_EMPLOYEE"));
				accountRepo.save(new Account("Alexandre",true, "$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu", "ROLE_EMPLOYEE"));
				accountRepo.save(new Account("Admin",true ,"$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu", "ROLE_MANAGER"));
				
			//Insertion des caétogoires
				
				categoryRepo.save(new Category("Chambre", "https://zupimages.net/viewer.php?id=21/11/aqpr.jpg"));
				categoryRepo.save(new Category("Sortie", "https://zupimages.net/viewer.php?id=21/11/neoo.jpg"));
				categoryRepo.save(new Category("Repas", "https://zupimages.net/viewer.php?id=21/11/wgm5.jpg"));
				categoryRepo.save(new Category("Eveil", "https://zupimages.net/viewer.php?id=21/11/3oy9.jpg"));
				
				
				/*productRepo.save(new Product("C001", "Lit", 100,new Date(),(new Category(1))));
				productRepo.save(new Product("C002", "Commodes", 100,"https://zupimages.net/viewer.php?id=21/11/m16d.jpg",new Date(),(new Category(1))));
				productRepo.save(new Product("C003", "Plan à langer", 100,new Date(),(new Category(1))));
				productRepo.save(new Product("C004", "Linge et parrures de lit", 100,(new Date()),(new Category(1))));*/
				productRepo.save(new Product("C005", "Décoration", 100, "https://zupimages.net/viewer.php?id=21/11/tpyh.jpg",(new Date()), new Category(1)));
				//productRepo.save(new Product("C006", "Matelas", 100,new Date(),(new Category(1))));
				productRepo.save(new Product("C007", "Berceaux et couffins", 100,"https://zupimages.net/viewer.php?id=21/11/bf2b.jpg",new Date(),(new Category(1))));
				productRepo.save(new Product("C008", "Coffre à jouet", 100, "https://zupimages.net/viewer.php?id=21/11/ed5p.jpg",new Date(),(new Category(1))));
				/*productRepo.save(new Product("C009", "Securité", 100,new Date(),(new Category(1))));
				productRepo.save(new Product("C007", "Gigoteuse", 100,"https://zupimages.net/viewer.php?id=21/11/o455.jpg",new Date(),(new Category(1))));
				
				productRepo.save(new Product("S001", "Poussette", 100,new Date(),(new Category(2))));
				productRepo.save(new Product("S002", "Nacelles", 100,new Date(),(new Category(2))));
				productRepo.save(new Product("S003", "Port-bébé", 100,new Date(),(new Category(2))));
				productRepo.save(new Product("S004", "Sac à langer", 100,new Date(),(new Category(2))));
				productRepo.save(new Product("S005", "Habillages pluie", 100,new Date(),(new Category(2))));
				
				
				productRepo.save(new Product("R001", "Biberons", 100,(new Category("Repas"))));
				productRepo.save(new Product("R002", "Accessoires biberons", 100,(new Category("Repas"))));
				productRepo.save(new Product("R003", "Sucettes et anneaux de dentitions", 100,(new Category("Repas"))));
				productRepo.save(new Product("R004", "Chaises hautes", 100,(new Category("Repas"))));
				productRepo.save(new Product("R005", "Stérélisateurs", 100,(new Category("Repas"))));
				productRepo.save(new Product("R006", "Bavoirs", 100,(new Category("Repas"))));
				productRepo.save(new Product("R007", "Chauffe-Biberons", 100,(new Category("Repas"))));
				productRepo.save(new Product("R008", "Stérélisateurs", 100,(new Category("Repas"))));
				productRepo.save(new Product("R009", "Tire-lait", 100,(new Category("Repas"))));
				productRepo.save(new Product("R0010", "Cuisseurs", 100,(new Category("Repas"))));
				
				productRepo.save(new Product("E001", "Tapis d'éveil", 100,(new Category("Eveil"))));
				productRepo.save(new Product("E002", "Transat", 100,(new Category("Eveil"))));
				productRepo.save(new Product("E003", "Panda hochet", 100,(new Category("Eveil"))));
				productRepo.save(new Product("E004", "Doudou", 100,(new Category("Eveil"))));
				productRepo.save(new Product("E005", "Sophie la girafe", 100,(new Category("Eveil"))));
				*/
				
	}

}
