package co.com.elbaiven.model.sale.gateways;


import co.com.elbaiven.model.sale.Sale;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SaleRepository {
    Mono<Void> create(Sale sale);
    Mono<Sale> read(Long id);
    Mono<Void> update(Long id,Sale sale);
    Mono<Void> delete(Long id);
    Flux<Sale> getAll();
}
