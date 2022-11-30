package co.com.elbaiven.sale.service;

import co.com.elbaiven.model.person.Person;
import co.com.elbaiven.model.person.gateways.PersonRepository;
import co.com.elbaiven.model.sale.Sale;
import co.com.elbaiven.model.sale.gateways.SaleRepository;
import co.com.elbaiven.sale.model.SaleModel;
import co.com.elbaiven.sale.repository.SaleReactiveRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class SaleAdapterImpl implements SaleRepository {
    private SaleReactiveRepository saleReactiveRepository;

    public Mono<Sale> create(Sale sale) {
        return !notNullFields(sale) ?
                Mono.error(new Exception("Los campos no comple con los valores aceptados")):
                saleReactiveRepository.save(toSaleModel(sale))
                .map((e) -> toSale(e));
    }

    public Mono<Sale> read(Long id) {
        return saleReactiveRepository.findById(id)
                .map((e) ->toSale(e));
    }

    public Mono<Sale> update(Long id, Sale sale) {
        return (id > 0 && !notNullFields(sale)) ?
                Mono.error(new Exception("Los campos no comple con los valores aceptados")):
                saleReactiveRepository.save(toSaleModel(sale))
                        .map((e) ->toSale(e));
    }

    public Mono<Void> delete(Long id) {
        return id < 0 ? Mono.error(new Exception("El campo Id no comple con los valores aceptados")) :
                saleReactiveRepository.deleteById(id);
    }

    public Flux<Sale> getAll() {
        return saleReactiveRepository.findAll()
                .map((e) ->toSale(e));
    }

    public static SaleModel toSaleModel(Sale sale) {
        return new SaleModel(
                sale.getId(),
                sale.getIdUser(),
                sale.getDate(),
                sale.getTotal()
        );
    }

    public static Sale toSale(SaleModel saleModel) {
        return new Sale(
                saleModel.getId(),
                saleModel.getIdUser(),
                saleModel.getDate(),
                saleModel.getTotal()
        );
    }

    public static boolean notNullFields(Sale sale) {
        return (sale.getIdUser()> 0  && sale.getDate() != null && sale.getTotal() > 0 );
    }
}
