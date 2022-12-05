package co.com.elbaiven.product.service;

import co.com.elbaiven.model.person.Person;
import co.com.elbaiven.model.person.gateways.PersonRepository;
import co.com.elbaiven.model.product.Product;
import co.com.elbaiven.model.product.gateways.ProductRepository;
import co.com.elbaiven.product.model.ProductModel;
import co.com.elbaiven.product.repository.ProductReactiveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductAdapterImpl implements ProductRepository {
    private final ProductReactiveRepository productReactiveRepository;

    public Mono<Product> create(Product product) {
        return !notNullFields(product) ?
                Mono.error(new Exception("Los campos no comple con los valores aceptados")):
                productReactiveRepository.save(toProductModel(product))
                .map((e) -> toProduct(e));
    }

    public Mono<Product> read(Long id) {
        return productReactiveRepository.findById(id)
                .map((e) ->toProduct(e));
    }

    public Mono<Product> update(Long id, Product product) {
        return (id > 0 && !notNullFields(product)) ?
                Mono.error(new Exception("Los campos no comple con los valores aceptados")):
                productReactiveRepository.save(toProductModel(product))
                        .map((e) ->toProduct(e));
    }

    public Mono<Void> delete(Long id) {
        return id < 0 ? Mono.error(new Exception("El campo Id no comple con los valores aceptados")) :
                productReactiveRepository.deleteById(id);
    }

    public Flux<Product> getAll() {
        return productReactiveRepository.findAll()
                .map((e) ->toProduct(e));
    }

    public static ProductModel toProductModel(Product Product) {
        return new ProductModel(
                Product.getId(),
                Product.getIdType(),
                Product.getName(),
                Product.getQuantity(),
                Product.getDescription(),
                Product.getPrice(),
                Product.getDiscount(),
                Product.getImage()
        );
    }

    public static Product toProduct(ProductModel productModel) {
        return new Product(
                productModel.getId(),
                productModel.getIdType(),
                productModel.getName(),
                productModel.getQuantity(),
                productModel.getDescription(),
                productModel.getPrice(),
                productModel.getDiscount(),
                productModel.getImage()
        );
    }

    public static boolean notNullFields(Product product) {
        return (product.getIdType()> 0  && product.getName().length() > 0 && product.getQuantity()> 0 && product.getDescription().length()> 0 && product.getPrice() > 0 && product.getDiscount() > 0 && product.getImage().length() > 0);
    }
}
