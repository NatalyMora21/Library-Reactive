package Sofka.LibraryReactive.UseCase.CrudResource;


import Sofka.LibraryReactive.model.ResourceDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface SaveResource {
    public Mono<String> apply(ResourceDTO resourceDTO);
}
