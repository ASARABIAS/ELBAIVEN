package co.com.elbaiven.usecase.product;

import co.com.elbaiven.model.product.Product;
import co.com.elbaiven.model.product.gateways.ProductRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ProductUseCase {
    private  final ProductRepository productRepository;

    public Mono<Product> create(Product product){
        return productRepository.create(product);
    }

    public Mono<Product> read(Long id){
        return productRepository.read(id);
    }

    public Mono<Product> update(Long id,Product product){
        return productRepository.update(id,product);
    }

    public Mono<Void> delete(Long id){
        return productRepository.delete(id);
    }

    public Flux<Product> getAll(){
        return productRepository.getAll();
    }
}
