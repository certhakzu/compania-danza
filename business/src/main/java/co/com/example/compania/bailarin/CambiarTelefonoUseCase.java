package co.com.example.compania.bailarin;

import co.com.example.compania.bailarin.commands.CambiarTelefonoCommand;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CambiarTelefonoUseCase extends UseCase<RequestCommand<CambiarTelefonoCommand>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<CambiarTelefonoCommand> cambiarTelefonoCommandRequestCommand) {
        var command = cambiarTelefonoCommandRequestCommand.getCommand();
        var bailarin = Bailarin.from(
                command.getBailarinId(),
                repository().getEventsBy(command.getBailarinId().value())
        );

        bailarin.cambiarTelefono(command.getTelefono());

        emit().onResponse(new ResponseEvents(bailarin.getUncommittedChanges()));
    }
}
