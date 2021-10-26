package Sofka.LibraryReactive.UseCase.CrudResource;

import Sofka.LibraryReactive.Repositories.ResourceRespository;
import Sofka.LibraryReactive.UseCase.MapperUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class DeleteResourceUseCase {
    private final ResourceRespository resourceRespository;
    private final MapperUtils mapperUtils;

    public DeleteResourceUseCase(ResourceRespository resourceRespository, MapperUtils mapperUtils) {
        this.resourceRespository = resourceRespository;
        this.mapperUtils = mapperUtils;
    }

    public Mono<Void> deleteById(String id) {
        return resourceRespository.deleteById(id);
    }
}
