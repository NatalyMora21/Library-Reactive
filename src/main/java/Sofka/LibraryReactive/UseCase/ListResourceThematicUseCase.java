package Sofka.LibraryReactive.UseCase;

import Sofka.LibraryReactive.Repositories.ResourceRespository;
import Sofka.LibraryReactive.collections.values.Thematic;
import Sofka.LibraryReactive.collections.values.Type;
import Sofka.LibraryReactive.model.ResourceDTO;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

@Service
@Validated

public class ListResourceThematicUseCase {


    private final ResourceRespository resourceRespository;
    private final MapperUtils mapperUtils;

    public ListResourceThematicUseCase(ResourceRespository resourceRespository, MapperUtils mapperUtils) {
        this.resourceRespository = resourceRespository;
        this.mapperUtils = mapperUtils;
    }

    public Flux<ResourceDTO> getResourcesByThematic(String thematic) {
        return resourceRespository.findByThematic(Thematic.valueOf(thematic)).map(mapperUtils.mapEntityToResource());
    }
}
