package co.com.elbaiven.usecase.saledetail;

import co.com.elbaiven.model.saledetail.SaleDetail;
import co.com.elbaiven.model.saledetail.gateways.SaleDetailRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class SaleDetailUseCase {
    private final SaleDetailRepository saleDetailRepository;

    public Mono<SaleDetail> create(SaleDetail saleDetail){
        return saleDetailRepository.create(saleDetail);
    }

    public Mono<SaleDetail> read(Long id){
        return saleDetailRepository.read(id);
    }

    public Mono<SaleDetail> update(Long id,SaleDetail saleDetail){
        return saleDetailRepository.update(id,saleDetail);
    }

    public Mono<Void> delete(Long id){
        return saleDetailRepository.delete(id);
    }

    public Flux<SaleDetail> getAll(){
        return saleDetailRepository.getAll();
    }

}
