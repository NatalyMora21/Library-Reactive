package Sofka.LibraryReactive.Repositories;

import Sofka.LibraryReactive.collections.Resource;
import Sofka.LibraryReactive.collections.values.Thematic;
import Sofka.LibraryReactive.collections.values.Type;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ResourceRespository extends ReactiveCrudRepository<Resource,String> {

    Flux<Resource> findAllByType(Type type);
    Flux<Resource> findByThematic(Thematic thematic);

}
