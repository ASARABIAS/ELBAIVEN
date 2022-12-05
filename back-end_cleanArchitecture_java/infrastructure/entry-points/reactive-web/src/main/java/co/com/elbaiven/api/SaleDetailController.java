package co.com.elbaiven.api;

import co.com.elbaiven.model.sale.Sale;
import co.com.elbaiven.model.saledetail.SaleDetail;
import co.com.elbaiven.usecase.sale.SaleUseCase;
import co.com.elbaiven.usecase.saledetail.SaleDetailUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/saledetail", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class SaleDetailController {
    private final SaleDetailUseCase saleDetailUseCase;

    @GetMapping
    public Flux<SaleDetail> getAll() {
        return  saleDetailUseCase.getAll();
    }
    @GetMapping("{id}")
    public Mono<SaleDetail> getId(@PathVariable("id") Long id) {
        return  saleDetailUseCase.read(id);
    }
    @PostMapping("/create")
    public Mono<SaleDetail> create(@RequestBody SaleDetail saleDetail) {
        return  saleDetailUseCase.create(saleDetail);
    }
    @PutMapping("{id}/edit")
    public Mono<SaleDetail> update(@PathVariable("id") Long id, @RequestBody SaleDetail saleDetail) {
        return  saleDetailUseCase.update(id,saleDetail);
    }

    @DeleteMapping("delete/{id}")
    public Mono<Void> delete(@PathVariable("id") Long id) {
        return  saleDetailUseCase.delete(id);
    }
}
