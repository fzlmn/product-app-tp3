package mvc.webmvcproducts;

import mvc.webmvcproducts.entities.Product;
import mvc.webmvcproducts.repositories.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebMvcProductsApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebMvcProductsApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepo productRepo) {
        return args -> {
            Product product = Product.builder()
                    .name("Computer").price(4500).quantity(11)
                    .build();
            productRepo.save(product);
            productRepo.save(Product.builder()
                    .name("Printer")
                    .price(1000)
                    .quantity(35)
                    .build());
            productRepo.save(Product.builder()
                    .name("Smart Phone")
                    .price(8000)
                    .quantity(23)
                    .build());

            productRepo.findAll().forEach(p->System.out.println(p.toString()));
        };
    }

}
