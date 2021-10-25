package Sofka.LibraryReactive.UseCase;

import Sofka.LibraryReactive.collections.Resource;
import Sofka.LibraryReactive.model.AvalibleResourceDto;
import Sofka.LibraryReactive.model.ResourceDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperResource {

    public Function<ResourceDTO, AvalibleResourceDto> getResourceAvalible(){

        return resource -> {
            AvalibleResourceDto avalibleResourceDto= new AvalibleResourceDto();

            System.out.println(resource.getStock());

            String message = resource.getStock() == 0 ? "Resource not available": "Resource available";
            avalibleResourceDto.setTitle(resource.getTitle());
            avalibleResourceDto.setDate(resource.getDate());
            avalibleResourceDto.setMessage(message);
            return  avalibleResourceDto;
        };

    }





}
