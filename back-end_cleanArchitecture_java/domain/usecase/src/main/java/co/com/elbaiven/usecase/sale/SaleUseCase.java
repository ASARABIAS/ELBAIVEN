package co.com.elbaiven.usecase.sale;


import co.com.elbaiven.model.sale.Sale;
import co.com.elbaiven.model.sale.gateways.SaleRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class SaleUseCase {
    private final SaleRepository saleRepository;

    public Mono<Sale> create(Sale sale){
        return saleRepository.create(sale);
    }

    public Mono<Sale> read(Long id){
        return saleRepository.read(id);
    }

    public Mono<Sale> update(Long id,Sale sale){
        return saleRepository.update(id,sale);
    }

    public Mono<Void> delete(Long id){
        return saleRepository.delete(id);
    }

    public Flux<Sale> getAll(){
        return saleRepository.getAll();
    }
}
