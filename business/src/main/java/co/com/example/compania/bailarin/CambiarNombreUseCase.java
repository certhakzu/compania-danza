package co.com.example.compania.bailarin;

import co.com.example.compania.bailarin.commands.CambiarNombreCommand;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CambiarNombreUseCase extends UseCase<RequestCommand<CambiarNombreCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CambiarNombreCommand> cambiarNombreCommandRequestCommand) {
        var command = cambiarNombreCommandRequestCommand.getCommand();
        var bailarin = Bailarin.from(
                command.getBailarinId(),
                repository().getEventsBy(command.getBailarinId().value())
        );

        bailarin.cambiarNombre(command.getNombre());

        emit().onResponse(new ResponseEvents(bailarin.getUncommittedChanges()));
    }
}
