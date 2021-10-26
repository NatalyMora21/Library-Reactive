package Sofka.LibraryReactive.routers;

import Sofka.LibraryReactive.UseCase.GetResourceUseCase;
import Sofka.LibraryReactive.UseCase.ListResourceUseCase;
import Sofka.LibraryReactive.UseCase.LoadResourceUseCase;
import Sofka.LibraryReactive.UseCase.ReturnResourceUseCase;
import Sofka.LibraryReactive.model.AvalibleResourceDto;
import Sofka.LibraryReactive.model.ResourceDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class sourceRouter {

    @Bean
    public RouterFunction<ServerResponse> getAll(ListResourceUseCase listResourceUseCase) {
        return route(GET("/resources"),
                request ->
                        ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(BodyInserters.fromPublisher(listResourceUseCase.get(), ResourceDTO.class))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> availabilityGet(GetResourceUseCase getResourceUseCase) {
        return route(
                GET("/resourceInfo/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .body(BodyInserters.fromPublisher(getResourceUseCase.apply(
                                        request.pathVariable("id")),
                                AvalibleResourceDto.class
                        ))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> load(LoadResourceUseCase loadResourceUseCase) {
        return route(
                PUT("/resourceLoad/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .body(BodyInserters.fromPublisher(loadResourceUseCase.apply(
                                        request.pathVariable("id")),
                                AvalibleResourceDto.class
                        ))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> returnResource(ReturnResourceUseCase returnResourceUseCase) {
        return route(
                PUT("/resourceReturn/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .body(BodyInserters.fromPublisher(returnResourceUseCase.apply(
                                        request.pathVariable("id")),
                                AvalibleResourceDto.class
                        ))
        );
    }


}
