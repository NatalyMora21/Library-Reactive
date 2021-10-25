package Sofka.LibraryReactive.Repositories;

import Sofka.LibraryReactive.collections.Resource;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ResourceRespository extends ReactiveCrudRepository<Resource,String> {


}
