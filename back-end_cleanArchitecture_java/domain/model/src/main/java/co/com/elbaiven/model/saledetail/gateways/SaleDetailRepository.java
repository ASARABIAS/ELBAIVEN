package co.com.elbaiven.model.saledetail.gateways;

import co.com.elbaiven.model.saledetail.SaleDetail;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SaleDetailRepository {
    Mono<SaleDetail> create(SaleDetail saleDetail);
    Mono<SaleDetail> read(Long id);
    Mono<SaleDetail> update(Long id,SaleDetail saleDetail);
    Mono<Void> delete(Long id);
    Flux<SaleDetail> getAll();
}
