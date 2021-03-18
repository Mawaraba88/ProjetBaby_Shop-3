package projet.babyShop3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projet.babyShop3.entity.OrderDetail;



public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

}
