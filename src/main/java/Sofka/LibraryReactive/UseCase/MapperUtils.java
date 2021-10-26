package Sofka.LibraryReactive.UseCase;

import Sofka.LibraryReactive.collections.Resource;
import Sofka.LibraryReactive.model.ResourceDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperUtils {

    public Function<ResourceDTO, Resource> mapperToResource(String id) {

        return updateResource -> {
            var resource = new Resource();
            resource.setId(id);
            resource.setTitle(updateResource.getTitle());
            resource.setType(updateResource.getType());
            resource.setThematic(updateResource.getThematic());
            resource.setStock(updateResource.getStock());
            resource.setLending(0);
            resource.setDate(updateResource.getDate());
            resource.setState(false);

            return resource;
        };
    }

    public Function<Resource, ResourceDTO> mapEntityToResource () {
        return entity -> new ResourceDTO(
                entity.getId(),
                entity.getTitle(),
                entity.getType(),
                entity.getThematic(),
                entity.getStock(),
                entity.getLending(),
                entity.getDate(),
                entity.getState()
        );
    }




}
