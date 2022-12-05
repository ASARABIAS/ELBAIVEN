package co.com.elbaiven.saleDetail.service;

import co.com.elbaiven.model.sale.Sale;
import co.com.elbaiven.model.sale.gateways.SaleRepository;
import co.com.elbaiven.model.saledetail.SaleDetail;
import co.com.elbaiven.model.saledetail.gateways.SaleDetailRepository;
import co.com.elbaiven.saleDetail.model.SaleDetailModel;
import co.com.elbaiven.saleDetail.repository.SaleDetailReactiveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SaleDetailAdapterImpl implements SaleDetailRepository {
    private final SaleDetailReactiveRepository saleDetailReactiveRepository;

    public Mono<SaleDetail> create(SaleDetail saleDetail) {
        return !notNullFields(saleDetail) ?
                Mono.error(new Exception("Los campos no comple con los valores aceptados")):
                saleDetailReactiveRepository.save(toSaleDetailModel(saleDetail))
                .map((e) -> toSaleDetail(e));
    }

    public Mono<SaleDetail> read(Long id) {
        return saleDetailReactiveRepository.findById(id)
                .map((e) ->toSaleDetail(e));
    }

    public Mono<SaleDetail> update(Long id, SaleDetail saleDetail) {
        return (id > 0 && !notNullFields(saleDetail)) ?
                Mono.error(new Exception("Los campos no comple con los valores aceptados")):
                saleDetailReactiveRepository.save(toSaleDetailModel(saleDetail))
                        .map((e) ->toSaleDetail(e));
    }

    public Mono<Void> delete(Long id) {
        return id < 0 ? Mono.error(new Exception("El campo Id no comple con los valores aceptados")) :
                saleDetailReactiveRepository.deleteById(id);
    }

    public Flux<SaleDetail> getAll() {
        return saleDetailReactiveRepository.findAll()
                .map((e) ->toSaleDetail(e));
    }

    public static SaleDetailModel toSaleDetailModel(SaleDetail SaleDetail) {
        return new SaleDetailModel(
                SaleDetail.getId(),
                SaleDetail.getIdSale(),
                SaleDetail.getIdProduct(),
                SaleDetail.getQuantity(),
                SaleDetail.getSubtotal()
        );
    }

    public static SaleDetail toSaleDetail(SaleDetailModel saleDetailModel) {
        return new SaleDetail(
                saleDetailModel.getId(),
                saleDetailModel.getIdSale(),
                saleDetailModel.getIdProduct(),
                saleDetailModel.getQuantity(),
                saleDetailModel.getSubtotal()
        );
    }

    public static boolean notNullFields(SaleDetail saleDetail) {
        return (saleDetail.getIdSale()> 0  && saleDetail.getIdProduct() > 0 && saleDetail.getSubtotal() > 0 && saleDetail.getQuantity() > 0);
    }
}
