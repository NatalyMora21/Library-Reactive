package Sofka.LibraryReactive.UseCase.CrudResource;

import Sofka.LibraryReactive.Repositories.ResourceRespository;
import Sofka.LibraryReactive.UseCase.MapperUtils;
import Sofka.LibraryReactive.model.ResourceDTO;
import reactor.core.publisher.Mono;

public class GetResourceUseCase {

    private final ResourceRespository resourceRespository;
    private final MapperUtils mapperUtils;

    public GetResourceUseCase(ResourceRespository resourceRespository, MapperUtils mapperUtils) {
        this.resourceRespository = resourceRespository;
        this.mapperUtils = mapperUtils;
    }

    public Mono<ResourceDTO> findById(String id) {
        return resourceRespository.findById(id).map(mapperUtils.mapEntityToResource());
    }
}
