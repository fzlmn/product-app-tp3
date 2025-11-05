package mvc.webmvcproducts.repositories;

import mvc.webmvcproducts.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
