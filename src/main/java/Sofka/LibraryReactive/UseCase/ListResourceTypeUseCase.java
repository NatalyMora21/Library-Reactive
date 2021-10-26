package Sofka.LibraryReactive.UseCase;

import Sofka.LibraryReactive.Repositories.ResourceRespository;
import Sofka.LibraryReactive.collections.values.Type;
import Sofka.LibraryReactive.model.ResourceDTO;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@Validated

public class ListResourceTypeUseCase {

    private final ResourceRespository resourceRespository;
    private final MapperUtils mapperUtils;

    public ListResourceTypeUseCase(ResourceRespository resourceRespository, MapperUtils mapperUtils) {
        this.resourceRespository = resourceRespository;
        this.mapperUtils = mapperUtils;
    }



    public Flux<ResourceDTO> getResourcesByType(String type) {
        var info = resourceRespository.findAllByType(Type.valueOf(type)).map(mapperUtils.mapEntityToResource());
        return resourceRespository.findAllByType(Type.valueOf(type)).map(mapperUtils.mapEntityToResource());
    }


}
