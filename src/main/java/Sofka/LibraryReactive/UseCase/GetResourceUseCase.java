package Sofka.LibraryReactive.UseCase;

import Sofka.LibraryReactive.Repositories.ResourceRespository;
import Sofka.LibraryReactive.model.AvalibleResourceDto;
import Sofka.LibraryReactive.model.ResourceDTO;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Function;

@Service
@Validated

public class GetResourceUseCase implements Function<String, Mono<AvalibleResourceDto>> {

    private final ResourceRespository resourceRespository;
    private final MapperResource mapperResource;
    private final MapperUtils mapperUtils;


    public GetResourceUseCase(ResourceRespository resourceRespository, MapperResource mapperResource ,MapperUtils mapperUtils) {
        this.resourceRespository = resourceRespository;
        this.mapperResource = mapperResource;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Mono<AvalibleResourceDto> apply(String id) {
        Objects.requireNonNull(id, "Id is required");
        var resource = resourceRespository.findById(id).map(mapperUtils.mapEntityToResource());
        return resource.map(mapperResource.getResourceAvalible());
    }



}
