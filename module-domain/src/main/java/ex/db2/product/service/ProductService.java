package ex.db2.product.service;

import ex.db2.product.domain.Product;
import ex.db2.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(transactionManager = "db2TransactionManager")
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Long register(Product product) {
        return productRepository.save(product).getId();
    }

    public Product getById(Long id) {
        return productRepository.findOne(id);
    }
}
