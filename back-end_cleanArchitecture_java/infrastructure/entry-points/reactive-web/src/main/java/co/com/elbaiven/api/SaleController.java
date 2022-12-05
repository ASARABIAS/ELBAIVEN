package co.com.elbaiven.api;

import co.com.elbaiven.model.product.Product;
import co.com.elbaiven.model.sale.Sale;
import co.com.elbaiven.usecase.sale.SaleUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/sale", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class SaleController {
    private final SaleUseCase saleUseCase;

    @GetMapping
    public Flux<Sale> getAll() {
        return  saleUseCase.getAll();
    }
    @GetMapping("{id}")
    public Mono<Sale> getId(@PathVariable("id") Long id) {
        return  saleUseCase.read(id);
    }

    @PostMapping("/create")
    public Mono<Sale> create(@RequestBody Sale sale) {
        return  saleUseCase.create(sale);
    }

    @PutMapping("{id}/edit")
    public Mono<Sale> update(@PathVariable("id") Long id, @RequestBody Sale sale) {
        return  saleUseCase.update(id,sale);
    }

    @DeleteMapping("delete/{id}")
    public Mono<Void> delete(@PathVariable("id") Long id) {
        return  saleUseCase.delete(id);
    }

}
