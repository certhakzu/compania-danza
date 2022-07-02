package co.com.example.compania.clase;


import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.example.compania.clase.commands.ActualizarNombreCommand;

public class ActualizarNombreUseCase extends UseCase<RequestCommand<ActualizarNombreCommand>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreCommand> actualizarNombreCommandRequestCommand) {
        var command = actualizarNombreCommandRequestCommand.getCommand();
        var clase = Clase.from(
                command.getClaseId(),
                repository().getEventsBy(command.getClaseId().value())
        );

        clase.actualizarNombre(command.getNombre());

        emit().onResponse(new ResponseEvents(clase.getUncommittedChanges()));
    }
}
