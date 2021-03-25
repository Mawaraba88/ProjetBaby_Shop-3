/*
 * package projet.babyShop3.service;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.data.domain.Page; import
 * org.springframework.data.domain.PageRequest; import
 * org.springframework.data.domain.Pageable; import
 * org.springframework.data.domain.Sort; import
 * org.springframework.stereotype.Service;
 * 
 * import projet.babyShop3.entity.Product; import
 * projet.babyShop3.repository.ProductRepository;
 * 
 * @Service public class ProductService {
 * 
 * @Autowired private ProductRepository productRepo;
 * 
 * 
 * public Page<Product> listAll(int pageNumber, String sortField, String
 * sortDir,String keyword){ Sort sort = Sort.by(sortField);
 * 
 * sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
 * 
 * Pageable pageable = PageRequest.of(pageNumber -1, 6, sort);
 * 
 * if(keyword != null) { return productRepo.findAll(keyword, pageable); } return
 * productRepo.findAll(pageable);
 * 
 * 
 * 
 * 
 * } public void save(Product product) { productRepo.save(product); }
 * 
 * 
 * 
 * 
 * 
 * }
 */