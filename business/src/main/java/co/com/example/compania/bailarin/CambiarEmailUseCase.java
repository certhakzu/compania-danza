package co.com.example.compania.bailarin;


import co.com.example.compania.bailarin.commands.CambiarEmailCommand;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CambiarEmailUseCase extends UseCase<RequestCommand<CambiarEmailCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CambiarEmailCommand> cambiarEmailCommandRequestCommand) {
        var command = cambiarEmailCommandRequestCommand.getCommand();
        var bailarin = Bailarin.from(
                command.getBailarinId(),
                repository().getEventsBy(command.getBailarinId().value())
        );

        bailarin.cambiarEmail(command.getEmail());

        emit().onResponse(new ResponseEvents(bailarin.getUncommittedChanges()));
    }
}
