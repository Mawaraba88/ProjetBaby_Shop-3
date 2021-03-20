package projet.babyShop3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import projet.babyShop3.entity.Account;
import projet.babyShop3.entity.Category;
import projet.babyShop3.repository.AccountRepository;
import projet.babyShop3.repository.CategoryRepository;

@SpringBootApplication
public class ProjetBabyShop3Application /* implements CommandLineRunner */ {

	/*
	 * @Autowired private AccountRepository accountRepo;
	 * 
	 * @Autowired private ProductRepository productRepo;
	 * 
	 * @Autowired private CategoryRepository categoryRepo;
	 */

	public static void main(String[] args) {
		SpringApplication.run(ProjetBabyShop3Application.class, args);
	}

	/*
	 * @Override public void run(String... args) throws Exception {
	 */
	// Insertion des données Account

	/*
	 * accountRepo.save(new Account("Mawaraba",true,
	 * "$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu",
	 * "ROLE_EMPLOYEE")); accountRepo.save(new Account("Fatoumata", true,
	 * "$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu",
	 * "ROLE_EMPLOYEE")); accountRepo.save(new Account("Alexandre",true,
	 * "$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu",
	 * "ROLE_EMPLOYEE")); accountRepo.save(new Account("Admin",true
	 * ,"$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu",
	 * "ROLE_MANAGER"));
	 * 
	 * //Insertion des caétogoires
	 * 
	 * categoryRepo.save(new Category("Chambre","chambre.JPG"));
	 * categoryRepo.save(new Category("Sortie", "sorti.JPG")); categoryRepo.save(new
	 * Category("Repas","repas.JPG")); categoryRepo.save(new Category("Eveil",
	 * "eveil.JPG"));
	 */

	/*
	 * productRepo.save(new Product("C001", "Lit", 100,
	 * "https://zupimages.net/viewer.php?id=21/11/gwjw.jpg", new Date(),(new
	 * Category(1)))); productRepo.save(new Product("C002", "Commodes",
	 * 100,"https://zupimages.net/viewer.php?id=21/11/m16d.jpg",new Date(),(new
	 * Category(1)))); productRepo.save(new Product("C003", "Plan à langer", 100,
	 * "https://zupimages.net/viewer.php?id=21/11/yr3p.jpg", new Date(),(new
	 * Category(1)))); productRepo.save(new Product("C004",
	 * "Linge et parrures de lit", 100,
	 * "https://zupimages.net/viewer.php?id=21/11/68pr.jpg", (new Date()),(new
	 * Category(1)))); productRepo.save(new Product("C005", "Décoration", 100,
	 * "https://zupimages.net/viewer.php?id=21/11/tpyh.jpg",(new Date()), new
	 * Category(1))); productRepo.save(new Product("C006", "Matelas",
	 * 100,"https://zupimages.net/viewer.php?id=21/11/buaf.jpg", new Date(),(new
	 * Category(1)))); productRepo.save(new Product("C007", "Berceaux et couffins",
	 * 100,"https://zupimages.net/viewer.php?id=21/11/bf2b.jpg",new Date(),(new
	 * Category(1)))); productRepo.save(new Product("C008", "Coffre à jouet", 100,
	 * "https://zupimages.net/viewer.php?id=21/11/bf2b.jpg",new Date(),(new
	 * Category(1)))); productRepo.save(new Product("C009", "Securité", 100,
	 * "https://zupimages.net/viewer.php?id=21/11/xlig.jpg", new Date(),(new
	 * Category(1)))); productRepo.save(new Product("C007", "Gigoteuse",
	 * 100,"https://zupimages.net/viewer.php?id=21/11/o455.jpg",new Date(),(new
	 * Category(1))));
	 * 
	 * productRepo.save(new Product("S001", "Poussette", 799.99,
	 * "https://zupimages.net/viewer.php?id=21/11/h3fx.jpg", new Date(),(new
	 * Category(2)))); productRepo.save(new Product("S002", "Nacelles", 150,
	 * "https://zupimages.net/viewer.php?id=21/11/19gi.jpg", new Date(),(new
	 * Category(2)))); productRepo.save(new Product("S003", "Port-bébé", 250,
	 * "https://zupimages.net/viewer.php?id=21/11/yltz.jpg", new Date(),(new
	 * Category(2)))); productRepo.save(new Product("S004", "Sac à langer", 90,
	 * "https://zupimages.net/viewer.php?id=21/11/3zat.jpg", new Date(),(new
	 * Category(2)))); //productRepo.save(new Product("S005", "Habillages pluie",
	 * 30, "", new Date(),(new Category(2))));
	 * 
	 * 
	 * productRepo.save(new Product("R001", "Biberons", 100,
	 * "https://zupimages.net/viewer.php?id=21/11/lmb3.jpg", new Date(),(new
	 * Category(3)))); productRepo.save(new Product("R002", "Accessoires biberons",
	 * 100, "https://zupimages.net/viewer.php?id=21/11/1s8n.jpg",new Date(), (new
	 * Category(3)))); productRepo.save(new Product("R003", "Sucettes", 100,
	 * "https://zupimages.net/viewer.php?id=21/11/isb6.jpg",new Date(), (new
	 * Category(3)))); productRepo.save(new Product("R004", "Chaises hautes", 100,
	 * "https://zupimages.net/viewer.php?id=21/11/kbz0.jpg", new Date(),(new
	 * Category(3)))); productRepo.save(new Product("R005", "Stérélisateurs", 100,
	 * "https://zupimages.net/viewer.php?id=21/11/2ypz.jpg",new Date(), (new
	 * Category(3)))); productRepo.save(new Product("R006", "Bavoirs", 100,
	 * "https://zupimages.net/viewer.php?id=21/11/t6fg.jpg", new Date(),(new
	 * Category(3)))); productRepo.save(new Product("R007", "Chauffe-Biberons", 100,
	 * "https://zupimages.net/viewer.php?id=21/11/b9fo.jpg",new Date(), (new
	 * Category(3)))); productRepo.save(new Product("R008", "Anneaux de dentitions",
	 * 100, "https://zupimages.net/viewer.php?id=21/11/zkge.jpg",new Date(), (new
	 * Category(3)))); productRepo.save(new Product("R009", "Tire-lait", 100,
	 * "https://zupimages.net/viewer.php?id=21/11/cc98.jpg", new Date(),(new
	 * Category(3)))); productRepo.save(new Product("R0010", "Cuisseurs", 100,
	 * "https://zupimages.net/viewer.php?id=21/11/7vvp.jpg", new Date(),(new
	 * Category(3))));
	 * 
	 * 
	 * productRepo.save(new Product("E001", "Tapis d'éveil", 100,
	 * "https://zupimages.net/viewer.php?id=21/11/vo6q.jpg",new Date(), (new
	 * Category(4)))); productRepo.save(new Product("E002", "Transat", 100,
	 * "https://zupimages.net/viewer.php?id=21/11/t3b6.jpg",new Date(), (new
	 * Category(4)))); productRepo.save(new Product("E003", "Panda hochet", 100,
	 * "https://zupimages.net/viewer.php?id=21/11/ieeh.jpg",new Date(), (new
	 * Category(4)))); productRepo.save(new Product("E004", "Doudou", 100,
	 * "https://zupimages.net/viewer.php?id=21/11/vs8m.jpg",new Date(), (new
	 * Category(4)))); productRepo.save(new Product("E005", "Sophie la girafe", 100,
	 * "https://zupimages.net/viewer.php?id=21/11/krar.jpg", new Date(), (new
	 * Category(4))));
	 * 
	 * 
	 */

	/*
	 * List<Category> cat = categoryRepo.findAll();
	 * cat.forEach(p->System.out.println(p.getNameCategory()));
	 */
}

/*
 * Category cat = new Category(); Byte [] photo = new Byte [1024];
 * 
 * categoryRepo.save(new Category("Chambre", photo));
 */

//}
