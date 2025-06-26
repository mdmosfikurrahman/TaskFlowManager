package org.epde.tfm.common.exception;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import io.micrometer.common.lang.NonNull;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

@Component
public class GraphQLExceptionHandler extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError(@NonNull Throwable ex, @NonNull DataFetchingEnvironment env) {
        if (ex instanceof NotFoundException notFoundException) {
            return GraphqlErrorBuilder.newError(env)
                    .message(notFoundException.getMessage())
                    .errorType(graphql.ErrorType.DataFetchingException)
                    .build();
        }

        return GraphqlErrorBuilder.newError(env)
                .message("Unexpected error: " + ex.getMessage())
                .errorType(graphql.ErrorType.DataFetchingException)
                .build();
    }
}
