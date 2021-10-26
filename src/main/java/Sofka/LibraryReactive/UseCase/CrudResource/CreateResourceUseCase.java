package Sofka.LibraryReactive.UseCase.CrudResource;

import Sofka.LibraryReactive.Repositories.ResourceRespository;
import Sofka.LibraryReactive.UseCase.MapperResource;
import Sofka.LibraryReactive.UseCase.MapperUtils;
import Sofka.LibraryReactive.collections.Resource;
import Sofka.LibraryReactive.model.ResourceDTO;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated


public class CreateResourceUseCase implements SaveResource{

    private final ResourceRespository resourceRespository;
    private final MapperUtils mapperUtils;

    public CreateResourceUseCase(ResourceRespository resourceRespository, MapperUtils mapperUtils) {
        this.resourceRespository = resourceRespository;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Mono<String> apply(ResourceDTO resourceDTO) {
        return resourceRespository.save(mapperUtils.mapperToResource(null).apply(resourceDTO)).map(Resource::getId);
    }




}
