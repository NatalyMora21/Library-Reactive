package Sofka.LibraryReactive.UseCase;

import Sofka.LibraryReactive.Repositories.ResourceRespository;
import Sofka.LibraryReactive.collections.Resource;
import Sofka.LibraryReactive.model.AvalibleResourceDto;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.function.Function;

@Service
@Validated

public class LoadResourceUseCase implements Function<String, Mono<AvalibleResourceDto>> {

    private final ResourceRespository resourceRespository;
    private final MapperResource mapperResource;
    private final MapperUtils mapperUtils;

    public LoadResourceUseCase(ResourceRespository resourceRespository, MapperResource mapperResource, MapperUtils mapperUtils) {
        this.resourceRespository = resourceRespository;
        this.mapperResource = mapperResource;
        this.mapperUtils = mapperUtils;
    }

    public Mono<AvalibleResourceDto> apply (String id) {

        var elementResource = resourceRespository.findById(id);

        var load = elementResource.flatMap( resource -> {

            Boolean state = resource.getStock()>0 ? true : false;
            if(resource.getStock()>0) {
                resource.setStock(resource.getStock()-1);
                resource.setLending(resource.getLending()+1);
                resource.setDate(LocalDate.now());
            }

            resource.setState(state);

            return resourceRespository.save(resource);

        }).map(mapperUtils.mapEntityToResource());

       var message = load.map(mapperResource.getResourceLoad());;
       return message;


    }


}
