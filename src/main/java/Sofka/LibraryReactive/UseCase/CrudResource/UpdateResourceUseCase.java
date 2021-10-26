package Sofka.LibraryReactive.UseCase.CrudResource;

import Sofka.LibraryReactive.Repositories.ResourceRespository;
import Sofka.LibraryReactive.UseCase.MapperUtils;
import Sofka.LibraryReactive.collections.Resource;
import Sofka.LibraryReactive.model.ResourceDTO;
import reactor.core.publisher.Mono;

public class UpdateResourceUseCase {

    private final ResourceRespository resourceRespository;
    private final MapperUtils mapperUtils;

    public UpdateResourceUseCase(ResourceRespository resourceRespository, MapperUtils mapperUtils) {
        this.resourceRespository = resourceRespository;
        this.mapperUtils = mapperUtils;
    }

    public Mono<ResourceDTO> apply(ResourceDTO resourceDTO) {
        return resourceRespository.save(mapperUtils.mapperToResource(resourceDTO.getId()).apply(resourceDTO))
                .map(mapperUtils.mapEntityToResource());
    }


}
