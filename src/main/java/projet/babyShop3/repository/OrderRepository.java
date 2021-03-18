package projet.babyShop3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projet.babyShop3.entity.Order;



public interface OrderRepository extends JpaRepository<Order, String> {

}
