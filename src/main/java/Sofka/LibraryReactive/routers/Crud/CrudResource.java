package Sofka.LibraryReactive.routers.Crud;


import Sofka.LibraryReactive.UseCase.CrudResource.CreateResourceUseCase;
import Sofka.LibraryReactive.UseCase.CrudResource.DeleteResourceUseCase;
import Sofka.LibraryReactive.UseCase.CrudResource.GetResourceUseCase;
import Sofka.LibraryReactive.UseCase.CrudResource.UpdateResourceUseCase;
import Sofka.LibraryReactive.model.ResourceDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CrudResource {

    @Bean
    public RouterFunction<ServerResponse> createResource(CreateResourceUseCase createResourceUseCase) {
        return route(POST("/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ResourceDTO.class)
                        .flatMap(resourceDto -> createResourceUseCase.apply(resourceDto)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.TEXT_PLAIN)
                                        .bodyValue(result))
                        )
        );
    }

    @Bean
    public RouterFunction<ServerResponse> deleteResource(DeleteResourceUseCase deleteResourceUseCase) {
        return RouterFunctions.route(DELETE("/delete/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request ->
                        ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(deleteResourceUseCase.deleteById(request.pathVariable("id")), ResourceDTO.class));
    }

    @Bean
    public RouterFunction<ServerResponse> actualizarResource(UpdateResourceUseCase updateResourceUseCase){
        return route(PUT("/update").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ResourceDTO.class)
                        .flatMap(resourceDTO -> updateResourceUseCase.apply(resourceDTO)
                                .flatMap(result->ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result)))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> getResource(GetResourceUseCase getResourceUseCase){
        return route(GET("consultar/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request ->
                        ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(getResourceUseCase.findById(request.pathVariable("id")), ResourceDTO.class));
    }



}
