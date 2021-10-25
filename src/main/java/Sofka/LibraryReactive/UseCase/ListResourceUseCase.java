package Sofka.LibraryReactive.UseCase;

import Sofka.LibraryReactive.Repositories.ResourceRespository;
import Sofka.LibraryReactive.collections.Resource;
import Sofka.LibraryReactive.model.ResourceDTO;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@Validated
public class ListResourceUseCase implements Supplier<Flux<ResourceDTO>> {

    private final ResourceRespository resourceRespository;
    private final MapperUtils mapperUtils;

    public ListResourceUseCase(ResourceRespository resourceRespository, MapperUtils mapperUtils) {
        this.resourceRespository = resourceRespository;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Flux<ResourceDTO> get() {
        return resourceRespository.findAll().map(mapperUtils.mapEntityToResource());
    }
}
